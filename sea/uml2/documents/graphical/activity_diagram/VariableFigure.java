/*
 * @(#)VariableFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Mar 11, 2008        descrição
 */
package documents.graphical.activity_diagram;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import ocean.accessories.SingleConnector;
import ocean.smalltalk.OceanVector;
import CH.ifa.draw.contrib.GraphicalCompositeFigure;
import CH.ifa.draw.figures.RectangleFigure;
import CH.ifa.draw.figures.TextFigure;
import CH.ifa.draw.framework.Figure;
import documents.concepts.activity_diagram.Comment;
import documents.concepts.activity_diagram.Variable;
import documents.graphical.deployment_diagram.ExtendedTextFigure;
import documents.util.I18NProperties;

public class VariableFigure extends CommentFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -2316524774885003463L;

    /**
     * The stereotype of the generic task.
     */
    private static final String TYPE = new String("<<var>>");

    /**
     * The popup keys.
     */
    private List<String> popupKeys = new LinkedList<String>();

    /**
     * Constructor.
     */
    public VariableFigure()
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
        return Variable.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(Variable.class);
        return auxList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#initialize()
     */
    public void initialize()
    {
        if (this.popupKeys == null)
        {
            this.popupKeys = new LinkedList<String>();
        }

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

        // FONTS
        Font fontType = new Font("Helvetica", Font.ITALIC, 11);
        Font fontVar = new Font("Helvetica", Font.BOLD, 14);

        // Rectangle border.
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

        // VARIABLES
        Variable variable = (Variable) this.concept();
        java.util.List<String> list = variable.getVariablesList();
        List<TextFigure> variables = new LinkedList<TextFigure>();
        List<Integer> textWidth = new LinkedList<Integer>();

        // The max text width.
        int max = 0;

        // Just if we have items.
        if (list != null && !list.isEmpty())
        {

            for (String var : list)
            {
                TextFigure newVariable = new TextFigure();
                newVariable.setFont(fontVar);
                newVariable.setText(var);
                variables.add(newVariable);

                FontMetrics metrics = Toolkit.getDefaultToolkit().getFontMetrics(fontVar);
                textWidth.add(metrics.stringWidth(var));
            }

            Collections.sort(textWidth);
            FontMetrics metrics = Toolkit.getDefaultToolkit().getFontMetrics(fontType);
            int widthType = metrics.stringWidth(TYPE);
            int widthMaxVar = textWidth.get(textWidth.size() - 1);
            if (widthMaxVar > widthType)
            {
                max = (widthMaxVar - widthType) / 2;
            }
        }

        // TYPE
        ExtendedTextFigure text = new ExtendedTextFigure(max);
        text.setFont(fontType);
        text.setText(TYPE);
        gFigure.add(text);

        for (TextFigure figure : variables)
        {
            gFigure.add(figure);
        }

        add(gFigure);

        update();
    }

    /**
     * Creates a popup menu to edit the class or object name.
     */
    protected JPopupMenu createPopupMenu()
    {
        final JPopupMenu popupMenu = new JPopupMenu();

        String key = I18NProperties.getString("add.new.variable.declaration");
        this.popupKeys.add(key);

        popupMenu.add(new AbstractAction(key)
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
                final String declaration = JOptionPane.showInputDialog(null, I18NProperties
                    .getString("variable.declaration"), I18NProperties
                    .getString("adding.variable.declaration"), JOptionPane.QUESTION_MESSAGE);

                if (declaration != null)
                {
                    ((Variable) concept()).getVariablesList().add(declaration);
                    popupMenu.add(VariableFigure.this.getNewItem(declaration, popupMenu));
                    SingleConnector.manager().updateRedrawCode();
                    concept().redraw();
                }
            }
        });
        popupMenu.setLightWeightPopupEnabled(true);
        return popupMenu;
    }

    /**
     * Gets a new item to popup.
     * 
     * @param key
     * @return
     */
    private AbstractAction getNewItem(final String name, final JPopupMenu popup)
    {
        final String key = I18NProperties.getString("remove.variable.declaration") + ": " + name;
        this.popupKeys.add(key);
        AbstractAction abs = new AbstractAction(key)
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
                ((Variable) concept()).getVariablesList().remove(name);
                int index = this.getIndex(key);
                popup.remove(index);
                VariableFigure.this.popupKeys.remove(key);
                SingleConnector.manager().updateRedrawCode();
                ((Variable) concept()).redraw();
            }

            /**
             * Gets the index.
             * 
             * @param value
             * @return
             */
            private int getIndex(String value)
            {
                for (int i = 0; i < VariableFigure.this.popupKeys.size(); i++)
                {
                    String next = VariableFigure.this.popupKeys.get(i);
                    if (next.equals(value))
                    {
                        return i;
                    }
                }
                return -1;
            }
        };

        return abs;
    }

}
