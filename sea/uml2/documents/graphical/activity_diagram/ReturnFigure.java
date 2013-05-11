/*
 * @(#)ReturnFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Mar 11, 2008        descrição
 */
package documents.graphical.activity_diagram;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPopupMenu;

import ocean.accessories.SingleConnector;
import ocean.smalltalk.Constantes;
import ocean.smalltalk.OceanVector;
import CH.ifa.draw.contrib.GraphicalCompositeFigure;
import CH.ifa.draw.framework.Figure;
import documents.concepts.activity_diagram.Activity;
import documents.concepts.activity_diagram.Assignment;
import documents.concepts.activity_diagram.Return;
import documents.graphical.deployment_diagram.ExtendedTextFigure;
import documents.util.I18NProperties;

public class ReturnFigure extends ActivityFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -1084244837859099881L;

    /**
     * The stereotype of the return activity.
     */
    private static final String TYPE = new String("<<return>>");

    /**
     * Constructor.
     */
    public ReturnFigure()
    {
        super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @Override
    public Class< ? extends Activity> relatedConceptClass()
    {
        return Return.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(Return.class);
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

        Return returnConcept = (Return) this.concept();
        if ((returnConcept.name() == null) || ("").equals(returnConcept.name()))
        {
            returnConcept.name("a");
        }

        // NAME
        String returnName = returnConcept.name();
        Font fontName = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metrics1 = Toolkit.getDefaultToolkit().getFontMetrics(fontName);
        int widthFig1 = metrics1.stringWidth(returnName);

        // TYPE
        Font fontType = new Font("Helvetica", Font.ITALIC, 11);
        FontMetrics metrics2 = Toolkit.getDefaultToolkit().getFontMetrics(fontType);
        int widthFig2 = metrics2.stringWidth(TYPE);

        ExtendedTextFigure figure;
        ExtendedTextFigure figure2;

        if (widthFig1 >= widthFig2)
        {
            // NAME
            figure = new ExtendedTextFigure();
            // TYPE
            figure2 = new ExtendedTextFigure((widthFig1 - widthFig2) / 2);
        }
        else
        {
            // NAME
            figure = new ExtendedTextFigure((widthFig2 - widthFig1) / 2);
            // TYPE
            figure2 = new ExtendedTextFigure();
        }

        // NAME
        figure.setFont(fontName);
        figure.setText(returnName);
        // TYPE
        figure2.setFont(fontType);
        figure2.setText(TYPE);

        GraphicalCompositeFigure gFigure = new GraphicalCompositeFigure();
        gFigure.setAttribute("FillColor", grayColor);
        gFigure.setAttribute("FrameColor", grayColor);
        gFigure.getLayouter().setInsets(new Insets(10, 10, 10, 2));
        gFigure.add(figure2);
        gFigure.add(figure);

        add(gFigure);

        getLayouter().setInsets(new Insets(5, 5, 5, 5));

        update();
    }

    /**
     * Creates a popup menu to edit the class or object name.
     */
    protected JPopupMenu createPopupMenu()
    {
        JPopupMenu popupMenu = new JPopupMenu();

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.name.return"))
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
                    ((Return) concept()).name().trim()))
                {
                    ((Return) concept()).name((SingleConnector.manager()).getCreationName());
                    SingleConnector.manager().updateRedrawCode();
                    concept().redraw();
                }
            }
        });

        popupMenu.setLightWeightPopupEnabled(true);
        return popupMenu;
    }

}
