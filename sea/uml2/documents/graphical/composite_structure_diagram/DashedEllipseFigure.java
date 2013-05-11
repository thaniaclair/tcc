/*
 * @(#)ExtendedEllipseFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Feb 19, 2008        descrição
 */
package documents.graphical.composite_structure_diagram;

import java.awt.*;
import java.util.Vector;

import CH.ifa.draw.figures.EllipseFigure;
import CH.ifa.draw.standard.BoxHandleKit;

public class DashedEllipseFigure extends EllipseFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 988818462147667717L;

    /**
     * True if the figure is in a collaboration concept, false otherwise.
     */
    private boolean isCollaboration = false;

    /**
     * The width text.
     */
    private int textWidth = 0;

    /**
     * The total width.
     */
    private int totalWidth = 20;

    /**
     * The total height.
     */
    private int totalHeight = 100;

    /**
     * Height to calculate the location of the separation line.
     */
    private int divisorHeight = 6;

    /**
     * Width to calculate the location of the separation line.
     */
    private int divisorWidth = 7;

    /**
     * The constructor.
     */
    public DashedEllipseFigure()
    {
        super(new Point(0, 0), new Point(0, 0));
        this.isCollaboration = false;
    }

    /**
     * The constructor.
     */
    public DashedEllipseFigure(boolean isCollaboration, int width)
    {
        super(new Point(0, 0), new Point(0, 0));
        this.isCollaboration = isCollaboration;
        this.textWidth = width;
    }

    /**
     * @param origin
     * @param corner
     */
    public DashedEllipseFigure(Point origin, Point corner)
    {
        basicDisplayBox(origin, corner);
    }

    /*
     * (non-Javadoc)
     * 
     * @see CH.ifa.draw.figures.EllipseFigure#drawBackground(java.awt.Graphics)
     */
    public void drawBackground(Graphics g)
    {
        Rectangle r = displayBox();
        Graphics2D g2 = (Graphics2D) g;
        float[] x = { 5, 5, 5, 5 };
        g2.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 3, x, 0));
        g2.fillOval(r.x, r.y, this.textWidth + this.totalWidth, this.totalHeight);
        g2.setStroke(new BasicStroke(1));
    }

    /*
     * (non-Javadoc)
     * 
     * @see CH.ifa.draw.figures.EllipseFigure#drawFrame(java.awt.Graphics)
     */
    public void drawFrame(Graphics g)
    {
        Rectangle r = displayBox();
        Graphics2D g2 = (Graphics2D) g;
        float[] x = { 5, 5, 5, 5 };
        g2.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 3, x, 0));
        g2.drawOval(r.x, r.y, this.textWidth + this.totalWidth, this.totalHeight);
        if (this.isCollaboration)
        {
            int width = this.textWidth + this.totalWidth + 5;
            g2.drawLine(r.x + (width / this.divisorWidth), r.y + (r.height / this.divisorHeight),
                r.x + width - (width / this.divisorWidth), r.y + (r.height / this.divisorHeight));
        }
        g2.setStroke(new BasicStroke(1));
    }

    /*
     * (non-Javadoc)
     * 
     * @see CH.ifa.draw.figures.EllipseFigure#handles()
     */
    @SuppressWarnings("unchecked")
    public Vector handles()
    {
        Vector handles = new Vector();
        BoxHandleKit.addHandles(this, handles);
        return handles;
    }

    /**
     * @return the widthText
     */
    public int getWidthText()
    {
        return textWidth;
    }

    /**
     * @param widthText the widthText to set
     */
    public void setWidthText(int widthText)
    {
        this.textWidth = widthText;
    }

    /**
     * @return the totalWidth
     */
    public int getTotalWidth()
    {
        return totalWidth;
    }

    /**
     * @param totalWidth the totalWidth to set
     */
    public void setTotalWidth(int totalWidth)
    {
        this.totalWidth = totalWidth;
    }

    /**
     * @return the totalHeight
     */
    public int getTotalHeight()
    {
        return totalHeight;
    }

    /**
     * @param totalHeight the totalHeight to set
     */
    public void setTotalHeight(int totalHeight)
    {
        this.totalHeight = totalHeight;
    }

    /**
     * @return the divisorHeight
     */
    public int getDivisorHeight()
    {
        return divisorHeight;
    }

    /**
     * @param divisorHeight the divisorHeight to set
     */
    public void setDivisorHeight(int divisorHeight)
    {
        this.divisorHeight = divisorHeight;
    }

    /**
     * @return the divisorWidth
     */
    public int getDivisorWidth()
    {
        return divisorWidth;
    }

    /**
     * @param divisorWidth the divisorWidth to set
     */
    public void setDivisorWidth(int divisorWidth)
    {
        this.divisorWidth = divisorWidth;
    }

}
