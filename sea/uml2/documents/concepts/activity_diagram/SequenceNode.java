/*
 * @(#)SequenceNode.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Mar 3, 2008        descrição
 */
package documents.concepts.activity_diagram;

import ocean.framework.Concept;
import ocean.smalltalk.OceanVector;
import documents.util.I18NProperties;

public class SequenceNode extends Concept
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 4092448691263091108L;

    /**
     * The conditional name.
     */
    private String nodeName = null;

    /**
     * The conditional type.
     */
    private String nodeType = null;

    /**
     * Official constructor.
     */
    public SequenceNode()
    {
        super();
        this.nodeName = new String("sequence");
        this.nodeType = new String("<<structured>>");
        name(I18NProperties.getString("sequence.node.concept.name"));
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#conceptName()
     */
    public String conceptName()
    {
        return I18NProperties.getString("sequence.node.concept.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("sequence.node.concept.name.for.tree") + name();
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
     * @return the sequenceName
     */
    public String getNodeName()
    {
        return nodeName;
    }

    /**
     * @param sequenceName the sequenceName to set
     */
    public void setNodeName(String sequenceName)
    {
        this.nodeName = sequenceName;
    }

    /**
     * @return the sequenceType
     */
    public String getNodeType()
    {
        return nodeType;
    }

    /**
     * @param sequenceType the sequenceType to set
     */
    public void setNodeType(String sequenceType)
    {
        this.nodeType = sequenceType;
    }

}
