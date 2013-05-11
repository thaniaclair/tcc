/*
 * @(#)Merge.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Jan 5, 2008        descrição
 */
package documents.concepts.package_diagram;

import documents.util.I18NProperties;
import ocean.framework.Concept;
import ocean.smalltalk.OceanVector;

public class Merge extends Concept
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -146885130342392249L;

    private Package mergedPackage;

    private Package mergerPackage;

    /**
     * Constructor
     */
    public Merge()
    {
        super();
    }

    /**
     * Official constructor.
     */
    public Merge(Package aPackage, Package anotherPackage)
    {
        this();
        name(I18NProperties.getString("merge.concept.name"));
        this.mergedPackage(aPackage);
        this.mergerPackage(anotherPackage);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#attacherComponent()
     */
    public Object attacherComponent()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(this.mergerPackage());
        auxList.add(this.mergedPackage());
        return auxList;
    }

    public void mergedPackage(Package pack)
    {
        this.mergedPackage = pack;
    }

    public void mergerPackage(Package pack)
    {
        this.mergerPackage = pack;
    }

    public Package mergedPackage()
    {
        return this.mergedPackage;
    }

    public Package mergerPackage()
    {
        return this.mergerPackage;
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#conceptName()
     */
    public String conceptName()
    {
        return I18NProperties.getString("merge.concept.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("merge.concept.name.for.tree");
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
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#name()
     */
    public String name()
    {
        return I18NProperties.getString("merge.concept.name");
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
