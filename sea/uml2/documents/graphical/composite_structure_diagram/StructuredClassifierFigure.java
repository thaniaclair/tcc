/*
 * @(#)StructuredClassifier.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Feb 29, 2008        descrição
 */
package documents.graphical.composite_structure_diagram;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.JPopupMenu;

import ocean.accessories.SingleConnector;
import ocean.documents.oo.concepts.Classe;
import ocean.jhotdraw.SeparatorFigure;
import ocean.jhotdraw.SpecificationCompositeFigure;
import ocean.jhotdraw.SpecificationDrawing;
import ocean.smalltalk.Constantes;
import CH.ifa.draw.contrib.GraphicalCompositeFigure;
import CH.ifa.draw.figures.RectangleFigure;
import CH.ifa.draw.framework.DrawingView;
import CH.ifa.draw.framework.Figure;
import CH.ifa.draw.framework.FigureEnumeration;
import CH.ifa.draw.standard.BoxHandleKit;
import CH.ifa.draw.standard.LocatorHandle;
import CH.ifa.draw.standard.RelativeLocator;
import documents.concepts.composite_structure_diagram.Collaboration;
import documents.graphical.component_diagram.PortFigure;
import documents.graphical.deployment_diagram.ExtendedTextFigure;
import documents.util.I18NProperties;

