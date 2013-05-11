/*
 * @(#)DashedSeparatorFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Mar 14, 2008        descrição
 */
package documents.graphical.activity_diagram;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

import ocean.jhotdraw.SeparatorFigure;

public class DashedSeparatorFigure extends SeparatorFigure
{

    /**
     * The generated serial version UID.
     */
    private static final long serialVersionUID = -93655391536796624L;

    /**
     * Create a new SeparatorFigure
     */
    public DashedSeparatorFigure()
    {
        super();
    }

    /**
     * Draw the separation line and to hold some space free
     */
    public void draw(Graphics g)
    {
        g.setColor(getFrameColor());
        Graphics2D g2 = (Graphics2D) g;
        float[] x = { 5, 5, 5, 5 };
        g2.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 3, x, 0));
        g2.drawLine(startPoint().x, startPoint().y, endPoint().x - 1, startPoint().y);
        g2.setStroke(new BasicStroke(1));
    }

}
