/*
 * @(#)CommentFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Mar 11, 2008        descrição
 */
package documents.graphical.activity_diagram;

import java.awt.*;
import java.awt.event.ActionEvent;

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
import documents.concepts.activity_diagram.Comment;
import documents.graphical.deployment_diagram.ExtendedTextFigure;
import documents.util.I18NProperties;

public class CommentFigure extends SpecificationCompositeFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -1084244837859099881L;

    /**
     * The stereotype of the generic task.
     */
    private static final String TYPE = new String("<<comment>>");

    /**
     * Default constructor.
     */
    public CommentFigure()
    {
        super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @Override
    public Class< ? extends Comment> relatedConceptClass()
    {
        return Comment.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(Comment.class);
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

        Comment comment = (Comment) this.concept();
        if ((comment.name() == null) || ("").equals(comment.name()))
        {
            comment.name("comment");
        }

        // NAME
        String commentName = comment.name();
        Font fontName = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metrics1 = Toolkit.getDefaultToolkit().getFontMetrics(fontName);
        int widthFig1 = metrics1.stringWidth(commentName);

        // TYPE
        Font fontType = new Font("Helvetica", Font.ITALIC, 11);
        FontMetrics metrics2 = Toolkit.getDefaultToolkit().getFontMetrics(fontType);
        int widthFig2 = metrics2.stringWidth(TYPE);

        ExtendedTextFigure figure;
        ExtendedTextFigure figure2;

        if (widthFig1 >= widthFig2)
        {
            // NAME
            figure = new ExtendedTextFigure();
            // TYPE
            figure2 = new ExtendedTextFigure((widthFig1 - widthFig2) / 2);
        }
        else
        {
            // NAME
            figure = new ExtendedTextFigure((widthFig2 - widthFig1) / 2);
            // TYPE
            figure2 = new ExtendedTextFigure();
        }

        // NAME
        figure.setFont(fontName);
        figure.setText(commentName);
        // TYPE
        figure2.setFont(fontType);
        figure2.setText(TYPE);

        GraphicalCompositeFigure gFigure = new GraphicalCompositeFigure()
        {

            /**
             * The generated serial version UID.
             */
            private static final long serialVersionUID = 7916814024119362906L;
            
            /**
             * A rectangle to represents the border of the comment figure.
             */
            RectangleFigure rectangle = new RectangleFigure()
            {

                /**
                 * The serial version UID.
                 */
                private static final long serialVersionUID = 2619213026524648879L;

                /*
                 * (non-Javadoc)
                 * 
                 * @see CH.ifa.draw.figures.RectangleFigure#drawBackground(java.awt.Graphics)
                 */
                public void drawBackground(Graphics g)
                {
                    Rectangle r = displayBox();
                    g.setColor(new Color(0xFFFFE0));
                    g.fillRect(r.x, r.y, r.width, r.height);
                }

                /*
                 * (non-Javadoc)
                 * 
                 * @see CH.ifa.draw.figures.RectangleFigure#drawFrame(java.awt.Graphics)
                 */
                public void drawFrame(Graphics g)
                {
                    // Drawing the rectangle.
                    Rectangle r = displayBox();
                    g.setColor(Color.BLACK);
                    g.drawRect(r.x, r.y, r.width - 1, r.height - 1);
                    // Drawing the polygon.
                    Polygon p = new Polygon();
                    g.setColor(Color.WHITE);
                    p.addPoint(r.x + r.width - 9, r.y);
                    p.addPoint(r.x + r.width, r.y + 9);
                    p.addPoint(r.x + r.width, r.y);
                    p.addPoint(r.x + r.width - 9, r.y);
                    g.drawPolygon(p);
                    g.fillPolygon(p);
                    // Drawing a triangle.
                    g.setColor(Color.BLACK);
                    g.drawLine(r.x + r.width - 10, r.y, r.x + r.width, r.y + 10);
                    g.drawLine(r.x + r.width, r.y + 10, r.x + r.width - 10, r.y + 10);
                    g.drawLine(r.x + r.width - 10, r.y + 10, r.x + r.width - 10, r.y);
                }

            };

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.contrib.GraphicalCompositeFigure#getPresentationFigure()
             */
            public Figure getPresentationFigure()
            {
                return this.rectangle;
            }

        };
        gFigure.setAttribute("FillColor", new Color(0xFFFFE0));
        gFigure.getLayouter().setInsets(new Insets(10, 10, 10, 2));
        gFigure.add(figure2);
        gFigure.add(figure);

        add(gFigure);

        update();
    }

    /**
     * Creates a popup menu to edit the class or object name.
     */
    protected JPopupMenu createPopupMenu()
    {
        JPopupMenu popupMenu = new JPopupMenu();

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.name.comment"))
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
                    ((Comment) concept()).name().trim()))
                {
                    ((Comment) concept()).name((SingleConnector.manager()).getCreationName());
                    SingleConnector.manager().updateRedrawCode();
                    concept().redraw();
                }
            }
        });

        popupMenu.setLightWeightPopupEnabled(true);
        return popupMenu;
    }

}
