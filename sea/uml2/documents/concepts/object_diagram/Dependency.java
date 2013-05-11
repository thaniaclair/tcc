/*
 * @(#)Dependency.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Dec 17, 2007        descrição
 */
package documents.concepts.object_diagram;

import javax.swing.JOptionPane;

import ocean.documents.oo.concepts.Classe;
import ocean.framework.Concept;
import ocean.smalltalk.OceanVector;
import documents.concepts.component_diagram.Component;
import documents.concepts.component_diagram.Interface;
import documents.concepts.composite_structure_diagram.Collaboration;
import documents.concepts.composite_structure_diagram.CollaborationUse;
import documents.concepts.deployment_diagram.*;
import documents.concepts.package_diagram.Package;
import documents.util.I18NProperties;

public class Dependency extends Concept
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 7527146479809933341L;

    private InstanceSpecification dependentInstance;

    private InstanceSpecification dependencyInstance;

    private Package dependentPackage;

    private Package dependencyPackage;

    private Component dependentComponent;

    private Component dependencyComponent;

    private Interface dependentInterface;

    private Interface dependencyInterface;

    private Artifact dependentArtifact;

    private Artifact dependencyArtifact;

    private DeploymentSpecification dependentDeploy;

    private DeploymentSpecification dependencyDeploy;

    private Node dependentNode;

    private Node dependencyNode;

    private DeviceNode dependentDevice;

    private DeviceNode dependencyDevice;

    private ExecutionEnvironment dependentExecution;

    private ExecutionEnvironment dependencyExecution;

    private Collaboration dependentCollaboration;

    private Collaboration dependencyCollaboration;

    private CollaborationUse dependentCollaborationUse;

    private CollaborationUse dependencyCollaborationUse;

    private Classe dependentClass;

    private Classe dependencyClass;

    /**
     * Constructor.
     */
    public Dependency()
    {
        super();
        name(I18NProperties.getString("dependency.concept.name"));
    }

    /**
     * Constructor.
     * 
     * @param aInstance
     * @param anotherInstance
     */
    public Dependency(InstanceSpecification aInstance, InstanceSpecification anotherInstance)
    {
        this();
        this.dependentInstance(aInstance);
        this.dependencyInstance(anotherInstance);
    }

    /**
     * Constructor.
     * 
     * @param aInterface
     * @param anotherInterface
     */
    public Dependency(Interface aInterface, Interface anotherInterface)
    {
        this();
        this.dependentInterface(aInterface);
        this.dependencyInterface(anotherInterface);
    }

    /**
     * Constructor.
     * 
     * @param aComponent
     * @param anotherComponent
     */
    public Dependency(Component aComponent, Component anotherComponent)
    {
        this();
        this.dependentComponent(aComponent);
        this.dependencyComponent(anotherComponent);
    }

    /**
     * Constructor.
     * 
     * @param aComponent
     * @param aInterface
     */
    public Dependency(Component aComponent, Interface aInterface)
    {
        this();
        this.dependentComponent(aComponent);
        this.dependencyInterface(aInterface);
    }

    /**
     * Constructor.
     * 
     * @param aInterface
     * @param aComponent
     */
    public Dependency(Interface aInterface, Component aComponent)
    {
        this();
        this.dependentInterface(aInterface);
        this.dependencyComponent(aComponent);
    }

    /**
     * Constructor.
     * 
     * @param aPackage
     * @param anotherPackage
     */
    public Dependency(Package aPackage, Package anotherPackage)
    {
        this();
        this.dependentPackage(aPackage);
        this.dependencyPackage(anotherPackage);
    }

    /**
     * Constructor.
     * 
     * @param aArtifact
     * @param anotherArtifact
     */
    public Dependency(Artifact aArtifact, Artifact anotherArtifact)
    {
        this();
        this.dependentArtifact(aArtifact);
        this.dependencyArtifact(anotherArtifact);
    }

    /**
     * Constructor.
     * 
     * @param aDeploy
     * @param anotherDeploy
     */
    public Dependency(DeploymentSpecification aDeploy, DeploymentSpecification anotherDeploy)
    {
        this();
        this.dependentDeploy(aDeploy);
        this.dependencyDeploy(anotherDeploy);
    }

    /**
     * Constructor.
     * 
     * @param aDeploy
     * @param aArtifact
     */
    public Dependency(DeploymentSpecification aDeploy, Artifact aArtifact)
    {
        this();
        this.dependentDeploy(aDeploy);
        this.dependencyArtifact(aArtifact);
    }

    /**
     * Constructor.
     * 
     * @param aArtifact
     * @param aDeploy
     */
    public Dependency(Artifact aArtifact, DeploymentSpecification aDeploy)
    {
        this();
        this.dependentArtifact(aArtifact);
        this.dependencyDeploy(aDeploy);
    }

    /**
     * @param node
     * @param node2
     */
    public Dependency(Node node, Node node2)
    {
        this();
        this.dependentNode(node);
        this.dependencyNode(node2);
    }

    /**
     * @param node
     * @param device
     */
    public Dependency(Node node, DeviceNode device)
    {
        this();
        this.dependentNode(node);
        this.dependencyDevice(device);
    }

    /**
     * @param device
     * @param node
     */
    public Dependency(DeviceNode device, Node node)
    {
        this();
        this.dependentDevice(device);
        this.dependencyNode(node);
    }

    /**
     * @param node
     * @param execution
     */
    public Dependency(Node node, ExecutionEnvironment execution)
    {
        this();
        this.dependentNode(node);
        this.dependencyExecution(execution);
    }

    /**
     * @param execution
     * @param node
     */
    public Dependency(ExecutionEnvironment execution, Node node)
    {
        this();
        this.dependentExecution(execution);
        this.dependencyNode(node);
    }

    /**
     * @param node
     * @param component
     */
    public Dependency(Node node, Component component)
    {
        this();
        this.dependentNode(node);
        this.dependencyComponent(component);
    }

    /**
     * @param component
     * @param node
     */
    public Dependency(Component component, Node node)
    {
        this();
        this.dependentComponent(component);
        this.dependencyNode(node);
    }

    /**
     * @param node
     * @param interface
     */
    public Dependency(Node node, Interface interface1)
    {
        this();
        this.dependentNode(node);
        this.dependencyInterface(interface1);
    }

    /**
     * @param interface1
     * @param node
     */
    public Dependency(Interface interface1, Node node)
    {
        this();
        this.dependentInterface(interface1);
        this.dependencyNode(node);
    }

    /**
     * @param node
     * @param artifact
     */
    public Dependency(Node node, Artifact artifact)
    {
        this();
        this.dependentNode(node);
        this.dependencyArtifact(artifact);
    }

    /**
     * @param artifact
     * @param node
     */
    public Dependency(Artifact artifact, Node node)
    {
        this();
        this.dependentArtifact(artifact);
        this.dependencyNode(node);
    }

    /**
     * @param node
     * @param dep
     */
    public Dependency(Node node, DeploymentSpecification dep)
    {
        this();
        this.dependentNode(node);
        this.dependencyDeploy(dep);
    }

    /**
     * @param dep
     * @param node
     */
    public Dependency(DeploymentSpecification dep, Node node)
    {
        this();
        this.dependentDeploy(dep);
        this.dependencyNode(node);
    }

    /**
     * @param artifact
     * @param device
     */
    public Dependency(Artifact artifact, DeviceNode device)
    {
        this();
        this.dependentArtifact(artifact);
        this.dependencyDevice(device);
    }

    /**
     * @param device
     * @param artifact
     */
    public Dependency(DeviceNode device, Artifact artifact)
    {
        this();
        this.dependentDevice(device);
        this.dependencyArtifact(artifact);
    }

    /**
     * @param artifact
     * @param execution
     */
    public Dependency(Artifact artifact, ExecutionEnvironment execution)
    {
        this();
        this.dependentArtifact(artifact);
        this.dependencyExecution(execution);
    }

    /**
     * @param execution
     * @param artifact
     */
    public Dependency(ExecutionEnvironment execution, Artifact artifact)
    {
        this();
        this.dependentExecution(execution);
        this.dependencyArtifact(artifact);
    }

    /**
     * @param artifact
     * @param component
     */
    public Dependency(Artifact artifact, Component component)
    {
        this();
        this.dependentArtifact(artifact);
        this.dependencyComponent(component);
    }

    /**
     * @param component
     * @param artifact
     */
    public Dependency(Component component, Artifact artifact)
    {
        this();
        this.dependentComponent(component);
        this.dependencyArtifact(artifact);
    }

    /**
     * @param artifact
     * @param interface1
     */
    public Dependency(Artifact artifact, Interface interface1)
    {
        this();
        this.dependentArtifact(artifact);
        this.dependencyInterface(interface1);
    }

    /**
     * @param interface1
     * @param artifact
     */
    public Dependency(Interface interface1, Artifact artifact)
    {
        this();
        this.dependentInterface(interface1);
        this.dependencyArtifact(artifact);
    }

    /**
     * @param device
     * @param execution
     */
    public Dependency(DeviceNode device, ExecutionEnvironment execution)
    {
        this();
        this.dependentDevice(device);
        this.dependencyExecution(execution);
    }

    /**
     * @param execution
     * @param device
     */
    public Dependency(ExecutionEnvironment execution, DeviceNode device)
    {
        this();
        this.dependentExecution(execution);
        this.dependencyDevice(device);
    }

    /**
     * @param device
     * @param deploy
     */
    public Dependency(DeviceNode device, DeploymentSpecification deploy)
    {
        this();
        this.dependentDevice(device);
        this.dependencyDeploy(deploy);
    }

    /**
     * @param deploy
     * @param device
     */
    public Dependency(DeploymentSpecification deploy, DeviceNode device)
    {
        this();
        this.dependentDeploy(deploy);
        this.dependencyDevice(device);
    }

    /**
     * @param device
     * @param component
     */
    public Dependency(DeviceNode device, Component component)
    {
        this();
        this.dependentDevice(device);
        this.dependencyComponent(component);
    }

    /**
     * @param component
     * @param device
     */
    public Dependency(Component component, DeviceNode device)
    {
        this();
        this.dependentComponent(component);
        this.dependencyDevice(device);
    }

    /**
     * @param device
     * @param interface1
     */
    public Dependency(DeviceNode device, Interface interface1)
    {
        this();
        this.dependentDevice(device);
        this.dependencyInterface(interface1);
    }

    /**
     * @param interface1
     * @param device
     */
    public Dependency(Interface interface1, DeviceNode device)
    {
        this();
        this.dependentInterface(interface1);
        this.dependencyDevice(device);
    }

    /**
     * @param execution
     * @param deploy
     */
    public Dependency(ExecutionEnvironment execution, DeploymentSpecification deploy)
    {
        this();
        this.dependentExecution(execution);
        this.dependencyDeploy(deploy);
    }

    /**
     * @param deploy
     * @param execution
     */
    public Dependency(DeploymentSpecification deploy, ExecutionEnvironment execution)
    {
        this();
        this.dependentDeploy(deploy);
        this.dependencyExecution(execution);
    }

    /**
     * @param execution
     * @param component
     */
    public Dependency(ExecutionEnvironment execution, Component component)
    {
        this();
        this.dependentExecution(execution);
        this.dependencyComponent(component);
    }

    /**
     * @param component
     * @param execution
     */
    public Dependency(Component component, ExecutionEnvironment execution)
    {
        this();
        this.dependentComponent(component);
        this.dependencyExecution(execution);
    }

    /**
     * @param execution
     * @param interface1
     */
    public Dependency(ExecutionEnvironment execution, Interface interface1)
    {
        this();
        this.dependentExecution(execution);
        this.dependencyInterface(interface1);
    }

    /**
     * @param interface1
     * @param execution
     */
    public Dependency(Interface interface1, ExecutionEnvironment execution)
    {
        this();
        this.dependentInterface(interface1);
        this.dependencyExecution(execution);
    }

    /**
     * @param deploy
     * @param component
     */
    public Dependency(DeploymentSpecification deploy, Component component)
    {
        this();
        this.dependentDeploy(deploy);
        this.dependencyComponent(component);
    }

    /**
     * @param component
     * @param deploy
     */
    public Dependency(Component component, DeploymentSpecification deploy)
    {
        this();
        this.dependentComponent(component);
        this.dependencyDeploy(deploy);
    }

    /**
     * @param deploy
     * @param interface1
     */
    public Dependency(DeploymentSpecification deploy, Interface interface1)
    {
        this();
        this.dependentDeploy(deploy);
        this.dependencyInterface(interface1);
    }

    /**
     * @param interface1
     * @param deploy
     */
    public Dependency(Interface interface1, DeploymentSpecification deploy)
    {
        this();
        this.dependentInterface(interface1);
        this.dependencyDeploy(deploy);
    }

    /**
     * @param interface1
     * @param collaboration
     */
    public Dependency(Interface interface1, Collaboration collaboration)
    {
        this();
        this.dependentInterface(interface1);
        this.dependencyCollaboration(collaboration);
    }

    /**
     * @param collaboration
     * @param interface1
     */
    public Dependency(Collaboration collaboration, Interface interface1)
    {
        this();
        this.dependentCollaboration(collaboration);
        this.dependencyInterface(interface1);
    }

    /**
     * @param interface1
     * @param collaboration
     */
    public Dependency(Interface interface1, CollaborationUse collaboration)
    {
        this();
        this.dependentInterface(interface1);
        this.dependencyCollaborationUse(collaboration);
    }

    /**
     * @param collaboration
     * @param interface1
     */
    public Dependency(CollaborationUse collaboration, Interface interface1)
    {
        this();
        this.dependentCollaborationUse(collaboration);
        this.dependencyInterface(interface1);
    }

    /**
     * @param classe
     * @param classe2
     */
    public Dependency(Classe classe, Classe classe2)
    {
        this();
        this.dependentClass(classe);
        this.dependencyClass(classe2);
    }

    /**
     * @param classe
     * @param interface1
     */
    public Dependency(Classe classe, Interface interface1)
    {
        this();
        this.dependentClass(classe);
        this.dependencyInterface(interface1);
    }

    /**
     * @param interface1
     * @param classe
     */
    public Dependency(Interface interface1, Classe classe)
    {
        this();
        this.dependentInterface(interface1);
        this.dependencyClass(classe);
    }

    /**
     * @param classe
     * @param collaboration
     */
    public Dependency(Classe classe, Collaboration collaboration)
    {
        this();
        this.dependentClass(classe);
        this.dependencyCollaboration(collaboration);
    }

    /**
     * @param classe
     * @param collaboration
     */
    public Dependency(Collaboration collaboration, Classe classe)
    {
        this();
        this.dependentCollaboration(collaboration);
        this.dependencyClass(classe);
    }

    /**
     * @param classe
     * @param collaboration
     */
    public Dependency(Classe classe, CollaborationUse collaboration)
    {
        this();
        this.dependentClass(classe);
        this.dependencyCollaborationUse(collaboration);
    }

    /**
     * @param classe
     * @param collaboration
     */
    public Dependency(CollaborationUse collaboration, Classe classe)
    {
        this();
        this.dependentCollaborationUse(collaboration);
        this.dependencyClass(classe);
    }

    /**
     * @param collaboration
     * @param collaboration2
     */
    public Dependency(Collaboration collaboration, Collaboration collaboration2)
    {
        this();
        this.dependentCollaboration(collaboration);
        this.dependencyCollaboration(collaboration2);
    }

    /**
     * @param collaboration
     * @param collaborationUse
     */
    public Dependency(Collaboration collaboration, CollaborationUse collaborationUse)
    {
        this();
        this.dependentCollaboration(collaboration);
        this.dependencyCollaborationUse(collaborationUse);
    }

    /**
     * @param collaborationUse
     * @param collaboration
     */
    public Dependency(CollaborationUse collaborationUse, Collaboration collaboration)
    {
        this();
        this.dependentCollaborationUse(collaborationUse);
        this.dependencyCollaboration(collaboration);
    }

    /**
     * @param collaborationUse
     * @param collaborationUse2
     */
    public Dependency(CollaborationUse collaborationUse, CollaborationUse collaborationUse2)
    {
        this();
        this.dependentCollaborationUse(collaborationUse);
        this.dependencyCollaborationUse(collaborationUse2);
    }

    /**
     * @param classe
     */
    public void dependentClass(Classe classe)
    {
        this.dependentClass = classe;
    }

    /**
     * @param classe
     */
    public void dependencyClass(Classe classe)
    {
        this.dependencyClass = classe;
    }

    /**
     * @param collaboration
     */
    public void dependentCollaboration(Collaboration collaboration)
    {
        this.dependentCollaboration = collaboration;
    }

    /**
     * @param collaboration
     */
    public void dependencyCollaboration(Collaboration collaboration)
    {
        this.dependencyCollaboration = collaboration;
    }

    /**
     * @param collaboration
     */
    public void dependentCollaborationUse(CollaborationUse collaboration)
    {
        this.dependentCollaborationUse = collaboration;
    }

    /**
     * @param collaboration
     */
    public void dependencyCollaborationUse(CollaborationUse collaboration)
    {
        this.dependencyCollaborationUse = collaboration;
    }

    /**
     * @param node
     */
    public void dependentNode(Node node)
    {
        this.dependentNode = node;
    }

    /**
     * @param node
     */
    public void dependencyNode(Node node)
    {
        this.dependencyNode = node;
    }

    /**
     * @param device
     */
    public void dependentDevice(DeviceNode device)
    {
        this.dependentDevice = device;
    }

    /**
     * @param device
     */
    public void dependencyDevice(DeviceNode device)
    {
        this.dependencyDevice = device;
    }

    /**
     * @param execution
     */
    public void dependentExecution(ExecutionEnvironment execution)
    {
        this.dependentExecution = execution;
    }

    /**
     * @param execution
     */
    public void dependencyExecution(ExecutionEnvironment execution)
    {
        this.dependencyExecution = execution;
    }

    /**
     * @param anotherDeploy
     */
    public void dependencyDeploy(DeploymentSpecification anotherDeploy)
    {
        this.dependencyDeploy = anotherDeploy;
    }

    /**
     * @param deploy
     */
    public void dependentDeploy(DeploymentSpecification deploy)
    {
        this.dependentDeploy = deploy;
    }

    /**
     * @param anotherArtifact
     */
    public void dependentArtifact(Artifact anotherArtifact)
    {
        this.dependentArtifact = anotherArtifact;
    }

    /**
     * @param artifact
     */
    public void dependencyArtifact(Artifact artifact)
    {
        this.dependencyArtifact = artifact;
    }

    /**
     * @param anotherInterface
     */
    public void dependencyInterface(Interface anotherInterface)
    {
        this.dependencyInterface = anotherInterface;
    }

    /**
     * @param interface1
     */
    public void dependentInterface(Interface interface1)
    {
        this.dependentInterface = interface1;
    }

    /**
     * @param aComponent
     */
    public void dependencyComponent(Component aComponent)
    {
        this.dependencyComponent = aComponent;
    }

    /**
     * @param aComponent
     */
    public void dependentComponent(Component aComponent)
    {
        this.dependentComponent = aComponent;
    }

    /**
     * @param aPackage
     */
    public void dependencyPackage(Package aPackage)
    {
        this.dependencyPackage = aPackage;
    }

    /**
     * @param aPackage
     */
    public void dependentPackage(Package aPackage)
    {
        this.dependentPackage = aPackage;
    }

    /**
     * @return
     */
    public Interface dependentInterface()
    {
        return this.dependentInterface;
    }

    /**
     * @return
     */
    public Interface dependencyInterface()
    {
        return this.dependencyInterface;
    }

    /**
     * @return
     */
    public Component dependentComponent()
    {
        return this.dependentComponent;
    }

    /**
     * @return
     */
    public Component dependencyComponent()
    {
        return this.dependencyComponent;
    }

    /**
     * @return
     */
    public Package dependentPackage()
    {
        return this.dependentPackage;
    }

    /**
     * @return
     */
    public Package dependencyPackage()
    {
        return this.dependencyPackage;
    }

    /**
     * @param instance
     */
    protected void dependencyInstance(InstanceSpecification instance)
    {
        this.dependencyInstance = instance;
    }

    /**
     * @return
     */
    public InstanceSpecification dependencyInstance()
    {
        return this.dependencyInstance;
    }

    /**
     * @param instance
     */
    protected void dependentInstance(InstanceSpecification instance)
    {
        this.dependentInstance = instance;
    }

    /**
     * @return
     */
    public InstanceSpecification dependentInstance()
    {
        return this.dependentInstance;
    }

    /**
     * @return
     */
    public Artifact dependencyArtifact()
    {
        return this.dependencyArtifact;
    }

    /**
     * @return
     */
    public Artifact dependentArtifact()
    {
        return this.dependentArtifact;
    }

    /**
     * @return
     */
    public DeploymentSpecification dependencyDeploy()
    {
        return this.dependencyDeploy;
    }

    /**
     * @return
     */
    public DeploymentSpecification dependentDeploy()
    {
        return this.dependentDeploy;
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
        auxList.add(this.dependentInstance());
        auxList.add(this.dependencyInstance());
        auxList.add(this.dependencyPackage());
        auxList.add(this.dependentPackage());
        auxList.add(this.dependencyComponent());
        auxList.add(this.dependentComponent());
        auxList.add(this.dependencyInterface());
        auxList.add(this.dependentInterface());
        auxList.add(this.dependencyArtifact());
        auxList.add(this.dependentArtifact());
        auxList.add(this.dependencyDeploy());
        auxList.add(this.dependentDeploy());
        auxList.add(this.dependencyNode());
        auxList.add(this.dependentNode());
        auxList.add(this.dependencyDevice());
        auxList.add(this.dependentDevice());
        auxList.add(this.dependencyExecution());
        auxList.add(this.dependentExecution());
        auxList.add(this.dependencyCollaboration());
        auxList.add(this.dependentCollaboration());
        auxList.add(this.dependencyCollaborationUse());
        auxList.add(this.dependentCollaborationUse());
        auxList.add(this.dependencyClass());
        auxList.add(this.dependentClass());
        return auxList;
    }

    /**
     * @return
     */
    public Collaboration dependentCollaboration()
    {
        return this.dependentCollaboration;
    }

    /**
     * @return
     */
    public Collaboration dependencyCollaboration()
    {
        return this.dependencyCollaboration;
    }

    /**
     * @return
     */
    public CollaborationUse dependentCollaborationUse()
    {
        return this.dependentCollaborationUse;
    }

    /**
     * @return
     */
    public CollaborationUse dependencyCollaborationUse()
    {
        return this.dependencyCollaborationUse;
    }

    /**
     * @return
     */
    public Classe dependentClass()
    {
        return this.dependentClass;
    }

    /**
     * @return
     */
    public Classe dependencyClass()
    {
        return this.dependencyClass;
    }

    /**
     * @return
     */
    public ExecutionEnvironment dependentExecution()
    {
        return this.dependentExecution;
    }

    /**
     * @return
     */
    public ExecutionEnvironment dependencyExecution()
    {
        return this.dependencyExecution;
    }

    /**
     * @return
     */
    public DeviceNode dependentDevice()
    {
        return this.dependentDevice;
    }

    /**
     * @return
     */
    public DeviceNode dependencyDevice()
    {
        return this.dependencyDevice;
    }

    /**
     * @return
     */
    public Node dependentNode()
    {
        return this.dependentNode;
    }

    /**
     * @return
     */
    public Node dependencyNode()
    {
        return this.dependencyNode;
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#canBeMovedFrom_to(ocean.framework.Concept,
     *      ocean.framework.Concept)
     */
    public boolean canBeMovedFrom_to(Concept anOriginComponent, Concept aTargetComponent)
    {

        boolean auxRecursBool;

        auxRecursBool = this.dependentInstance().equals(anOriginComponent)
                & this.dependencyInstance().equals(aTargetComponent)
                | (this.dependentInstance().equals(aTargetComponent) & this.dependencyInstance()
                    .equals(anOriginComponent));
        if (auxRecursBool)
        {
            JOptionPane.showMessageDialog(null, "Não existe dependências com apenas uma classe.");
        }

        return aTargetComponent.conceptName().equals("objeto")
                & !(anOriginComponent.equals(aTargetComponent))
                & (this.dependentInstance().equals(anOriginComponent) | this.dependentInstance()
                    .equals(anOriginComponent)) & !(auxRecursBool);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#conceptName()
     */
    public String conceptName()
    {
        return I18NProperties.getString("dependency.concept.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("dependency.concept.name.for.tree");
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
        return I18NProperties.getString("dependency.concept.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#changeReferenceFrom_to(ocean.framework.Concept,
     *      ocean.framework.Concept)
     */
    public void changeReferenceFrom_to(Concept anOriginComponent, Concept aTargetComponent)
    {
        if (aTargetComponent.conceptName().equals("object"))
        {
            if (this.dependentInstance().equals(anOriginComponent))
            {
                this.dependentInstance((InstanceSpecification) aTargetComponent);
            }

            if (this.dependencyInstance().equals(anOriginComponent))
            {
                this.dependencyInstance((InstanceSpecification) aTargetComponent);
            }
        }
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
