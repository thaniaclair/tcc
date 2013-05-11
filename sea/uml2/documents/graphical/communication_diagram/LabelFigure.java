/*
 * @(#)LabelFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Feb 11, 2008        descrição
 */
package documents.graphical.communication_diagram;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.JPopupMenu;

import ocean.accessories.SingleConnector;
import ocean.jhotdraw.SpecificationCompositeFigure;
import ocean.smalltalk.Constantes;
import ocean.smalltalk.OceanVector;
import CH.ifa.draw.contrib.PolygonFigure;
import CH.ifa.draw.figures.RectangleFigure;
import CH.ifa.draw.framework.Figure;
import CH.ifa.draw.standard.NullHandle;
import CH.ifa.draw.standard.RelativeLocator;
import documents.concepts.communication_diagram.Label;
import documents.graphical.deployment_diagram.ExtendedTextFigure;
import documents.util.I18NProperties;

public class LabelFigure extends SpecificationCompositeFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -1962910747021582743L;

    /**
     * The label type.
     */
    private static final String LABEL_TYPE = new String("sd");

    /**
     * The text figure with the label.
     */
    protected static ExtendedTextFigure figure = new ExtendedTextFigure()
    {

        /**
         * The serial version UID.
         */
        private static final long serialVersionUID = 2960122660431866736L;

        /*
         * (non-Javadoc)
         * 
         * @see documents.graphical.deployment_diagram.ExtendedTextFigure#drawBackground(java.awt.Graphics)
         */
        public void drawBackground(Graphics g)
        {
            this.setFOriginX(5);
            this.setFOriginY(0);
            super.drawBackground(g);
        }

        /*
         * (non-Javadoc)
         * 
         * @see documents.graphical.deployment_diagram.ExtendedTextFigure#drawFrame(java.awt.Graphics)
         */
        public void drawFrame(Graphics g)
        {
            this.setFOriginX(5);
            this.setFOriginY(0);
            super.drawFrame(g);
        }

        /*
         * (non-Javadoc)
         * 
         * @see documents.graphical.deployment_diagram.ExtendedTextFigure#displayBox()
         */
        public Rectangle displayBox()
        {
            this.setFOriginX(5);
            this.setFOriginY(0);
            return super.displayBox();
        }

    };

    /**
     * Default constructor.
     */
    public LabelFigure()
    {
        super(new RectangleFigure()
        {

            /**
             * The serial version UID.
             */
            private static final long serialVersionUID = -1010696746923422617L;

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.figures.RectangleFigure#drawBackground(java.awt.Graphics)
             */
            public void drawBackground(Graphics g)
            {
                g.fillRect(0, 0, figure.textDisplayBox().width + 5, figure.textDisplayBox().height);
            }

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.figures.RectangleFigure#drawFrame(java.awt.Graphics)
             */
            public void drawFrame(Graphics g)
            {
                g.drawRect(0, 0, figure.textDisplayBox().width + 4,
                    figure.textDisplayBox().height - 1);
            }

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.figures.RectangleFigure#displayBox()
             */
            public Rectangle displayBox()
            {
                return new Rectangle(0, 0, figure.textDisplayBox().width,
                        figure.textDisplayBox().height);
            }

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.figures.RectangleFigure#basicMoveBy(int, int)
             */
            protected void basicMoveBy(int x, int y)
            {
                // Empty.
            }

            /*
             * (non-Javadoc)
             * 
             * @see documents.graphical.deployment_diagram.ExtendedTextFigure#handles()
             */
            @SuppressWarnings( { "unchecked", "unchecked" })
            public Vector handles()
            {
                Vector handles = new Vector();
                handles.addElement(new NullHandle(this, RelativeLocator.northWest()));
                handles.addElement(new NullHandle(this, RelativeLocator.northEast()));
                handles.addElement(new NullHandle(this, RelativeLocator.southWest()));
                handles.addElement(new NullHandle(this, RelativeLocator.southEast()));
                return handles;
            }
        });
        this.getPresentationFigure().setAttribute("FillColor", Color.WHITE);
        this.getPresentationFigure().setAttribute("FrameColor", Color.WHITE);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @Override
    public Class<Label> relatedConceptClass()
    {
        return Label.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(Label.class);
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

        Label label = (Label) this.concept();
        if (label.name() == null || ("").equals(label.name()))
        {
            label.name(I18NProperties.getString("communication.diagram.name"));
        }

        figure.setFont(new Font("Helvetica", Font.BOLD, 14));
        figure.setText(LABEL_TYPE + " " + label.name());
        figure.setAttribute("TextColor", Color.BLACK);

        int w = figure.textDisplayBox().width;
        int h = figure.textDisplayBox().height;

        PolygonFigure poly = new PolygonFigure()
        {

            /**
             * The serial version UID.
             */
            private static final long serialVersionUID = 7132902592267776994L;

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.AbstractFigure#moveBy(int, int)
             */
            public void moveBy(int x, int y)
            {
                // Empty.
            }
        };
        poly.addPoint(0, 0);
        poly.addPoint(w + 20, 0);
        poly.addPoint(w + 19, 2);
        poly.addPoint(w + 18, 4);
        poly.addPoint(w + 17, 6);
        poly.addPoint(w + 16, 8);
        poly.addPoint(w + 12, 12);
        poly.addPoint(w + 8, 16);
        poly.addPoint(w + 7, 16);
        poly.addPoint(w + 6, 17);
        poly.addPoint(w, h);
        poly.addPoint(0, h);
        poly.addPoint(0, 0);
        poly.setAttribute("FillColor", new Color(0xFFFFE0));

        add(poly);
        add(figure);

        update();

    }

    /**
     * Creates a popup menu to edit the class or object name.
     */
    protected JPopupMenu createPopupMenu()
    {
        JPopupMenu popupMenu = new JPopupMenu();

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.name.label"))
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
                    ((Label) concept()).name().trim()))
                {
                    ((Label) concept()).name((SingleConnector.manager()).getCreationName());
                    SingleConnector.manager().updateRedrawCode();
                    concept().redraw();
                }
            }
        });

        popupMenu.setLightWeightPopupEnabled(true);
        return popupMenu;
    }

}
