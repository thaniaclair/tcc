/*
 * @(#)Import.java
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

public class Import extends Concept
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -146885130342392249L;

    private Package importedPackage;

    private Package importerPackage;

    /**
     * Constructor
     */
    public Import()
    {
        super();
    }

    /**
     * Official constructor.
     */
    public Import(Package aPackage, Package anotherPackage)
    {
        this();
        name(I18NProperties.getString("import.concept.name"));
        this.importedPackage(aPackage);
        this.importerPackage(anotherPackage);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#attacherComponent()
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public Object attacherComponent()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(this.importerPackage());
        auxList.add(this.importedPackage());
        return auxList;
    }

    public void importedPackage(Package pack)
    {
        this.importedPackage = pack;
    }

    public void importerPackage(Package pack)
    {
        this.importerPackage = pack;
    }

    public Package importedPackage()
    {
        return this.importedPackage;
    }

    public Package importerPackage()
    {
        return this.importerPackage;
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#conceptName()
     */
    public String conceptName()
    {
        return I18NProperties.getString("import.concept.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("import.concept.name.for.tree");
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
        return I18NProperties.getString("import.concept.name");
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
