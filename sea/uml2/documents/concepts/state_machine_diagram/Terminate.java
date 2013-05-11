/*
 * @(#)Terminate.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Feb 21, 2008        descrição
 */
package documents.concepts.state_machine_diagram;

import documents.util.I18NProperties;
import ocean.framework.Concept;
import ocean.smalltalk.OceanVector;

public class Terminate extends Concept
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 4441718359801597821L;

    /**
     * Official constructor.
     */
    public Terminate()
    {
        super();
        name(I18NProperties.getString("terminate.concept.name"));
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#conceptName()
     */
    public String conceptName()
    {
        return I18NProperties.getString("terminate.concept.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("terminate.concept.name.for.tree") + name();
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#mustHaveName()
     */
    public boolean mustHaveName()
    {
        return false;
    }

    /*
     * FIXME (non-Javadoc)
     * 
     * @see ocean.framework.Concept#duplicityIn(ocean.smalltalk.OceanVector)
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public Concept duplicityIn(OceanVector aConceptList)
    {
        return super.duplicityIn(aConceptList);
    }

}
