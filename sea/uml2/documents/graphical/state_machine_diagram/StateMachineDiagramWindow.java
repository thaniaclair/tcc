/*
 * @(#)StateMachineDiagramWindow.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Feb 21, 2008        descrição
 */
package documents.graphical.state_machine_diagram;

import java.io.Serializable;

import ocean.framework.ConceptualModel;
import ocean.jhotdraw.*;
import ocean.smalltalk.IComunicacao;

public class StateMachineDiagramWindow extends EditorAuxWindow implements IComunicacao
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 2052155616596041612L;

    /**
     * Official constructor.
     */
    public StateMachineDiagramWindow()
    {
        super(new StateMachineDiagramEditor());
        setDrawingView((SpecificationDrawingView) getEditor().view());
    }

    /**
     * Official constructor.
     * 
     * @param editor The specification editor.
     */
    public StateMachineDiagramWindow(SpecificationEditor editor)
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
        ((StateMachineDiagramEditor) getEditor()).setDocument(obj);
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

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.EditorAuxWindow#show()
     */
    public void show()
    {
        this.setVisible(true);
    }
}
