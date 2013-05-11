/*
 * @(#)NoteFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Mar 19, 2008        descrição
 */
package documents.graphical.activity_diagram;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.*;

import ocean.accessories.SingleConnector;
import ocean.jhotdraw.SpecificationCompositeFigure;
import ocean.smalltalk.OceanVector;
import CH.ifa.draw.contrib.GraphicalCompositeFigure;
import CH.ifa.draw.figures.RectangleFigure;
import CH.ifa.draw.figures.TextFigure;
import CH.ifa.draw.framework.Figure;

import com.borland.jbcl.layout.XYConstraints;
import com.borland.jbcl.layout.XYLayout;

import documents.concepts.activity_diagram.Note;
import documents.util.I18NProperties;

public class NoteFigure extends SpecificationCompositeFigure
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -7414918748026176236L;

    /**
     * Default constructor.
     */
    public NoteFigure()
    {
        super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @Override
    public Class<Note> relatedConceptClass()
    {
        return Note.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(Note.class);
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

        Note note = (Note) this.concept();
        if ((note.name() == null) || ("").equals(note.name()))
        {
            this.createDialog(note);
        }

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

        String[] notes = note.name().split("\\n");
        Font fontNote = new Font("Helvetica", Font.PLAIN, 12);

        // Just if we have items.
        if (notes != null && notes.length > 0)
        {
            for (String nextNote : notes)
            {
                TextFigure newNote = new TextFigure();
                newNote.setFont(fontNote);
                newNote.setText(nextNote);
                gFigure.add(newNote);
            }
        }

        add(gFigure);

        update();
    }

    /**
     * Creates a popup menu to edit the class or object name.
     */
    protected JPopupMenu createPopupMenu()
    {
        JPopupMenu popupMenu = new JPopupMenu();

        popupMenu.add(new AbstractAction(I18NProperties.getString("change.description.note"))
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

                NoteFigure.this.createDialog((Note) concept());
                SingleConnector.manager().updateRedrawCode();
                concept().redraw();
            }
        });

        popupMenu.setLightWeightPopupEnabled(true);
        return popupMenu;
    }

    /**
     * Creates a NoteDialog instance.
     */
    public void createDialog(Note note)
    {
        JFrame frame = new JFrame();
        NoteDialog noteDialog = new NoteDialog(frame, note);
        noteDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Display the window.
        Dimension dx = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        noteDialog.setLocation(((dx.width - 300) / 2), ((dx.height - 300) / 2));
        noteDialog.setResizable(false);
        noteDialog.pack();
        noteDialog.getTextArea().requestFocusInWindow();
        noteDialog.setVisible(true);
        frame.setSize(noteDialog.getPreferredSize());
    }

    /**
     * Creates a dialog to get the note content.
     * 
     * @author thania
     * @since Mar 12, 2008
     */
    class NoteDialog extends JDialog
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
        public NoteDialog(Frame owner, Note note)
        {
            super(owner, true);
            this.frame = owner;
            this.init(note);
        }

        /**
         * Initializes the components of the dialog.
         */
        private void init(final Note note)
        {
            this.setTitle(I18NProperties.getString("note.title"));
            this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
            this.setLayout(xYLayout);
            this.setFocusable(true);

            Font fontDialog = new Font("Dialog", Font.BOLD, 12);
            input.setFont(fontDialog);
            input.setText(I18NProperties.getString("note.input"));

            textArea.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
            textArea.setWrapStyleWord(true);
            textArea.setFont(new Font("monospaced", Font.PLAIN, 12));
            textArea.setText(note.name());

            scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

            ok.setFont(fontDialog);
            ok.setSelected(true);
            ok.setText(I18NProperties.getString("note.ok"));
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
                    note.name(NoteDialog.this.textArea.getText());
                    setVisible(false);
                    frame.dispose();
                }
            });

            cancel.setFont(fontDialog);
            cancel.setRolloverEnabled(true);
            cancel.setText(I18NProperties.getString("note.cancel"));
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
            this.add(ok, new XYConstraints(50, 245, 95, 20));
            this.add(cancel, new XYConstraints(155, 245, 95, 20));
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
