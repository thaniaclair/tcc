/*
 * @(#)JunctionFigure.java
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
import documents.concepts.state_machine_diagram.Junction;

public class JunctionFigure extends SpecificationCompositeFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -493885453093051824L;

    /**
     * Constructor.
     */
    public JunctionFigure()
    {
        super(new EmptyFillRectangle());
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @Override
    public Class<Junction> relatedConceptClass()
    {
        return Junction.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(Junction.class);
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
        ef.setAttribute("FillColor", new Color(0x000000));
        ef.setAttribute("FrameColor", new Color(0x000000));

        GraphicalCompositeFigure gf = new GraphicalCompositeFigure(new EmptyFillRectangle());
        gf.getLayouter().setInsets(new Insets(10, 0, 0, 10));
        gf.setAttribute("FillColor", Color.WHITE);
        gf.setAttribute("FrameColor", new Color(0xFFFFFF));
        gf.add(ef);
        add(gf);

        update();
    }

}
