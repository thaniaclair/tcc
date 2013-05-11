/*
 * @(#)EntryPointFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Feb 22, 2008        descrição
 */
package documents.graphical.state_machine_diagram;

import java.awt.*;

import ocean.jhotdraw.SpecificationCompositeFigure;
import ocean.smalltalk.OceanVector;
import CH.ifa.draw.contrib.GraphicalCompositeFigure;
import CH.ifa.draw.figures.EllipseFigure;
import CH.ifa.draw.framework.Figure;
import CH.ifa.draw.framework.FigureEnumeration;
import documents.concepts.state_machine_diagram.EntryPoint;

public class EntryPointFigure extends SpecificationCompositeFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -4072795821754306559L;

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
    public EntryPointFigure()
    {
        super(new EmptyFillRectangle());
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @Override
    public Class<EntryPoint> relatedConceptClass()
    {
        return EntryPoint.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(EntryPoint.class);
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
                g.drawOval(r.x, r.y, 18, 18);
            }
        };
        ef.setAttribute("FillColor", new Color(0xE8E8E8));
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
            int xEntry = this.displayBox().x;
            int yEntry = this.displayBox().y;
            int wEntry = this.displayBox().width;
            int hEntry = this.displayBox().height;

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
                    if ((xEntry > (xSub - (wEntry / 2))) && (xEntry < (xSub + wSub - (wEntry / 2)))
                            && (yEntry > (ySub - (hEntry / 2)))
                            && (yEntry < (ySub + hSub - (hEntry / 2))))
                    {
                        submachine = (SubmachineStateFigure) nextFigure;
                        submachine.getEntryPointFigureList().add(this);
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

            // ENTRY POINT
            int entryX = this.displayBox().x;
            int entryY = this.displayBox().y;
            int entryW = this.displayBox().width;
            int entryH = this.displayBox().height;

            int leftBoundary = subX - (entryW / 2);
            int rightBoundary = subX + subW - (entryW / 2);
            int topBoundary = subY - (entryH / 2);
            int bottomBoundary = subY + subH - (entryH / 2);

            int newX = dx;
            int newY = dy;

            // Add restriction inside of the package.
            if (((entryX + dx) < leftBoundary) || ((entryX + dx) > rightBoundary)
                    || ((entryY + dy) < topBoundary) || ((entryY + dy) > bottomBoundary))
            {
                return;
            }

            else if (!((((entryX + dx) > leftBoundary) && ((entryX + dx) < rightBoundary) && (((entryY + dy) == topBoundary) || ((entryY + dy) == bottomBoundary))) || (((entryY + dy) > topBoundary)
                    && ((entryY + dy) < bottomBoundary) && (((entryX + dx) == leftBoundary) || ((entryX + dx) == rightBoundary)))))
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
