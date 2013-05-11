/*
 * @(#)VerticalSwinlaneFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Mar 4, 2008        descrição
 */
package documents.graphical.activity_diagram;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.JPopupMenu;

import ocean.accessories.SingleConnector;
import ocean.jhotdraw.SeparatorFigure;
import ocean.jhotdraw.SpecificationCompositeFigure;
import ocean.smalltalk.Constantes;
import ocean.smalltalk.OceanVector;
import CH.ifa.draw.contrib.GraphicalCompositeFigure;
import CH.ifa.draw.figures.RectangleFigure;
import CH.ifa.draw.figures.TextFigure;
import CH.ifa.draw.framework.Figure;
import CH.ifa.draw.standard.BoxHandleKit;
import documents.concepts.activity_diagram.VerticalSwinlane;
import documents.util.I18NProperties;

public class VerticalSwinlaneFigure extends SpecificationCompositeFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 1423839872837875545L;

    /**
     * Default constructor.
     */
    public VerticalSwinlaneFigure()
    {
        super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @Override
    public Class<VerticalSwinlane> relatedConceptClass()
    {
        return VerticalSwinlane.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(VerticalSwinlane.class);
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

        VerticalSwinlane vertical = (VerticalSwinlane) this.concept();
        if (vertical.name() == null || ("").equals(vertical.name()))
        {
            vertical.name("partition");
        }

        TextFigure figure = new TextFigure();
        figure.setFont(new Font("Helvetica", Font.BOLD, 14));
        figure.setText(vertical.name());

        GraphicalCompositeFigure composite1 = new GraphicalCompositeFigure(new SeparatorFigure());
        composite1.getLayouter().setInsets(new Insets(15, 180, 15, 15));
        composite1.setAttribute("FillColor", new Color(0xE8E8E8));
        composite1.setAttribute("FrameColor", Color.BLACK);
        composite1.add(figure);

        add(composite1);

        GraphicalCompositeFigure composite2 = new GraphicalCompositeFigure();
        composite2.getLayouter().setInsets(new Insets(15, 180, 600, 15));
        composite2.setAttribute("FillColor", Color.WHITE);
        composite2.setAttribute("FrameColor", Color.BLACK);

        add(composite2);

        this.setAttribute("FillColor", new Color(0xE8E8E8));
        this.setAttribute("FrameColor", Color.BLACK);

        update();

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
     * Creates a popup menu to edit the class or object name.
     */
    protected JPopupMenu createPopupMenu()
    {
        JPopupMenu popupMenu = new JPopupMenu();

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.name.partition"))
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
                    ((VerticalSwinlane) concept()).name().trim()))
                {
                    ((VerticalSwinlane) concept()).name((SingleConnector.manager())
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
