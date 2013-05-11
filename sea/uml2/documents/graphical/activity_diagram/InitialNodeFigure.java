/*
 * @(#)InitialNodeFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Mar 4, 2008        descrição
 */
package documents.graphical.activity_diagram;

import ocean.framework.Concept;
import ocean.smalltalk.OceanVector;
import documents.concepts.activity_diagram.InitialNode;
import documents.graphical.state_machine_diagram.InitialStateFigure;

public class InitialNodeFigure extends InitialStateFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 5801583340905403150L;

    /**
     * Default constructor.
     */
    public InitialNodeFigure()
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
        return InitialNode.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(InitialNode.class);
        return auxList;
    }

}
