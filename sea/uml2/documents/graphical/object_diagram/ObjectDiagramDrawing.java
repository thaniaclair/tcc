package documents.graphical.object_diagram;

import documents.concepts.object_diagram.Dependency;
import documents.concepts.object_diagram.Realization;
import ocean.documents.oo.concepts.*;
import ocean.documents.oo.graphical.classDiagram.*;
import ocean.framework.Concept;
import ocean.jhotdraw.*;

public class ObjectDiagramDrawing extends SpecificationDrawing
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -3968123032514369441L;

    /**
     * Official constructor.
     */
    public ObjectDiagramDrawing()
    {
        super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationDrawing#createDesiredFigureForConcept(ocean.framework.Concept)
     */
    @Override
    public SpecificationCompositeFigure createDesiredFigureForConcept(Concept component)
    {
        SpecificationCompositeFigure figure = null;
        if (component instanceof documents.concepts.object_diagram.InstanceSpecification)
        {
            figure = new InstanceSpecificationFigure();
        }

        return figure;
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationDrawing#startFigureFor(ocean.framework.Concept)
     */
    public SpecificationCompositeFigure startFigureFor(Concept aComponent)
    {
        Concept auxComp = null;

        String concNameHeranca = Concept.conceptName(Heranca.class);
        String concNameAgregacao = Concept.conceptName(Agregacao.class);
        String concNameComposition = Concept.conceptName(Composition.class);
        String concNameAssociacao = Concept.conceptName(AssociacaoBinaria.class);
        String concNameDependency = Concept.conceptName(Dependency.class);
        String concNameRealization = Concept.conceptName(Realization.class);

        if (aComponent.conceptName().equals(concNameAgregacao))
        {
            auxComp = ((Agregacao) aComponent).agreggatedInstanceSpecification();
        }
        else if (aComponent.conceptName().equals(concNameAssociacao))
        {
            auxComp = ((AssociacaoBinaria) aComponent).instanceTerminal1();
        }
        else if (aComponent.conceptName().equals(concNameComposition))
        {
            auxComp = ((Composition) aComponent).agreggatedInstanceSpecification();
        }
        else if (aComponent.conceptName().equals(concNameHeranca))
        {
            auxComp = ((Heranca) aComponent).subInstance();
        }
        else if (aComponent.conceptName().equals(concNameDependency))
        {
            auxComp = ((Dependency) aComponent).dependentInstance();
        }
        else if (aComponent.conceptName().equals(concNameRealization))
        {
            auxComp = ((Realization) aComponent).realizatedInstance();
        }

        return (SpecificationCompositeFigure) getFigureOfConcept(auxComp);
    }

    /*
     * (non-Javadoc)
     * mponent.conceptName().equals(concNameAssociacao))
     * @see ocean.jhotdraw.SpecificationDrawing#stopFigureFor(ocean.framework.Concept)
     */
    public SpecificationCompositeFigure stopFigureFor(Concept aComponent)
    {
        Concept auxComp = null;

        String concNameHeranca = Concept.conceptName(Heranca.class);
        String concNameAgregacao = Concept.conceptName(Agregacao.class);
        String concNameComposition = Concept.conceptName(Composition.class);
        String concNameAssociacao = Concept.conceptName(AssociacaoBinaria.class);
        String concNameDependency = Concept.conceptName(Dependency.class);
        String concNameRealization = Concept. conceptName(Realization.class);

        if (aComponent.conceptName().equals(concNameAgregacao))
        {
            auxComp = ((Agregacao) aComponent).agreggaterInstanceSpecification();
        }
        else if (aComponent.conceptName().equals(concNameAssociacao))
        {
            auxComp = ((AssociacaoBinaria) aComponent).instanceTerminal2();
        }
        else if (aComponent.conceptName().equals(concNameComposition))
        {
            auxComp = ((Composition) aComponent).agreggaterInstanceSpecification();
        }
        else if (aComponent.conceptName().equals(concNameHeranca))
        {
            auxComp = ((Heranca) aComponent).superInstance();
        }
        else if (aComponent.conceptName().equals(concNameDependency))
        {
            auxComp = ((Dependency) aComponent).dependencyInstance();
        }
        else if (aComponent.conceptName().equals(concNameRealization))
        {
            auxComp = ((Realization) aComponent).realizaterInstance();
        }
        return (SpecificationCompositeFigure) getFigureOfConcept(auxComp);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationDrawing#createDesiredLineForConcept(ocean.framework.Concept)
     */
    public SpecificationLineFigure createDesiredLineForConcept(Concept aComponent)
    {
        SpecificationLineFigure aLine = null;
        String concNameHeranca = Concept.conceptName(Heranca.class);
        String concNameAgregacao = Concept.conceptName(Agregacao.class);
        String concNameAssociacao = Concept.conceptName(AssociacaoBinaria.class);

        if (aComponent.conceptName().equals(concNameAgregacao))
        {
            aLine = new MObjAgregationLineFigure();
        }
        else if (aComponent.conceptName().equals(concNameAssociacao))
        {
            aLine = new MObjRelationshipLineFigure();
        }
        else if (aComponent.conceptName().equals(concNameHeranca))
        {
            aLine = new MObjInheritanceLineFigure();
        }

        return aLine;
    }

}