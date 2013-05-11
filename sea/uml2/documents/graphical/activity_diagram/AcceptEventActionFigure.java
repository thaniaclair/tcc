/*
 * @(#)AcceptEventActionFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Mar 4, 2008        descrição
 */
package documents.graphical.activity_diagram;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPopupMenu;

import ocean.accessories.SingleConnector;
import ocean.jhotdraw.SpecificationCompositeFigure;
import ocean.smalltalk.Constantes;
import ocean.smalltalk.OceanVector;
import CH.ifa.draw.contrib.PolygonFigure;
import CH.ifa.draw.figures.RectangleFigure;
import CH.ifa.draw.framework.Figure;
import documents.concepts.activity_diagram.AcceptEventAction;
import documents.graphical.deployment_diagram.ExtendedTextFigure;
import documents.util.I18NProperties;

public class AcceptEventActionFigure extends SpecificationCompositeFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 5075810204811510250L;

    /**
     * Default constructor.
     */
    public AcceptEventActionFigure()
    {
        super();
        this.setPresentationFigure(this.getRectangleFigure());
    }

    /**
     * @return
     */
    protected RectangleFigure getRectangleFigure()
    {
        RectangleFigure r = new RectangleFigure()
        {

            /**
             * The serial version UID.
             */
            private static final long serialVersionUID = 141751299939341453L;

            /**
             * The display box.
             */
            private Rectangle fDisplayBox;

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.figures.RectangleFigure#basicDisplayBox(java.awt.Point,
             *      java.awt.Point)
             */
            public void basicDisplayBox(Point origin, Point corner)
            {
                fDisplayBox = new Rectangle(origin);
                fDisplayBox.add(corner);
            }

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.figures.RectangleFigure#displayBox()
             */
            public Rectangle displayBox()
            {
                return new Rectangle(fDisplayBox.x, fDisplayBox.y, fDisplayBox.width,
                        fDisplayBox.height - 16);
            }

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.figures.RectangleFigure#basicMoveBy(int, int)
             */
            protected void basicMoveBy(int x, int y)
            {
                fDisplayBox.translate(x, y);
            }

        };
        r.setAttribute("FillColor", Color.WHITE);
        r.setAttribute("FrameColor", Color.WHITE);

        return r;
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @Override
    public Class<AcceptEventAction> relatedConceptClass()
    {
        return AcceptEventAction.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(AcceptEventAction.class);
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

        Color grayColor = new Color(0xE8E8E8);

        AcceptEventAction accept = (AcceptEventAction) this.concept();

        if (accept.name() == null || ("").equals(accept.name()))
        {
            accept.name("accept event");
        }

        int x = this.getPresentationFigure().displayBox().x;
        int y = this.getPresentationFigure().displayBox().y;

        ExtendedTextFigure text = new ExtendedTextFigure()
        {

            /**
             * The serial version UID.
             */
            private static final long serialVersionUID = 3586370330445558470L;

            /**
             * The value to help in the text position.
             */
            public static final int VALUE = 40;

            /*
             * (non-Javadoc)
             * 
             * @see documents.graphical.deployment_diagram.ExtendedTextFigure#displayBox()
             */
            public Rectangle displayBox()
            {
                Dimension extent = textExtent();
                return new Rectangle(getFOriginX() + VALUE, getFOriginY() - VALUE, extent.width,
                        extent.height);
            }

            /*
             * (non-Javadoc)
             * 
             * @see documents.graphical.deployment_diagram.ExtendedTextFigure#drawFrame(java.awt.Graphics)
             */
            public void drawFrame(Graphics g)
            {
                g.setFont(getFFont());
                g.setColor((Color) getAttribute("TextColor"));
                FontMetrics metrics = g.getFontMetrics(getFFont());
                g.drawString(getFText(), getFOriginX() + VALUE, getFOriginY() + metrics.getAscent()
                        - VALUE);
            }

        };
        text.setText(accept.name());
        text.setFont(new Font("Helvetica", Font.BOLD, 14));
        text.setAttribute("FillColor", grayColor);
        text.setAttribute("FrameColor", grayColor);

        int w = text.textDisplayBox().width + 10;

        PolygonFigure poly = new PolygonFigure();
        this.initializePolygonPoints(poly, x, y, w);
        poly.setAttribute("FillColor", grayColor);
        poly.setAttribute("FrameColor", Color.BLACK);

        add(poly);
        add(text);

        this.setAttribute("FillColor", Color.WHITE);
        this.setAttribute("FrameColor", Color.WHITE);

        update();

    }

    /**
     * Initializes the polygon points.
     * 
     * @param x
     * @param y
     * @param w
     */
    private void initializePolygonPoints(PolygonFigure poly, int x, int y, int w)
    {
        poly.addPoint(x, y);
        poly.addPoint(x + 40 + w, y);
        poly.addPoint(x + 40 + w, y + 57);
        poly.addPoint(x, y + 57);
        poly.addPoint(x + 30, y + 28);
        poly.addPoint(x, y);
    }

    /**
     * Creates a popup menu to edit the class or object name.
     */
    protected JPopupMenu createPopupMenu()
    {
        JPopupMenu popupMenu = new JPopupMenu();

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.name.accept.event"))
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
                    ((AcceptEventAction) concept()).name().trim()))
                {
                    ((AcceptEventAction) concept()).name((SingleConnector.manager())
                        .getCreationName());
                    SingleConnector.manager().updateRedrawCode();
                    concept().redraw();
                }
            }
        });

        popupMenu.setLightWeightPopupEnabled(true);
        return popupMenu;
    }

}
