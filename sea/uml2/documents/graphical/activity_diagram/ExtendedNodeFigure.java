/*
 * @(#)ExtendedNodeFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Mar 5, 2008        descrição
 */
package documents.graphical.activity_diagram;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Enumeration;
import java.util.Vector;

import CH.ifa.draw.framework.Connector;
import CH.ifa.draw.standard.LocatorConnector;
import CH.ifa.draw.standard.RelativeLocator;
import documents.graphical.deployment_diagram.ExtendedTextFigure;

public class ExtendedNodeFigure extends ExtendedTextFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -8876303447379296738L;

    private Vector<LocatorConnector> fConnectors;

    private boolean fConnectorsVisible;

    private int diff = 0;

    private int border = 6;

    /**
     * Constructor.
     */
    public ExtendedNodeFigure()
    {
        super();
    }

    /**
     * Constructor.
     * 
     * @param diff
     */
    public ExtendedNodeFigure(int diff, int border)
    {
        super(diff);
        this.diff = diff;
        this.border = border;
    }

    /**
     * Constructor.
     * 
     * @param diff
     */
    public ExtendedNodeFigure(int border)
    {
        super();
        this.border = border;
    }

    /*
     * (non-Javadoc)
     * 
     * @see CH.ifa.draw.samples.net.NodeFigure#displayBox()
     */
    public Rectangle displayBox()
    {
        Rectangle box = super.displayBox();
        int d = this.border;
        box.grow(d, d);
        return box;
    }

    /**
     * @param g
     */
    public void drawBorder(Graphics g)
    {
        Rectangle r = displayBox();
        g.setColor(getFrameColor());
        g.drawRect(r.x + this.diff, r.y, r.width - 1, r.height - 1);
    }

    /*
     * (non-Javadoc)
     * 
     * @see CH.ifa.draw.samples.net.NodeFigure#draw(java.awt.Graphics)
     */
    public void draw(Graphics g)
    {
        super.draw(g);
        drawBorder(g);
        drawConnectors(g);
    }

    /**
     * @param g
     */
    @SuppressWarnings("unchecked")
    private void drawConnectors(Graphics g)
    {
        if (fConnectorsVisible)
        {
            Enumeration e = connectors().elements();
            while (e.hasMoreElements())
            {
                ((Connector) e.nextElement()).draw(g);
            }
        }
    }

    /**
     * @return
     */
    @SuppressWarnings("unchecked")
    private Vector connectors()
    {
        if (fConnectors == null)
        {
            createConnectors();
        }
        return fConnectors;
    }

    /**
     * 
     */
    @SuppressWarnings("unchecked")
    private void createConnectors()
    {
        fConnectors = new Vector(4);
        fConnectors.addElement(new LocatorConnector(this, RelativeLocator.north()));
        fConnectors.addElement(new LocatorConnector(this, RelativeLocator.south()));
        fConnectors.addElement(new LocatorConnector(this, RelativeLocator.west()));
        fConnectors.addElement(new LocatorConnector(this, RelativeLocator.east()));
    }

}
