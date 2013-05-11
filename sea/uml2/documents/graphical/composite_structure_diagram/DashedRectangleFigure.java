/*
 * @(#)DashedRectangleFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Feb 21, 2008        descrição
 */
package documents.graphical.composite_structure_diagram;

import java.awt.*;

import CH.ifa.draw.figures.RectangleFigure;

public class DashedRectangleFigure extends RectangleFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -70554739690644227L;

    /**
     * Constructor.
     */
    public DashedRectangleFigure()
    {
        this(new Point(0, 0), new Point(0, 0));
    }

    /**
     * Overloaded Constructor.
     * 
     * @param origin
     * @param corner
     */
    public DashedRectangleFigure(Point origin, Point corner)
    {
        basicDisplayBox(origin, corner);
    }

    /*
     * (non-Javadoc)
     * 
     * @see CH.ifa.draw.figures.RectangleFigure#drawBackground(java.awt.Graphics)
     */
    public void drawBackground(Graphics g)
    {
        Rectangle r = displayBox();
        Graphics2D g2 = (Graphics2D) g;
        float[] x = { 5, 5, 5, 5 };
        g2.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 3, x, 0));
        g2.fillRect(r.x, r.y, r.width, r.height);
        g2.setStroke(new BasicStroke(1));
    }

    /*
     * (non-Javadoc)
     * 
     * @see CH.ifa.draw.figures.RectangleFigure#drawFrame(java.awt.Graphics)
     */
    public void drawFrame(Graphics g)
    {
        Rectangle r = displayBox();
        Graphics2D g2 = (Graphics2D) g;
        float[] x = { 5, 5, 5, 5 };
        g2.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 3, x, 0));
        g2.drawRect(r.x, r.y, r.width - 1, r.height - 1);
        g2.setStroke(new BasicStroke(1));
    }

}