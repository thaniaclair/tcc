/*
 * @(#)Interface.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Jan 11, 2008        descrição
 */
package documents.concepts.component_diagram;

import documents.util.I18NProperties;
import ocean.framework.Concept;

public class Interface extends Concept
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 5550319748632533836L;

    /**
     * The name of the interface.
     */
    private String interfaceName = null;

    /**
     * Official constructor.
     */
    public Interface()
    {
        super();
        this.interfaceName = new String("interface");
        name("interface");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#conceptName()
     */
    public String conceptName()
    {
        return I18NProperties.getString("interface.concept.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("interface.concept.name.for.tree") + name();
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

    /**
     * @return the interfaceName
     */
    public String getInterfaceName()
    {
        return interfaceName;
    }

    /**
     * @param interfaceName the interfaceName to set
     */
    public void setInterfaceName(String interfaceName)
    {
        this.interfaceName = interfaceName;
    }

}