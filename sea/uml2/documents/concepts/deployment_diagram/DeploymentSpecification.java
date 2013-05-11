/*
 * @(#)DeploymentSpecification.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Jan 24, 2008        descrição
 */
package documents.concepts.deployment_diagram;

import ocean.framework.Concept;
import ocean.smalltalk.OceanVector;
import documents.util.I18NProperties;

public class DeploymentSpecification extends Concept
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -2979948508500068184L;

    /**
     * The name of deployment specification.
     */
    private String deployName = null;

    /**
     * The type of deployment specification.
     */
    private String deployType = null;

    /**
     * Constructor.
     */
    public DeploymentSpecification()
    {
        super();
        this.deployName = new String("deployment");
        this.deployType = new String("<<deployment spec>>");
        name(I18NProperties.getString("deployment.specification.concept.name"));
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#conceptName()
     */
    public String conceptName()
    {
        return I18NProperties.getString("deployment.specification.concept.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("deployment.specification.concept.name.for.tree");
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
        return I18NProperties.getString("deployment.specification.concept.name");
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
     * @return the deployName
     */
    public String getDeployName()
    {
        return deployName;
    }

    /**
     * @param deployName the deployName to set
     */
    public void setDeployName(String deployName)
    {
        this.deployName = deployName;
    }

    /**
     * @return the deployType
     */
    public String getDeployType()
    {
        return deployType;
    }

    /**
     * @param deployType the deployType to set
     */
    public void setDeployType(String deployType)
    {
        this.deployType = deployType;
    }

}