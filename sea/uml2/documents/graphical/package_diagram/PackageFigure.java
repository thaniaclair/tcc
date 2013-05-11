/*
 * @(#)PackageFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Jan 5, 2008        descrição
 */
package documents.graphical.package_diagram;

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
import CH.ifa.draw.figures.RectangleFigure;
import CH.ifa.draw.framework.DrawingView;
import CH.ifa.draw.framework.Figure;
import CH.ifa.draw.standard.BoxHandleKit;
import CH.ifa.draw.standard.LocatorHandle;
import CH.ifa.draw.standard.RelativeLocator;
import documents.concepts.package_diagram.Package;
import documents.graphical.composite_structure_diagram.ExtendedClassFigure;
import documents.graphical.deployment_diagram.ExtendedTextFigure;
import documents.util.I18NProperties;

public class PackageFigure extends SpecificationCompositeFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -6483960502988299359L;

    /**
     * A list of class figures.
     */
    private List<ExtendedClassFigure> classFigureList = new LinkedList<ExtendedClassFigure>();

    /**
     * The inner composite figure.
     */
    private GraphicalCompositeFigure innerCompositeFigure = new GraphicalCompositeFigure();

    /**
     * The empty fill rectangle.
     */
    private RectangleFigure emptyFillRectangle = new RectangleFigure()
    {

        /**
         * The generated serial version UID.
         */
        private static final long serialVersionUID = -2182702704328653913L;

        /*
         * (non-Javadoc)
         * 
         * @see CH.ifa.draw.figures.RectangleFigure#drawBackground(java.awt.Graphics)
         */
        public void drawBackground(Graphics g)
        {
            // EMPTY.
        }

        /*
         * (non-Javadoc)
         * 
         * @see CH.ifa.draw.figures.RectangleFigure#drawFrame(java.awt.Graphics)
         */
        public void drawFrame(Graphics g)
        {
            // EMPTY.
        }
    };

    /**
     * Default constructor.
     */
    public PackageFigure()
    {
        super();
        this.setPresentationFigure(emptyFillRectangle);
    }

    /**
     * Overloaded constructor.
     * 
     * @param object
     */
    public PackageFigure(documents.concepts.package_diagram.Package object)
    {
        super(object);
        this.setPresentationFigure(emptyFillRectangle);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @Override
    public Class<Package> relatedConceptClass()
    {
        return Package.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(Package.class);
        return auxList;
    }

    /*
     * e (non-Javadoc)
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
    public void redraw()
    {

        removeAll();

        String fillColor = new String("FillColor");
        String frameColor = new String("FrameColor");
        Color grayColor = new Color(0xE8E8E8);

        Package packageInstance = (Package) this.concept();

        this.setAttribute(fillColor, new Color(0xFFFFFF));
        this.setAttribute(frameColor, new Color(0xFFFFFF));

        final int width = 50;
        final int height = 20;

        ExtendedTextFigure textFigure = new ExtendedTextFigure()
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
                int y = getPresentationFigure().displayBox().y + height + 15;
                int x = getPresentationFigure().displayBox().x;
                int width = getPresentationFigure().displayBox().width;
                FontMetrics metrics = g.getFontMetrics(getFFont());
                int myWidth = metrics.stringWidth(getFText());
                Rectangle r = displayBox();
                g.fillRect((x + (width / 2) - (myWidth / 2)), y, r.width, r.height);
            }

            /*
             * (non-Javadoc)
             * 
             * @see documents.graphical.deployment_diagram.ExtendedTextFigure#drawFrame(java.awt.Graphics)
             */
            public void drawFrame(Graphics g)
            {
                int y = getPresentationFigure().displayBox().y + height + 15;
                int x = getPresentationFigure().displayBox().x;
                int width = getPresentationFigure().displayBox().width;
                g.setFont(getFFont());
                g.setColor((Color) getAttribute("TextColor"));
                FontMetrics metrics = g.getFontMetrics(getFFont());
                int myWidth = metrics.stringWidth(getFText());
                g
                    .drawString(getFText(), (x + (width / 2) - (myWidth / 2)), y
                            + metrics.getAscent());
            }
        };
        textFigure.setFont(new Font("Helvetica", Font.BOLD, 14));
        textFigure.setText(packageInstance.getPackageName());
        textFigure.setAttribute(fillColor, grayColor);

        RectangleFigure rect = new RectangleFigure()
        {

            /**
             * The generated serial version UID.
             */
            private static final long serialVersionUID = 2053974290553913103L;

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.figures.RectangleFigure#drawBackground(java.awt.Graphics)
             */
            public void drawBackground(Graphics g)
            {
                Rectangle r = displayBox();
                g.fillRect(r.x, r.y, width, height);
            }

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.figures.RectangleFigure#drawFrame(java.awt.Graphics)
             */
            public void drawFrame(Graphics g)
            {
                Rectangle r = displayBox();
                g.drawRect(r.x, r.y, width - 1, height - 1);
            }

        };
        rect.displayBox(new Rectangle(width - 1, height - 1));
        rect.setAttribute(fillColor, grayColor);
        add(rect);

        innerCompositeFigure.getLayouter().setInsets(new Insets(30, 38, 30, 0));
        innerCompositeFigure.setAttribute(fillColor, grayColor);
        innerCompositeFigure.add(textFigure);
        add(innerCompositeFigure);

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

        for (ExtendedClassFigure classFig : classFigureList)
        {
            classFig.moveBy(x, y);
        }
    }

    /**
     * Creates a popup menu to edit the class or object name.
     */
    protected JPopupMenu createPopupMenu()
    {
        JPopupMenu popupMenu = new JPopupMenu();

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.name.package"))
        {

            /**
             * The serial version UID.
             */
            private static final long serialVersionUID = 131777655629571396L;

            /*
             * (non-Javadoc)
             * 
             * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
             */
            public void actionPerformed(ActionEvent event)
            {
                if (SingleConnector.managerView().openDialogInterface(Constantes.NAME_SPEC,
                    ((Package) concept()).getPackageName()))
                {
                    Package pack = ((Package) concept());
                    pack.setPackageName((SingleConnector.manager())
                        .getCreationName());
                    SingleConnector.manager().updateRedrawCode();
                    pack.redraw();
                }
            }
        });

        popupMenu.setLightWeightPopupEnabled(true);
        return popupMenu;
    }

    /**
     * @return the classFigureList
     */
    public List<ExtendedClassFigure> getClassFigureList()
    {
        return classFigureList;
    }

    /**
     * @param classFigureList the classFigureList to set
     */
    public void setClassFigureList(List<ExtendedClassFigure> classFigureList)
    {
        this.classFigureList = classFigureList;
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
        handles.addElement(BoxHandleKit.east(this));
        handles.addElement(BoxHandleKit.west(this));
        handles.addElement(BoxHandleKit.north(this));
        BoxHandleKit.addCornerHandles(this, handles);
        // SOUTH
        handles.addElement(new LocatorHandle(this, new RelativeLocator(0.5, 1.0))
        {

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.AbstractHandle#invokeStep(int, int, int, int,
             *      CH.ifa.draw.framework.DrawingView)
             */
            public void invokeStep(int x, int y, int anchorX, int anchorY, DrawingView view)
            {
                if (y > anchorY)
                {
                    Rectangle outerRect = PackageFigure.this.displayBox();
                    Rectangle innerRect = PackageFigure.this.innerCompositeFigure.displayBox();
                    PackageFigure.this.displayBox(new Point(outerRect.x, outerRect.y), new Point(
                            outerRect.x + outerRect.width, Math.max(outerRect.y, anchorY)));
                    PackageFigure.this.innerCompositeFigure.displayBox(new Point(innerRect.x,
                            innerRect.y), new Point(innerRect.x + innerRect.width, Math.max(
                        innerRect.y, anchorY)));
                    PackageFigure.this.redraw();
                }
            }

        });
        return handles;
    }
}
