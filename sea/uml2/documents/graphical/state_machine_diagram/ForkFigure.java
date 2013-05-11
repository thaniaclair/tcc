/*
 * @(#)ForkFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Feb 22, 2008        descrição
 */
package documents.graphical.state_machine_diagram;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPopupMenu;

import ocean.accessories.SingleConnector;
import ocean.framework.Concept;
import ocean.jhotdraw.SpecificationCompositeFigure;
import ocean.smalltalk.OceanVector;
import CH.ifa.draw.contrib.GraphicalCompositeFigure;
import CH.ifa.draw.figures.RectangleFigure;
import CH.ifa.draw.framework.Figure;
import documents.concepts.state_machine_diagram.Fork;
import documents.util.I18NProperties;

public class ForkFigure extends SpecificationCompositeFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -3636371601760338925L;

    /**
     * In default way, the join figure is vertical.
     */
    private boolean isVertical = true;

    /**
     * Constructor.
     */
    public ForkFigure()
    {
        super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @Override
    public Class< ? extends Concept> relatedConceptClass()
    {
        return Fork.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(Fork.class);
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

        RectangleFigure ef = new RectangleFigure()
        {

            /**
             * The serial version UID.
             */
            private static final long serialVersionUID = -3170914264688028656L;

            /**
             * The rectangle box.
             */
            private Rectangle fDisplayBox;

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.figures.RectangleFigure#drawBackground(java.awt.Graphics)
             */
            public void drawBackground(Graphics g)
            {
                Rectangle r = displayBox();
                g.setColor(Color.BLACK);
                g.fillRect(r.x, r.y, r.width, r.height);
            }

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.figures.RectangleFigure#drawFrame(java.awt.Graphics)
             */
            public void drawFrame(Graphics g)
            {
                Rectangle r = displayBox();
                g.setColor(Color.BLACK);
                g.drawRect(r.x, r.y, r.width - 1, r.height - 1);
            }

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.figures.RectangleFigure#displayBox()
             */
            public Rectangle displayBox()
            {
                Rectangle rec = null;

                if (ForkFigure.this.isVertical)
                {
                    rec = new Rectangle(fDisplayBox.x, fDisplayBox.y, 8, 75);
                }
                else
                {
                    rec = new Rectangle(fDisplayBox.x, fDisplayBox.y, 75, 8);
                }
                return rec;
            }

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
             * @see CH.ifa.draw.figures.RectangleFigure#basicMoveBy(int, int)
             */
            protected void basicMoveBy(int x, int y)
            {
                fDisplayBox.translate(x, y);
            }

        };

        GraphicalCompositeFigure gf = new GraphicalCompositeFigure();
        gf.getLayouter().setInsets(new Insets(0, 0, 0, 0));
        gf.setAttribute("FillColor", Color.WHITE);
        gf.setAttribute("FrameColor", new Color(0xFFFFFF));
        gf.add(ef);
        add(gf);

        update();
    }

    /**
     * Creates a popup menu to edit the class or object name.
     */
    protected JPopupMenu createPopupMenu()
    {
        JPopupMenu popupMenu = new JPopupMenu();

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.to.vertical"))
        {

            private static final long serialVersionUID = 676546L;

            /*
             * (non-Javadoc)
             * 
             * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
             */
            public void actionPerformed(ActionEvent event)
            {
                ForkFigure.this.isVertical = true;
                SingleConnector.manager().updateRedrawCode();
                concept().redraw();
            }
        });

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.to.horizontal"))
        {

            private static final long serialVersionUID = 676546L;

            /*
             * (non-Javadoc)
             * 
             * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
             */
            public void actionPerformed(ActionEvent event)
            {
                ForkFigure.this.isVertical = false;
                SingleConnector.manager().updateRedrawCode();
                concept().redraw();
            }
        });

        popupMenu.setLightWeightPopupEnabled(true);
        return popupMenu;
    }

}
