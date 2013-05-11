/*
 * @(#)ObjectFlowFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Mar 4, 2008        descrição
 */
package documents.graphical.activity_diagram;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPopupMenu;

import ocean.accessories.SingleConnector;
import ocean.framework.Concept;
import ocean.smalltalk.Constantes;
import documents.concepts.activity_diagram.ObjectFlow;
import documents.graphical.state_machine_diagram.TransitionFigure;
import documents.util.I18NProperties;

public class ObjectFlowFigure extends TransitionFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -7538068839783167726L;

    /**
     * The control flow description.
     */
    private String flowDescription = null;

    /**
     * Constructor.
     */
    public ObjectFlowFigure()
    {
        super();
        this.flowDescription = new String("");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationLineFigure#relatedConceptClass()
     */
    @Override
    public Class< ? extends Concept> relatedConceptClass()
    {
        return ObjectFlow.class;
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.DependencyLineConnection#drawLine(java.awt.Graphics, int, int, int, int)
     */
    protected void drawLine(Graphics g, int x1, int y1, int x2, int y2)
    {
        super.drawLine(g, x1, y1, x2, y2);

        int xm = (x1 + x2) / 2;
        int ym = (y1 + y2) / 2;

        g.setFont(new Font("Helvetica", Font.BOLD, 14));
        g.setColor(Color.BLACK);

        if (flowDescription != null && !("").equals(flowDescription))
        {
            g.drawString(flowDescription, xm, ym);
        }

    }

    /**
     * Creates a popup menu to edit the class or object name.
     */
    protected JPopupMenu createPopupMenu()
    {
        JPopupMenu popupMenu = new JPopupMenu();

        popupMenu
            .add(new AbstractAction(I18NProperties.getString("change.object.flow.description"))
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
                        ObjectFlowFigure.this.flowDescription))
                    {
                        willChange();
                        ObjectFlowFigure.this.flowDescription = ((SingleConnector.manager())
                            .getCreationName());
                        SingleConnector.manager().updateRedrawCode();
                        ObjectFlowFigure.this.redraw();
                        change();
                        changed();
                    }
                }
            });

        popupMenu.setLightWeightPopupEnabled(true);
        return popupMenu;
    }

}
