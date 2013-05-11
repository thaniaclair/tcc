/*
 * @(#)TerminateFigure.java
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
import CH.ifa.draw.figures.RectangleFigure;
import documents.concepts.state_machine_diagram.Terminate;

public class TerminateFigure extends SpecificationCompositeFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 3670423930806131128L;

    /**
     * Constructor.
     */
    public TerminateFigure()
    {
        super(new EmptyFillRectangle());
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @Override
    public Class<Terminate> relatedConceptClass()
    {
        return Terminate.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(Terminate.class);
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

        RectangleFigure ef = new RectangleFigure()
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
                g.setColor(Color.WHITE);
                g.fillRect(r.x, r.y, 36, 36);
            }

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.figures.EllipseFigure#drawFrame(java.awt.Graphics)
             */
            public void drawFrame(Graphics g)
            {
                Rectangle r = displayBox();
                g.setColor(Color.WHITE);
                g.drawRect(r.x, r.y, 36, 36);
                g.setColor(new Color(0x000000));
                int xRa = r.x + 18;
                int yRa = r.y + 18;
                g.drawLine(xRa, yRa, xRa - 18, yRa - 18);
                g.drawLine(xRa, yRa, xRa + 18, yRa + 18);
                g.drawLine(xRa, yRa, xRa + 18, yRa - 18);
                g.drawLine(xRa, yRa, xRa - 18, yRa + 18);
            }
        };
        ef.setAttribute("FrameColor", new Color(0x000000));

        GraphicalCompositeFigure gf = new GraphicalCompositeFigure(new EmptyFillRectangle());
        gf.getLayouter().setInsets(new Insets(18, 0, 0, 18));
        gf.setAttribute("FillColor", Color.WHITE);
        gf.setAttribute("FrameColor", new Color(0xFFFFFF));
        gf.add(ef);
        add(gf);

        update();
    }
}
