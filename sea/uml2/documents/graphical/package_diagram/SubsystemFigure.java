/*
 * @(#)SubsystemFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Jan 5, 2008        descrição
 */
package documents.graphical.package_diagram;

import documents.concepts.package_diagram.Subsystem;
import ocean.jhotdraw.SpecificationCompositeFigure;


public class SubsystemFigure extends SpecificationCompositeFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -8533180195146405528L;

    /* (non-Javadoc)
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @Override
    public Class<Subsystem> relatedConceptClass()
    {
        return Subsystem.class;
    }
    
}