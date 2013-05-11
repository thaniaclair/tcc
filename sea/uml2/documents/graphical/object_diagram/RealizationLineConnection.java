package documents.graphical.object_diagram;

import java.awt.Color;
import java.awt.Graphics;

import CH.ifa.draw.figures.ArrowTip;
import documents.concepts.object_diagram.Realization;

public class RealizationLineConnection extends DependencyLineConnection
{

    /**
     * The serial version UID.
     */
    public static final long serialVersionUID = -2964321053621789632L;

    /**
     * Create a new instance
     */
    public RealizationLineConnection()
    {
        super();

        setStartDecoration(null);
        ArrowTip arrow = new ArrowTip(0.35, 20.0, 20.0);
        arrow.setBorderColor(java.awt.Color.black);
        arrow.setFillColor(Color.white);
        setEndDecoration(arrow);
        setEndDecoration(arrow);
    }

    /**
     * Draw the line which is a dotted line for a dependency connection. Instead of drawing one line
     * from start point to end point, the line is divided into several small lines each 5 pixels
     * long and 5 pixels away from the previous line. Some minor inaccuracy are possible due to
     * rounding errors or incomplete last lines.
     * 
     * @param g graphics context into which the line is drawn
     * @param x1 start x point
     * @param y1 start y point
     * @param x2 end x point
     * @param y2 end y point
     */
    protected void drawLine(Graphics g, int x1, int y1, int x2, int y2)
    {
        int xDistance = x2 - x1;
        int yDistance = y2 - y1;
        double direction = Math.PI / 2 - Math.atan2(xDistance, yDistance);

        double xAngle = Math.cos(direction);
        double yAngle = Math.sin(direction);
        int lineLength = (int) Math.sqrt(xDistance * xDistance + yDistance * yDistance);

        for (int i = 0; i + 5 < lineLength; i = i + 10)
        {
            int p1x = x1 + (int) (i * xAngle);
            int p1y = y1 + (int) (i * yAngle);
            int p2x = x1 + (int) ((i + 5) * xAngle);
            int p2y = y1 + (int) ((i + 5) * yAngle);
            g.drawLine(p1x, p1y, p2x, p2y);
        }
    }

    /* (non-Javadoc)
     * @see documents.graphical.object_diagram.DependencyLineConnection#relatedConceptClass()
     */
    @Override
    public Class<Realization> relatedConceptClass()
    {
        return Realization.class;
    }
}