/*
 * @(#)FinalNodeFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Mar 4, 2008        descrição
 */
package documents.graphical.activity_diagram;

import ocean.framework.Concept;
import ocean.smalltalk.OceanVector;
import documents.concepts.activity_diagram.FinalNode;
import documents.graphical.state_machine_diagram.FinalStateFigure;

public class FinalNodeFigure extends FinalStateFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -7581591794098655131L;

    /**
     * Default constructor.
     */
    public FinalNodeFigure()
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
        return FinalNode.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(FinalNode.class);
        return auxList;
    }

}
