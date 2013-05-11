/*
 * @(#)DeploymentDiagramDrawing.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Jan 24, 2008        descrição
 */
package documents.graphical.deployment_diagram;

import ocean.documents.oo.concepts.Agregacao;
import ocean.documents.oo.concepts.AssociacaoBinaria;
import ocean.documents.oo.concepts.Composition;
import ocean.documents.oo.graphical.classDiagram.MObjAgregationLineFigure;
import ocean.framework.Concept;
import ocean.jhotdraw.SpecificationCompositeFigure;
import ocean.jhotdraw.SpecificationDrawing;
import ocean.jhotdraw.SpecificationLineFigure;
import documents.concepts.component_diagram.Component;
import documents.concepts.component_diagram.Interface;
import documents.concepts.deployment_diagram.*;
import documents.concepts.object_diagram.Dependency;
import documents.concepts.object_diagram.Realization;
import documents.graphical.component_diagram.ComponentFigure;
import documents.graphical.component_diagram.InterfaceFigure;
import documents.graphical.object_diagram.*;

public class DeploymentDiagramDrawing extends SpecificationDrawing
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -6475103657575438689L;

    /**
     * Official constructor.
     */
    public DeploymentDiagramDrawing()
    {
        super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationDrawing#createDesiredFigureForConcept(ocean.framework.Concept)
     */
    @Override
    public SpecificationCompositeFigure createDesiredFigureForConcept(Concept aConcept)
    {
        SpecificationCompositeFigure figure = null;
        if (aConcept instanceof Artifact)
        {
            figure = new ArtifactFigure();
        }
        else if (aConcept instanceof DeploymentSpecification)
        {
            figure = new DeploymentSpecificationFigure();
        }
        else if (aConcept instanceof Node)
        {
            figure = new NodeFigure();
        }
        else if (aConcept instanceof DeviceNode)
        {
            figure = new DeviceNodeFigure();
        }
        else if (aConcept instanceof ExecutionEnvironment)
        {
            figure = new ExecutionEnvironmentFigure();
        }
        else if (aConcept instanceof Component)
        {
            figure = new ComponentFigure();
        }
        else if (aConcept instanceof Interface)
        {
            figure = new InterfaceFigure();
        }
        return figure;
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationDrawing#startFigureFor(ocean.framework.Concept)
     */
    public SpecificationCompositeFigure startFigureFor(Concept aConcept)
    {
        Concept auxComp = null;

        String concNameAssociation = Concept.conceptName(AssociacaoBinaria.class);
        String concNameComposition = Concept.conceptName(Composition.class);
        String concNameAgregacao = Concept.conceptName(Agregacao.class);
        String concNameDependency = Concept.conceptName(Dependency.class);
        String concNameRealization = Concept.conceptName(Realization.class);
        String concNameManifest = Concept.conceptName(Manifestation.class);
        String concNameDeploy = Concept.conceptName(Deployment.class);

        if (aConcept.conceptName().equals(concNameAssociation))
        {
            // FIXME - verificar quando o conceito é um node
            // pois aí deve chamar o dependentNode()
            auxComp = ((AssociacaoBinaria) aConcept).nodeTerminal1();
        }
        else if (aConcept.conceptName().equals(concNameComposition))
        {
            auxComp = ((Composition) aConcept).agreggaterNode();
        }
        else if (aConcept.conceptName().equals(concNameAgregacao))
        {
            auxComp = ((Agregacao) aConcept).agreggaterNode();
        }
        else if (aConcept.conceptName().equals(concNameDependency))
        {
            auxComp = ((Dependency) aConcept).dependentArtifact();
        }
        else if (aConcept.conceptName().equals(concNameRealization))
        {
            auxComp = ((Realization) aConcept).realizatedArtifact();
        }
        else if (aConcept.conceptName().equals(concNameManifest))
        {
            auxComp = ((Manifestation) aConcept).manifestedArtifact();
        }
        else if (aConcept.conceptName().equals(concNameDeploy))
        {
            auxComp = ((Deployment) aConcept).deployedArtifact();
        }
        return (SpecificationCompositeFigure) getFigureOfConcept(auxComp);
    }

    /*
     * (non-Javadoc) mponent.conceptName().equals(concNameAssociacao))
     * 
     * @see ocean.jhotdraw.SpecificationDrawing#stopFigureFor(ocean.framework.Concept)
     */
    public SpecificationCompositeFigure stopFigureFor(Concept aConcept)
    {
        Concept auxComp = null;
        
        String concNameAssociation = Concept.conceptName(AssociacaoBinaria.class);
        String concNameComposition = Concept.conceptName(Composition.class);
        String concNameAgregacao = Concept.conceptName(Agregacao.class);
        String concNameDependency = Concept.conceptName(Dependency.class);
        String concNameRealization = Concept.conceptName(Realization.class);
        String concNameManifest = Concept.conceptName(Manifestation.class);
        String concNameDeploy = Concept.conceptName(Deployment.class);
        
        if (aConcept.conceptName().equals(concNameAssociation))
        {
            // FIXME - verificar quando o conceito é um node
            // pois aí deve chamar o dependentNode()
            auxComp = ((AssociacaoBinaria) aConcept).nodeTerminal1();
        }
        else if (aConcept.conceptName().equals(concNameComposition))
        {
            auxComp = ((Composition) aConcept).agreggatedNode();
        }
        else if (aConcept.conceptName().equals(concNameAgregacao))
        {
            auxComp = ((Agregacao) aConcept).agreggatedNode();
        }
        else if (aConcept.conceptName().equals(concNameDependency))
        {
            auxComp = ((Dependency) aConcept).dependencyArtifact();
        }
        else if (aConcept.conceptName().equals(concNameRealization))
        {
            auxComp = ((Realization) aConcept).realizaterArtifact();
        }
        else if (aConcept.conceptName().equals(concNameManifest))
        {
            auxComp = ((Manifestation) aConcept).manifesterArtifact();
        }
        else if (aConcept.conceptName().equals(concNameDeploy))
        {
            auxComp = ((Deployment) aConcept).deployerArtifact();
        }
        return (SpecificationCompositeFigure) getFigureOfConcept(auxComp);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationDrawing#createDesiredLineForConcept(ocean.framework.Concept)
     */
    public SpecificationLineFigure createDesiredLineForConcept(Concept aConcept)
    {
        SpecificationLineFigure aLine = null;

        String concNameAssociation = Concept.conceptName(AssociacaoBinaria.class);
        String concNameComposition = Concept.conceptName(Composition.class);
        String concNameAgregacao = Concept.conceptName(Agregacao.class);
        String concNameDependency = Concept.conceptName(Dependency.class);
        String concNameRealization = Concept.conceptName(Realization.class);
        String concNameManifest = Concept.conceptName(Manifestation.class);
        String concNameDeploy = Concept.conceptName(Deployment.class);

        if (aConcept.conceptName().equals(concNameDependency))
        {
            aLine = new DependencyLineConnection();
        }
        else if (aConcept.conceptName().equals(concNameComposition))
        {
            aLine = new CompositionLineConnection();
        }
        else if (aConcept.conceptName().equals(concNameAssociation))
        {
            aLine = new AssociationLineConnection();
        }
        else if (aConcept.conceptName().equals(concNameAgregacao))
        {
            aLine = new MObjAgregationLineFigure();
        }
        else if (aConcept.conceptName().equals(concNameRealization))
        {
            aLine = new RealizationLineConnection();
        }
        else if (aConcept.conceptName().equals(concNameManifest))
        {
            aLine = new ManifestionLineConnection();
        }
        else if (aConcept.conceptName().equals(concNameDeploy))
        {
            aLine = new DeploymentLineConnection();
        }

        return aLine;
    }
}
