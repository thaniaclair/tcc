/*
 * @(#)Deployment.java
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

public class Deployment extends Concept
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 1329096864188592714L;

    Artifact deployedArtifact;

    Artifact deployerArtifact;

    DeploymentSpecification deployedDeploySpec;

    DeploymentSpecification deployerDeploySpec;

    Component deployedComponent;

    Component deployerComponent;

    Interface deployedInterface;

    Interface deployerInterface;

    Node deployerNode;

    Node deployedNode;

    DeviceNode deployerDevice;

    DeviceNode deployedDevice;

    ExecutionEnvironment deployerExecution;

    ExecutionEnvironment deployedExecution;

    /**
     * Constructor.
     */
    public Deployment()
    {
        super();
        name(I18NProperties.getString("deployment.concept.name"));
    }

    /**
     * Constructor.
     * 
     * @param aArtifact
     * @param anotherArtifact
     */
    public Deployment(Artifact aArtifact, Artifact anotherArtifact)
    {
        this();
        this.deployedArtifact(aArtifact);
        this.deployerArtifact(anotherArtifact);
    }

    /**
     * Constructor.
     * 
     * @param aArtifact
     * @param anotherArtifact
     */
    public Deployment(DeploymentSpecification deployedDeploySpec,
                      DeploymentSpecification deployerDeploySpec)
    {
        this();
        this.deployedDeploySpec(deployedDeploySpec);
        this.deployerDeploySpec(deployerDeploySpec);
    }

    /**
     * Constructor.
     * 
     * @param deployedDeploySpec
     * @param aArtifact
     */
    public Deployment(DeploymentSpecification deployedDeploySpec, Artifact aArtifact)
    {
        this();
        this.deployedDeploySpec(deployedDeploySpec);
        this.deployerArtifact(aArtifact);
    }

    /**
     * Constructor.
     * 
     * @param aArtifact
     * @param deployerDeploySpec
     */
    public Deployment(Artifact aArtifact, DeploymentSpecification deployerDeploySpec)
    {
        this();
        this.deployedArtifact(aArtifact);
        this.deployerDeploySpec(deployerDeploySpec);
    }

    /**
     * @param node
     * @param node2
     */
    public Deployment(Node node, Node node2)
    {
        this();
        this.deployerNode(node);
        this.deployedNode(node2);
    }

    /**
     * @param node
     * @param device
     */
    public Deployment(Node node, DeviceNode device)
    {
        this();
        this.deployerNode(node);
        this.deployedDevice(device);
    }

    /**
     * @param device
     * @param node
     */
    public Deployment(DeviceNode device, Node node)
    {
        this();
        this.deployerDevice(device);
        this.deployedNode(node);
    }

    /**
     * @param node
     * @param execution
     */
    public Deployment(Node node, ExecutionEnvironment execution)
    {
        this();
        this.deployerNode(node);
        this.deployedExecution(execution);
    }

    /**
     * @param execution
     * @param node
     */
    public Deployment(ExecutionEnvironment execution, Node node)
    {
        this();
        this.deployerExecution(execution);
        this.deployedNode(node);
    }

    /**
     * @param node
     * @param component
     */
    public Deployment(Node node, Component component)
    {
        this();
        this.deployerNode(node);
        this.deployedComponent(component);
    }

    /**
     * @param component
     * @param node
     */
    public Deployment(Component component, Node node)
    {
        this();
        this.deployerComponent(component);
        this.deployedNode(node);
    }

    /**
     * @param node
     * @param interface
     */
    public Deployment(Node node, Interface interface1)
    {
        this();
        this.deployerNode(node);
        this.deployedInterface(interface1);
    }

    /**
     * @param interface1
     * @param node
     */
    public Deployment(Interface interface1, Node node)
    {
        this();
        this.deployerInterface(interface1);
        this.deployedNode(node);
    }

    /**
     * @param node
     * @param artifact
     */
    public Deployment(Node node, Artifact artifact)
    {
        this();
        this.deployerNode(node);
        this.deployedArtifact(artifact);
    }

    /**
     * @param artifact
     * @param node
     */
    public Deployment(Artifact artifact, Node node)
    {
        this();
        this.deployerArtifact(artifact);
        this.deployedNode(node);
    }

    /**
     * @param node
     * @param dep
     */
    public Deployment(Node node, DeploymentSpecification dep)
    {
        this();
        this.deployerNode(node);
        this.deployedDeploySpec(dep);
    }

    /**
     * @param dep
     * @param node
     */
    public Deployment(DeploymentSpecification dep, Node node)
    {
        this();
        this.deployerDeploySpec(dep);
        this.deployedNode(node);
    }

    /**
     * @param artifact
     * @param device
     */
    public Deployment(Artifact artifact, DeviceNode device)
    {
        this();
        this.deployerArtifact(artifact);
        this.deployedDevice(device);
    }

    /**
     * @param device
     * @param artifact
     */
    public Deployment(DeviceNode device, Artifact artifact)
    {
        this();
        this.deployerDevice(device);
        this.deployedArtifact(artifact);
    }

    /**
     * @param artifact
     * @param execution
     */
    public Deployment(Artifact artifact, ExecutionEnvironment execution)
    {
        this();
        this.deployerArtifact(artifact);
        this.deployedExecution(execution);
    }

    /**
     * @param execution
     * @param artifact
     */
    public Deployment(ExecutionEnvironment execution, Artifact artifact)
    {
        this();
        this.deployerExecution(execution);
        this.deployedArtifact(artifact);
    }

    /**
     * @param artifact
     * @param component
     */
    public Deployment(Artifact artifact, Component component)
    {
        this();
        this.deployerArtifact(artifact);
        this.deployedComponent(component);
    }

    /**
     * @param component
     * @param artifact
     */
    public Deployment(Component component, Artifact artifact)
    {
        this();
        this.deployerComponent(component);
        this.deployedArtifact(artifact);
    }

    /**
     * @param artifact
     * @param interface1
     */
    public Deployment(Artifact artifact, Interface interface1)
    {
        this();
        this.deployerArtifact(artifact);
        this.deployedInterface(interface1);
    }

    /**
     * @param interface1
     * @param artifact
     */
    public Deployment(Interface interface1, Artifact artifact)
    {
        this();
        this.deployerInterface(interface1);
        this.deployedArtifact(artifact);
    }

    /**
     * @param device
     * @param execution
     */
    public Deployment(DeviceNode device, ExecutionEnvironment execution)
    {
        this();
        this.deployerDevice(device);
        this.deployedExecution(execution);
    }

    /**
     * @param execution
     * @param device
     */
    public Deployment(ExecutionEnvironment execution, DeviceNode device)
    {
        this();
        this.deployerExecution(execution);
        this.deployedDevice(device);
    }

    /**
     * @param device
     * @param deploy
     */
    public Deployment(DeviceNode device, DeploymentSpecification deploy)
    {
        this();
        this.deployerDevice(device);
        this.deployedDeploySpec(deploy);
    }

    /**
     * @param deploy
     * @param device
     */
    public Deployment(DeploymentSpecification deploy, DeviceNode device)
    {
        this();
        this.deployerDeploySpec(deploy);
        this.deployedDevice(device);
    }

    /**
     * @param device
     * @param component
     */
    public Deployment(DeviceNode device, Component component)
    {
        this();
        this.deployerDevice(device);
        this.deployedComponent(component);
    }

    /**
     * @param component
     * @param device
     */
    public Deployment(Component component, DeviceNode device)
    {
        this();
        this.deployerComponent(component);
        this.deployedDevice(device);
    }

    /**
     * @param device
     * @param interface1
     */
    public Deployment(DeviceNode device, Interface interface1)
    {
        this();
        this.deployerDevice(device);
        this.deployedInterface(interface1);
    }

    /**
     * @param interface1
     * @param device
     */
    public Deployment(Interface interface1, DeviceNode device)
    {
        this();
        this.deployerInterface(interface1);
        this.deployedDevice(device);
    }

    /**
     * @param execution
     * @param deploy
     */
    public Deployment(ExecutionEnvironment execution, DeploymentSpecification deploy)
    {
        this();
        this.deployerExecution(execution);
        this.deployedDeploySpec(deploy);
    }

    /**
     * @param deploy
     * @param execution
     */
    public Deployment(DeploymentSpecification deploy, ExecutionEnvironment execution)
    {
        this();
        this.deployerDeploySpec(deploy);
        this.deployedExecution(execution);
    }

    /**
     * @param execution
     * @param component
     */
    public Deployment(ExecutionEnvironment execution, Component component)
    {
        this();
        this.deployerExecution(execution);
        this.deployedComponent(component);
    }

    /**
     * @param component
     * @param execution
     */
    public Deployment(Component component, ExecutionEnvironment execution)
    {
        this();
        this.deployerComponent(component);
        this.deployedExecution(execution);
    }

    /**
     * @param execution
     * @param interface1
     */
    public Deployment(ExecutionEnvironment execution, Interface interface1)
    {
        this();
        this.deployerExecution(execution);
        this.deployedInterface(interface1);
    }

    /**
     * @param interface1
     * @param execution
     */
    public Deployment(Interface interface1, ExecutionEnvironment execution)
    {
        this();
        this.deployerInterface(interface1);
        this.deployedExecution(execution);
    }

    /**
     * @param deploy
     * @param component
     */
    public Deployment(DeploymentSpecification deploy, Component component)
    {
        this();
        this.deployerDeploySpec(deploy);
        this.deployedComponent(component);
    }

    /**
     * @param component
     * @param deploy
     */
    public Deployment(Component component, DeploymentSpecification deploy)
    {
        this();
        this.deployerComponent(component);
        this.deployedDeploySpec(deploy);
    }

    /**
     * @param deploy
     * @param interface1
     */
    public Deployment(DeploymentSpecification deploy, Interface interface1)
    {
        this();
        this.deployerDeploySpec(deploy);
        this.deployedInterface(interface1);
    }

    /**
     * @param interface1
     * @param deploy
     */
    public Deployment(Interface interface1, DeploymentSpecification deploy)
    {
        this();
        this.deployerInterface(interface1);
        this.deployedDeploySpec(deploy);
    }

    /**
     * @param node
     */
    public void deployerNode(Node node)
    {
        this.deployerNode = node;
    }

    /**
     * @param node
     */
    public void deployedNode(Node node)
    {
        this.deployedNode = node;
    }

    /**
     * @param device
     */
    public void deployerDevice(DeviceNode device)
    {
        this.deployerDevice = device;
    }

    /**
     * @param device
     */
    public void deployedDevice(DeviceNode device)
    {
        this.deployedDevice = device;
    }

    /**
     * @param execution
     */
    public void deployerExecution(ExecutionEnvironment execution)
    {
        this.deployerExecution = execution;
    }

    /**
     * @param execution
     */
    public void deployedExecution(ExecutionEnvironment execution)
    {
        this.deployedExecution = execution;
    }

    /**
     * @param interface2
     */
    public void deployedInterface(Interface aInterface)
    {
        this.deployedInterface = aInterface;
    }

    /**
     * @param interface1
     */
    public void deployerInterface(Interface aInterface)
    {
        this.deployerInterface = aInterface;
    }

    /**
     * @param anotherComponent
     */
    public void deployedComponent(Component anotherComponent)
    {
        this.deployedComponent = anotherComponent;
    }

    /**
     * @param component
     */
    public void deployerComponent(Component component)
    {
        this.deployerComponent = component;
    }

    /**
     * @param deployerDeploySpec
     */
    public void deployerDeploySpec(DeploymentSpecification deployerDeploySpec)
    {
        this.deployerDeploySpec = deployerDeploySpec;
    }

    /**
     * @param deployedDeploySpec
     */
    public void deployedDeploySpec(DeploymentSpecification deployedDeploySpec)
    {
        this.deployedDeploySpec = deployedDeploySpec;
    }

    /**
     * @param anotherArtifact
     */
    public void deployedArtifact(Artifact anotherArtifact)
    {
        this.deployedArtifact = anotherArtifact;
    }

    /**
     * @param artifact
     */
    public void deployerArtifact(Artifact artifact)
    {
        this.deployerArtifact = artifact;
    }

    /**
     * @return
     */
    public Artifact deployedArtifact()
    {
        return this.deployedArtifact;
    }

    /**
     * @return
     */
    public Artifact deployerArtifact()
    {
        return this.deployerArtifact;
    }

    /**
     * @return
     */
    public DeploymentSpecification deployerDeploySpec()
    {
        return this.deployerDeploySpec;
    }

    /**
     * @return
     */
    public DeploymentSpecification deployedDeploySpec()
    {
        return this.deployedDeploySpec;
    }

    /**
     * @return
     */
    public ExecutionEnvironment deployerExecution()
    {
        return this.deployerExecution;
    }

    /**
     * @return
     */
    public ExecutionEnvironment deployedExecution()
    {
        return this.deployedExecution;
    }

    /**
     * @return
     */
    public DeviceNode deployerDevice()
    {
        return this.deployerDevice;
    }

    /**
     * @return
     */
    public DeviceNode deployedDevice()
    {
        return this.deployedDevice;
    }

    /**
     * @return
     */
    public Node deployerNode()
    {
        return this.deployerNode;
    }

    /**
     * @return
     */
    public Node deployedNode()
    {
        return this.deployedNode;
    }

    /**
     * @return
     */
    public Interface deployerInterface()
    {
        return this.deployerInterface;
    }

    /**
     * @return
     */
    public Interface deployedInterface()
    {
        return this.deployedInterface;
    }

    /**
     * @return
     */
    public Component deployerComponent()
    {
        return this.deployerComponent;
    }

    /**
     * @return
     */
    public Component deployedComponent()
    {
        return this.deployedComponent;
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
        auxList.add(this.deployedArtifact());
        auxList.add(this.deployerArtifact());
        auxList.add(this.deployedDeploySpec());
        auxList.add(this.deployerDeploySpec());
        auxList.add(this.deployerInterface());
        auxList.add(this.deployedInterface());
        auxList.add(this.deployerComponent());
        auxList.add(this.deployedComponent());
        auxList.add(this.deployerNode());
        auxList.add(this.deployedNode());
        auxList.add(this.deployerDevice());
        auxList.add(this.deployedDevice());
        auxList.add(this.deployerExecution());
        auxList.add(this.deployedExecution());
        return auxList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#conceptName()
     */
    public String conceptName()
    {
        return I18NProperties.getString("deployment.concept.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("deployment.concept.name.for.tree");
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
        return I18NProperties.getString("deployment.concept.name");
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
