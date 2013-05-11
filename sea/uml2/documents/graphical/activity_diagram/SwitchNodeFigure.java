/*
 * @(#)SwitchNodeFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Mar 13, 2008        descrição
 */
package documents.graphical.activity_diagram;

import ocean.smalltalk.OceanVector;
import documents.concepts.activity_diagram.ConditionalNode;
import documents.concepts.activity_diagram.SwitchNode;

public class SwitchNodeFigure extends ConditionalNodeFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 8587315660895341048L;

    /**
     * The stereotype of the switch node.
     */
    private static final String TYPE = new String("<<SWITCH>>");

    /**
     * Default constructor.
     */
    public SwitchNodeFigure()
    {
        super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @Override
    public Class< ? extends ConditionalNode> relatedConceptClass()
    {
        return SwitchNode.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(SwitchNode.class);
        return auxList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#redraw()
     */
    @SuppressWarnings("deprecation")
    public void redraw()
    {

        removeAll();

        super.createNodeFigure(this.createConcept());

        update();
    }

    /*
     * (non-Javadoc)
     * 
     * @see documents.graphical.activity_diagram.LoopNodeFigure#createLoopConcept()
     */
    protected SwitchNode createConcept()
    {

        SwitchNode switchNode = (SwitchNode) this.concept();
        // NAME
        if (switchNode.getNodeName() == null || ("").equals(switchNode.getNodeName()))
        {
            switchNode.setNodeName("sequence");
        }
        // TYPE
        switchNode.setNodeType(TYPE);

        return switchNode;

    }

}
