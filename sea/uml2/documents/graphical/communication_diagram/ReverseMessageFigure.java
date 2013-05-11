/*
 * @(#)ReverseMessageFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Feb 9, 2008        descrição
 */
package documents.graphical.communication_diagram;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.JPopupMenu;

import ocean.accessories.SingleConnector;
import ocean.jhotdraw.SpecificationCompositeFigure;
import ocean.smalltalk.Constantes;
import ocean.smalltalk.OceanVector;
import CH.ifa.draw.figures.*;
import CH.ifa.draw.framework.Figure;
import CH.ifa.draw.standard.NullHandle;
import CH.ifa.draw.standard.RelativeLocator;
import documents.concepts.communication_diagram.ReverseMessage;
import documents.util.I18NProperties;

public class ReverseMessageFigure extends SpecificationCompositeFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -7357235896803922915L;

    /**
     * Default constructor.
     */
    public ReverseMessageFigure()
    {
        super(new RectangleFigure());
    }

    /**
     * Overloaded constructor.
     * 
     * @param message
     */
    public ReverseMessageFigure(ReverseMessage message)
    {
        super(message);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @Override
    public Class<ReverseMessage> relatedConceptClass()
    {
        return ReverseMessage.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(ReverseMessage.class);
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
    @SuppressWarnings("deprecation")
    public void redraw()
    {

        removeAll();

        this.getPresentationFigure().setAttribute("FillColor", Color.WHITE);
        this.getPresentationFigure().setAttribute("FrameColor", Color.WHITE);
        int x = this.getPresentationFigure().displayBox().x;
        int y = this.getPresentationFigure().displayBox().y;

        ReverseMessage message = (ReverseMessage) this.concept();
        TextFigure textMessage = this.getMessage(message);
        FontMetrics metrics1 = Toolkit.getDefaultToolkit().getFontMetrics(
            new Font("Helvetica", Font.BOLD, 14));
        int width = metrics1.stringWidth(textMessage.getText());
        add(textMessage);

        if (message.getDegreeArrow() == -45)
        {
            add(this.getPolyLineLess45(x, y, width));
        }
        else if (message.getDegreeArrow() == -90)
        {
            add(this.getPolyLineLess90(x, y, width));
        }
        else if (message.getDegreeArrow() == 45)
        {
            add(this.getPolyLineMore45(x, y, width));
        }
        else if (message.getDegreeArrow() == 0)
        {
            add(this.getPolyLine(x, y, width));
        }

        update();

    }

    /**
     * Gets the text message.
     * 
     * @return The text message.
     */
    private TextFigure getMessage(ReverseMessage message)
    {
        if (message.getMessageName() == null || ("").equals(message.getMessageName()))
        {
            message.setMessageName("message()");
        }

        if (message.getMessageNumber() == null || ("").equals(message.getMessageNumber()))
        {
            message.setMessageNumber("1");
        }

        String messageString = new String(message.getMessageNumber() + " : "
                + message.getMessageName());

        TextFigure text = new TextFigure();
        text.setFont(new Font("Helvetica", Font.BOLD, 14));
        text.setText(messageString);
        text.setAttribute("FillColor", Color.WHITE);
        text.setAttribute("FrameColor", Color.WHITE);

        return text;
    }

    /**
     * Gets the line.
     * 
     * @param x The x origin where the figure was designed.
     * @param y The y origin where the figure was designed.
     * @param width The width of the figure.
     * @return The line figure.
     */
    private PolyLineFigure getPolyLine(int x, int y, int width)
    {
        PolyLineFigure poly = new PolyLineFigure();
        poly.addPoint(x + (width / 2) - 8, y + 40);
        poly.addPoint(x + (width / 2) + 20, y + 40);
        poly.setStartDecoration(this.getArrow());
        return poly;
    }

    /**
     * Gets the line.
     * 
     * @param x The x origin where the figure was designed.
     * @param y The y origin where the figure was designed.
     * @param width The width of the figure.
     * @return The line figure.
     */
    private PolyLineFigure getPolyLineLess45(int x, int y, int width)
    {
        PolyLineFigure poly = new PolyLineFigure();
        poly.addPoint(x + (width / 2) - 8, y + 30);
        poly.addPoint(x + (width / 2) + 20, y + 50);
        poly.setStartDecoration(this.getArrow());
        return poly;
    }

    /**
     * Gets the line.
     * 
     * @param x The x origin where the figure was designed.
     * @param y The y origin where the figure was designed.
     * @param width The width of the figure.
     * @return The line figure.
     */
    private PolyLineFigure getPolyLineLess90(int x, int y, int width)
    {
        PolyLineFigure poly = new PolyLineFigure();
        poly.addPoint(x + (width / 2), y + 60);
        poly.addPoint(x + (width / 2), y + 30);
        poly.setEndDecoration(this.getArrow());
        return poly;
    }

    /**
     * Gets the line.
     * 
     * @param x The x origin where the figure was designed.
     * @param y The y origin where the figure was designed.
     * @param width The width of the figure.
     * @return The line figure.
     */
    private PolyLineFigure getPolyLineMore45(int x, int y, int width)
    {
        PolyLineFigure poly = new PolyLineFigure();
        poly.addPoint(x + (width / 2) - 8, y + 60);
        poly.addPoint(x + (width / 2) + 20, y + 40);
        poly.setStartDecoration(this.getArrow());
        return poly;
    }

    /**
     * Gets the arrow.
     * 
     * @return The arrow.
     */
    public ArrowTip getArrow()
    {
        ArrowTip arrow = new ArrowTip(0.4, 12.0, 12.0);
        arrow.setBorderColor(Color.BLACK);
        arrow.setFillColor(Color.BLACK);
        return arrow;
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#handles()
     */
    @SuppressWarnings("unchecked")
    public Vector handles()
    {
        Vector handles = new Vector();
        handles.addElement(new NullHandle(this, RelativeLocator.northWest()));
        handles.addElement(new NullHandle(this, RelativeLocator.northEast()));
        handles.addElement(new NullHandle(this, RelativeLocator.southWest()));
        handles.addElement(new NullHandle(this, RelativeLocator.southEast()));
        return handles;
    }

    /**
     * Creates a popup menu to edit the class or object name.
     */
    protected JPopupMenu createPopupMenu()
    {
        JPopupMenu popupMenu = new JPopupMenu();

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.name.reverse.message"))
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
                    ((ReverseMessage) concept()).getMessageName()))
                {
                    String newName = (SingleConnector.manager()).getCreationName();
                    ((ReverseMessage) concept()).setMessageName(newName);
                    SingleConnector.manager().updateRedrawCode();
                    concept().redraw();
                }
            }
        });

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.number.reverse.message"))
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
                    ((ReverseMessage) concept()).getMessageNumber()))
                {
                    String newName = (SingleConnector.manager()).getCreationName();
                    ((ReverseMessage) concept()).setMessageNumber(newName);
                    SingleConnector.manager().updateRedrawCode();
                    concept().redraw();
                }
            }
        });

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.degree.reverse.default"))
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
                SingleConnector.manager().updateRedrawCode();
                ((ReverseMessage) concept()).setDegreeArrow(0);
                ((ReverseMessage) concept()).redraw();
            }
        });

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.degree.reverse.less.45"))
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
                SingleConnector.manager().updateRedrawCode();
                ((ReverseMessage) concept()).setDegreeArrow(-45);
                ((ReverseMessage) concept()).redraw();
            }
        });

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.degree.reverse.less.90"))
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
                SingleConnector.manager().updateRedrawCode();
                ((ReverseMessage) concept()).setDegreeArrow(-90);
                ((ReverseMessage) concept()).redraw();
            }
        });
        
        popupMenu.add(new AbstractAction(I18NProperties.getString("change.degree.reverse.more.45"))
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
                SingleConnector.manager().updateRedrawCode();
                ((ReverseMessage) concept()).setDegreeArrow(45);
                ((ReverseMessage) concept()).redraw();
            }
        });

        popupMenu.setLightWeightPopupEnabled(true);
        return popupMenu;
    }

}
