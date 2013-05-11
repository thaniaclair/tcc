/*
 * @(#)ExtendedClass.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Feb 19, 2008        descrição
 */
package documents.graphical.composite_structure_diagram;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.Vector;

import ocean.documents.oo.concepts.Classe;
import ocean.jhotdraw.figures.ClasseFigure;
import ocean.smalltalk.OceanVector;
import CH.ifa.draw.framework.Figure;
import CH.ifa.draw.framework.FigureEnumeration;
import CH.ifa.draw.standard.BoxHandleKit;
import documents.graphical.package_diagram.PackageDiagramDrawing;
import documents.graphical.package_diagram.PackageFigure;

public class ExtendedClassFigure extends ClasseFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -8101716597368370179L;

    /**
     * A package figure.
     */
    private PackageFigure packageFig;

    /**
     * The drawing.
     */
    private PackageDiagramDrawing drawing;

    /**
     * Default constructor.
     */
    public ExtendedClassFigure()
    {
        super();
    }

    /**
     * Overloaded constructor.
     * 
     * @param port
     */
    public ExtendedClassFigure(Classe classe)
    {
        super(classe);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @Override
    public Class<Classe> relatedConceptClass()
    {
        return Classe.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(Classe.class);
        return auxList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#initialize()
     */
    public void initialize()
    {
        removeAll();

        super.initialize();
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#redraw()
     */
    public void redraw()
    {

        removeAll();

        super.redraw();

        this.getPresentationFigure().setAttribute("FillColor", new Color(0xE8E8E8));
        this.getPresentationFigure().setAttribute("FrameColor", Color.BLACK);

        update();
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.figures.ClasseFigure#handles()
     */
    @SuppressWarnings("unchecked")
    public Vector handles()
    {
        Vector handles = new Vector();
        BoxHandleKit.addHandles(this, handles);
        return handles;
    }

    /*
     * (non-Javadoc)
     * 
     * @see CH.ifa.draw.standard.AbstractFigure#moveBy(int, int)
     */
    @Override
    public void moveBy(int dx, int dy)
    {

        // It doesn't belong to a package.
        if ((packageFig == null) && (drawing != null))
        {
            int xClass = this.displayBox().x;
            int yClass = this.displayBox().y;
            int wClass = this.displayBox().width;
            int hClass = this.displayBox().height;

            FigureEnumeration enumeration = drawing.figures();
            while (enumeration.hasMoreElements())
            {
                Figure nextFigure = enumeration.nextFigure();
                if (nextFigure instanceof PackageFigure)
                {
                    Rectangle displayBox = nextFigure.displayBox();
                    int xPack = displayBox.x;
                    int yPack = displayBox.y + 35;
                    int wPack = displayBox.width;
                    int hPack = displayBox.height - 35;

                    // Checks the restrictions.
                    if (((xClass > xPack) && (xClass < (xPack + wPack - wClass)) /* BOTTOM */
                            && (yClass < (yPack + hPack - hClass)) && (yClass > yPack))
                            || ((xClass < (xPack + wPack - wClass)) && (xClass > xPack) /* RIGHT */
                                    && (yClass > yPack) && (yClass < (yPack + hPack - hClass)))
                            || ((yClass > yPack) && (yClass < (yPack + hPack - hClass)) /* TOP */
                                    && (xClass > xPack) && (xClass < (xPack + wPack - wClass)))
                            || ((xClass > xPack) && (xClass < (xPack + wPack - wClass)) /* LEFT */
                                    && (yClass > yPack) && (yClass < (yPack + hPack - hClass))))
                    {
                        packageFig = (PackageFigure) nextFigure;
                        packageFig.getClassFigureList().add(this);
                        ((documents.concepts.package_diagram.Package) packageFig.concept())
                            .getClassList().add((Classe) concept());
                        super.moveBy(dx, dy);
                        break;
                    }
                }
            }
        }
        // It belongs to a package.
        else if ((packageFig != null) && (drawing != null))
        {

            int x = packageFig.getPresentationFigure().displayBox().x;
            int y = packageFig.getPresentationFigure().displayBox().y + 35;
            int w = packageFig.getPresentationFigure().displayBox().width;
            int h = packageFig.getPresentationFigure().displayBox().height - 35;

            int oldX = this.displayBox().x;
            int oldY = this.displayBox().y;
            int classWidth = this.displayBox().width;
            int classHeight = this.displayBox().height;

            int leftBoundary = x + 10;
            int rightBoundary = x + w - 10 - classWidth;
            int topBoundary = y + 5;
            int bottomBoundary = y + h - 10 - classHeight;

            int newX = dx;
            int newY = dy;

            // Add restriction inside of the package.
            if (((oldX + dx) < leftBoundary) || ((oldX + dx) > rightBoundary)
                    || ((oldY + dy) < topBoundary) || ((oldY + dy) > bottomBoundary))
            {
                // Don't move!!!
                return;
            }

            super.moveBy(newX, newY);
        }

        if (packageFig == null)
        {
            super.moveBy(dx, dy);
        }
    }

    /**
     * @return the drawing
     */
    public PackageDiagramDrawing getDrawing()
    {
        return drawing;
    }

    /**
     * @param drawing the drawing to set
     */
    public void setDrawing(PackageDiagramDrawing drawing)
    {
        this.drawing = drawing;
    }

}
