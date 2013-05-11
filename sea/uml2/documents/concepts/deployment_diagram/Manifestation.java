/*
 * @(#)Manifestation.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Jan 24, 2008        descrição
 */
package documents.concepts.deployment_diagram;

import ocean.framework.Concept;
import ocean.smalltalk.OceanVector;
import documents.concepts.component_diagram.Component;
import documents.concepts.component_diagram.Interface;
import documents.util.I18NProperties;

public class Manifestation extends Concept
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 5092050498756548997L;

    Artifact manifestedArtifact;

    Artifact manifesterArtifact;

    DeploymentSpecification manifesterDeploy;

    DeploymentSpecification manifestedDeploy;

    Component manifestedComponent;

    Component manifesterComponent;

    Interface manifestedInterface;

    Interface manifesterInterface;

    Node manifesterNode;

    Node manifestedNode;

    DeviceNode manifesterDevice;

    DeviceNode manifestedDevice;

    ExecutionEnvironment manifesterExecution;

    ExecutionEnvironment manifestedExecution;

    /**
     * Constructor.
     */
    public Manifestation()
    {
        super();
        name(I18NProperties.getString("manifestation.concept.name"));
    }

    /**
     * Constructor.
     * 
     * @param aArtifact
     * @param anotherArtifact
     */
    public Manifestation(Artifact aArtifact, Artifact anotherArtifact)
    {
        this();
        this.manifestedArtifact(aArtifact);
        this.manifesterArtifact(anotherArtifact);
    }

    /**
     * Constructor.
     * 
     * @param aArtifact
     * @param anotherArtifact
     */
    public Manifestation(DeploymentSpecification deploy, DeploymentSpecification anotherDeploy)
    {
        this();
        this.manifestedDeploy(deploy);
        this.manifesterDeploy(anotherDeploy);
    }

    /**
     * Constructor.
     * 
     * @param aArtifact
     * @param deploy
     */
    public Manifestation(Artifact aArtifact, DeploymentSpecification deploy)
    {
        this();
        this.manifestedArtifact(aArtifact);
        this.manifesterDeploy(deploy);
    }

    /**
     * Constructor.
     * 
     * @param deploy
     * @param aArtifact
     */
    public Manifestation(DeploymentSpecification deploy, Artifact aArtifact)
    {
        this();
        this.manifestedDeploy(deploy);
        this.manifesterArtifact(aArtifact);
    }

    /**
     * @param node
     * @param node2
     */
    public Manifestation(Node node, Node node2)
    {
        this();
        this.manifesterNode(node);
        this.manifestedNode(node2);
    }

    /**
     * @param node
     * @param device
     */
    public Manifestation(Node node, DeviceNode device)
    {
        this();
        this.manifesterNode(node);
        this.manifestedDevice(device);
    }

    /**
     * @param device
     * @param node
     */
    public Manifestation(DeviceNode device, Node node)
    {
        this();
        this.manifesterDevice(device);
        this.manifestedNode(node);
    }

    /**
     * @param node
     * @param execution
     */
    public Manifestation(Node node, ExecutionEnvironment execution)
    {
        this();
        this.manifesterNode(node);
        this.manifestedExecution(execution);
    }

    /**
     * @param execution
     * @param node
     */
    public Manifestation(ExecutionEnvironment execution, Node node)
    {
        this();
        this.manifesterExecution(execution);
        this.manifestedNode(node);
    }

    /**
     * @param node
     * @param component
     */
    public Manifestation(Node node, Component component)
    {
        this();
        this.manifesterNode(node);
        this.manifestedComponent(component);
    }

    /**
     * @param component
     * @param node
     */
    public Manifestation(Component component, Node node)
    {
        this();
        this.manifesterComponent(component);
        this.manifestedNode(node);
    }

    /**
     * @param node
     * @param interface
     */
    public Manifestation(Node node, Interface interface1)
    {
        this();
        this.manifesterNode(node);
        this.manifestedInterface(interface1);
    }

    /**
     * @param interface1
     * @param node
     */
    public Manifestation(Interface interface1, Node node)
    {
        this();
        this.manifesterInterface(interface1);
        this.manifestedNode(node);
    }

    /**
     * @param node
     * @param artifact
     */
    public Manifestation(Node node, Artifact artifact)
    {
        this();
        this.manifesterNode(node);
        this.manifestedArtifact(artifact);
    }

    /**
     * @param artifact
     * @param node
     */
    public Manifestation(Artifact artifact, Node node)
    {
        this();
        this.manifesterArtifact(artifact);
        this.manifestedNode(node);
    }

    /**
     * @param node
     * @param dep
     */
    public Manifestation(Node node, DeploymentSpecification dep)
    {
        this();
        this.manifesterNode(node);
        this.manifestedDeploy(dep);
    }

    /**
     * @param dep
     * @param node
     */
    public Manifestation(DeploymentSpecification dep, Node node)
    {
        this();
        this.manifesterDeploy(dep);
        this.manifestedNode(node);
    }

    /**
     * @param artifact
     * @param device
     */
    public Manifestation(Artifact artifact, DeviceNode device)
    {
        this();
        this.manifesterArtifact(artifact);
        this.manifestedDevice(device);
    }

    /**
     * @param device
     * @param artifact
     */
    public Manifestation(DeviceNode device, Artifact artifact)
    {
        this();
        this.manifesterDevice(device);
        this.manifestedArtifact(artifact);
    }

    /**
     * @param artifact
     * @param execution
     */
    public Manifestation(Artifact artifact, ExecutionEnvironment execution)
    {
        this();
        this.manifesterArtifact(artifact);
        this.manifestedExecution(execution);
    }

    /**
     * @param execution
     * @param artifact
     */
    public Manifestation(ExecutionEnvironment execution, Artifact artifact)
    {
        this();
        this.manifesterExecution(execution);
        this.manifestedArtifact(artifact);
    }

    /**
     * @param artifact
     * @param component
     */
    public Manifestation(Artifact artifact, Component component)
    {
        this();
        this.manifesterArtifact(artifact);
        this.manifestedComponent(component);
    }

    /**
     * @param component
     * @param artifact
     */
    public Manifestation(Component component, Artifact artifact)
    {
        this();
        this.manifesterComponent(component);
        this.manifestedArtifact(artifact);
    }

    /**
     * @param artifact
     * @param interface1
     */
    public Manifestation(Artifact artifact, Interface interface1)
    {
        this();
        this.manifesterArtifact(artifact);
        this.manifestedInterface(interface1);
    }

    /**
     * @param interface1
     * @param artifact
     */
    public Manifestation(Interface interface1, Artifact artifact)
    {
        this();
        this.manifesterInterface(interface1);
        this.manifestedArtifact(artifact);
    }

    /**
     * @param device
     * @param execution
     */
    public Manifestation(DeviceNode device, ExecutionEnvironment execution)
    {
        this();
        this.manifesterDevice(device);
        this.manifestedExecution(execution);
    }

    /**
     * @param execution
     * @param device
     */
    public Manifestation(ExecutionEnvironment execution, DeviceNode device)
    {
        this();
        this.manifesterExecution(execution);
        this.manifestedDevice(device);
    }

    /**
     * @param device
     * @param deploy
     */
    public Manifestation(DeviceNode device, DeploymentSpecification deploy)
    {
        this();
        this.manifesterDevice(device);
        this.manifestedDeploy(deploy);
    }

    /**
     * @param deploy
     * @param device
     */
    public Manifestation(DeploymentSpecification deploy, DeviceNode device)
    {
        this();
        this.manifesterDeploy(deploy);
        this.manifestedDevice(device);
    }

    /**
     * @param device
     * @param component
     */
    public Manifestation(DeviceNode device, Component component)
    {
        this();
        this.manifesterDevice(device);
        this.manifestedComponent(component);
    }

    /**
     * @param component
     * @param device
     */
    public Manifestation(Component component, DeviceNode device)
    {
        this();
        this.manifesterComponent(component);
        this.manifestedDevice(device);
    }

    /**
     * @param device
     * @param interface1
     */
    public Manifestation(DeviceNode device, Interface interface1)
    {
        this();
        this.manifesterDevice(device);
        this.manifestedInterface(interface1);
    }

    /**
     * @param interface1
     * @param device
     */
    public Manifestation(Interface interface1, DeviceNode device)
    {
        this();
        this.manifesterInterface(interface1);
        this.manifestedDevice(device);
    }

    /**
     * @param execution
     * @param deploy
     */
    public Manifestation(ExecutionEnvironment execution, DeploymentSpecification deploy)
    {
        this();
        this.manifesterExecution(execution);
        this.manifestedDeploy(deploy);
    }

    /**
     * @param deploy
     * @param execution
     */
    public Manifestation(DeploymentSpecification deploy, ExecutionEnvironment execution)
    {
        this();
        this.manifesterDeploy(deploy);
        this.manifestedExecution(execution);
    }

    /**
     * @param execution
     * @param component
     */
    public Manifestation(ExecutionEnvironment execution, Component component)
    {
        this();
        this.manifesterExecution(execution);
        this.manifestedComponent(component);
    }

    /**
     * @param component
     * @param execution
     */
    public Manifestation(Component component, ExecutionEnvironment execution)
    {
        this();
        this.manifesterComponent(component);
        this.manifestedExecution(execution);
    }

    /**
     * @param execution
     * @param interface1
     */
    public Manifestation(ExecutionEnvironment execution, Interface interface1)
    {
        this();
        this.manifesterExecution(execution);
        this.manifestedInterface(interface1);
    }

    /**
     * @param interface1
     * @param execution
     */
    public Manifestation(Interface interface1, ExecutionEnvironment execution)
    {
        this();
        this.manifesterInterface(interface1);
        this.manifestedExecution(execution);
    }

    /**
     * @param deploy
     * @param component
     */
    public Manifestation(DeploymentSpecification deploy, Component component)
    {
        this();
        this.manifesterDeploy(deploy);
        this.manifestedComponent(component);
    }

    /**
     * @param component
     * @param deploy
     */
    public Manifestation(Component component, DeploymentSpecification deploy)
    {
        this();
        this.manifesterComponent(component);
        this.manifestedDeploy(deploy);
    }

    /**
     * @param deploy
     * @param interface1
     */
    public Manifestation(DeploymentSpecification deploy, Interface interface1)
    {
        this();
        this.manifesterDeploy(deploy);
        this.manifestedInterface(interface1);
    }

    /**
     * @param interface1
     * @param deploy
     */
    public Manifestation(Interface interface1, DeploymentSpecification deploy)
    {
        this();
        this.manifesterInterface(interface1);
        this.manifestedDeploy(deploy);
    }

    /**
     * @param node
     */
    public void manifesterNode(Node node)
    {
        this.manifesterNode = node;
    }

    /**
     * @param node
     */
    public void manifestedNode(Node node)
    {
        this.manifestedNode = node;
    }

    /**
     * @param device
     */
    public void manifesterDevice(DeviceNode device)
    {
        this.manifesterDevice = device;
    }

    /**
     * @param device
     */
    public void manifestedDevice(DeviceNode device)
    {
        this.manifestedDevice = device;
    }

    /**
     * @param execution
     */
    public void manifesterExecution(ExecutionEnvironment execution)
    {
        this.manifesterExecution = execution;
    }

    /**
     * @param execution
     */
    public void manifestedExecution(ExecutionEnvironment execution)
    {
        this.manifestedExecution = execution;
    }

    /**
     * @param interface2
     */
    public void manifestedInterface(Interface aInterface)
    {
        this.manifestedInterface = aInterface;
    }

    /**
     * @param interface1
     */
    public void manifesterInterface(Interface aInterface)
    {
        this.manifesterInterface = aInterface;
    }

    /**
     * @param anotherComponent
     */
    public void manifestedComponent(Component anotherComponent)
    {
        this.manifestedComponent = anotherComponent;
    }

    /**
     * @param component
     */
    public void manifesterComponent(Component component)
    {
        this.manifesterComponent = component;
    }

    /**
     * @param anotherDeploy
     */
    public void manifesterDeploy(DeploymentSpecification anotherDeploy)
    {
        this.manifesterDeploy = anotherDeploy;
    }

    /**
     * @param deploy
     */
    public void manifestedDeploy(DeploymentSpecification deploy)
    {
        this.manifestedDeploy = deploy;
    }

    /**
     * @param anotherArtifact
     */
    public void manifestedArtifact(Artifact anotherArtifact)
    {
        this.manifestedArtifact = anotherArtifact;
    }

    /**
     * @param artifact
     */
    public void manifesterArtifact(Artifact artifact)
    {
        this.manifesterArtifact = artifact;
    }

    /**
     * @return
     */
    public Artifact manifesterArtifact()
    {
        return this.manifesterArtifact;
    }

    /**
     * @return
     */
    public Artifact manifestedArtifact()
    {
        return this.manifestedArtifact;
    }

    /**
     * @return
     */
    public DeploymentSpecification manifesterDeploy()
    {
        return this.manifesterDeploy;
    }

    /**
     * @return
     */
    public DeploymentSpecification manifestedDeploy()
    {
        return this.manifestedDeploy;
    }

    /**
     * @return
     */
    public ExecutionEnvironment manifesterExecution()
    {
        return this.manifesterExecution;
    }

    /**
     * @return
     */
    public ExecutionEnvironment manifestedExecution()
    {
        return this.manifestedExecution;
    }

    /**
     * @return
     */
    public DeviceNode manifesterDevice()
    {
        return this.manifesterDevice;
    }

    /**
     * @return
     */
    public DeviceNode manifestedDevice()
    {
        return this.manifestedDevice;
    }

    /**
     * @return
     */
    public Node manifesterNode()
    {
        return this.manifesterNode;
    }

    /**
     * @return
     */
    public Node manifestedNode()
    {
        return this.manifestedNode;
    }

    /**
     * @return
     */
    public Interface manifesterInterface()
    {
        return this.manifesterInterface;
    }

    /**
     * @return
     */
    public Interface manifestedInterface()
    {
        return this.manifestedInterface;
    }

    /**
     * @return
     */
    public Component manifesterComponent()
    {
        return this.manifesterComponent;
    }

    /**
     * @return
     */
    public Component manifestedComponent()
    {
        return this.manifestedComponent;
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
        auxList.add(this.manifestedArtifact());
        auxList.add(this.manifesterArtifact());
        auxList.add(this.manifestedDeploy());
        auxList.add(this.manifesterDeploy());
        auxList.add(this.manifesterInterface());
        auxList.add(this.manifestedInterface());
        auxList.add(this.manifesterComponent());
        auxList.add(this.manifestedComponent());
        auxList.add(this.manifesterNode());
        auxList.add(this.manifestedNode());
        auxList.add(this.manifesterDevice());
        auxList.add(this.manifestedDevice());
        auxList.add(this.manifesterExecution());
        auxList.add(this.manifestedExecution());
        return auxList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#conceptName()
     */
    public String conceptName()
    {
        return I18NProperties.getString("manifestation.concept.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("manifestation.concept.name.for.tree");
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
        return I18NProperties.getString("manifestation.concept.name");
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
