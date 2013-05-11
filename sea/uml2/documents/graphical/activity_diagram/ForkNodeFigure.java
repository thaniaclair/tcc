/*
 * @(#)ForkNodeFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Mar 4, 2008        descrição
 */
package documents.graphical.activity_diagram;

import ocean.framework.Concept;
import ocean.smalltalk.OceanVector;
import documents.concepts.activity_diagram.ForkNode;
import documents.graphical.state_machine_diagram.ForkFigure;

public class ForkNodeFigure extends ForkFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 8915648660742800984L;

    /**
     * Default constructor.
     */
    public ForkNodeFigure()
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
        return ForkNode.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(ForkNode.class);
        return auxList;
    }

}
