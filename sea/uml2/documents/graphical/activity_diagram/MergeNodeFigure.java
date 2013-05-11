/*
 * @(#)MergeNodeFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Mar 4, 2008        descrição
 */
package documents.graphical.activity_diagram;

import ocean.framework.Concept;
import ocean.smalltalk.OceanVector;
import documents.concepts.activity_diagram.MergeNode;
import documents.graphical.state_machine_diagram.ChoiceFigure;

public class MergeNodeFigure extends ChoiceFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 765052736302739771L;

    /**
     * Default constructor.
     */
    public MergeNodeFigure()
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
        return MergeNode.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(MergeNode.class);
        return auxList;
    }

}
