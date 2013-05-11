/*
 * @(#)CubeFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Feb 20, 2008        descrição
 */
package documents.graphical.deployment_diagram;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import CH.ifa.draw.figures.RectangleFigure;

public class CubeFigure extends RectangleFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -8424263341728825447L;

    /*
     * (non-Javadoc)
     * 
     * @see CH.ifa.draw.figures.RectangleFigure#drawBackground(java.awt.Graphics)
     */
    public void drawBackground(Graphics g)
    {
        // Draw the cube. 
        
        Rectangle r = displayBox();
        g.fillRect(r.x + 1, r.y + 1, r.width - 2, r.height - 2);
        g.setColor(Color.DARK_GRAY);
        g.drawLine(r.x + 7, r.y - 6, r.x + r.width + 5, r.y - 6);
        g.setColor(new Color(0xE8E8E8));
        g.drawLine(r.x + 6, r.y - 5, r.x + r.width + 4, r.y - 5);
        g.drawLine(r.x + 5, r.y - 4, r.x + r.width + 3, r.y - 4);
        g.drawLine(r.x + 4, r.y - 3, r.x + r.width + 2, r.y - 3);
        g.drawLine(r.x + 3, r.y - 2, r.x + r.width + 1, r.y - 2);
        g.drawLine(r.x + 2, r.y - 1, r.x + r.width, r.y - 1);
        g.drawLine(r.x + 1, r.y, r.x + r.width - 1, r.y);
        g.setColor(Color.DARK_GRAY);
        g.drawLine(r.x, r.y + 1, r.x + r.width - 2, r.y + 1);

        g.drawLine(r.x + r.width - 2, r.y + 1, r.x + r.width - 2, r.y + r.height - 1);
        g.setColor(new Color(0xE8E8E8));
        g.drawLine(r.x + r.width - 1, r.y, r.x + r.width - 1, r.y + r.height - 1);
        g.drawLine(r.x + r.width, r.y - 1, r.x + r.width, r.y + r.height - 2);
        g.drawLine(r.x + r.width + 1, r.y - 2, r.x + r.width + 1, r.y + r.height - 3);
        g.drawLine(r.x + r.width + 2, r.y - 3, r.x + r.width + 2, r.y + r.height - 4);
        g.drawLine(r.x + r.width + 3, r.y - 4, r.x + r.width + 3, r.y + r.height - 5);
        g.drawLine(r.x + r.width + 4, r.y - 5, r.x + r.width + 4, r.y + r.height - 6);
        g.setColor(Color.DARK_GRAY);
        g.drawLine(r.x + r.width + 5, r.y - 6, r.x + r.width + 5, r.y + r.height - 7);

        g.setColor(Color.DARK_GRAY);
        g.drawLine(r.x, r.y, r.x + 7, r.y - 6);
        g.drawLine(r.x + r.width - 2, r.y + 1, r.x + r.width + 4, r.y - 5);
        g.drawLine(r.x + r.width - 2, r.y + r.height - 1, r.x + r.width + 4, r.y + r.height - 6);

        g.setColor(new Color(0xE8E8E8));
    }

    /*
     * (non-Javadoc)
     * 
     * @see CH.ifa.draw.figures.RectangleFigure#drawFrame(java.awt.Graphics)
     */
    public void drawFrame(Graphics g)
    {
        displayBox();
        g.setColor(Color.DARK_GRAY);
    }

}
