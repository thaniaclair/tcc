package documents.graphical.object_diagram;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.font.TextAttribute;
import java.util.*;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import ocean.accessories.SingleConnector;
import ocean.documents.oo.concepts.Classe;
import ocean.jhotdraw.SeparatorFigure;
import ocean.jhotdraw.SpecificationCompositeFigure;
import ocean.smalltalk.Constantes;
import ocean.smalltalk.OceanVector;
import CH.ifa.draw.contrib.GraphicalCompositeFigure;
import CH.ifa.draw.figures.RectangleFigure;
import CH.ifa.draw.figures.TextFigure;
import CH.ifa.draw.framework.Figure;
import documents.concepts.object_diagram.InstanceSpecification;
import documents.graphical.deployment_diagram.ExtendedTextFigure;
import documents.util.I18NProperties;

public class InstanceSpecificationFigure extends SpecificationCompositeFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -6090801871615341295L;

    /**
     * The popup keys.
     */
    private List<String> popupKeys = new LinkedList<String>();

    /**
     * Default constructor.
     */
    public InstanceSpecificationFigure()
    {
        super(new RectangleFigure());
    }

    /**
     * Overloaded constructor.
     * 
     * @param object
     */
    public InstanceSpecificationFigure(InstanceSpecification object)
    {
        super(new RectangleFigure(), object);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @Override
    public Class<InstanceSpecification> relatedConceptClass()
    {
        return InstanceSpecification.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(InstanceSpecification.class);
        auxList.add(Classe.class);
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

        if (this.popupKeys == null)
        {
            this.popupKeys = new LinkedList<String>();
        }

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

        InstanceSpecification instance = (InstanceSpecification) this.concept();
        if ((instance.name() == null) || ("").equals(instance.name()))
        {
            instance.name("object");
        }

        // NAME
        String instanceName = instance.name() + " : " + instance.conceptClass().name();
        Map<TextAttribute, Number> map = new HashMap<TextAttribute, Number>();
        map.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        map.put(TextAttribute.SIZE, 14);
        map.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD);
        Font fontName = new Font(map);
        FontMetrics metrics1 = Toolkit.getDefaultToolkit().getFontMetrics(fontName);
        int widthFig1 = metrics1.stringWidth(instanceName);

        // TYPE
        Font fontType = new Font("Helvetica", Font.ITALIC, 11);
        FontMetrics metrics2 = Toolkit.getDefaultToolkit().getFontMetrics(fontType);
        int widthFig2 = metrics2.stringWidth(instance.getInstanceType());

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
        figure.setText(instanceName);
        // TYPE
        figure2.setFont(fontType);
        figure2.setText(instance.getInstanceType());

        GraphicalCompositeFigure gFigure = new GraphicalCompositeFigure();
        gFigure.setAttribute("FillColor", new Color(0xE8E8E8));
        gFigure.getLayouter().setInsets(new Insets(10, 10, 10, 2));
        gFigure.add(figure2);
        gFigure.add(figure);

        GraphicalCompositeFigure gFigure2 = null;

        if (!instance.getAttributes().isEmpty())
        {
            SeparatorFigure s = new SeparatorFigure();
            s.setAttribute("FillColor", new Color(0xE8E8E8));
            s.setAttribute("FrameColor", Color.BLACK);

            gFigure2 = new GraphicalCompositeFigure(s);
            gFigure2.getLayouter().setInsets(new Insets(5, 5, 5, 5));
            gFigure2.setAttribute("FillColor", new Color(0xE8E8E8));

            TextFigure text = null;
            Set<Map.Entry<String, String>> set = instance.getAttributes().entrySet();
            for (Map.Entry<String, String> entry : set)
            {
                text = new TextFigure();
                text.setFont(new Font("Helvetica", Font.PLAIN, 12));
                text.setText(entry.getKey() + " = " + entry.getValue());
                gFigure2.add(text);
            }
        }

        add(gFigure);

        if (gFigure2 != null)
        {
            add(gFigure2);
        }

        this.setAttribute("FillColor", new Color(0xE8E8E8));

        update();
    }

    /**
     * Creates a popup menu to edit the class or object name.
     */
    protected JPopupMenu createPopupMenu()
    {
        final JPopupMenu popupMenu = new JPopupMenu();

        String key = I18NProperties.getString("change.name.class");
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
                if (SingleConnector.managerView().openDialogInterface(Constantes.NAME_SPEC,
                    ((InstanceSpecification) concept()).conceptClass().name()))
                {
                    ((InstanceSpecification) concept()).conceptClass().name(
                        (SingleConnector.manager()).getCreationName());
                    SingleConnector.manager().updateRedrawCode();
                    concept().redraw();
                }
            }
        });

        key = I18NProperties.getString("change.name.object");
        this.popupKeys.add(key);
        popupMenu.add(new AbstractAction(key)
        {

            /**
             * The serial version UID.
             */
            private static final long serialVersionUID = 4676464L;

            /*
             * (non-Javadoc)
             * 
             * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
             */
            public void actionPerformed(ActionEvent event)
            {
                if (SingleConnector.managerView().openDialogInterface(Constantes.NAME_SPEC,
                    ((InstanceSpecification) concept()).name()))
                {
                    ((InstanceSpecification) concept()).name((SingleConnector.manager())
                        .getCreationName());
                    SingleConnector.manager().updateRedrawCode();
                    concept().redraw();
                }
            }
        });

        key = I18NProperties.getString("change.type.object");
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
                String type = ((InstanceSpecification) concept()).getInstanceType().trim();
                if (type.startsWith("<<") && type.endsWith(">>"))
                {
                    type = type.substring(2, type.length() - 2);
                }

                if (SingleConnector.managerView().openDialogInterface(Constantes.NAME_SPEC, type))
                {
                    String newType = (SingleConnector.manager()).getCreationName();
                    if ((newType == null) || ("").equals(newType) || (" ").equals(newType))
                    {
                        newType = new String("instance specification");
                    }
                    ((InstanceSpecification) concept()).setInstanceType("<<" + newType + ">>");
                    SingleConnector.manager().updateRedrawCode();
                    concept().redraw();
                }
            }
        });

        key = I18NProperties.getString("add.new.attribute");
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
                String name = JOptionPane.showInputDialog(null, I18NProperties
                    .getString("attribute.name"), I18NProperties.getString("adding.attribute"),
                    JOptionPane.QUESTION_MESSAGE);

                String value = JOptionPane.showInputDialog(null, I18NProperties
                    .getString("attribute.value"), I18NProperties.getString("adding.attribute"),
                    JOptionPane.QUESTION_MESSAGE);

                if ((name != null) && (value != null))
                {
                    ((InstanceSpecification) concept()).getAttributes().put(name, value);
                    popupMenu.add(InstanceSpecificationFigure.this.getNewItem(name, popupMenu));
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
        final String key = I18NProperties.getString("remove.attribute") + " " + name;
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
                ((InstanceSpecification) concept()).getAttributes().remove(name);
                popup.remove(this.getIndex(key));
                InstanceSpecificationFigure.this.popupKeys.remove(key);
                SingleConnector.manager().updateRedrawCode();
                ((InstanceSpecification) concept()).redraw();
            }

            /**
             * Gets the index.
             * 
             * @param value
             * @return
             */
            private int getIndex(String value)
            {
                for (int i = 0; i < InstanceSpecificationFigure.this.popupKeys.size(); i++)
                {
                    String next = InstanceSpecificationFigure.this.popupKeys.get(i);
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
