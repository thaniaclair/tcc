/*
 * @(#)ExitPointFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Feb 22, 2008        descrição
 */
package documents.graphical.state_machine_diagram;

import java.awt.*;

import ocean.framework.Concept;
import ocean.jhotdraw.SpecificationCompositeFigure;
import ocean.smalltalk.OceanVector;
import CH.ifa.draw.contrib.GraphicalCompositeFigure;
import CH.ifa.draw.figures.EllipseFigure;
import CH.ifa.draw.framework.Figure;
import CH.ifa.draw.framework.FigureEnumeration;
import documents.concepts.state_machine_diagram.ExitPoint;

public class ExitPointFigure extends SpecificationCompositeFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -7921625967358902521L;

    /**
     * An instance of sub machine figure.
     */
    private SubmachineStateFigure submachine;

    /**
     * The drawing.
     */
    private StateMachineDiagramDrawing drawing;

    /**
     * Constructor.
     */
    public ExitPointFigure()
    {
        super(new EmptyFillRectangle());
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @Override
    public Class< ? extends Concept> relatedConceptClass()
    {
        return ExitPoint.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(ExitPoint.class);
        return auxList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#redraw()
     */
    public void redraw()
    {

        removeAll();

        EllipseFigure ef = new EllipseFigure()
        {

            /**
             * The serial version UID.
             */
            private static final long serialVersionUID = -5990021166034781909L;

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.figures.EllipseFigure#drawBackground(java.awt.Graphics)
             */
            public void drawBackground(Graphics g)
            {
                Rectangle r = displayBox();
                g.setColor(new Color(0xE8E8E8));
                g.fillOval(r.x, r.y, 18, 18);
            }

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.figures.EllipseFigure#drawFrame(java.awt.Graphics)
             */
            public void drawFrame(Graphics g)
            {
                Rectangle r = displayBox();
                g.setColor(new Color(0x000000));
                g.drawOval(r.x, r.y, 18, 18);
                int xRa = r.x + 9;
                int yRa = r.y + 9;
                g.drawLine(xRa, yRa, xRa - 6, yRa - 6);
                g.drawLine(xRa, yRa, xRa + 6, yRa + 6);
                g.drawLine(xRa, yRa, xRa + 6, yRa - 6);
                g.drawLine(xRa, yRa, xRa - 6, yRa + 6);
            }
        };
        ef.setAttribute("FrameColor", new Color(0x000000));

        GraphicalCompositeFigure gf = new GraphicalCompositeFigure(new EmptyFillRectangle());
        gf.getLayouter().setInsets(new Insets(10, 0, 0, 10));
        gf.setAttribute("FillColor", Color.WHITE);
        gf.setAttribute("FrameColor", new Color(0xFFFFFF));
        gf.add(ef);
        add(gf);

        update();
    }

    /*
     * (non-Javadoc)
     * 
     * @see CH.ifa.draw.standard.AbstractFigure#moveBy(int, int)
     */
    @Override
    public void moveBy(int dx, int dy)
    {

        // It doesn't belong to a package.
        if ((submachine == null) && (drawing != null))
        {
            int xExit = this.displayBox().x;
            int yExit = this.displayBox().y;
            int wExit = this.displayBox().width;
            int hExit = this.displayBox().height;

            FigureEnumeration enumeration = drawing.figures();
            while (enumeration.hasMoreElements())
            {
                Figure nextFigure = enumeration.nextFigure();
                if (nextFigure instanceof SubmachineStateFigure)
                {
                    Rectangle displayBox = nextFigure.displayBox();
                    int xSub = displayBox.x;
                    int ySub = displayBox.y;
                    int wSub = displayBox.width;
                    int hSub = displayBox.height;

                    // Checks the restrictions.
                    if ((xExit > (xSub - (wExit / 2))) && (xExit < (xSub + wSub - (wExit / 2)))
                            && (yExit > (ySub - (hExit / 2)))
                            && (yExit < (ySub + hSub - (hExit / 2))))
                    {
                        submachine = (SubmachineStateFigure) nextFigure;
                        submachine.getExitPointFigureList().add(this);
                        return;
                    }
                }
            }
        }
        // It belongs to a package.
        else if ((submachine != null) && (drawing != null))
        {

            // SUBMACHINE
            int subX = submachine.getPresentationFigure().displayBox().x;
            int subY = submachine.getPresentationFigure().displayBox().y;
            int subW = submachine.getPresentationFigure().displayBox().width;
            int subH = submachine.getPresentationFigure().displayBox().height;

            // EXIT POINT
            int exitX = this.displayBox().x;
            int exitY = this.displayBox().y;
            int exitW = this.displayBox().width;
            int exitH = this.displayBox().height;

            int leftBoundary = subX - (exitW / 2);
            int rightBoundary = subX + subW - (exitW / 2);
            int topBoundary = subY - (exitH / 2);
            int bottomBoundary = subY + subH - (exitH / 2);

            int newX = dx;
            int newY = dy;

            // Add restriction inside of the package.
            if (((exitX + dx) < leftBoundary) || ((exitX + dx) > rightBoundary)
                    || ((exitY + dy) < topBoundary) || ((exitY + dy) > bottomBoundary))
            {
                return;
            }

            else if (!((((exitX + dx) > leftBoundary) && ((exitX + dx) < rightBoundary) && (((exitY + dy) == topBoundary) || ((exitY + dy) == bottomBoundary))) || (((exitY + dy) > topBoundary)
                    && ((exitY + dy) < bottomBoundary) && (((exitX + dx) == leftBoundary) || ((exitX + dx) == rightBoundary)))))
            {
                return;
            }

            super.moveBy(newX, newY);

        }

        if (submachine == null)
        {
            super.moveBy(dx, dy);
        }

    }

    /**
     * @return the drawing
     */
    public StateMachineDiagramDrawing getDrawing()
    {
        return drawing;
    }

    /**
     * @param drawing the drawing to set
     */
    public void setDrawing(StateMachineDiagramDrawing drawing)
    {
        this.drawing = drawing;
    }
}
