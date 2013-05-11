/*
 * @(#)CollaborationFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Feb 16, 2008        descrição
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
import ocean.jhotdraw.SpecificationCompositeFigure;
import ocean.smalltalk.Constantes;
import ocean.smalltalk.OceanVector;
import CH.ifa.draw.contrib.GraphicalCompositeFigure;
import CH.ifa.draw.figures.RectangleFigure;
import CH.ifa.draw.figures.TextFigure;
import CH.ifa.draw.framework.Figure;
import CH.ifa.draw.standard.BoxHandleKit;
import documents.concepts.composite_structure_diagram.Collaboration;
import documents.util.I18NProperties;

public class CollaborationFigure extends SpecificationCompositeFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 3992473601587356624L;

    /**
     * The dashed ellipse.
     */
    private DashedEllipseFigure ellipse = new DashedEllipseFigure(true, 0);

    /**
     * A list of structured classifier figures.
     */
    private List<StructuredClassifierFigure> classifierFigureList = new LinkedList<StructuredClassifierFigure>();

    /**
     * A list of collaboration use figures.
     */
    private List<CollaborationUseFigure> collaborationFigureList = new LinkedList<CollaborationUseFigure>();

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
     * Constructor.
     */
    public CollaborationFigure()
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
    public Class<Collaboration> relatedConceptClass()
    {
        return Collaboration.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(Collaboration.class);
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
     * @see CH.ifa.draw.standard.AbstractFigure#moveBy(int, int)
     */
    public void moveBy(int x, int y)
    {
        super.moveBy(x, y);

        for (StructuredClassifierFigure classifierFig : classifierFigureList)
        {
            classifierFig.moveBy(x, y);
        }

        for (CollaborationUseFigure useFig : collaborationFigureList)
        {
            useFig.moveBy(x, y);
        }
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

        final Collaboration collab = (Collaboration) this.concept();
        if (collab.getCollaborationName() == null || ("").equals(collab.getCollaborationName()))
        {
            collab.setCollaborationName("Collaboration");
        }

        String collabName = collab.getCollaborationName();
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
                ellipse.setTotalWidth(400);
                ellipse.setTotalHeight(350);
                ellipse.setWidthText(widthFig);
                return ellipse;
            }
        };
        gc.setAttribute("FillColor", new Color(0xE8E8E8));
        gc.getLayouter().setInsets(new Insets(20, 200, 315, 0));
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

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.name.collaboration"))
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
                    ((Collaboration) concept()).getCollaborationName().trim()))
                {
                    ((Collaboration) concept()).setCollaborationName((SingleConnector.manager())
                        .getCreationName());
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
     * @return the classifierFigureList
     */
    public List<StructuredClassifierFigure> getClassifierFigureList()
    {
        return classifierFigureList;
    }

    /**
     * @param classifierFigureList the classifierFigureList to set
     */
    public void setClassifierFigureList(List<StructuredClassifierFigure> classifierFigureList)
    {
        this.classifierFigureList = classifierFigureList;
    }

    /**
     * @return the collaborationFigureList
     */
    public List<CollaborationUseFigure> getCollaborationFigureList()
    {
        return collaborationFigureList;
    }

    /**
     * @param collaborationFigureList the collaborationFigureList to set
     */
    public void setCollaborationFigureList(List<CollaborationUseFigure> collaborationFigureList)
    {
        this.collaborationFigureList = collaborationFigureList;
    }

}
