/*
 * @(#)IfNodeFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Mar 13, 2008        descrição
 */
package documents.graphical.activity_diagram;

import java.awt.Point;
import java.awt.Rectangle;

import ocean.smalltalk.OceanVector;
import documents.concepts.activity_diagram.*;

public class IfNodeFigure extends SequenceNodeFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 8587315660895341048L;

    /**
     * The stereotype of the if node.
     */
    private static final String TYPE = new String("<<IF>>");

    /**
     * The drawing.
     */
    private ActivityDiagramDrawing drawing;

    /**
     * Default constructor.
     */
    public IfNodeFigure()
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
        return IfNode.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(IfNode.class);
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

        super.createNodeFigure(this.createConcept());
        
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

        // int xDecision1 = decisionNodeFigure1.displayBox().x;
        // int yDecision1 = decisionNodeFigure1.displayBox().y;
        //
        // // CONTROL FLOW - JOIN DECISION 1 AND IF
        // ControlFlow controlFlow1 = new ControlFlow(decisionNode1, (IfNode) this.concept());
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
        // ControlFlow controlFlow2 = new ControlFlow((IfNode) this.concept(), decisionNode2);
        // ControlFlowFigure controlFigure2 = new ControlFlowFigure();
        // controlFigure2.setFlowDescription("[NOT cond]");
        // controlFigure2.concept(controlFlow2);
        // controlFigure2.connectStart(this.connectorAt(x, y));
        // controlFigure2.connectEnd(decisionNodeFigure2.connectorAt(xDecision2, yDecision2));
        // controlFigure2.startPoint(decisionNodeFigure2.displayBox().x
        // + decisionNodeFigure2.displayBox().width / 2, decisionNodeFigure2.displayBox().y);
        // controlFigure2.endPoint(x + 150, y + 275);
        // drawing.add(controlFigure2);
        // controlFigure2.redraw();
        //
        // // CONTROL FLOW - JOIN DECISION 1 AND DECISION 2
        // ControlFlow controlFlow3 = new ControlFlow(decisionNode1, decisionNode2);
        // ControlFlowFigure controlFigure3 = new ControlFlowFigure();
        // controlFigure3.concept(controlFlow3);
        // controlFigure3.connectStart(decisionNodeFigure1.connectorAt(xDecision1, yDecision1));
        // controlFigure3.connectEnd(decisionNodeFigure2.connectorAt(xDecision2, yDecision2));
        //        Rectangle r1 = decisionNodeFigure1.displayBox();
        //        controlFigure3.startPoint(r1.x + r1.width, r1.y + (r1.height / 2));
        //        Rectangle r2 = decisionNodeFigure2.displayBox();
        //        controlFigure3.endPoint(r2.x, r2.y + (r2.height / 2));
        //        drawing.add(controlFigure3);
        //        controlFigure3.redraw();

        update();
    }

    /*
     * (non-Javadoc)
     * 
     * @see documents.graphical.activity_diagram.SequenceNodeFigure#createConcept()
     */
    protected IfNode createConcept()
    {

        IfNode ifNode = (IfNode) this.concept();
        // NAME
        if (ifNode.getNodeName() == null || ("").equals(ifNode.getNodeName()))
        {
            ifNode.setNodeName("sequence");
        }
        // TYPE
        ifNode.setNodeType(TYPE);

        return ifNode;
    }

    /**
     * @param drawing the drawing to set
     */
    public void setDrawing(ActivityDiagramDrawing drawing)
    {
        this.drawing = drawing;
    }

}
