/*
 * @(#)ControlFlowFigure.java
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
import ocean.framework.Concept;
import ocean.smalltalk.Constantes;
import ocean.smalltalk.OceanVector;
import documents.concepts.activity_diagram.ControlFlow;
import documents.graphical.state_machine_diagram.TransitionFigure;
import documents.util.I18NProperties;

public class ControlFlowFigure extends TransitionFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -7182025214217316668L;

    /**
     * The control flow description.
     */
    private String flowDescription = null;

    /**
     * Constructor.
     */
    public ControlFlowFigure()
    {
        super();
        this.flowDescription = new String("");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @Override
    public Class< ? extends Concept> relatedConceptClass()
    {
        return ControlFlow.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(ControlFlow.class);
        return auxList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.DependencyLineConnection#drawLine(java.awt.Graphics, int, int, int, int)
     */
    @SuppressWarnings("deprecation")
    protected void drawLine(Graphics g, int x1, int y1, int x2, int y2)
    {
        super.drawLine(g, x1, y1, x2, y2);

        if (flowDescription != null && !("").equals(flowDescription))
        {
            Font font = new Font("Helvetica", Font.BOLD, 14);
            FontMetrics metrics2 = Toolkit.getDefaultToolkit().getFontMetrics(font);
            int widthFig = metrics2.stringWidth(flowDescription);

            int xm = (x1 + x2) / 2;

            if (widthFig > 0)
            {
                xm -= (widthFig / 2);
            }
            int ym = (y1 + y2) / 2;

            g.setFont(font);
            g.setColor(Color.BLACK);

            g.drawString(flowDescription, xm, ym);
        }
    }

    /**
     * Creates a popup menu to edit the class or object name.
     */
    protected JPopupMenu createPopupMenu()
    {
        JPopupMenu popupMenu = new JPopupMenu();

        popupMenu.add(new AbstractAction(I18NProperties
            .getString("change.control.flow.description"))
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
                    ControlFlowFigure.this.flowDescription))
                {
                    willChange();
                    ControlFlowFigure.this.flowDescription = ((SingleConnector.manager())
                        .getCreationName());
                    SingleConnector.manager().updateRedrawCode();
                    ControlFlowFigure.this.redraw();
                    change();
                    changed();
                }
            }
        });

        popupMenu.setLightWeightPopupEnabled(true);
        return popupMenu;
    }

    /**
     * @return the flowDescription
     */
    public String getFlowDescription()
    {
        return flowDescription;
    }

    /**
     * @param flowDescription the flowDescription to set
     */
    public void setFlowDescription(String flowDescription)
    {
        this.flowDescription = flowDescription;
    }

}
