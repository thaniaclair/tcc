/*
 * @(#)ObjectFlow.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Mar 3, 2008        descrição
 */
package documents.concepts.activity_diagram;

import ocean.framework.Concept;
import ocean.smalltalk.OceanVector;
import documents.util.I18NProperties;

public class ObjectFlow extends Concept
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 8471485448156729551L;

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

    private ObjectNode objectTerminal1;

    private ObjectNode objectTerminal2;

    private CentralBufferNode centralBufferTerminal1;

    private CentralBufferNode centralBufferTerminal2;

    private DataStoreNode dataStoreTerminal1;

    private DataStoreNode dataStoreTerminal2;

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
    public ObjectFlow()
    {
        super();
        name(I18NProperties.getString("object.flow.concept.name"));
    }

    /**
     * @param object
     * @param object2
     */
    public ObjectFlow(ObjectNode object, ObjectNode object2)
    {
        this.setObjectTerminal1(object);
        this.setObjectTerminal2(object2);
    }

    /**
     * @param node
     * @param object
     */
    public ObjectFlow(InitialNode node, ObjectNode object)
    {
        this.setInitialTerminal1(node);
        this.setObjectTerminal2(object);
    }

    /**
     * @param node
     * @param object
     */
    public ObjectFlow(ObjectNode object, FinalNode node)
    {
        this.setObjectTerminal1(object);
        this.setFinalTerminal2(node);
    }

    /**
     * @param node
     * @param object
     */
    public ObjectFlow(ObjectNode object, FlowFinalNode node)
    {
        this.setObjectTerminal1(object);
        this.setFlowFinalTerminal2(node);
    }

    /**
     * @param node
     * @param activity
     */
    public ObjectFlow(ObjectNode object, Activity activity)
    {
        this.setObjectTerminal1(object);
        this.setActivityTerminal2(activity);
    }

    /**
     * @param activity
     * @param object
     */
    public ObjectFlow(Activity activity, ObjectNode object)
    {
        this.setActivityTerminal1(activity);
        this.setObjectTerminal2(object);
    }

    /**
     * @param node
     * @param decision
     */
    public ObjectFlow(ObjectNode object, DecisionNode decision)
    {
        this.setObjectTerminal1(object);
        this.setDecisionTerminal2(decision);
    }

    /**
     * @param decision
     * @param object
     */
    public ObjectFlow(DecisionNode decision, ObjectNode object)
    {
        this.setDecisionTerminal1(decision);
        this.setObjectTerminal2(object);
    }

    /**
     * @param node
     * @param merge
     */
    public ObjectFlow(ObjectNode object, MergeNode merge)
    {
        this.setObjectTerminal1(object);
        this.setMergeTerminal2(merge);
    }

    /**
     * @param merge
     * @param object
     */
    public ObjectFlow(MergeNode merge, ObjectNode object)
    {
        this.setMergeTerminal1(merge);
        this.setObjectTerminal2(object);
    }

    /**
     * @param node
     * @param fork
     */
    public ObjectFlow(ObjectNode object, ForkNode fork)
    {
        this.setObjectTerminal1(object);
        this.setForkTerminal2(fork);
    }

    /**
     * @param fork
     * @param object
     */
    public ObjectFlow(ForkNode fork, ObjectNode object)
    {
        this.setForkTerminal1(fork);
        this.setObjectTerminal2(object);
    }

    /**
     * @param node
     * @param join
     */
    public ObjectFlow(ObjectNode object, JoinNode join)
    {
        this.setObjectTerminal1(object);
        this.setJoinTerminal2(join);
    }

    /**
     * @param join
     * @param object
     */
    public ObjectFlow(JoinNode join, ObjectNode object)
    {
        this.setJoinTerminal1(join);
        this.setObjectTerminal2(object);
    }

    /**
     * @param object
     * @param action
     */
    public ObjectFlow(ObjectNode object, Action action)
    {
        this.setObjectTerminal1(object);
        this.setActionTerminal2(action);
    }

    /**
     * @param action
     * @param object
     */
    public ObjectFlow(Action action, ObjectNode object)
    {
        this.setActionTerminal1(action);
        this.setObjectTerminal2(object);
    }

    /**
     * @param object
     * @param send
     */
    public ObjectFlow(ObjectNode object, SendSignal send)
    {
        this.setObjectTerminal1(object);
        this.setSendSignalTerminal2(send);
    }

    /**
     * @param send
     * @param object
     */
    public ObjectFlow(SendSignal send, ObjectNode object)
    {
        this.setSendSignalTerminal1(send);
        this.setObjectTerminal2(object);
    }

    /**
     * @param object
     * @param action
     */
    public ObjectFlow(ObjectNode object, AcceptEventAction action)
    {
        this.setObjectTerminal1(object);
        this.setAcceptEventTerminal2(action);
    }

    /**
     * @param action
     * @param object
     */
    public ObjectFlow(AcceptEventAction action, ObjectNode object)
    {
        this.setAcceptEventTerminal1(action);
        this.setObjectTerminal2(object);
    }

    /**
     * @param object
     * @param action
     */
    public ObjectFlow(ObjectNode object, AcceptTimeEventAction action)
    {
        this.setObjectTerminal1(object);
        this.setAcceptTimeEventTerminal2(action);
    }

    /**
     * @param action
     * @param object
     */
    public ObjectFlow(AcceptTimeEventAction action, ObjectNode object)
    {
        this.setAcceptTimeEventTerminal1(action);
        this.setObjectTerminal2(object);
    }

    /**
     * @param object
     * @param central
     */
    public ObjectFlow(ObjectNode object, CentralBufferNode central)
    {
        this.setObjectTerminal1(object);
        this.setCentralBufferTerminal2(central);
    }

    /**
     * @param central
     * @param object
     */
    public ObjectFlow(CentralBufferNode central, ObjectNode object)
    {
        this.setCentralBufferTerminal1(central);
        this.setObjectTerminal2(object);
    }

    /**
     * @param object
     * @param data
     */
    public ObjectFlow(ObjectNode object, DataStoreNode data)
    {
        this.setObjectTerminal1(object);
        this.setDataStoreTerminal2(data);
    }

    /**
     * @param data
     * @param object
     */
    public ObjectFlow(DataStoreNode data, ObjectNode object)
    {
        this.setDataStoreTerminal1(data);
        this.setObjectTerminal2(object);
    }

    /**
     * @param object
     * @param node
     */
    public ObjectFlow(ObjectNode object, LoopNode node)
    {
        this.setObjectTerminal1(object);
        this.setLoopTerminal2(node);
    }

    /**
     * @param node
     * @param object
     */
    public ObjectFlow(LoopNode node, ObjectNode object)
    {
        this.setLoopTerminal1(node);
        this.setObjectTerminal2(object);
    }

    /**
     * @param object
     * @param node
     */
    public ObjectFlow(ObjectNode object, SequenceNode node)
    {
        this.setObjectTerminal1(object);
        this.setSequenceTerminal2(node);
    }

    /**
     * @param node
     * @param object
     */
    public ObjectFlow(SequenceNode node, ObjectNode object)
    {
        this.setSequenceTerminal1(node);
        this.setObjectTerminal2(object);
    }

    /**
     * @param object
     * @param node
     */
    public ObjectFlow(ObjectNode object, ConditionalNode node)
    {
        this.setObjectTerminal1(object);
        this.setConditionalTerminal2(node);
    }

    /**
     * @param node
     * @param object
     */
    public ObjectFlow(ConditionalNode node, ObjectNode object)
    {
        this.setConditionalTerminal1(node);
        this.setObjectTerminal2(object);
    }

    /**
     * @param object
     * @param node
     */
    public ObjectFlow(ObjectNode object, StructuredActivityNode node)
    {
        this.setObjectTerminal1(object);
        this.setStructuredActivityTerminal2(node);
    }

    /**
     * @param node
     * @param object
     */
    public ObjectFlow(StructuredActivityNode node, ObjectNode object)
    {
        this.setStructuredActivityTerminal1(node);
        this.setObjectTerminal2(object);
    }

    /**
     * @param node
     * @param object
     */
    public ObjectFlow(InitialNode node, DataStoreNode object)
    {
        this.setInitialTerminal1(node);
        this.setDataStoreTerminal2(object);
    }

    /**
     * @param node
     * @param object
     */
    public ObjectFlow(DataStoreNode object, FinalNode node)
    {
        this.setDataStoreTerminal1(object);
        this.setFinalTerminal2(node);
    }

    /**
     * @param node
     * @param object
     */
    public ObjectFlow(DataStoreNode object, FlowFinalNode node)
    {
        this.setDataStoreTerminal1(object);
        this.setFlowFinalTerminal2(node);
    }

    /**
     * @param node
     * @param activity
     */
    public ObjectFlow(DataStoreNode object, Activity activity)
    {
        this.setDataStoreTerminal1(object);
        this.setActivityTerminal2(activity);
    }

    /**
     * @param activity
     * @param object
     */
    public ObjectFlow(Activity activity, DataStoreNode object)
    {
        this.setActivityTerminal1(activity);
        this.setDataStoreTerminal2(object);
    }

    /**
     * @param node
     * @param decision
     */
    public ObjectFlow(DataStoreNode object, DecisionNode decision)
    {
        this.setDataStoreTerminal1(object);
        this.setDecisionTerminal2(decision);
    }

    /**
     * @param decision
     * @param object
     */
    public ObjectFlow(DecisionNode decision, DataStoreNode object)
    {
        this.setDecisionTerminal1(decision);
        this.setDataStoreTerminal2(object);
    }

    /**
     * @param node
     * @param merge
     */
    public ObjectFlow(DataStoreNode object, MergeNode merge)
    {
        this.setDataStoreTerminal1(object);
        this.setMergeTerminal2(merge);
    }

    /**
     * @param merge
     * @param object
     */
    public ObjectFlow(MergeNode merge, DataStoreNode object)
    {
        this.setMergeTerminal1(merge);
        this.setDataStoreTerminal2(object);
    }

    /**
     * @param node
     * @param fork
     */
    public ObjectFlow(DataStoreNode object, ForkNode fork)
    {
        this.setDataStoreTerminal1(object);
        this.setForkTerminal2(fork);
    }

    /**
     * @param fork
     * @param object
     */
    public ObjectFlow(ForkNode fork, DataStoreNode object)
    {
        this.setForkTerminal1(fork);
        this.setDataStoreTerminal2(object);
    }

    /**
     * @param node
     * @param join
     */
    public ObjectFlow(DataStoreNode object, JoinNode join)
    {
        this.setDataStoreTerminal1(object);
        this.setJoinTerminal2(join);
    }

    /**
     * @param join
     * @param object
     */
    public ObjectFlow(JoinNode join, DataStoreNode object)
    {
        this.setJoinTerminal1(join);
        this.setDataStoreTerminal2(object);
    }

    /**
     * @param object
     * @param action
     */
    public ObjectFlow(DataStoreNode object, Action action)
    {
        this.setDataStoreTerminal1(object);
        this.setActionTerminal2(action);
    }

    /**
     * @param action
     * @param object
     */
    public ObjectFlow(Action action, DataStoreNode object)
    {
        this.setActionTerminal1(action);
        this.setDataStoreTerminal2(object);
    }

    /**
     * @param object
     * @param send
     */
    public ObjectFlow(DataStoreNode object, SendSignal send)
    {
        this.setDataStoreTerminal1(object);
        this.setSendSignalTerminal2(send);
    }

    /**
     * @param send
     * @param object
     */
    public ObjectFlow(SendSignal send, DataStoreNode object)
    {
        this.setSendSignalTerminal1(send);
        this.setDataStoreTerminal2(object);
    }

    /**
     * @param object
     * @param action
     */
    public ObjectFlow(DataStoreNode object, AcceptEventAction action)
    {
        this.setDataStoreTerminal1(object);
        this.setAcceptEventTerminal2(action);
    }

    /**
     * @param action
     * @param object
     */
    public ObjectFlow(AcceptEventAction action, DataStoreNode object)
    {
        this.setAcceptEventTerminal1(action);
        this.setDataStoreTerminal2(object);
    }

    /**
     * @param object
     * @param action
     */
    public ObjectFlow(DataStoreNode object, AcceptTimeEventAction action)
    {
        this.setDataStoreTerminal1(object);
        this.setAcceptTimeEventTerminal2(action);
    }

    /**
     * @param action
     * @param object
     */
    public ObjectFlow(AcceptTimeEventAction action, DataStoreNode object)
    {
        this.setAcceptTimeEventTerminal1(action);
        this.setDataStoreTerminal2(object);
    }

    /**
     * @param object
     * @param central
     */
    public ObjectFlow(DataStoreNode object, CentralBufferNode central)
    {
        this.setDataStoreTerminal1(object);
        this.setCentralBufferTerminal2(central);
    }

    /**
     * @param central
     * @param object
     */
    public ObjectFlow(CentralBufferNode central, DataStoreNode object)
    {
        this.setCentralBufferTerminal1(central);
        this.setDataStoreTerminal2(object);
    }

    /**
     * @param object
     * @param data
     */
    public ObjectFlow(DataStoreNode object, DataStoreNode data)
    {
        this.setDataStoreTerminal1(object);
        this.setDataStoreTerminal2(data);
    }

    /**
     * @param object
     * @param node
     */
    public ObjectFlow(DataStoreNode object, LoopNode node)
    {
        this.setDataStoreTerminal1(object);
        this.setLoopTerminal2(node);
    }

    /**
     * @param node
     * @param object
     */
    public ObjectFlow(LoopNode node, DataStoreNode object)
    {
        this.setLoopTerminal1(node);
        this.setDataStoreTerminal2(object);
    }

    /**
     * @param object
     * @param node
     */
    public ObjectFlow(DataStoreNode object, SequenceNode node)
    {
        this.setDataStoreTerminal1(object);
        this.setSequenceTerminal2(node);
    }

    /**
     * @param node
     * @param object
     */
    public ObjectFlow(SequenceNode node, DataStoreNode object)
    {
        this.setSequenceTerminal1(node);
        this.setDataStoreTerminal2(object);
    }

    /**
     * @param object
     * @param node
     */
    public ObjectFlow(DataStoreNode object, ConditionalNode node)
    {
        this.setDataStoreTerminal1(object);
        this.setConditionalTerminal2(node);
    }

    /**
     * @param node
     * @param object
     */
    public ObjectFlow(ConditionalNode node, DataStoreNode object)
    {
        this.setConditionalTerminal1(node);
        this.setDataStoreTerminal2(object);
    }

    /**
     * @param object
     * @param node
     */
    public ObjectFlow(DataStoreNode object, StructuredActivityNode node)
    {
        this.setDataStoreTerminal1(object);
        this.setStructuredActivityTerminal2(node);
    }

    /**
     * @param node
     * @param object
     */
    public ObjectFlow(StructuredActivityNode node, DataStoreNode object)
    {
        this.setStructuredActivityTerminal1(node);
        this.setDataStoreTerminal2(object);
    }

    /**
     * @param object
     * @param object2
     */
    public ObjectFlow(CentralBufferNode object, CentralBufferNode object2)
    {
        this.setCentralBufferTerminal1(object);
        this.setCentralBufferTerminal2(object2);
    }

    /**
     * @param node
     * @param object
     */
    public ObjectFlow(InitialNode node, CentralBufferNode object)
    {
        this.setInitialTerminal1(node);
        this.setCentralBufferTerminal2(object);
    }

    /**
     * @param node
     * @param object
     */
    public ObjectFlow(CentralBufferNode object, FinalNode node)
    {
        this.setCentralBufferTerminal1(object);
        this.setFinalTerminal2(node);
    }

    /**
     * @param node
     * @param object
     */
    public ObjectFlow(CentralBufferNode object, FlowFinalNode node)
    {
        this.setCentralBufferTerminal1(object);
        this.setFlowFinalTerminal2(node);
    }

    /**
     * @param node
     * @param activity
     */
    public ObjectFlow(CentralBufferNode object, Activity activity)
    {
        this.setCentralBufferTerminal1(object);
        this.setActivityTerminal2(activity);
    }

    /**
     * @param activity
     * @param object
     */
    public ObjectFlow(Activity activity, CentralBufferNode object)
    {
        this.setActivityTerminal1(activity);
        this.setCentralBufferTerminal2(object);
    }

    /**
     * @param node
     * @param decision
     */
    public ObjectFlow(CentralBufferNode object, DecisionNode decision)
    {
        this.setCentralBufferTerminal1(object);
        this.setDecisionTerminal2(decision);
    }

    /**
     * @param decision
     * @param object
     */
    public ObjectFlow(DecisionNode decision, CentralBufferNode object)
    {
        this.setDecisionTerminal1(decision);
        this.setCentralBufferTerminal2(object);
    }

    /**
     * @param node
     * @param merge
     */
    public ObjectFlow(CentralBufferNode object, MergeNode merge)
    {
        this.setCentralBufferTerminal1(object);
        this.setMergeTerminal2(merge);
    }

    /**
     * @param merge
     * @param object
     */
    public ObjectFlow(MergeNode merge, CentralBufferNode object)
    {
        this.setMergeTerminal1(merge);
        this.setCentralBufferTerminal2(object);
    }

    /**
     * @param node
     * @param fork
     */
    public ObjectFlow(CentralBufferNode object, ForkNode fork)
    {
        this.setCentralBufferTerminal1(object);
        this.setForkTerminal2(fork);
    }

    /**
     * @param fork
     * @param object
     */
    public ObjectFlow(ForkNode fork, CentralBufferNode object)
    {
        this.setForkTerminal1(fork);
        this.setCentralBufferTerminal2(object);
    }

    /**
     * @param node
     * @param join
     */
    public ObjectFlow(CentralBufferNode object, JoinNode join)
    {
        this.setCentralBufferTerminal1(object);
        this.setJoinTerminal2(join);
    }

    /**
     * @param join
     * @param object
     */
    public ObjectFlow(JoinNode join, CentralBufferNode object)
    {
        this.setJoinTerminal1(join);
        this.setCentralBufferTerminal2(object);
    }

    /**
     * @param object
     * @param action
     */
    public ObjectFlow(CentralBufferNode object, Action action)
    {
        this.setCentralBufferTerminal1(object);
        this.setActionTerminal2(action);
    }

    /**
     * @param action
     * @param object
     */
    public ObjectFlow(Action action, CentralBufferNode object)
    {
        this.setActionTerminal1(action);
        this.setCentralBufferTerminal2(object);
    }

    /**
     * @param object
     * @param send
     */
    public ObjectFlow(CentralBufferNode object, SendSignal send)
    {
        this.setCentralBufferTerminal1(object);
        this.setSendSignalTerminal2(send);
    }

    /**
     * @param send
     * @param object
     */
    public ObjectFlow(SendSignal send, CentralBufferNode object)
    {
        this.setSendSignalTerminal1(send);
        this.setCentralBufferTerminal2(object);
    }

    /**
     * @param object
     * @param action
     */
    public ObjectFlow(CentralBufferNode object, AcceptEventAction action)
    {
        this.setCentralBufferTerminal1(object);
        this.setAcceptEventTerminal2(action);
    }

    /**
     * @param action
     * @param object
     */
    public ObjectFlow(AcceptEventAction action, CentralBufferNode object)
    {
        this.setAcceptEventTerminal1(action);
        this.setCentralBufferTerminal2(object);
    }

    /**
     * @param object
     * @param action
     */
    public ObjectFlow(CentralBufferNode object, AcceptTimeEventAction action)
    {
        this.setCentralBufferTerminal1(object);
        this.setAcceptTimeEventTerminal2(action);
    }

    /**
     * @param action
     * @param object
     */
    public ObjectFlow(AcceptTimeEventAction action, CentralBufferNode object)
    {
        this.setAcceptTimeEventTerminal1(action);
        this.setCentralBufferTerminal2(object);
    }

    /**
     * @param object
     * @param node
     */
    public ObjectFlow(CentralBufferNode object, LoopNode node)
    {
        this.setCentralBufferTerminal1(object);
        this.setLoopTerminal2(node);
    }

    /**
     * @param node
     * @param object
     */
    public ObjectFlow(LoopNode node, CentralBufferNode object)
    {
        this.setLoopTerminal1(node);
        this.setCentralBufferTerminal2(object);
    }

    /**
     * @param object
     * @param node
     */
    public ObjectFlow(CentralBufferNode object, SequenceNode node)
    {
        this.setCentralBufferTerminal1(object);
        this.setSequenceTerminal2(node);
    }

    /**
     * @param node
     * @param object
     */
    public ObjectFlow(SequenceNode node, CentralBufferNode object)
    {
        this.setSequenceTerminal1(node);
        this.setCentralBufferTerminal2(object);
    }

    /**
     * @param object
     * @param node
     */
    public ObjectFlow(CentralBufferNode object, ConditionalNode node)
    {
        this.setCentralBufferTerminal1(object);
        this.setConditionalTerminal2(node);
    }

    /**
     * @param node
     * @param object
     */
    public ObjectFlow(ConditionalNode node, CentralBufferNode object)
    {
        this.setConditionalTerminal1(node);
        this.setCentralBufferTerminal2(object);
    }

    /**
     * @param object
     * @param node
     */
    public ObjectFlow(CentralBufferNode object, StructuredActivityNode node)
    {
        this.setCentralBufferTerminal1(object);
        this.setStructuredActivityTerminal2(node);
    }

    /**
     * @param node
     * @param object
     */
    public ObjectFlow(StructuredActivityNode node, CentralBufferNode object)
    {
        this.setStructuredActivityTerminal1(node);
        this.setCentralBufferTerminal2(object);
    }

    /**
     * @param assign
     * @param object
     */
    public ObjectFlow(Assignment assign, ObjectNode object)
    {
        this.setAssignmentTerminal1(assign);
        this.setObjectTerminal2(object);
    }

    /**
     * @param object
     * @param assign
     */
    public ObjectFlow(ObjectNode object, Assignment assign)
    {
        this.setObjectTerminal1(object);
        this.setAssignmentTerminal2(assign);
    }

    /**
     * @param assign
     * @param central
     */
    public ObjectFlow(Assignment assign, CentralBufferNode central)
    {
        this.setAssignmentTerminal1(assign);
        this.setCentralBufferTerminal2(central);
    }

    /**
     * @param central
     * @param assign
     */
    public ObjectFlow(CentralBufferNode central, Assignment assign)
    {
        this.setCentralBufferTerminal1(central);
        this.setAssignmentTerminal2(assign);
    }

    /**
     * @param assign
     * @param data
     */
    public ObjectFlow(Assignment assign, DataStoreNode data)
    {
        this.setAssignmentTerminal1(assign);
        this.setDataStoreTerminal2(data);
    }

    /**
     * @param data
     * @param assign
     */
    public ObjectFlow(DataStoreNode data, Assignment assign)
    {
        this.setDataStoreTerminal1(data);
        this.setAssignmentTerminal2(assign);
    }

    /**
     * @param returnInstance
     * @param object
     */
    public ObjectFlow(Return returnInstance, ObjectNode object)
    {
        this.setReturnTerminal1(returnInstance);
        this.setObjectTerminal2(object);
    }

    /**
     * @param object
     * @param returnInstance
     */
    public ObjectFlow(ObjectNode object, Return returnInstance)
    {
        this.setObjectTerminal1(object);
        this.setReturnTerminal2(returnInstance);
    }

    /**
     * @param returnInstance
     * @param central
     */
    public ObjectFlow(Return returnInstance, CentralBufferNode central)
    {
        this.setReturnTerminal1(returnInstance);
        this.setCentralBufferTerminal2(central);
    }

    /**
     * @param central
     * @param returnInstance
     */
    public ObjectFlow(CentralBufferNode central, Return returnInstance)
    {
        this.setCentralBufferTerminal1(central);
        this.setReturnTerminal2(returnInstance);
    }

    /**
     * @param returnInstance
     * @param data
     */
    public ObjectFlow(Return returnInstance, DataStoreNode data)
    {
        this.setReturnTerminal1(returnInstance);
        this.setDataStoreTerminal2(data);
    }

    /**
     * @param data
     * @param returnInstance
     */
    public ObjectFlow(DataStoreNode data, Return returnInstance)
    {
        this.setDataStoreTerminal1(data);
        this.setReturnTerminal2(returnInstance);
    }

    /**
     * @param message
     * @param object
     */
    public ObjectFlow(Message message, ObjectNode object)
    {
        this.setMessageTerminal1(message);
        this.setObjectTerminal2(object);
    }

    /**
     * @param object
     * @param message
     */
    public ObjectFlow(ObjectNode object, Message message)
    {
        this.setObjectTerminal1(object);
        this.setMessageTerminal2(message);
    }

    /**
     * @param message
     * @param central
     */
    public ObjectFlow(Message message, CentralBufferNode central)
    {
        this.setMessageTerminal1(message);
        this.setCentralBufferTerminal2(central);
    }

    /**
     * @param central
     * @param message
     */
    public ObjectFlow(CentralBufferNode central, Message message)
    {
        this.setCentralBufferTerminal1(central);
        this.setMessageTerminal2(message);
    }

    /**
     * @param message
     * @param data
     */
    public ObjectFlow(Message message, DataStoreNode data)
    {
        this.setMessageTerminal1(message);
        this.setDataStoreTerminal2(data);
    }

    /**
     * @param data
     * @param message
     */
    public ObjectFlow(DataStoreNode data, Message message)
    {
        this.setDataStoreTerminal1(data);
        this.setMessageTerminal2(message);
    }

    /**
     * @param task
     * @param object
     */
    public ObjectFlow(TaskPackage task, ObjectNode object)
    {
        this.setTaskTerminal1(task);
        this.setObjectTerminal2(object);
    }

    /**
     * @param object
     * @param task
     */
    public ObjectFlow(ObjectNode object, TaskPackage task)
    {
        this.setObjectTerminal1(object);
        this.setTaskTerminal2(task);
    }

    /**
     * @param task
     * @param central
     */
    public ObjectFlow(TaskPackage task, CentralBufferNode central)
    {
        this.setTaskTerminal1(task);
        this.setCentralBufferTerminal2(central);
    }

    /**
     * @param central
     * @param task
     */
    public ObjectFlow(CentralBufferNode central, TaskPackage task)
    {
        this.setCentralBufferTerminal1(central);
        this.setTaskTerminal2(task);
    }

    /**
     * @param task
     * @param data
     */
    public ObjectFlow(TaskPackage task, DataStoreNode data)
    {
        this.setTaskTerminal1(task);
        this.setDataStoreTerminal2(data);
    }

    /**
     * @param data
     * @param task
     */
    public ObjectFlow(DataStoreNode data, TaskPackage task)
    {
        this.setDataStoreTerminal1(data);
        this.setTaskTerminal2(task);
    }

    /**
     * @param task
     * @param object
     */
    public ObjectFlow(GenericTask task, ObjectNode object)
    {
        this.setGenericTerminal1(task);
        this.setObjectTerminal2(object);
    }

    /**
     * @param object
     * @param task
     */
    public ObjectFlow(ObjectNode object, GenericTask task)
    {
        this.setObjectTerminal1(object);
        this.setGenericTerminal2(task);
    }

    /**
     * @param task
     * @param central
     */
    public ObjectFlow(GenericTask task, CentralBufferNode central)
    {
        this.setGenericTerminal1(task);
        this.setCentralBufferTerminal2(central);
    }

    /**
     * @param central
     * @param task
     */
    public ObjectFlow(CentralBufferNode central, GenericTask task)
    {
        this.setCentralBufferTerminal1(central);
        this.setGenericTerminal2(task);
    }

    /**
     * @param task
     * @param data
     */
    public ObjectFlow(GenericTask task, DataStoreNode data)
    {
        this.setGenericTerminal1(task);
        this.setDataStoreTerminal2(data);
    }

    /**
     * @param data
     * @param task
     */
    public ObjectFlow(DataStoreNode data, GenericTask task)
    {
        this.setDataStoreTerminal1(data);
        this.setGenericTerminal2(task);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#conceptName()
     */
    public String conceptName()
    {
        return I18NProperties.getString("object.flow.concept.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("object.flow.concept.name.for.tree") + name();
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

        return auxList;
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

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID()
    {
        return serialVersionUID;
    }

    /**
     * @return the objectTerminal1
     */
    public ObjectNode getObjectTerminal1()
    {
        return objectTerminal1;
    }

    /**
     * @param objectTerminal1 the objectTerminal1 to set
     */
    public void setObjectTerminal1(ObjectNode objectTerminal1)
    {
        this.objectTerminal1 = objectTerminal1;
    }

    /**
     * @return the objectTerminal2
     */
    public ObjectNode getObjectTerminal2()
    {
        return objectTerminal2;
    }

    /**
     * @param objectTerminal2 the objectTerminal2 to set
     */
    public void setObjectTerminal2(ObjectNode objectTerminal2)
    {
        this.objectTerminal2 = objectTerminal2;
    }

    /**
     * @return the centralBufferTerminal1
     */
    public CentralBufferNode getCentralBufferTerminal1()
    {
        return centralBufferTerminal1;
    }

    /**
     * @param centralBufferTerminal1 the centralBufferTerminal1 to set
     */
    public void setCentralBufferTerminal1(CentralBufferNode centralBufferTerminal1)
    {
        this.centralBufferTerminal1 = centralBufferTerminal1;
    }

    /**
     * @return the centralBufferTerminal2
     */
    public CentralBufferNode getCentralBufferTerminal2()
    {
        return centralBufferTerminal2;
    }

    /**
     * @param centralBufferTerminal2 the centralBufferTerminal2 to set
     */
    public void setCentralBufferTerminal2(CentralBufferNode centralBufferTerminal2)
    {
        this.centralBufferTerminal2 = centralBufferTerminal2;
    }

    /**
     * @return the dataStoreTerminal1
     */
    public DataStoreNode getDataStoreTerminal1()
    {
        return dataStoreTerminal1;
    }

    /**
     * @param dataStoreTerminal1 the dataStoreTerminal1 to set
     */
    public void setDataStoreTerminal1(DataStoreNode dataStoreTerminal1)
    {
        this.dataStoreTerminal1 = dataStoreTerminal1;
    }

    /**
     * @return the dataStoreTerminal2
     */
    public DataStoreNode getDataStoreTerminal2()
    {
        return dataStoreTerminal2;
    }

    /**
     * @param dataStoreTerminal2 the dataStoreTerminal2 to set
     */
    public void setDataStoreTerminal2(DataStoreNode dataStoreTerminal2)
    {
        this.dataStoreTerminal2 = dataStoreTerminal2;
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

}
