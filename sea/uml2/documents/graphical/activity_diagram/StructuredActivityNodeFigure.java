/*
 * @(#)StructuredActivityNode.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Mar 4, 2008        descrição
 */
package documents.graphical.activity_diagram;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.JPopupMenu;

import ocean.accessories.SingleConnector;
import ocean.jhotdraw.SpecificationCompositeFigure;
import ocean.smalltalk.Constantes;
import ocean.smalltalk.OceanVector;
import CH.ifa.draw.standard.BoxHandleKit;
import documents.concepts.activity_diagram.StructuredActivityNode;
import documents.util.I18NProperties;

public class StructuredActivityNodeFigure extends SpecificationCompositeFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 6384746097373403641L;

    /**
     * The dashed round rectangle figure.
     */
    private DashedRoundRectangleFigure dashedRoundRec = new DashedRoundRectangleFigure()
    {

        /**
         * The serial version UID.
         */
        private static final long serialVersionUID = -5836607882244376142L;

        /*
         * (non-Javadoc)
         * 
         * @see CH.ifa.draw.figures.RoundRectangleFigure#displayBox()
         */
        public Rectangle displayBox()
        {
            return new Rectangle(super.getFDisplayBox().x, super.getFDisplayBox().y, super
                .getFDisplayBox().width + 150, super.getFDisplayBox().height);
        }
    };

    /**
     * Constructor.
     */
    public StructuredActivityNodeFigure()
    {
        super();
        this.setPresentationFigure(dashedRoundRec);
    }

    /**
     * Overloaded constructor.
     * 
     * @param struct
     */
    public StructuredActivityNodeFigure(StructuredActivityNode struct)
    {
        super(struct);
        this.setPresentationFigure(dashedRoundRec);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @Override
    public Class<StructuredActivityNode> relatedConceptClass()
    {
        return StructuredActivityNode.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(StructuredActivityNode.class);
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

        this.createStructuredActivityNodeFigure(this.createStructuredConcept());

        update();
    }

    /**
     * Creates a sequence concept instance.
     * 
     * @return
     */
    protected StructuredActivityNode createStructuredConcept()
    {
        StructuredActivityNode activity = (StructuredActivityNode) this.concept();

        // NAME
        if (activity.getStructuredName() == null || ("").equals(activity.getStructuredName()))
        {
            activity.setStructuredName("sequence");
        }

        // TYPE
        if (activity.getStructuredType() == null || ("").equals(activity.getStructuredType()))
        {
            activity.setStructuredType("<<structured>>");
        }

        return activity;
    }

    /**
     * Creates the loop node figure.
     */
    @SuppressWarnings("deprecation")
    protected void createStructuredActivityNodeFigure(StructuredActivityNode activity)
    {
        // COLOR
        Color whiteColor = Color.WHITE;
        String fillColor = new String("FillColor");
        String frameColor = new String("FrameColor");

        this.getPresentationFigure().setAttribute(fillColor, whiteColor);
        this.getPresentationFigure().setAttribute(frameColor, Color.BLACK);
        dashedRoundRec.setArc(22, 22);

        // TYPE
        Font fontType = new Font("Helvetica", Font.ITALIC, 11);
        ExtendedNodeFigure nodeType = new ExtendedNodeFigure(0);
        nodeType.setFont(fontType);
        nodeType.setText(activity.getStructuredType());
        nodeType.setAttribute(fillColor, whiteColor);
        nodeType.setAttribute(frameColor, whiteColor);

        // NAME
        Font fontName = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metrics2 = Toolkit.getDefaultToolkit().getFontMetrics(fontType);
        int w = metrics2.stringWidth(activity.getStructuredType());

        final int width;

        if (w <= 0)
        {
            width = 75;
        }
        else
        {
            width = w + 5;
        }

        ExtendedNodeFigure nodeName = new ExtendedNodeFigure(0)
        {

            /**
             * The generated serial version UID.
             */
            private static final long serialVersionUID = -8027784492684288467L;

            /**
             * Y space.
             */
            private static final int Y_SPACE = 16;

            /*
             * (non-Javadoc)
             * 
             * @see documents.graphical.activity_diagram.ExtendedNodeFigure#drawBorder(java.awt.Graphics)
             */
            public void drawBorder(Graphics g)
            {
                Rectangle r = displayBox();
                g.setColor(getFrameColor());
                g.drawRect(r.x + width, r.y - Y_SPACE, r.width - 1, r.height - 1);
            }

            /*
             * (non-Javadoc)
             * 
             * @see documents.graphical.deployment_diagram.ExtendedTextFigure#drawBackground(java.awt.Graphics)
             */
            public void drawBackground(Graphics g)
            {
                Rectangle r = displayBox();
                g.fillRect(r.x + width, r.y - Y_SPACE, r.width, r.height);
            }

            /*
             * (non-Javadoc)
             * 
             * @see documents.graphical.deployment_diagram.ExtendedTextFigure#drawFrame(java.awt.Graphics)
             */
            public void drawFrame(Graphics g)
            {
                g.setFont(getFFont());
                g.setColor((Color) getAttribute("TextColor"));
                FontMetrics metrics = g.getFontMetrics(getFFont());
                g.drawString(getFText(), getFOriginX() + width, getFOriginY() - Y_SPACE
                        + metrics.getAscent());
            }
        };
        nodeName.setFont(fontName);
        nodeName.setText(activity.getStructuredName());
        nodeName.setAttribute(fillColor, whiteColor);
        nodeName.setAttribute(frameColor, whiteColor);

        getLayouter().setInsets(new Insets(10, 10, 150, 50));

        add(nodeType);
        add(nodeName);

    }

    /**
     * Creates a popup menu to edit the class or object name.
     */
    protected JPopupMenu createPopupMenu()
    {
        JPopupMenu popupMenu = new JPopupMenu();

        popupMenu.add(new AbstractAction(I18NProperties
            .getString("change.name.structured.activity"))
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
                    ((StructuredActivityNode) concept()).getStructuredName().trim()))
                {
                    ((StructuredActivityNode) concept()).setStructuredName((SingleConnector
                        .manager()).getCreationName());
                    SingleConnector.manager().updateRedrawCode();
                    concept().redraw();
                }
            }
        });

        popupMenu.add(new AbstractAction(I18NProperties
            .getString("change.type.structured.activity"))
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
                String type = ((StructuredActivityNode) concept()).getStructuredType().trim();
                if (type.startsWith("<<") && type.endsWith(">>"))
                {
                    type = type.substring(2, type.length() - 2);
                }

                if (SingleConnector.managerView().openDialogInterface(Constantes.NAME_SPEC, type))
                {
                    String newType = (SingleConnector.manager()).getCreationName();
                    if ((newType == null) || ("").equals(newType) || (" ").equals(newType))
                    {
                        newType = new String("structured");
                    }
                    ((StructuredActivityNode) concept()).setStructuredType("<<" + newType + ">>");
                    SingleConnector.manager().updateRedrawCode();
                    concept().redraw();
                }
            }
        });

        popupMenu.setLightWeightPopupEnabled(true);
        return popupMenu;
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
        BoxHandleKit.addHandles(this, handles);
        return handles;
    }

}
