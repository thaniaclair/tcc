/*
 * @(#)DeploymentSpecificationFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Jan 24, 2008        descrição
 */
package documents.graphical.deployment_diagram;

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
import CH.ifa.draw.framework.Figure;
import CH.ifa.draw.framework.FigureEnumeration;
import CH.ifa.draw.standard.NullHandle;
import CH.ifa.draw.standard.RelativeLocator;
import documents.concepts.deployment_diagram.Artifact;
import documents.concepts.deployment_diagram.DeploymentSpecification;
import documents.concepts.deployment_diagram.Node;
import documents.util.I18NProperties;

public class DeploymentSpecificationFigure extends SpecificationCompositeFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 4624462347032016058L;

    /**
     * A node figure.
     */
    private NodeFigure nodeFig;

    /**
     * The drawing.
     */
    private DeploymentDiagramDrawing drawing;

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @Override
    public Class<DeploymentSpecification> relatedConceptClass()
    {
        return DeploymentSpecification.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(Artifact.class);
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

        DeploymentSpecification deploy = (DeploymentSpecification) this.concept();
        if (deploy.getDeployName() == null || ("").equals(deploy.getDeployName()))
        {
            deploy.setDeployName("deployment");
        }

        if (deploy.getDeployType() == null || ("").equals(deploy.getDeployType()))
        {
            deploy.setDeployType("<<deployment spec>>");
        }

        // NAME
        Font fontName = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metrics1 = Toolkit.getDefaultToolkit().getFontMetrics(fontName);
        int widthFig1 = metrics1.stringWidth(deploy.getDeployName());

        // TYPE
        Font fontType = new Font("Helvetica", Font.ITALIC, 11);
        FontMetrics metrics2 = Toolkit.getDefaultToolkit().getFontMetrics(fontType);
        int widthFig2 = metrics2.stringWidth(deploy.getDeployType());

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
        figure.setText(deploy.getDeployName());
        // TYPE
        figure2.setFont(fontType);
        figure2.setText(deploy.getDeployType());

        GraphicalCompositeFigure gFigure = new GraphicalCompositeFigure();
        gFigure.getLayouter().setInsets(new Insets(10, 10, 10, 2));
        gFigure.setAttribute("FillColor", new Color(0xE8E8E8));
        gFigure.add(figure2);
        gFigure.add(figure);

        add(gFigure);

        SeparatorFigure s = new SeparatorFigure();
        s.setAttribute("FillColor", new Color(0xE8E8E8));
        s.setAttribute("FrameColor", Color.BLACK);

        gFigure = new GraphicalCompositeFigure(s);
        gFigure.getLayouter().setInsets(new Insets(5, 5, 5, 5));
        gFigure.setAttribute("FillColor", new Color(0xE8E8E8));

        add(gFigure);

        this.getPresentationFigure().setAttribute("FillColor", new Color(0xE8E8E8));
        this.getPresentationFigure().setAttribute("FrameColor", Color.BLACK);

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
        handles.addElement(new NullHandle(this, RelativeLocator.northWest()));
        handles.addElement(new NullHandle(this, RelativeLocator.northEast()));
        handles.addElement(new NullHandle(this, RelativeLocator.southWest()));
        handles.addElement(new NullHandle(this, RelativeLocator.southEast()));
        return handles;
    }

    /*
     * (non-Javadoc)
     * 
     * @see CH.ifa.draw.standard.AbstractFigure#moveBy(int, int)
     */
    @Override
    public void moveBy(int dx, int dy)
    {

        // It doesn't belong to a node.
        if ((nodeFig == null) && (drawing != null))
        {
            int xDep = this.displayBox().x;
            int yDep = this.displayBox().y;
            int wDep = this.displayBox().width;
            int hDep = this.displayBox().height;

            FigureEnumeration enumeration = drawing.figures();
            while (enumeration.hasMoreElements())
            {
                Figure nextFigure = enumeration.nextFigure();
                if (nextFigure instanceof NodeFigure)
                {
                    Rectangle displayBox = nextFigure.displayBox();
                    int xNode = displayBox.x;
                    int yNode = displayBox.y;
                    int wNode = displayBox.width;
                    int hNode = displayBox.height;

                    // Checks the restrictions.
                    if (((xDep > xNode) && (xDep < (xNode + wNode - wDep)) /* BOTTOM */
                            && (yDep < (yNode + hNode - hDep)) && (yDep > yNode))
                            || ((xDep < (xNode + wNode - wDep)) && (xDep > xNode) /* RIGHT */
                                    && (yDep > yNode) && (yDep < (yNode + hNode - hDep)))
                            || ((yDep > yNode) && (yDep < (yNode + hNode - hDep)) /* TOP */
                                    && (xDep > xNode) && (xDep < (xNode + wNode - wDep)))
                            || ((xDep > xNode) && (xDep < (xNode + wNode - wDep)) /* LEFT */
                                    && (yDep > yNode) && (yDep < (yNode + hNode - hDep))))
                    {
                        nodeFig = (NodeFigure) nextFigure;
                        nodeFig.getDeploySpecList().add(this);
                        ((Node) nodeFig.concept()).getDeployList().add(
                            (DeploymentSpecification) concept());
                        super.moveBy(dx, dy);
                        break;
                    }
                }
            }
        }
        // It belongs to a node.
        else if ((nodeFig != null) && (drawing != null))
        {
            int x = nodeFig.getPresentationFigure().displayBox().x;
            int y = nodeFig.getPresentationFigure().displayBox().y;
            int w = nodeFig.getPresentationFigure().displayBox().width;
            int h = nodeFig.getPresentationFigure().displayBox().height;

            int deployX = this.displayBox().x;
            int deployY = this.displayBox().y;
            int deployW = this.displayBox().width;
            int deployH = this.displayBox().height;

            int leftBoundary = x + 10;
            int rightBoundary = x + w - 10 - deployW;
            int topBoundary = y + 5;
            int bottomBoundary = y + h - 10 - deployH;

            int newX = dx;
            int newY = dy;

            // Add restriction inside of the package.
            if (((deployX + dx) < leftBoundary) || ((deployX + dx) > rightBoundary)
                    || ((deployY + dy) < topBoundary) || ((deployY + dy) > bottomBoundary))
            {
                // Don't move!!!
                return;
            }

            super.moveBy(newX, newY);
        }

        if (nodeFig == null)
        {
            super.moveBy(dx, dy);
        }

    }

    /**
     * Creates a popup menu to edit the class or object name.
     */
    protected JPopupMenu createPopupMenu()
    {
        JPopupMenu popupMenu = new JPopupMenu();

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.name.deploy.spec"))
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
                    ((DeploymentSpecification) concept()).getDeployName().trim()))
                {
                    ((DeploymentSpecification) concept()).setDeployName((SingleConnector.manager())
                        .getCreationName());
                    SingleConnector.manager().updateRedrawCode();
                    concept().redraw();
                }
            }
        });

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.type.deploy.spec"))
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
                String type = ((DeploymentSpecification) concept()).getDeployType().trim();
                if (type.startsWith("<<") && type.endsWith(">>"))
                {
                    type = type.substring(2, type.length() - 2);
                }

                if (SingleConnector.managerView().openDialogInterface(Constantes.NAME_SPEC, type))
                {
                    String newType = (SingleConnector.manager()).getCreationName();
                    if ((newType == null) || ("").equals(newType) || (" ").equals(newType))
                    {
                        newType = new String("artefato");
                    }
                    ((DeploymentSpecification) concept()).setDeployType("<<" + newType + ">>");

                    SingleConnector.manager().updateRedrawCode();
                    concept().redraw();
                }
            }
        });

        popupMenu.setLightWeightPopupEnabled(true);
        return popupMenu;
    }

    /**
     * @return the drawing
     */
    public DeploymentDiagramDrawing getDrawing()
    {
        return drawing;
    }

    /**
     * @param drawing the drawing to set
     */
    public void setDrawing(DeploymentDiagramDrawing drawing)
    {
        this.drawing = drawing;
    }

}
