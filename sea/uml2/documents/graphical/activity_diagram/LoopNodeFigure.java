/*
 * @(#)LoopNodeFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Mar 4, 2008        descrição
 */
package documents.graphical.activity_diagram;

import java.awt.Color;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.JPopupMenu;

import ocean.accessories.SingleConnector;
import ocean.framework.Concept;
import ocean.smalltalk.Constantes;
import ocean.smalltalk.OceanVector;
import CH.ifa.draw.contrib.GraphicalCompositeFigure;
import CH.ifa.draw.framework.Figure;
import CH.ifa.draw.standard.BoxHandleKit;
import documents.concepts.activity_diagram.LoopNode;
import documents.concepts.activity_diagram.SequenceNode;
import documents.util.I18NProperties;

public class LoopNodeFigure extends SequenceNodeFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -2584493642536279338L;

    /**
     * String to represent the setup stereotype.
     */
    private static final String SETUP = new String("<<setup>>");

    /**
     * String to represent the test stereotype.
     */
    private static final String TEST = new String("<<test>>");

    /**
     * String to represent the body stereotype.
     */
    private static final String BODY = new String("<<body>>");

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
                .getFDisplayBox().width + 160, super.getFDisplayBox().height);
        }
    };

    /**
     * Constructor.
     */
    public LoopNodeFigure()
    {
        super();
        this.setPresentationFigure(dashedRoundRec);
    }

    /**
     * Overloaded constructor.
     * 
     * @param loop
     */
    public LoopNodeFigure(LoopNode loop)
    {
        super(loop);
        this.setPresentationFigure(dashedRoundRec);
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @Override
    public Class< ? extends LoopNode> relatedConceptClass()
    {
        return LoopNode.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(LoopNode.class);
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
    protected LoopNode createConcept()
    {
        LoopNode loop = (LoopNode) this.concept();
        // NAME
        if (loop.getNodeName() == null || ("").equals(loop.getNodeName()))
        {
            loop.setNodeName("loop");
        }
        // TYPE
        if (loop.getNodeType() == null || ("").equals(loop.getNodeType()))
        {
            loop.setNodeType("<<structured>>");
        }
        return loop;
    }

    /*
     * (non-Javadoc)
     * 
     * @see documents.graphical.activity_diagram.SequenceNodeFigure#createNodeFigure(documents.concepts.activity_diagram.SequenceNode)
     */
    @SuppressWarnings("deprecation")
    protected void createNodeFigure(LoopNode loop)
    {
        dashedRoundRec.setArc(22, 22);
        super.createNodeFigure(loop);

        // SETUP
        SequenceNode setup = new SequenceNode();
        setup.setNodeName("");
        setup.setNodeType(SETUP);

        SequenceNodeFigure setupFigure = new SequenceNodeFigure(setup);
        setupFigure.setSequenceWidth(125);
        setupFigure.setSequenceHeight(140);
        setupFigure.createNodeFigure(setup);
        add(setupFigure);

        GraphicalCompositeFigure rec1 = new GraphicalCompositeFigure();
        rec1.getLayouter().setInsets(new Insets(10, 5, 5, 5));
        rec1.setAttribute("FillColor", Color.WHITE);
        rec1.setAttribute("FrameColor", Color.WHITE);
        add(rec1);

        // TEST
        SequenceNode test = new SequenceNode();
        test.setNodeName("");
        test.setNodeType(TEST);

        SequenceNodeFigure testFigure = new SequenceNodeFigure(test);
        testFigure.setSequenceWidth(125);
        testFigure.setSequenceHeight(140);
        testFigure.createNodeFigure(test);
        add(testFigure);

        GraphicalCompositeFigure rec2 = new GraphicalCompositeFigure();
        rec2.getLayouter().setInsets(new Insets(10, 5, 5, 5));
        rec2.setAttribute("FillColor", Color.WHITE);
        rec2.setAttribute("FrameColor", Color.WHITE);
        add(rec2);

        // BODY
        SequenceNode body = new SequenceNode();
        body.setNodeName("");
        body.setNodeType(BODY);

        SequenceNodeFigure bodyFigure = new SequenceNodeFigure(body);
        bodyFigure.setSequenceWidth(125);
        bodyFigure.setSequenceHeight(140);
        bodyFigure.createNodeFigure(body);
        add(bodyFigure);

        getLayouter().setInsets(new Insets(15, 18, 15, 50));
    }

    /**
     * Creates a popup menu to edit the class or object name.
     */
    protected JPopupMenu createPopupMenu()
    {
        JPopupMenu popupMenu = new JPopupMenu();

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.name.loop.node"))
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
                    ((LoopNode) concept()).getNodeName().trim()))
                {
                    ((LoopNode) concept()).setNodeName((SingleConnector.manager())
                        .getCreationName());
                    SingleConnector.manager().updateRedrawCode();
                    concept().redraw();
                }
            }
        });

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.type.loop.node"))
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
                String type = ((LoopNode) concept()).getNodeType().trim();
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
                    ((LoopNode) concept()).setNodeType("<<" + newType + ">>");
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
