package documents.graphical.object_diagram;

import java.awt.event.MouseEvent;

import javax.swing.JToolBar;

import ocean.framework.Concept;
import ocean.jhotdraw.*;
import CH.ifa.draw.framework.Tool;
import CH.ifa.draw.standard.ConnectionTool;
import CH.ifa.draw.standard.CreationTool;
import CH.ifa.draw.standard.ToolButton;
import documents.concepts.object_diagram.InstanceSpecification;
import documents.util.I18NPrinter;
import documents.util.I18NProperties;

public class ObjectDiagramEditor extends SpecificationEditor
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -4780637064592542680L;

    /**
     * Diagram images path.
     */
    protected final static String FG_OBJECT_DIAGRAM_PATH = new String(
            "/ocean/documents/oo/graphical/objectDiagram/");

    protected final static String FG_CLASS_DIAGRAM_PATH = new String(
            "/ocean/documents/oo/graphical/classDiagram/");

    /**
     * Overloaded constructor.
     * 
     * @param view
     */
    public ObjectDiagramEditor(ObjectDiagramDrawingView view)
    {
        super(view);
    }

    /**
     * Official constructor.
     */
    public ObjectDiagramEditor()
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
        return new ObjectDiagramDrawingView(this);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationEditor#createSpecificationDrawing()
     */
    @Override
    protected SpecificationDrawing createSpecificationDrawing()
    {
        return new ObjectDiagramDrawing();
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationEditor#createTools(javax.swing.JToolBar)
     */
    @Override
    protected void createTools(JToolBar palette)
    {
        super.createTools(palette);

        // OBJECT
        Tool tool = new CreationTool(this, new InstanceSpecificationFigure())
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
        ToolButton tB = createToolButton(FG_OBJECT_DIAGRAM_PATH
                + I18NProperties.getString("object"), I18NProperties.getString("new.object"), tool);
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
    }

}
