/*
 * @(#)CommunicationDiagramWindow.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Feb 9, 2008        descrição
 */
package documents.graphical.communication_diagram;

import java.io.Serializable;

import org.omg.CORBA.Environment;

import documents.concepts.communication_diagram.Label;

import ocean.framework.Concept;
import ocean.framework.ConceptualModel;
import ocean.gui.EnvironmentManagerView;
import ocean.jhotdraw.*;
import ocean.smalltalk.IComunicacao;

public class CommunicationDiagramWindow extends EditorAuxWindow implements IComunicacao
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 889008073424726922L;

    /**
     * Official constructor.
     */
    public CommunicationDiagramWindow()
    {
        super(new CommunicationDiagramEditor());
        setDrawingView((SpecificationDrawingView) getEditor().view());
    }

    /**
     * Official constructor.
     * 
     * @param editor The specification editor.
     */
    public CommunicationDiagramWindow(SpecificationEditor editor)
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
        ((CommunicationDiagramEditor) getEditor()).setDocument(obj);
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
