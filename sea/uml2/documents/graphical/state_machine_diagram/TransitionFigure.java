/*
 * @(#)TransitionFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Feb 22, 2008        descrição
 */
package documents.graphical.state_machine_diagram;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPopupMenu;

import ocean.accessories.SingleConnector;
import ocean.framework.Concept;
import ocean.smalltalk.Constantes;
import ocean.smalltalk.OceanVector;
import CH.ifa.draw.figures.ArrowTip;
import documents.concepts.state_machine_diagram.Transition;
import documents.graphical.object_diagram.AssociationLineConnection;
import documents.util.I18NProperties;

public class TransitionFigure extends AssociationLineConnection
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 3687498907780494966L;

    /**
     * The transition description.
     */
    private String transitionDescription = null;

    /**
     * Constructor.
     */
    public TransitionFigure()
    {
        super();
        setStartDecoration(null);
        ArrowTip arrow = new ArrowTip(0.35, 20.0, 5);
        arrow.setFillColor(Color.WHITE);
        arrow.setBorderColor(Color.BLACK);
        setEndDecoration(arrow);
        this.transitionDescription = new String("");
        this.createPopupMenu();
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @Override
    public Class< ? extends Concept> relatedConceptClass()
    {
        return Transition.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(Transition.class);
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

        if (transitionDescription != null && !("").equals(transitionDescription))
        {
            Font font = new Font("Helvetica", Font.BOLD, 14);
            FontMetrics metrics = Toolkit.getDefaultToolkit().getFontMetrics(font);
            int width = metrics.stringWidth(transitionDescription);

            int xm = (x1 + x2) / 2;

            if (width > 0)
            {
                xm -= (width / 2);
            }
            int ym = (y1 + y2) / 2;

            g.setFont(font);
            g.setColor(Color.BLACK);

            g.drawString(transitionDescription, xm, ym);
        }

    }

    /**
     * Creates a popup menu to edit the class or object name.
     */
    protected JPopupMenu createPopupMenu()
    {
        JPopupMenu popupMenu = new JPopupMenu();

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.transition.description"))
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
                    TransitionFigure.this.transitionDescription))
                {
                    willChange();
                    TransitionFigure.this.transitionDescription = ((SingleConnector.manager())
                        .getCreationName());
                    SingleConnector.manager().updateRedrawCode();
                    TransitionFigure.this.redraw();
                    change();
                    changed();
                }
            }
        });

        popupMenu.setLightWeightPopupEnabled(true);
        return popupMenu;
    }

}
