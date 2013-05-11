/*
 * @(#)AcceptTimeEventActionFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Mar 4, 2008        descrição
 */
package documents.graphical.activity_diagram;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.JPopupMenu;

import ocean.accessories.SingleConnector;
import ocean.jhotdraw.SpecificationCompositeFigure;
import ocean.smalltalk.Constantes;
import ocean.smalltalk.OceanVector;
import CH.ifa.draw.contrib.GraphicalCompositeFigure;
import CH.ifa.draw.contrib.PolygonFigure;
import CH.ifa.draw.contrib.TriangleFigure;
import CH.ifa.draw.figures.TextFigure;
import CH.ifa.draw.framework.Figure;
import CH.ifa.draw.standard.BoxHandleKit;
import documents.concepts.activity_diagram.AcceptTimeEventAction;
import documents.util.I18NProperties;

public class AcceptTimeEventActionFigure extends SpecificationCompositeFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 5905629813749147489L;

    /**
     * Default constructor.
     */
    public AcceptTimeEventActionFigure()
    {
        super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @Override
    public Class<AcceptTimeEventAction> relatedConceptClass()
    {
        return AcceptTimeEventAction.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(AcceptTimeEventAction.class);
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

        AcceptTimeEventAction accept = (AcceptTimeEventAction) this.concept();

        if (accept.name() == null || ("").equals(accept.name()))
        {
            accept.name("accept event");
        }

        TextFigure text = new TextFigure();
        text.setText(accept.name());
        text.setFont(new Font("Helvetica", Font.BOLD, 14));
        text.setAttribute("FillColor", Color.WHITE);
        text.setAttribute("FrameColor", Color.WHITE);

        final int w = text.textDisplayBox().width;

        TriangleFigure t1 = new TriangleFigure()
        {

            /**
             * The serial version UID.
             */
            private static final long serialVersionUID = -2101006515661556492L;

            Rectangle fDisplayBox;

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
                int x1 = fDisplayBox.x + (w / 2) - 17;
                return new Rectangle(x1, fDisplayBox.y, 35, 25);
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
        t1.setAttribute("FillColor", new Color(0xE8E8E8));
        t1.setAttribute("FrameColor", Color.BLACK);

        TriangleFigure t2 = new TriangleFigure()
        {

            /**
             * The serial version UID.
             */
            private static final long serialVersionUID = -4941215003356587828L;

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
                int x1 = fDisplayBox.x + (w / 2) - 17;
                return new Rectangle(x1, fDisplayBox.y, 35, 25);
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
        t2.rotate(t1.getRotationAngle() * -1);
        t2.setAttribute("FillColor", new Color(0xE8E8E8));
        t2.setAttribute("FrameColor", Color.BLACK);

        GraphicalCompositeFigure gf = new GraphicalCompositeFigure();
        gf.getLayouter().setInsets(new Insets(0, 0, 5, 0));
        gf.setAttribute("FillColor", Color.WHITE);
        gf.setAttribute("FrameColor", Color.WHITE);
        gf.add(t2);
        gf.add(t1);

        add(gf);

        add(text);

        this.setAttribute("FillColor", Color.WHITE);
        this.setAttribute("FrameColor", Color.WHITE);

        update();
    }

    /**
     * Creates a popup menu to edit the class or object name.
     */
    protected JPopupMenu createPopupMenu()
    {
        JPopupMenu popupMenu = new JPopupMenu();

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.name.accept.time.event"))
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
                    ((AcceptTimeEventAction) concept()).name().trim()))
                {
                    ((AcceptTimeEventAction) concept()).name((SingleConnector.manager())
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
