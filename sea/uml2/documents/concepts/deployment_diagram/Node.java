/*
 * @(#)Node.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Jan 24, 2008        descrição
 */
package documents.concepts.deployment_diagram;

import java.util.LinkedList;
import java.util.List;

import ocean.framework.Concept;
import ocean.smalltalk.OceanVector;
import documents.concepts.component_diagram.Component;
import documents.util.I18NProperties;

public class Node extends Concept
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 900064134964175299L;

    /**
     * The name of artifact.
     */
    private String nodeName = null;

    /**
     * The artifact list.
     */
    private List<Artifact> artifactList = new LinkedList<Artifact>();

    /**
     * The deployment specification list.
     */
    private List<DeploymentSpecification> deployList = new LinkedList<DeploymentSpecification>();

    /**
     * The component list.
     */
    private List<Component> componentList = new LinkedList<Component>();

    /**
     * Constructor.
     */
    public Node()
    {
        super();
        this.nodeName = new String("node");
        name(I18NProperties.getString("node.concept.name"));
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#conceptName()
     */
    public String conceptName()
    {
        return I18NProperties.getString("node.concept.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("node.concept.name.for.tree");
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
        return I18NProperties.getString("node.concept.name");
    }

    /**
     * @return the nodeName
     */
    public String getNodeName()
    {
        return nodeName;
    }

    /**
     * @param nodeName the nodeName to set
     */
    public void setNodeName(String nodeName)
    {
        this.nodeName = nodeName;
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
     * @return the artifactList
     */
    public List<Artifact> getArtifactList()
    {
        return artifactList;
    }

    /**
     * @param artifactList the artifactList to set
     */
    public void setArtifactList(List<Artifact> artifactList)
    {
        this.artifactList = artifactList;
    }

    /**
     * @return the deployList
     */
    public List<DeploymentSpecification> getDeployList()
    {
        return deployList;
    }

    /**
     * @param deployList the deployList to set
     */
    public void setDeployList(List<DeploymentSpecification> deployList)
    {
        this.deployList = deployList;
    }

    /**
     * @return the componentList
     */
    public List<Component> getComponentList()
    {
        return componentList;
    }

    /**
     * @param componentList the componentList to set
     */
    public void setComponentList(List<Component> componentList)
    {
        this.componentList = componentList;
    }

}
