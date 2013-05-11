/*
 * @(#)OccurrenceFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Feb 16, 2008        descrição
 */
package documents.graphical.composite_structure_diagram;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import CH.ifa.draw.figures.ArrowTip;
import documents.concepts.composite_structure_diagram.Occurrence;
import documents.graphical.object_diagram.DependencyLineConnection;

public class OccurrenceFigure extends DependencyLineConnection
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 8973542287663000983L;

    /**
     * Create a new instance
     */
    public OccurrenceFigure()
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
    protected void drawLine(Graphics g, int x1, int y1, int x2, int y2)
    {
        super.drawLine(g, x1, y1, x2, y2);

        int xm = (x1 + x2) / 2;
        int ym = (y1 + y2) / 2;

        g.setFont(new Font("Helvetica", Font.BOLD, 14));
        g.setColor(Color.BLACK);
        g.drawString("<< occurrence >>", xm, ym);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.DependencyLineConnection#relatedConceptClass()
     */
    @Override
    public Class<Occurrence> relatedConceptClass()
    {
        return Occurrence.class;
    }

}