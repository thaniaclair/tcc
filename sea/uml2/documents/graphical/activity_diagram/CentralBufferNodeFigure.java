/*
 * @(#)CentralBufferNodeFigure.java
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
import CH.ifa.draw.contrib.GraphicalCompositeFigure;
import CH.ifa.draw.framework.Figure;
import documents.concepts.activity_diagram.CentralBufferNode;
import documents.concepts.communication_diagram.Label;
import documents.graphical.deployment_diagram.ExtendedTextFigure;
import documents.util.I18NProperties;

public class CentralBufferNodeFigure extends SpecificationCompositeFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 7634602589438807376L;

    /**
     * Default constructor.
     */
    public CentralBufferNodeFigure()
    {
        super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @Override
    public Class<CentralBufferNode> relatedConceptClass()
    {
        return CentralBufferNode.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(CentralBufferNode.class);
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

        CentralBufferNode buffer = (CentralBufferNode) this.concept();
        if ((buffer.getCentralBufferName() == null) || ("").equals(buffer.getCentralBufferName()))
        {
            buffer.setCentralBufferName("CentralBufferNode");
        }
        if ((buffer.getCentralBufferType() == null) || ("").equals(buffer.getCentralBufferType()))
        {
            buffer.setCentralBufferType("<<central buffer>>");
        }

        // NAME
        String bufferName = buffer.getCentralBufferName();
        Font fontName = (new Font("Helvetica", Font.BOLD, 14));
        FontMetrics metrics1 = Toolkit.getDefaultToolkit().getFontMetrics(fontName);
        int widthFig1 = metrics1.stringWidth(bufferName);

        // TYPE
        String bufferType = buffer.getCentralBufferType();
        Font fontType = new Font("Helvetica", Font.ITALIC, 11);
        FontMetrics metrics2 = Toolkit.getDefaultToolkit().getFontMetrics(fontType);
        int widthFig2 = metrics2.stringWidth(bufferType);

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
        figure.setText(bufferName);
        // TYPE
        figure2.setFont(fontType);
        figure2.setText(bufferType);

        GraphicalCompositeFigure gFigure = new GraphicalCompositeFigure();
        gFigure.setAttribute("FillColor", new Color(0xE8E8E8));
        gFigure.getLayouter().setInsets(new Insets(10, 10, 10, 2));
        gFigure.add(figure2);
        gFigure.add(figure);

        add(gFigure);

        this.setAttribute("FillColor", new Color(0xE8E8E8));

        update();

    }

    /**
     * Creates a popup menu to edit the class or object name.
     */
    protected JPopupMenu createPopupMenu()
    {
        JPopupMenu popupMenu = new JPopupMenu();

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.name.central.buffer"))
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
                    ((CentralBufferNode) concept()).getCentralBufferName().trim()))
                {
                    ((CentralBufferNode) concept())
                        .setCentralBufferName((SingleConnector.manager()).getCreationName());
                    SingleConnector.manager().updateRedrawCode();
                    concept().redraw();
                }
            }
        });

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.type.central.buffer"))
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
                String type = ((CentralBufferNode) concept()).getCentralBufferType().trim();
                if (type.startsWith("<<") && type.endsWith(">>"))
                {
                    type = type.substring(2, type.length() - 2);
                }

                if (SingleConnector.managerView().openDialogInterface(Constantes.NAME_SPEC, type))
                {
                    String newType = (SingleConnector.manager()).getCreationName();
                    if ((newType == null) || ("").equals(newType) || (" ").equals(newType))
                    {
                        newType = new String("central buffer");
                    }
                    ((CentralBufferNode) concept()).setCentralBufferType("<<" + newType + ">>");
                    SingleConnector.manager().updateRedrawCode();
                    concept().redraw();
                }
            }
        });

        popupMenu.setLightWeightPopupEnabled(true);
        return popupMenu;
    }

}
