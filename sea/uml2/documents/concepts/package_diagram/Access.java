/*
 * @(#)Access.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Jan 5, 2008        descrição
 */
package documents.concepts.package_diagram;

import ocean.framework.Concept;
import ocean.smalltalk.OceanVector;
import documents.util.I18NProperties;

public class Access extends Concept
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -146885130342392249L;
    
    private Package accessedPackage;
    
    private Package accesserPackage;

    /**
     * Constructor
     */
    public Access()
    {
        super();
    }

    /**
     * Official constructor.
     */
    public Access(Package aPackage, Package anotherPackage)
    {
        this();
        name(I18NProperties.getString("access.concept.name"));
        this.accessedPackage(aPackage);
        this.accesserPackage(anotherPackage);
    }

    /* (non-Javadoc)
     * @see ocean.framework.Concept#attacherComponent()
     */
    @SuppressWarnings({ "deprecation", "unchecked" })
    public Object attacherComponent()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(this.accesserPackage());
        auxList.add(this.accessedPackage());
        return auxList;
    }

    public void accessedPackage(Package pack)
    {
        this.accessedPackage = pack;
    }

    public void accesserPackage(Package pack)
    {
        this.accesserPackage = pack;   
    }
    
    public Package accessedPackage()
    {
        return this.accessedPackage;
    }

    public Package accesserPackage()
    {
        return this.accesserPackage;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#conceptName()
     */
    public String conceptName()
    {
        return I18NProperties.getString("access.concept.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("access.concept.name.for.tree");
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

    /*realization
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#name()
     */
    public String name()
    {
        return I18NProperties.getString("access.concept.name");
    }

    /*
     * FIXME 
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#duplicityIn(ocean.smalltalk.OceanVector)
     */
    @SuppressWarnings({ "deprecation", "unchecked" })
    public Concept duplicityIn(OceanVector aConceptList)
    {
        return super.duplicityIn(aConceptList);
    }
    
}