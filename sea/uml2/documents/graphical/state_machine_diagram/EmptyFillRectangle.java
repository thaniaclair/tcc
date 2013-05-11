/*
 * @(#)EmptyFillRectangle.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Apr 8, 2008        descrição
 */
package documents.graphical.state_machine_diagram;

import java.awt.Graphics;

import CH.ifa.draw.figures.RectangleFigure;

public class EmptyFillRectangle extends RectangleFigure
{

    /**
     * The generated serial version UID.
     */
    private static final long serialVersionUID = 7460260942123340735L;

    /*
     * (non-Javadoc)
     * 
     * @see CH.ifa.draw.figures.RectangleFigure#drawFrame(java.awt.Graphics)
     */
    public void drawFrame(Graphics g)
    {
        // EMPTY.
    }

    /*
     * (non-Javadoc)
     * 
     * @see CH.ifa.draw.figures.RectangleFigure#drawBackground(java.awt.Graphics)
     */
    public void drawBackground(Graphics g)
    {
        // EMPTY.
    }
}
