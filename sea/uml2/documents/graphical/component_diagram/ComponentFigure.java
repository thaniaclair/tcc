/*
 * @(#)ComponentFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Jan 11, 2008        descrição
 */
package documents.graphical.component_diagram;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.JPopupMenu;

import ocean.accessories.SingleConnector;
import ocean.jhotdraw.SpecificationCompositeFigure;
import ocean.smalltalk.Constantes;
import ocean.smalltalk.OceanVector;
import CH.ifa.draw.contrib.GraphicalCompositeFigure;
import CH.ifa.draw.figures.PolyLineFigure;
import CH.ifa.draw.figures.RectangleFigure;
import CH.ifa.draw.framework.Figure;
import CH.ifa.draw.framework.FigureEnumeration;
import CH.ifa.draw.standard.NullHandle;
import CH.ifa.draw.standard.RelativeLocator;
import documents.concepts.component_diagram.Component;
import documents.concepts.deployment_diagram.Node;
import documents.graphical.deployment_diagram.DeploymentDiagramDrawing;
import documents.graphical.deployment_diagram.ExtendedTextFigure;
import documents.graphical.deployment_diagram.NodeFigure;
import documents.util.I18NProperties;

public class ComponentFigure extends SpecificationCompositeFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -3360539347429614894L;

    /**
     * A list of port figures.
     */
    private List<PortFigure> portFigureList = new LinkedList<PortFigure>();

    /**
     * A node figure.
     */
    private NodeFigure nodeFig;

    /**
     * The drawing.
     */
    private DeploymentDiagramDrawing drawing;

    /**
     * Default constructor.
     */
    public ComponentFigure()
    {
        super(new RectangleFigure());
    }

    /**
     * Overloaded constructor.
     * 
     * @param object
     */
    public ComponentFigure(Component component)
    {
        super(component);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @Override
    public Class<Component> relatedConceptClass()
    {
        return Component.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(Component.class);
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
     * @see CH.ifa.draw.standard.AbstractFigure#moveBy(int, int)
     */
    public void moveBy(int dx, int dy)
    {

        // It doesn't belong to a node.
        if ((nodeFig == null) && (drawing != null))
        {
            int xComp = this.displayBox().x;
            int yComp = this.displayBox().y;
            int wComp = this.displayBox().width;
            int hComp = this.displayBox().height;

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
                    if (((xComp > xNode) && (xComp < (xNode + wNode - wComp)) /* BOTTOM */
                            && (yComp < (yNode + hNode - hComp)) && (yComp > yNode))
                            || ((xComp < (xNode + wNode - wComp)) && (xComp > xNode) /* RIGHT */
                                    && (yComp > yNode) && (yComp < (yNode + hNode - hComp)))
                            || ((yComp > yNode) && (yComp < (yNode + hNode - hComp)) /* TOP */
                                    && (xComp > xNode) && (xComp < (xNode + wNode - wComp)))
                            || ((xComp > xNode) && (xComp < (xNode + wNode - wComp)) /* LEFT */
                                    && (yComp > yNode) && (yComp < (yNode + hNode - hComp))))
                    {
                        nodeFig = (NodeFigure) nextFigure;
                        nodeFig.getComponentFigureList().add(this);
                        ((Node) nodeFig.concept()).getComponentList().add((Component) concept());
                        return;
                    }
                }
            }
        }
        // It belongs to a package.
        else if ((nodeFig != null) && (drawing != null))
        {

            int x = nodeFig.getPresentationFigure().displayBox().x;
            int y = nodeFig.getPresentationFigure().displayBox().y;
            int width = nodeFig.getPresentationFigure().displayBox().width;
            int height = nodeFig.getPresentationFigure().displayBox().height;

            final int w = (width == 0) ? 0 : width;
            final int h = (height == 0) ? 0 : height;

            int oldX = this.displayBox().x;
            int oldY = this.displayBox().y;
            int classWidth = this.displayBox().width;
            int classHeight = this.displayBox().height;

            int leftBoundary = x + 10;
            int rightBoundary = x + w - 10 - classWidth;
            int topBoundary = y + 5;
            int bottomBoundary = y + h - 10 - classHeight;

            int newX = dx;
            int newY = dy;

            // Add restriction inside of the package.
            if (((oldX + dx) < leftBoundary) || ((oldX + dx) > rightBoundary)
                    || ((oldY + dy) < topBoundary) || ((oldY + dy) > bottomBoundary))
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

        for (PortFigure portFig : portFigureList)
        {
            portFig.moveBy(dx, dy);
        }
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

        Component component = (Component) this.concept();
        if (component.getComponentName() == null || ("").equals(component.getComponentName()))
        {
            component.setComponentName("componente");
        }

        if (component.getComponentType() == null || ("").equals(component.getComponentType()))
        {
            component.setComponentType("<<component>>");
        }

        // NAME
        Font fontName = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metrics1 = Toolkit.getDefaultToolkit().getFontMetrics(fontName);
        int widthFig1 = metrics1.stringWidth(component.getComponentName());

        // TYPE
        Font fontType = new Font("Helvetica", Font.ITALIC, 11);
        FontMetrics metrics2 = Toolkit.getDefaultToolkit().getFontMetrics(fontType);
        int widthFig2 = metrics2.stringWidth(component.getComponentType());

        ExtendedTextFigure figure;
        ExtendedTextFigure figure2;
        int w = 0;

        if (widthFig1 >= widthFig2)
        {
            w = widthFig1;
            // NAME
            figure = new ExtendedTextFigure();
            // TYPE
            figure2 = new ExtendedTextFigure((widthFig1 - widthFig2) / 2);
        }
        else
        {
            w = widthFig2;
            // NAME
            figure = new ExtendedTextFigure((widthFig2 - widthFig1) / 2);
            // TYPE
            figure2 = new ExtendedTextFigure();
        }

        // NAME
        figure.setFont(fontName);
        figure.setText(component.getComponentName());
        // TYPE
        figure2.setFont(fontType);
        figure2.setText(component.getComponentType());

        GraphicalCompositeFigure gFigure = new GraphicalCompositeFigure();
        gFigure.getLayouter().setInsets(new Insets(40, 30, 20, 2));
        gFigure.setAttribute("FillColor", new Color(0xE8E8E8));
        gFigure.add(figure2);
        gFigure.add(figure);

        int x = this.getPresentationFigure().displayBox().x;
        int y = this.getPresentationFigure().displayBox().y;

        PolyLineFigure poly = new PolyLineFigure();

        poly.addPoint(x + w + 19, y + 15);
        poly.addPoint(x + w + 29, y + 15);
        poly.addPoint(x + w + 29, y + 18);
        poly.addPoint(x + w + 19, y + 18);
        poly.addPoint(x + w + 19, y + 15);

        poly.setAttribute("FillColor", new Color(0xE8E8E8));
        poly.setAttribute("FrameColor", Color.BLACK);

        gFigure.add(poly);

        poly = new PolyLineFigure();

        poly.addPoint(x + w + 19, y + 20);
        poly.addPoint(x + w + 29, y + 20);
        poly.addPoint(x + w + 29, y + 23);
        poly.addPoint(x + w + 19, y + 23);
        poly.addPoint(x + w + 19, y + 20);

        poly.setAttribute("FillColor", new Color(0xE8E8E8));
        poly.setAttribute("FrameColor", Color.BLACK);

        gFigure.add(poly);

        poly = new PolyLineFigure();

        poly.addPoint(x + w + 24, y + 18);
        poly.addPoint(x + w + 24, y + 20);

        poly.setAttribute("FillColor", new Color(0xE8E8E8));
        poly.setAttribute("FrameColor", Color.BLACK);

        gFigure.add(poly);

        poly = new PolyLineFigure();

        poly.addPoint(x + w + 24, y + 15);
        poly.addPoint(x + w + 24, y + 13);
        poly.addPoint(x + w + 39, y + 13);
        poly.addPoint(x + w + 39, y + 25);
        poly.addPoint(x + w + 24, y + 25);
        poly.addPoint(x + w + 24, y + 23);

        poly.setAttribute("FillColor", new Color(0xE8E8E8));
        poly.setAttribute("FrameColor", Color.BLACK);

        gFigure.add(poly);
        add(gFigure);

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

    /**
     * Creates a popup menu to edit the class or object name.
     */
    protected JPopupMenu createPopupMenu()
    {
        JPopupMenu popupMenu = new JPopupMenu();

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.name.component"))
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
                    ((Component) concept()).getComponentName().trim()))
                {
                    ((Component) concept()).setComponentName((SingleConnector.manager())
                        .getCreationName());
                    SingleConnector.manager().updateRedrawCode();
                    concept().redraw();
                }
            }
        });

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.type.component"))
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
                String type = ((Component) concept()).getComponentType().trim();
                if (type.startsWith("<<") && type.endsWith(">>"))
                {
                    type = type.substring(2, type.length() - 2);
                }

                if (SingleConnector.managerView().openDialogInterface(Constantes.NAME_SPEC, type))
                {
                    String newType = (SingleConnector.manager()).getCreationName();
                    if ((newType == null) || ("").equals(newType) || (" ").equals(newType))
                    {
                        newType = new String("componente");
                    }
                    ((Component) concept()).setComponentType("<<" + newType + ">>");
                    SingleConnector.manager().updateRedrawCode();
                    concept().redraw();
                }
            }
        });

        popupMenu.setLightWeightPopupEnabled(true);
        return popupMenu;
    }

    /**
     * @return the portFigureList
     */
    public List<PortFigure> getPortFigureList()
    {
        return portFigureList;
    }

    /**
     * @param portFigureList the portFigureList to set
     */
    public void setPortFigureList(List<PortFigure> portFigureList)
    {
        this.portFigureList = portFigureList;
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
