/*
 * @(#)ActionFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Mar 4, 2008        descrição
 */
package documents.graphical.activity_diagram;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPopupMenu;

import ocean.accessories.SingleConnector;
import ocean.jhotdraw.SpecificationCompositeFigure;
import ocean.smalltalk.Constantes;
import ocean.smalltalk.OceanVector;
import CH.ifa.draw.framework.Figure;
import CH.ifa.draw.samples.net.NodeFigure;
import documents.concepts.activity_diagram.Action;
import documents.graphical.state_machine_diagram.StateRoundRectangleFigure;
import documents.util.I18NProperties;

public class ActionFigure extends SpecificationCompositeFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 7639103148911392719L;

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
                .getFDisplayBox().width + 10, super.getFDisplayBox().height);
        }
    };

    /**
     * Constructor.
     */
    public ActionFigure()
    {
        super();
        this.setPresentationFigure(recRound);
    }

    /**
     * Overloaded constructor.
     * 
     * @param action
     */
    public ActionFigure(Action action)
    {
        super(action);
        this.setPresentationFigure(recRound);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @Override
    public Class<Action> relatedConceptClass()
    {
        return Action.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(Action.class);
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

        this.getPresentationFigure().setAttribute("FillColor", new Color(0xE8E8E8));
        this.getPresentationFigure().setAttribute("FrameColor", Color.BLACK);
        recRound.setArc(22, 22);

        Action action = (Action) this.concept();

        if (action.name() == null || ("").equals(action.name()))
        {
            action.name("action");
        }

        NodeFigure text = new NodeFigure()
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
                Rectangle box = super.displayBox();
                int d = 6;
                box.grow(d, d - 2);
                return box;
            }
        };
        text.setFont(new Font("Helvetica", Font.BOLD, 14));
        text.setText(action.name());
        text.setAttribute("FillColor", new Color(0xE8E8E8));
        text.setAttribute("FrameColor", new Color(0xE8E8E8));

        getLayouter().setInsets(new Insets(20, 17, 0, 5));

        add(text);

        update();
    }

    /**
     * Creates a popup menu to edit the class or object name.
     */
    protected JPopupMenu createPopupMenu()
    {
        JPopupMenu popupMenu = new JPopupMenu();

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.name.action"))
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
                    ((Action) concept()).name().trim()))
                {
                    ((Action) concept()).name((SingleConnector.manager()).getCreationName());
                    SingleConnector.manager().updateRedrawCode();
                    concept().redraw();
                }
            }
        });

        popupMenu.setLightWeightPopupEnabled(true);
        return popupMenu;
    }

}
