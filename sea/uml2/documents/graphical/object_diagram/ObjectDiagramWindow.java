package documents.graphical.object_diagram;

import java.io.Serializable;

import ocean.framework.ConceptualModel;
import ocean.jhotdraw.*;
import ocean.smalltalk.IComunicacao;

public class ObjectDiagramWindow extends EditorAuxWindow implements IComunicacao
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 5173757635595308500L;

    /**
     * Official constructor.
     */
    public ObjectDiagramWindow()
    {
        super(new ObjectDiagramEditor());
        setDrawingView((SpecificationDrawingView) getEditor().view());
    }

    /**
     * Official constructor.
     * 
     * @param editor The specification editor.
     */
    public ObjectDiagramWindow(SpecificationEditor editor)
    {
        super(editor);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.EditorAuxWindow#getSelected()
     */
    public Serializable getSelected()
    {
        return getDrawingView().getSelected();
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.EditorAuxWindow#setDocument(java.lang.Object)
     */
    public void setDocument(Object obj)
    {
        this.handledElement((ConceptualModel) obj);
        ((ObjectDiagramEditor) getEditor()).setDocument(obj);
        this.getEditor().view().setDrawing(((ConceptualModel) obj).drawing());
        this.setDrawing((SpecificationDrawing) getEditor().view().drawing());
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.EditorAuxWindow#getDocument()
     */
    public Object getDocument()
    {
        return handledElement();
    }

    /* (non-Javadoc)
     * @see ocean.jhotdraw.EditorAuxWindow#show()
     */
    public void show()
    {
        this.setVisible(true);
    }

}