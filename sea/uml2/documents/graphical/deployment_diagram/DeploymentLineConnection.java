/*
 * @(#)AggregationLineConnection.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Jan 3, 2008        descrição
 */
package documents.graphical.deployment_diagram;

import java.awt.*;

import CH.ifa.draw.figures.ArrowTip;
import documents.concepts.deployment_diagram.Manifestation;
import documents.graphical.object_diagram.DependencyLineConnection;

public class DeploymentLineConnection extends DependencyLineConnection
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -8624011393087214151L;

    /**
     * Create a new instance
     */
    public DeploymentLineConnection()
    {
        super();
        setStartDecoration(null);
        ArrowTip arrow = new ArrowTip(0.4, 12.0, 0.0);
        arrow.setBorderColor(java.awt.Color.BLACK);
        setEndDecoration(arrow);
        setEndDecoration(arrow);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.DependencyLineConnection#drawLine(java.awt.Graphics, int, int, int, int)
     */
    @SuppressWarnings("deprecation")
    protected void drawLine(Graphics g, int x1, int y1, int x2, int y2)
    {
        super.drawLine(g, x1, y1, x2, y2);

        String manifest = new String("<< deploy >>");
        Font font = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metrics2 = Toolkit.getDefaultToolkit().getFontMetrics(font);
        int widthFig = metrics2.stringWidth(manifest);

        int xm = (x1 + x2) / 2;

        if (widthFig > 0)
        {
            xm -= (widthFig / 2);
        }
        int ym = (y1 + y2) / 2;

        g.setFont(font);
        g.setColor(Color.BLACK);

        g.drawString(manifest, xm, ym);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.DependencyLineConnection#relatedConceptClass()
     */
    @Override
    public Class<Manifestation> relatedConceptClass()
    {
        return Manifestation.class;
    }

}
