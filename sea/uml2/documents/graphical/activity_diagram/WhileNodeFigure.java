/*
 * @(#)WhileNodeFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Mar 13, 2008        descrição
 */
package documents.graphical.activity_diagram;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPopupMenu;

import ocean.accessories.SingleConnector;
import ocean.smalltalk.Constantes;
import ocean.smalltalk.OceanVector;
import documents.concepts.activity_diagram.LoopNode;
import documents.concepts.activity_diagram.WhileNode;
import documents.util.I18NProperties;

public class WhileNodeFigure extends LoopNodeFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 8587315660895341048L;

    /**
     * The stereotype of the while node.
     */
    private static final String TYPE = new String("<<WHILE>>");

    /**
     * Default constructor.
     */
    public WhileNodeFigure()
    {
        super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @Override
    public Class< ? extends LoopNode> relatedConceptClass()
    {
        return WhileNode.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(WhileNode.class);
        return auxList;
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

        super.createNodeFigure(this.createConcept());

        update();
    }

    /*
     * (non-Javadoc)
     * 
     * @see documents.graphical.activity_diagram.LoopNodeFigure#createLoopConcept()
     */
    protected WhileNode createConcept()
    {

        WhileNode whileNode = (WhileNode) this.concept();
        // NAME
        if (whileNode.getNodeName() == null || ("").equals(whileNode.getNodeName()))
        {
            whileNode.setNodeName("loop");
        }
        // TYPE
        whileNode.setNodeType(TYPE);

        return whileNode;
    }

    /**
     * Creates a popup menu to edit the do-while node.
     */
    protected JPopupMenu createPopupMenu()
    {
        JPopupMenu popupMenu = new JPopupMenu();

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.name.loop.node"))
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
                    ((WhileNode) concept()).getNodeName().trim()))
                {
                    ((WhileNode) concept()).setNodeName((SingleConnector.manager())
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
