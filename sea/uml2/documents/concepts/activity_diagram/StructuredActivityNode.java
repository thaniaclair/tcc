/*
 * @(#)StructuredActivityNode.java
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

public class StructuredActivityNode extends Concept
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 4092448691263091108L;

    /**
     * The structured name.
     */
    private String structuredName = null;

    /**
     * The structured type.
     */
    private String structuredType = null;

    /**
     * Official constructor.
     */
    public StructuredActivityNode()
    {
        super();
        this.structuredName = new String("activity");
        this.structuredType = new String("<<structured>>");
        name(I18NProperties.getString("structured.activity.node.concept.name"));
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#conceptName()
     */
    public String conceptName()
    {
        return I18NProperties.getString("structured.activity.node.concept.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("structured.activity.node.concept.name.for.tree") + name();
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
     * @return the structuredName
     */
    public String getStructuredName()
    {
        return structuredName;
    }

    /**
     * @param structuredName the structuredName to set
     */
    public void setStructuredName(String structuredName)
    {
        this.structuredName = structuredName;
    }

    /**
     * @return the structuredType
     */
    public String getStructuredType()
    {
        return structuredType;
    }

    /**
     * @param structuredType the structuredType to set
     */
    public void setStructuredType(String structuredType)
    {
        this.structuredType = structuredType;
    }

}
