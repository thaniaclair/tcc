/*
 * @(#)CommentLink.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Mar 10, 2008        descrição
 */
package documents.concepts.activity_diagram;

import ocean.framework.Concept;
import ocean.smalltalk.OceanVector;
import documents.util.I18NProperties;

public class NoteLink extends Concept
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -7478120789722223323L;

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

    private DoWhileNode doWhileTerminal1;

    private DoWhileNode doWhileTerminal2;

    private WhileNode whileTerminal1;

    private WhileNode whileTerminal2;

    private ForNode forTerminal1;

    private ForNode forTerminal2;

    private SwitchNode switchTerminal1;

    private SwitchNode switchTerminal2;

    // Common concepts.

    private Note noteTerminal1;

    private Note noteTerminal2;

    private InitialNode initialTerminal1;

    private InitialNode initialTerminal2;

    private FinalNode finalTerminal1;

    private FinalNode finalTerminal2;

    private FlowFinalNode flowFinalTerminal1;

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

    private InterruptibleActivity interruptibleActivityTerminal1;

    private InterruptibleActivity interruptibleActivityTerminal2;

    private ObjectNode objectTerminal1;

    private ObjectNode objectTerminal2;

    private DataStoreNode dataTerminal1;

    private DataStoreNode dataTerminal2;

    private CentralBufferNode centralTerminal1;

    private CentralBufferNode centralTerminal2;

    private VerticalSwinlane verticalSwinlaneTerminal1;

    private VerticalSwinlane verticalSwinlaneTerminal2;

    /**
     * Official constructor.
     */
    public NoteLink()
    {
        super();
        name(I18NProperties.getString("comment.link.concept.name"));
    }

    /**
     * @param comment
     * @param comment2
     */
    public NoteLink(Comment comment, Comment comment2)
    {
        this.setCommentTerminal1(comment);
        this.setCommentTerminal2(comment2);
    }

    /**
     * @param comment
     * @param assignment
     */
    public NoteLink(Comment comment, Assignment assignment)
    {
        this.setCommentTerminal1(comment);
        this.setAssignmentTerminal2(assignment);
    }

    /**
     * @param assignment
     * @param comment
     */
    public NoteLink(Assignment assignment, Comment comment)
    {
        this.setAssignmentTerminal1(assignment);
        this.setCommentTerminal2(comment);
    }

    /**
     * @param comment
     * @param return1
     */
    public NoteLink(Comment comment, Return return1)
    {
        this.setCommentTerminal1(comment);
        this.setReturnTerminal2(return1);
    }

    /**
     * @param return1
     * @param comment
     */
    public NoteLink(Return return1, Comment comment)
    {
        this.setReturnTerminal1(return1);
        this.setCommentTerminal2(comment);
    }

    /**
     * @param comment
     * @param message
     */
    public NoteLink(Comment comment, Message message)
    {
        this.setCommentTerminal1(comment);
        this.setMessageTerminal2(message);
    }

    /**
     * @param message
     * @param comment
     */
    public NoteLink(Message message, Comment comment)
    {
        this.setMessageTerminal1(message);
        this.setCommentTerminal2(comment);
    }

    /**
     * @param comment
     * @param task
     */
    public NoteLink(Comment comment, TaskPackage task)
    {
        this.setCommentTerminal1(comment);
        this.setTaskTerminal2(task);
    }

    /**
     * @param task
     * @param comment
     */
    public NoteLink(TaskPackage task, Comment comment)
    {
        this.setTaskTerminal1(task);
        this.setCommentTerminal2(comment);
    }

    /**
     * @param comment
     * @param task
     */
    public NoteLink(Comment comment, GenericTask task)
    {
        this.setCommentTerminal1(comment);
        this.setGenericTerminal2(task);
    }

    /**
     * @param task
     * @param comment
     */
    public NoteLink(GenericTask task, Comment comment)
    {
        this.setGenericTerminal1(task);
        this.setCommentTerminal2(comment);
    }

    /**
     * @param comment
     * @param var
     */
    public NoteLink(Comment comment, Variable var)
    {
        this.setCommentTerminal1(comment);
        this.setVarTerminal2(var);
    }

    /**
     * @param var
     * @param comment
     */
    public NoteLink(Variable var, Comment comment)
    {
        this.setVarTerminal1(var);
        this.setCommentTerminal2(comment);
    }

    /**
     * @param comment
     * @param doWhile
     */
    public NoteLink(Comment comment, DoWhileNode doWhile)
    {
        this.setCommentTerminal1(comment);
        this.setDoWhileTerminal2(doWhile);
    }

    /**
     * @param doWhile
     * @param comment
     */
    public NoteLink(DoWhileNode doWhile, Comment comment)
    {
        this.setDoWhileTerminal1(doWhile);
        this.setCommentTerminal2(comment);
    }

    /**
     * @param comment
     * @param whileNode
     */
    public NoteLink(Comment comment, WhileNode whileNode)
    {
        this.setCommentTerminal1(comment);
        this.setWhileTerminal2(whileNode);
    }

    /**
     * @param whileNode
     * @param comment
     */
    public NoteLink(WhileNode whileNode, Comment comment)
    {
        this.setWhileTerminal1(whileNode);
        this.setCommentTerminal2(comment);
    }

    /**
     * @param comment
     * @param forNode
     */
    public NoteLink(Comment comment, ForNode forNode)
    {
        this.setCommentTerminal1(comment);
        this.setForTerminal2(forNode);
    }

    /**
     * @param forNode
     * @param comment
     */
    public NoteLink(ForNode forNode, Comment comment)
    {
        this.setForTerminal1(forNode);
        this.setCommentTerminal2(comment);
    }

    /**
     * @param comment
     * @param switchNode
     */
    public NoteLink(Comment comment, SwitchNode switchNode)
    {
        this.setCommentTerminal1(comment);
        this.setSwitchTerminal2(switchNode);
    }

    /**
     * @param switchNode
     * @param comment
     */
    public NoteLink(SwitchNode switchNode, Comment comment)
    {
        this.setSwitchTerminal1(switchNode);
        this.setCommentTerminal2(comment);
    }

    /**
     * @param variable
     * @param variable2
     */
    public NoteLink(Variable variable, Variable variable2)
    {
        this.setVarTerminal1(variable);
        this.setVarTerminal2(variable2);
    }

    /**
     * @param variable
     * @param assignment
     */
    public NoteLink(Variable variable, Assignment assignment)
    {
        this.setVarTerminal1(variable);
        this.setAssignmentTerminal2(assignment);
    }

    /**
     * @param assignment
     * @param variable
     */
    public NoteLink(Assignment assignment, Variable variable)
    {
        this.setAssignmentTerminal1(assignment);
        this.setVarTerminal2(variable);
    }

    /**
     * @param variable
     * @param return1
     */
    public NoteLink(Variable variable, Return return1)
    {
        this.setVarTerminal1(variable);
        this.setReturnTerminal2(return1);
    }

    /**
     * @param return1
     * @param variable
     */
    public NoteLink(Return return1, Variable variable)
    {
        this.setReturnTerminal1(return1);
        this.setVarTerminal2(variable);
    }

    /**
     * @param variable
     * @param message
     */
    public NoteLink(Variable variable, Message message)
    {
        this.setVarTerminal1(variable);
        this.setMessageTerminal2(message);
    }

    /**
     * @param message
     * @param variable
     */
    public NoteLink(Message message, Variable variable)
    {
        this.setMessageTerminal1(message);
        this.setVarTerminal2(variable);
    }

    /**
     * @param variable
     * @param task
     */
    public NoteLink(Variable variable, TaskPackage task)
    {
        this.setVarTerminal1(variable);
        this.setTaskTerminal2(task);
    }

    /**
     * @param task
     * @param variable
     */
    public NoteLink(TaskPackage task, Variable variable)
    {
        this.setTaskTerminal1(task);
        this.setVarTerminal2(variable);
    }

    /**
     * @param variable
     * @param task
     */
    public NoteLink(Variable variable, GenericTask task)
    {
        this.setVarTerminal1(variable);
        this.setGenericTerminal2(task);
    }

    /**
     * @param task
     * @param variable
     */
    public NoteLink(GenericTask task, Variable variable)
    {
        this.setGenericTerminal1(task);
        this.setVarTerminal2(variable);
    }

    /**
     * @param variable
     * @param doWhile
     */
    public NoteLink(Variable variable, DoWhileNode doWhile)
    {
        this.setVarTerminal1(variable);
        this.setDoWhileTerminal2(doWhile);
    }

    /**
     * @param doWhile
     * @param variable
     */
    public NoteLink(DoWhileNode doWhile, Variable variable)
    {
        this.setDoWhileTerminal1(doWhile);
        this.setVarTerminal2(variable);
    }

    /**
     * @param variable
     * @param whileNode
     */
    public NoteLink(Variable variable, WhileNode whileNode)
    {
        this.setVarTerminal1(variable);
        this.setWhileTerminal2(whileNode);
    }

    /**
     * @param whileNode
     * @param variable
     */
    public NoteLink(WhileNode whileNode, Variable variable)
    {
        this.setWhileTerminal1(whileNode);
        this.setVarTerminal2(variable);
    }

    /**
     * @param variable
     * @param forNode
     */
    public NoteLink(Variable variable, ForNode forNode)
    {
        this.setVarTerminal1(variable);
        this.setForTerminal2(forNode);
    }

    /**
     * @param forNode
     * @param variable
     */
    public NoteLink(ForNode forNode, Variable variable)
    {
        this.setForTerminal1(forNode);
        this.setVarTerminal2(variable);
    }

    /**
     * @param variable
     * @param switchNode
     */
    public NoteLink(Variable variable, SwitchNode switchNode)
    {
        this.setVarTerminal1(variable);
        this.setSwitchTerminal2(switchNode);
    }

    /**
     * @param switchNode
     * @param variable
     */
    public NoteLink(SwitchNode switchNode, Variable variable)
    {
        this.setSwitchTerminal1(switchNode);
        this.setVarTerminal2(variable);
    }

    // Note relationship with activity diagram common concepts.

    /**
     * @param note
     * @param initial
     */
    public NoteLink(Note note, InitialNode initial)
    {
        this.setNoteTerminal1(note);
        this.setInitialTerminal2(initial);
    }

    /**
     * @param initial
     * @param note
     */
    public NoteLink(InitialNode initial, Note note)
    {
        this.setInitialTerminal1(initial);
        this.setNoteTerminal2(note);
    }

    /**
     * @param note
     * @param finalNode
     */
    public NoteLink(Note note, FinalNode finalNode)
    {
        this.setNoteTerminal1(note);
        this.setFinalTerminal2(finalNode);
    }

    /**
     * @param finalNode
     * @param note
     */
    public NoteLink(FinalNode finalNode, Note note)
    {
        this.setFinalTerminal1(finalNode);
        this.setNoteTerminal2(note);
    }

    /**
     * @param note
     * @param finalNode
     */
    public NoteLink(Note note, FlowFinalNode finalNode)
    {
        this.setNoteTerminal1(note);
        this.setFlowFinalTerminal2(finalNode);
    }

    /**
     * @param finalNode
     * @param note
     */
    public NoteLink(FlowFinalNode finalNode, Note note)
    {
        this.setFlowFinalTerminal1(finalNode);
        this.setNoteTerminal2(note);
    }

    /**
     * @param note
     * @param activity
     */
    public NoteLink(Note note, Activity activity)
    {
        this.setNoteTerminal1(note);
        this.setActivityTerminal2(activity);
    }

    /**
     * @param activity
     * @param note
     */
    public NoteLink(Activity activity, Note note)
    {
        this.setActivityTerminal1(activity);
        this.setNoteTerminal2(note);
    }

    /**
     * @param note
     * @param decision
     */
    public NoteLink(Note note, DecisionNode decision)
    {
        this.setNoteTerminal1(note);
        this.setDecisionTerminal2(decision);
    }

    /**
     * @param decision
     * @param note
     */
    public NoteLink(DecisionNode decision, Note note)
    {
        this.setDecisionTerminal1(decision);
        this.setNoteTerminal2(note);
    }

    /**
     * @param note
     * @param merge
     */
    public NoteLink(Note note, MergeNode merge)
    {
        this.setNoteTerminal1(note);
        this.setMergeTerminal2(merge);
    }

    /**
     * @param merge
     * @param note
     */
    public NoteLink(MergeNode merge, Note note)
    {
        this.setMergeTerminal1(merge);
        this.setNoteTerminal2(note);
    }

    /**
     * @param note
     * @param fork
     */
    public NoteLink(Note note, ForkNode fork)
    {
        this.setNoteTerminal1(note);
        this.setForkTerminal2(fork);
    }

    /**
     * @param fork
     * @param note
     */
    public NoteLink(ForkNode fork, Note note)
    {
        this.setForkTerminal1(fork);
        this.setNoteTerminal2(note);
    }

    /**
     * @param note
     * @param join
     */
    public NoteLink(Note note, JoinNode join)
    {
        this.setNoteTerminal1(note);
        this.setJoinTerminal2(join);
    }

    /**
     * @param join
     * @param note
     */
    public NoteLink(JoinNode join, Note note)
    {
        this.setJoinTerminal1(join);
        this.setNoteTerminal2(note);
    }

    /**
     * @param note
     * @param action
     */
    public NoteLink(Note note, Action action)
    {
        this.setNoteTerminal1(note);
        this.setActionTerminal2(action);
    }

    /**
     * @param note
     * @param action
     */
    public NoteLink(Note note, AcceptEventAction action)
    {
        this.setNoteTerminal1(note);
        this.setAcceptEventTerminal2(action);
    }

    /**
     * @param action
     * @param note
     */
    public NoteLink(AcceptEventAction action, Note note)
    {
        this.setAcceptEventTerminal1(action);
        this.setNoteTerminal2(note);
    }

    /**
     * @param note
     * @param action
     */
    public NoteLink(Note note, AcceptTimeEventAction action)
    {
        this.setNoteTerminal1(note);
        this.setAcceptTimeEventTerminal2(action);
    }

    /**
     * @param action
     * @param note
     */
    public NoteLink(AcceptTimeEventAction action, Note note)
    {
        this.setAcceptTimeEventTerminal1(action);
        this.setNoteTerminal2(note);
    }

    /**
     * @param note
     * @param send
     */
    public NoteLink(Note note, SendSignal send)
    {
        this.setNoteTerminal1(note);
        this.setSendSignalTerminal2(send);
    }

    /**
     * @param send
     * @param note
     */
    public NoteLink(SendSignal send, Note note)
    {
        this.setSendSignalTerminal1(send);
        this.setNoteTerminal2(note);
    }

    /**
     * @param note
     * @param object
     */
    public NoteLink(Note note, ObjectNode object)
    {
        this.setNoteTerminal1(note);
        this.setObjectTerminal2(object);
    }

    /**
     * @param object
     * @param note
     */
    public NoteLink(ObjectNode object, Note note)
    {
        this.setObjectTerminal1(object);
        this.setNoteTerminal2(note);
    }

    /**
     * @param note
     * @param data
     */
    public NoteLink(Note note, DataStoreNode data)
    {
        this.setNoteTerminal1(note);
        this.setDataTerminal2(data);
    }

    /**
     * @param data
     * @param note
     */
    public NoteLink(DataStoreNode data, Note note)
    {
        this.setDataTerminal1(data);
        this.setNoteTerminal2(note);
    }

    /**
     * @param note
     * @param central
     */
    public NoteLink(Note note, CentralBufferNode central)
    {
        this.setNoteTerminal1(note);
        this.setCentralTerminal2(central);
    }

    /**
     * @param central
     * @param note
     */
    public NoteLink(CentralBufferNode central, Note note)
    {
        this.setCentralTerminal1(central);
        this.setNoteTerminal2(note);
    }

    /**
     * @param note
     * @param interruptible
     */
    public NoteLink(Note note, InterruptibleActivity interruptible)
    {
        this.setNoteTerminal1(note);
        this.setInterruptibleActivityTerminal2(interruptible);
    }

    /**
     * @param interruptible
     * @param note
     */
    public NoteLink(InterruptibleActivity interruptible, Note note)
    {
        this.setInterruptibleActivityTerminal1(interruptible);
        this.setNoteTerminal2(note);
    }

    /**
     * @param note
     * @param loop
     */
    public NoteLink(Note note, LoopNode loop)
    {
        this.setNoteTerminal1(note);
        this.setLoopTerminal2(loop);
    }

    /**
     * @param loop
     * @param note
     */
    public NoteLink(LoopNode loop, Note note)
    {
        this.setLoopTerminal1(loop);
        this.setNoteTerminal2(note);
    }

    /**
     * @param note
     * @param activity
     */
    public NoteLink(Note note, StructuredActivityNode activity)
    {
        this.setNoteTerminal1(note);
        this.setStructuredActivityTerminal2(activity);
    }

    /**
     * @param activity
     * @param note
     */
    public NoteLink(StructuredActivityNode activity, Note note)
    {
        this.setStructuredActivityTerminal1(activity);
        this.setNoteTerminal2(note);
    }

    /**
     * @param note
     * @param conditional
     */
    public NoteLink(Note note, ConditionalNode conditional)
    {
        this.setNoteTerminal1(note);
        this.setConditionalTerminal2(conditional);
    }

    /**
     * @param conditional
     * @param note
     */
    public NoteLink(ConditionalNode conditional, Note note)
    {
        this.setConditionalTerminal1(conditional);
        this.setNoteTerminal2(note);
    }

    /**
     * @param note
     * @param sequence
     */
    public NoteLink(Note note, SequenceNode sequence)
    {
        this.setNoteTerminal1(note);
        this.setSequenceTerminal2(sequence);
    }

    /**
     * @param sequence
     * @param note
     */
    public NoteLink(SequenceNode sequence, Note note)
    {
        this.setSequenceTerminal1(sequence);
        this.setNoteTerminal2(note);
    }

    /**
     * @param note
     * @param vertical
     */
    public NoteLink(Note note, VerticalSwinlane vertical)
    {
        this.setNoteTerminal1(note);
        this.setVerticalSwinlaneTerminal2(vertical);
    }

    /**
     * @param vertical
     * @param note
     */
    public NoteLink(VerticalSwinlane vertical, Note note)
    {
        this.setVerticalSwinlaneTerminal1(vertical);
        this.setNoteTerminal2(note);
    }

    /**
     * @param note
     * @param note2
     */
    public NoteLink(Note note, Note note2)
    {
        this.setNoteTerminal1(note);
        this.setNoteTerminal2(note2);
    }

    /**
     * @param note
     * @param assignment
     */
    public NoteLink(Note note, Assignment assignment)
    {
        this.setNoteTerminal1(note);
        this.setAssignmentTerminal2(assignment);
    }

    /**
     * @param assignment
     * @param note
     */
    public NoteLink(Assignment assignment, Note note)
    {
        this.setAssignmentTerminal1(assignment);
        this.setNoteTerminal2(note);
    }

    /**
     * @param note
     * @param return1
     */
    public NoteLink(Note note, Return return1)
    {
        this.setNoteTerminal1(note);
        this.setReturnTerminal2(return1);
    }

    /**
     * @param return1
     * @param note
     */
    public NoteLink(Return return1, Note note)
    {
        this.setReturnTerminal1(return1);
        this.setNoteTerminal2(note);
    }

    /**
     * @param note
     * @param message
     */
    public NoteLink(Note note, Message message)
    {
        this.setNoteTerminal1(note);
        this.setMessageTerminal2(message);
    }

    /**
     * @param message
     * @param note
     */
    public NoteLink(Message message, Note note)
    {
        this.setMessageTerminal1(message);
        this.setNoteTerminal2(note);
    }

    /**
     * @param note
     * @param task
     */
    public NoteLink(Note note, TaskPackage task)
    {
        this.setNoteTerminal1(note);
        this.setTaskTerminal2(task);
    }

    /**
     * @param task
     * @param note
     */
    public NoteLink(TaskPackage task, Note note)
    {
        this.setTaskTerminal1(task);
        this.setNoteTerminal2(note);
    }

    /**
     * @param note
     * @param task
     */
    public NoteLink(Note note, GenericTask task)
    {
        this.setNoteTerminal1(note);
        this.setGenericTerminal2(task);
    }

    /**
     * @param task
     * @param note
     */
    public NoteLink(GenericTask task, Note note)
    {
        this.setGenericTerminal1(task);
        this.setNoteTerminal2(note);
    }

    /**
     * @param note
     * @param var
     */
    public NoteLink(Note note, Variable var)
    {
        this.setNoteTerminal1(note);
        this.setVarTerminal2(var);
    }

    /**
     * @param var
     * @param note
     */
    public NoteLink(Variable var, Note note)
    {
        this.setVarTerminal1(var);
        this.setNoteTerminal2(note);
    }

    /**
     * @param note
     * @param doWhile
     */
    public NoteLink(Note note, DoWhileNode doWhile)
    {
        this.setNoteTerminal1(note);
        this.setDoWhileTerminal2(doWhile);
    }

    /**
     * @param doWhile
     * @param note
     */
    public NoteLink(DoWhileNode doWhile, Note note)
    {
        this.setDoWhileTerminal1(doWhile);
        this.setNoteTerminal2(note);
    }

    /**
     * @param note
     * @param whileNode
     */
    public NoteLink(Note note, WhileNode whileNode)
    {
        this.setNoteTerminal1(note);
        this.setWhileTerminal2(whileNode);
    }

    /**
     * @param whileNode
     * @param note
     */
    public NoteLink(WhileNode whileNode, Note note)
    {
        this.setWhileTerminal1(whileNode);
        this.setNoteTerminal2(note);
    }

    /**
     * @param note
     * @param forNode
     */
    public NoteLink(Note note, ForNode forNode)
    {
        this.setNoteTerminal1(note);
        this.setForTerminal2(forNode);
    }

    /**
     * @param forNode
     * @param note
     */
    public NoteLink(ForNode forNode, Note note)
    {
        this.setForTerminal1(forNode);
        this.setNoteTerminal2(note);
    }

    /**
     * @param note
     * @param switchNode
     */
    public NoteLink(Note note, SwitchNode switchNode)
    {
        this.setNoteTerminal1(note);
        this.setSwitchTerminal2(switchNode);
    }

    /**
     * @param switchNode
     * @param note
     */
    public NoteLink(SwitchNode switchNode, Note note)
    {
        this.setSwitchTerminal1(switchNode);
        this.setNoteTerminal2(note);
    }

    /**
     * @param note
     * @param comment
     */
    public NoteLink(Note note, Comment comment)
    {
        this.setCommentTerminal1(comment);
        this.setNoteTerminal2(note);
    }

    /**
     * @param comment
     * @param note
     */
    public NoteLink(Comment comment, Note note)
    {
        this.setNoteTerminal1(note);
        this.setCommentTerminal2(comment);
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#conceptName()
     */
    public String conceptName()
    {
        return I18NProperties.getString("comment.link.concept.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("comment.link.concept.name.for.tree") + name();
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
     * @return the initialTerminal2
     */
    public InitialNode getInitialTerminal2()
    {
        return initialTerminal2;
    }

    /**
     * @param initialTerminal2 the initialTerminal2 to set
     */
    public void setInitialTerminal2(InitialNode initialTerminal2)
    {
        this.initialTerminal2 = initialTerminal2;
    }

    /**
     * @return the finalTerminal1
     */
    public FinalNode getFinalTerminal1()
    {
        return finalTerminal1;
    }

    /**
     * @param finalTerminal1 the finalTerminal1 to set
     */
    public void setFinalTerminal1(FinalNode finalTerminal1)
    {
        this.finalTerminal1 = finalTerminal1;
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
     * @return the flowFinalTerminal1
     */
    public FlowFinalNode getFlowFinalTerminal1()
    {
        return flowFinalTerminal1;
    }

    /**
     * @param flowFinalTerminal1 the flowFinalTerminal1 to set
     */
    public void setFlowFinalTerminal1(FlowFinalNode flowFinalTerminal1)
    {
        this.flowFinalTerminal1 = flowFinalTerminal1;
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
     * @return the noteTerminal1
     */
    public Note getNoteTerminal1()
    {
        return noteTerminal1;
    }

    /**
     * @param noteTerminal1 the noteTerminal1 to set
     */
    public void setNoteTerminal1(Note noteTerminal1)
    {
        this.noteTerminal1 = noteTerminal1;
    }

    /**
     * @return the noteTerminal2
     */
    public Note getNoteTerminal2()
    {
        return noteTerminal2;
    }

    /**
     * @param noteTerminal2 the noteTerminal2 to set
     */
    public void setNoteTerminal2(Note noteTerminal2)
    {
        this.noteTerminal2 = noteTerminal2;
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
     * @return the dataTerminal1
     */
    public DataStoreNode getDataTerminal1()
    {
        return dataTerminal1;
    }

    /**
     * @param dataTerminal1 the dataTerminal1 to set
     */
    public void setDataTerminal1(DataStoreNode dataTerminal1)
    {
        this.dataTerminal1 = dataTerminal1;
    }

    /**
     * @return the dataTerminal2
     */
    public DataStoreNode getDataTerminal2()
    {
        return dataTerminal2;
    }

    /**
     * @param dataTerminal2 the dataTerminal2 to set
     */
    public void setDataTerminal2(DataStoreNode dataTerminal2)
    {
        this.dataTerminal2 = dataTerminal2;
    }

    /**
     * @return the centralTerminal1
     */
    public CentralBufferNode getCentralTerminal1()
    {
        return centralTerminal1;
    }

    /**
     * @param centralTerminal1 the centralTerminal1 to set
     */
    public void setCentralTerminal1(CentralBufferNode centralTerminal1)
    {
        this.centralTerminal1 = centralTerminal1;
    }

    /**
     * @return the centralTerminal2
     */
    public CentralBufferNode getCentralTerminal2()
    {
        return centralTerminal2;
    }

    /**
     * @param centralTerminal2 the centralTerminal2 to set
     */
    public void setCentralTerminal2(CentralBufferNode centralTerminal2)
    {
        this.centralTerminal2 = centralTerminal2;
    }

    /**
     * @return the interruptibleActivityTerminal1
     */
    public InterruptibleActivity getInterruptibleActivityTerminal1()
    {
        return interruptibleActivityTerminal1;
    }

    /**
     * @param interruptibleActivityTerminal1 the interruptibleActivityTerminal1 to set
     */
    public void setInterruptibleActivityTerminal1(
            InterruptibleActivity interruptibleActivityTerminal1)
    {
        this.interruptibleActivityTerminal1 = interruptibleActivityTerminal1;
    }

    /**
     * @return the interruptibleActivityTerminal2
     */
    public InterruptibleActivity getInterruptibleActivityTerminal2()
    {
        return interruptibleActivityTerminal2;
    }

    /**
     * @param interruptibleActivityTerminal2 the interruptibleActivityTerminal2 to set
     */
    public void setInterruptibleActivityTerminal2(
            InterruptibleActivity interruptibleActivityTerminal2)
    {
        this.interruptibleActivityTerminal2 = interruptibleActivityTerminal2;
    }

    /**
     * @return the verticalSwinlaneTerminal1
     */
    public VerticalSwinlane getVerticalSwinlaneTerminal1()
    {
        return verticalSwinlaneTerminal1;
    }

    /**
     * @param verticalSwinlaneTerminal1 the verticalSwinlaneTerminal1 to set
     */
    public void setVerticalSwinlaneTerminal1(VerticalSwinlane verticalSwinlaneTerminal1)
    {
        this.verticalSwinlaneTerminal1 = verticalSwinlaneTerminal1;
    }

    /**
     * @return the verticalSwinlaneTerminal2
     */
    public VerticalSwinlane getVerticalSwinlaneTerminal2()
    {
        return verticalSwinlaneTerminal2;
    }

    /**
     * @param verticalSwinlaneTerminal2 the verticalSwinlaneTerminal2 to set
     */
    public void setVerticalSwinlaneTerminal2(VerticalSwinlane verticalSwinlaneTerminal2)
    {
        this.verticalSwinlaneTerminal2 = verticalSwinlaneTerminal2;
    }

    /**
     * @return the doWhileTerminal1
     */
    public DoWhileNode getDoWhileTerminal1()
    {
        return doWhileTerminal1;
    }

    /**
     * @param doWhileTerminal1 the doWhileTerminal1 to set
     */
    public void setDoWhileTerminal1(DoWhileNode doWhileTerminal1)
    {
        this.doWhileTerminal1 = doWhileTerminal1;
    }

    /**
     * @return the doWhileTerminal2
     */
    public DoWhileNode getDoWhileTerminal2()
    {
        return doWhileTerminal2;
    }

    /**
     * @param doWhileTerminal2 the doWhileTerminal2 to set
     */
    public void setDoWhileTerminal2(DoWhileNode doWhileTerminal2)
    {
        this.doWhileTerminal2 = doWhileTerminal2;
    }

    /**
     * @return the whileTerminal1
     */
    public WhileNode getWhileTerminal1()
    {
        return whileTerminal1;
    }

    /**
     * @param whileTerminal1 the whileTerminal1 to set
     */
    public void setWhileTerminal1(WhileNode whileTerminal1)
    {
        this.whileTerminal1 = whileTerminal1;
    }

    /**
     * @return the whileTerminal2
     */
    public WhileNode getWhileTerminal2()
    {
        return whileTerminal2;
    }

    /**
     * @param whileTerminal2 the whileTerminal2 to set
     */
    public void setWhileTerminal2(WhileNode whileTerminal2)
    {
        this.whileTerminal2 = whileTerminal2;
    }

    /**
     * @return the forTerminal1
     */
    public ForNode getForTerminal1()
    {
        return forTerminal1;
    }

    /**
     * @param forTerminal1 the forTerminal1 to set
     */
    public void setForTerminal1(ForNode forTerminal1)
    {
        this.forTerminal1 = forTerminal1;
    }

    /**
     * @return the forTerminal2
     */
    public ForNode getForTerminal2()
    {
        return forTerminal2;
    }

    /**
     * @param forTerminal2 the forTerminal2 to set
     */
    public void setForTerminal2(ForNode forTerminal2)
    {
        this.forTerminal2 = forTerminal2;
    }

    /**
     * @return the switchTerminal1
     */
    public SwitchNode getSwitchTerminal1()
    {
        return switchTerminal1;
    }

    /**
     * @param switchTerminal1 the switchTerminal1 to set
     */
    public void setSwitchTerminal1(SwitchNode switchTerminal1)
    {
        this.switchTerminal1 = switchTerminal1;
    }

    /**
     * @return the switchTerminal2
     */
    public SwitchNode getSwitchTerminal2()
    {
        return switchTerminal2;
    }

    /**
     * @param switchTerminal2 the switchTerminal2 to set
     */
    public void setSwitchTerminal2(SwitchNode switchTerminal2)
    {
        this.switchTerminal2 = switchTerminal2;
    }

}
