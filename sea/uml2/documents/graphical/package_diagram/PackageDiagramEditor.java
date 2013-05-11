/*
 * @(#)PackageDiagramEditor.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Jan 5, 2008        descrição
 */
package documents.graphical.package_diagram;

import java.awt.event.MouseEvent;

import javax.swing.JToolBar;

import ocean.documents.oo.concepts.Classe;
import ocean.framework.Concept;
import ocean.jhotdraw.*;
import CH.ifa.draw.framework.Tool;
import CH.ifa.draw.standard.ConnectionTool;
import CH.ifa.draw.standard.CreationTool;
import CH.ifa.draw.standard.ToolButton;
import documents.graphical.composite_structure_diagram.ExtendedClassFigure;
import documents.graphical.object_diagram.DependencyLineConnection;
import documents.graphical.object_diagram.RealizationLineConnection;
import documents.util.I18NPrinter;
import documents.util.I18NProperties;

public class PackageDiagramEditor extends SpecificationEditor
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -4780637064592542680L;

    /**
     * Diagram image path.
     */
    protected final static String FG_OBJECT_DIAGRAM_PATH = new String(
            "/ocean/documents/oo/graphical/objectDiagram/");

    protected final static String FG_CLASS_DIAGRAM_PATH = new String(
            "/ocean/documents/oo/graphical/classDiagram/");

    protected final static String FG_PACKAGE_DIAGRAM_PATH = new String(
            "/ocean/documents/oo/graphical/packageDiagram/");

    /**
     * Overloaded constructor.
     * 
     * @param view
     */
    public PackageDiagramEditor(PackageDiagramDrawingView view)
    {
        super(view);
    }

    /**
     * Official constructor.
     */
    public PackageDiagramEditor()
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
        return new PackageDiagramDrawingView(this);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationEditor#createSpecificationDrawing()
     */
    @Override
    protected SpecificationDrawing createSpecificationDrawing()
    {
        return new PackageDiagramDrawing();
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

        // PACKAGE
        Tool tool = new CreationTool(this, new PackageFigure())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.CreationTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                Concept conc = getModel().createComponent(
                    documents.concepts.package_diagram.Package.class);

                if (conc == null)
                {
                    I18NPrinter.printMessage("package.not.created");
                }
                else
                {
                    PackageFigure packageFig = ((PackageFigure) getCreatedFigure());
                    packageFig.concept(conc);
                    conc.getObservable().addObserver(packageFig);
                    conc.redraw();
                }
                super.mouseUp(e, x, y);
            }

        };
        ToolButton tB = createToolButton(FG_PACKAGE_DIAGRAM_PATH
                + I18NProperties.getString("package"), I18NProperties.getString("new.package"),
            tool);
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
                    ExtendedClassFigure classFig = ((ExtendedClassFigure) getCreatedFigure());
                    classFig.concept(conc);
                    conc.getObservable().addObserver(classFig);
                    classFig.setDrawing((PackageDiagramDrawing) getDrawing());
                    conc.redraw();
                }

                super.mouseUp(e, x, y);
            }

        };
        tB = createToolButton(FG_CLASS_DIAGRAM_PATH + I18NProperties.getString("class"),
            I18NProperties.getString("new.class"), tool);
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

        // ACCESS
        tool = new ConnectionTool(this, new AccessLineConnection())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.ConnectionTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                AccessLineConnection line = (AccessLineConnection) getConnection();
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
        tB = createToolButton(FG_PACKAGE_DIAGRAM_PATH + I18NProperties.getString("access"),
            I18NProperties.getString("new.access"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // MERGE
        tool = new ConnectionTool(this, new MergeLineConnection())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.ConnectionTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                MergeLineConnection line = (MergeLineConnection) getConnection();
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
        tB = createToolButton(FG_PACKAGE_DIAGRAM_PATH + I18NProperties.getString("merge"),
            I18NProperties.getString("new.merge"), tool);
        tB.setEnabled(true);
        palette.add(tB);

        // IMPORT
        tool = new ConnectionTool(this, new ImportLineConnection())
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.ConnectionTool#mouseUp(java.awt.event.MouseEvent, int, int)
             */
            public void mouseUp(MouseEvent e, int x, int y)
            {
                ImportLineConnection line = (ImportLineConnection) getConnection();
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
        tB = createToolButton(FG_PACKAGE_DIAGRAM_PATH + I18NProperties.getString("import"),
            I18NProperties.getString("new.import"), tool);
        tB.setEnabled(true);
        palette.add(tB);
    }
}
