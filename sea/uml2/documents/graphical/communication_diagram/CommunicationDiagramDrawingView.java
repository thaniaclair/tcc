/*
 * @(#)CommunicationDiagramDrawingView.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Feb 9, 2008        descrição
 */
package documents.graphical.communication_diagram;

import ocean.jhotdraw.SpecificationDrawingView;
import ocean.jhotdraw.SpecificationEditor;

public class CommunicationDiagramDrawingView extends SpecificationDrawingView
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 2763705944730608164L;

    /**
     * @param editor
     */
    public CommunicationDiagramDrawingView(SpecificationEditor editor)
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
    public CommunicationDiagramDrawingView(SpecificationEditor editor, int width, int height)
    {
        super(editor, width, height);
    }

}