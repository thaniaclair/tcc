/*
 * @(#)ChoiceFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Feb 22, 2008        descrição
 */
package documents.graphical.state_machine_diagram;

import java.awt.Color;

import ocean.framework.Concept;
import ocean.jhotdraw.SpecificationCompositeFigure;
import ocean.smalltalk.OceanVector;
import CH.ifa.draw.contrib.PolygonFigure;
import documents.concepts.state_machine_diagram.Choice;

public class ChoiceFigure extends SpecificationCompositeFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 2784918643693124834L;

    /**
     * Constructor.
     */
    public ChoiceFigure()
    {
        super(new EmptyFillRectangle());
    }
    
    /**
     * Constructor.
     */
    public ChoiceFigure(Concept concept)
    {
        super(concept);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @Override
    public Class< ? extends Concept> relatedConceptClass()
    {
        return Choice.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(Choice.class);
        return auxList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#redraw()
     */
    public void redraw()
    {

        removeAll();

        int x = this.getPresentationFigure().displayBox().x;
        int y = this.getPresentationFigure().displayBox().y;

        PolygonFigure poly = new PolygonFigure();

        poly.addPoint(x + 15, y);
        poly.addPoint(x, y + 15);
        poly.addPoint(x + 15, y + 30);
        poly.addPoint(x + 30, y + 15);
        poly.addPoint(x + 15, y);

        poly.setAttribute("FillColor", new Color(0xE8E8E8));
        poly.setAttribute("FrameColor", Color.BLACK);

        this.setAttribute("FillColor", Color.WHITE);
        this.setAttribute("FrameColor", Color.WHITE);

        add(poly);

        update();
    }

}
