/*
 * @(#)ActivityDiagram.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Mar 3, 2008        descrição
 */
package documents.models;

import ocean.framework.ConceptualModel;
import ocean.framework.SpecificationElement;
import ocean.jhotdraw.SpecificationDrawing;
import ocean.smalltalk.OceanVector;
import documents.concepts.activity_diagram.*;
import documents.concepts.communication_diagram.Label;
import documents.graphical.activity_diagram.ActivityDiagramDrawing;
import documents.util.I18NProperties;

public class ActivityDiagram extends ConceptualModel
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -73604485105160495L;

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.ConceptualModel#initialize()
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public void initialize()
    {
        elementKeeperList = new OceanVector();
        elementKeeperList.add(SpecificationElement.construtor(AcceptEventAction.class));
        elementKeeperList.add(SpecificationElement.construtor(AcceptTimeEventAction.class));
        elementKeeperList.add(SpecificationElement.construtor(Action.class));
        elementKeeperList.add(SpecificationElement.construtor(Activity.class));
        elementKeeperList.add(SpecificationElement.construtor(CentralBufferNode.class));
        elementKeeperList.add(SpecificationElement.construtor(ConditionalNode.class));
        elementKeeperList.add(SpecificationElement.construtor(ControlFlow.class));
        elementKeeperList.add(SpecificationElement.construtor(DataStoreNode.class));
        elementKeeperList.add(SpecificationElement.construtor(DecisionNode.class));
        elementKeeperList.add(SpecificationElement.construtor(ExceptionHandler.class));
        elementKeeperList.add(SpecificationElement.construtor(FinalNode.class));
        elementKeeperList.add(SpecificationElement.construtor(FlowFinalNode.class));
        elementKeeperList.add(SpecificationElement.construtor(ForkNode.class));
        elementKeeperList.add(SpecificationElement.construtor(HorizontalSwinlane.class));
        elementKeeperList.add(SpecificationElement.construtor(InitialNode.class));
        elementKeeperList.add(SpecificationElement.construtor(InterruptibleActivity.class));
        elementKeeperList.add(SpecificationElement.construtor(JoinNode.class));
        elementKeeperList.add(SpecificationElement.construtor(LoopNode.class));
        elementKeeperList.add(SpecificationElement.construtor(MergeNode.class));
        elementKeeperList.add(SpecificationElement.construtor(ObjectFlow.class));
        elementKeeperList.add(SpecificationElement.construtor(ObjectNode.class));
        elementKeeperList.add(SpecificationElement.construtor(SendSignal.class));
        elementKeeperList.add(SpecificationElement.construtor(SequenceNode.class));
        elementKeeperList.add(SpecificationElement.construtor(StructuredActivityNode.class));
        elementKeeperList.add(SpecificationElement.construtor(VerticalSwinlane.class));
        elementKeeperList.add(SpecificationElement.construtor(Assignment.class));
        elementKeeperList.add(SpecificationElement.construtor(Return.class));
        elementKeeperList.add(SpecificationElement.construtor(Message.class));
        elementKeeperList.add(SpecificationElement.construtor(Comment.class));
        elementKeeperList.add(SpecificationElement.construtor(NoteLink.class));
        elementKeeperList.add(SpecificationElement.construtor(Variable.class));
        elementKeeperList.add(SpecificationElement.construtor(TaskPackage.class));
        elementKeeperList.add(SpecificationElement.construtor(GenericTask.class));
        elementKeeperList.add(SpecificationElement.construtor(Label.class));
        elementKeeperList.add(SpecificationElement.construtor(IfNode.class));
        elementKeeperList.add(SpecificationElement.construtor(IfElseNode.class));
        elementKeeperList.add(SpecificationElement.construtor(ForNode.class));
        elementKeeperList.add(SpecificationElement.construtor(WhileNode.class));
        elementKeeperList.add(SpecificationElement.construtor(DoWhileNode.class));
        elementKeeperList.add(SpecificationElement.construtor(SwitchNode.class));
        elementKeeperList.add(SpecificationElement.construtor(Note.class));
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.ConceptualModel#createEmptyDrawing()
     */
    @Override
    public SpecificationDrawing createEmptyDrawing()
    {
        return new ActivityDiagramDrawing();
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.ConceptualModel#conceitoLista()
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public OceanVector<Class> conceitoLista()
    {
        OceanVector<Class> aList = new OceanVector<Class>();
        aList.add(AcceptEventAction.class);
        aList.add(AcceptTimeEventAction.class);
        aList.add(Action.class);
        aList.add(Activity.class);
        aList.add(CentralBufferNode.class);
        aList.add(ConditionalNode.class);
        aList.add(ControlFlow.class);
        aList.add(DataStoreNode.class);
        aList.add(DecisionNode.class);
        aList.add(ExceptionHandler.class);
        aList.add(FinalNode.class);
        aList.add(FlowFinalNode.class);
        aList.add(ForkNode.class);
        aList.add(HorizontalSwinlane.class);
        aList.add(InitialNode.class);
        aList.add(InterruptibleActivity.class);
        aList.add(JoinNode.class);
        aList.add(LoopNode.class);
        aList.add(MergeNode.class);
        aList.add(ObjectFlow.class);
        aList.add(ObjectNode.class);
        aList.add(SendSignal.class);
        aList.add(SequenceNode.class);
        aList.add(StructuredActivityNode.class);
        aList.add(VerticalSwinlane.class);
        aList.add(Assignment.class);
        aList.add(Return.class);
        aList.add(Message.class);
        aList.add(Comment.class);
        aList.add(NoteLink.class);
        aList.add(Variable.class);
        aList.add(TaskPackage.class);
        aList.add(GenericTask.class);
        aList.add(Label.class);
        aList.add(IfNode.class);
        aList.add(IfElseNode.class);
        aList.add(ForNode.class);
        aList.add(WhileNode.class);
        aList.add(DoWhileNode.class);
        aList.add(SwitchNode.class);
        aList.add(Note.class);

        return aList;
    }

    /*
     * (non-Javadoc) Realization
     * 
     * @see ocean.framework.ConceptualModel#modelName()
     */
    public String modelName()
    {
        return I18NProperties.getString("activity.diagram.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("activity.diagram.name.for.tree") + name;
    }

}
