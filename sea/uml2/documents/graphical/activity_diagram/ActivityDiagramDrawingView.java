/*
 * @(#)ActivityDiagramDrawingView.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Mar 3, 2008        descrição
 */
package documents.graphical.activity_diagram;

import ocean.jhotdraw.SpecificationDrawingView;

public class ActivityDiagramDrawingView extends SpecificationDrawingView
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 3969155395018681813L;

    /**
     * @param editor
     */
    public ActivityDiagramDrawingView(ActivityDiagramEditor editor)
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
    public ActivityDiagramDrawingView(ActivityDiagramEditor editor, int width, int height)
    {
        super(editor, width, height);
    }
}
