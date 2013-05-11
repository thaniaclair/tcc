/*
 * @(#)SubmachineStateFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Feb 22, 2008        descrição
 */
package documents.graphical.state_machine_diagram;

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
import CH.ifa.draw.figures.PolyLineFigure;
import CH.ifa.draw.framework.Figure;
import CH.ifa.draw.standard.BoxHandleKit;
import documents.concepts.state_machine_diagram.State;
import documents.concepts.state_machine_diagram.SubmachineState;
import documents.graphical.deployment_diagram.ExtendedTextFigure;
import documents.util.I18NProperties;

public class SubmachineStateFigure extends SpecificationCompositeFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -1500462727788257188L;

    /**
     * A list of state figures.
     */
    private List<StateFigure> stateFigureList = new LinkedList<StateFigure>();

    /**
     * A list of entry point figures.
     */
    private List<EntryPointFigure> entryPointFigureList = new LinkedList<EntryPointFigure>();

    /**
     * A list of exit point figures.
     */
    private List<ExitPointFigure> exitPointFigureList = new LinkedList<ExitPointFigure>();

    /**
     * The round rectangle figure.
     */
    private StateRoundRectangleFigure recRound = new StateRoundRectangleFigure()
    {

        /**
         * The serial version UID.
         */
        private static final long serialVersionUID = -6048076675908521347L;

        /*
         * (non-Javadoc)
         * 
         * @see CH.ifa.draw.figures.RoundRectangleFigure#displayBox()
         */
        public Rectangle displayBox()
        {
            return new Rectangle(super.getFDisplayBox().x, super.getFDisplayBox().y, super
                .getFDisplayBox().width + 10, super.getFDisplayBox().height);
        }
    };

    /**
     * Constructor.
     */
    public SubmachineStateFigure()
    {
        super();
        this.setPresentationFigure(recRound);
    }

    /**
     * Overloaded constructor.
     * 
     * @param state
     */
    public SubmachineStateFigure(State state)
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
    public Class<SubmachineState> relatedConceptClass()
    {
        return SubmachineState.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(SubmachineState.class);
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
        String fillColor = new String("FillColor");
        String frameColor = new String("FrameColor");

        this.getPresentationFigure().setAttribute(fillColor, grayColor);
        this.getPresentationFigure().setAttribute(frameColor, Color.BLACK);
        recRound.setArc(22, 22);

        SubmachineState submachine = (SubmachineState) this.concept();

        if (submachine.getSubmachineDescription() == null
                || ("").equals(submachine.getSubmachineDescription()))
        {
            submachine.setSubmachineDescription("submachine");
        }

        ExtendedTextFigure text = new ExtendedTextFigure()
        {

            /**
             * The generated serial version UID.
             */
            private static final long serialVersionUID = -8424263341728825447L;

            /*
             * (non-Javadoc)
             * 
             * @see documents.graphical.deployment_diagram.ExtendedTextFigure#drawBackground(java.awt.Graphics)
             */
            public void drawBackground(Graphics g)
            {
                int x = getPresentationFigure().displayBox().x;
                int width = getPresentationFigure().displayBox().width;
                FontMetrics metrics = g.getFontMetrics(getFFont());
                int myWidth = metrics.stringWidth(getFText());
                Rectangle r = displayBox();
                g.fillRect((x + (width / 2) - (myWidth / 2)), r.y, r.width, r.height);
            }

            /*
             * (non-Javadoc)
             * 
             * @see documents.graphical.deployment_diagram.ExtendedTextFigure#drawFrame(java.awt.Graphics)
             */
            public void drawFrame(Graphics g)
            {
                int x = getPresentationFigure().displayBox().x;
                int width = getPresentationFigure().displayBox().width;
                g.setFont(getFFont());
                g.setColor((Color) getAttribute("TextColor"));
                FontMetrics metrics = g.getFontMetrics(getFFont());
                int myWidth = metrics.stringWidth(getFText());
                g.drawString(getFText(), (x + (width / 2) - (myWidth / 2)), getFOriginY()
                        + metrics.getAscent());
            }
        };
        String description = submachine.getSubmachineDescription();
        Font fontType = new Font("Helvetica", Font.BOLD, 14);
        text.setFont(fontType);
        text.setText(description);
        text.setAttribute(fillColor, grayColor);
        text.setAttribute(frameColor, grayColor);

        getLayouter().setInsets(new Insets(20, 2, 20, 25));

        add(text);

        GraphicalCompositeFigure composite = new GraphicalCompositeFigure();
        // composite.getLayouter().setInsets(new Insets(100, 200, 100, 0));
        // composite.displayBox(new Rectangle(200, 100));
        composite.getLayouter().setInsets(new Insets(50, 100, 50, 0));
        composite.displayBox(new Rectangle(100, 50));
        composite.setAttribute(fillColor, grayColor);
        composite.setAttribute(frameColor, grayColor);
        add(composite);

        int x = this.getPresentationFigure().displayBox().x;
        int y = this.getPresentationFigure().displayBox().y;
        int h = 170; //275;
        int w = 170; //370;

        PolyLineFigure poly = new PolyLineFigure();
        poly.addPoint(x + w + 15, y + h - 28);
        poly.addPoint(x + w + 11, y + h - 32);
        poly.addPoint(x + w + 7, y + h - 32);
        poly.addPoint(x + w + 3, y + h - 28);
        poly.addPoint(x + w - 3, y + h - 28);
        poly.addPoint(x + w - 7, y + h - 32);
        poly.addPoint(x + w - 11, y + h - 32);
        poly.addPoint(x + w - 15, y + h - 28);
        poly.addPoint(x + w - 11, y + h - 24);
        poly.addPoint(x + w - 7, y + h - 24);
        poly.addPoint(x + w - 3, y + h - 28);
        poly.addPoint(x + w + 3, y + h - 28);
        poly.addPoint(x + w + 7, y + h - 24);
        poly.addPoint(x + w + 11, y + h - 24);
        poly.addPoint(x + w + 15, y + h - 28);
        poly.setAttribute(fillColor, grayColor);
        poly.setAttribute(frameColor, Color.BLACK);

        add(poly);

        update();
    }

    /*
     * (non-Javadoc)
     * 
     * @see CH.ifa.draw.standard.AbstractFigure#moveBy(int, int)
     */
    public void moveBy(int x, int y)
    {
        super.moveBy(x, y);

        for (StateFigure stateFig : stateFigureList)
        {
            stateFig.moveBy(x, y);
        }

        for (EntryPointFigure entryFig : entryPointFigureList)
        {
            entryFig.moveBy(x, y);
        }

        for (ExitPointFigure exitFig : exitPointFigureList)
        {
            exitFig.moveBy(x, y);
        }
    }

    /**
     * Creates a popup menu to edit the class or object name.
     */
    protected JPopupMenu createPopupMenu()
    {
        JPopupMenu popupMenu = new JPopupMenu();

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.name.submachine.state"))
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
                    ((SubmachineState) concept()).getSubmachineDescription()))
                {
                    ((SubmachineState) concept()).setSubmachineDescription((SingleConnector
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
     * @return the stateFigureList
     */
    public List<StateFigure> getStateFigureList()
    {
        return stateFigureList;
    }

    /**
     * @return the entryPointFigureList
     */
    public List<EntryPointFigure> getEntryPointFigureList()
    {
        return entryPointFigureList;
    }

    /**
     * @param entryPointFigureList the entryPointFigureList to set
     */
    public void setEntryPointFigureList(List<EntryPointFigure> entryPointFigureList)
    {
        this.entryPointFigureList = entryPointFigureList;
    }

    /**
     * @return the exitPointFigureList
     */
    public List<ExitPointFigure> getExitPointFigureList()
    {
        return exitPointFigureList;
    }

    /**
     * @param exitPointFigureList the exitPointFigureList to set
     */
    public void setExitPointFigureList(List<ExitPointFigure> exitPointFigureList)
    {
        this.exitPointFigureList = exitPointFigureList;
    }

}
