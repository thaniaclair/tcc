/*
 * @(#)Realization.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Dec 17, 2007        descrição
 */
package documents.concepts.object_diagram;

import ocean.framework.Concept;
import ocean.smalltalk.OceanVector;
import documents.concepts.component_diagram.Component;
import documents.concepts.component_diagram.Interface;
import documents.concepts.deployment_diagram.*;
import documents.concepts.package_diagram.Package;
import documents.util.I18NProperties;

public class Realization extends Concept
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -7274733191304012817L;

    private InstanceSpecification realizatedInstance;

    private InstanceSpecification realizaterInstance;

    private Package realizatedPackage;

    private Package realizaterPackage;

    private Component realizatedComponent;

    private Component realizaterComponent;

    private Interface realizatedInterface;

    private Interface realizaterInterface;

    private Artifact realizatedArtifact;

    private Artifact realizaterArtifact;

    private DeploymentSpecification realizatedDeploy;

    private DeploymentSpecification realizaterDeploy;

    private Node realizaterNode;

    private Node realizatedNode;

    private ExecutionEnvironment realizatedExecution;

    private ExecutionEnvironment realizaterExecution;

    private DeviceNode realizatedDevice;

    private DeviceNode realizaterDevice;

    /**
     * Official constructor.
     */
    public Realization()
    {
        super();
        name(I18NProperties.getString("realization.concept.name"));
    }

    /**
     * Constructor.
     * 
     * @param aInstance
     * @param anotherInstance
     */
    public Realization(InstanceSpecification aInstance, InstanceSpecification anotherInstance)
    {
        this();
        this.realizatedInstance(aInstance);
        this.realizaterInstance(anotherInstance);
    }

    /**
     * Constructor.
     * 
     * @param superPackage
     * @param subPackage
     */
    public Realization(Package aPackage, Package anotherPackage)
    {
        this();
        this.realizatedPackage(aPackage);
        this.realizaterPackage(anotherPackage);
    }

    /**
     * Constructor.
     * 
     * @param aInterface
     * @param anotherInterface
     */
    public Realization(Interface aInterface, Interface anotherInterface)
    {
        this();
        this.realizatedInterface(aInterface);
        this.realizaterInterface(anotherInterface);
    }

    /**
     * Constructor.
     * 
     * @param aComponent
     * @param anotherComponent
     */
    public Realization(Component aComponent, Component anotherComponent)
    {
        this();
        this.realizatedComponent(aComponent);
        this.realizaterComponent(anotherComponent);
    }

    /**
     * Constructor.
     * 
     * @param aComponent
     * @param anotherComponent
     */
    public Realization(Component aComponent, Interface aInterface)
    {
        this();
        this.realizatedComponent(aComponent);
        this.realizaterInterface(aInterface);
    }

    /**
     * Constructor.
     * 
     * @param aInterface
     * @param aComponent
     */
    public Realization(Interface aInterface, Component aComponent)
    {
        this();
        this.realizatedInterface(aInterface);
        this.realizaterComponent(aComponent);
    }

    /**
     * Constructor.
     * 
     * @param aArtifact
     * @param anotherArtifact
     */
    public Realization(Artifact aArtifact, Artifact anotherArtifact)
    {
        this();
        this.realizatedArtifact(aArtifact);
        this.realizaterArtifact(anotherArtifact);
    }

    /**
     * Constructor.
     * 
     * @param aDeploy
     * @param anotherDeploy
     */
    public Realization(DeploymentSpecification aDeploy, DeploymentSpecification anotherDeploy)
    {
        this();
        this.realizatedDeploy(aDeploy);
        this.realizaterDeploy(anotherDeploy);
    }

    /**
     * Constructor.
     * 
     * @param aDeploy
     * @param aArtifact
     */
    public Realization(DeploymentSpecification aDeploy, Artifact aArtifact)
    {
        this();
        this.realizatedDeploy(aDeploy);
        this.realizaterArtifact(aArtifact);
    }

    /**
     * Constructor.
     * 
     * @param aArtifact
     * @param aDeploy
     */
    public Realization(Artifact aArtifact, DeploymentSpecification aDeploy)
    {
        this();
        this.realizatedArtifact(aArtifact);
        this.realizaterDeploy(aDeploy);
    }

    /**
     * @param node
     * @param component
     */
    public Realization(Node node, Component component)
    {
        this();
        this.realizaterNode(node);
        this.realizatedComponent(component);
    }

    /**
     * @param component
     * @param node
     */
    public Realization(Component component, Node node)
    {
        this();
        this.realizaterComponent(component);
        this.realizatedNode(node);
    }

    /**
     * @param node
     * @param interface
     */
    public Realization(Node node, Interface interface1)
    {
        this();
        this.realizaterNode(node);
        this.realizatedInterface(interface1);
    }

    /**
     * @param interface1
     * @param node
     */
    public Realization(Interface interface1, Node node)
    {
        this();
        this.realizaterInterface(interface1);
        this.realizatedNode(node);
    }

    /**
     * @param node
     * @param artifact
     */
    public Realization(Node node, Artifact artifact)
    {
        this();
        this.realizaterNode(node);
        this.realizatedArtifact(artifact);
    }

    /**
     * @param artifact
     * @param node
     */
    public Realization(Artifact artifact, Node node)
    {
        this();
        this.realizaterArtifact(artifact);
        this.realizatedNode(node);
    }

    /**
     * @param node
     * @param interface
     */
    public Realization(Node node, ExecutionEnvironment execution)
    {
        this();
        this.realizaterNode(node);
        this.realizatedExecution(execution);
    }

    /**
     * @param execution
     * @param node
     */
    public Realization(ExecutionEnvironment execution, Node node)
    {
        this();
        this.realizaterExecution(execution);
        this.realizatedNode(node);
    }

    /**
     * @param node
     * @param artifact
     */
    public Realization(Node node, DeviceNode device)
    {
        this();
        this.realizaterNode(node);
        this.realizatedDevice(device);
    }

    /**
     * @param device
     * @param node
     */
    public Realization(DeviceNode device, Node node)
    {
        this();
        this.realizaterDevice(device);
        this.realizatedNode(node);
    }

    /**
     * @param node
     * @param dep
     */
    public Realization(Node node, DeploymentSpecification dep)
    {
        this();
        this.realizaterNode(node);
        this.realizatedDeploy(dep);
    }

    /**
     * @param dep
     * @param node
     */
    public Realization(DeploymentSpecification dep, Node node)
    {
        this();
        this.realizaterDeploy(dep);
        this.realizatedNode(node);
    }

    /**
     * @param artifact
     * @param device
     */
    public Realization(Artifact artifact, DeviceNode device)
    {
        this();
        this.realizaterArtifact(artifact);
        this.realizatedDevice(device);
    }

    /**
     * @param device
     * @param artifact
     */
    public Realization(DeviceNode device, Artifact artifact)
    {
        this();
        this.realizaterDevice(device);
        this.realizatedArtifact(artifact);
    }

    /**
     * @param artifact
     * @param execution
     */
    public Realization(Artifact artifact, ExecutionEnvironment execution)
    {
        this();
        this.realizaterArtifact(artifact);
        this.realizatedExecution(execution);
    }

    /**
     * @param execution
     * @param artifact
     */
    public Realization(ExecutionEnvironment execution, Artifact artifact)
    {
        this();
        this.realizaterExecution(execution);
        this.realizatedArtifact(artifact);
    }

    /**
     * @param artifact
     * @param component
     */
    public Realization(Artifact artifact, Component component)
    {
        this();
        this.realizaterArtifact(artifact);
        this.realizatedComponent(component);
    }

    /**
     * @param component
     * @param artifact
     */
    public Realization(Component component, Artifact artifact)
    {
        this();
        this.realizaterComponent(component);
        this.realizatedArtifact(artifact);
    }

    /**
     * @param artifact
     * @param interface1
     */
    public Realization(Artifact artifact, Interface interface1)
    {
        this();
        this.realizaterArtifact(artifact);
        this.realizatedInterface(interface1);
    }

    /**
     * @param device
     * @param execution
     */
    public Realization(DeviceNode device, ExecutionEnvironment execution)
    {
        this();
        this.realizaterDevice(device);
        this.realizatedExecution(execution);
    }

    /**
     * @param execution
     * @param device
     */
    public Realization(ExecutionEnvironment execution, DeviceNode device)
    {
        this();
        this.realizaterExecution(execution);
        this.realizatedDevice(device);
    }

    /**
     * @param device
     * @param deploy
     */
    public Realization(DeviceNode device, DeploymentSpecification deploy)
    {
        this();
        this.realizaterDevice(device);
        this.realizatedDeploy(deploy);
    }

    /**
     * @param deploy
     * @param device
     */
    public Realization(DeploymentSpecification deploy, DeviceNode device)
    {
        this();
        this.realizaterDeploy(deploy);
        this.realizatedDevice(device);
    }

    /**
     * @param device
     * @param component
     */
    public Realization(DeviceNode device, Component component)
    {
        this();
        this.realizaterDevice(device);
        this.realizatedComponent(component);
    }

    /**
     * @param component
     * @param device
     */
    public Realization(Component component, DeviceNode device)
    {
        this();
        this.realizaterComponent(component);
        this.realizatedDevice(device);
    }

    /**
     * @param device
     * @param interface1
     */
    public Realization(DeviceNode device, Interface interface1)
    {
        this();
        this.realizaterDevice(device);
        this.realizatedInterface(interface1);
    }

    /**
     * @param interface1
     * @param device
     */
    public Realization(Interface interface1, DeviceNode device)
    {
        this();
        this.realizaterInterface(interface1);
        this.realizatedDevice(device);
    }

    /**
     * @param execution
     * @param deploy
     */
    public Realization(ExecutionEnvironment execution, DeploymentSpecification deploy)
    {
        this();
        this.realizaterExecution(execution);
        this.realizatedDeploy(deploy);
    }

    /**
     * @param deploy
     * @param execution
     */
    public Realization(DeploymentSpecification deploy, ExecutionEnvironment execution)
    {
        this();
        this.realizaterDeploy(deploy);
        this.realizatedExecution(execution);
    }

    /**
     * @param execution
     * @param component
     */
    public Realization(ExecutionEnvironment execution, Component component)
    {
        this();
        this.realizaterExecution(execution);
        this.realizatedComponent(component);
    }

    /**
     * @param component
     * @param execution
     */
    public Realization(Component component, ExecutionEnvironment execution)
    {
        this();
        this.realizaterComponent(component);
        this.realizatedExecution(execution);
    }

    /**
     * @param execution
     * @param interface1
     */
    public Realization(ExecutionEnvironment execution, Interface interface1)
    {
        this();
        this.realizaterExecution(execution);
        this.realizatedInterface(interface1);
    }

    /**
     * @param interface1
     * @param execution
     */
    public Realization(Interface interface1, ExecutionEnvironment execution)
    {
        this();
        this.realizaterInterface(interface1);
        this.realizatedExecution(execution);
    }

    /**
     * @param deploy
     * @param component
     */
    public Realization(DeploymentSpecification deploy, Component component)
    {
        this();
        this.realizaterDeploy(deploy);
        this.realizatedComponent(component);
    }

    /**
     * @param component
     * @param deploy
     */
    public Realization(Component component, DeploymentSpecification deploy)
    {
        this();
        this.realizaterComponent(component);
        this.realizatedDeploy(deploy);
    }

    /**
     * @param deploy
     * @param interface1
     */
    public Realization(DeploymentSpecification deploy, Interface interface1)
    {
        this();
        this.realizaterDeploy(deploy);
        this.realizatedInterface(interface1);
    }

    /**
     * @param interface1
     * @param deploy
     */
    public Realization(Interface interface1, DeploymentSpecification deploy)
    {
        this();
        this.realizaterInterface(interface1);
        this.realizatedDeploy(deploy);
    }

    /**
     * @param interface1
     * @param artifact
     */
    public Realization(Interface interface1, Artifact artifact)
    {
        this();
        this.realizaterInterface(interface1);
        this.realizatedArtifact(artifact);
    }

    /**
     * @param node
     */
    public void realizatedDevice(DeviceNode node)
    {
        this.realizatedDevice = node;
    }

    /**
     * @param node
     */
    public void realizaterDevice(DeviceNode node)
    {
        this.realizaterDevice = node;
    }

    /**
     * @param node
     */
    public void realizatedExecution(ExecutionEnvironment exe)
    {
        this.realizatedExecution = exe;
    }

    /**
     * @param node
     */
    public void realizaterExecution(ExecutionEnvironment exe)
    {
        this.realizaterExecution = exe;
    }

    /**
     * @param node
     */
    public void realizaterNode(Node node)
    {
        this.realizaterNode = node;
    }

    /**
     * @param node
     */
    public void realizatedNode(Node node)
    {
        this.realizatedNode = node;
    }

    /**
     * @param anotherDeploy
     */
    public void realizaterDeploy(DeploymentSpecification anotherDeploy)
    {
        this.realizaterDeploy = anotherDeploy;
    }

    /**
     * @param deploy
     */
    public void realizatedDeploy(DeploymentSpecification deploy)
    {
        this.realizatedDeploy = deploy;
    }

    /**
     * @param anotherArtifact
     */
    public void realizaterArtifact(Artifact anotherArtifact)
    {
        this.realizaterArtifact = anotherArtifact;
    }

    /**
     * @param artifact
     */
    public void realizatedArtifact(Artifact artifact)
    {
        this.realizatedArtifact = artifact;
    }

    /**
     * @param anotherComponent
     */
    public void realizaterComponent(Component anotherComponent)
    {
        this.realizaterComponent = anotherComponent;
    }

    /**
     * @param component
     */
    public void realizatedComponent(Component component)
    {
        this.realizatedComponent = component;
    }

    /**
     * @param anotherInterface
     */
    public void realizaterInterface(Interface anotherInterface)
    {
        this.realizaterInterface = anotherInterface;
    }

    /**
     * @param interface1
     */
    public void realizatedInterface(Interface interface1)
    {
        this.realizaterInterface = interface1;
    }

    /**
     * @return
     */
    public Package realizatedPackage()
    {
        return this.realizatedPackage;
    }

    /**
     * @return
     */
    public Package realizaterPackage()
    {
        return this.realizaterPackage;
    }

    /**
     * @param aPackage
     */
    public void realizatedPackage(Package aPackage)
    {
        this.realizatedPackage = aPackage;
    }

    /**
     * @param aPackage
     */
    public void realizaterPackage(Package aPackage)
    {
        this.realizaterPackage = aPackage;
    }

    /**
     * @param instance
     */
    public void realizaterInstance(InstanceSpecification instance)
    {
        this.realizaterInstance = instance;
    }

    /**
     * @param instance
     */
    public void realizatedInstance(InstanceSpecification instance)
    {
        this.realizatedInstance = instance;
    }

    /**
     * @return
     */
    public InstanceSpecification realizatedInstance()
    {
        return realizatedInstance;
    }

    /**
     * @return
     */
    public InstanceSpecification realizaterInstance()
    {
        return realizaterInstance;
    }

    /**
     * @return
     */
    public Component realizatedComponent()
    {
        return this.realizatedComponent;
    }

    /**
     * @return
     */
    public Component realizaterComponent()
    {
        return this.realizaterComponent;
    }

    /**
     * @return
     */
    public Interface realizatedInterface()
    {
        return this.realizatedInterface;
    }

    /**
     * @return
     */
    public Interface realizaterInterface()
    {
        return this.realizaterInterface;
    }

    /**
     * @return
     */
    public Artifact realizatedArtifact()
    {
        return this.realizatedArtifact;
    }

    /**
     * @return
     */
    public Artifact realizaterArtifact()
    {
        return this.realizaterArtifact;
    }

    /**
     * @return
     */
    public DeploymentSpecification realizatedDeploy()
    {
        return this.realizatedDeploy;
    }

    /**
     * @return
     */
    public DeploymentSpecification realizaterDeploy()
    {
        return this.realizaterDeploy;
    }

    /**
     * @return
     */
    public Node realizaterNode()
    {
        return this.realizaterNode;
    }

    /**
     * @return
     */
    public Node realizatedNode()
    {
        return this.realizatedNode;
    }

    /**
     * @return
     */
    public DeviceNode realizatedDevice()
    {
        return this.realizatedDevice;
    }

    /**
     * @return
     */
    public DeviceNode realizaterDevice()
    {
        return this.realizaterDevice;
    }

    /**
     * @return
     */
    public ExecutionEnvironment realizatedExecution()
    {
        return this.realizatedExecution;
    }

    /**
     * @return
     */
    public ExecutionEnvironment realizaterExecution()
    {
        return this.realizaterExecution;
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
        auxList.add(this.realizaterInstance());
        auxList.add(this.realizatedInstance());
        auxList.add(this.realizaterPackage());
        auxList.add(this.realizatedPackage());
        auxList.add(this.realizaterInterface());
        auxList.add(this.realizatedInterface());
        auxList.add(this.realizaterComponent());
        auxList.add(this.realizatedComponent());
        auxList.add(this.realizaterArtifact());
        auxList.add(this.realizatedArtifact());
        auxList.add(this.realizaterDeploy());
        auxList.add(this.realizatedDeploy());
        auxList.add(this.realizaterNode());
        auxList.add(this.realizatedNode());
        auxList.add(this.realizaterDevice());
        auxList.add(this.realizatedDevice());
        auxList.add(this.realizaterExecution());
        auxList.add(this.realizatedExecution());
        return auxList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#conceptName()
     */
    public String conceptName()
    {
        return I18NProperties.getString("realization.concept.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("realization.concept.name.for.tree") + name();
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

}
