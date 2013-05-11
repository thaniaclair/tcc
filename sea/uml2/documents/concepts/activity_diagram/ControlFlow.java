/*
 * @(#)ControlFlow.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Mar 3, 2008        descrição
 */
package documents.concepts.activity_diagram;

import ocean.framework.Concept;
import ocean.smalltalk.OceanVector;
import documents.graphical.activity_diagram.IfNodeFigure;
import documents.util.I18NProperties;

public class ControlFlow extends Concept
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -5942132208180174453L;

    private InitialNode initialTerminal1;

    private FinalNode finalTerminal2;

    private FlowFinalNode flowFinalTerminal2;

    private Activity activityTerminal1;

    private Activity activityTerminal2;

    private DecisionNode decisionTerminal1;

    private DecisionNode decisionTerminal2;

    private MergeNode mergeTerminal1;

    private MergeNode mergeTerminal2;

    private ForkNode forkTerminal1;

    private ForkNode forkTerminal2;

    private JoinNode joinTerminal1;

    private JoinNode joinTerminal2;

    private Action actionTerminal1;

    private Action actionTerminal2;

    private AcceptEventAction acceptEventTerminal1;

    private AcceptEventAction acceptEventTerminal2;

    private AcceptTimeEventAction acceptTimeEventTerminal1;

    private AcceptTimeEventAction acceptTimeEventTerminal2;

    private SendSignal sendSignalTerminal1;

    private SendSignal sendSignalTerminal2;

    private LoopNode loopTerminal1;

    private LoopNode loopTerminal2;

    private ConditionalNode conditionalTerminal1;

    private ConditionalNode conditionalTerminal2;

    private SequenceNode sequenceTerminal1;

    private SequenceNode sequenceTerminal2;

    private StructuredActivityNode structuredActivityTerminal1;

    private StructuredActivityNode structuredActivityTerminal2;

    private IfNode ifNodeTerminal1;

    private IfNode ifNodeTerminal2;

    private IfElseNode ifElseNodeTerminal1;

    private IfElseNode ifElseNodeTerminal2;

    // Code concepts.

    private Assignment assignmentTerminal1;

    private Assignment assignmentTerminal2;

    private Return returnTerminal1;

    private Return returnTerminal2;

    private Message messageTerminal1;

    private Message messageTerminal2;

    private TaskPackage taskTerminal1;

    private TaskPackage taskTerminal2;

    private GenericTask genericTerminal1;

    private GenericTask genericTerminal2;

    private Comment commentTerminal1;

    private Comment commentTerminal2;

    private Variable varTerminal1;

    private Variable varTerminal2;

    /**
     * Official constructor.
     */
    public ControlFlow()
    {
        super();
        name(I18NProperties.getString("control.flow.concept.name"));
    }

    /**
     * @param initialNode
     * @param finalNode
     */
    public ControlFlow(InitialNode initialNode, FinalNode finalNode)
    {
        this();
        this.setInitialTerminal1(initialNode);
        this.setFinalTerminal2(finalNode);
    }

    /**
     * @param initialNode
     * @param finalNode
     */
    public ControlFlow(InitialNode initialNode, FlowFinalNode finalNode)
    {
        this();
        this.setInitialTerminal1(initialNode);
        this.setFlowFinalTerminal2(finalNode);
    }

    /**
     * @param initialNode
     * @param activity
     */
    public ControlFlow(InitialNode initialNode, Activity activity)
    {
        this();
        this.setInitialTerminal1(initialNode);
        this.setActivityTerminal2(activity);
    }

    /**
     * @param initialNode
     * @param decision
     */
    public ControlFlow(InitialNode initialNode, DecisionNode decision)
    {
        this();
        this.setInitialTerminal1(initialNode);
        this.setDecisionTerminal2(decision);
    }

    /**
     * @param initialNode
     * @param merge
     */
    public ControlFlow(InitialNode initialNode, MergeNode merge)
    {
        this();
        this.setInitialTerminal1(initialNode);
        this.setMergeTerminal2(merge);
    }

    /**
     * @param initialNode
     * @param fork
     */
    public ControlFlow(InitialNode initialNode, ForkNode fork)
    {
        this();
        this.setInitialTerminal1(initialNode);
        this.setForkTerminal2(fork);
    }

    /**
     * @param initialNode
     * @param join
     */
    public ControlFlow(InitialNode initialNode, JoinNode join)
    {
        this();
        this.setInitialTerminal1(initialNode);
        this.setJoinTerminal2(join);
    }

    /**
     * @param initialNode
     * @param action
     */
    public ControlFlow(InitialNode initialNode, Action action)
    {
        this();
        this.setInitialTerminal1(initialNode);
        this.setActionTerminal2(action);
    }

    /**
     * @param initialNode
     * @param action
     */
    public ControlFlow(InitialNode initialNode, AcceptEventAction action)
    {
        this();
        this.setInitialTerminal1(initialNode);
        this.setAcceptEventTerminal2(action);
    }

    /**
     * @param initialNode
     * @param action
     */
    public ControlFlow(InitialNode initialNode, AcceptTimeEventAction action)
    {
        this();
        this.setInitialTerminal1(initialNode);
        this.setAcceptTimeEventTerminal2(action);
    }

    /**
     * @param initialNode
     * @param loop
     */
    public ControlFlow(InitialNode initialNode, LoopNode loop)
    {
        this();
        this.setInitialTerminal1(initialNode);
        this.setLoopTerminal2(loop);
    }

    /**
     * @param initialNode
     * @param sequence
     */
    public ControlFlow(InitialNode initialNode, SequenceNode sequence)
    {
        this();
        this.setInitialTerminal1(initialNode);
        this.setSequenceTerminal2(sequence);
    }

    /**
     * @param initialNode
     * @param conditional
     */
    public ControlFlow(InitialNode initialNode, ConditionalNode conditional)
    {
        this();
        this.setInitialTerminal1(initialNode);
        this.setConditionalTerminal2(conditional);
    }

    /**
     * @param initialNode
     * @param conditional
     */
    public ControlFlow(InitialNode initialNode, StructuredActivityNode structured)
    {
        this();
        this.setInitialTerminal1(initialNode);
        this.setStructuredActivityTerminal2(structured);
    }

    /**
     * @param initialNode
     * @param signal
     */
    public ControlFlow(InitialNode initialNode, SendSignal signal)
    {
        this();
        this.setInitialTerminal1(initialNode);
        this.setSendSignalTerminal2(signal);
    }

    /**
     * @param activity
     * @param finalNode
     */
    public ControlFlow(Activity activity, FinalNode finalNode)
    {
        this();
        this.setActivityTerminal1(activity);
        this.setFinalTerminal2(finalNode);
    }

    /**
     * @param decision
     * @param finalNode
     */
    public ControlFlow(DecisionNode decision, FinalNode finalNode)
    {
        this();
        this.setDecisionTerminal1(decision);
        this.setFinalTerminal2(finalNode);
    }

    /**
     * @param merge
     * @param finalNode
     */
    public ControlFlow(MergeNode merge, FinalNode finalNode)
    {
        this();
        this.setMergeTerminal1(merge);
        this.setFinalTerminal2(finalNode);
    }

    /**
     * @param fork
     * @param finalNode
     */
    public ControlFlow(ForkNode fork, FinalNode finalNode)
    {
        this();
        this.setForkTerminal1(fork);
        this.setFinalTerminal2(finalNode);
    }

    /**
     * @param join
     * @param finalNode
     */
    public ControlFlow(JoinNode join, FinalNode finalNode)
    {
        this();
        this.setJoinTerminal1(join);
        this.setFinalTerminal2(finalNode);
    }

    /**
     * @param action
     * @param finalNode
     */
    public ControlFlow(Action action, FinalNode finalNode)
    {
        this();
        this.setActionTerminal1(action);
        this.setFinalTerminal2(finalNode);
    }

    /**
     * @param action
     * @param finalNode
     */
    public ControlFlow(AcceptEventAction action, FinalNode finalNode)
    {
        this();
        this.setAcceptEventTerminal1(action);
        this.setFinalTerminal2(finalNode);
    }

    /**
     * @param action
     * @param finalNode
     */
    public ControlFlow(AcceptTimeEventAction action, FinalNode finalNode)
    {
        this();
        this.setAcceptTimeEventTerminal1(action);
        this.setFinalTerminal2(finalNode);
    }

    /**
     * @param signal
     * @param finalNode
     */
    public ControlFlow(SendSignal signal, FinalNode finalNode)
    {
        this();
        this.setSendSignalTerminal1(signal);
        this.setFinalTerminal2(finalNode);
    }

    /**
     * @param loop
     * @param finalNode
     */
    public ControlFlow(LoopNode loop, FinalNode finalNode)
    {
        this();
        this.setLoopTerminal1(loop);
        this.setFinalTerminal2(finalNode);
    }

    /**
     * @param activity
     * @param finalNode
     */
    public ControlFlow(StructuredActivityNode activity, FinalNode finalNode)
    {
        this();
        this.setStructuredActivityTerminal1(activity);
        this.setFinalTerminal2(finalNode);
    }

    /**
     * @param sequence
     * @param finalNode
     */
    public ControlFlow(SequenceNode sequence, FinalNode finalNode)
    {
        this();
        this.setSequenceTerminal1(sequence);
        this.setFinalTerminal2(finalNode);
    }

    /**
     * @param conditional
     * @param finalNode
     */
    public ControlFlow(ConditionalNode conditional, FinalNode finalNode)
    {
        this();
        this.setConditionalTerminal1(conditional);
        this.setFinalTerminal2(finalNode);
    }

    /**
     * @param activity
     * @param finalNode
     */
    public ControlFlow(Activity activity, FlowFinalNode finalNode)
    {
        this();
        this.setActivityTerminal1(activity);
        this.setFlowFinalTerminal2(finalNode);
    }

    /**
     * @param decision
     * @param finalNode
     */
    public ControlFlow(DecisionNode decision, FlowFinalNode finalNode)
    {
        this();
        this.setDecisionTerminal1(decision);
        this.setFlowFinalTerminal2(finalNode);
    }

    /**
     * @param merge
     * @param finalNode
     */
    public ControlFlow(MergeNode merge, FlowFinalNode finalNode)
    {
        this();
        this.setMergeTerminal1(merge);
        this.setFlowFinalTerminal2(finalNode);
    }

    /**
     * @param fork
     * @param finalNode
     */
    public ControlFlow(ForkNode fork, FlowFinalNode finalNode)
    {
        this();
        this.setForkTerminal1(fork);
        this.setFlowFinalTerminal2(finalNode);
    }

    /**
     * @param join
     * @param finalNode
     */
    public ControlFlow(JoinNode join, FlowFinalNode finalNode)
    {
        this();
        this.setJoinTerminal1(join);
        this.setFlowFinalTerminal2(finalNode);
    }

    /**
     * @param action
     * @param finalNode
     */
    public ControlFlow(Action action, FlowFinalNode finalNode)
    {
        this();
        this.setActionTerminal1(action);
        this.setFlowFinalTerminal2(finalNode);
    }

    /**
     * @param action
     * @param finalNode
     */
    public ControlFlow(AcceptEventAction action, FlowFinalNode finalNode)
    {
        this();
        this.setAcceptEventTerminal1(action);
        this.setFlowFinalTerminal2(finalNode);
    }

    /**
     * @param action
     * @param finalNode
     */
    public ControlFlow(AcceptTimeEventAction action, FlowFinalNode finalNode)
    {
        this();
        this.setAcceptTimeEventTerminal1(action);
        this.setFlowFinalTerminal2(finalNode);
    }

    /**
     * @param signal
     * @param finalNode
     */
    public ControlFlow(SendSignal signal, FlowFinalNode finalNode)
    {
        this();
        this.setSendSignalTerminal1(signal);
        this.setFlowFinalTerminal2(finalNode);
    }

    /**
     * @param loop
     * @param finalNode
     */
    public ControlFlow(LoopNode loop, FlowFinalNode finalNode)
    {
        this();
        this.setLoopTerminal1(loop);
        this.setFlowFinalTerminal2(finalNode);
    }

    /**
     * @param activity
     * @param finalNode
     */
    public ControlFlow(StructuredActivityNode activity, FlowFinalNode finalNode)
    {
        this();
        this.setStructuredActivityTerminal1(activity);
        this.setFlowFinalTerminal2(finalNode);
    }

    /**
     * @param sequence
     * @param finalNode
     */
    public ControlFlow(SequenceNode sequence, FlowFinalNode finalNode)
    {
        this();
        this.setSequenceTerminal1(sequence);
        this.setFlowFinalTerminal2(finalNode);
    }

    /**
     * @param conditional
     * @param finalNode
     */
    public ControlFlow(ConditionalNode conditional, FlowFinalNode finalNode)
    {
        this();
        this.setConditionalTerminal1(conditional);
        this.setFlowFinalTerminal2(finalNode);
    }

    /**
     * @param activity
     * @param activity2
     */
    public ControlFlow(Activity activity, Activity activity2)
    {
        this();
        this.setActivityTerminal1(activity);
        this.setActivityTerminal2(activity2);
    }

    /**
     * @param activity
     * @param decision
     */
    public ControlFlow(Activity activity, DecisionNode decision)
    {
        this();
        this.setActivityTerminal1(activity);
        this.setDecisionTerminal2(decision);
    }

    /**
     * @param decision
     * @param activity
     */
    public ControlFlow(DecisionNode decision, Activity activity)
    {
        this();
        this.setDecisionTerminal1(decision);
        this.setActivityTerminal2(activity);
    }

    /**
     * @param activity
     * @param merge
     */
    public ControlFlow(Activity activity, MergeNode merge)
    {
        this();
        this.setActivityTerminal1(activity);
        this.setMergeTerminal2(merge);
    }

    /**
     * @param merge
     * @param activity
     */
    public ControlFlow(MergeNode merge, Activity activity)
    {
        this();
        this.setMergeTerminal1(merge);
        this.setActivityTerminal2(activity);
    }

    /**
     * @param activity
     * @param merge
     */
    public ControlFlow(Activity activity, ForkNode fork)
    {
        this();
        this.setActivityTerminal1(activity);
        this.setForkTerminal2(fork);
    }

    /**
     * @param fork
     * @param activity
     */
    public ControlFlow(ForkNode fork, Activity activity)
    {
        this();
        this.setForkTerminal1(fork);
        this.setActivityTerminal2(activity);
    }

    /**
     * @param activity
     * @param join
     */
    public ControlFlow(Activity activity, JoinNode join)
    {
        this();
        this.setActivityTerminal1(activity);
        this.setJoinTerminal2(join);
    }

    /**
     * @param join
     * @param activity
     */
    public ControlFlow(JoinNode join, Activity activity)
    {
        this();
        this.setJoinTerminal1(join);
        this.setActivityTerminal2(activity);
    }

    /**
     * @param activity
     * @param action
     */
    public ControlFlow(Activity activity, Action action)
    {
        this();
        this.setActivityTerminal1(activity);
        this.setActionTerminal2(action);
    }

    /**
     * @param action
     * @param activity
     */
    public ControlFlow(Action action, Activity activity)
    {
        this();
        this.setActionTerminal1(action);
        this.setActivityTerminal2(activity);
    }

    /**
     * @param activity
     * @param action
     */
    public ControlFlow(Activity activity, AcceptEventAction action)
    {
        this();
        this.setActivityTerminal1(activity);
        this.setAcceptEventTerminal2(action);
    }

    /**
     * @param action
     * @param activity
     */
    public ControlFlow(AcceptEventAction action, Activity activity)
    {
        this();
        this.setAcceptEventTerminal1(action);
        this.setActivityTerminal2(activity);
    }

    /**
     * @param activity
     * @param action
     */
    public ControlFlow(Activity activity, AcceptTimeEventAction action)
    {
        this();
        this.setActivityTerminal1(activity);
        this.setAcceptTimeEventTerminal2(action);
    }

    /**
     * @param action
     * @param activity
     */
    public ControlFlow(AcceptTimeEventAction action, Activity activity)
    {
        this();
        this.setAcceptTimeEventTerminal1(action);
        this.setActivityTerminal2(activity);
    }

    /**
     * @param activity
     * @param signal
     */
    public ControlFlow(Activity activity, SendSignal signal)
    {
        this();
        this.setActivityTerminal1(activity);
        this.setSendSignalTerminal2(signal);
    }

    /**
     * @param signal
     * @param activity
     */
    public ControlFlow(SendSignal signal, Activity activity)
    {
        this();
        this.setSendSignalTerminal1(signal);
        this.setActivityTerminal2(activity);
    }

    /**
     * @param activity
     * @param loop
     */
    public ControlFlow(Activity activity, LoopNode loop)
    {
        this();
        this.setActivityTerminal1(activity);
        this.setLoopTerminal2(loop);
    }

    /**
     * @param loop
     * @param activity
     */
    public ControlFlow(LoopNode loop, Activity activity)
    {
        this();
        this.setLoopTerminal1(loop);
        this.setActivityTerminal2(activity);
    }

    /**
     * @param sequence
     * @param activity
     */
    public ControlFlow(SequenceNode sequence, Activity activity)
    {
        this();
        this.setSequenceTerminal1(sequence);
        this.setActivityTerminal2(activity);
    }

    /**
     * @param activity
     * @param sequence
     */
    public ControlFlow(Activity activity, SequenceNode sequence)
    {
        this();
        this.setActivityTerminal1(activity);
        this.setSequenceTerminal2(sequence);
    }

    /**
     * @param conditional
     * @param activity
     */
    public ControlFlow(ConditionalNode conditional, Activity activity)
    {
        this();
        this.setConditionalTerminal1(conditional);
        this.setActivityTerminal2(activity);
    }

    /**
     * @param activity
     * @param conditional
     */
    public ControlFlow(Activity activity, ConditionalNode conditional)
    {
        this();
        this.setActivityTerminal1(activity);
        this.setConditionalTerminal2(conditional);
    }

    /**
     * @param structured
     * @param activity
     */
    public ControlFlow(StructuredActivityNode structured, Activity activity)
    {
        this();
        this.setStructuredActivityTerminal1(structured);
        this.setActivityTerminal2(activity);
    }

    /**
     * @param activity
     * @param structured
     */
    public ControlFlow(Activity activity, StructuredActivityNode structured)
    {
        this();
        this.setActivityTerminal1(activity);
        this.setStructuredActivityTerminal2(structured);
    }

    /**
     * @param decision
     * @param decision2
     */
    public ControlFlow(DecisionNode decision, DecisionNode decision2)
    {
        this();
        this.setDecisionTerminal1(decision);
        this.setDecisionTerminal2(decision2);
    }

    /**
     * @param decision
     * @param merge
     */
    public ControlFlow(DecisionNode decision, MergeNode merge)
    {
        this();
        this.setDecisionTerminal1(decision);
        this.setMergeTerminal2(merge);
    }

    /**
     * @param merge
     * @param decision
     */
    public ControlFlow(MergeNode merge, DecisionNode decision)
    {
        this();
        this.setMergeTerminal1(merge);
        this.setDecisionTerminal2(decision);
    }

    /**
     * @param decision
     * @param merge
     */
    public ControlFlow(DecisionNode decision, ForkNode fork)
    {
        this();
        this.setDecisionTerminal1(decision);
        this.setForkTerminal2(fork);
    }

    /**
     * @param fork
     * @param decision
     */
    public ControlFlow(ForkNode fork, DecisionNode decision)
    {
        this();
        this.setForkTerminal1(fork);
        this.setDecisionTerminal2(decision);
    }

    /**
     * @param decision
     * @param join
     */
    public ControlFlow(DecisionNode decision, JoinNode join)
    {
        this();
        this.setDecisionTerminal1(decision);
        this.setJoinTerminal2(join);
    }

    /**
     * @param join
     * @param decision
     */
    public ControlFlow(JoinNode join, DecisionNode decision)
    {
        this();
        this.setJoinTerminal1(join);
        this.setDecisionTerminal2(decision);
    }

    /**
     * @param decision
     * @param action
     */
    public ControlFlow(DecisionNode decision, Action action)
    {
        this();
        this.setDecisionTerminal1(decision);
        this.setActionTerminal2(action);
    }

    /**
     * @param action
     * @param decision
     */
    public ControlFlow(Action action, DecisionNode decision)
    {
        this();
        this.setActionTerminal1(action);
        this.setDecisionTerminal2(decision);
    }

    /**
     * @param decision
     * @param action
     */
    public ControlFlow(DecisionNode decision, AcceptEventAction action)
    {
        this();
        this.setDecisionTerminal1(decision);
        this.setAcceptEventTerminal2(action);
    }

    /**
     * @param action
     * @param decision
     */
    public ControlFlow(AcceptEventAction action, DecisionNode decision)
    {
        this();
        this.setAcceptEventTerminal1(action);
        this.setDecisionTerminal2(decision);
    }

    /**
     * @param decision
     * @param action
     */
    public ControlFlow(DecisionNode decision, AcceptTimeEventAction action)
    {
        this();
        this.setDecisionTerminal1(decision);
        this.setAcceptTimeEventTerminal2(action);
    }

    /**
     * @param action
     * @param decision
     */
    public ControlFlow(AcceptTimeEventAction action, DecisionNode decision)
    {
        this();
        this.setAcceptTimeEventTerminal1(action);
        this.setDecisionTerminal2(decision);
    }

    /**
     * @param decision
     * @param signal
     */
    public ControlFlow(DecisionNode decision, SendSignal signal)
    {
        this();
        this.setDecisionTerminal1(decision);
        this.setSendSignalTerminal2(signal);
    }

    /**
     * @param signal
     * @param decision
     */
    public ControlFlow(SendSignal signal, DecisionNode decision)
    {
        this();
        this.setSendSignalTerminal1(signal);
        this.setDecisionTerminal2(decision);
    }

    /**
     * @param decision
     * @param loop
     */
    public ControlFlow(DecisionNode decision, LoopNode loop)
    {
        this();
        this.setDecisionTerminal1(decision);
        this.setLoopTerminal2(loop);
    }

    /**
     * @param loop
     * @param decision
     */
    public ControlFlow(LoopNode loop, DecisionNode decision)
    {
        this();
        this.setLoopTerminal1(loop);
        this.setDecisionTerminal2(decision);
    }

    /**
     * @param sequence
     * @param decision
     */
    public ControlFlow(SequenceNode sequence, DecisionNode decision)
    {
        this();
        this.setSequenceTerminal1(sequence);
        this.setDecisionTerminal2(decision);
    }

    /**
     * @param decision
     * @param sequence
     */
    public ControlFlow(DecisionNode decision, SequenceNode sequence)
    {
        this();
        this.setDecisionTerminal1(decision);
        this.setSequenceTerminal2(sequence);
    }

    /**
     * @param conditional
     * @param decision
     */
    public ControlFlow(ConditionalNode conditional, DecisionNode decision)
    {
        this();
        this.setConditionalTerminal1(conditional);
        this.setDecisionTerminal2(decision);
    }

    /**
     * @param decision
     * @param conditional
     */
    public ControlFlow(DecisionNode decision, ConditionalNode conditional)
    {
        this();
        this.setDecisionTerminal1(decision);
        this.setConditionalTerminal2(conditional);
    }

    /**
     * @param structured
     * @param decision
     */
    public ControlFlow(StructuredActivityNode structured, DecisionNode decision)
    {
        this();
        this.setStructuredActivityTerminal1(structured);
        this.setDecisionTerminal2(decision);
    }

    /**
     * @param decision
     * @param structured
     */
    public ControlFlow(DecisionNode decision, StructuredActivityNode structured)
    {
        this();
        this.setDecisionTerminal1(decision);
        this.setStructuredActivityTerminal2(structured);
    }

    /**
     * @param merge
     * @param merge
     */
    public ControlFlow(MergeNode merge, ForkNode fork)
    {
        this();
        this.setMergeTerminal1(merge);
        this.setForkTerminal2(fork);
    }

    /**
     * @param fork
     * @param merge
     */
    public ControlFlow(ForkNode fork, MergeNode merge)
    {
        this();
        this.setForkTerminal1(fork);
        this.setMergeTerminal2(merge);
    }

    /**
     * @param merge
     * @param join
     */
    public ControlFlow(MergeNode merge, JoinNode join)
    {
        this();
        this.setMergeTerminal1(merge);
        this.setJoinTerminal2(join);
    }

    /**
     * @param join
     * @param merge
     */
    public ControlFlow(JoinNode join, MergeNode merge)
    {
        this();
        this.setJoinTerminal1(join);
        this.setMergeTerminal2(merge);
    }

    /**
     * @param merge
     * @param action
     */
    public ControlFlow(MergeNode merge, Action action)
    {
        this();
        this.setMergeTerminal1(merge);
        this.setActionTerminal2(action);
    }

    /**
     * @param action
     * @param merge
     */
    public ControlFlow(Action action, MergeNode merge)
    {
        this();
        this.setActionTerminal1(action);
        this.setMergeTerminal2(merge);
    }

    /**
     * @param merge
     * @param action
     */
    public ControlFlow(MergeNode merge, AcceptEventAction action)
    {
        this();
        this.setMergeTerminal1(merge);
        this.setAcceptEventTerminal2(action);
    }

    /**
     * @param action
     * @param merge
     */
    public ControlFlow(AcceptEventAction action, MergeNode merge)
    {
        this();
        this.setAcceptEventTerminal1(action);
        this.setMergeTerminal2(merge);
    }

    /**
     * @param merge
     * @param action
     */
    public ControlFlow(MergeNode merge, AcceptTimeEventAction action)
    {
        this();
        this.setMergeTerminal1(merge);
        this.setAcceptTimeEventTerminal2(action);
    }

    /**
     * @param action
     * @param merge
     */
    public ControlFlow(AcceptTimeEventAction action, MergeNode merge)
    {
        this();
        this.setAcceptTimeEventTerminal1(action);
        this.setMergeTerminal2(merge);
    }

    /**
     * @param merge
     * @param signal
     */
    public ControlFlow(MergeNode merge, SendSignal signal)
    {
        this();
        this.setMergeTerminal1(merge);
        this.setSendSignalTerminal2(signal);
    }

    /**
     * @param signal
     * @param merge
     */
    public ControlFlow(SendSignal signal, MergeNode merge)
    {
        this();
        this.setSendSignalTerminal1(signal);
        this.setMergeTerminal2(merge);
    }

    /**
     * @param merge
     * @param loop
     */
    public ControlFlow(MergeNode merge, LoopNode loop)
    {
        this();
        this.setMergeTerminal1(merge);
        this.setLoopTerminal2(loop);
    }

    /**
     * @param loop
     * @param merge
     */
    public ControlFlow(LoopNode loop, MergeNode merge)
    {
        this();
        this.setLoopTerminal1(loop);
        this.setMergeTerminal2(merge);
    }

    /**
     * @param sequence
     * @param merge
     */
    public ControlFlow(SequenceNode sequence, MergeNode merge)
    {
        this();
        this.setSequenceTerminal1(sequence);
        this.setMergeTerminal2(merge);
    }

    /**
     * @param merge
     * @param sequence
     */
    public ControlFlow(MergeNode merge, SequenceNode sequence)
    {
        this();
        this.setMergeTerminal1(merge);
        this.setSequenceTerminal2(sequence);
    }

    /**
     * @param conditional
     * @param merge
     */
    public ControlFlow(ConditionalNode conditional, MergeNode merge)
    {
        this();
        this.setConditionalTerminal1(conditional);
        this.setMergeTerminal2(merge);
    }

    /**
     * @param merge
     * @param conditional
     */
    public ControlFlow(MergeNode merge, ConditionalNode conditional)
    {
        this();
        this.setMergeTerminal1(merge);
        this.setConditionalTerminal2(conditional);
    }

    /**
     * @param structured
     * @param merge
     */
    public ControlFlow(StructuredActivityNode structured, MergeNode merge)
    {
        this();
        this.setStructuredActivityTerminal1(structured);
        this.setMergeTerminal2(merge);
    }

    /**
     * @param merge
     * @param structured
     */
    public ControlFlow(MergeNode merge, StructuredActivityNode structured)
    {
        this();
        this.setMergeTerminal1(merge);
        this.setStructuredActivityTerminal2(structured);
    }

    /**
     * @param fork
     * @param fork2
     */
    public ControlFlow(ForkNode fork, ForkNode fork2)
    {
        this();
        this.setForkTerminal1(fork);
        this.setForkTerminal2(fork2);
    }

    /**
     * @param fork
     * @param join
     */
    public ControlFlow(ForkNode fork, JoinNode join)
    {
        this();
        this.setForkTerminal1(fork);
        this.setJoinTerminal2(join);
    }

    /**
     * @param join
     * @param fork
     */
    public ControlFlow(JoinNode join, ForkNode fork)
    {
        this();
        this.setJoinTerminal1(join);
        this.setForkTerminal2(fork);
    }

    /**
     * @param fork
     * @param action
     */
    public ControlFlow(ForkNode fork, Action action)
    {
        this();
        this.setForkTerminal1(fork);
        this.setActionTerminal2(action);
    }

    /**
     * @param action
     * @param fork
     */
    public ControlFlow(Action action, ForkNode fork)
    {
        this();
        this.setActionTerminal1(action);
        this.setForkTerminal2(fork);
    }

    /**
     * @param fork
     * @param action
     */
    public ControlFlow(ForkNode fork, AcceptEventAction action)
    {
        this();
        this.setForkTerminal1(fork);
        this.setAcceptEventTerminal2(action);
    }

    /**
     * @param action
     * @param fork
     */
    public ControlFlow(AcceptEventAction action, ForkNode fork)
    {
        this();
        this.setAcceptEventTerminal1(action);
        this.setForkTerminal2(fork);
    }

    /**
     * @param fork
     * @param action
     */
    public ControlFlow(ForkNode fork, AcceptTimeEventAction action)
    {
        this();
        this.setForkTerminal1(fork);
        this.setAcceptTimeEventTerminal2(action);
    }

    /**
     * @param action
     * @param fork
     */
    public ControlFlow(AcceptTimeEventAction action, ForkNode fork)
    {
        this();
        this.setAcceptTimeEventTerminal1(action);
        this.setForkTerminal2(fork);
    }

    /**
     * @param fork
     * @param signal
     */
    public ControlFlow(ForkNode fork, SendSignal signal)
    {
        this();
        this.setForkTerminal1(fork);
        this.setSendSignalTerminal2(signal);
    }

    /**
     * @param signal
     * @param fork
     */
    public ControlFlow(SendSignal signal, ForkNode fork)
    {
        this();
        this.setSendSignalTerminal1(signal);
        this.setForkTerminal2(fork);
    }

    /**
     * @param fork
     * @param loop
     */
    public ControlFlow(ForkNode fork, LoopNode loop)
    {
        this();
        this.setForkTerminal1(fork);
        this.setLoopTerminal2(loop);
    }

    /**
     * @param loop
     * @param fork
     */
    public ControlFlow(LoopNode loop, ForkNode fork)
    {
        this();
        this.setLoopTerminal1(loop);
        this.setForkTerminal2(fork);
    }

    /**
     * @param sequence
     * @param fork
     */
    public ControlFlow(SequenceNode sequence, ForkNode fork)
    {
        this();
        this.setSequenceTerminal1(sequence);
        this.setForkTerminal2(fork);
    }

    /**
     * @param fork
     * @param sequence
     */
    public ControlFlow(ForkNode fork, SequenceNode sequence)
    {
        this();
        this.setForkTerminal1(fork);
        this.setSequenceTerminal2(sequence);
    }

    /**
     * @param conditional
     * @param fork
     */
    public ControlFlow(ConditionalNode conditional, ForkNode fork)
    {
        this();
        this.setConditionalTerminal1(conditional);
        this.setForkTerminal2(fork);
    }

    /**
     * @param fork
     * @param conditional
     */
    public ControlFlow(ForkNode fork, ConditionalNode conditional)
    {
        this();
        this.setForkTerminal1(fork);
        this.setConditionalTerminal2(conditional);
    }

    /**
     * @param structured
     * @param fork
     */
    public ControlFlow(StructuredActivityNode structured, ForkNode fork)
    {
        this();
        this.setStructuredActivityTerminal1(structured);
        this.setForkTerminal2(fork);
    }

    /**
     * @param fork
     * @param structured
     */
    public ControlFlow(ForkNode fork, StructuredActivityNode structured)
    {
        this();
        this.setForkTerminal1(fork);
        this.setStructuredActivityTerminal2(structured);
    }

    /**
     * @param join
     * @param action
     */
    public ControlFlow(JoinNode join, Action action)
    {
        this();
        this.setJoinTerminal1(join);
        this.setActionTerminal2(action);
    }

    /**
     * @param action
     * @param join
     */
    public ControlFlow(Action action, JoinNode join)
    {
        this();
        this.setActionTerminal1(action);
        this.setJoinTerminal2(join);
    }

    /**
     * @param join
     * @param action
     */
    public ControlFlow(JoinNode join, AcceptEventAction action)
    {
        this();
        this.setJoinTerminal1(join);
        this.setAcceptEventTerminal2(action);
    }

    /**
     * @param action
     * @param join
     */
    public ControlFlow(AcceptEventAction action, JoinNode join)
    {
        this();
        this.setAcceptEventTerminal1(action);
        this.setJoinTerminal2(join);
    }

    /**
     * @param join
     * @param action
     */
    public ControlFlow(JoinNode join, AcceptTimeEventAction action)
    {
        this();
        this.setJoinTerminal1(join);
        this.setAcceptTimeEventTerminal2(action);
    }

    /**
     * @param action
     * @param join
     */
    public ControlFlow(AcceptTimeEventAction action, JoinNode join)
    {
        this();
        this.setAcceptTimeEventTerminal1(action);
        this.setJoinTerminal2(join);
    }

    /**
     * @param join
     * @param signal
     */
    public ControlFlow(JoinNode join, SendSignal signal)
    {
        this();
        this.setJoinTerminal1(join);
        this.setSendSignalTerminal2(signal);
    }

    /**
     * @param signal
     * @param join
     */
    public ControlFlow(SendSignal signal, JoinNode join)
    {
        this();
        this.setSendSignalTerminal1(signal);
        this.setJoinTerminal2(join);
    }

    /**
     * @param join
     * @param loop
     */
    public ControlFlow(JoinNode join, LoopNode loop)
    {
        this();
        this.setJoinTerminal1(join);
        this.setLoopTerminal2(loop);
    }

    /**
     * @param loop
     * @param join
     */
    public ControlFlow(LoopNode loop, JoinNode join)
    {
        this();
        this.setLoopTerminal1(loop);
        this.setJoinTerminal2(join);
    }

    /**
     * @param sequence
     * @param join
     */
    public ControlFlow(SequenceNode sequence, JoinNode join)
    {
        this();
        this.setSequenceTerminal1(sequence);
        this.setJoinTerminal2(join);
    }

    /**
     * @param join
     * @param sequence
     */
    public ControlFlow(JoinNode join, SequenceNode sequence)
    {
        this();
        this.setJoinTerminal1(join);
        this.setSequenceTerminal2(sequence);
    }

    /**
     * @param conditional
     * @param join
     */
    public ControlFlow(ConditionalNode conditional, JoinNode join)
    {
        this();
        this.setConditionalTerminal1(conditional);
        this.setJoinTerminal2(join);
    }

    /**
     * @param join
     * @param conditional
     */
    public ControlFlow(JoinNode join, ConditionalNode conditional)
    {
        this();
        this.setJoinTerminal1(join);
        this.setConditionalTerminal2(conditional);
    }

    /**
     * @param structured
     * @param join
     */
    public ControlFlow(StructuredActivityNode structured, JoinNode join)
    {
        this();
        this.setStructuredActivityTerminal1(structured);
        this.setJoinTerminal2(join);
    }

    /**
     * @param join
     * @param structured
     */
    public ControlFlow(JoinNode join, StructuredActivityNode structured)
    {
        this();
        this.setJoinTerminal1(join);
        this.setStructuredActivityTerminal2(structured);
    }

    /**
     * @param action
     * @param action
     */
    public ControlFlow(Action action, Action action2)
    {
        this();
        this.setActionTerminal1(action);
        this.setActionTerminal2(action2);
    }

    /**
     * @param action
     * @param action
     */
    public ControlFlow(Action action, AcceptEventAction action2)
    {
        this();
        this.setActionTerminal1(action);
        this.setAcceptEventTerminal2(action2);
    }

    /**
     * @param action
     * @param action
     */
    public ControlFlow(AcceptEventAction action, Action action2)
    {
        this();
        this.setAcceptEventTerminal1(action);
        this.setActionTerminal2(action2);
    }

    /**
     * @param action
     * @param action
     */
    public ControlFlow(Action action, AcceptTimeEventAction action2)
    {
        this();
        this.setActionTerminal1(action);
        this.setAcceptTimeEventTerminal2(action2);
    }

    /**
     * @param action
     * @param action
     */
    public ControlFlow(AcceptTimeEventAction action, Action action2)
    {
        this();
        this.setAcceptTimeEventTerminal1(action);
        this.setActionTerminal2(action2);
    }

    /**
     * @param action
     * @param signal
     */
    public ControlFlow(Action action, SendSignal signal)
    {
        this();
        this.setActionTerminal1(action);
        this.setSendSignalTerminal2(signal);
    }

    /**
     * @param signal
     * @param action
     */
    public ControlFlow(SendSignal signal, Action action)
    {
        this();
        this.setSendSignalTerminal1(signal);
        this.setActionTerminal2(action);
    }

    /**
     * @param action
     * @param loop
     */
    public ControlFlow(Action action, LoopNode loop)
    {
        this();
        this.setActionTerminal1(action);
        this.setLoopTerminal2(loop);
    }

    /**
     * @param loop
     * @param action
     */
    public ControlFlow(LoopNode loop, Action action)
    {
        this();
        this.setLoopTerminal1(loop);
        this.setActionTerminal2(action);
    }

    /**
     * @param sequence
     * @param action
     */
    public ControlFlow(SequenceNode sequence, Action action)
    {
        this();
        this.setSequenceTerminal1(sequence);
        this.setActionTerminal2(action);
    }

    /**
     * @param action
     * @param sequence
     */
    public ControlFlow(Action action, SequenceNode sequence)
    {
        this();
        this.setActionTerminal1(action);
        this.setSequenceTerminal2(sequence);
    }

    /**
     * @param conditional
     * @param action
     */
    public ControlFlow(ConditionalNode conditional, Action action)
    {
        this();
        this.setConditionalTerminal1(conditional);
        this.setActionTerminal2(action);
    }

    /**
     * @param action
     * @param conditional
     */
    public ControlFlow(Action action, ConditionalNode conditional)
    {
        this();
        this.setActionTerminal1(action);
        this.setConditionalTerminal2(conditional);
    }

    /**
     * @param structured
     * @param action
     */
    public ControlFlow(StructuredActivityNode structured, Action action)
    {
        this();
        this.setStructuredActivityTerminal1(structured);
        this.setActionTerminal2(action);
    }

    /**
     * @param action
     * @param structured
     */
    public ControlFlow(Action action, StructuredActivityNode structured)
    {
        this();
        this.setActionTerminal1(action);
        this.setStructuredActivityTerminal2(structured);
    }

    /**
     * @param action
     * @param action
     */
    public ControlFlow(AcceptEventAction action, AcceptEventAction action2)
    {
        this();
        this.setAcceptEventTerminal1(action);
        this.setAcceptEventTerminal2(action2);
    }

    /**
     * @param action
     * @param action
     */
    public ControlFlow(AcceptEventAction action, AcceptTimeEventAction action2)
    {
        this();
        this.setAcceptEventTerminal1(action);
        this.setAcceptTimeEventTerminal2(action2);
    }

    /**
     * @param action
     * @param action
     */
    public ControlFlow(AcceptTimeEventAction action, AcceptEventAction action2)
    {
        this();
        this.setAcceptTimeEventTerminal1(action);
        this.setAcceptEventTerminal2(action2);
    }

    /**
     * @param action
     * @param signal
     */
    public ControlFlow(AcceptEventAction action, SendSignal signal)
    {
        this();
        this.setAcceptEventTerminal1(action);
        this.setSendSignalTerminal2(signal);
    }

    /**
     * @param signal
     * @param action
     */
    public ControlFlow(SendSignal signal, AcceptEventAction action)
    {
        this();
        this.setSendSignalTerminal1(signal);
        this.setAcceptEventTerminal2(action);
    }

    /**
     * @param action
     * @param loop
     */
    public ControlFlow(AcceptEventAction action, LoopNode loop)
    {
        this();
        this.setAcceptEventTerminal1(action);
        this.setLoopTerminal2(loop);
    }

    /**
     * @param loop
     * @param action
     */
    public ControlFlow(LoopNode loop, AcceptEventAction action)
    {
        this();
        this.setLoopTerminal1(loop);
        this.setAcceptEventTerminal2(action);
    }

    /**
     * @param sequence
     * @param action
     */
    public ControlFlow(SequenceNode sequence, AcceptEventAction action)
    {
        this();
        this.setSequenceTerminal1(sequence);
        this.setAcceptEventTerminal2(action);
    }

    /**
     * @param action
     * @param sequence
     */
    public ControlFlow(AcceptEventAction action, SequenceNode sequence)
    {
        this();
        this.setAcceptEventTerminal1(action);
        this.setSequenceTerminal2(sequence);
    }

    /**
     * @param conditional
     * @param action
     */
    public ControlFlow(ConditionalNode conditional, AcceptEventAction action)
    {
        this();
        this.setConditionalTerminal1(conditional);
        this.setAcceptEventTerminal2(action);
    }

    /**
     * @param action
     * @param conditional
     */
    public ControlFlow(AcceptEventAction action, ConditionalNode conditional)
    {
        this();
        this.setAcceptEventTerminal1(action);
        this.setConditionalTerminal2(conditional);
    }

    /**
     * @param structured
     * @param action
     */
    public ControlFlow(StructuredActivityNode structured, AcceptEventAction action)
    {
        this();
        this.setStructuredActivityTerminal1(structured);
        this.setAcceptEventTerminal2(action);
    }

    /**
     * @param action
     * @param structured
     */
    public ControlFlow(AcceptEventAction action, StructuredActivityNode structured)
    {
        this();
        this.setAcceptEventTerminal1(action);
        this.setStructuredActivityTerminal2(structured);
    }

    /**
     * @param send
     * @param send2
     */
    public ControlFlow(SendSignal send, SendSignal send2)
    {
        this();
        this.setSendSignalTerminal1(send);
        this.setSendSignalTerminal2(send2);
    }

    /**
     * @param send
     * @param action2
     */
    public ControlFlow(SendSignal send, AcceptTimeEventAction action2)
    {
        this();
        this.setSendSignalTerminal1(send);
        this.setAcceptTimeEventTerminal2(action2);
    }

    /**
     * @param action
     * @param send
     */
    public ControlFlow(AcceptTimeEventAction action, SendSignal send)
    {
        this();
        this.setAcceptTimeEventTerminal1(action);
        this.setSendSignalTerminal2(send);
    }

    /**
     * @param send
     * @param loop
     */
    public ControlFlow(SendSignal send, LoopNode loop)
    {
        this();
        this.setSendSignalTerminal1(send);
        this.setLoopTerminal2(loop);
    }

    /**
     * @param loop
     * @param send
     */
    public ControlFlow(LoopNode loop, SendSignal send)
    {
        this();
        this.setLoopTerminal1(loop);
        this.setSendSignalTerminal2(send);
    }

    /**
     * @param sequence
     * @param send
     */
    public ControlFlow(SequenceNode sequence, SendSignal send)
    {
        this();
        this.setSequenceTerminal1(sequence);
        this.setSendSignalTerminal2(send);
    }

    /**
     * @param send
     * @param sequence
     */
    public ControlFlow(SendSignal send, SequenceNode sequence)
    {
        this();
        this.setSendSignalTerminal1(send);
        this.setSequenceTerminal2(sequence);
    }

    /**
     * @param conditional
     * @param send
     */
    public ControlFlow(ConditionalNode conditional, SendSignal send)
    {
        this();
        this.setConditionalTerminal1(conditional);
        this.setSendSignalTerminal2(send);
    }

    /**
     * @param send
     * @param conditional
     */
    public ControlFlow(SendSignal send, ConditionalNode conditional)
    {
        this();
        this.setSendSignalTerminal1(send);
        this.setConditionalTerminal2(conditional);
    }

    /**
     * @param structured
     * @param send
     */
    public ControlFlow(StructuredActivityNode structured, SendSignal send)
    {
        this();
        this.setStructuredActivityTerminal1(structured);
        this.setSendSignalTerminal2(send);
    }

    /**
     * @param send
     * @param structured
     */
    public ControlFlow(SendSignal send, StructuredActivityNode structured)
    {
        this();
        this.setSendSignalTerminal1(send);
        this.setStructuredActivityTerminal2(structured);
    }

    /**
     * @param time
     * @param time2
     */
    public ControlFlow(AcceptTimeEventAction time1, AcceptTimeEventAction time2)
    {
        this();
        this.setAcceptTimeEventTerminal1(time1);
        this.setAcceptTimeEventTerminal2(time2);
    }

    /**
     * @param time
     * @param loop
     */
    public ControlFlow(AcceptTimeEventAction time, LoopNode loop)
    {
        this();
        this.setAcceptTimeEventTerminal1(time);
        this.setLoopTerminal2(loop);
    }

    /**
     * @param loop
     * @param time
     */
    public ControlFlow(LoopNode loop, AcceptTimeEventAction time)
    {
        this();
        this.setLoopTerminal1(loop);
        this.setAcceptTimeEventTerminal2(time);
    }

    /**
     * @param sequence
     * @param time
     */
    public ControlFlow(SequenceNode sequence, AcceptTimeEventAction time)
    {
        this();
        this.setSequenceTerminal1(sequence);
        this.setAcceptTimeEventTerminal2(time);
    }

    /**
     * @param time
     * @param sequence
     */
    public ControlFlow(AcceptTimeEventAction time, SequenceNode sequence)
    {
        this();
        this.setAcceptTimeEventTerminal1(time);
        this.setSequenceTerminal2(sequence);
    }

    /**
     * @param conditional
     * @param time
     */
    public ControlFlow(ConditionalNode conditional, AcceptTimeEventAction time)
    {
        this();
        this.setConditionalTerminal1(conditional);
        this.setAcceptTimeEventTerminal2(time);
    }

    /**
     * @param time
     * @param conditional
     */
    public ControlFlow(AcceptTimeEventAction time, ConditionalNode conditional)
    {
        this();
        this.setAcceptTimeEventTerminal1(time);
        this.setConditionalTerminal2(conditional);
    }

    /**
     * @param structured
     * @param time
     */
    public ControlFlow(StructuredActivityNode structured, AcceptTimeEventAction time)
    {
        this();
        this.setStructuredActivityTerminal1(structured);
        this.setAcceptTimeEventTerminal2(time);
    }

    /**
     * @param time
     * @param structured
     */
    public ControlFlow(AcceptTimeEventAction time, StructuredActivityNode structured)
    {
        this();
        this.setAcceptTimeEventTerminal1(time);
        this.setStructuredActivityTerminal2(structured);
    }

    /**
     * @param loop
     * @param loop
     */
    public ControlFlow(LoopNode loop, LoopNode loop2)
    {
        this();
        this.setLoopTerminal1(loop);
        this.setLoopTerminal2(loop2);
    }

    /**
     * @param sequence
     * @param loop
     */
    public ControlFlow(SequenceNode sequence, LoopNode loop)
    {
        this();
        this.setSequenceTerminal1(sequence);
        this.setLoopTerminal2(loop);
    }

    /**
     * @param loop
     * @param sequence
     */
    public ControlFlow(LoopNode loop, SequenceNode sequence)
    {
        this();
        this.setLoopTerminal1(loop);
        this.setSequenceTerminal2(sequence);
    }

    /**
     * @param conditional
     * @param loop
     */
    public ControlFlow(ConditionalNode conditional, LoopNode loop)
    {
        this();
        this.setConditionalTerminal1(conditional);
        this.setLoopTerminal2(loop);
    }

    /**
     * @param loop
     * @param conditional
     */
    public ControlFlow(LoopNode loop, ConditionalNode conditional)
    {
        this();
        this.setLoopTerminal1(loop);
        this.setConditionalTerminal2(conditional);
    }

    /**
     * @param structured
     * @param loop
     */
    public ControlFlow(StructuredActivityNode structured, LoopNode loop)
    {
        this();
        this.setStructuredActivityTerminal1(structured);
        this.setLoopTerminal2(loop);
    }

    /**
     * @param loop
     * @param structured
     */
    public ControlFlow(LoopNode loop, StructuredActivityNode structured)
    {
        this();
        this.setLoopTerminal1(loop);
        this.setStructuredActivityTerminal2(structured);
    }

    /**
     * @param sequence
     * @param sequence2
     */
    public ControlFlow(SequenceNode sequence, SequenceNode sequence2)
    {
        this();
        this.setSequenceTerminal1(sequence);
        this.setSequenceTerminal2(sequence2);
    }

    /**
     * @param conditional
     * @param sequence
     */
    public ControlFlow(ConditionalNode conditional, SequenceNode sequence)
    {
        this();
        this.setConditionalTerminal1(conditional);
        this.setSequenceTerminal2(sequence);
    }

    /**
     * @param sequence
     * @param conditional
     */
    public ControlFlow(SequenceNode sequence, ConditionalNode conditional)
    {
        this();
        this.setSequenceTerminal1(sequence);
        this.setConditionalTerminal2(conditional);
    }

    /**
     * @param structured
     * @param sequence
     */
    public ControlFlow(StructuredActivityNode structured, SequenceNode sequence)
    {
        this();
        this.setStructuredActivityTerminal1(structured);
        this.setSequenceTerminal2(sequence);
    }

    /**
     * @param sequence
     * @param structured
     */
    public ControlFlow(SequenceNode sequence, StructuredActivityNode structured)
    {
        this();
        this.setSequenceTerminal1(sequence);
        this.setStructuredActivityTerminal2(structured);
    }

    /**
     * @param conditional
     * @param conditional2
     */
    public ControlFlow(ConditionalNode conditional, ConditionalNode conditional2)
    {
        this();
        this.setConditionalTerminal1(conditional);
        this.setConditionalTerminal2(conditional2);
    }

    /**
     * @param structured
     * @param conditional
     */
    public ControlFlow(StructuredActivityNode structured, ConditionalNode conditional)
    {
        this();
        this.setStructuredActivityTerminal1(structured);
        this.setConditionalTerminal2(conditional);
    }

    /**
     * @param conditional
     * @param structured
     */
    public ControlFlow(ConditionalNode conditional, StructuredActivityNode structured)
    {
        this();
        this.setConditionalTerminal1(conditional);
        this.setStructuredActivityTerminal2(structured);
    }

    /**
     * @param structured
     * @param structured2
     */
    public ControlFlow(StructuredActivityNode structured, StructuredActivityNode structured2)
    {
        this();
        this.setStructuredActivityTerminal1(structured);
        this.setStructuredActivityTerminal2(structured2);
    }

    /**
     * @param assignment1
     * @param assignment2
     */
    public ControlFlow(Assignment assignment1, Assignment assignment2)
    {
        this();
        this.setAssignmentTerminal1(assignment1);
        this.setAssignmentTerminal2(assignment2);
    }

    /**
     * @param assignment1
     * @param assignment2
     */
    public ControlFlow(Assignment assignment1, Return return1)
    {
        this();
        this.setAssignmentTerminal1(assignment1);
        this.setReturnTerminal2(return1);
    }

    /**
     * @param assignment1
     * @param assignment2
     */
    public ControlFlow(Return return1, Assignment assignment1)
    {
        this();
        this.setReturnTerminal1(return1);
        this.setAssignmentTerminal2(assignment1);
    }

    /**
     * @param assignment1
     * @param message
     */
    public ControlFlow(Assignment assignment1, Message message)
    {
        this();
        this.setAssignmentTerminal1(assignment1);
        this.setMessageTerminal2(message);
    }

    /**
     * @param message
     * @param assignment1
     */
    public ControlFlow(Message message, Assignment assignment1)
    {
        this();
        this.setMessageTerminal1(message);
        this.setAssignmentTerminal2(assignment1);
    }

    /**
     * @param assignment1
     * @param task
     */
    public ControlFlow(Assignment assignment1, TaskPackage task)
    {
        this();
        this.setAssignmentTerminal1(assignment1);
        this.setTaskTerminal2(task);
    }

    /**
     * @param task
     * @param assignment1
     */
    public ControlFlow(TaskPackage task, Assignment assignment1)
    {
        this();
        this.setTaskTerminal1(task);
        this.setAssignmentTerminal2(assignment1);
    }

    /**
     * @param assignment1
     * @param task
     */
    public ControlFlow(Assignment assignment1, GenericTask task)
    {
        this();
        this.setAssignmentTerminal1(assignment1);
        this.setGenericTerminal2(task);
    }

    /**
     * @param task
     * @param assignment1
     */
    public ControlFlow(GenericTask task, Assignment assignment1)
    {
        this();
        this.setGenericTerminal1(task);
        this.setAssignmentTerminal2(assignment1);
    }

    /**
     * @param return1
     * @param return2
     */
    public ControlFlow(Return return1, Return return2)
    {
        this();
        this.setReturnTerminal1(return1);
        this.setReturnTerminal2(return2);
    }

    /**
     * @param return1
     * @param message
     */
    public ControlFlow(Return return1, Message message)
    {
        this();
        this.setReturnTerminal1(return1);
        this.setMessageTerminal2(message);
    }

    /**
     * @param message
     * @param return1
     */
    public ControlFlow(Message message, Return return1)
    {
        this();
        this.setMessageTerminal1(message);
        this.setReturnTerminal2(return1);
    }

    /**
     * @param return1
     * @param task
     */
    public ControlFlow(Return return1, TaskPackage task)
    {
        this();
        this.setReturnTerminal1(return1);
        this.setTaskTerminal2(task);
    }

    /**
     * @param task
     * @param return1
     */
    public ControlFlow(TaskPackage task, Return return1)
    {
        this();
        this.setTaskTerminal1(task);
        this.setReturnTerminal2(return1);
    }

    /**
     * @param return1
     * @param task
     */
    public ControlFlow(Return return1, GenericTask task)
    {
        this();
        this.setReturnTerminal1(return1);
        this.setGenericTerminal2(task);
    }

    /**
     * @param task
     * @param return1
     */
    public ControlFlow(GenericTask task, Return return1)
    {
        this();
        this.setGenericTerminal1(task);
        this.setReturnTerminal2(return1);
    }

    /**
     * @param message1
     * @param message2
     */
    public ControlFlow(Message message1, Message message2)
    {
        this();
        this.setMessageTerminal1(message1);
        this.setMessageTerminal2(message2);
    }

    /**
     * @param message1
     * @param task
     */
    public ControlFlow(Message message1, TaskPackage task)
    {
        this();
        this.setMessageTerminal1(message1);
        this.setTaskTerminal2(task);
    }

    /**
     * @param task
     * @param message1
     */
    public ControlFlow(TaskPackage task, Message message1)
    {
        this();
        this.setTaskTerminal1(task);
        this.setMessageTerminal2(message1);
    }

    /**
     * @param message1
     * @param task
     */
    public ControlFlow(Message message1, GenericTask task)
    {
        this();
        this.setMessageTerminal1(message1);
        this.setGenericTerminal2(task);
    }

    /**
     * @param task
     * @param message1
     */
    public ControlFlow(GenericTask task, Message message1)
    {
        this();
        this.setGenericTerminal1(task);
        this.setMessageTerminal2(message1);
    }

    /**
     * @param taskPackage1
     * @param taskPackage2
     */
    public ControlFlow(TaskPackage taskPackage1, TaskPackage taskPackage2)
    {
        this();
        this.setTaskTerminal1(taskPackage1);
        this.setTaskTerminal2(taskPackage2);
    }

    /**
     * @param taskPackage
     * @param task
     */
    public ControlFlow(TaskPackage taskPackage, GenericTask task)
    {
        this();
        this.setTaskTerminal1(taskPackage);
        this.setGenericTerminal2(task);
    }

    /**
     * @param task
     * @param taskPackage
     */
    public ControlFlow(GenericTask task, TaskPackage taskPackage)
    {
        this();
        this.setGenericTerminal1(task);
        this.setTaskTerminal2(taskPackage);
    }

    /**
     * @param task
     * @param task2
     */
    public ControlFlow(GenericTask task, GenericTask task2)
    {
        this();
        this.setGenericTerminal1(task);
        this.setGenericTerminal2(task2);
    }

    /**
     * @param initial
     * @param assignment
     */
    public ControlFlow(InitialNode initial, Assignment assignment)
    {
        this();
        this.setInitialTerminal1(initial);
        this.setAssignmentTerminal2(assignment);
    }

    /**
     * @param assignment
     * @param finalNode
     */
    public ControlFlow(Assignment assignment, FinalNode finalNode)
    {
        this();
        this.setAssignmentTerminal1(assignment);
        this.setFinalTerminal2(finalNode);
    }

    /**
     * @param assignment
     * @param finalNode
     */
    public ControlFlow(Assignment assignment, FlowFinalNode finalNode)
    {
        this();
        this.setAssignmentTerminal1(assignment);
        this.setFlowFinalTerminal2(finalNode);
    }

    /**
     * @param assignment
     * @param activity
     */
    public ControlFlow(Assignment assignment, Activity activity)
    {
        this.setAssignmentTerminal1(assignment);
        this.setActivityTerminal2(activity);
    }

    /**
     * @param activity
     * @param assignment
     */
    public ControlFlow(Activity activity, Assignment assignment)
    {
        this.setActivityTerminal1(activity);
        this.setAssignmentTerminal2(assignment);
    }

    /**
     * @param assignment
     * @param decision
     */
    public ControlFlow(Assignment assignment, DecisionNode decision)
    {
        this.setAssignmentTerminal1(assignment);
        this.setDecisionTerminal2(decision);
    }

    /**
     * @param decision
     * @param assignment
     */
    public ControlFlow(DecisionNode decision, Assignment assignment)
    {
        this.setDecisionTerminal1(decision);
        this.setAssignmentTerminal2(assignment);
    }

    /**
     * @param assignment
     * @param merge
     */
    public ControlFlow(Assignment assignment, MergeNode merge)
    {
        this.setAssignmentTerminal1(assignment);
        this.setMergeTerminal2(merge);
    }

    /**
     * @param merge
     * @param assignment
     */
    public ControlFlow(MergeNode merge, Assignment assignment)
    {
        this.setMergeTerminal1(merge);
        this.setAssignmentTerminal2(assignment);
    }

    /**
     * @param assignment
     * @param fork
     */
    public ControlFlow(Assignment assignment, ForkNode fork)
    {
        this.setAssignmentTerminal1(assignment);
        this.setForkTerminal2(fork);
    }

    /**
     * @param fork
     * @param assignment
     */
    public ControlFlow(ForkNode fork, Assignment assignment)
    {
        this.setForkTerminal1(fork);
        this.setAssignmentTerminal2(assignment);
    }

    /**
     * @param assignment
     * @param join
     */
    public ControlFlow(Assignment assignment, JoinNode join)
    {
        this.setAssignmentTerminal1(assignment);
        this.setJoinTerminal2(join);
    }

    /**
     * @param join
     * @param assignment
     */
    public ControlFlow(JoinNode join, Assignment assignment)
    {
        this.setJoinTerminal1(join);
        this.setAssignmentTerminal2(assignment);
    }

    /**
     * @param assignment
     * @param action
     */
    public ControlFlow(Assignment assignment, Action action)
    {
        this.setAssignmentTerminal1(assignment);
        this.setActionTerminal2(action);
    }

    /**
     * @param action
     * @param assignment
     */
    public ControlFlow(Action action, Assignment assignment)
    {
        this.setActionTerminal1(action);
        this.setAssignmentTerminal2(assignment);
    }

    /**
     * @param assignment
     * @param send
     */
    public ControlFlow(Assignment assignment, SendSignal send)
    {
        this.setAssignmentTerminal1(assignment);
        this.setSendSignalTerminal2(send);
    }

    /**
     * @param send
     * @param assignment
     */
    public ControlFlow(SendSignal send, Assignment assignment)
    {
        this.setSendSignalTerminal1(send);
        this.setAssignmentTerminal2(assignment);
    }

    /**
     * @param assignment
     * @param action
     */
    public ControlFlow(Assignment assignment, AcceptEventAction action)
    {
        this.setAssignmentTerminal1(assignment);
        this.setAcceptEventTerminal2(action);
    }

    /**
     * @param action
     * @param assignment
     */
    public ControlFlow(AcceptEventAction action, Assignment assignment)
    {
        this.setAcceptEventTerminal1(action);
        this.setAssignmentTerminal2(assignment);
    }

    /**
     * @param assignment
     * @param action
     */
    public ControlFlow(Assignment assignment, AcceptTimeEventAction action)
    {
        this.setAssignmentTerminal1(assignment);
        this.setAcceptTimeEventTerminal2(action);
    }

    /**
     * @param action
     * @param assignment
     */
    public ControlFlow(AcceptTimeEventAction action, Assignment assignment)
    {
        this.setAcceptTimeEventTerminal1(action);
        this.setAssignmentTerminal2(assignment);
    }

    /**
     * @param assignment
     * @param node
     */
    public ControlFlow(Assignment assignment, LoopNode node)
    {
        this.setAssignmentTerminal1(assignment);
        this.setLoopTerminal2(node);
    }

    /**
     * @param node
     * @param assignment
     */
    public ControlFlow(LoopNode node, Assignment assignment)
    {
        this.setLoopTerminal1(node);
        this.setAssignmentTerminal2(assignment);
    }

    /**
     * @param assignment
     * @param node
     */
    public ControlFlow(Assignment assignment, SequenceNode node)
    {
        this.setAssignmentTerminal1(assignment);
        this.setSequenceTerminal2(node);
    }

    /**
     * @param node
     * @param assignment
     */
    public ControlFlow(SequenceNode node, Assignment assignment)
    {
        this.setSequenceTerminal1(node);
        this.setAssignmentTerminal2(assignment);
    }

    /**
     * @param assignment
     * @param node
     */
    public ControlFlow(Assignment assignment, ConditionalNode node)
    {
        this.setAssignmentTerminal1(assignment);
        this.setConditionalTerminal2(node);
    }

    /**
     * @param node
     * @param assignment
     */
    public ControlFlow(ConditionalNode node, Assignment assignment)
    {
        this.setConditionalTerminal1(node);
        this.setAssignmentTerminal2(assignment);
    }

    /**
     * @param assignment
     * @param node
     */
    public ControlFlow(Assignment assignment, StructuredActivityNode node)
    {
        this.setAssignmentTerminal1(assignment);
        this.setStructuredActivityTerminal2(node);
    }

    /**
     * @param node
     * @param assignment
     */
    public ControlFlow(StructuredActivityNode node, Assignment assignment)
    {
        this.setStructuredActivityTerminal1(node);
        this.setAssignmentTerminal2(assignment);
    }

    /**
     * @param initial
     * @param return1
     */
    public ControlFlow(InitialNode initial, Return return1)
    {
        this();
        this.setInitialTerminal1(initial);
        this.setReturnTerminal2(return1);
    }

    /**
     * @param return1
     * @param finalNode
     */
    public ControlFlow(Return return1, FinalNode finalNode)
    {
        this();
        this.setReturnTerminal1(return1);
        this.setFinalTerminal2(finalNode);
    }

    /**
     * @param return1
     * @param finalNode
     */
    public ControlFlow(Return return1, FlowFinalNode finalNode)
    {
        this();
        this.setReturnTerminal1(return1);
        this.setFlowFinalTerminal2(finalNode);
    }

    /**
     * @param return1
     * @param activity
     */
    public ControlFlow(Return return1, Activity activity)
    {
        this.setReturnTerminal1(return1);
        this.setActivityTerminal2(activity);
    }

    /**
     * @param activity
     * @param return1
     */
    public ControlFlow(Activity activity, Return return1)
    {
        this.setActivityTerminal1(activity);
        this.setReturnTerminal2(return1);
    }

    /**
     * @param return1
     * @param decision
     */
    public ControlFlow(Return return1, DecisionNode decision)
    {
        this.setReturnTerminal1(return1);
        this.setDecisionTerminal2(decision);
    }

    /**
     * @param decision
     * @param return1
     */
    public ControlFlow(DecisionNode decision, Return return1)
    {
        this.setDecisionTerminal1(decision);
        this.setReturnTerminal2(return1);
    }

    /**
     * @param return1
     * @param merge
     */
    public ControlFlow(Return return1, MergeNode merge)
    {
        this.setReturnTerminal1(return1);
        this.setMergeTerminal2(merge);
    }

    /**
     * @param merge
     * @param return1
     */
    public ControlFlow(MergeNode merge, Return return1)
    {
        this.setMergeTerminal1(merge);
        this.setReturnTerminal2(return1);
    }

    /**
     * @param return1
     * @param fork
     */
    public ControlFlow(Return return1, ForkNode fork)
    {
        this.setReturnTerminal1(return1);
        this.setForkTerminal2(fork);
    }

    /**
     * @param fork
     * @param return1
     */
    public ControlFlow(ForkNode fork, Return return1)
    {
        this.setForkTerminal1(fork);
        this.setReturnTerminal2(return1);
    }

    /**
     * @param return1
     * @param join
     */
    public ControlFlow(Return return1, JoinNode join)
    {
        this.setReturnTerminal1(return1);
        this.setJoinTerminal2(join);
    }

    /**
     * @param join
     * @param return1
     */
    public ControlFlow(JoinNode join, Return return1)
    {
        this.setJoinTerminal1(join);
        this.setReturnTerminal2(return1);
    }

    /**
     * @param return1
     * @param action
     */
    public ControlFlow(Return return1, Action action)
    {
        this.setReturnTerminal1(return1);
        this.setActionTerminal2(action);
    }

    /**
     * @param action
     * @param return1
     */
    public ControlFlow(Action action, Return return1)
    {
        this.setActionTerminal1(action);
        this.setReturnTerminal2(return1);
    }

    /**
     * @param return1
     * @param send
     */
    public ControlFlow(Return return1, SendSignal send)
    {
        this.setReturnTerminal1(return1);
        this.setSendSignalTerminal2(send);
    }

    /**
     * @param send
     * @param return1
     */
    public ControlFlow(SendSignal send, Return return1)
    {
        this.setSendSignalTerminal1(send);
        this.setReturnTerminal2(return1);
    }

    /**
     * @param return1
     * @param action
     */
    public ControlFlow(Return return1, AcceptEventAction action)
    {
        this.setReturnTerminal1(return1);
        this.setAcceptEventTerminal2(action);
    }

    /**
     * @param action
     * @param return1
     */
    public ControlFlow(AcceptEventAction action, Return return1)
    {
        this.setAcceptEventTerminal1(action);
        this.setReturnTerminal2(return1);
    }

    /**
     * @param return1
     * @param action
     */
    public ControlFlow(Return return1, AcceptTimeEventAction action)
    {
        this.setReturnTerminal1(return1);
        this.setAcceptTimeEventTerminal2(action);
    }

    /**
     * @param action
     * @param return1
     */
    public ControlFlow(AcceptTimeEventAction action, Return return1)
    {
        this.setAcceptTimeEventTerminal1(action);
        this.setReturnTerminal2(return1);
    }

    /**
     * @param return1
     * @param node
     */
    public ControlFlow(Return return1, LoopNode node)
    {
        this.setReturnTerminal1(return1);
        this.setLoopTerminal2(node);
    }

    /**
     * @param node
     * @param return1
     */
    public ControlFlow(LoopNode node, Return return1)
    {
        this.setLoopTerminal1(node);
        this.setReturnTerminal2(return1);
    }

    /**
     * @param return1
     * @param node
     */
    public ControlFlow(Return return1, SequenceNode node)
    {
        this.setReturnTerminal1(return1);
        this.setSequenceTerminal2(node);
    }

    /**
     * @param node
     * @param return1
     */
    public ControlFlow(SequenceNode node, Return return1)
    {
        this.setSequenceTerminal1(node);
        this.setReturnTerminal2(return1);
    }

    /**
     * @param return1
     * @param node
     */
    public ControlFlow(Return return1, ConditionalNode node)
    {
        this.setReturnTerminal1(return1);
        this.setConditionalTerminal2(node);
    }

    /**
     * @param node
     * @param return1
     */
    public ControlFlow(ConditionalNode node, Return return1)
    {
        this.setConditionalTerminal1(node);
        this.setReturnTerminal2(return1);
    }

    /**
     * @param return1
     * @param node
     */
    public ControlFlow(Return return1, StructuredActivityNode node)
    {
        this.setReturnTerminal1(return1);
        this.setStructuredActivityTerminal2(node);
    }

    /**
     * @param node
     * @param return1
     */
    public ControlFlow(StructuredActivityNode node, Return return1)
    {
        this.setStructuredActivityTerminal1(node);
        this.setReturnTerminal2(return1);
    }

    /**
     * @param initial
     * @param message
     */
    public ControlFlow(InitialNode initial, Message message)
    {
        this();
        this.setInitialTerminal1(initial);
        this.setMessageTerminal2(message);
    }

    /**
     * @param message
     * @param finalNode
     */
    public ControlFlow(Message message, FinalNode finalNode)
    {
        this();
        this.setMessageTerminal1(message);
        this.setFinalTerminal2(finalNode);
    }

    /**
     * @param message
     * @param finalNode
     */
    public ControlFlow(Message message, FlowFinalNode finalNode)
    {
        this();
        this.setMessageTerminal1(message);
        this.setFlowFinalTerminal2(finalNode);
    }

    /**
     * @param message
     * @param activity
     */
    public ControlFlow(Message message, Activity activity)
    {
        this.setMessageTerminal1(message);
        this.setActivityTerminal2(activity);
    }

    /**
     * @param activity
     * @param message
     */
    public ControlFlow(Activity activity, Message message)
    {
        this.setActivityTerminal1(activity);
        this.setMessageTerminal2(message);
    }

    /**
     * @param message
     * @param decision
     */
    public ControlFlow(Message message, DecisionNode decision)
    {
        this.setMessageTerminal1(message);
        this.setDecisionTerminal2(decision);
    }

    /**
     * @param decision
     * @param message
     */
    public ControlFlow(DecisionNode decision, Message message)
    {
        this.setDecisionTerminal1(decision);
        this.setMessageTerminal2(message);
    }

    /**
     * @param message
     * @param merge
     */
    public ControlFlow(Message message, MergeNode merge)
    {
        this.setMessageTerminal1(message);
        this.setMergeTerminal2(merge);
    }

    /**
     * @param merge
     * @param message
     */
    public ControlFlow(MergeNode merge, Message message)
    {
        this.setMergeTerminal1(merge);
        this.setMessageTerminal2(message);
    }

    /**
     * @param message
     * @param fork
     */
    public ControlFlow(Message message, ForkNode fork)
    {
        this.setMessageTerminal1(message);
        this.setForkTerminal2(fork);
    }

    /**
     * @param fork
     * @param message
     */
    public ControlFlow(ForkNode fork, Message message)
    {
        this.setForkTerminal1(fork);
        this.setMessageTerminal2(message);
    }

    /**
     * @param message
     * @param join
     */
    public ControlFlow(Message message, JoinNode join)
    {
        this.setMessageTerminal1(message);
        this.setJoinTerminal2(join);
    }

    /**
     * @param join
     * @param message
     */
    public ControlFlow(JoinNode join, Message message)
    {
        this.setJoinTerminal1(join);
        this.setMessageTerminal2(message);
    }

    /**
     * @param message
     * @param action
     */
    public ControlFlow(Message message, Action action)
    {
        this.setMessageTerminal1(message);
        this.setActionTerminal2(action);
    }

    /**
     * @param action
     * @param message
     */
    public ControlFlow(Action action, Message message)
    {
        this.setActionTerminal1(action);
        this.setMessageTerminal2(message);
    }

    /**
     * @param message
     * @param send
     */
    public ControlFlow(Message message, SendSignal send)
    {
        this.setMessageTerminal1(message);
        this.setSendSignalTerminal2(send);
    }

    /**
     * @param send
     * @param message
     */
    public ControlFlow(SendSignal send, Message message)
    {
        this.setSendSignalTerminal1(send);
        this.setMessageTerminal2(message);
    }

    /**
     * @param message
     * @param action
     */
    public ControlFlow(Message message, AcceptEventAction action)
    {
        this.setMessageTerminal1(message);
        this.setAcceptEventTerminal2(action);
    }

    /**
     * @param action
     * @param message
     */
    public ControlFlow(AcceptEventAction action, Message message)
    {
        this.setAcceptEventTerminal1(action);
        this.setMessageTerminal2(message);
    }

    /**
     * @param message
     * @param action
     */
    public ControlFlow(Message message, AcceptTimeEventAction action)
    {
        this.setMessageTerminal1(message);
        this.setAcceptTimeEventTerminal2(action);
    }

    /**
     * @param action
     * @param message
     */
    public ControlFlow(AcceptTimeEventAction action, Message message)
    {
        this.setAcceptTimeEventTerminal1(action);
        this.setMessageTerminal2(message);
    }

    /**
     * @param message
     * @param node
     */
    public ControlFlow(Message message, LoopNode node)
    {
        this.setMessageTerminal1(message);
        this.setLoopTerminal2(node);
    }

    /**
     * @param node
     * @param message
     */
    public ControlFlow(LoopNode node, Message message)
    {
        this.setLoopTerminal1(node);
        this.setMessageTerminal2(message);
    }

    /**
     * @param message
     * @param node
     */
    public ControlFlow(Message message, SequenceNode node)
    {
        this.setMessageTerminal1(message);
        this.setSequenceTerminal2(node);
    }

    /**
     * @param node
     * @param message
     */
    public ControlFlow(SequenceNode node, Message message)
    {
        this.setSequenceTerminal1(node);
        this.setMessageTerminal2(message);
    }

    /**
     * @param message
     * @param node
     */
    public ControlFlow(Message message, ConditionalNode node)
    {
        this.setMessageTerminal1(message);
        this.setConditionalTerminal2(node);
    }

    /**
     * @param node
     * @param message
     */
    public ControlFlow(ConditionalNode node, Message message)
    {
        this.setConditionalTerminal1(node);
        this.setMessageTerminal2(message);
    }

    /**
     * @param message
     * @param node
     */
    public ControlFlow(Message message, StructuredActivityNode node)
    {
        this.setMessageTerminal1(message);
        this.setStructuredActivityTerminal2(node);
    }

    /**
     * @param node
     * @param message
     */
    public ControlFlow(StructuredActivityNode node, Message message)
    {
        this.setStructuredActivityTerminal1(node);
        this.setMessageTerminal2(message);
    }

    /**
     * @param initial
     * @param task
     */
    public ControlFlow(InitialNode initial, TaskPackage task)
    {
        this();
        this.setInitialTerminal1(initial);
        this.setTaskTerminal2(task);
    }

    /**
     * @param task
     * @param finalNode
     */
    public ControlFlow(TaskPackage task, FinalNode finalNode)
    {
        this();
        this.setTaskTerminal1(task);
        this.setFinalTerminal2(finalNode);
    }

    /**
     * @param task
     * @param finalNode
     */
    public ControlFlow(TaskPackage task, FlowFinalNode finalNode)
    {
        this();
        this.setTaskTerminal1(task);
        this.setFlowFinalTerminal2(finalNode);
    }

    /**
     * @param task
     * @param activity
     */
    public ControlFlow(TaskPackage task, Activity activity)
    {
        this.setTaskTerminal1(task);
        this.setActivityTerminal2(activity);
    }

    /**
     * @param activity
     * @param task
     */
    public ControlFlow(Activity activity, TaskPackage task)
    {
        this.setActivityTerminal1(activity);
        this.setTaskTerminal2(task);
    }

    /**
     * @param task
     * @param decision
     */
    public ControlFlow(TaskPackage task, DecisionNode decision)
    {
        this.setTaskTerminal1(task);
        this.setDecisionTerminal2(decision);
    }

    /**
     * @param decision
     * @param task
     */
    public ControlFlow(DecisionNode decision, TaskPackage task)
    {
        this.setDecisionTerminal1(decision);
        this.setTaskTerminal2(task);
    }

    /**
     * @param task
     * @param merge
     */
    public ControlFlow(TaskPackage task, MergeNode merge)
    {
        this.setTaskTerminal1(task);
        this.setMergeTerminal2(merge);
    }

    /**
     * @param merge
     * @param task
     */
    public ControlFlow(MergeNode merge, TaskPackage task)
    {
        this.setMergeTerminal1(merge);
        this.setTaskTerminal2(task);
    }

    /**
     * @param task
     * @param fork
     */
    public ControlFlow(TaskPackage task, ForkNode fork)
    {
        this.setTaskTerminal1(task);
        this.setForkTerminal2(fork);
    }

    /**
     * @param fork
     * @param task
     */
    public ControlFlow(ForkNode fork, TaskPackage task)
    {
        this.setForkTerminal1(fork);
        this.setTaskTerminal2(task);
    }

    /**
     * @param task
     * @param join
     */
    public ControlFlow(TaskPackage task, JoinNode join)
    {
        this.setTaskTerminal1(task);
        this.setJoinTerminal2(join);
    }

    /**
     * @param join
     * @param task
     */
    public ControlFlow(JoinNode join, TaskPackage task)
    {
        this.setJoinTerminal1(join);
        this.setTaskTerminal2(task);
    }

    /**
     * @param task
     * @param action
     */
    public ControlFlow(TaskPackage task, Action action)
    {
        this.setTaskTerminal1(task);
        this.setActionTerminal2(action);
    }

    /**
     * @param action
     * @param task
     */
    public ControlFlow(Action action, TaskPackage task)
    {
        this.setActionTerminal1(action);
        this.setTaskTerminal2(task);
    }

    /**
     * @param task
     * @param send
     */
    public ControlFlow(TaskPackage task, SendSignal send)
    {
        this.setTaskTerminal1(task);
        this.setSendSignalTerminal2(send);
    }

    /**
     * @param send
     * @param task
     */
    public ControlFlow(SendSignal send, TaskPackage task)
    {
        this.setSendSignalTerminal1(send);
        this.setTaskTerminal2(task);
    }

    /**
     * @param task
     * @param action
     */
    public ControlFlow(TaskPackage task, AcceptEventAction action)
    {
        this.setTaskTerminal1(task);
        this.setAcceptEventTerminal2(action);
    }

    /**
     * @param action
     * @param task
     */
    public ControlFlow(AcceptEventAction action, TaskPackage task)
    {
        this.setAcceptEventTerminal1(action);
        this.setTaskTerminal2(task);
    }

    /**
     * @param task
     * @param action
     */
    public ControlFlow(TaskPackage task, AcceptTimeEventAction action)
    {
        this.setTaskTerminal1(task);
        this.setAcceptTimeEventTerminal2(action);
    }

    /**
     * @param action
     * @param task
     */
    public ControlFlow(AcceptTimeEventAction action, TaskPackage task)
    {
        this.setAcceptTimeEventTerminal1(action);
        this.setTaskTerminal2(task);
    }

    /**
     * @param task
     * @param node
     */
    public ControlFlow(TaskPackage task, LoopNode node)
    {
        this.setTaskTerminal1(task);
        this.setLoopTerminal2(node);
    }

    /**
     * @param node
     * @param task
     */
    public ControlFlow(LoopNode node, TaskPackage task)
    {
        this.setLoopTerminal1(node);
        this.setTaskTerminal2(task);
    }

    /**
     * @param task
     * @param node
     */
    public ControlFlow(TaskPackage task, SequenceNode node)
    {
        this.setTaskTerminal1(task);
        this.setSequenceTerminal2(node);
    }

    /**
     * @param node
     * @param task
     */
    public ControlFlow(SequenceNode node, TaskPackage task)
    {
        this.setSequenceTerminal1(node);
        this.setTaskTerminal2(task);
    }

    /**
     * @param task
     * @param node
     */
    public ControlFlow(TaskPackage task, ConditionalNode node)
    {
        this.setTaskTerminal1(task);
        this.setConditionalTerminal2(node);
    }

    /**
     * @param node
     * @param task
     */
    public ControlFlow(ConditionalNode node, TaskPackage task)
    {
        this.setConditionalTerminal1(node);
        this.setTaskTerminal2(task);
    }

    /**
     * @param task
     * @param node
     */
    public ControlFlow(TaskPackage task, StructuredActivityNode node)
    {
        this.setTaskTerminal1(task);
        this.setStructuredActivityTerminal2(node);
    }

    /**
     * @param node
     * @param task
     */
    public ControlFlow(StructuredActivityNode node, TaskPackage task)
    {
        this.setStructuredActivityTerminal1(node);
        this.setTaskTerminal2(task);
    }

    /**
     * @param initial
     * @param task
     */
    public ControlFlow(InitialNode initial, GenericTask task)
    {
        this();
        this.setInitialTerminal1(initial);
        this.setGenericTerminal2(task);
    }

    /**
     * @param task
     * @param finalNode
     */
    public ControlFlow(GenericTask task, FinalNode finalNode)
    {
        this();
        this.setGenericTerminal1(task);
        this.setFinalTerminal2(finalNode);
    }

    /**
     * @param task
     * @param finalNode
     */
    public ControlFlow(GenericTask task, FlowFinalNode finalNode)
    {
        this();
        this.setGenericTerminal1(task);
        this.setFlowFinalTerminal2(finalNode);
    }

    /**
     * @param task
     * @param activity
     */
    public ControlFlow(GenericTask task, Activity activity)
    {
        this.setGenericTerminal1(task);
        this.setActivityTerminal2(activity);
    }

    /**
     * @param activity
     * @param task
     */
    public ControlFlow(Activity activity, GenericTask task)
    {
        this.setActivityTerminal1(activity);
        this.setGenericTerminal2(task);
    }

    /**
     * @param task
     * @param decision
     */
    public ControlFlow(GenericTask task, DecisionNode decision)
    {
        this.setGenericTerminal1(task);
        this.setDecisionTerminal2(decision);
    }

    /**
     * @param decision
     * @param task
     */
    public ControlFlow(DecisionNode decision, GenericTask task)
    {
        this.setDecisionTerminal1(decision);
        this.setGenericTerminal2(task);
    }

    /**
     * @param task
     * @param merge
     */
    public ControlFlow(GenericTask task, MergeNode merge)
    {
        this.setGenericTerminal1(task);
        this.setMergeTerminal2(merge);
    }

    /**
     * @param merge
     * @param task
     */
    public ControlFlow(MergeNode merge, GenericTask task)
    {
        this.setMergeTerminal1(merge);
        this.setGenericTerminal2(task);
    }

    /**
     * @param task
     * @param fork
     */
    public ControlFlow(GenericTask task, ForkNode fork)
    {
        this.setGenericTerminal1(task);
        this.setForkTerminal2(fork);
    }

    /**
     * @param fork
     * @param task
     */
    public ControlFlow(ForkNode fork, GenericTask task)
    {
        this.setForkTerminal1(fork);
        this.setGenericTerminal2(task);
    }

    /**
     * @param task
     * @param join
     */
    public ControlFlow(GenericTask task, JoinNode join)
    {
        this.setGenericTerminal1(task);
        this.setJoinTerminal2(join);
    }

    /**
     * @param join
     * @param task
     */
    public ControlFlow(JoinNode join, GenericTask task)
    {
        this.setJoinTerminal1(join);
        this.setGenericTerminal2(task);
    }

    /**
     * @param task
     * @param action
     */
    public ControlFlow(GenericTask task, Action action)
    {
        this.setGenericTerminal1(task);
        this.setActionTerminal2(action);
    }

    /**
     * @param action
     * @param task
     */
    public ControlFlow(Action action, GenericTask task)
    {
        this.setActionTerminal1(action);
        this.setGenericTerminal2(task);
    }

    /**
     * @param task
     * @param send
     */
    public ControlFlow(GenericTask task, SendSignal send)
    {
        this.setGenericTerminal1(task);
        this.setSendSignalTerminal2(send);
    }

    /**
     * @param send
     * @param task
     */
    public ControlFlow(SendSignal send, GenericTask task)
    {
        this.setSendSignalTerminal1(send);
        this.setGenericTerminal2(task);
    }

    /**
     * @param task
     * @param action
     */
    public ControlFlow(GenericTask task, AcceptEventAction action)
    {
        this.setGenericTerminal1(task);
        this.setAcceptEventTerminal2(action);
    }

    /**
     * @param action
     * @param task
     */
    public ControlFlow(AcceptEventAction action, GenericTask task)
    {
        this.setAcceptEventTerminal1(action);
        this.setGenericTerminal2(task);
    }

    /**
     * @param task
     * @param action
     */
    public ControlFlow(GenericTask task, AcceptTimeEventAction action)
    {
        this.setGenericTerminal1(task);
        this.setAcceptTimeEventTerminal2(action);
    }

    /**
     * @param action
     * @param task
     */
    public ControlFlow(AcceptTimeEventAction action, GenericTask task)
    {
        this.setAcceptTimeEventTerminal1(action);
        this.setGenericTerminal2(task);
    }

    /**
     * @param task
     * @param node
     */
    public ControlFlow(GenericTask task, LoopNode node)
    {
        this.setGenericTerminal1(task);
        this.setLoopTerminal2(node);
    }

    /**
     * @param node
     * @param task
     */
    public ControlFlow(LoopNode node, GenericTask task)
    {
        this.setLoopTerminal1(node);
        this.setGenericTerminal2(task);
    }

    /**
     * @param task
     * @param node
     */
    public ControlFlow(GenericTask task, SequenceNode node)
    {
        this.setGenericTerminal1(task);
        this.setSequenceTerminal2(node);
    }

    /**
     * @param node
     * @param task
     */
    public ControlFlow(SequenceNode node, GenericTask task)
    {
        this.setSequenceTerminal1(node);
        this.setGenericTerminal2(task);
    }

    /**
     * @param task
     * @param node
     */
    public ControlFlow(GenericTask task, ConditionalNode node)
    {
        this.setGenericTerminal1(task);
        this.setConditionalTerminal2(node);
    }

    /**
     * @param node
     * @param task
     */
    public ControlFlow(ConditionalNode node, GenericTask task)
    {
        this.setConditionalTerminal1(node);
        this.setGenericTerminal2(task);
    }

    /**
     * @param task
     * @param node
     */
    public ControlFlow(GenericTask task, StructuredActivityNode node)
    {
        this.setGenericTerminal1(task);
        this.setStructuredActivityTerminal2(node);
    }

    /**
     * @param node
     * @param task
     */
    public ControlFlow(StructuredActivityNode node, GenericTask task)
    {
        this.setStructuredActivityTerminal1(node);
        this.setGenericTerminal2(task);
    }

    /**
     * @param node
     * @param decision
     */
    public ControlFlow(IfNode node, DecisionNode decision)
    {
        this.setIfNodeTerminal1(node);
        this.setDecisionTerminal2(decision);
    }

    /**
     * @param node
     * @param decision
     */
    public ControlFlow(DecisionNode decision, IfNode node)
    {
        this.setDecisionTerminal1(decision);
        this.setIfNodeTerminal2(node);
    }

    /**
     * @param node
     * @param decision
     */
    public ControlFlow(IfElseNode node, DecisionNode decision)
    {
        this.setIfElseNodeTerminal1(node);
        this.setDecisionTerminal2(decision);
    }

    /**
     * @param node
     * @param decision
     */
    public ControlFlow(DecisionNode decision, IfElseNode node)
    {
        this.setDecisionTerminal1(decision);
        this.setIfElseNodeTerminal2(node);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#conceptName()
     */
    public String conceptName()
    {
        return I18NProperties.getString("control.flow.concept.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("control.flow.concept.name.for.tree") + name();
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#mustHaveName()
     */
    public boolean mustHaveName()
    {
        return false;
    }

    /*
     * FIXME (non-Javadoc)
     * 
     * @see ocean.framework.Concept#duplicityIn(ocean.smalltalk.OceanVector)
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public Concept duplicityIn(OceanVector aConceptList)
    {
        return super.duplicityIn(aConceptList);
    }

    /**
     * @return the initialTerminal1
     */
    public InitialNode getInitialTerminal1()
    {
        return initialTerminal1;
    }

    /**
     * @param initialTerminal1 the initialTerminal1 to set
     */
    public void setInitialTerminal1(InitialNode initialTerminal1)
    {
        this.initialTerminal1 = initialTerminal1;
    }

    /**
     * @return the finalTerminal2
     */
    public FinalNode getFinalTerminal2()
    {
        return finalTerminal2;
    }

    /**
     * @param finalTerminal2 the finalTerminal2 to set
     */
    public void setFinalTerminal2(FinalNode finalTerminal2)
    {
        this.finalTerminal2 = finalTerminal2;
    }

    /**
     * @return the flowFinalTerminal2
     */
    public FlowFinalNode getFlowFinalTerminal2()
    {
        return flowFinalTerminal2;
    }

    /**
     * @param flowFinalTerminal2 the flowFinalTerminal2 to set
     */
    public void setFlowFinalTerminal2(FlowFinalNode flowFinalTerminal2)
    {
        this.flowFinalTerminal2 = flowFinalTerminal2;
    }

    /**
     * @return the activityTerminal1
     */
    public Activity getActivityTerminal1()
    {
        return activityTerminal1;
    }

    /**
     * @param activityTerminal1 the activityTerminal1 to set
     */
    public void setActivityTerminal1(Activity activityTerminal1)
    {
        this.activityTerminal1 = activityTerminal1;
    }

    /**
     * @return the activityTerminal2
     */
    public Activity getActivityTerminal2()
    {
        return activityTerminal2;
    }

    /**
     * @param activityTerminal2 the activityTerminal2 to set
     */
    public void setActivityTerminal2(Activity activityTerminal2)
    {
        this.activityTerminal2 = activityTerminal2;
    }

    /**
     * @return the decisionTerminal1
     */
    public DecisionNode getDecisionTerminal1()
    {
        return decisionTerminal1;
    }

    /**
     * @param decisionTerminal1 the decisionTerminal1 to set
     */
    public void setDecisionTerminal1(DecisionNode decisionTerminal1)
    {
        this.decisionTerminal1 = decisionTerminal1;
    }

    /**
     * @return the decisionTerminal2
     */
    public DecisionNode getDecisionTerminal2()
    {
        return decisionTerminal2;
    }

    /**
     * @param decisionTerminal2 the decisionTerminal2 to set
     */
    public void setDecisionTerminal2(DecisionNode decisionTerminal2)
    {
        this.decisionTerminal2 = decisionTerminal2;
    }

    /**
     * @return the mergeTerminal1
     */
    public MergeNode getMergeTerminal1()
    {
        return mergeTerminal1;
    }

    /**
     * @param mergeTerminal1 the mergeTerminal1 to set
     */
    public void setMergeTerminal1(MergeNode mergeTerminal1)
    {
        this.mergeTerminal1 = mergeTerminal1;
    }

    /**
     * @return the mergeTerminal2
     */
    public MergeNode getMergeTerminal2()
    {
        return mergeTerminal2;
    }

    /**
     * @param mergeTerminal2 the mergeTerminal2 to set
     */
    public void setMergeTerminal2(MergeNode mergeTerminal2)
    {
        this.mergeTerminal2 = mergeTerminal2;
    }

    /**
     * @return the forkTerminal1
     */
    public ForkNode getForkTerminal1()
    {
        return forkTerminal1;
    }

    /**
     * @param forkTerminal1 the forkTerminal1 to set
     */
    public void setForkTerminal1(ForkNode forkTerminal1)
    {
        this.forkTerminal1 = forkTerminal1;
    }

    /**
     * @return the forkTerminal2
     */
    public ForkNode getForkTerminal2()
    {
        return forkTerminal2;
    }

    /**
     * @param forkTerminal2 the forkTerminal2 to set
     */
    public void setForkTerminal2(ForkNode forkTerminal2)
    {
        this.forkTerminal2 = forkTerminal2;
    }

    /**
     * @return the joinTerminal1
     */
    public JoinNode getJoinTerminal1()
    {
        return joinTerminal1;
    }

    /**
     * @param joinTerminal1 the joinTerminal1 to set
     */
    public void setJoinTerminal1(JoinNode joinTerminal1)
    {
        this.joinTerminal1 = joinTerminal1;
    }

    /**
     * @return the joinTerminal2
     */
    public JoinNode getJoinTerminal2()
    {
        return joinTerminal2;
    }

    /**
     * @param joinTerminal2 the joinTerminal2 to set
     */
    public void setJoinTerminal2(JoinNode joinTerminal2)
    {
        this.joinTerminal2 = joinTerminal2;
    }

    /**
     * @return the actionTerminal1
     */
    public Action getActionTerminal1()
    {
        return actionTerminal1;
    }

    /**
     * @param actionTerminal1 the actionTerminal1 to set
     */
    public void setActionTerminal1(Action actionTerminal1)
    {
        this.actionTerminal1 = actionTerminal1;
    }

    /**
     * @return the actionTerminal2
     */
    public Action getActionTerminal2()
    {
        return actionTerminal2;
    }

    /**
     * @param actionTerminal2 the actionTerminal2 to set
     */
    public void setActionTerminal2(Action actionTerminal2)
    {
        this.actionTerminal2 = actionTerminal2;
    }

    /**
     * @return the acceptEventTerminal1
     */
    public AcceptEventAction getAcceptEventTerminal1()
    {
        return acceptEventTerminal1;
    }

    /**
     * @param acceptEventTerminal1 the acceptEventTerminal1 to set
     */
    public void setAcceptEventTerminal1(AcceptEventAction acceptEventTerminal1)
    {
        this.acceptEventTerminal1 = acceptEventTerminal1;
    }

    /**
     * @return the acceptEventTerminal2
     */
    public AcceptEventAction getAcceptEventTerminal2()
    {
        return acceptEventTerminal2;
    }

    /**
     * @param acceptEventTerminal2 the acceptEventTerminal2 to set
     */
    public void setAcceptEventTerminal2(AcceptEventAction acceptEventTerminal2)
    {
        this.acceptEventTerminal2 = acceptEventTerminal2;
    }

    /**
     * @return the acceptTimeEventTerminal1
     */
    public AcceptTimeEventAction getAcceptTimeEventTerminal1()
    {
        return acceptTimeEventTerminal1;
    }

    /**
     * @param acceptTimeEventTerminal1 the acceptTimeEventTerminal1 to set
     */
    public void setAcceptTimeEventTerminal1(AcceptTimeEventAction acceptTimeEventTerminal1)
    {
        this.acceptTimeEventTerminal1 = acceptTimeEventTerminal1;
    }

    /**
     * @return the acceptTimeEventTerminal2
     */
    public AcceptTimeEventAction getAcceptTimeEventTerminal2()
    {
        return acceptTimeEventTerminal2;
    }

    /**
     * @param acceptTimeEventTerminal2 the acceptTimeEventTerminal2 to set
     */
    public void setAcceptTimeEventTerminal2(AcceptTimeEventAction acceptTimeEventTerminal2)
    {
        this.acceptTimeEventTerminal2 = acceptTimeEventTerminal2;
    }

    /**
     * @return the sendSignalTerminal1
     */
    public SendSignal getSendSignalTerminal1()
    {
        return sendSignalTerminal1;
    }

    /**
     * @param sendSignalTerminal1 the sendSignalTerminal1 to set
     */
    public void setSendSignalTerminal1(SendSignal sendSignalTerminal1)
    {
        this.sendSignalTerminal1 = sendSignalTerminal1;
    }

    /**
     * @return the sendSignalTerminal2
     */
    public SendSignal getSendSignalTerminal2()
    {
        return sendSignalTerminal2;
    }

    /**
     * @param sendSignalTerminal2 the sendSignalTerminal2 to set
     */
    public void setSendSignalTerminal2(SendSignal sendSignalTerminal2)
    {
        this.sendSignalTerminal2 = sendSignalTerminal2;
    }

    /**
     * @return the loopTerminal1
     */
    public LoopNode getLoopTerminal1()
    {
        return loopTerminal1;
    }

    /**
     * @param loopTerminal1 the loopTerminal1 to set
     */
    public void setLoopTerminal1(LoopNode loopTerminal1)
    {
        this.loopTerminal1 = loopTerminal1;
    }

    /**
     * @return the loopTerminal2
     */
    public LoopNode getLoopTerminal2()
    {
        return loopTerminal2;
    }

    /**
     * @param loopTerminal2 the loopTerminal2 to set
     */
    public void setLoopTerminal2(LoopNode loopTerminal2)
    {
        this.loopTerminal2 = loopTerminal2;
    }

    /**
     * @return the conditionalTerminal1
     */
    public ConditionalNode getConditionalTerminal1()
    {
        return conditionalTerminal1;
    }

    /**
     * @param conditionalTerminal1 the conditionalTerminal1 to set
     */
    public void setConditionalTerminal1(ConditionalNode conditionalTerminal1)
    {
        this.conditionalTerminal1 = conditionalTerminal1;
    }

    /**
     * @return the conditionalTerminal2
     */
    public ConditionalNode getConditionalTerminal2()
    {
        return conditionalTerminal2;
    }

    /**
     * @param conditionalTerminal2 the conditionalTerminal2 to set
     */
    public void setConditionalTerminal2(ConditionalNode conditionalTerminal2)
    {
        this.conditionalTerminal2 = conditionalTerminal2;
    }

    /**
     * @return the sequenceTerminal1
     */
    public SequenceNode getSequenceTerminal1()
    {
        return sequenceTerminal1;
    }

    /**
     * @param sequenceTerminal1 the sequenceTerminal1 to set
     */
    public void setSequenceTerminal1(SequenceNode sequenceTerminal1)
    {
        this.sequenceTerminal1 = sequenceTerminal1;
    }

    /**
     * @return the sequenceTerminal2
     */
    public SequenceNode getSequenceTerminal2()
    {
        return sequenceTerminal2;
    }

    /**
     * @param sequenceTerminal2 the sequenceTerminal2 to set
     */
    public void setSequenceTerminal2(SequenceNode sequenceTerminal2)
    {
        this.sequenceTerminal2 = sequenceTerminal2;
    }

    /**
     * @return the structuredActivityTerminal1
     */
    public StructuredActivityNode getStructuredActivityTerminal1()
    {
        return structuredActivityTerminal1;
    }

    /**
     * @param structuredActivityTerminal1 the structuredActivityTerminal1 to set
     */
    public void setStructuredActivityTerminal1(StructuredActivityNode structuredActivityTerminal1)
    {
        this.structuredActivityTerminal1 = structuredActivityTerminal1;
    }

    /**
     * @return the structuredActivityTerminal2
     */
    public StructuredActivityNode getStructuredActivityTerminal2()
    {
        return structuredActivityTerminal2;
    }

    /**
     * @param structuredActivityTerminal2 the structuredActivityTerminal2 to set
     */
    public void setStructuredActivityTerminal2(StructuredActivityNode structuredActivityTerminal2)
    {
        this.structuredActivityTerminal2 = structuredActivityTerminal2;
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#attacherComponent()
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public Object attacherComponent()
    {
        OceanVector auxList;

        auxList = new OceanVector();
        auxList.add(this.getInitialTerminal1());
        auxList.add(this.getFinalTerminal2());
        auxList.add(this.getFlowFinalTerminal2());
        auxList.add(this.getActivityTerminal1());
        auxList.add(this.getActivityTerminal2());
        auxList.add(this.getDecisionTerminal1());
        auxList.add(this.getDecisionTerminal2());
        auxList.add(this.getMergeTerminal1());
        auxList.add(this.getMergeTerminal2());
        auxList.add(this.getForkTerminal1());
        auxList.add(this.getForkTerminal2());
        auxList.add(this.getJoinTerminal1());
        auxList.add(this.getJoinTerminal2());
        auxList.add(this.getActionTerminal1());
        auxList.add(this.getActionTerminal2());
        auxList.add(this.getAcceptEventTerminal1());
        auxList.add(this.getAcceptEventTerminal2());
        auxList.add(this.getSendSignalTerminal1());
        auxList.add(this.getSendSignalTerminal2());
        auxList.add(this.getAcceptTimeEventTerminal1());
        auxList.add(this.getAcceptTimeEventTerminal2());
        auxList.add(this.getLoopTerminal1());
        auxList.add(this.getLoopTerminal2());
        auxList.add(this.getStructuredActivityTerminal1());
        auxList.add(this.getStructuredActivityTerminal2());
        auxList.add(this.getSequenceTerminal1());
        auxList.add(this.getSequenceTerminal2());
        auxList.add(this.getConditionalTerminal1());
        auxList.add(this.getConditionalTerminal2());
        auxList.add(this.getAssignmentTerminal1());
        auxList.add(this.getAssignmentTerminal2());
        auxList.add(this.getReturnTerminal1());
        auxList.add(this.getReturnTerminal2());
        auxList.add(this.getMessageTerminal1());
        auxList.add(this.getMessageTerminal2());
        auxList.add(this.getTaskTerminal1());
        auxList.add(this.getTaskTerminal2());
        auxList.add(this.getGenericTerminal1());
        auxList.add(this.getGenericTerminal2());
        auxList.add(this.getIfNodeTerminal1());
        auxList.add(this.getIfNodeTerminal2());
        auxList.add(this.getIfElseNodeTerminal1());
        auxList.add(this.getIfElseNodeTerminal2());

        return auxList;
    }

    /**
     * @return the assignmentTerminal1
     */
    public Assignment getAssignmentTerminal1()
    {
        return assignmentTerminal1;
    }

    /**
     * @param assignmentTerminal1 the assignmentTerminal1 to set
     */
    public void setAssignmentTerminal1(Assignment assignmentTerminal1)
    {
        this.assignmentTerminal1 = assignmentTerminal1;
    }

    /**
     * @return the assignmentTerminal2
     */
    public Assignment getAssignmentTerminal2()
    {
        return assignmentTerminal2;
    }

    /**
     * @param assignmentTerminal2 the assignmentTerminal2 to set
     */
    public void setAssignmentTerminal2(Assignment assignmentTerminal2)
    {
        this.assignmentTerminal2 = assignmentTerminal2;
    }

    /**
     * @return the returnTerminal1
     */
    public Return getReturnTerminal1()
    {
        return returnTerminal1;
    }

    /**
     * @param returnTerminal1 the returnTerminal1 to set
     */
    public void setReturnTerminal1(Return returnTerminal1)
    {
        this.returnTerminal1 = returnTerminal1;
    }

    /**
     * @return the returnTerminal2
     */
    public Return getReturnTerminal2()
    {
        return returnTerminal2;
    }

    /**
     * @param returnTerminal2 the returnTerminal2 to set
     */
    public void setReturnTerminal2(Return returnTerminal2)
    {
        this.returnTerminal2 = returnTerminal2;
    }

    /**
     * @return the messageTerminal1
     */
    public Message getMessageTerminal1()
    {
        return messageTerminal1;
    }

    /**
     * @param messageTerminal1 the messageTerminal1 to set
     */
    public void setMessageTerminal1(Message messageTerminal1)
    {
        this.messageTerminal1 = messageTerminal1;
    }

    /**
     * @return the messageTerminal2
     */
    public Message getMessageTerminal2()
    {
        return messageTerminal2;
    }

    /**
     * @param messageTerminal2 the messageTerminal2 to set
     */
    public void setMessageTerminal2(Message messageTerminal2)
    {
        this.messageTerminal2 = messageTerminal2;
    }

    /**
     * @return the taskTerminal1
     */
    public TaskPackage getTaskTerminal1()
    {
        return taskTerminal1;
    }

    /**
     * @param taskTerminal1 the taskTerminal1 to set
     */
    public void setTaskTerminal1(TaskPackage taskTerminal1)
    {
        this.taskTerminal1 = taskTerminal1;
    }

    /**
     * @return the taskTerminal2
     */
    public TaskPackage getTaskTerminal2()
    {
        return taskTerminal2;
    }

    /**
     * @param taskTerminal2 the taskTerminal2 to set
     */
    public void setTaskTerminal2(TaskPackage taskTerminal2)
    {
        this.taskTerminal2 = taskTerminal2;
    }

    /**
     * @return the genericTerminal1
     */
    public GenericTask getGenericTerminal1()
    {
        return genericTerminal1;
    }

    /**
     * @param genericTerminal1 the genericTerminal1 to set
     */
    public void setGenericTerminal1(GenericTask genericTerminal1)
    {
        this.genericTerminal1 = genericTerminal1;
    }

    /**
     * @return the genericTerminal2
     */
    public GenericTask getGenericTerminal2()
    {
        return genericTerminal2;
    }

    /**
     * @param genericTerminal2 the genericTerminal2 to set
     */
    public void setGenericTerminal2(GenericTask genericTerminal2)
    {
        this.genericTerminal2 = genericTerminal2;
    }

    /**
     * @return the commentTerminal1
     */
    public Comment getCommentTerminal1()
    {
        return commentTerminal1;
    }

    /**
     * @param commentTerminal1 the commentTerminal1 to set
     */
    public void setCommentTerminal1(Comment commentTerminal1)
    {
        this.commentTerminal1 = commentTerminal1;
    }

    /**
     * @return the commentTerminal2
     */
    public Comment getCommentTerminal2()
    {
        return commentTerminal2;
    }

    /**
     * @param commentTerminal2 the commentTerminal2 to set
     */
    public void setCommentTerminal2(Comment commentTerminal2)
    {
        this.commentTerminal2 = commentTerminal2;
    }

    /**
     * @return the varTerminal1
     */
    public Variable getVarTerminal1()
    {
        return varTerminal1;
    }

    /**
     * @param varTerminal1 the varTerminal1 to set
     */
    public void setVarTerminal1(Variable varTerminal1)
    {
        this.varTerminal1 = varTerminal1;
    }

    /**
     * @return the varTerminal2
     */
    public Variable getVarTerminal2()
    {
        return varTerminal2;
    }

    /**
     * @param varTerminal2 the varTerminal2 to set
     */
    public void setVarTerminal2(Variable varTerminal2)
    {
        this.varTerminal2 = varTerminal2;
    }

    /**
     * @return the ifNodeTerminal1
     */
    public IfNode getIfNodeTerminal1()
    {
        return ifNodeTerminal1;
    }

    /**
     * @param ifNodeTerminal1 the ifNodeTerminal1 to set
     */
    public void setIfNodeTerminal1(IfNode ifNodeTerminal1)
    {
        this.ifNodeTerminal1 = ifNodeTerminal1;
    }

    /**
     * @return the ifNodeTerminal2
     */
    public IfNode getIfNodeTerminal2()
    {
        return ifNodeTerminal2;
    }

    /**
     * @param ifNodeTerminal2 the ifNodeTerminal2 to set
     */
    public void setIfNodeTerminal2(IfNode ifNodeTerminal2)
    {
        this.ifNodeTerminal2 = ifNodeTerminal2;
    }

    /**
     * @return the ifElseNodeTerminal1
     */
    public IfElseNode getIfElseNodeTerminal1()
    {
        return ifElseNodeTerminal1;
    }

    /**
     * @param ifElseNodeTerminal1 the ifElseNodeTerminal1 to set
     */
    public void setIfElseNodeTerminal1(IfElseNode ifElseNodeTerminal1)
    {
        this.ifElseNodeTerminal1 = ifElseNodeTerminal1;
    }

    /**
     * @return the ifElseNodeTerminal2
     */
    public IfElseNode getIfElseNodeTerminal2()
    {
        return ifElseNodeTerminal2;
    }

    /**
     * @param ifElseNodeTerminal2 the ifElseNodeTerminal2 to set
     */
    public void setIfElseNodeTerminal2(IfElseNode ifElseNodeTerminal2)
    {
        this.ifElseNodeTerminal2 = ifElseNodeTerminal2;
    }

}
