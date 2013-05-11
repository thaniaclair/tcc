/*
 * @(#)FlowFinalNodeFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Mar 4, 2008        descrição
 */
package documents.graphical.activity_diagram;

import ocean.framework.Concept;
import ocean.smalltalk.OceanVector;
import documents.concepts.activity_diagram.FlowFinalNode;
import documents.graphical.state_machine_diagram.ExitPointFigure;

public class FlowFinalNodeFigure extends ExitPointFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 3984022087207842359L;

    /**
     * Default constructor.
     */
    public FlowFinalNodeFigure()
    {
        super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @Override
    public Class< ? extends Concept> relatedConceptClass()
    {
        return FlowFinalNode.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(FlowFinalNode.class);
        return auxList;
    }

}
