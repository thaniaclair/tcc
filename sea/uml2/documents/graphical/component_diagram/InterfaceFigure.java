/*
 * @(#)InterfaceFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Jan 11, 2008        descrição
 */
package documents.graphical.component_diagram;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPopupMenu;

import ocean.accessories.SingleConnector;
import ocean.jhotdraw.SpecificationCompositeFigure;
import ocean.smalltalk.Constantes;
import ocean.smalltalk.OceanVector;
import CH.ifa.draw.contrib.GraphicalCompositeFigure;
import CH.ifa.draw.figures.EllipseFigure;
import CH.ifa.draw.figures.RectangleFigure;
import CH.ifa.draw.figures.TextFigure;
import CH.ifa.draw.framework.Figure;
import documents.concepts.component_diagram.Interface;
import documents.util.I18NProperties;

public class InterfaceFigure extends SpecificationCompositeFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -8939607608294996977L;

    /**
     * A empty fill rectangle figure.
     * 
     * @author thania
     * @since Apr 7, 2008
     */
    class EmptyFillRectangle extends RectangleFigure
    {

        /**
         * The generated serial version UID.
         */
        private static final long serialVersionUID = 7460260942123340735L;

        /*
         * (non-Javadoc)
         * 
         * @see CH.ifa.draw.figures.RectangleFigure#drawFrame(java.awt.Graphics)
         */
        public void drawFrame(Graphics g)
        {
            // EMPTY.
        }

        /*
         * (non-Javadoc)
         * 
         * @see CH.ifa.draw.figures.RectangleFigure#drawBackground(java.awt.Graphics)
         */
        public void drawBackground(Graphics g)
        {
            // EMPTY.
        }
    }

    /**
     * Default constructor.
     */
    public InterfaceFigure()
    {
        super();
        this.setPresentationFigure(new EmptyFillRectangle());
    }

    /**
     * Overloaded constructor.
     * 
     * @param object
     */
    public InterfaceFigure(Interface interfaceConcept)
    {
        super(interfaceConcept);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @Override
    public Class<Interface> relatedConceptClass()
    {
        return Interface.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(Interface.class);
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
    public void redraw()
    {

        removeAll();

        Interface inter = (Interface) this.concept();
        if (inter.getInterfaceName() == null || ("").equals(inter.getInterfaceName()))
        {
            inter.setInterfaceName("interface");
        }
        TextFigure figure = new TextFigure();
        figure.setFont(new Font("Helvetica", Font.BOLD, 14));
        figure.setText(inter.getInterfaceName());

        final int w = figure.textDisplayBox().width;

        EllipseFigure ef = new EllipseFigure()
        {

            /**
             * The serial version UID.
             */
            private static final long serialVersionUID = -5990021166034781909L;

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.figures.EllipseFigure#drawBackground(java.awt.Graphics)
             */
            public void drawBackground(Graphics g)
            {
                Rectangle r = displayBox();
                g.fillOval(r.x + w / 2 - 14, r.y, 28, 28);
            }

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.figures.EllipseFigure#drawFrame(java.awt.Graphics)
             */
            public void drawFrame(Graphics g)
            {
                Rectangle r = displayBox();
                g.drawOval(r.x + w / 2 - 14, r.y, 28, 28);
            }
        };
        ef.setAttribute("FillColor", new Color(0xE8E8E8));
        ef.setAttribute("FrameColor", new Color(0x000000));

        GraphicalCompositeFigure gf = new GraphicalCompositeFigure(new EmptyFillRectangle());
        gf.getLayouter().setInsets(new Insets(10, 0, 10, 10));
        gf.setAttribute("FillColor", Color.WHITE);
        gf.setAttribute("FrameColor", new Color(0xFFFFFF));
        gf.add(ef);
        add(gf);

        add(figure);

        update();
    }

    /**
     * Creates a popup menu to edit the class or object name.
     */
    protected JPopupMenu createPopupMenu()
    {
        JPopupMenu popupMenu = new JPopupMenu();

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.name.interface"))
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
                    ((Interface) concept()).getInterfaceName()))
                {
                    ((Interface) concept()).setInterfaceName((SingleConnector.manager())
                        .getCreationName());
                    SingleConnector.manager().updateRedrawCode();
                    concept().redraw();
                }
            }
        });

        popupMenu.setLightWeightPopupEnabled(true);
        return popupMenu;
    }

}
