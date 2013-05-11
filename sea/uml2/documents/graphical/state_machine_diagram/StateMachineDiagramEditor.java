/*
 * @(#)StateMachineDiagramEditor.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Feb 21, 2008        descrição
 */
package documents.graphical.state_machine_diagram;

import java.awt.event.MouseEvent;

import javax.swing.JToolBar;

import ocean.framework.Concept;
import ocean.jhotdraw.*;
import CH.ifa.draw.framework.Tool;
import CH.ifa.draw.standard.ConnectionTool;
import CH.ifa.draw.standard.CreationTool;
import CH.ifa.draw.standard.ToolButton;
import documents.concepts.state_machine_diagram.*;
import documents.util.I18NPrinter;
import documents.util.I18NProperties;

public class StateMachineDiagramEditor extends SpecificationEditor
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -4780637064592542680L;

    /**
     * Diagram image path.
     */
    protected final static String FG_STATE_MACHINE_DIAGRAM_PATH = new String(
            "/ocean/documents/oo/graphical/stateMachineDiagram/");

    /**
     * Overloaded constructor.
     * 
     * @param view
     */
    public StateMachineDiagramEditor(StateMachineDiagramDrawingView view)
    {
        super(view);
    }

    /**
     * Official constructor.
     */
    public StateMachineDiagramEditor()
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
        return new StateMachineDiagramDrawingView(this);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationEditor#createSpecificationDrawing()
     */
    @Override
    protected SpecificationDrawing createSpecificationDrawing()
    {
        return new StateMachineDiagramDrawing();
    }

    /*
     * (non-Javadoc)ackage
     * 
     * @see ocean.jhotdraw.SpecificationEditor#createTools(javax.swing.JToolBar)
     */
    @Override
    protected void createTools(JToolBar palette)
    {
        super.createTools(palette);

        // INITIAL STATE
        Tool tool = new CreationTool(this, new InitialStateFigure())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.CreationTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                Concept conc = getModel().createComponent(InitialState.class);

                if (conc == null)
                {
                    I18NPrinter.printMessage("initial.state.not.created");
                }
                else
                {
                    ((InitialStateFigure) getCreatedFigure()).concept(conc);
                    conc.getObservable().addObserver((InitialStateFigure) getCreatedFigure());
                    conc.redraw();
                }
                super.mouseUp(e, x, y);
            }

        };
        ToolButton tB = createToolButton(FG_STATE_MACHINE_DIAGRAM_PATH
                + I18NProperties.getString("initial.state"), I18NProperties
            .getString("new.initial.state"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // FINAL STATE
        tool = new CreationTool(this, new FinalStateFigure())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.CreationTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                Concept conc = getModel().createComponent(FinalState.class);

                if (conc == null)
                {
                    I18NPrinter.printMessage("final.state.not.created");
                }
                else
                {
                    ((FinalStateFigure) getCreatedFigure()).concept(conc);
                    conc.getObservable().addObserver((FinalStateFigure) getCreatedFigure());
                    conc.redraw();
                }
                super.mouseUp(e, x, y);
            }

        };
        tB = createToolButton(FG_STATE_MACHINE_DIAGRAM_PATH
                + I18NProperties.getString("final.state"), I18NProperties
            .getString("new.final.state"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // STATE
        tool = new CreationTool(this, new StateFigure())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.CreationTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                Concept conc = getModel().createComponent(State.class);

                if (conc == null)
                {
                    I18NPrinter.printMessage("state.not.created");
                }
                else
                {
                    StateFigure stateFig = (StateFigure) getCreatedFigure();
                    stateFig.concept(conc);
                    stateFig.setDrawing((StateMachineDiagramDrawing) getDrawing());
                    conc.getObservable().addObserver(stateFig);
                    conc.redraw();
                }
                super.mouseUp(e, x, y);
            }

        };
        tB = createToolButton(FG_STATE_MACHINE_DIAGRAM_PATH + I18NProperties.getString("state"),
            I18NProperties.getString("new.state"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // SUBMACHINE STATE
        tool = new CreationTool(this, new SubmachineStateFigure())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.CreationTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                Concept conc = getModel().createComponent(SubmachineState.class);

                if (conc == null)
                {
                    I18NPrinter.printMessage("submachine.state.not.created");
                }
                else
                {
                    ((SubmachineStateFigure) getCreatedFigure()).concept(conc);
                    conc.getObservable().addObserver((SubmachineStateFigure) getCreatedFigure());
                    conc.redraw();
                }
                super.mouseUp(e, x, y);
            }

        };
        tB = createToolButton(FG_STATE_MACHINE_DIAGRAM_PATH
                + I18NProperties.getString("submachine.state"), I18NProperties
            .getString("new.submachine.state"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // TRANSITION
        tool = new ConnectionTool(this, new TransitionFigure())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.ConnectionTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                TransitionFigure line = (TransitionFigure) getConnection();
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
        tB = createToolButton(FG_STATE_MACHINE_DIAGRAM_PATH
                + I18NProperties.getString("transition"), I18NProperties
            .getString("new.transition"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // CHOICE
        tool = new CreationTool(this, new ChoiceFigure())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.CreationTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                Concept conc = getModel().createComponent(Choice.class);

                if (conc == null)
                {
                    I18NPrinter.printMessage("choice.not.created");
                }
                else
                {
                    ((ChoiceFigure) getCreatedFigure()).concept(conc);
                    conc.getObservable().addObserver((ChoiceFigure) getCreatedFigure());
                    conc.redraw();
                }
                super.mouseUp(e, x, y);
            }

        };
        tB = createToolButton(FG_STATE_MACHINE_DIAGRAM_PATH + I18NProperties.getString("choice"),
            I18NProperties.getString("new.choice"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // FORK
        tool = new CreationTool(this, new ForkFigure())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.CreationTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                Concept conc = getModel().createComponent(Fork.class);

                if (conc == null)
                {
                    I18NPrinter.printMessage("fork.not.created");
                }
                else
                {
                    ((ForkFigure) getCreatedFigure()).concept(conc);
                    conc.getObservable().addObserver((ForkFigure) getCreatedFigure());
                    conc.redraw();
                }
                super.mouseUp(e, x, y);
            }

        };
        tB = createToolButton(FG_STATE_MACHINE_DIAGRAM_PATH + I18NProperties.getString("fork"),
            I18NProperties.getString("new.fork"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // JOIN
        tool = new CreationTool(this, new JoinFigure())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.CreationTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                Concept conc = getModel().createComponent(Join.class);

                if (conc == null)
                {
                    I18NPrinter.printMessage("join.not.created");
                }
                else
                {
                    ((JoinFigure) getCreatedFigure()).concept(conc);
                    conc.getObservable().addObserver((JoinFigure) getCreatedFigure());
                    conc.redraw();
                }
                super.mouseUp(e, x, y);
            }

        };
        tB = createToolButton(FG_STATE_MACHINE_DIAGRAM_PATH + I18NProperties.getString("join"),
            I18NProperties.getString("new.join"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // JUNCTION
        tool = new CreationTool(this, new JunctionFigure())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.CreationTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                Concept conc = getModel().createComponent(Junction.class);

                if (conc == null)
                {
                    I18NPrinter.printMessage("junction.not.created");
                }
                else
                {
                    ((JunctionFigure) getCreatedFigure()).concept(conc);
                    conc.getObservable().addObserver((JunctionFigure) getCreatedFigure());
                    conc.redraw();
                }
                super.mouseUp(e, x, y);
            }

        };
        tB = createToolButton(FG_STATE_MACHINE_DIAGRAM_PATH + I18NProperties.getString("junction"),
            I18NProperties.getString("new.junction"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // ENTRY POINT
        tool = new CreationTool(this, new EntryPointFigure())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.CreationTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                Concept conc = getModel().createComponent(EntryPoint.class);

                if (conc == null)
                {
                    I18NPrinter.printMessage("entry.point.not.created");
                }
                else
                {
                    EntryPointFigure entryPoint = (EntryPointFigure) getCreatedFigure();
                    entryPoint.concept(conc);
                    entryPoint.setDrawing((StateMachineDiagramDrawing) getDrawing());
                    conc.getObservable().addObserver(entryPoint);
                    conc.redraw();
                }
                super.mouseUp(e, x, y);
            }

        };
        tB = createToolButton(FG_STATE_MACHINE_DIAGRAM_PATH
                + I18NProperties.getString("entry.point"), I18NProperties
            .getString("new.entry.point"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // EXIT POINT
        tool = new CreationTool(this, new ExitPointFigure())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.CreationTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                Concept conc = getModel().createComponent(ExitPoint.class);

                if (conc == null)
                {
                    I18NPrinter.printMessage("exit.point.not.created");
                }
                else
                {
                    ExitPointFigure exitFig = (ExitPointFigure) getCreatedFigure();
                    exitFig.concept(conc);
                    exitFig.setDrawing((StateMachineDiagramDrawing) getDrawing());
                    conc.getObservable().addObserver(exitFig);
                    conc.redraw();
                }
                super.mouseUp(e, x, y);
            }

        };
        tB = createToolButton(FG_STATE_MACHINE_DIAGRAM_PATH
                + I18NProperties.getString("exit.point"), I18NProperties
            .getString("new.exit.point"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // TERMINATE
        tool = new CreationTool(this, new TerminateFigure())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.CreationTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                Concept conc = getModel().createComponent(Terminate.class);

                if (conc == null)
                {
                    I18NPrinter.printMessage("terminate.not.created");
                }
                else
                {
                    ((TerminateFigure) getCreatedFigure()).concept(conc);
                    conc.getObservable().addObserver((TerminateFigure) getCreatedFigure());
                    conc.redraw();
                }
                super.mouseUp(e, x, y);
            }

        };
        tB = createToolButton(
            FG_STATE_MACHINE_DIAGRAM_PATH + I18NProperties.getString("terminate"), I18NProperties
                .getString("new.terminate"), tool);
        tB.setEnabled(true);
        palette.add(tB);
    }

}
