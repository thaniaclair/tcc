/*
 * @(#)PartFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Feb 16, 2008        descrição
 */
package documents.graphical.composite_structure_diagram;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPopupMenu;

import ocean.accessories.SingleConnector;
import ocean.framework.Concept;
import ocean.jhotdraw.SpecificationCompositeFigure;
import ocean.smalltalk.Constantes;
import ocean.smalltalk.OceanVector;
import CH.ifa.draw.contrib.GraphicalCompositeFigure;
import CH.ifa.draw.figures.RectangleFigure;
import CH.ifa.draw.figures.TextFigure;
import CH.ifa.draw.framework.Figure;
import documents.concepts.composite_structure_diagram.Part;
import documents.util.I18NProperties;

public class PartFigure extends SpecificationCompositeFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 4742541838068670115L;

    /**
     * Default constructor.
     */
    public PartFigure()
    {
        super(new RectangleFigure());
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @SuppressWarnings("unchecked")
    @Override
    public Class<Part> relatedConceptClass()
    {
        return Part.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(Part.class);
        return auxList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#initialize()
     */
    public void initialize()
    {
        removeAll();

        setAttribute(Figure.POPUP_MENU, createPopupMenu());

        super.initialize();
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#redraw()
     */
    public void redraw()
    {

        removeAll();

        Part part = (Part) this.concept();
        if (part.getAttributeName() == null || ("").equals(part.getAttributeName()))
        {
            part.setAttributeName("attribute");
        }

        if (part.getAttributeVisibility() == null || ("").equals(part.getAttributeVisibility()))
        {
            part.setAttributeVisibility("-");
        }

        TextFigure figure = new TextFigure();
        figure.setFont(new Font("Helvetica", Font.BOLD, 14));
        figure.setText(part.getAttributeVisibility() + " " + part.getAttributeName());

        GraphicalCompositeFigure gFigure = new GraphicalCompositeFigure();
        gFigure.setAttribute("FillColor", new Color(0xE8E8E8));
        gFigure.getLayouter().setInsets(new Insets(10, 10, 10, 2));
        gFigure.add(figure);

        add(gFigure);

        update();
    }

    /**
     * Creates a popup menu to edit the class or object name.
     */
    protected JPopupMenu createPopupMenu()
    {
        JPopupMenu popupMenu = new JPopupMenu();

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.name.attribute"))
        {

            /**
             * The serial version UID.
             */
            private static final long serialVersionUID = 676546L;

            /*
             * (non-Javadoc)
             * 
             * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
             */
            public void actionPerformed(ActionEvent event)
            {
                if (SingleConnector.managerView().openDialogInterface(Constantes.NAME_SPEC,
                    ((Part) concept()).getAttributeName()))
                {
                    ((Part) concept()).setAttributeName((SingleConnector.manager())
                        .getCreationName());
                    SingleConnector.manager().updateRedrawCode();
                    concept().redraw();
                }
            }
        });

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.visibility.to.private"))
        {

            /**
             * The serial version UID.
             */
            private static final long serialVersionUID = 676546L;

            /*
             * (non-Javadoc)
             * 
             * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
             */
            public void actionPerformed(ActionEvent event)
            {
                ((Part) concept()).setAttributeVisibility("-");
                SingleConnector.manager().updateRedrawCode();
                concept().redraw();
            }
        });

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.visibility.to.package"))
        {

            /**
             * The serial version UID.
             */
            private static final long serialVersionUID = 676546L;

            /*
             * (non-Javadoc)
             * 
             * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
             */
            public void actionPerformed(ActionEvent event)
            {
                ((Part) concept()).setAttributeVisibility("~");
                SingleConnector.manager().updateRedrawCode();
                concept().redraw();
            }
        });

        popupMenu
            .add(new AbstractAction(I18NProperties.getString("change.visibility.to.protected"))
            {

                /**
                 * The serial version UID.
                 */
                private static final long serialVersionUID = 676546L;

                /*
                 * (non-Javadoc)
                 * 
                 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
                 */
                public void actionPerformed(ActionEvent event)
                {
                    ((Part) concept()).setAttributeVisibility("#");
                    SingleConnector.manager().updateRedrawCode();
                    concept().redraw();
                }
            });

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.visibility.to.public"))
        {

            /**
             * The serial version UID.
             */
            private static final long serialVersionUID = 676546L;

            /*
             * (non-Javadoc)
             * 
             * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
             */
            public void actionPerformed(ActionEvent event)
            {
                ((Part) concept()).setAttributeVisibility("+");
                SingleConnector.manager().updateRedrawCode();
                concept().redraw();
            }
        });

        popupMenu.setLightWeightPopupEnabled(true);
        return popupMenu;
    }

}
