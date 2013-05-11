/*
 * @(#)DeploymentDiagram.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Jan 24, 2008        descrição
 */
package documents.models;

import ocean.documents.oo.concepts.*;
import ocean.framework.ConceptualModel;
import ocean.framework.SpecificationElement;
import ocean.jhotdraw.SpecificationDrawing;
import ocean.smalltalk.OceanVector;
import documents.concepts.component_diagram.Component;
import documents.concepts.component_diagram.Interface;
import documents.concepts.component_diagram.Port;
import documents.concepts.deployment_diagram.*;
import documents.concepts.object_diagram.Dependency;
import documents.concepts.object_diagram.Realization;
import documents.graphical.deployment_diagram.DeploymentDiagramDrawing;
import documents.util.I18NProperties;

public class DeploymentDiagram extends ConceptualModel
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -2759341821171253471L;

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.ConceptualModel#initialize()
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public void initialize()
    {
        elementKeeperList = new OceanVector();
        elementKeeperList.add(SpecificationElement.construtor(Artifact.class));
        elementKeeperList.add(SpecificationElement.construtor(Deployment.class));
        elementKeeperList.add(SpecificationElement.construtor(DeploymentSpecification.class));
        elementKeeperList.add(SpecificationElement.construtor(DeviceNode.class));
        elementKeeperList.add(SpecificationElement.construtor(Node.class));
        elementKeeperList.add(SpecificationElement.construtor(Manifestation.class));
        elementKeeperList.add(SpecificationElement.construtor(ExecutionEnvironment.class));        
        elementKeeperList.add(SpecificationElement.construtor(Port.class));
        elementKeeperList.add(SpecificationElement.construtor(Interface.class));
        elementKeeperList.add(SpecificationElement.construtor(Component.class));
        elementKeeperList.add(SpecificationElement.construtor(Dependency.class));
        elementKeeperList.add(SpecificationElement.construtor(Realization.class));
        elementKeeperList.add(SpecificationElement.construtor(Heranca.class));
        elementKeeperList.add(SpecificationElement.construtor(AssociacaoBinaria.class));
        elementKeeperList.add(SpecificationElement.construtor(Agregacao.class));
        elementKeeperList.add(SpecificationElement.construtor(Composition.class));
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.ConceptualModel#createEmptyDrawing()
     */
    @Override
    public SpecificationDrawing createEmptyDrawing()
    {
        return new DeploymentDiagramDrawing();
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.ConceptualModel#conceitoLista()
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public OceanVector<Class> conceitoLista()
    {
        OceanVector<Class> aList = new OceanVector<Class>();
        aList.add(Artifact.class);
        aList.add(Deployment.class);
        aList.add(DeploymentSpecification.class);
        aList.add(DeviceNode.class);
        aList.add(Node.class);
        aList.add(Manifestation.class);
        aList.add(ExecutionEnvironment.class);        
        aList.add(Port.class);
        aList.add(Interface.class);
        aList.add(Component.class);
        aList.add(Dependency.class);
        aList.add(Realization.class);
        aList.add(Heranca.class);
        aList.add(AssociacaoBinaria.class);
        aList.add(Agregacao.class);
        aList.add(Composition.class);
        return aList;
    }

    /*
     * (non-Javadoc) Realization
     * 
     * @see ocean.framework.ConceptualModel#modelName()
     */
    public String modelName()
    {
        return I18NProperties.getString("deployment.diagram.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("deployment.diagram.name.for.tree") + name;
    }

}
