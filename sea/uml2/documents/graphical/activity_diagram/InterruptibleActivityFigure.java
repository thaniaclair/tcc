/*
 * @(#)InterruptibleActivityFigure.java
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
import java.util.Vector;

import ocean.jhotdraw.SpecificationCompositeFigure;
import ocean.smalltalk.OceanVector;
import CH.ifa.draw.standard.BoxHandleKit;
import documents.concepts.activity_diagram.InterruptibleActivity;

public class InterruptibleActivityFigure extends SpecificationCompositeFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -3544665056205986190L;

    /**
     * The dashed round rectangle figure.
     */
    private DashedRoundRectangleFigure dashedRoundRec = new DashedRoundRectangleFigure()
    {

        /**
         * The serial version UID.
         */
        private static final long serialVersionUID = -4772655153401960294L;

        /*
         * (non-Javadoc)
         * 
         * @see CH.ifa.draw.figures.RoundRectangleFigure#displayBox()
         */
        public Rectangle displayBox()
        {
            return new Rectangle(super.getFDisplayBox().x, super.getFDisplayBox().y, super
                .getFDisplayBox().width + 350, super.getFDisplayBox().height);
        }
    };

    /**
     * Constructor.
     */
    public InterruptibleActivityFigure()
    {
        super();
        this.setPresentationFigure(dashedRoundRec);
    }

    /**
     * Overloaded constructor.
     * 
     * @param inter
     */
    public InterruptibleActivityFigure(InterruptibleActivity inter)
    {
        super(inter);
        this.setPresentationFigure(dashedRoundRec);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @Override
    public Class<InterruptibleActivity> relatedConceptClass()
    {
        return InterruptibleActivity.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(InterruptibleActivity.class);
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

        this.getPresentationFigure().setAttribute("FillColor", Color.WHITE);
        this.getPresentationFigure().setAttribute("FrameColor", Color.BLACK);
        dashedRoundRec.setArc(22, 22);

        getLayouter().setInsets(new Insets(20, 17, 350, 25));

        this.setAttribute("FillColor", Color.WHITE);

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
        // FIXME
        Vector handles = new Vector();
        BoxHandleKit.addHandles(this, handles);
        // return dashedRoundRec.handles();

        return handles;
    }

}
