/*
 * @(#)StateRoundRectangleFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Feb 28, 2008        descrição
 */
package documents.graphical.state_machine_diagram;

import java.awt.Point;
import java.awt.Rectangle;

import CH.ifa.draw.figures.RoundRectangleFigure;

public class StateRoundRectangleFigure extends RoundRectangleFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 9123739823689879972L;

    /**
     * A reference to rectangle box.
     */
    private Rectangle fDisplayBox;

    /*
     * (non-Javadoc)
     * 
     * @see CH.ifa.draw.figures.RoundRectangleFigure#basicDisplayBox(java.awt.Point, java.awt.Point)
     */
    public void basicDisplayBox(Point origin, Point corner)
    {
        fDisplayBox = new Rectangle(origin);
        fDisplayBox.add(corner);
    }

    /*
     * (non-Javadoc)
     * 
     * @see CH.ifa.draw.figures.RoundRectangleFigure#basicMoveBy(int, int)
     */
    protected void basicMoveBy(int x, int y)
    {
        fDisplayBox.translate(x, y);
    }

    /*
     * (non-Javadoc)
     * 
     * @see CH.ifa.draw.figures.RoundRectangleFigure#displayBox()
     */
    public Rectangle displayBox()
    {
        return new Rectangle(fDisplayBox.x, fDisplayBox.y, fDisplayBox.width,
                fDisplayBox.height);
    }

    /**
     * @return the fDisplayBox
     */
    public Rectangle getFDisplayBox()
    {
        return fDisplayBox;
    }

}
