/*
 * @(#)CompositeStructureDiagramEditor.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Feb 16, 2008        descrição
 */
package documents.graphical.composite_structure_diagram;

import java.awt.event.MouseEvent;

import javax.swing.JToolBar;

import ocean.accessories.SingleConnector;
import ocean.documents.oo.concepts.Classe;
import ocean.framework.Concept;
import ocean.jhotdraw.*;
import ocean.smalltalk.Constantes;
import CH.ifa.draw.framework.Tool;
import CH.ifa.draw.standard.ConnectionTool;
import CH.ifa.draw.standard.CreationTool;
import CH.ifa.draw.standard.ToolButton;
import documents.concepts.component_diagram.Interface;
import documents.concepts.component_diagram.Port;
import documents.concepts.composite_structure_diagram.*;
import documents.concepts.object_diagram.InstanceSpecification;
import documents.graphical.component_diagram.ComponentDiagramDrawingView;
import documents.graphical.component_diagram.InterfaceFigure;
import documents.graphical.component_diagram.PortFigure;
import documents.graphical.object_diagram.*;
import documents.graphical.object_diagram.AssociationLineConnection;
import documents.util.I18NPrinter;
import documents.util.I18NProperties;

public class CompositeStructureDiagramEditor extends SpecificationEditor
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -5065290511916302552L;

    /**
     * Diagram images path.
     */
    protected final static String FG_OBJECT_DIAGRAM_PATH = new String(
            "/ocean/documents/oo/graphical/objectDiagram/");

    protected final static String FG_CLASS_DIAGRAM_PATH = new String(
            "/ocean/documents/oo/graphical/classDiagram/");

    protected final static String FG_COMPONENT_DIAGRAM_PATH = new String(
            "/ocean/documents/oo/graphical/componentDiagram/");

    protected final static String FG_COMPOSITE_STRUCTURE_DIAGRAM_PATH = new String(
            "/ocean/documents/oo/graphical/compositeStructureDiagram/");

    /**
     * Overloaded constructor.
     * 
     * @param view
     */
    public CompositeStructureDiagramEditor(ComponentDiagramDrawingView view)
    {
        super(view);
    }

    /**
     * Official constructor.
     */
    public CompositeStructureDiagramEditor()
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
        return new CompositeStructureDiagramDrawingView(this);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationEditor#createSpecificationDrawing()
     */
    @Override
    protected SpecificationDrawing createSpecificationDrawing()
    {
        return new CompositeStructureDiagramDrawing();
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

        // STRUCTURED CLASSIFIER
        Tool tool = new CreationTool(this, new StructuredClassifierFigure())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.CreationTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                Concept conc = getModel().createComponent(Classe.class);

                if (conc == null)
                {
                    I18NPrinter.printMessage("classifier.not.created");
                }
                else
                {
                    StructuredClassifierFigure structured = ((StructuredClassifierFigure) getCreatedFigure());
                    structured.concept(conc);
                    structured.setDrawing((CompositeStructureDiagramDrawing) getDrawing());
                    conc.getObservable().addObserver(structured);
                    conc.redraw();
                }
                super.mouseUp(e, x, y);
            }

        };
        ToolButton tB = createToolButton(FG_COMPOSITE_STRUCTURE_DIAGRAM_PATH
                + I18NProperties.getString("structured.classifier"), I18NProperties
            .getString("new.structured.classifier"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // CLASS
        tool = new CreationTool(this, new ExtendedClassFigure())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.CreationTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                Concept conc = getModel().createComponent(Classe.class);

                if (conc == null)
                {
                    I18NPrinter.printMessage("class.not.created");
                }
                else
                {
                    ((ExtendedClassFigure) getCreatedFigure()).concept(conc);
                    conc.getObservable().addObserver((ExtendedClassFigure) getCreatedFigure());
                    conc.redraw();
                }
                super.mouseUp(e, x, y);
            }

        };
        tB = createToolButton(FG_CLASS_DIAGRAM_PATH + I18NProperties.getString("class"),
            I18NProperties.getString("new.class"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // OBJECT
        tool = new CreationTool(this, new InstanceSpecificationFigure())
        {

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

        // PART
        tool = new CreationTool(this, new PartFigure())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.CreationTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                Concept conc = getModel().createComponent(Part.class);

                if (conc == null)
                {
                    I18NPrinter.printMessage("part.not.created");
                }
                else
                {
                    ((PartFigure) getCreatedFigure()).concept(conc);
                    conc.getObservable().addObserver((PartFigure) getCreatedFigure());
                    conc.redraw();
                }
                super.mouseUp(e, x, y);
            }

        };
        tB = createToolButton(FG_COMPOSITE_STRUCTURE_DIAGRAM_PATH
                + I18NProperties.getString("part"), I18NProperties.getString("new.part"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // PROPERTY
        tool = new CreationTool(this, new PropertyFigure())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.CreationTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                Concept conc = getModel().createComponent(Property.class);

                if (conc == null)
                {
                    I18NPrinter.printMessage("property.not.created");
                }
                else
                {
                    ((PropertyFigure) getCreatedFigure()).concept(conc);
                    conc.getObservable().addObserver((PropertyFigure) getCreatedFigure());
                    conc.redraw();
                }
                super.mouseUp(e, x, y);
            }

        };
        tB = createToolButton(FG_COMPOSITE_STRUCTURE_DIAGRAM_PATH
                + I18NProperties.getString("property"), I18NProperties.getString("new.property"),
            tool);
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
                    PortFigure portFig = ((PortFigure) getCreatedFigure());
                    portFig.concept(conc);
                    conc.getObservable().addObserver(portFig);
                    portFig.setDrawing((CompositeStructureDiagramDrawing) getDrawing());
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

        // COLLABORATION
        tool = new CreationTool(this, new CollaborationFigure())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.CreationTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                Concept conc = getModel().createComponent(Collaboration.class);

                if (conc == null)
                {
                    I18NPrinter.printMessage("collaboration.not.created");
                }
                else
                {
                    ((CollaborationFigure) getCreatedFigure()).concept(conc);
                    conc.getObservable().addObserver((CollaborationFigure) getCreatedFigure());
                    conc.redraw();
                }
                super.mouseUp(e, x, y);
            }

        };
        tB = createToolButton(FG_COMPOSITE_STRUCTURE_DIAGRAM_PATH
                + I18NProperties.getString("collaboration"), I18NProperties
            .getString("new.collaboration"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // COLLABORATION USE
        tool = new CreationTool(this, new CollaborationUseFigure())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.CreationTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                Concept conc = getModel().createComponent(CollaborationUse.class);

                if (conc == null)
                {
                    I18NPrinter.printMessage("collaboration.use.not.created");
                }
                else
                {
                    CollaborationUseFigure use = (CollaborationUseFigure) getCreatedFigure();
                    use.concept(conc);
                    use.setDrawing((CompositeStructureDiagramDrawing) getDrawing());
                    conc.getObservable().addObserver(use);
                    conc.redraw();
                }
                super.mouseUp(e, x, y);
            }

        };
        tB = createToolButton(FG_COMPOSITE_STRUCTURE_DIAGRAM_PATH
                + I18NProperties.getString("collaboration.use"), I18NProperties
            .getString("new.collaboration.use"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // ASSOCIATION
        tool = new ConnectionTool(this, new AssociationLineConnection())
        {

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

        // CONNECTOR
        tool = new ConnectionTool(this, new ConnectorFigure())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.ConnectionTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                ConnectorFigure line = (ConnectorFigure) getConnection();
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

                if (SingleConnector.managerView().openDialogInterface(Constantes.NAME_SPEC, ""))
                {
                    line.setConnectorDescription((SingleConnector.manager()).getCreationName());
                }

            }
        };
        tB = createToolButton(FG_COMPOSITE_STRUCTURE_DIAGRAM_PATH
                + I18NProperties.getString("connector"), I18NProperties.getString("new.connector"),
            tool);
        tB.setEnabled(true);
        palette.add(tB);

        // OCCURRENCE
        tool = new ConnectionTool(this, new OccurrenceFigure())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.ConnectionTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                OccurrenceFigure line = (OccurrenceFigure) getConnection();
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
        tB = createToolButton(FG_COMPOSITE_STRUCTURE_DIAGRAM_PATH
                + I18NProperties.getString("occurrence"), I18NProperties
            .getString("new.occurrence"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // REPRESENTS
        tool = new ConnectionTool(this, new RepresentsFigure())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.ConnectionTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                RepresentsFigure line = (RepresentsFigure) getConnection();
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
        tB = createToolButton(FG_COMPOSITE_STRUCTURE_DIAGRAM_PATH
                + I18NProperties.getString("represents"), I18NProperties
            .getString("new.represents"), tool);
        tB.setEnabled(true);
        palette.add(tB);
    }
}
