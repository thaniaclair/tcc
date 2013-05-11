/*
 * @(#)ConditionalNodeFigure.java
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
import ocean.smalltalk.Constantes;
import ocean.smalltalk.OceanVector;
import CH.ifa.draw.contrib.GraphicalCompositeFigure;
import CH.ifa.draw.figures.RectangleFigure;
import CH.ifa.draw.framework.Figure;
import CH.ifa.draw.standard.BoxHandleKit;
import documents.concepts.activity_diagram.ConditionalNode;
import documents.concepts.activity_diagram.SequenceNode;
import documents.util.I18NProperties;

public class ConditionalNodeFigure extends SequenceNodeFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 7594241583829477369L;

    /**
     * String to represent the test stereotype.
     */
    private static final String TEST = new String("<<test>>");

    /**
     * String to represent the body stereotype.
     */
    private static final String BODY = new String("<<body>>");

    /**
     * String to represent the structured stereotype.
     */
    private static final String STRUCTURED = new String("<<structured>>");

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
                .getFDisplayBox().width + 35, super.getFDisplayBox().height);
        }
    };

    /**
     * The total of conditional cases.
     */
    private int casesTotal = 3;

    /**
     * Constructor.
     */
    public ConditionalNodeFigure()
    {
        super();
        this.setPresentationFigure(dashedRoundRec);
    }

    /**
     * Overloaded constructor.
     * 
     * @param conditional
     */
    public ConditionalNodeFigure(ConditionalNode conditional)
    {
        super(conditional);
        this.setPresentationFigure(dashedRoundRec);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @Override
    public Class< ? extends ConditionalNode> relatedConceptClass()
    {
        return ConditionalNode.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(ConditionalNode.class);
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
    public void redraw()
    {

        removeAll();

        this.createNodeFigure(this.createConcept());

        update();
    }

    /*
     * (non-Javadoc)
     * 
     * @see documents.graphical.activity_diagram.SequenceNodeFigure#createConcept()
     */
    protected ConditionalNode createConcept()
    {
        ConditionalNode conditional = (ConditionalNode) this.concept();

        // NAME
        if (conditional.getNodeName() == null || ("").equals(conditional.getNodeName()))
        {
            conditional.setNodeName("conditional");
        }
        // TYPE
        if (conditional.getNodeType() == null || ("").equals(conditional.getNodeType()))
        {
            conditional.setNodeType(STRUCTURED);
        }
        return conditional;

    }

    /**
     * Creates the loop node figure.
     */
    @SuppressWarnings("deprecation")
    protected void createNodeFigure(ConditionalNode conditional)
    {

        // Creates the external figure.
        dashedRoundRec.setArc(22, 22);
        super.createNodeFigure(conditional);

        // CONTAINER
        GraphicalCompositeFigure gc = new GraphicalCompositeFigure();
        gc.getLayouter().setInsets(new Insets(0, 0, 0, 0));
        gc.setAttribute("FillColor", Color.WHITE);
        gc.setAttribute("FrameColor", Color.WHITE);

        // Creates three cases.
        for (int i = 0; i < casesTotal; i++)
        {

            // TEST
            SequenceNode test = new SequenceNode();
            test.setNodeName("");
            test.setNodeType(TEST);

            SequenceNodeFigure testFigure = new SequenceNodeFigure(test);
            testFigure.setSequenceHeight(140);
            testFigure.setSequenceWidth(0);
            testFigure.displayBox(new Rectangle(300, 0));
            testFigure.createNodeFigure(test);

            // BODY
            SequenceNode body = new SequenceNode();
            body.setNodeName("");
            body.setNodeType(BODY);

            SequenceNodeFigure bodyFigure = new SequenceNodeFigure(body);
            bodyFigure.setSequenceHeight(140);
            bodyFigure.setSequenceWidth(0);
            bodyFigure.displayBox(new Rectangle(300, 0));
            bodyFigure.createNodeFigure(body);

            // VERTICAL SPACE RECTANGLE
            RectangleFigure spaceRec = new RectangleFigure();
            spaceRec.displayBox(new Rectangle(18, 30));
            spaceRec.setAttribute("FillColor", Color.WHITE);
            spaceRec.setAttribute("FrameColor", Color.WHITE);

            // Composite that composites the test and body figure.
            GraphicalCompositeFigure gc1 = new GraphicalCompositeFigure();
            HorizontalLayouter horizontal = new HorizontalLayouter();
            horizontal.setInsets(new Insets(0, 0, 18, 0));
            horizontal.setLayoutable(gc1);
            gc1.setLayouter(horizontal);
            gc1.setAttribute("FillColor", Color.WHITE);
            gc1.setAttribute("FrameColor", Color.WHITE);
            gc1.add(testFigure);
            gc1.add(spaceRec);
            gc1.add(bodyFigure);

            gc.add(gc1);
        }

        add(gc);

        super.getLayouter().setInsets(new Insets(15, 18, 2, 0));
    }

    /**
     * Creates a popup menu to edit the class or object name.
     */
    protected JPopupMenu createPopupMenu()
    {
        JPopupMenu popupMenu = new JPopupMenu();

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.name.conditional.node"))
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
                    ((ConditionalNode) concept()).getNodeName().trim()))
                {
                    ((ConditionalNode) concept()).setNodeName((SingleConnector.manager())
                        .getCreationName());
                    SingleConnector.manager().updateRedrawCode();
                    concept().redraw();
                }
            }
        });

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.type.conditional.node"))
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
                String type = ((ConditionalNode) concept()).getNodeType().trim();
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
                    ((ConditionalNode) concept()).setNodeType("<<" + newType + ">>");
                    SingleConnector.manager().updateRedrawCode();
                    concept().redraw();
                }
            }
        });

        popupMenu.add(new AbstractAction(I18NProperties.getString("add.new.case"))
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
                casesTotal++;
                SingleConnector.manager().updateRedrawCode();
                concept().redraw();
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
