/*
 * @(#)CentralBufferNode.java
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

public class CentralBufferNode extends Concept
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 4024991121765628160L;

    /**
     * The central buffer node name.
     */
    private String centralBufferName = null;

    /**
     * The central buffer node type.
     */
    private String centralBufferType = null;

    /**
     * Official constructor.
     */
    public CentralBufferNode()
    {
        super();
        this.centralBufferName = new String("CentralBufferNode");
        this.centralBufferType = new String("<<central buffer>>");
        name(I18NProperties.getString("central.buffer.node.concept.name"));
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#conceptName()
     */
    public String conceptName()
    {
        return I18NProperties.getString("central.buffer.node.concept.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("central.buffer.node.concept.name.for.tree") + name();
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
     * @return the centralBufferType
     */
    public String getCentralBufferType()
    {
        return centralBufferType;
    }

    /**
     * @param centralBufferType the centralBufferType to set
     */
    public void setCentralBufferType(String centralBufferType)
    {
        this.centralBufferType = centralBufferType;
    }

    /**
     * @return the centralBufferName
     */
    public String getCentralBufferName()
    {
        return centralBufferName;
    }

    /**
     * @param centralBufferName the centralBufferName to set
     */
    public void setCentralBufferName(String centralBufferName)
    {
        this.centralBufferName = centralBufferName;
    }

}