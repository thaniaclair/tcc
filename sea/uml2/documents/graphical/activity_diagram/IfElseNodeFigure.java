/*
 * @(#)IfElseNodeFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Mar 13, 2008        descrição
 */
package documents.graphical.activity_diagram;

import java.awt.Point;

import ocean.smalltalk.OceanVector;
import documents.concepts.activity_diagram.*;

public class IfElseNodeFigure extends SequenceNodeFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 8587315660895341048L;

    /**
     * The stereotype of the if node.
     */
    private static final String TYPE_IF = new String("<<IF>>");

    /**
     * The stereotype of the else node.
     */
    private static final String TYPE_ELSE = new String("<<ELSE>>");

    /**
     * The drawing.
     */
    private ActivityDiagramDrawing drawing;

    /**
     * Default constructor.
     */
    public IfElseNodeFigure()
    {
        super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @Override
    public Class< ? extends SequenceNode> relatedConceptClass()
    {
        return IfElseNode.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(IfElseNode.class);
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

        // IF
        super.createNodeFigure(this.createIfConcept());

        int x = super.getPresentationFigure().displayBox().x;
        int y = super.getPresentationFigure().displayBox().y;

        // DECISION 1
        DecisionNode decisionNode1 = new DecisionNode();
        DecisionNodeFigure decisionNodeFigure1 = new DecisionNodeFigure(decisionNode1);
        decisionNodeFigure1.displayBox(new Point(x + 20, y + 245), new Point(x + 70, y + 270));
        drawing.add(decisionNodeFigure1);
        decisionNodeFigure1.redraw();

        // MERGE 1
        MergeNode mergeNode = new MergeNode();
        MergeNodeFigure mergeNodeFigure = new MergeNodeFigure();
        mergeNodeFigure.concept(mergeNode);
        mergeNodeFigure.displayBox(new Point(x + 170, y + 245), new Point(x + 230, y + 270));
        drawing.add(mergeNodeFigure);
        mergeNodeFigure.redraw();

        // ELSE
        IfElseNode ifElse = this.createElseConcept();
        SequenceNodeFigure sequenceFigure = new SequenceNodeFigure();
        sequenceFigure.createNodeFigure(ifElse);
        sequenceFigure.displayBox(new Point(x, y + 330), new Point(x + 70, y + 630));
        drawing.add(sequenceFigure);
        ifElse.redraw();

        // int xDecision1 = decisionNodeFigure1.displayBox().x;
        // int yDecision1 = decisionNodeFigure1.displayBox().y;
        //
        // // CONTROL FLOW - JOIN DECISION 1 AND IF
        // ControlFlow controlFlow1 = new ControlFlow(decisionNode1, (IfElseNode) this.concept());
        // ControlFlowFigure controlFigure1 = new ControlFlowFigure();
        // controlFigure1.setFlowDescription("[cond]");
        // controlFigure1.concept(controlFlow1);
        // controlFigure1.connectStart(decisionNodeFigure1.connectorAt(xDecision1, yDecision1));
        // controlFigure1.connectEnd(this.connectorAt(x, y));
        // controlFigure1.startPoint(decisionNodeFigure1.displayBox().x
        // + decisionNodeFigure1.displayBox().width / 2, decisionNodeFigure1.displayBox().y);
        // controlFigure1.endPoint(x + 20, y + 275);
        // drawing.add(controlFigure1);
        // controlFigure1.redraw();
        //
        // // DECISION 2
        // DecisionNode decisionNode2 = new DecisionNode();
        // DecisionNodeFigure decisionNodeFigure2 = new DecisionNodeFigure(decisionNode2);
        // decisionNodeFigure2.displayBox(new Point(x + 150, y + 275), new Point(x + 200, y + 30));
        // drawing.add(decisionNodeFigure2);
        // decisionNodeFigure2.redraw();
        //
        // int xDecision2 = decisionNodeFigure2.displayBox().x;
        // int yDecision2 = decisionNodeFigure2.displayBox().y;
        //
        // // CONTROL FLOW - JOIN IF AND DECISION 2
        // ControlFlow controlFlow2 = new ControlFlow((IfElseNode) this.concept(), decisionNode2);
        // ControlFlowFigure controlFigure2 = new ControlFlowFigure();
        // controlFigure2.concept(controlFlow2);
        // controlFigure2.connectStart(this.connectorAt(x, y));
        // controlFigure2.connectEnd(decisionNodeFigure2.connectorAt(xDecision2, yDecision2));
        // controlFigure2.startPoint(decisionNodeFigure2.displayBox().x
        // + decisionNodeFigure2.displayBox().width / 2, decisionNodeFigure2.displayBox().y);
        // controlFigure2.endPoint(x + 150, y + 275);
        // drawing.add(controlFigure2);
        // controlFigure2.redraw();
        //
        // // ELSE
        // IfElseNode ifElse = this.createElseConcept();
        // SequenceNodeFigure sequenceFigure = new SequenceNodeFigure();
        // sequenceFigure.createNodeFigure(ifElse);
        // sequenceFigure.displayBox(new Point(x, y + 390), new Point(x + 70, y + 690));
        // drawing.add(sequenceFigure);
        //
        // // CONTROL FLOW - JOIN DECISION 1 AND ELSE
        // ControlFlow controlFlow3 = new ControlFlow(decisionNode1, ifElse);
        // ControlFlowFigure controlFigure3 = new ControlFlowFigure();
        // controlFigure3.setFlowDescription("[NOT cond]");
        // controlFigure3.concept(controlFlow3);
        // controlFigure3.connectStart(decisionNodeFigure1.connectorAt(xDecision1, yDecision1));
        // controlFigure3.connectEnd(sequenceFigure.connectorAt(sequenceFigure.displayBox().x,
        // sequenceFigure.displayBox().y));
        // Rectangle rDec1 = decisionNodeFigure1.displayBox();
        // controlFigure3.startPoint(rDec1.x + rDec1.width / 2, rDec1.y + rDec1.height);
        // controlFigure3.endPoint(sequenceFigure.displayBox().x + 70,
        // sequenceFigure.displayBox().y);
        // drawing.add(controlFigure3);
        // controlFigure3.redraw();
        //
        // // CONTROL FLOW - JOIN ELSE AND DECISION 2
        // ControlFlow controlFlow4 = new ControlFlow(ifElse, decisionNode2);
        // ControlFlowFigure controlFigure4 = new ControlFlowFigure();
        // controlFigure4.concept(controlFlow4);
        // controlFigure4.connectStart(sequenceFigure.connectorAt(sequenceFigure.displayBox().x,
        // sequenceFigure.displayBox().y));
        // controlFigure4.connectEnd(decisionNodeFigure2.connectorAt(xDecision2, yDecision2));
        // Rectangle rDec2 = decisionNodeFigure2.displayBox();
        // controlFigure4.startPoint(sequenceFigure.displayBox().x + 130,
        // sequenceFigure.displayBox().y);
        // controlFigure4.endPoint(rDec2.x + rDec2.width / 2, rDec2.y + rDec2.height);
        // drawing.add(controlFigure4);
        // controlFigure4.redraw();

        update();
    }

    /**
     * Creates the else concept.
     * 
     * @return
     */
    protected IfElseNode createElseConcept()
    {
        IfElseNode ifElseNode = new IfElseNode();
        // NAME
        if (ifElseNode.getNodeName() == null || ("").equals(ifElseNode.getNodeName()))
        {
            ifElseNode.setNodeName("sequence");
        }
        // TYPE
        ifElseNode.setNodeType(TYPE_ELSE);

        return ifElseNode;
    }

    /*
     * (non-Javadoc)
     * 
     * @see documents.graphical.activity_diagram.SequenceNodeFigure#createConcept()
     */
    protected IfElseNode createIfConcept()
    {
        IfElseNode ifElseNode = (IfElseNode) this.concept();
        // NAME
        if (ifElseNode.getNodeName() == null || ("").equals(ifElseNode.getNodeName()))
        {
            ifElseNode.setNodeName("sequence");
        }
        // TYPE
        ifElseNode.setNodeType(TYPE_IF);

        return ifElseNode;
    }

    /**
     * @param drawing the drawing to set
     */
    public void setDrawing(ActivityDiagramDrawing drawing)
    {
        this.drawing = drawing;
    }

}
