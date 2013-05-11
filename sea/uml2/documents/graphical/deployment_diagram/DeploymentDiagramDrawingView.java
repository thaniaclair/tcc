/*
 * @(#)DeploymentDiagramDrawingView.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Jan 24, 2008        descrição
 */
package documents.graphical.deployment_diagram;

import ocean.jhotdraw.SpecificationDrawingView;
import ocean.jhotdraw.SpecificationEditor;

public class DeploymentDiagramDrawingView extends SpecificationDrawingView
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 2115422977952547262L;

    /**
     * @param editor
     */
    public DeploymentDiagramDrawingView(SpecificationEditor editor)
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
    public DeploymentDiagramDrawingView(SpecificationEditor editor, int width, int height)
    {
        super(editor, width, height);
    }

}