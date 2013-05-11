/*
 * @(#)ActivityFigure.java
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
import documents.concepts.activity_diagram.Activity;
import documents.graphical.state_machine_diagram.StateRoundRectangleFigure;
import documents.util.I18NProperties;

public class ActivityFigure extends SpecificationCompositeFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -3132759492606639424L;

    /**
     * The round rectangle figure.
     */
    protected StateRoundRectangleFigure recRound = new StateRoundRectangleFigure()
    {

        /**
         * The serial version UID.
         */
        private static final long serialVersionUID = -1258125606760006346L;

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
    public ActivityFigure()
    {
        super();
        this.setPresentationFigure(recRound);
    }

    /**
     * Overloaded constructor.
     * 
     * @param activity
     */
    public ActivityFigure(Activity activity)
    {
        super(activity);
        this.setPresentationFigure(recRound);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @Override
    public Class< ? extends Activity> relatedConceptClass()
    {
        return Activity.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(Activity.class);
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

        Activity activity = (Activity) this.concept();

        if (activity.name() == null || ("").equals(activity.name()))
        {
            activity.name("activity");
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
                Rectangle box = super.displayBox();
                int d = 6;
                box.grow(d, d - 2);
                return box;
            }

            /*
             * (non-Javadoc)
             * 
             * @see documents.graphical.activity_diagram.ExtendedNodeFigure#drawBorder(java.awt.Graphics)
             */
            public void drawBorder(Graphics g)
            {
                Rectangle r = displayBox();
                g.setColor(getFrameColor());
                g.drawRect(r.x, r.y, r.width - 1, r.height - 1);

                int x = r.x + r.width - 18;
                int y = r.y + r.height + 6;

                // Draw the little fork.
                g.setColor(Color.BLACK);
                g.drawLine(x, y, x, y - 5);
                g.drawLine(x, y - 5, x + 5, y - 5);
                g.drawLine(x + 5, y - 5, x + 5, y - 10);
                g.drawLine(x + 5, y - 5, x + 5, y);
                g.drawLine(x + 5, y - 5, x + 10, y - 5);
                g.drawLine(x + 10, y - 5, x + 10, y);

            }

        };
        text.setFont(new Font("Helvetica", Font.BOLD, 14));
        text.setText(activity.name());
        text.setAttribute("FillColor", new Color(0xE8E8E8));
        text.setAttribute("FrameColor", new Color(0xE8E8E8));

        getLayouter().setInsets(new Insets(20, 17, 4, 5));

        add(text);

        update();
    }

    /**
     * Creates a popup menu to edit the class or object name.
     */
    protected JPopupMenu createPopupMenu()
    {
        JPopupMenu popupMenu = new JPopupMenu();

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.name.activity"))
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
                    ((Activity) concept()).name().trim()))
                {
                    ((Activity) concept()).name((SingleConnector.manager()).getCreationName());
                    SingleConnector.manager().updateRedrawCode();
                    concept().redraw();
                }
            }
        });

        popupMenu.setLightWeightPopupEnabled(true);
        return popupMenu;
    }

}
