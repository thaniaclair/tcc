/*
 * @(#)ConnectorFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Feb 16, 2008        descrição
 */
package documents.graphical.composite_structure_diagram;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import ocean.accessories.SingleConnector;
import ocean.smalltalk.Constantes;
import documents.concepts.composite_structure_diagram.Connector;
import documents.graphical.object_diagram.AssociationLineConnection;
import documents.util.I18NProperties;

public class ConnectorFigure extends AssociationLineConnection
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -634197379359265118L;

    /**
     * The connectorDescription
     */
    private String connectorDescription = null;

    /**
     * The constructor.
     */
    public ConnectorFigure()
    {
        super();
        setStartDecoration(null);
        setEndDecoration(null);
        this.connectorDescription = new String("");
        this.createPopupMenu();
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.AssociationLineConnection#relatedConceptClass()
     */
    @Override
    public Class<Connector> relatedConceptClass()
    {
        return Connector.class;
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

        String description = this.getConnectorDescription();
        
        Font font = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metrics = Toolkit.getDefaultToolkit().getFontMetrics(font);
        int width = metrics.stringWidth(description);

        int xm = (x1 + x2) / 2;

        if (width > 0)
        {
            xm -= (width / 2);
        }
        int ym = (y1 + y2) / 2;

        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString(description, xm, ym - 3);
    }

    /**
     * @return the connectorDescription
     */
    public String getConnectorDescription()
    {
        if (connectorDescription == null)
        {
            connectorDescription = new String("");
        }
        return connectorDescription;
    }

    /**
     * @param connectorDescription the connectorDescription to set
     */
    public void setConnectorDescription(String connectorDescription)
    {
        this.connectorDescription = connectorDescription;
    }

    /**
     * Creates a popup menu to edit the class or object name.
     */
    protected JPopupMenu createPopupMenu()
    {
        JPopupMenu popupMenu = new JPopupMenu();

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.name.connector"))
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
                    ConnectorFigure.this.getConnectorDescription()))
                {
                    willChange();
                    ConnectorFigure.this.setConnectorDescription((SingleConnector.manager())
                        .getCreationName());
                    SingleConnector.manager().updateRedrawCode();
                    ConnectorFigure.this.redraw();
                    change();
                    changed();
                }
            }
        });

        popupMenu.setLightWeightPopupEnabled(true);
        return popupMenu;
    }

}