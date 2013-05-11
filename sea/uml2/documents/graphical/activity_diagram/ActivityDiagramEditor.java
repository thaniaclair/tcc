/*
 * @(#)ActivityDiagramEditor.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Mar 3, 2008        descrição
 */
package documents.graphical.activity_diagram;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.*;

import ocean.framework.Concept;
import ocean.jhotdraw.*;
import CH.ifa.draw.framework.Tool;
import CH.ifa.draw.standard.*;
import documents.concepts.activity_diagram.*;
import documents.concepts.activity_diagram.Action;
import documents.concepts.communication_diagram.Label;
import documents.util.I18NPrinter;
import documents.util.I18NProperties;

public class ActivityDiagramEditor extends SpecificationEditor
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 9075136729660599987L;

    /**
     * Diagram images path.
     */
    protected final static String FG_ACTIVITY_DIAGRAM_PATH = new String(
            "/ocean/documents/oo/graphical/activityDiagram2/");

    /**
     * The second tool bar.
     */
    protected JToolBar tools2;

    /**
     * The third tool bar.
     */
    protected JToolBar tools3;

    /**
     * Overloaded constructor.
     * 
     * @param view
     */
    public ActivityDiagramEditor(ActivityDiagramDrawingView view)
    {
        super(view);
    }

    /**
     * Official constructor.
     */
    public ActivityDiagramEditor()
    {
        super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationEditor#createDrawingViewObject()
     */
    @Override
    protected SpecificationDrawingView createDrawingViewObject()
    {
        return new ActivityDiagramDrawingView(this);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationEditor#createSpecificationDrawing()
     */
    @Override
    protected SpecificationDrawing createSpecificationDrawing()
    {
        return new ActivityDiagramDrawing();
    }

    /*
     * (non-Javadoc)ackage
     * 
     * @see ocean.jhotdraw.SpecificationEditor#createTools(javax.swing.JToolBar)
     */
    @Override
    protected void createTools(JToolBar palette)
    {

        // COMMON TOOLS

        super.createTools(palette);

        // INITIAL NODE
        Tool tool = this.createFigureTool(new InitialNodeFigure(), InitialNode.class,
            "initial.node.not.created");
        ToolButton tB = createToolButton(FG_ACTIVITY_DIAGRAM_PATH
                + I18NProperties.getString("initial.node"), I18NProperties
            .getString("new.initial.node"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // FINAL NODE
        tool = this.createFigureTool(new FinalNodeFigure(), FinalNode.class,
            "final.node.not.created");
        tB = createToolButton(FG_ACTIVITY_DIAGRAM_PATH + I18NProperties.getString("final.node"),
            I18NProperties.getString("new.final.node"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // FLOW FINAL NODE
        tool = this.createFigureTool(new FlowFinalNodeFigure(), FlowFinalNode.class,
            "flow.final.node.not.created");
        tB = createToolButton(FG_ACTIVITY_DIAGRAM_PATH
                + I18NProperties.getString("flow.final.node"), I18NProperties
            .getString("new.flow.final.node"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // DECISION NODE
        tool = this.createFigureTool(new DecisionNodeFigure(), DecisionNode.class,
            "decision.node.not.created");
        tB = createToolButton(FG_ACTIVITY_DIAGRAM_PATH + I18NProperties.getString("decision.node"),
            I18NProperties.getString("new.decision.node"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // MERGE NODE
        tool = this.createFigureTool(new MergeNodeFigure(), MergeNode.class,
            "merge.node.not.created");
        tB = createToolButton(FG_ACTIVITY_DIAGRAM_PATH + I18NProperties.getString("merge.node"),
            I18NProperties.getString("new.merge.node"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // FORK NODE
        tool = this.createFigureTool(new ForkNodeFigure(), ForkNode.class, "fork.node.not.created");
        tB = createToolButton(FG_ACTIVITY_DIAGRAM_PATH + I18NProperties.getString("fork.node"),
            I18NProperties.getString("new.fork.node"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // JOIN NODE
        tool = this.createFigureTool(new JoinNodeFigure(), JoinNode.class, "join.node.not.created");
        tB = createToolButton(FG_ACTIVITY_DIAGRAM_PATH + I18NProperties.getString("join.node"),
            I18NProperties.getString("new.join.node"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // CONTROL FLOW
        tool = this.createLineTool(new ControlFlowFigure(), ControlFlow.class);
        tB = createToolButton(FG_ACTIVITY_DIAGRAM_PATH + I18NProperties.getString("control.flow"),
            I18NProperties.getString("new.control.flow"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // ACTIVITY LABEL
        tool = this.createFigureTool(new ActivityLabelFigure(), Label.class,
            "activity.label.not.created");
        tB = createToolButton(
            FG_ACTIVITY_DIAGRAM_PATH + I18NProperties.getString("activity.label"), I18NProperties
                .getString("new.activity.label"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // NOTE
        tool = this.createFigureTool(new NoteFigure(), Note.class, "note.not.created");
        tB = createToolButton(FG_ACTIVITY_DIAGRAM_PATH + I18NProperties.getString("note"),
            I18NProperties.getString("new.note"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // COMMENT LINK
        tool = this.createLineTool(new CommentLinkFigure(), NoteLink.class);
        tB = createToolButton(FG_ACTIVITY_DIAGRAM_PATH + I18NProperties.getString("comment.link"),
            I18NProperties.getString("new.comment.link"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // VERTICAL SWINLANE
        tool = this.createFigureTool(new VerticalSwinlaneFigure(), VerticalSwinlane.class,
            "vertical.swinlane.not.created");
        tB = createToolButton(FG_ACTIVITY_DIAGRAM_PATH
                + I18NProperties.getString("vertical.swinlane"), I18NProperties
            .getString("new.vertical.swinlane"), tool);
        tB.setEnabled(true);
        palette.add(tB);

    }

    /**
     * Creates the second tool bar.
     * 
     * @param palette
     */
    protected void createTools2(JToolBar palette)
    {

        // ACTIVITY TOOLS

        // ACTIVITY
        Tool tool = this.createFigureTool(new ActivityFigure(), Activity.class,
            "activity.not.created");
        ToolButton tB = createToolButton(FG_ACTIVITY_DIAGRAM_PATH
                + I18NProperties.getString("activity"), I18NProperties.getString("new.activity"),
            tool);
        tB.setEnabled(true);
        palette.add(tB);

        // ACTION
        tool = this.createFigureTool(new ActionFigure(), Action.class, "action.not.created");
        tB = createToolButton(FG_ACTIVITY_DIAGRAM_PATH + I18NProperties.getString("action"),
            I18NProperties.getString("new.action"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // ACCEPT EVENT ACTION
        tool = this.createFigureTool(new AcceptEventActionFigure(), AcceptEventAction.class,
            "accept.event.action.not.created");
        tB = createToolButton(FG_ACTIVITY_DIAGRAM_PATH
                + I18NProperties.getString("accept.event.action"), I18NProperties
            .getString("new.accept.event.action"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // SEND SIGNAL
        tool = this.createFigureTool(new SendSignalFigure(), SendSignal.class,
            "send.signal.not.created");
        tB = createToolButton(FG_ACTIVITY_DIAGRAM_PATH + I18NProperties.getString("send.signal"),
            I18NProperties.getString("new.send.signal"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // ACCEPT TIME EVENT ACTION
        tool = this.createFigureTool(new AcceptTimeEventActionFigure(),
            AcceptTimeEventAction.class, "accept.time.event.action.not.created");
        tB = createToolButton(FG_ACTIVITY_DIAGRAM_PATH
                + I18NProperties.getString("accept.time.event.action"), I18NProperties
            .getString("new.accept.time.event.action"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // OBJECT NODE
        tool = this.createFigureTool(new ObjectNodeFigure(), ObjectNode.class,
            "object.node.not.created");
        tB = createToolButton(FG_ACTIVITY_DIAGRAM_PATH + I18NProperties.getString("object.node"),
            I18NProperties.getString("new.object.node"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // CENTRAL BUFFER NODE
        tool = this.createFigureTool(new CentralBufferNodeFigure(), CentralBufferNode.class,
            "central.buffer.node.not.created");
        tB = createToolButton(FG_ACTIVITY_DIAGRAM_PATH
                + I18NProperties.getString("central.buffer.node"), I18NProperties
            .getString("new.central.buffer.node"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // DATA STORE NODE
        tool = this.createFigureTool(new DataStoreNodeFigure(), DataStoreNode.class,
            "data.store.node.not.created");
        tB = createToolButton(FG_ACTIVITY_DIAGRAM_PATH
                + I18NProperties.getString("data.store.node"), I18NProperties
            .getString("new.data.store.node"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // OBJECT FLOW
        tool = this.createLineTool(new ObjectFlowFigure(), ObjectFlow.class);
        tB = createToolButton(FG_ACTIVITY_DIAGRAM_PATH + I18NProperties.getString("object.flow"),
            I18NProperties.getString("new.object.flow"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // EXCEPTION HANDLER
        tool = this.createFigureTool(new ExceptionHandlerFigure(), ExceptionHandler.class,
            "exception.handler.not.created");
        tB = createToolButton(FG_ACTIVITY_DIAGRAM_PATH
                + I18NProperties.getString("exception.handler"), I18NProperties
            .getString("new.exception.handler"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // INTERRUPTIBLE ACTIVITY
        tool = this.createFigureTool(new InterruptibleActivityFigure(),
            InterruptibleActivity.class, "interruptible.activity.not.created");
        tB = createToolButton(FG_ACTIVITY_DIAGRAM_PATH
                + I18NProperties.getString("interruptible.activity"), I18NProperties
            .getString("new.interruptible.activity"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // LOOP NODE
        tool = this.createFigureTool(new LoopNodeFigure(), LoopNode.class, "loop.node.not.created");
        tB = createToolButton(FG_ACTIVITY_DIAGRAM_PATH + I18NProperties.getString("loop.node"),
            I18NProperties.getString("new.loop.node"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // STRUCTURED ACTIVITY NODE
        tool = this.createFigureTool(new StructuredActivityNodeFigure(),
            StructuredActivityNode.class, "structured.activity.node.not.created");
        tB = createToolButton(FG_ACTIVITY_DIAGRAM_PATH
                + I18NProperties.getString("structured.activity.node"), I18NProperties
            .getString("new.structured.activity.node"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // CONDITIONAL NODE
        tool = this.createFigureTool(new ConditionalNodeFigure(), ConditionalNode.class,
            "conditional.node.not.created");
        tB = createToolButton(FG_ACTIVITY_DIAGRAM_PATH
                + I18NProperties.getString("conditional.node"), I18NProperties
            .getString("new.conditional.node"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // SEQUENCE NODE
        tool = this.createFigureTool(new SequenceNodeFigure(), SequenceNode.class,
            "sequence.node.not.created");
        tB = createToolButton(FG_ACTIVITY_DIAGRAM_PATH + I18NProperties.getString("sequence.node"),
            I18NProperties.getString("new.sequence.node"), tool);
        tB.setEnabled(true);
        palette.add(tB);

    }

    /**
     * Creates the third tool bar.
     * 
     * @param palette
     */
    protected void createTools3(JToolBar palette)
    {
        // CUSTOM TOOLS

        // ASSIGNMENT
        Tool tool = this.createFigureTool(new AssignmentFigure(), Assignment.class,
            "assignment.not.created");
        ToolButton tB = createToolButton(FG_ACTIVITY_DIAGRAM_PATH
                + I18NProperties.getString("assignment"), I18NProperties
            .getString("new.assignment"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // RETURN
        tool = this.createFigureTool(new ReturnFigure(), Return.class, "return.not.created");
        tB = createToolButton(FG_ACTIVITY_DIAGRAM_PATH + I18NProperties.getString("return"),
            I18NProperties.getString("new.return"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // MESSAGE
        tool = this.createFigureTool(new MessageFigure(), Message.class,
            "message.activity.not.created");
        tB = createToolButton(FG_ACTIVITY_DIAGRAM_PATH
                + I18NProperties.getString("message.activity"), I18NProperties
            .getString("new.message.activity"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // TASK PACKAGE
        tool = this.createFigureTool(new TaskPackageFigure(), TaskPackage.class,
            "task.package.not.created");
        tB = createToolButton(FG_ACTIVITY_DIAGRAM_PATH + I18NProperties.getString("task.package"),
            I18NProperties.getString("new.task.package"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // GENERIC TASK
        tool = this.createFigureTool(new GenericTaskFigure(), GenericTask.class,
            "generic.task.not.created");
        tB = createToolButton(FG_ACTIVITY_DIAGRAM_PATH + I18NProperties.getString("generic.task"),
            I18NProperties.getString("new.generic.task"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // COMMENT
        tool = this.createFigureTool(new CommentFigure(), Comment.class, "comment.not.created");
        tB = createToolButton(FG_ACTIVITY_DIAGRAM_PATH + I18NProperties.getString("comment"),
            I18NProperties.getString("new.comment"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // VAR
        tool = this.createFigureTool(new VariableFigure(), Variable.class, "var.not.created");
        tB = createToolButton(FG_ACTIVITY_DIAGRAM_PATH + I18NProperties.getString("var"),
            I18NProperties.getString("new.var"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // IF
        tool = new CreationTool(this, new IfNodeFigure())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.CreationTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                Concept conc = getModel().createComponent(IfNode.class);

                if (conc == null)
                {
                    I18NPrinter.printMessage("if.not.created");
                }
                else
                {
                    IfNodeFigure ifFigure = ((IfNodeFigure) getCreatedFigure());
                    ifFigure.concept(conc);
                    conc.getObservable().addObserver(ifFigure);
                    ifFigure.setDrawing((ActivityDiagramDrawing) getDrawing());
                    conc.redraw();
                }

                super.mouseUp(e, x, y);
            }
        };
        tB = createToolButton(FG_ACTIVITY_DIAGRAM_PATH + I18NProperties.getString("if"),
            I18NProperties.getString("new.if"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // IF/ELSE
        tool = new CreationTool(this, new IfElseNodeFigure())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.CreationTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                Concept conc = getModel().createComponent(IfElseNode.class);

                if (conc == null)
                {
                    I18NPrinter.printMessage("if.else.not.created");
                }
                else
                {
                    IfElseNodeFigure ifElseFigure = ((IfElseNodeFigure) getCreatedFigure());
                    ifElseFigure.concept(conc);
                    conc.getObservable().addObserver(ifElseFigure);
                    ifElseFigure.setDrawing((ActivityDiagramDrawing) getDrawing());
                    conc.redraw();
                }

                super.mouseUp(e, x, y);
            }
        };
        tB = createToolButton(FG_ACTIVITY_DIAGRAM_PATH + I18NProperties.getString("if.else"),
            I18NProperties.getString("new.if.else"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // FOR
        tool = this.createFigureTool(new ForNodeFigure(), ForNode.class, "for.not.created");
        tB = createToolButton(FG_ACTIVITY_DIAGRAM_PATH + I18NProperties.getString("for"),
            I18NProperties.getString("new.for"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // WHILE
        tool = this.createFigureTool(new WhileNodeFigure(), WhileNode.class, "while.not.created");
        tB = createToolButton(FG_ACTIVITY_DIAGRAM_PATH + I18NProperties.getString("while"),
            I18NProperties.getString("new.while"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // DO
        tool = this.createFigureTool(new DoWhileNodeFigure(), DoWhileNode.class, "do.not.created");
        tB = createToolButton(FG_ACTIVITY_DIAGRAM_PATH + I18NProperties.getString("do"),
            I18NProperties.getString("new.do"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // SWITCH
        tool = this
            .createFigureTool(new SwitchNodeFigure(), SwitchNode.class, "switch.not.created");
        tB = createToolButton(FG_ACTIVITY_DIAGRAM_PATH + I18NProperties.getString("switch"),
            I18NProperties.getString("new.switch"), tool);
        tB.setEnabled(true);
        palette.add(tB);
    }

    /**
     * Creates a tool instance.
     * 
     * @param figure
     * @param conceptClass
     * @param keyString
     * @return
     */
    public Tool createFigureTool(final SpecificationCompositeFigure figure,
            final Class< ? > conceptClass, final String keyString)
    {

        Tool tool = new CreationTool(this, figure)
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.CreationTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                Concept conc = getModel().createComponent(conceptClass);

                if (conc == null)
                {
                    I18NPrinter.printMessage(keyString);
                }
                else
                {
                    figure.getClass().cast(getCreatedFigure()).concept(conc);
                    conc.getObservable().addObserver(figure.getClass().cast(getCreatedFigure()));
                    conc.redraw();
                }

                super.mouseUp(e, x, y);
            }
        };

        return tool;
    }

    /**
     * Creates a line tool.
     * 
     * @param figure
     * @param conceptClass
     * @return
     */
    public Tool createLineTool(final SpecificationLineFigure figure, final Class< ? > conceptClass)
    {

        Tool tool = new ConnectionTool(this, figure)
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.ConnectionTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                SpecificationLineFigure line = figure.getClass().cast(getConnection());
                super.mouseUp(e, x, y);

                if (stopCreateConcept(line))
                {
                    return;
                }

                Concept start = ((SpecificationCompositeFigure) line.startFigure()).concept();
                Concept end = ((SpecificationCompositeFigure) line.endFigure()).concept();

                Concept conc = getModel().createComponent_with_and(line.relatedConceptClass(),
                    start, end);

                if (conc == null)
                {
                    getDrawing().remove(line);
                }

                line.concept(conc);

            }

        };
        return tool;
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationEditor#open(ocean.jhotdraw.SpecificationDrawingView)
     */
    protected void open(SpecificationDrawingView newDrawingView)
    {

        final JPanel panel = new JPanel();

        setLayout(new BorderLayout());

        initializeFormat();

        fStatusLine = createStatusLine();

        setView(newDrawingView);

        setTool(new NullTool(this), "");

        // COMMOM TOOLS
        this.tools = createToolPalette();
        this.tools.setToolTipText(I18NProperties.getString("common.tools"));
        createTools(this.tools);

        JPanel innerPanel = new JPanel();
        innerPanel.setLayout(new BorderLayout());
        innerPanel.setSize(this.tools.getSize().height, tools.getSize().width);
        innerPanel.add(this.tools, BorderLayout.CENTER);

        // Added options bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu(I18NProperties.getString("options.menu"));
        final JMenuItem item1 = new JMenuItem(I18NProperties.getString("hide.custom.tools"));
        final JMenuItem item2 = new JMenuItem(I18NProperties.getString("show.custom.tools"));
        final JPopupMenu.Separator separator1 = new JPopupMenu.Separator();
        final JPopupMenu.Separator separator2 = new JPopupMenu.Separator();
        menu.add(item1);
        item1.addActionListener(new ActionListener()
        {

            /*
             * (non-Javadoc)
             * 
             * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
             */
            public void actionPerformed(ActionEvent e)
            {
                ActivityDiagramEditor.this.tools3.setVisible(false);
                panel.setSize(ActivityDiagramEditor.this.tools.getSize().height * 2,
                    ActivityDiagramEditor.this.getSize().width * 2);
                item1.setVisible(false);
                separator1.setVisible(false);
                item2.setVisible(true);
                separator2.setVisible(true);
            }
        });
        item1.setVisible(false);
        separator1.setVisible(false);
        menu.add(separator1);
        menu.add(item2);
        item2.addActionListener(new ActionListener()
        {

            /*
             * (non-Javadoc)
             * 
             * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
             */
            public void actionPerformed(ActionEvent e)
            {
                ActivityDiagramEditor.this.tools3.setVisible(true);
                panel.setSize(ActivityDiagramEditor.this.tools.getSize().height * 3,
                    ActivityDiagramEditor.this.getSize().width * 3);
                item2.setVisible(false);
                separator2.setVisible(false);
                item1.setVisible(true);
                separator1.setVisible(true);
            }
        });
        menu.add(separator2);

        final JMenuItem item3 = new JMenuItem(I18NProperties.getString("hide.activity.tools"));
        final JMenuItem item4 = new JMenuItem(I18NProperties.getString("show.activity.tools"));
        menu.add(item3);
        item3.addActionListener(new ActionListener()
        {

            /*
             * (non-Javadoc)
             * 
             * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
             */
            public void actionPerformed(ActionEvent e)
            {
                ActivityDiagramEditor.this.tools2.setVisible(false);
                panel.setSize(ActivityDiagramEditor.this.tools.getSize().height * 2,
                    ActivityDiagramEditor.this.getSize().width * 2);
                item3.setVisible(false);
                item4.setVisible(true);
            }
        });
        menu.add(item4);
        item4.addActionListener(new ActionListener()
        {

            /*
             * (non-Javadoc)
             * 
             * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
             */
            public void actionPerformed(ActionEvent e)
            {
                ActivityDiagramEditor.this.tools2.setVisible(true);
                panel.setSize(ActivityDiagramEditor.this.tools.getSize().height * 3,
                    ActivityDiagramEditor.this.getSize().width * 3);
                item4.setVisible(false);
                item3.setVisible(true);
            }
        });
        item4.setVisible(false);
        menuBar.add(menu);
        innerPanel.add(menuBar, BorderLayout.EAST);

        // ACTIVITY TOOLS
        this.tools2 = createToolPalette();
        this.tools2.setToolTipText(I18NProperties.getString("activity.diagram.tools"));
        createTools2(this.tools2);

        // CUSTOM TOOLS
        this.tools3 = createToolPalette();
        this.tools3.setToolTipText(I18NProperties.getString("custom.tools"));
        this.tools3.setVisible(false);
        createTools3(this.tools3);

        this.add(fStatusLine, BorderLayout.SOUTH);

        createContents(view(), BorderLayout.CENTER);

        panel.setLayout(new BorderLayout());
        panel.setSize(this.tools.getSize().height * 2, tools.getSize().width * 2);

        panel.add(innerPanel, BorderLayout.NORTH);
        panel.add(this.tools2, BorderLayout.CENTER);
        panel.add(this.tools3, BorderLayout.SOUTH);

        this.add(panel, BorderLayout.NORTH);

        toolDone();
    }
}
