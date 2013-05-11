/*
 * @(#)CollaborationUse.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Feb 16, 2008        descrição
 */
package documents.graphical.composite_structure_diagram;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.JPopupMenu;

import ocean.accessories.SingleConnector;
import ocean.documents.oo.concepts.Classe;
import ocean.jhotdraw.SpecificationCompositeFigure;
import ocean.smalltalk.Constantes;
import ocean.smalltalk.OceanVector;
import CH.ifa.draw.contrib.GraphicalCompositeFigure;
import CH.ifa.draw.figures.RectangleFigure;
import CH.ifa.draw.figures.TextFigure;
import CH.ifa.draw.framework.Figure;
import CH.ifa.draw.framework.FigureEnumeration;
import CH.ifa.draw.standard.BoxHandleKit;
import documents.concepts.composite_structure_diagram.Collaboration;
import documents.concepts.composite_structure_diagram.CollaborationUse;
import documents.util.I18NProperties;

public class CollaborationUseFigure extends SpecificationCompositeFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 6736326643487460586L;

    /**
     * The dashed ellipse.
     */
    private DashedEllipseFigure ellipse = new DashedEllipseFigure(false, 0);

    /**
     * A package figure.
     */
    private CollaborationFigure collabFig;

    /**
     * The drawing.
     */
    private CompositeStructureDiagramDrawing drawing;

    /**
     * The empty fill rectangle.
     */
    private RectangleFigure emptyFillRectangle = new RectangleFigure()
    {

        /**
         * The generated serial version UID.
         */
        private static final long serialVersionUID = -2182702704328653913L;

        /*
         * (non-Javadoc)
         * 
         * @see CH.ifa.draw.figures.RectangleFigure#drawBackground(java.awt.Graphics)
         */
        public void drawBackground(Graphics g)
        {
            // EMPTY.
        }

        /*
         * (non-Javadoc)
         * 
         * @see CH.ifa.draw.figures.RectangleFigure#drawFrame(java.awt.Graphics)
         */
        public void drawFrame(Graphics g)
        {
            // EMPTY.
        }
    };

    /**
     * Default constructor.
     */
    public CollaborationUseFigure()
    {
        super();
        this.setPresentationFigure(emptyFillRectangle);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @Override
    public Class<CollaborationUse> relatedConceptClass()
    {
        return CollaborationUse.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(CollaborationUse.class);
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

        final CollaborationUse collab = (CollaborationUse) this.concept();
        if (collab.getCollaborationUseName() == null
                || ("").equals(collab.getCollaborationUseName()))
        {
            collab.setCollaborationUseName("Collaboration Use");
        }

        String collabName = collab.getCollaborationUseName();
        Font fontName = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metrics = Toolkit.getDefaultToolkit().getFontMetrics(fontName);
        final int widthFig = metrics.stringWidth(collabName);

        TextFigure figure = new TextFigure();
        figure.setFont(fontName);
        figure.setText(collabName);

        GraphicalCompositeFigure gc = new GraphicalCompositeFigure()
        {

            /**
             * The serial version UID.
             */
            private static final long serialVersionUID = -8589366744617460851L;

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.contrib.GraphicalCompositeFigure#getPresentationFigure()
             */
            public Figure getPresentationFigure()
            {
                ellipse.setWidthText(widthFig);
                return ellipse;
            }
        };
        gc.setAttribute("FillColor", new Color(0xE8E8E8));
        gc.getLayouter().setInsets(new Insets(40, 10, 42, 0));

        gc.add(figure);

        add(gc);

        this.getPresentationFigure().setAttribute("FillColor", Color.WHITE);
        this.getPresentationFigure().setAttribute("FrameColor", Color.WHITE);

        update();
    }

    /**
     * Creates a popup menu to edit the class or object name.
     */
    protected JPopupMenu createPopupMenu()
    {
        JPopupMenu popupMenu = new JPopupMenu();

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.name.collaboration.use"))
        {

            private static final long serialVersionUID = 676546L;

            /*
             * (non-Javadoc)
             * 
             * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
             */
            public void actionPerformed(ActionEvent event)
            {
                if (SingleConnector.managerView().openDialogInterface(Constantes.NAME_SPEC,
                    ((CollaborationUse) concept()).getCollaborationUseName().trim()))
                {
                    ((CollaborationUse) concept()).setCollaborationUseName((SingleConnector
                        .manager()).getCreationName());
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

        // It doesn't belong to a package.
        if ((collabFig == null) && (drawing != null))
        {
            int xUse = this.displayBox().x;
            int yUse = this.displayBox().y;
            int wUse = this.displayBox().width;
            int hUse = this.displayBox().height;

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
                    if (((xUse > xCollab) && (xUse < (xCollab + wCollab - wUse)) /* BOTTOM */
                            && (yUse < (yCollab + hCollab - hUse)) && (yUse > yCollab))
                            || ((xUse < (xCollab + wCollab - wUse)) && (xUse > xCollab) /* RIGHT */
                                    && (yUse > yCollab) && (yUse < (yCollab + hCollab - hUse)))
                            || ((yUse > yCollab) && (yUse < (yCollab + hCollab - hUse)) /* TOP */
                                    && (xUse > xCollab) && (xUse < (xCollab + wCollab - wUse)))
                            || ((xUse > xCollab) && (xUse < (xCollab + wCollab - wUse)) /* LEFT */
                                    && (yUse > yCollab) && (yUse < (yCollab + hCollab - hUse))))
                    {
                        collabFig = (CollaborationFigure) nextFigure;
                        collabFig.getCollaborationFigureList().add(this);
                        ((Collaboration) collabFig.concept()).getClassList()
                            .add((Classe) concept());
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

            super.moveBy(newX, newY);
        }

        if (collabFig == null)
        {
            super.moveBy(dx, dy);
        }

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
        BoxHandleKit.addHandles(this, handles);

        return handles;
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

}
