/*
 * @(#)Label.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Feb 11, 2008        descrição
 */
package documents.concepts.communication_diagram;

import documents.util.I18NProperties;
import ocean.framework.Concept;
import ocean.smalltalk.OceanVector;

public class Label extends Concept
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -3118364627779217321L;

    /**
     * Official constructor.
     */
    public Label()
    {
        super();
        name(I18NProperties.getString("label.concept.name"));
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#conceptName()
     */
    public String conceptName()
    {
        return I18NProperties.getString("label.concept.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("label.concept.name.for.tree") + name();
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