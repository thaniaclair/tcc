/*
 * @(#)HorizontalLayouter.java  2.1  2006-07-08
 *
 * Copyright (c) 1996-2006 by the original authors of JHotDraw
 * and all its contributors ("JHotDraw.org")
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * JHotDraw.org ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with
 * JHotDraw.org.
 */

package documents.graphical.activity_diagram;

import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;

import CH.ifa.draw.contrib.Layoutable;
import CH.ifa.draw.contrib.Layouter;
import CH.ifa.draw.contrib.StandardLayouter;
import CH.ifa.draw.framework.Figure;
import CH.ifa.draw.framework.FigureEnumeration;
import CH.ifa.draw.util.StorableInput;
import CH.ifa.draw.util.StorableOutput;

/**
 */
public class HorizontalLayouter extends StandardLayouter
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 6553422453325146485L;

    /**
     * @param newLayoutable
     */
    public HorizontalLayouter(Layoutable newLayoutable)
    {
        setInsets(new Insets(0, 0, 0, 0));
        setLayoutable(newLayoutable);
    }

    /**
     */
    public HorizontalLayouter()
    {
        super();
    }

    /**
     * @param origin start point for the layout
     * @param corner minimum corner point for the layout
     */
    public Rectangle layout(Point origin, Point corner)
    {
        Rectangle r = calculateLayout(origin, corner);

        int maxHeight = getInsets().top;
        int maxWidth = getInsets().left;
        FigureEnumeration enu = getLayoutable().figures();
        while (enu.hasMoreElements())
        {
            Figure currentFigure = enu.nextFigure();

            Point partOrigin = new Point(r.x + maxWidth, r.y + maxHeight);
            Point partCorner = new Point(r.x + maxWidth + currentFigure.displayBox().width, r.y
                    + maxHeight + r.height);
            currentFigure.displayBox(partOrigin, partCorner);

            maxWidth += currentFigure.displayBox().width;
        }

        return new Rectangle(r.x, r.y, r.x + maxWidth + getInsets().right, r.y + r.height);
    }

    /*
     * (non-Javadoc)
     * 
     * @see CH.ifa.draw.contrib.StandardLayouter#calculateLayout(java.awt.Point, java.awt.Point)
     */
    public Rectangle calculateLayout(Point origin, Point corner)
    {

        int maxWidth = 0;
        int maxHeight = Math.abs(corner.y - origin.y);

        FigureEnumeration enu = getLayoutable().figures();
        while (enu.hasMoreElements())
        {
            Figure currentFigure = enu.nextFigure();
            Rectangle r = new Rectangle(currentFigure.displayBox().getBounds().width
                    + getInsets().right, currentFigure.displayBox().getBounds().height
                    + getInsets().bottom);
            maxWidth += r.width;
            maxHeight = r.height; // Math.max(maxHeight, r.height);
        }

        return new Rectangle(origin.x, origin.y, maxWidth, maxHeight);
    }

    /**
     * Reads the contained figures from StorableInput.
     */
    public void read(StorableInput dr) throws IOException
    {
        setLayoutable((Layoutable) dr.readStorable());
    }

    /**
     * Writes the contained figures to the StorableOutput.
     */
    public void write(StorableOutput dw)
    {
        dw.writeStorable(getLayoutable());
    }

}
