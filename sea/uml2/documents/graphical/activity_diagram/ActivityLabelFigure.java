/*
 * @(#)ActivityLabelFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Mar 12, 2008        descrição
 */
package documents.graphical.activity_diagram;

import java.awt.Color;
import java.awt.Font;

import CH.ifa.draw.contrib.PolygonFigure;
import documents.concepts.communication_diagram.Label;
import documents.graphical.communication_diagram.LabelFigure;
import documents.util.I18NProperties;

public class ActivityLabelFigure extends LabelFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 2443960213328196136L;

    /**
     * The label type.
     */
    private static final String LABEL_TYPE = new String("act");

    /**
     * Constructor.
     */
    public ActivityLabelFigure()
    {
        super();
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

        Label label = (Label) this.concept();
        if (label.name() == null || ("").equals(label.name()))
        {
            label.name(I18NProperties.getString("activity.concept.name"));
        }

        figure.setFont(new Font("Helvetica", Font.BOLD, 14));
        figure.setText(LABEL_TYPE + " " + label.name());
        figure.setAttribute("TextColor", Color.BLACK);

        int w = figure.textDisplayBox().width;
        int h = figure.textDisplayBox().height;

        PolygonFigure poly = new PolygonFigure()
        {

            /**
             * The serial version UID.
             */
            private static final long serialVersionUID = 7132902592267776994L;

            /*
             * (non-Javadoc)
             * 
             * @see CH.ifa.draw.standard.AbstractFigure#moveBy(int, int)
             */
            public void moveBy(int x, int y)
            {
                // Empty.
            }
        };
        poly.addPoint(0, 0);
        poly.addPoint(w + 20, 0);
        poly.addPoint(w + 19, 2);
        poly.addPoint(w + 18, 4);
        poly.addPoint(w + 17, 6);
        poly.addPoint(w + 16, 8);
        poly.addPoint(w + 12, 12);
        poly.addPoint(w + 8, 16);
        poly.addPoint(w + 7, 16);
        poly.addPoint(w + 6, 17);
        poly.addPoint(w, h);
        poly.addPoint(0, h);
        poly.addPoint(0, 0);
        poly.setAttribute("FillColor", new Color(0xFFFFE0));

        add(poly);
        add(figure);

        update();

    }

}
