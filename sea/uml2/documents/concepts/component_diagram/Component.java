/*
 * @(#)Component.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Jan 11, 2008        descrição
 */
package documents.concepts.component_diagram;

import ocean.framework.Concept;
import ocean.smalltalk.OceanVector;
import documents.util.I18NProperties;

public class Component extends Concept
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -3127608563350981688L;

    /**
     * The name of component.
     */
    private String componentName = null;

    /**
     * The type of component.
     */
    private String componentType = null;

    /**
     * Official constructor.
     */
    public Component()
    {
        super();
        this.componentName = new String("componente");
        this.componentType = new String("<<component>>");
        name("componente");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#conceptName()
     */
    public String conceptName()
    {
        return I18NProperties.getString("component.concept.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("component.concept.name.for.tree") + name();
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
     * @return the componentName
     */
    public String getComponentName()
    {
        return componentName;
    }

    /**
     * @param componentName the componentName to set
     */
    public void setComponentName(String componentName)
    {
        this.componentName = componentName;
    }

    /**
     * @return the componentType
     */
    public String getComponentType()
    {
        return componentType;
    }

    /**
     * @param componentType the componentType to set
     */
    public void setComponentType(String componentType)
    {
        this.componentType = componentType;
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