public class StructuredClassifierFigure extends SpecificationCompositeFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -6456332339977321157L;

    /**
     * A package figure.
     */
    private CollaborationFigure collabFig;

    /**
     * The drawing.
     */
    private CompositeStructureDiagramDrawing drawing;

    /**
     * A list of port figures.
     */
    private List<PortFigure> portFigureList = new LinkedList<PortFigure>();

    /**
     * A list of structured classifier figures.
     */
    private List<StructuredClassifierFigure> strucClassFigureList = new LinkedList<StructuredClassifierFigure>();

    /**
     * A structured classifier figure.
     */
    private StructuredClassifierFigure strucFigure;

    /**
     * The content of the structured classifier.
     */
    private GraphicalCompositeFigure compositeContent = new GraphicalCompositeFigure(
            new SeparatorFigure());

    /**
     * The insets to the the structured classifier.
     */
    private Insets insetsContent = new Insets(10, 10, 10, 0);

    /**
     * Default constructor.
     */
    public StructuredClassifierFigure()
    {
        super(new RectangleFigure());
    }

    /**
     * Overloaded constructor.
     * 
     * @param classe
     */
    public StructuredClassifierFigure(Classe classe)
    {
        super(new RectangleFigure(), classe);
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

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#initialize()
     */
    public void initialize()
    {
        removeAll();

        setAttribute(Figure.POPUP_MENU, createPopupMenu());

        super.initialize();
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#redraw()
     */
    @SuppressWarnings("deprecation")
    public void redraw()
    {

        removeAll();

        Font fontType = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metrics = Toolkit.getDefaultToolkit().getFontMetrics(fontType);
        int widthText = metrics.stringWidth(this.concept.name());
        int widthContent = this.getPresentationFigure().displayBox().width - insetsContent.left;

        ExtendedTextFigure text;
        if (widthContent <= 0)
        {
            text = new ExtendedTextFigure(0);
        }
        else
        {
            text = new ExtendedTextFigure((widthContent / 2) - (widthText / 2) - 15);
        }
        text.setFont(new Font("Helvetica", Font.BOLD, 14));
        text.setText(this.concept.name());
        text.setAttribute("FillColor", new Color(0xE8E8E8));

        GraphicalCompositeFigure compositeTitle = new GraphicalCompositeFigure(
                new SeparatorFigure());
        compositeTitle.setAttribute("FillColor", new Color(0xE8E8E8));
        compositeTitle.getLayouter().setInsets(new Insets(20, 20, 20, 0));
        compositeTitle.add(text);
        add(compositeTitle);

        compositeContent.setAttribute("FillColor", new Color(0xE8E8E8));
        compositeContent.getLayouter().setInsets(insetsContent);
        add(compositeContent);

        this.setAttribute("FillColor", new Color(0xE8E8E8));

        update();

    }

    /**
     * Creates a popup menu to edit the class or object name.
     */
    protected JPopupMenu createPopupMenu()
    {
        JPopupMenu popupMenu = new JPopupMenu();

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.name.class"))
        {

            /**
             * The serial version UID.
             */
            private static final long serialVersionUID = 676546L;

            /*
             * (non-Javadoc)
             * 
             * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
             */
            public void actionPerformed(ActionEvent event)
            {
                if (SingleConnector.managerView().openDialogInterface(Constantes.NAME_SPEC,
                    ((Classe) concept()).name().trim()))
                {
                    ((Classe) concept()).name((SingleConnector.manager()).getCreationName());
                    SingleConnector.manager().updateRedrawCode();
                    concept().redraw();
                }
            }
        });

        popupMenu.setLightWeightPopupEnabled(true);
        return popupMenu;
    }

    /*
     * (non-Javadoc)
     * 
     * @see CH.ifa.draw.standard.AbstractFigure#moveBy(int, int)
     */
    @Override
    public void moveBy(int dx, int dy)
    {

        int nextX = 0;
        int nextY = 0;

        // It doesn't belong to a package.
        if ((collabFig == null) && (drawing != null))
        {
            int xClass = this.displayBox().x;
            int yClass = this.displayBox().y;
            int wClass = this.displayBox().width;
            int hClass = this.displayBox().height;

            FigureEnumeration enumeration = drawing.figures();
            while (enumeration.hasMoreElements())
            {
                Figure nextFigure = enumeration.nextFigure();
                if (nextFigure instanceof CollaborationFigure)
                {
                    Rectangle displayBox = nextFigure.displayBox();
                    int xCollab = displayBox.x;
                    int yCollab = displayBox.y;
                    int wCollab = displayBox.width;
                    int hCollab = displayBox.height;

                    // Checks the restrictions.
                    if (((xClass > xCollab) && (xClass < (xCollab + wCollab - wClass)) /* BOTTOM */
                            && (yClass < (yCollab + hCollab - hClass)) && (yClass > yCollab))
                            || ((xClass < (xCollab + wCollab - wClass)) && (xClass > xCollab) /* RIGHT */
                                    && (yClass > yCollab) && (yClass < (yCollab + hCollab - hClass)))
                            || ((yClass > yCollab) && (yClass < (yCollab + hCollab - hClass)) /* TOP */
                                    && (xClass > xCollab) && (xClass < (xCollab + wCollab - wClass)))
                            || ((xClass > xCollab) && (xClass < (xCollab + wCollab - wClass)) /* LEFT */
                                    && (yClass > yCollab) && (yClass < (yCollab + hCollab - hClass))))
                    {
                        collabFig = (CollaborationFigure) nextFigure;
                        collabFig.getClassifierFigureList().add(this);
                        ((Collaboration) collabFig.concept()).getClassList()
                            .add((Classe) concept());
                        nextX = dx;
                        nextY = dy;
                        super.moveBy(dx, dy);
                        break;
                    }
                }
            }
        }
        // It belongs to a package.
        else if ((collabFig != null) && (drawing != null))
        {

            int x = collabFig.getPresentationFigure().displayBox().x;
            int y = collabFig.getPresentationFigure().displayBox().y;
            int width = collabFig.getPresentationFigure().displayBox().width;
            int height = collabFig.getPresentationFigure().displayBox().height;

            final int w = (width == 0) ? 0 : width;
            final int h = (height == 0) ? 0 : height;

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

            nextX = newX;
            nextY = newY;

            super.moveBy(newX, newY);
        }

        if ((strucFigure == null) && (drawing != null))
        {

            int xClassOut = this.displayBox().x;
            int yClassOut = this.displayBox().y;
            int wClassOut = this.displayBox().width;
            int hClassOut = this.displayBox().height;

            FigureEnumeration enumeration = drawing.figures();
            while (enumeration.hasMoreElements())
            {
                Figure nextFigure = enumeration.nextFigure();
                if (nextFigure instanceof StructuredClassifierFigure)
                {
                    Rectangle displayBox = nextFigure.displayBox();
                    int xClassIn = displayBox.x;
                    int yClassIn = displayBox.y + 50;
                    int wClassIn = displayBox.width;
                    int hClassIn = displayBox.height - 50;

                    // Checks the restrictions.
                    if (((xClassOut > xClassIn) && (xClassOut < (xClassIn + wClassIn - wClassOut)) /* BOTTOM */
                            && (yClassOut < (yClassIn + hClassIn - hClassOut)) && (yClassOut > yClassIn))
                            || ((xClassOut < (xClassIn + wClassIn - wClassOut))
                                    && (xClassOut > xClassIn) /* RIGHT */
                                    && (yClassOut > yClassIn) && (yClassOut < (yClassIn + hClassIn - hClassOut)))
                            || ((yClassOut > yClassIn)
                                    && (yClassOut < (yClassIn + hClassIn - hClassOut)) /* TOP */
                                    && (xClassOut > xClassIn) && (xClassOut < (xClassIn + wClassIn - wClassOut)))
                            || ((xClassOut > xClassIn)
                                    && (xClassOut < (xClassIn + wClassIn - wClassOut)) /* LEFT */
                                    && (yClassOut > yClassIn) && (yClassOut < (yClassIn + hClassIn - hClassOut))))
                    {
                        strucFigure = (StructuredClassifierFigure) nextFigure;
                        strucFigure.getStrucClassFigureList().add(this);
                        nextX = dx;
                        nextY = dy;
                        super.moveBy(dx, dy);
                        break;
                    }
                }
            }

        }
        else if ((strucFigure != null) && (drawing != null))
        {
            
            int x = strucFigure.getPresentationFigure().displayBox().x;
            int y = strucFigure.getPresentationFigure().displayBox().y;
            int w = strucFigure.getPresentationFigure().displayBox().width;
            int h = strucFigure.getPresentationFigure().displayBox().height;

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

            nextX = newX;
            nextY = newY;

            super.moveBy(newX, newY);

        }

        if ((collabFig == null) && (strucFigure == null))
        {
            nextX = dx;
            nextY = dy;

            super.moveBy(dx, dy);
        }

        for (PortFigure portFig : portFigureList)
        {
            portFig.moveBy(nextX, nextY);
        }
        
        for (StructuredClassifierFigure strucFig : strucClassFigureList)
        {
            strucFig.moveBy(nextX, nextY);
        }
    }

    /**
     * @return the drawing
     */
    public CompositeStructureDiagramDrawing getDrawing()
    {
        return drawing;
    }

    /**
     * @param drawing the drawing to set
     */
    public void setDrawing(CompositeStructureDiagramDrawing drawing)
    {
        this.drawing = drawing;
    }

    /**
     * @return the portFigureList
     */
    public List<PortFigure> getPortFigureList()
    {
        return portFigureList;
    }

    /**
     * @param portFigureList the portFigureList to set
     */
    public void setPortFigureList(List<PortFigure> portFigureList)
    {
        this.portFigureList = portFigureList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#handles()
     */
    @SuppressWarnings("unchecked")
    public Vector handles()
    {

        Vector handles = new Vector();
        // EAST
        handles.addElement(new LocatorHandle(this, new RelativeLocator(1.0, 0.5))
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.AbstractHandle#invokeStep(int, int, int, int,
             *      CH.ifa.draw.framework.DrawingView)
             */
            public void invokeStep(int x, int y, int anchorX, int anchorY, DrawingView view)
            {
                if (x > anchorX)
                {
                    compositeContent.getLayouter().setInsets(
                        new Insets(insetsContent.top, insetsContent.left, insetsContent.bottom,
                                insetsContent.right + 2));
                    insetsContent = compositeContent.getLayouter().getInsets();
                    StructuredClassifierFigure.this.redraw();
                }
            }

        });
        handles.addElement(BoxHandleKit.west(this));
        handles.addElement(BoxHandleKit.north(this));
        BoxHandleKit.addCornerHandles(this, handles);
        // SOUTH
        handles.addElement(new LocatorHandle(this, new RelativeLocator(0.5, 1.0))
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.AbstractHandle#invokeStep(int, int, int, int,
             *      CH.ifa.draw.framework.DrawingView)
             */
            public void invokeStep(int x, int y, int anchorX, int anchorY, DrawingView view)
            {
                if (y > anchorY)
                {
                    compositeContent.getLayouter().setInsets(
                        new Insets(insetsContent.top, insetsContent.left, insetsContent.bottom + 2,
                                insetsContent.right));
                    insetsContent = compositeContent.getLayouter().getInsets();
                    StructuredClassifierFigure.this.redraw();
                }
            }

        });
        return handles;
    }

    /**
     * @return the strucClassFigureList
     */
    public List<StructuredClassifierFigure> getStrucClassFigureList()
    {
        return strucClassFigureList;
    }

    /**
     * @param strucClassFigureList the strucClassFigureList to set
     */
    public void setStrucClassFigureList(List<StructuredClassifierFigure> strucClassFigureList)
    {
        this.strucClassFigureList = strucClassFigureList;
    }

}
