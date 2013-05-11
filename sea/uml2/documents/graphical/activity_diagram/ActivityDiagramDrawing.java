/*
 * @(#)ActivityDiagramDrawing.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Mar 3, 2008        descrição
 */
package documents.graphical.activity_diagram;

import ocean.framework.Concept;
import ocean.jhotdraw.SpecificationCompositeFigure;
import ocean.jhotdraw.SpecificationDrawing;
import ocean.jhotdraw.SpecificationLineFigure;

public class ActivityDiagramDrawing extends SpecificationDrawing
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 609688987340936812L;

    /**
     * Official constructor.
     */
    public ActivityDiagramDrawing()
    {
        super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationDrawing#createDesiredFigureForConcept(ocean.framework.Concept)
     */
    @Override
    public SpecificationCompositeFigure createDesiredFigureForConcept(Concept component)
    {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationDrawing#createDesiredLineForConcept(ocean.framework.Concept)
     */
    @Override
    public SpecificationLineFigure createDesiredLineForConcept(Concept component)
    {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationDrawing#startFigureFor(ocean.framework.Concept)
     */
    @Override
    public SpecificationCompositeFigure startFigureFor(Concept component)
    {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationDrawing#stopFigureFor(ocean.framework.Concept)
     */
    @Override
    public SpecificationCompositeFigure stopFigureFor(Concept component)
    {
        return null;
    }

}
