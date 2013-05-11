/*
 * @(#)TaskPackageFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Mar 11, 2008        descrição
 */
package documents.graphical.activity_diagram;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.swing.*;

import ocean.accessories.SingleConnector;
import ocean.smalltalk.OceanVector;
import CH.ifa.draw.contrib.GraphicalCompositeFigure;
import CH.ifa.draw.figures.TextFigure;
import CH.ifa.draw.framework.Figure;

import com.borland.jbcl.layout.XYConstraints;
import com.borland.jbcl.layout.XYLayout;

import documents.concepts.activity_diagram.Activity;
import documents.concepts.activity_diagram.TaskPackage;
import documents.graphical.deployment_diagram.ExtendedTextFigure;
import documents.util.I18NProperties;

public class TaskPackageFigure extends ActivityFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -1084244837859099881L;

    /**
     * The stereotype of the generic task.
     */
    private static final String TYPE = new String("<<task package>>");

    /**
     * Constructor.
     */
    public TaskPackageFigure()
    {
        super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @Override
    public Class< ? extends Activity> relatedConceptClass()
    {
        return TaskPackage.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(TaskPackage.class);
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

        // FONTS
        Font fontType = new Font("Helvetica", Font.ITALIC, 11);
        Font fontTask = new Font("Helvetica", Font.BOLD, 14);

        // COLOR
        Color grayColor = new Color(0xE8E8E8);

        this.getPresentationFigure().setAttribute("FillColor", grayColor);
        this.getPresentationFigure().setAttribute("FrameColor", Color.BLACK);
        recRound.setArc(22, 22);

        GraphicalCompositeFigure gFigure = new GraphicalCompositeFigure();
        gFigure.setAttribute("FillColor", grayColor);
        gFigure.setAttribute("FrameColor", grayColor);
        gFigure.getLayouter().setInsets(new Insets(10, 10, 10, 2));

        TaskPackage task = (TaskPackage) this.concept();
        if ((task.name() == null) || ("").equals(task.name()))
        {
            this.createDialog(task);
        }

        String[] tasks = task.name().split("\\n");
        List<TextFigure> textFigures = new LinkedList<TextFigure>();
        List<Integer> textWidths = new LinkedList<Integer>();

        // The max text width.
        int max = 0;

        // Just if we have items.
        if (tasks != null && tasks.length > 0)
        {

            for (String nextTask : tasks)
            {
                TextFigure newTask = new TextFigure();
                newTask.setFont(fontTask);
                newTask.setText(nextTask);
                textFigures.add(newTask);

                FontMetrics metrics = Toolkit.getDefaultToolkit().getFontMetrics(fontTask);
                textWidths.add(metrics.stringWidth(nextTask));
            }

            Collections.sort(textWidths);
            FontMetrics metrics = Toolkit.getDefaultToolkit().getFontMetrics(fontType);
            int widthType = metrics.stringWidth(TYPE);
            int widthMaxTask = textWidths.get(textWidths.size() - 1);
            if (widthMaxTask > widthType)
            {
                max = (widthMaxTask - widthType) / 2;
            }
        }

        // TYPE
        ExtendedTextFigure taskTypeFigure = new ExtendedTextFigure(max);
        taskTypeFigure.setFont(fontType);
        taskTypeFigure.setText(TYPE);
        gFigure.add(taskTypeFigure);

        for (TextFigure taskFigure : textFigures)
        {
            gFigure.add(taskFigure);
        }

        add(gFigure);

        getLayouter().setInsets(new Insets(5, 5, 5, 5));

        update();
    }

    /**
     * Creates a TaskDialog instance.
     */
    public void createDialog(TaskPackage task)
    {
        JFrame frame = new JFrame();
        TaskDialog taskDialog = new TaskDialog(frame, task);
        taskDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Display the window.
        Dimension dx = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        taskDialog.setLocation(((dx.width - 300) / 2), ((dx.height - 300) / 2));
        taskDialog.setResizable(false);
        taskDialog.pack();
        taskDialog.getTextArea().requestFocusInWindow();
        taskDialog.setVisible(true);
        frame.setSize(taskDialog.getPreferredSize());
    }

    /**
     * Creates a popup menu to edit the class or object name.
     */
    protected JPopupMenu createPopupMenu()
    {
        JPopupMenu popupMenu = new JPopupMenu();

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.task.package"))
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
                TaskPackageFigure.this.createDialog((TaskPackage) concept());
                SingleConnector.manager().updateRedrawCode();
                concept().redraw();
            }
        });

        popupMenu.setLightWeightPopupEnabled(true);
        return popupMenu;
    }

    /**
     * Creates a dialog to get the task package content.
     * 
     * @author thania
     * @since Mar 12, 2008
     */
    class TaskDialog extends JDialog
    {

        /**
         * The serial version UID.
         */
        private static final long serialVersionUID = -5067201495936061471L;

        private JTextArea textArea = new JTextArea();

        private JScrollPane scroll = new JScrollPane(textArea);

        private JLabel input = new JLabel();

        private XYLayout xYLayout = new XYLayout();

        private JButton ok = new JButton();

        private JButton cancel = new JButton();

        private static final int WIDTH = 300;

        private static final int HEIGHT = 275;

        private Frame frame;

        /**
         * @param owner
         */
        public TaskDialog(Frame owner, TaskPackage task)
        {
            super(owner, true);
            this.frame = owner;
            this.init(task);
        }

        /**
         * Initializes the components of the dialog.
         */
        private void init(final TaskPackage task)
        {
            this.setTitle(I18NProperties.getString("task.package.title"));
            this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
            this.setLayout(xYLayout);
            this.setFocusable(true);

            Font fontDialog = new Font("Dialog", Font.BOLD, 12);
            input.setFont(fontDialog);
            input.setText(I18NProperties.getString("task.package.input"));

            textArea.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
            textArea.setWrapStyleWord(true);
            textArea.setFont(new Font("monospaced", Font.PLAIN, 12));
            textArea.setText(task.name());

            scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

            ok.setFont(fontDialog);
            ok.setSelected(true);
            ok.setText(I18NProperties.getString("task.package.ok"));
            ok.setDefaultCapable(true);
            ok.addMouseListener(new java.awt.event.MouseAdapter()
            {

                /*
                 * (non-Javadoc)
                 * 
                 * @see java.awt.event.MouseAdapter#mouseClicked(java.awt.event.MouseEvent)
                 */
                public void mouseClicked(MouseEvent e)
                {
                    task.name(TaskDialog.this.textArea.getText());
                    setVisible(false);
                    frame.dispose();
                }
            });

            cancel.setFont(fontDialog);
            cancel.setRolloverEnabled(true);
            cancel.setText(I18NProperties.getString("task.package.cancel"));
            cancel.addMouseListener(new java.awt.event.MouseAdapter()
            {

                /*
                 * (non-Javadoc)
                 * 
                 * @see java.awt.event.MouseAdapter#mouseClicked(java.awt.event.MouseEvent)
                 */
                public void mouseClicked(MouseEvent e)
                {
                    setVisible(false);
                    frame.dispose();
                }
            });

            this.add(input, new XYConstraints(10, 5, 200, 30));
            this.add(scroll, new XYConstraints(10, 35, 280, 200));
            this.add(ok, new XYConstraints(55, 245, 95, 20));
            this.add(cancel, new XYConstraints(160, 245, 95, 20));
        }

        /**
         * @return the textArea
         */
        public JTextArea getTextArea()
        {
            return textArea;
        }

    }

}
