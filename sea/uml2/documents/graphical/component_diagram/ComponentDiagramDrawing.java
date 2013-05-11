/*
 * @(#)ComponentDiagramDrawing.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Jan 11, 2008        descrição
 */
package documents.graphical.component_diagram;

import ocean.documents.oo.concepts.*;
import ocean.framework.Concept;
import ocean.jhotdraw.*;
import documents.concepts.component_diagram.Component;
import documents.concepts.component_diagram.Interface;
import documents.concepts.component_diagram.Port;
import documents.concepts.object_diagram.Dependency;
import documents.concepts.object_diagram.Realization;
import documents.graphical.object_diagram.*;
import documents.graphical.object_diagram.AssociationLineConnection;

public class ComponentDiagramDrawing extends SpecificationDrawing
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 8993678782536928458L;

    /**
     * Official constructor.
     */
    public ComponentDiagramDrawing()
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
        if (aConcept instanceof Component)
        {
            figure = new ComponentFigure();
        }
        else if (aConcept instanceof Interface)
        {
            figure = new InterfaceFigure();
        }
        else if (aConcept instanceof Port)
        {
            figure = new PortFigure();
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

        String concNameDependency = Concept.conceptName(Dependency.class);
        String concNameAgregacao = Concept.conceptName(Agregacao.class);
        String concNameAssociacao = Concept.conceptName(AssociacaoBinaria.class);
        String concNameRealization = Concept.conceptName(Realization.class);
        String concNameInheritance = Concept.conceptName(Heranca.class);
        String concNameComposition = Concept.conceptName(Composition.class);

        if (aConcept.conceptName().equals(concNameDependency))
        {
            // FIXME - verificar quando o conceito é uma interface 
            // pois aí deve chamar o dependentInterface()
            auxComp = ((Dependency) aConcept).dependentComponent();
        }
        else if (aConcept.conceptName().equals(concNameAgregacao))
        {
            auxComp = ((Agregacao) aConcept).agreggatedComponent();
        }
        else if (aConcept.conceptName().equals(concNameAssociacao))
        {
            auxComp = ((AssociacaoBinaria) aConcept).componentTerminal1();
        }
        else if (aConcept.conceptName().equals(concNameRealization))
        {
            auxComp = ((Realization) aConcept).realizatedComponent();
        }
        else if (aConcept.conceptName().equals(concNameInheritance))
        {
            auxComp = ((Heranca) aConcept).subComponent();
        }
        else if (aConcept.conceptName().equals(concNameComposition))
        {
            auxComp = ((Composition) aConcept).agreggatedComponent();
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

        String concNameDependency = Concept.conceptName(Dependency.class);
        String concNameAgregacao = Concept.conceptName(Agregacao.class);
        String concNameAssociacao = Concept.conceptName(AssociacaoBinaria.class);
        String concNameRealization = Concept.conceptName(Realization.class);
        String concNameInheritance = Concept.conceptName(Heranca.class);
        String concNameComposition = Concept.conceptName(Composition.class);

        if (aConcept.conceptName().equals(concNameDependency))
        {
            // FIXME - verificar quando o conceito é uma interface 
            // pois aí deve chamar o dependentInterface()
            auxComp = ((Dependency) aConcept).dependencyComponent();
            // OR
            // auxComp = ((Dependency) aComponent).dependencyInterface();
        }
        else if (aConcept.conceptName().equals(concNameAgregacao))
        {
            auxComp = ((Agregacao) aConcept).agreggaterComponent();
        }
        else if (aConcept.conceptName().equals(concNameAssociacao))
        {
            auxComp = ((AssociacaoBinaria) aConcept).componentTerminal2();
        }
        else if (aConcept.conceptName().equals(concNameRealization))
        {
            auxComp = ((Realization) aConcept).realizaterComponent();
        }
        else if (aConcept.conceptName().equals(concNameInheritance))
        {
            auxComp = ((Heranca) aConcept).superComponent();
        }
        else if (aConcept.conceptName().equals(concNameComposition))
        {
            auxComp = ((Composition) aConcept).agreggaterComponent();
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

        String concNameDependency = Concept.conceptName(Dependency.class);
        String concNameHeranca = Concept.conceptName(Heranca.class);
        String concNameAgregacao = Concept.conceptName(Agregacao.class);
        String concNameAssociacao = Concept.conceptName(AssociacaoBinaria.class);
        String concNameRealization = Concept.conceptName(Realization.class);
        String concNameInheritance = Concept.conceptName(Heranca.class);
        String concNameComposition = Concept.conceptName(Composition.class);

        if (aConcept.conceptName().equals(concNameDependency))
        {
            aLine = new DependencyLineConnection();
        }
        else if (aConcept.conceptName().equals(concNameAgregacao))
        {
            aLine = new AggregationLineConnection();
        }
        else if (aConcept.conceptName().equals(concNameAssociacao))
        {
            aLine = new AssociationLineConnection();
        }
        else if (aConcept.conceptName().equals(concNameHeranca))
        {
            aLine = new InheritanceLineConnection();
        }
        else if (aConcept.conceptName().equals(concNameRealization))
        {
            aLine = new RealizationLineConnection();
        }
        else if (aConcept.conceptName().equals(concNameInheritance))
        {
            aLine = new InheritanceLineConnection();
        }
        else if (aConcept.conceptName().equals(concNameComposition))
        {
            aLine = new CompositionLineConnection();
        }

        return aLine;
    }

}