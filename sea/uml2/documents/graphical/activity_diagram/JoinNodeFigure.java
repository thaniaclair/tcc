/*
 * @(#)JoinNodeFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Mar 4, 2008        descrição
 */
package documents.graphical.activity_diagram;

import ocean.framework.Concept;
import ocean.smalltalk.OceanVector;
import documents.concepts.activity_diagram.JoinNode;
import documents.graphical.state_machine_diagram.JoinFigure;

public class JoinNodeFigure extends JoinFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -3178463072067671098L;

    /**
     * Default constructor.
     */
    public JoinNodeFigure()
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
        return JoinNode.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(JoinNode.class);
        return auxList;
    }

}
