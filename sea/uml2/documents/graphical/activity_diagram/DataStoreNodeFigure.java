/*
 * @(#)DataStoreNodeFigure.java
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

import CH.ifa.draw.contrib.GraphicalCompositeFigure;
import CH.ifa.draw.framework.Figure;
import ocean.accessories.SingleConnector;
import ocean.jhotdraw.SpecificationCompositeFigure;
import ocean.smalltalk.Constantes;
import ocean.smalltalk.OceanVector;
import documents.concepts.activity_diagram.Action;
import documents.concepts.activity_diagram.CentralBufferNode;
import documents.concepts.activity_diagram.DataStoreNode;
import documents.concepts.communication_diagram.Label;
import documents.graphical.deployment_diagram.ExtendedTextFigure;
import documents.util.I18NProperties;

public class DataStoreNodeFigure extends SpecificationCompositeFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -1048160366900942343L;

    /**
     * Default constructor.
     */
    public DataStoreNodeFigure()
    {
        super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @Override
    public Class<DataStoreNode> relatedConceptClass()
    {
        return DataStoreNode.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(DataStoreNode.class);
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

        DataStoreNode data = (DataStoreNode) this.concept();
        if ((data.getDataStoreName() == null) || ("").equals(data.getDataStoreName()))
        {
            data.setDataStoreName("DataStoreNode");
        }
        if ((data.getDataStoreType() == null) || ("").equals(data.getDataStoreType()))
        {
            data.setDataStoreType("<<data store>>");
        }

        // NAME
        String dataName = data.getDataStoreName();
        Font fontName = (new Font("Helvetica", Font.BOLD, 14));
        FontMetrics metrics1 = Toolkit.getDefaultToolkit().getFontMetrics(fontName);
        int widthFig1 = metrics1.stringWidth(dataName);

        // TYPE
        String dataType = data.getDataStoreType();
        Font fontType = new Font("Helvetica", Font.ITALIC, 11);
        FontMetrics metrics2 = Toolkit.getDefaultToolkit().getFontMetrics(fontType);
        int widthFig2 = metrics2.stringWidth(dataType);

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
        figure.setText(dataName);
        // TYPE
        figure2.setFont(fontType);
        figure2.setText(dataType);

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

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.name.data.store"))
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
                    ((DataStoreNode) concept()).getDataStoreName().trim()))
                {
                    ((DataStoreNode) concept()).setDataStoreName((SingleConnector.manager())
                        .getCreationName());
                    SingleConnector.manager().updateRedrawCode();
                    concept().redraw();
                }
            }
        });

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.type.data.store"))
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
                String type = ((DataStoreNode) concept()).getDataStoreType().trim();
                if (type.startsWith("<<") && type.endsWith(">>"))
                {
                    type = type.substring(2, type.length() - 2);
                }

                if (SingleConnector.managerView().openDialogInterface(Constantes.NAME_SPEC, type))
                {
                    String newType = (SingleConnector.manager()).getCreationName();
                    if ((newType == null) || ("").equals(newType) || (" ").equals(newType))
                    {
                        newType = new String("data store");
                    }
                    ((DataStoreNode) concept()).setDataStoreType("<<" + newType + ">>");
                    SingleConnector.manager().updateRedrawCode();
                    concept().redraw();
                }
            }
        });

        popupMenu.setLightWeightPopupEnabled(true);
        return popupMenu;
    }

}
