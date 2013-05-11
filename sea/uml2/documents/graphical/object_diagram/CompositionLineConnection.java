/*
 * @(#)CompositionLineConnection.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Jan 3, 2008        descrição
 */
package documents.graphical.object_diagram;

import ocean.documents.oo.concepts.Composition;
import ocean.jhotdraw.AggregationDecoration;

public class CompositionLineConnection extends AssociationLineConnection
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 968299689648718021L;

    /**
     * The constructor.
     */
    public CompositionLineConnection()
    {
        super();

        setStartDecoration(new AggregationDecoration("composicao"));
        setEndDecoration(null);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.AssociationLineConnection#relatedConceptClass()
     */
    @Override
    public Class<Composition> relatedConceptClass()
    {
        return Composition.class;
    }
    
}