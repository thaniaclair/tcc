/*
 * @(#)ComponentDiagramEditor.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Jan 11, 2008        descrição
 */
package documents.graphical.component_diagram;

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
import documents.graphical.object_diagram.*;
import documents.graphical.object_diagram.AssociationLineConnection;
import documents.util.I18NPrinter;
import documents.util.I18NProperties;

public class ComponentDiagramEditor extends SpecificationEditor
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -5413087507406938906L;

    /**
     * Diagram images path.
     */
    protected final static String FG_OBJECT_DIAGRAM_PATH = new String(
            "/ocean/documents/oo/graphical/objectDiagram/");

    protected final static String FG_CLASS_DIAGRAM_PATH = new String(
            "/ocean/documents/oo/graphical/classDiagram/");

    protected final static String FG_COMPONENT_DIAGRAM_PATH = new String(
            "/ocean/documents/oo/graphical/componentDiagram/");

    /**
     * Overloaded constructor.
     * 
     * @param view
     */
    public ComponentDiagramEditor(ComponentDiagramDrawingView view)
    {
        super(view);
    }

    /**
     * Official constructor.
     */
    public ComponentDiagramEditor()
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
        return new ComponentDiagramDrawingView(this);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationEditor#createSpecificationDrawing()
     */
    @Override
    protected SpecificationDrawing createSpecificationDrawing()
    {
        return new ComponentDiagramDrawing();
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

        // COMPONENT
        Tool tool = new CreationTool(this, new ComponentFigure())
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
                    conc.getObservable().addObserver(componentFig);
                    conc.redraw();
                }
                super.mouseUp(e, x, y);
            }

        };
        ToolButton tB = createToolButton(FG_COMPONENT_DIAGRAM_PATH
                + I18NProperties.getString("component"), I18NProperties.getString("new.component"),
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
                    PortFigure portFig = (PortFigure) getCreatedFigure();
                    portFig.concept(conc);
                    portFig.setDrawing((ComponentDiagramDrawing) getDrawing());
                    conc.getObservable().addObserver(portFig);
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
    }

}
