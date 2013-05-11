/*
 * @(#)Port.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Jan 11, 2008        descrição
 */
package documents.concepts.component_diagram;

import documents.util.I18NProperties;
import ocean.framework.Concept;

public class Port extends Concept
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -6662722305450121658L;

    /**
     * Official constructor.
     */
    public Port()
    {
        super();
        name("port");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#conceptName()
     */
    public String conceptName()
    {
        return I18NProperties.getString("port.concept.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("port.concept.name.for.tree") + name();
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

}