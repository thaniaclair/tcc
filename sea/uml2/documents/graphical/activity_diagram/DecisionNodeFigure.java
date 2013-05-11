/*
 * @(#)DecisionNodeFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Mar 4, 2008        descrição
 */
package documents.graphical.activity_diagram;

import ocean.framework.Concept;
import ocean.smalltalk.OceanVector;
import documents.concepts.activity_diagram.DecisionNode;
import documents.graphical.state_machine_diagram.ChoiceFigure;

public class DecisionNodeFigure extends ChoiceFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -5846271136562929810L;

    /**
     * Default constructor.
     */
    public DecisionNodeFigure()
    {
        super();
    }
    

    /**
     * Overloaded constructor.
     */
    public DecisionNodeFigure(DecisionNode decision)
    {
        super(decision);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @Override
    public Class< ? extends Concept> relatedConceptClass()
    {
        return DecisionNode.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(DecisionNode.class);
        return auxList;
    }

}
