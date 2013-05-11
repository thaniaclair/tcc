/*
 * @(#)Subsystem.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Jan 5, 2008        descrição
 */
package documents.concepts.package_diagram;

import documents.util.I18NProperties;
import ocean.framework.Concept;


public class Subsystem extends Concept
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -146885130342392249L;
    
    /**
     * Constructor
     */
    public Subsystem()
    {
        super();
    }
    
    /**
     * Official constructor.
     */
    public Subsystem(Package aPackage, Package anotherPackage)
    {
        this();
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#conceptName()
     */
    public String conceptName()
    {
        return I18NProperties.getString("subsystem.concept.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("subsystem.concept.name.for.tree");
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
    
    /* (non-Javadoc)
     * @see ocean.framework.OceanDocument#name()
     */
    public String name(){
        return I18NProperties.getString("subsystem.concept.name");
    }
    
}