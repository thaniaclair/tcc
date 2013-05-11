/*
 * @(#)Part.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Feb 16, 2008        descrição
 */
package documents.concepts.composite_structure_diagram;

import ocean.framework.Concept;
import ocean.smalltalk.OceanVector;
import documents.util.I18NProperties;

public class Part extends Concept
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 7565823586448180226L;

    /**
     * The name of the attribute.
     */
    private String attributeName = null;

    /**
     * The visibility of the attribute.
     */
    private String attributeVisibility = null;

    /**
     * Official constructor.
     */
    public Part()
    {
        super();
        this.attributeName = new String("attribute");
        this.attributeVisibility = new String("-");
        name(I18NProperties.getString("part.concept.name"));
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#conceptName()
     */
    public String conceptName()
    {
        return I18NProperties.getString("part.concept.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("part.concept.name.for.tree") + name();
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
     * @return the attributeName
     */
    public String getAttributeName()
    {
        return attributeName;
    }

    /**
     * @param attributeName the attributeName to set
     */
    public void setAttributeName(String attributeName)
    {
        this.attributeName = attributeName;
    }

    /**
     * @return the attributeVisibility
     */
    public String getAttributeVisibility()
    {
        return attributeVisibility;
    }

    /**
     * @param attributeVisibility the attributeVisibility to set
     */
    public void setAttributeVisibility(String attributeVisibility)
    {
        this.attributeVisibility = attributeVisibility;
    }

}
