package documents.graphical.object_diagram;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.AbstractAction;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import ocean.documents.oo.concepts.AssociacaoBinaria;
import ocean.jhotdraw.SpecificationLineFigure;
import CH.ifa.draw.figures.ArrowTip;
import CH.ifa.draw.framework.Figure;
import CH.ifa.draw.framework.FigureChangeEvent;

/**
 * An AssociationLineConnection represents an association relationship (has-a) between two classes
 * (represented by their ClassFigures). An association can either be bi-directional or
 * uni-directional. An association can be turned into an aggregation which can be regard a special
 * kind of association.
 */
public class AssociationLineConnection extends SpecificationLineFigure
{

    /**
     * PopupMenu for an associations which allows to switch between directed and not directed
     * associations and associations and aggregations
     */
    private transient JPopupMenu myPopupMenu;

    static final long serialVersionUID = 6492295462615980490L;

    /*
     * Create a new un-directed AssociationLineConnection
     */
    public AssociationLineConnection()
    {
        super();

        setStartDecoration(null);
        setEndDecoration(null);

        setAttribute(Figure.POPUP_MENU, createPopupMenu());
    }

    /**
     * Hook method to plug in application behaviour into a template method. This method is called
     * when a connection between two objects has been established.
     */
    protected void handleConnect(Figure start, Figure end)
    {
        super.handleConnect(start, end);
        // ClassDiagramClass startClass = ((ClassFigure) start).getDiagramClass();
        // ClassDiagramClass endClass = ((ClassFigure) end).getDiagramClass();
        // startClass.addAssociation(endClass);
        // endClass.addAssociation(startClass);
    }

    /**
     * Hook method to plug in application behaviour into a template method. This method is called
     * when a connection between two objects has been cancelled.
     */
    protected void handleDisconnect(Figure start, Figure end)
    {
        super.handleDisconnect(start, end);
        if ((start != null) && (end != null))
        {
            // ClassDiagramClass startClass = ((ClassFigure) start)
            // .getDiagramClass();
            // ClassDiagramClass endClass = ((ClassFigure) end).getDiagramClass();
            // startClass.removeAssociation(endClass);
            // endClass.removeAssociation(startClass);
        }
    }

    /**
     * Sets the named attribute to the new value. Intercept to enable popup menus.
     */
    public void setAttribute(String name, Object value)
    {
        if (name.equals(Figure.POPUP_MENU))
        {
            myPopupMenu = (JPopupMenu) value;
        }
        else
        {
            super.setAttribute(name, value);
        }
    }

    /**
     * Return the named attribute or null if a a figure doesn't have an attribute. All figures
     * support the attribute names FillColor and FrameColor
     */
    public Object getAttribute(String name)
    {
        if (name.equals(Figure.POPUP_MENU))
        {
            return myPopupMenu;
        }
        else
        {
            return super.getAttribute(name);
        }
    }

    /**
     * Factory method to create the associated popup menu. It allows switching between associations
     * and aggregation and directed and not-directed associations depending on the current kind of
     * association. For uni-directional associations the reference from the target class to the
     * start class is removed, while for bi-directional associations, this relation is established
     * again.
     * 
     * @return newly created popup menu
     */
    protected JPopupMenu createPopupMenu()
    {
        JPopupMenu popupMenu = new JPopupMenu();
        popupMenu.add(new AbstractAction("aggregation")
        {

            private static final long serialVersionUID = 37489283479L;

            public void actionPerformed(ActionEvent event)
            {
                setAggregation(!isAggregation());
                if (isAggregation())
                {
                    ((JMenuItem) event.getSource()).setText("no aggregation");
                }
                else
                {
                    ((JMenuItem) event.getSource()).setText("aggregation");
                }
            }
        });
        popupMenu.add(new AbstractAction("uni-directional")
        {

            private static final long serialVersionUID = 37489283479432L;

            public void actionPerformed(ActionEvent event)
            {
                setUniDirectional(!isUniDirectional());
                if (isUniDirectional())
                {
                    ((JMenuItem) event.getSource()).setText("bi-directional");
                    // ClassDiagramClass stlineartClass = ((ClassFigure) startFigure())
                    // .getDiagramClass();
                    // ClassDiagramClass endClass = ((ClassFigure) endFigure())
                    // .getDiagramClass();
                    // endClass.addAssociation(startClass);
                }
                else
                {
                    ((JMenuItem) event.getSource()).setText("uni-directional");
                    // ClassDiagramClass startClass = ((ClassFigure) startFigure())
                    // .getDiagramClass();
                    // ClassDiagramClass endClass = ((ClassFigure) endFigure())
                    // .getDiagramClass();
                    // endClass.removeAssociation(startClass);
                }
            }
        });

        popupMenu.setLightWeightPopupEnabled(true);
        return popupMenu;
    }

    /**
     * Turn an association into an aggregation or vice versa. Whether an association is an
     * aggregation is determined by an internal flag that can be set with this method.
     * 
     * @param isAggregation true to turn an association into an aggregation, false for the opposite
     *            effect
     */
    public void setAggregation(boolean isAggregation)
    {
        willChange();
        if (isAggregation)
        {
            // setStartDecoration(new AggregationDecoration());
        }
        else
        {
            setStartDecoration(null);
        }
        change();
        changed();
    }

    /**
     * Test whether an association is an aggregation or not
     * 
     * @return true if the association is an aggregation, false otherwise
     */
    protected boolean isAggregation()
    {
        return getStartDecoration() != null;
    }

    /**
     * Make an association directed or not directed.
     * 
     * @param isDirected true for a directed association, false otherwise
     */
    protected void setUniDirectional(boolean isDirected)
    {
        willChange();
        if (isDirected)
        {
            ArrowTip arrow = new ArrowTip(0.4, 12.0, 0.0);
            arrow.setBorderColor(java.awt.Color.black);
            setEndDecoration(arrow);
        }
        else
        {
            setEndDecoration(null);
        }
        change();
        changed();
    }

    /**
     * Test whether an associations is directed or not
     * 
     * @return true, if the association is directed, false otherwise
     */
    protected boolean isUniDirectional()
    {
        return getEndDecoration() != null;
    }

    /**
     * Notify listeners about a change
     */
    protected void change()
    {
        if (listener() != null)
        {
            listener().figureRequestUpdate(new FigureChangeEvent(this));
        }
    }

    /**
     * Read a serialized AssociationLineConnection from an input stream and activate the popup menu
     * again.
     */
    private void readObject(ObjectInputStream s) throws ClassNotFoundException, IOException
    {
        // call superclass' private readObject() indirectly
        s.defaultReadObject();

        setAttribute(Figure.POPUP_MENU, createPopupMenu());
    }

    /* (non-Javadoc)
     * @see ocean.jhotdraw.SpecificationLineFigure#relatedConceptClass()
     */
    @SuppressWarnings("unchecked")
    @Override
    public Class relatedConceptClass()
    {
        return AssociacaoBinaria.class;
    }
}
