/*
 * @(#)DeploymentDiagramEditor.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Jan 24, 2008        descrição
 */
package documents.graphical.deployment_diagram;

import java.awt.event.MouseEvent;

import javax.swing.JToolBar;

import ocean.framework.Concept;
import ocean.jhotdraw.*;
import CH.ifa.draw.framework.Tool;
import CH.ifa.draw.standard.ConnectionTool;
import CH.ifa.draw.standard.CreationTool;
import CH.ifa.draw.standard.ToolButton;
import documents.concepts.component_diagram.Component;
import documents.concepts.component_diagram.Interface;
import documents.concepts.component_diagram.Port;
import documents.concepts.deployment_diagram.*;
import documents.graphical.component_diagram.ComponentFigure;
import documents.graphical.component_diagram.InterfaceFigure;
import documents.graphical.component_diagram.PortFigure;
import documents.graphical.object_diagram.*;
import documents.graphical.object_diagram.AssociationLineConnection;
import documents.util.I18NPrinter;
import documents.util.I18NProperties;

public class DeploymentDiagramEditor extends SpecificationEditor
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 3214479335363292972L;

    /**
     * Diagram images path.
     */
    protected final static String FG_OBJECT_DIAGRAM_PATH = new String(
            "/ocean/documents/oo/graphical/objectDiagram/");

    protected final static String FG_CLASS_DIAGRAM_PATH = new String(
            "/ocean/documents/oo/graphical/classDiagram/");

    protected final static String FG_COMPONENT_DIAGRAM_PATH = new String(
            "/ocean/documents/oo/graphical/componentDiagram/");

    protected final static String FG_DEPLOYMENT_DIAGRAM_PATH = new String(
            "/ocean/documents/oo/graphical/deploymentDiagram/");

    /**
     * Overloaded constructor.
     * 
     * @param view
     */
    public DeploymentDiagramEditor(DeploymentDiagramDrawingView view)
    {
        super(view);
    }

    /**
     * Official constructor.
     */
    public DeploymentDiagramEditor()
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
        return new DeploymentDiagramDrawingView(this);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationEditor#createSpecificationDrawing()
     */
    @Override
    protected SpecificationDrawing createSpecificationDrawing()
    {
        return new DeploymentDiagramDrawing();
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

        // NODE
        Tool tool = new CreationTool(this, new NodeFigure())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.CreationTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                Concept conc = getModel().createComponent(Node.class);

                if (conc == null)
                {
                    I18NPrinter.printMessage("node.not.created");
                }
                else
                {
                    ((NodeFigure) getCreatedFigure()).concept(conc);
                    conc.getObservable().addObserver((NodeFigure) getCreatedFigure());
                    conc.redraw();
                }
                super.mouseUp(e, x, y);
            }

        };
        ToolButton tB = createToolButton(FG_DEPLOYMENT_DIAGRAM_PATH
                + I18NProperties.getString("node"), I18NProperties.getString("new.node"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // DEVICE NODE
        tool = new CreationTool(this, new DeviceNodeFigure())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.CreationTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                Concept conc = getModel().createComponent(DeviceNode.class);

                if (conc == null)
                {
                    I18NPrinter.printMessage("device.node.not.created");
                }
                else
                {
                    ((DeviceNodeFigure) getCreatedFigure()).concept(conc);
                    conc.getObservable().addObserver((DeviceNodeFigure) getCreatedFigure());
                    conc.redraw();
                }
                super.mouseUp(e, x, y);
            }

        };
        tB = createToolButton(FG_DEPLOYMENT_DIAGRAM_PATH + I18NProperties.getString("device.node"),
            I18NProperties.getString("new.device.node"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // EXECUTION ENVIRONMENT
        tool = new CreationTool(this, new ExecutionEnvironmentFigure())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.CreationTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                Concept conc = getModel().createComponent(ExecutionEnvironment.class);

                if (conc == null)
                {
                    I18NPrinter.printMessage("execution.environment.not.created");
                }
                else
                {
                    ((ExecutionEnvironmentFigure) getCreatedFigure()).concept(conc);
                    conc.getObservable().addObserver(
                        (ExecutionEnvironmentFigure) getCreatedFigure());
                    conc.redraw();
                }
                super.mouseUp(e, x, y);
            }

        };
        tB = createToolButton(FG_DEPLOYMENT_DIAGRAM_PATH
                + I18NProperties.getString("execution.environment"), I18NProperties
            .getString("new.execution.environment"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // ARTIFACT
        tool = new CreationTool(this, new ArtifactFigure())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.CreationTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                Concept conc = getModel().createComponent(Artifact.class);

                if (conc == null)
                {
                    I18NPrinter.printMessage("artifact.not.created");
                }
                else
                {
                    ArtifactFigure artifactFig = ((ArtifactFigure) getCreatedFigure());
                    artifactFig.concept(conc);
                    artifactFig.setDrawing((DeploymentDiagramDrawing) getDrawing());
                    conc.getObservable().addObserver(artifactFig);
                    conc.redraw();
                }
                super.mouseUp(e, x, y);
            }

        };
        tB = createToolButton(FG_DEPLOYMENT_DIAGRAM_PATH + I18NProperties.getString("artifact"),
            I18NProperties.getString("new.artifact"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // DEPLOYMENT SPECIFICATION
        tool = new CreationTool(this, new DeploymentSpecificationFigure())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.CreationTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                Concept conc = getModel().createComponent(DeploymentSpecification.class);

                if (conc == null)
                {
                    I18NPrinter.printMessage("deployment.specification.not.created");
                }
                else
                {
                    DeploymentSpecificationFigure deployFig = (DeploymentSpecificationFigure) getCreatedFigure();
                    deployFig.concept(conc);
                    deployFig.setDrawing((DeploymentDiagramDrawing) getDrawing());
                    conc.getObservable().addObserver(deployFig);
                    conc.redraw();
                }
                super.mouseUp(e, x, y);
            }

        };
        tB = createToolButton(FG_DEPLOYMENT_DIAGRAM_PATH
                + I18NProperties.getString("deployment.specification"), I18NProperties
            .getString("new.deployment.specification"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // COMPONENT
        tool = new CreationTool(this, new ComponentFigure())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.CreationTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                Concept conc = getModel().createComponent(Component.class);

                if (conc == null)
                {
                    I18NPrinter.printMessage("component.not.created");
                }
                else
                {
                    ComponentFigure componentFig = (ComponentFigure) getCreatedFigure();
                    componentFig.concept(conc);
                    componentFig.setDrawing((DeploymentDiagramDrawing) getDrawing());
                    conc.getObservable().addObserver(componentFig);
                    conc.redraw();
                }
                super.mouseUp(e, x, y);
            }

        };
        tB = createToolButton(FG_COMPONENT_DIAGRAM_PATH + I18NProperties.getString("component"),
            I18NProperties.getString("new.component"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // PORT
        tool = new CreationTool(this, new PortFigure())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.CreationTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                Concept conc = getModel().createComponent(Port.class);

                if (conc == null)
                {
                    I18NPrinter.printMessage("port.not.created");
                }
                else
                {
                    ((PortFigure) getCreatedFigure()).concept(conc);
                    conc.getObservable().addObserver((PortFigure) getCreatedFigure());
                    conc.redraw();
                }
                super.mouseUp(e, x, y);
            }

        };
        tB = createToolButton(FG_COMPONENT_DIAGRAM_PATH + I18NProperties.getString("port"),
            I18NProperties.getString("new.port"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // INTERFACE
        tool = new CreationTool(this, new InterfaceFigure())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.CreationTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                Concept conc = getModel().createComponent(Interface.class);

                if (conc == null)
                {
                    I18NPrinter.printMessage("interface.not.created");
                }
                else
                {
                    ((InterfaceFigure) getCreatedFigure()).concept(conc);
                    conc.getObservable().addObserver((InterfaceFigure) getCreatedFigure());
                    conc.redraw();
                }
                super.mouseUp(e, x, y);
            }

        };
        tB = createToolButton(FG_COMPONENT_DIAGRAM_PATH + I18NProperties.getString("interface"),
            I18NProperties.getString("new.interface"), tool);
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

        // AGREGATION
        tool = new ConnectionTool(this, new AggregationLineConnection())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.ConnectionTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                AggregationLineConnection line = (AggregationLineConnection) getConnection();
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
        tB = createToolButton(FG_OBJECT_DIAGRAM_PATH + I18NProperties.getString("aggregation"),
            I18NProperties.getString("new.aggregation"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // COMPOSITION
        tool = new ConnectionTool(this, new CompositionLineConnection())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.ConnectionTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                CompositionLineConnection line = (CompositionLineConnection) getConnection();
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
        tB = createToolButton(FG_OBJECT_DIAGRAM_PATH + I18NProperties.getString("composition"),
            I18NProperties.getString("new.composition"), tool);
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

        // REALIZATION
        tool = new ConnectionTool(this, new RealizationLineConnection())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.ConnectionTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                RealizationLineConnection line = (RealizationLineConnection) getConnection();
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
        tB = createToolButton(FG_OBJECT_DIAGRAM_PATH + I18NProperties.getString("realization"),
            I18NProperties.getString("new.realization"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // MANIFESTATION - FIXME
        tool = new ConnectionTool(this, new ManifestionLineConnection())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.ConnectionTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                ManifestionLineConnection line = (ManifestionLineConnection) getConnection();
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
        tB = createToolButton(FG_DEPLOYMENT_DIAGRAM_PATH
                + I18NProperties.getString("manifestation"), I18NProperties
            .getString("new.manifestation"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // DEPLOYMENT - FIXME
        tool = new ConnectionTool(this, new DeploymentLineConnection())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.ConnectionTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                DeploymentLineConnection line = (DeploymentLineConnection) getConnection();
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
        tB = createToolButton(FG_DEPLOYMENT_DIAGRAM_PATH + I18NProperties.getString("deployment"),
            I18NProperties.getString("new.deployment"), tool);
        tB.setEnabled(true);
        palette.add(tB);

    }
}
