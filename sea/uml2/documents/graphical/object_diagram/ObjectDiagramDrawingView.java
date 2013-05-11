package documents.graphical.object_diagram;

import ocean.jhotdraw.SpecificationDrawingView;
import ocean.jhotdraw.SpecificationEditor;

public class ObjectDiagramDrawingView extends SpecificationDrawingView
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 6394036983066746229L;

    /**
     * Constructor.
     * 
     * @param editor The specification editor.
     */
    public ObjectDiagramDrawingView(SpecificationEditor editor)
    {
        super(editor);
    }

    /**
     * Constructor.
     * 
     * @param editor
     * @param width
     * @param height
     */
    public ObjectDiagramDrawingView(SpecificationEditor editor, int width, int height)
    {
        super(editor, width, height);
    }

}
