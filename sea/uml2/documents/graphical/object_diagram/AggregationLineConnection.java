/*
 * @(#)AggregationLineConnection.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Jan 3, 2008        descrição
 */
package documents.graphical.object_diagram;

import ocean.documents.oo.concepts.Agregacao;
import ocean.jhotdraw.AggregationDecoration;

public class AggregationLineConnection extends AssociationLineConnection
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -8624011393087214151L;

    /**
     * The constructor.
     */
    public AggregationLineConnection()
    {
        super();

        setStartDecoration(new AggregationDecoration("agregacao"));
        setEndDecoration(null);
    }
 
    /* (non-Javadoc)
     * @see ocean.jhotdraw.AssociationLineConnection#relatedConceptClass()
     */
    @Override
    public Class<Agregacao> relatedConceptClass()
    {
        return Agregacao.class;
    }
    
}
