/*
 * @(#)ComponentDiagramDrawingView.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Jan 11, 2008        descrição
 */
package documents.graphical.composite_structure_diagram;

import ocean.jhotdraw.SpecificationDrawingView;
import ocean.jhotdraw.SpecificationEditor;

public class CompositeStructureDiagramDrawingView extends SpecificationDrawingView
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -7837595733925059760L;

    /**
     * @param editor
     */
    public CompositeStructureDiagramDrawingView(SpecificationEditor editor)
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
    public CompositeStructureDiagramDrawingView(SpecificationEditor editor, int width, int height)
    {
        super(editor, width, height);
    }

}