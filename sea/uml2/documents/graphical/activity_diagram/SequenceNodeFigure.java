/*
 * @(#)SequenceNodeFigure.java
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
import CH.ifa.draw.framework.Figure;
import CH.ifa.draw.standard.BoxHandleKit;
import documents.concepts.activity_diagram.SequenceNode;
import documents.util.I18NProperties;

public class SequenceNodeFigure extends SpecificationCompositeFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -1797743671904244753L;

    /**
     * The sequence width.
     */
    private int sequenceWidth = 150;

    /**
     * The sequence height.
     */
    private int sequenceHeight = 0;

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
            int h = super.getFDisplayBox().height;
            if (sequenceHeight > 0)
            {
                h = sequenceHeight;
            }
            return new Rectangle(super.getFDisplayBox().x, super.getFDisplayBox().y, super
                .getFDisplayBox().width
                    + sequenceWidth, h);
        }
    };

    /**
     * Constructor.
     */
    public SequenceNodeFigure()
    {
        super();
        this.setPresentationFigure(dashedRoundRec);
    }

    /**
     * Overloaded constructor.
     * 
     * @param sequence
     */
    public SequenceNodeFigure(SequenceNode sequence)
    {
        super(sequence);
        this.setPresentationFigure(dashedRoundRec);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @Override
    public Class< ? extends SequenceNode> relatedConceptClass()
    {
        return SequenceNode.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(SequenceNode.class);
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

        this.createNodeFigure(this.createConcept());

        update();
    }

    /**
     * Creates a sequence concept instance.
     * 
     * @return
     */
    protected SequenceNode createConcept()
    {
        SequenceNode sequence = (SequenceNode) this.concept();

        // NAME
        if (sequence.getNodeName() == null || ("").equals(sequence.getNodeName()))
        {
            sequence.setNodeName("sequence");
        }

        // TYPE
        if (sequence.getNodeType() == null || ("").equals(sequence.getNodeType()))
        {
            sequence.setNodeType("<<structured>>");
        }

        return sequence;
    }

    /**
     * Creates the loop node figure.
     */
    @SuppressWarnings("deprecation")
    protected void createNodeFigure(SequenceNode sequence)
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
        nodeType.setText(sequence.getNodeType());
        nodeType.setAttribute(fillColor, whiteColor);
        nodeType.setAttribute(frameColor, whiteColor);

        // NAME
        Font fontName = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metrics2 = Toolkit.getDefaultToolkit().getFontMetrics(fontType);
        int w = metrics2.stringWidth(sequence.getNodeType());

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
        nodeName.setText(sequence.getNodeName());
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

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.name.sequence.node"))
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
                    ((SequenceNode) concept()).getNodeName().trim()))
                {
                    ((SequenceNode) concept()).setNodeName((SingleConnector.manager())
                        .getCreationName());
                    SingleConnector.manager().updateRedrawCode();
                    concept().redraw();
                }
            }
        });

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.type.sequence.node"))
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
                String type = ((SequenceNode) concept()).getNodeType().trim();
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
                    ((SequenceNode) concept()).setNodeType("<<" + newType + ">>");
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

    /**
     * @return the sequenceWidth
     */
    public int getSequenceWidth()
    {
        return sequenceWidth;
    }

    /**
     * @param sequenceWidth the sequenceWidth to set
     */
    public void setSequenceWidth(int sequenceWidth)
    {
        this.sequenceWidth = sequenceWidth;
    }

    /**
     * @return the sequenceHeight
     */
    public int getSequenceHeight()
    {
        return sequenceHeight;
    }

    /**
     * @param sequenceHeight the sequenceHeight to set
     */
    public void setSequenceHeight(int sequenceHeight)
    {
        this.sequenceHeight = sequenceHeight;
    }

}
