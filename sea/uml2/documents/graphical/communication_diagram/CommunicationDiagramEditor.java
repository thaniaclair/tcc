/*
 * @(#)CommunicationDiagramEditor.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Feb 9, 2008        descrição
 */
package documents.graphical.communication_diagram;

import java.awt.event.MouseEvent;

import javax.swing.JToolBar;

import ocean.documents.oo.concepts.UseCaseActor;
import ocean.documents.oo.graphical.useCaseDiagram.UseCaseActorFigure;
import ocean.framework.Concept;
import ocean.jhotdraw.*;
import CH.ifa.draw.framework.Tool;
import CH.ifa.draw.standard.ConnectionTool;
import CH.ifa.draw.standard.CreationTool;
import CH.ifa.draw.standard.ToolButton;
import documents.concepts.communication_diagram.Label;
import documents.concepts.communication_diagram.Message;
import documents.concepts.communication_diagram.ReverseMessage;
import documents.concepts.object_diagram.InstanceSpecification;
import documents.graphical.object_diagram.AssociationLineConnection;
import documents.graphical.object_diagram.DependencyLineConnection;
import documents.graphical.object_diagram.InstanceSpecificationFigure;
import documents.util.I18NPrinter;
import documents.util.I18NProperties;

public class CommunicationDiagramEditor extends SpecificationEditor
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 9075136729660599987L;

    /**
     * Diagram images path.
     */
    protected final static String FG_USECASE_DIAGRAM_PATH = new String(
            "/ocean/documents/oo/graphical/useCaseDiagram/");

    protected final static String FG_OBJECT_DIAGRAM_PATH = new String(
            "/ocean/documents/oo/graphical/objectDiagram/");

    protected final static String FG_CLASS_DIAGRAM_PATH = new String(
            "/ocean/documents/oo/graphical/classDiagram/");

    protected final static String FG_COMMUNICATION_DIAGRAM_PATH = new String(
            "/ocean/documents/oo/graphical/communicationDiagram/");

    /**
     * Overloaded constructor.
     * 
     * @param view
     */
    public CommunicationDiagramEditor(CommunicationDiagramDrawingView view)
    {
        super(view);
    }

    /**
     * Official constructor.
     */
    public CommunicationDiagramEditor()
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
        return new CommunicationDiagramDrawingView(this);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationEditor#createSpecificationDrawing()
     */
    @Override
    protected SpecificationDrawing createSpecificationDrawing()
    {
        return new CommunicationDiagramDrawing();
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

        // LABEL
        Tool tool = new CreationTool(this, new LabelFigure())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.CreationTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                Concept conc = getModel().createComponent(Label.class);

                if (conc == null)
                {
                    I18NPrinter.printMessage("label.not.created");
                }
                else
                {
                    ((LabelFigure) getCreatedFigure()).concept(conc);
                    conc.getObservable().addObserver((LabelFigure) getCreatedFigure());
                    conc.redraw();
                }

                super.mouseUp(e, x, y);
            }
        };
        ToolButton tB = createToolButton(FG_COMMUNICATION_DIAGRAM_PATH
                + I18NProperties.getString("label"), I18NProperties.getString("new.label"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // OBJECT
        tool = new CreationTool(this, new InstanceSpecificationFigure())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.CreationTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                Concept conc = getModel().createComponent(InstanceSpecification.class);

                if (conc == null)
                {
                    I18NPrinter.printMessage("object.not.created");
                }
                else
                {
                    ((InstanceSpecificationFigure) getCreatedFigure()).concept(conc);
                    conc.getObservable().addObserver(
                        (InstanceSpecificationFigure) getCreatedFigure());
                    conc.redraw();
                }

                super.mouseUp(e, x, y);
            }
        };
        tB = createToolButton(FG_OBJECT_DIAGRAM_PATH + I18NProperties.getString("object"),
            I18NProperties.getString("new.object"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // ASSOCIATION
        tool = new ConnectionTool(this, new AssociationLineConnection())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.ConnectionTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                AssociationLineConnection line = (AssociationLineConnection) getConnection();
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
        tB = createToolButton(FG_CLASS_DIAGRAM_PATH + I18NProperties.getString("association"),
            I18NProperties.getString("new.association"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // ACTOR
        tool = new CreationTool(this, new UseCaseActorFigure())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.CreationTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                Concept conc = getModel().createComponent(UseCaseActor.class);

                if (conc == null)
                {
                    I18NPrinter.printMessage("actor.not.created");
                }
                else
                {
                    ((UseCaseActorFigure) getCreatedFigure()).concept(conc);
                    conc.getObservable().addObserver((UseCaseActorFigure) getCreatedFigure());
                    conc.redraw();
                }

                super.mouseUp(e, x, y);
            }
        };
        tB = createToolButton(FG_USECASE_DIAGRAM_PATH + I18NProperties.getString("actor"),
            I18NProperties.getString("new.actor"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // INHERITANCE
        tool = new ConnectionTool(this, new InheritanceLineConnection())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.ConnectionTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                InheritanceLineConnection line = (InheritanceLineConnection) getConnection();
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
        tB = createToolButton(FG_CLASS_DIAGRAM_PATH + I18NProperties.getString("inheritance"),
            I18NProperties.getString("new.inheritance"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // DEPENDENCY
        tool = new ConnectionTool(this, new DependencyLineConnection())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.ConnectionTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                DependencyLineConnection line = (DependencyLineConnection) getConnection();
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
        tB = createToolButton(FG_CLASS_DIAGRAM_PATH + I18NProperties.getString("dependency"),
            I18NProperties.getString("new.dependency"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // MESSAGE
        tool = new CreationTool(this, new MessageFigure())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.CreationTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                Concept conc = getModel().createComponent(Message.class);

                if (conc == null)
                {
                    I18NPrinter.printMessage("message.not.created");
                }
                else
                {
                    ((MessageFigure) getCreatedFigure()).concept(conc);
                    conc.getObservable().addObserver((MessageFigure) getCreatedFigure());
                    conc.redraw();
                }

                super.mouseUp(e, x, y);
            }
        };
        tB = createToolButton(FG_COMMUNICATION_DIAGRAM_PATH + I18NProperties.getString("message"),
            I18NProperties.getString("new.message"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // REVERSE MESSAGE
        tool = new CreationTool(this, new ReverseMessageFigure())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.CreationTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                Concept conc = getModel().createComponent(ReverseMessage.class);

                if (conc == null)
                {
                    I18NPrinter.printMessage("reverse.message.not.created");
                }
                else
                {
                    ((ReverseMessageFigure) getCreatedFigure()).concept(conc);
                    conc.getObservable().addObserver((ReverseMessageFigure) getCreatedFigure());
                    conc.redraw();
                }

                super.mouseUp(e, x, y);
            }
        };
        tB = createToolButton(FG_COMMUNICATION_DIAGRAM_PATH
                + I18NProperties.getString("reverse.message"), I18NProperties
            .getString("new.reverse.message"), tool);
        tB.setEnabled(true);
        palette.add(tB);

    }
}
