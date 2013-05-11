/*
 * @(#)StateMachineDiagramDrawingView.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Feb 21, 2008        descrição
 */
package documents.graphical.state_machine_diagram;

import ocean.jhotdraw.SpecificationDrawingView;
import ocean.jhotdraw.SpecificationEditor;

public class StateMachineDiagramDrawingView extends SpecificationDrawingView
{

    /**
     * The serial version ID.
     */
    private static final long serialVersionUID = -8139593629581181419L;

    /**
     * Constructor.
     * 
     * @param editor The specification editor.
     */
    public StateMachineDiagramDrawingView(SpecificationEditor editor)
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
    public StateMachineDiagramDrawingView(SpecificationEditor editor, int width, int height)
    {
        super(editor, width, height);
    }
}
