/*
 * @(#)CommentLinkFigure.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Mar 11, 2008        descrição
 */
package documents.graphical.activity_diagram;

import java.awt.Graphics;

import ocean.smalltalk.OceanVector;
import documents.concepts.activity_diagram.NoteLink;
import documents.graphical.object_diagram.DependencyLineConnection;

public class CommentLinkFigure extends DependencyLineConnection
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -1084244837859099881L;

    /**
     * Create a new instance
     */
    public CommentLinkFigure()
    {
        super();

        setStartDecoration(null);
        setEndDecoration(null);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationCompositeFigure#relatedConceptClass()
     */
    @Override
    public Class<NoteLink> relatedConceptClass()
    {
        return NoteLink.class;
    }

    /**
     * @return
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public static OceanVector memberRelatedConceptClass()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(NoteLink.class);
        return auxList;
    }

}
