/*
 * @(#)PortFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Jan 11, 2008        descrição
 */
package documents.graphical.component_diagram;

import java.awt.Color;
import java.awt.Insets;
import java.awt.Rectangle;

import ocean.jhotdraw.SpecificationCompositeFigure;
import ocean.jhotdraw.SpecificationDrawing;
import ocean.smalltalk.OceanVector;
import CH.ifa.draw.contrib.GraphicalCompositeFigure;
import CH.ifa.draw.figures.RectangleFigure;
import CH.ifa.draw.framework.Figure;
import CH.ifa.draw.framework.FigureEnumeration;
import documents.concepts.component_diagram.Port;
import documents.graphical.composite_structure_diagram.CompositeStructureDiagramDrawing;
import documents.graphical.composite_structure_diagram.StructuredClassifierFigure;

public class PortFigure extends SpecificationCompositeFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 2731329396930134885L;

    /**
     * An instance of classifier figure.
     */
    private StructuredClassifierFigure classifier;

    /**
     * An instance of component figure.
     */
    private ComponentFigure component;

    /**
     * The drawing.
     */
    private SpecificationDrawing drawing;

    /**
     * Default constructor.
     */
    public PortFigure()
    {
        super(new RectangleFigure());
    }

    /**
     * Overloaded constructor.
     * 
     * @param port
     */
    public PortFigure(Port port)
    {
        super(new RectangleFigure(), port);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @Override
    public Class<Port> relatedConceptClass()
    {
        return Port.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(Port.class);
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

        GraphicalCompositeFigure gFigure = new GraphicalCompositeFigure();
        gFigure.getLayouter().setInsets(new Insets(10, 5, 10, 5));
        gFigure.setAttribute("FillColor", new Color(0xE8E8E8));
        gFigure.setAttribute("FrameColor", new Color(0x000000));
        add(gFigure);

        update();
    }

    /*
     * (non-Javadoc)
     * 
     * @see CH.ifa.draw.standard.AbstractFigure#moveBy(int, int)
     */
    @Override
    public void moveBy(int dx, int dy)
    {

        if (drawing instanceof CompositeStructureDiagramDrawing)
        {

            // It doesn't belong to a package.
            if ((classifier == null) && (drawing != null))
            {
                int xPort = this.displayBox().x;
                int yPort = this.displayBox().y;
                int wPort = this.displayBox().width;
                int hPort = this.displayBox().height;

                FigureEnumeration enumeration = drawing.figures();
                while (enumeration.hasMoreElements())
                {
                    Figure nextFigure = enumeration.nextFigure();
                    if (nextFigure instanceof StructuredClassifierFigure)
                    {
                        Rectangle displayBox = nextFigure.displayBox();
                        int xClass = displayBox.x;
                        int yClass = displayBox.y;
                        int wClass = displayBox.width;
                        int hClass = displayBox.height;

                        // Checks the restrictions.
                        if ((xPort > (xClass - (wPort / 2)))
                                && (xPort < (xClass + wClass - (wPort / 2)))
                                && (yPort > (yClass - (hPort / 2)))
                                && (yPort < (yClass + hClass - (hPort / 2))))
                        {
                            classifier = (StructuredClassifierFigure) nextFigure;
                            classifier.getPortFigureList().add(this);
                            return;
                        }
                    }
                }
            }
            // It belongs to a package.
            else if ((classifier != null) && (drawing != null))
            {

                // CLASSIFIER
                int classX = classifier.getPresentationFigure().displayBox().x;
                int classY = classifier.getPresentationFigure().displayBox().y;
                int classW = classifier.getPresentationFigure().displayBox().width;
                int classH = classifier.getPresentationFigure().displayBox().height;

                // PORT
                int portX = this.displayBox().x;
                int portY = this.displayBox().y;
                int portW = this.displayBox().width;
                int portH = this.displayBox().height;

                int leftBoundary = classX - (portW / 2);
                int rightBoundary = classX + classW - (portW / 2);
                int topBoundary = classY - (portH / 2);
                int bottomBoundary = classY + classH - (portH / 2);

                int newX = dx;
                int newY = dy;

                // Add restriction inside of the package.
                if (((portX + dx) < leftBoundary) || ((portX + dx) > rightBoundary)
                        || ((portY + dy) < topBoundary) || ((portY + dy) > bottomBoundary))
                {
                    return;
                }

                else if (!((((portX + dx) > leftBoundary) && ((portX + dx) < rightBoundary) && (((portY + dy) == topBoundary) || ((portY + dy) == bottomBoundary))) || (((portY + dy) > topBoundary)
                        && ((portY + dy) < bottomBoundary) && (((portX + dx) == leftBoundary) || ((portX + dx) == rightBoundary)))))
                {
                    return;
                }

                super.moveBy(newX, newY);

            }

        }
        else if (drawing instanceof ComponentDiagramDrawing)
        {
            // It doesn't belong to a package.
            if ((component == null) && (drawing != null))
            {
                int xPort = this.displayBox().x;
                int yPort = this.displayBox().y;
                int wPort = this.displayBox().width;
                int hPort = this.displayBox().height;

                FigureEnumeration enumeration = drawing.figures();
                while (enumeration.hasMoreElements())
                {
                    Figure nextFigure = enumeration.nextFigure();
                    if (nextFigure instanceof ComponentFigure)
                    {
                        Rectangle displayBox = nextFigure.displayBox();
                        int xClass = displayBox.x;
                        int yClass = displayBox.y;
                        int wClass = displayBox.width;
                        int hClass = displayBox.height;

                        // Checks the restrictions.
                        if ((xPort > (xClass - (wPort / 2)))
                                && (xPort < (xClass + wClass - (wPort / 2)))
                                && (yPort > (yClass - (hPort / 2)))
                                && (yPort < (yClass + hClass - (hPort / 2))))
                        {
                            component = (ComponentFigure) nextFigure;
                            component.getPortFigureList().add(this);
                            return;
                        }
                    }
                }
            }
            // It belongs to a package.
            else if ((component != null) && (drawing != null))
            {

                // CLASSIFIER
                int classX = component.getPresentationFigure().displayBox().x;
                int classY = component.getPresentationFigure().displayBox().y;
                int classW = component.getPresentationFigure().displayBox().width;
                int classH = component.getPresentationFigure().displayBox().height;

                // PORT
                int portX = this.displayBox().x;
                int portY = this.displayBox().y;
                int portW = this.displayBox().width;
                int portH = this.displayBox().height;

                int leftBoundary = classX - (portW / 2);
                int rightBoundary = classX + classW - (portW / 2);
                int topBoundary = classY - (portH / 2);
                int bottomBoundary = classY + classH - (portH / 2);

                int newX = dx;
                int newY = dy;

                // Add restriction inside of the package.
                if (((portX + dx) < leftBoundary) || ((portX + dx) > rightBoundary)
                        || ((portY + dy) < topBoundary) || ((portY + dy) > bottomBoundary))
                {
                    return;
                }

                else if (!((((portX + dx) > leftBoundary) && ((portX + dx) < rightBoundary) && (((portY + dy) == topBoundary) || ((portY + dy) == bottomBoundary))) || (((portY + dy) > topBoundary)
                        && ((portY + dy) < bottomBoundary) && (((portX + dx) == leftBoundary) || ((portX + dx) == rightBoundary)))))
                {
                    return;
                }

                super.moveBy(newX, newY);

            }
        }

        if ((classifier == null) && (component == null))
        {
            super.moveBy(dx, dy);
        }

    }

    /**
     * @return the drawing
     */
    public SpecificationDrawing getDrawing()
    {
        return drawing;
    }

    /**
     * @param drawing the drawing to set
     */
    public void setDrawing(SpecificationDrawing drawing)
    {
        this.drawing = drawing;
    }

}
