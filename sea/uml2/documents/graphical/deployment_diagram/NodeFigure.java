/*
 * @(#)NodeFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Jan 24, 2008        descrição
 */
package documents.graphical.deployment_diagram;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JPopupMenu;

import ocean.accessories.SingleConnector;
import ocean.jhotdraw.SpecificationCompositeFigure;
import ocean.smalltalk.Constantes;
import ocean.smalltalk.OceanVector;
import CH.ifa.draw.contrib.GraphicalCompositeFigure;
import CH.ifa.draw.framework.Figure;
import documents.concepts.deployment_diagram.Node;
import documents.graphical.component_diagram.ComponentFigure;
import documents.util.I18NProperties;

public class NodeFigure extends SpecificationCompositeFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 7729972279452002677L;

    /**
     * The cube figure.
     */
    private CubeFigure cube = new CubeFigure();

    /**
     * A list of artifact figures.
     */
    private List<ArtifactFigure> artifactFigureList = new LinkedList<ArtifactFigure>();

    /**
     * A list of component figures.
     */
    private List<ComponentFigure> componentFigureList = new LinkedList<ComponentFigure>();

    /**
     * A list of deployment specification figures.
     */
    private List<DeploymentSpecificationFigure> deploySpecList = new LinkedList<DeploymentSpecificationFigure>();

    /**
     * Constructor.
     */
    public NodeFigure()
    {
        super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @Override
    public Class<Node> relatedConceptClass()
    {
        return Node.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(Node.class);
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

        Node node = (Node) this.concept();
        if (node.getNodeName() == null || ("").equals(node.getNodeName()))
        {
            node.setNodeName("node");
        }

        Font textFont = new Font("Helvetica", Font.BOLD, 14);
        ExtendedTextFigure tf = new ExtendedTextFigure()
        {

            /**
             * The generated serial version UID.
             */
            private static final long serialVersionUID = -8424263341728825447L;

            /*
             * (non-Javadoc)
             * 
             * @see documents.graphical.deployment_diagram.ExtendedTextFigure#drawBackground(java.awt.Graphics)
             */
            public void drawBackground(Graphics g)
            {
                int y = getPresentationFigure().displayBox().y + 5;
                Rectangle r = displayBox();
                g.fillRect(r.x, y, r.width, r.height);
            }

            /*
             * (non-Javadoc)
             * 
             * @see documents.graphical.deployment_diagram.ExtendedTextFigure#drawFrame(java.awt.Graphics)
             */
            public void drawFrame(Graphics g)
            {
                int y = getPresentationFigure().displayBox().y + 5;
                g.setFont(getFFont());
                g.setColor((Color) getAttribute("TextColor"));
                FontMetrics metrics = g.getFontMetrics(getFFont());
                g.drawString(getFText(), getFOriginX(), y + metrics.getAscent());
            }
        };
        tf.setText(node.getNodeName());
        tf.setFont(textFont);

        GraphicalCompositeFigure gc = new GraphicalCompositeFigure()
        {

            /**
             * The serial version UID.
             */
            private static final long serialVersionUID = -8589366744617460851L;

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.contrib.GraphicalCompositeFigure#getPresentationFigure()
             */
            public Figure getPresentationFigure()
            {
                return cube;
            }
        };
        gc.setAttribute("FillColor", new Color(0xE8E8E8));
        gc.getLayouter().setInsets(new Insets(100, 200, 100, 1));
        gc.add(tf);

        add(gc);

        update();
    }

    /*
     * (non-Javadoc)
     * 
     * @see CH.ifa.draw.standard.AbstractFigure#moveBy(int, int)
     */
    public void moveBy(int x, int y)
    {
        super.moveBy(x, y);

        // COMPONENTS
        for (ComponentFigure componentFig : componentFigureList)
        {
            componentFig.moveBy(x, y);
        }

        // ARTIFACTS
        for (ArtifactFigure artifactFig : artifactFigureList)
        {
            artifactFig.moveBy(x, y);
        }

        // DEPLOYMENT SPECIFICATIONS
        for (DeploymentSpecificationFigure deployFig : deploySpecList)
        {
            deployFig.moveBy(x, y);
        }
    }

    /**
     * Creates a popup menu to edit the class or object name.
     */
    protected JPopupMenu createPopupMenu()
    {
        JPopupMenu popupMenu = new JPopupMenu();

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.name.node"))
        {

            /**
             * The generated serial version UID.
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
                    ((Node) concept()).getNodeName().trim()))
                {
                    ((Node) concept()).setNodeName((SingleConnector.manager()).getCreationName());
                    SingleConnector.manager().updateRedrawCode();
                    concept().redraw();
                }
            }
        });

        popupMenu.setLightWeightPopupEnabled(true);
        return popupMenu;
    }

    /**
     * @return the artifactFigureList
     */
    public List<ArtifactFigure> getArtifactFigureList()
    {
        return artifactFigureList;
    }

    /**
     * @param artifactFigureList the artifactFigureList to set
     */
    public void setArtifactFigureList(List<ArtifactFigure> artifactFigureList)
    {
        this.artifactFigureList = artifactFigureList;
    }

    /**
     * @return the componentFigureList
     */
    public List<ComponentFigure> getComponentFigureList()
    {
        return componentFigureList;
    }

    /**
     * @param componentFigureList the componentFigureList to set
     */
    public void setComponentFigureList(List<ComponentFigure> componentFigureList)
    {
        this.componentFigureList = componentFigureList;
    }

    /**
     * @return the deploySpecList
     */
    public List<DeploymentSpecificationFigure> getDeploySpecList()
    {
        return deploySpecList;
    }

    /**
     * @param deploySpecList the deploySpecList to set
     */
    public void setDeploySpecList(List<DeploymentSpecificationFigure> deploySpecList)
    {
        this.deploySpecList = deploySpecList;
    }

}
