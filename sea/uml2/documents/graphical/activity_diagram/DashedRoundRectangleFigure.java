/*
 * @(#)DashedRoundRectangleFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Mar 5, 2008        descrição
 */
package documents.graphical.activity_diagram;

import java.awt.*;

import documents.graphical.state_machine_diagram.StateRoundRectangleFigure;

public class DashedRoundRectangleFigure extends StateRoundRectangleFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 7081648495339393003L;

    /*
     * (non-Javadoc)
     * 
     * @see CH.ifa.draw.figures.RoundRectangleFigure#drawBackground(java.awt.Graphics)
     */
    public void drawBackground(Graphics g)
    {
        Rectangle r = displayBox();
        Point p = super.getArc();
        Graphics2D g2 = (Graphics2D) g;
        float[] x = { 5, 5, 5, 5 };
        g2.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 3, x, 0));
        g2.fillRoundRect(r.x, r.y, r.width, r.height, p.x, p.y);
        g2.setStroke(new BasicStroke(1));

    }

    /*
     * (non-Javadoc)
     * 
     * @see CH.ifa.draw.figures.RoundRectangleFigure#drawFrame(java.awt.Graphics)
     */
    public void drawFrame(Graphics g)
    {
        Rectangle r = displayBox();
        Point p = super.getArc();
        Graphics2D g2 = (Graphics2D) g;
        float[] x = { 5, 5, 5, 5 };
        g2.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 3, x, 0));
        g2.drawRoundRect(r.x, r.y, r.width - 1, r.height - 1, p.x, p.y);
        g2.setStroke(new BasicStroke(1));
    }

}
