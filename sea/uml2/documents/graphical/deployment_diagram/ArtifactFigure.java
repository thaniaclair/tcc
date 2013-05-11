/*
 * @(#)Artifact.java
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
import documents.concepts.deployment_diagram.Artifact;
import documents.concepts.deployment_diagram.Node;
import documents.util.I18NProperties;

public class ArtifactFigure extends SpecificationCompositeFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -6463263692282797635L;

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
    public ArtifactFigure()
    {
        super(new RectangleFigure());
    }

    /**
     * Overloaded constructor.
     * 
     * @param object
     */
    public ArtifactFigure(Artifact arti)
    {
        super(arti);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @Override
    public Class<Artifact> relatedConceptClass()
    {
        return Artifact.class;
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

        Artifact artifact = (Artifact) this.concept();
        if (artifact.getArtifactName() == null || ("").equals(artifact.getArtifactName()))
        {
            artifact.setArtifactName("artefato");
        }

        if (artifact.getArtifactType() == null || ("").equals(artifact.getArtifactType()))
        {
            artifact.setArtifactType("<<artifact>>");
        }

        // NAME
        Font fontName = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metrics1 = Toolkit.getDefaultToolkit().getFontMetrics(fontName);
        int widthFig1 = metrics1.stringWidth(artifact.getArtifactName());

        // TYPE
        Font fontType = new Font("Helvetica", Font.ITALIC, 11);
        FontMetrics metrics2 = Toolkit.getDefaultToolkit().getFontMetrics(fontType);
        int widthFig2 = metrics2.stringWidth(artifact.getArtifactType());

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
        figure.setText(artifact.getArtifactName());
        // TYPE
        figure2.setFont(fontType);
        figure2.setText(artifact.getArtifactType());

        GraphicalCompositeFigure gFigure = new GraphicalCompositeFigure();
        gFigure.getLayouter().setInsets(new Insets(15, 15, 5, 15));
        gFigure.setAttribute("FillColor", new Color(0xE8E8E8));
        gFigure.add(figure2);
        gFigure.add(figure);

        int x = this.getPresentationFigure().displayBox().x;
        int y = this.getPresentationFigure().displayBox().y;

        PolyLineFigure poly = new PolyLineFigure();

        poly.addPoint(x + w + 40, y + 12);
        poly.addPoint(x + w + 46, y + 12);
        poly.addPoint(x + w + 46, y + 16);
        poly.addPoint(x + w + 50, y + 16);
        poly.addPoint(x + w + 50, y + 22);
        poly.addPoint(x + w + 40, y + 22);
        poly.addPoint(x + w + 40, y + 12);

        poly.setAttribute("FillColor", new Color(0xE8E8E8));
        poly.setAttribute("FrameColor", Color.BLACK);

        gFigure.add(poly);

        poly = new PolyLineFigure();

        poly.addPoint(x + w + 46, y + 12);
        poly.addPoint(x + w + 50, y + 16);

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
            int xArti = this.displayBox().x;
            int yArti = this.displayBox().y;
            int wArti = this.displayBox().width;
            int hArti = this.displayBox().height;

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
                    if (((xArti > xNode) && (xArti < (xNode + wNode - wArti)) /* BOTTOM */
                            && (yArti < (yNode + hNode - hArti)) && (yArti > yNode))
                            || ((xArti < (xNode + wNode - wArti)) && (xArti > xNode) /* RIGHT */
                                    && (yArti > yNode) && (yArti < (yNode + hNode - hArti)))
                            || ((yArti > yNode) && (yArti < (yNode + hNode - hArti)) /* TOP */
                                    && (xArti > xNode) && (xArti < (xNode + wNode - wArti)))
                            || ((xArti > xNode) && (xArti < (xNode + wNode - wArti)) /* LEFT */
                                    && (yArti > yNode) && (yArti < (yNode + hNode - hArti))))
                    {
                        nodeFig = (NodeFigure) nextFigure;
                        nodeFig.getArtifactFigureList().add(this);
                        ((Node) nodeFig.concept()).getArtifactList().add((Artifact) concept());
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

            int artiX = this.displayBox().x;
            int artiY = this.displayBox().y;
            int artiW = this.displayBox().width;
            int artiH = this.displayBox().height;

            int leftBoundary = x + 10;
            int rightBoundary = x + w - 10 - artiW;
            int topBoundary = y + 5;
            int bottomBoundary = y + h - 10 - artiH;

            int newX = dx;
            int newY = dy;

            // Add restriction inside of the package.
            if (((artiX + dx) < leftBoundary) || ((artiX + dx) > rightBoundary)
                    || ((artiY + dy) < topBoundary) || ((artiY + dy) > bottomBoundary))
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

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.name.artifact"))
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
                    ((Artifact) concept()).getArtifactName().trim()))
                {
                    ((Artifact) concept()).setArtifactName((SingleConnector.manager())
                        .getCreationName());
                    SingleConnector.manager().updateRedrawCode();
                    concept().redraw();
                }
            }
        });

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.type.artifact"))
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
                String type = ((Artifact) concept()).getArtifactType().trim();
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
                    ((Artifact) concept()).setArtifactType("<<" + newType + ">>");

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
