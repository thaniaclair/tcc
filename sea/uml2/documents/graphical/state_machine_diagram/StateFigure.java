/*
 * @(#)StateFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Feb 22, 2008        descrição
 */
package documents.graphical.state_machine_diagram;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPopupMenu;

import ocean.accessories.SingleConnector;
import ocean.jhotdraw.SeparatorFigure;
import ocean.jhotdraw.SpecificationCompositeFigure;
import ocean.smalltalk.Constantes;
import ocean.smalltalk.OceanVector;
import CH.ifa.draw.contrib.GraphicalCompositeFigure;
import CH.ifa.draw.contrib.PolygonFigure;
import CH.ifa.draw.framework.Figure;
import CH.ifa.draw.framework.FigureEnumeration;
import documents.concepts.state_machine_diagram.State;
import documents.concepts.state_machine_diagram.SubmachineState;
import documents.graphical.activity_diagram.ExtendedNodeFigure;
import documents.util.I18NProperties;

public class StateFigure extends SpecificationCompositeFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -1565192569641236139L;

    /**
     * A sub machine figure.
     */
    private SubmachineStateFigure submachineFig;

    /**
     * The drawing.
     */
    private StateMachineDiagramDrawing drawing;

    /**
     * The round rectangle figure.
     */
    private StateRoundRectangleFigure recRound = new StateRoundRectangleFigure()
    {

        /**
         * The serial version UID.
         */
        private static final long serialVersionUID = -5836607882244376142L;

        /*
         * (non-Javadoc)
         * 
         * @see CH.ifa.draw.figures.RoundRectangleFigure#displayBox()
         */
        public Rectangle displayBox()
        {
            return new Rectangle(super.getFDisplayBox().x, super.getFDisplayBox().y, super
                .getFDisplayBox().width + 30, super.getFDisplayBox().height);
        }
    };

    /**
     * Constructor.
     */
    public StateFigure()
    {
        super();
        this.setPresentationFigure(recRound);
    }

    /**
     * Overloaded constructor.
     * 
     * @param state
     */
    public StateFigure(State state)
    {
        super(state);
        this.setPresentationFigure(recRound);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @Override
    public Class<State> relatedConceptClass()
    {
        return State.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(State.class);
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

        Color grayColor = new Color(0xE8E8E8);

        this.getPresentationFigure().setAttribute("FillColor", grayColor);
        this.getPresentationFigure().setAttribute("FrameColor", Color.BLACK);
        recRound.setArc(22, 22);

        State state = (State) this.concept();

        if (state.getStateDescription() == null || ("").equals(state.getStateDescription()))
        {
            state.setStateDescription("state");
        }

        ExtendedNodeFigure text = new ExtendedNodeFigure()
        {

            /**
             * The serial version UID.
             */
            private static final long serialVersionUID = -5187022414165514376L;

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.samples.net.NodeFigure#displayBox()
             */
            public Rectangle displayBox()
            {
                Dimension extent = textExtent();
                rec = new Rectangle(getFOriginX() + 18, getFOriginY() + 5, extent.width,
                        extent.height);
                int d = 4;
                rec.grow(d, d);
                return rec;
            }

            /*
             * (non-Javadoc)
             * 
             * @see documents.graphical.deployment_diagram.ExtendedTextFigure#drawFrame(java.awt.Graphics)
             */
            public void drawFrame(Graphics g)
            {
                g.setFont(getFFont());
                g.setColor((Color) getAttribute("TextColor"));
                FontMetrics metrics = g.getFontMetrics(getFFont());
                g.drawString(getFText(), getFOriginX() + 18, getFOriginY() + metrics.getAscent()
                        + 5);
            }

        };
        text.setFont(new Font("Helvetica", Font.BOLD, 14));
        text.setText(state.getStateDescription());
        text.setAttribute("FillColor", grayColor);
        text.setAttribute("FrameColor", grayColor);

        add(text);

        GraphicalCompositeFigure gc = new GraphicalCompositeFigure(new SeparatorFigure()
        {

            /**
             * The serial version UID.
             */
            private static final long serialVersionUID = -6025662621222597345L;

            /**
             * Draw the separation line and to hold some space free
             */
            public void draw(Graphics g)
            {
                g.setColor(getFrameColor());
                g.drawLine(startPoint().x, startPoint().y, endPoint().x - 1 + 30, startPoint().y);
            }

        });
        gc.getLayouter().setInsets(new Insets(20, 0, 25, 0));

        add(gc);

        update();
    }

    /**
     * @param x
     * @param y
     * @param widthFig
     */
    @SuppressWarnings("unused")
    private void initializePolygonPoints(PolygonFigure poly, int x, int y, int widthFig)
    {
        poly.addPoint(x + 20, y + 5);
        poly.addPoint(x + 15, y + 8);
        poly.addPoint(x + 10, y + 11);
        poly.addPoint(x + 5, y + 16);
        poly.addPoint(x + 3, y + 21);
        poly.addPoint(x + 1, y + 26);
        poly.addPoint(x, y + 31);
        poly.addPoint(x, y + 45);
        poly.addPoint(x + 1, y + 50);
        poly.addPoint(x + 3, y + 55);
        poly.addPoint(x + 5, y + 60);
        poly.addPoint(x + 10, y + 65);
        poly.addPoint(x + 15, y + 68);
        poly.addPoint(x + 20, y + 71);
        poly.addPoint(x + 20 + widthFig, y + 71);
        poly.addPoint(x + 20 + widthFig + 5, y + 68);
        poly.addPoint(x + 20 + widthFig + 10, y + 65);
        poly.addPoint(x + 20 + widthFig + 15, y + 60);
        poly.addPoint(x + 20 + widthFig + 18, y + 55);
        poly.addPoint(x + 20 + widthFig + 20, y + 50);
        poly.addPoint(x + 20 + widthFig + 20, y + 45);
        poly.addPoint(x + 20 + widthFig + 20, y + 31);
        poly.addPoint(x + 20 + widthFig + 19, y + 26);
        poly.addPoint(x + 20 + widthFig + 17, y + 21);
        poly.addPoint(x + 20 + widthFig + 15, y + 16);
        poly.addPoint(x + 20 + widthFig + 10, y + 11);
        poly.addPoint(x + 20 + widthFig + 5, y + 8);
        poly.addPoint(x + 20 + widthFig, y + 5);
    }

    /**
     * Creates a popup menu to edit the class or object name.
     */
    protected JPopupMenu createPopupMenu()
    {
        JPopupMenu popupMenu = new JPopupMenu();

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.name.state"))
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
                    ((State) concept()).getStateDescription()))
                {
                    ((State) concept()).setStateDescription((SingleConnector.manager())
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
     * @see CH.ifa.draw.standard.AbstractFigure#moveBy(int, int)
     */
    @Override
    public void moveBy(int dx, int dy)
    {

        // It doesn't belong to a package.
        if ((submachineFig == null) && (drawing != null))
        {
            int xState = this.displayBox().x;
            int yState = this.displayBox().y;
            int wState = this.displayBox().width;
            int hState = this.displayBox().height;

            FigureEnumeration enumeration = drawing.figures();
            while (enumeration.hasMoreElements())
            {
                Figure nextFigure = enumeration.nextFigure();
                if (nextFigure instanceof SubmachineStateFigure)
                {
                    Rectangle displayBox = nextFigure.displayBox();
                    int xSub = displayBox.x;
                    int ySub = displayBox.y + 10;
                    int wSub = displayBox.width;
                    int hSub = displayBox.height - 10;

                    // Checks the restrictions.
                    if (((xState > xSub) && (xState < (xSub + wSub - wState)) /* BOTTOM */
                            && (yState < (ySub + hSub - hState)) && (yState > ySub))
                            || ((xState < (xSub + wSub - wState)) && (xState > xSub) /* RIGHT */
                                    && (yState > ySub) && (yState < (ySub + hSub - hState)))
                            || ((yState > ySub) && (yState < (ySub + hSub - hState)) /* TOP */
                                    && (xState > xSub) && (xState < (xSub + wSub - wState)))
                            || ((xState > xSub) && (xState < (xSub + wSub - wState)) /* LEFT */
                                    && (yState > ySub) && (yState < (ySub + hSub - hState))))
                    {
                        submachineFig = (SubmachineStateFigure) nextFigure;
                        submachineFig.getStateFigureList().add(this);
                        ((SubmachineState) submachineFig.concept()).getStateList().add(
                            (State) concept());
                        return;
                    }
                }
            }
        }
        // It belongs to a package.
        else if ((submachineFig != null) && (drawing != null))
        {

            int x = submachineFig.getPresentationFigure().displayBox().x;
            int y = submachineFig.getPresentationFigure().displayBox().y + 10;
            int w = submachineFig.getPresentationFigure().displayBox().width;
            int h = submachineFig.getPresentationFigure().displayBox().height - 10;

            int stateX = this.displayBox().x;
            int stateY = this.displayBox().y;
            int stateW = this.displayBox().width;
            int stateH = this.displayBox().height;

            int leftBoundary = x + 10;
            int rightBoundary = x + w - 10 - stateW;
            int topBoundary = y + 5;
            int bottomBoundary = y + h - 10 - stateH;

            int newX = dx;
            int newY = dy;

            // Add restriction inside of the package.
            if (((stateX + dx) < leftBoundary) || ((stateX + dx) > rightBoundary)
                    || ((stateY + dy) < topBoundary) || ((stateY + dy) > bottomBoundary))
            {
                // Don't move!!!
                return;
            }

            super.moveBy(newX, newY);
        }

        if (submachineFig == null)
        {
            super.moveBy(dx, dy);
        }
    }

    /**
     * @return the drawing
     */
    public StateMachineDiagramDrawing getDrawing()
    {
        return drawing;
    }

    /**
     * @param drawing the drawing to set
     */
    public void setDrawing(StateMachineDiagramDrawing drawing)
    {
        this.drawing = drawing;
    }

}
