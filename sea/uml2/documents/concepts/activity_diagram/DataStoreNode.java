/*
 * @(#)DataStoreNode.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Mar 3, 2008        descrição
 */
package documents.concepts.activity_diagram;

import documents.util.I18NProperties;
import ocean.framework.Concept;
import ocean.smalltalk.OceanVector;

public class DataStoreNode extends Concept
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -5942132208180174453L;

    /**
     * The central buffer node name.
     */
    private String dataStoreName = null;

    /**
     * The central buffer node type.
     */
    private String dataStoreType = null;

    /**
     * Official constructor.
     */
    public DataStoreNode()
    {
        super();
        this.dataStoreName = new String("DataStoreNode");
        this.dataStoreType = new String("<<data store>>");
        name(I18NProperties.getString("data.store.node.concept.name"));
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#conceptName()
     */
    public String conceptName()
    {
        return I18NProperties.getString("data.store.node.concept.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("data.store.node.concept.name.for.tree") + name();
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

    /**
     * @return the dataStoreName
     */
    public String getDataStoreName()
    {
        return dataStoreName;
    }

    /**
     * @param dataStoreName the dataStoreName to set
     */
    public void setDataStoreName(String dataStoreName)
    {
        this.dataStoreName = dataStoreName;
    }

    /**
     * @return the dataStoreType
     */
    public String getDataStoreType()
    {
        return dataStoreType;
    }

    /**
     * @param dataStoreType the dataStoreType to set
     */
    public void setDataStoreType(String dataStoreType)
    {
        this.dataStoreType = dataStoreType;
    }

}
