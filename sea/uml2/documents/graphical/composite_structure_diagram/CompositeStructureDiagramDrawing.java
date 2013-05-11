/*
 * @(#)CompositeStructureDiagramDrawing.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Feb 16, 2008        descrição
 */
package documents.graphical.composite_structure_diagram;

import ocean.documents.oo.concepts.*;
import ocean.framework.Concept;
import ocean.jhotdraw.*;
import ocean.jhotdraw.figures.ClasseFigure;
import documents.concepts.component_diagram.Interface;
import documents.concepts.component_diagram.Port;
import documents.concepts.composite_structure_diagram.*;
import documents.concepts.object_diagram.Dependency;
import documents.concepts.object_diagram.Realization;
import documents.graphical.component_diagram.InterfaceFigure;
import documents.graphical.component_diagram.PortFigure;
import documents.graphical.object_diagram.*;
import documents.graphical.object_diagram.AssociationLineConnection;

public class CompositeStructureDiagramDrawing extends SpecificationDrawing
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 6497200982930948782L;

    /**
     * Official constructor.
     */
    public CompositeStructureDiagramDrawing()
    {
        super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationDrawing#createDesiredFigureForConcept(ocean.framework.Concept)
     */
    @Override
    public SpecificationCompositeFigure createDesiredFigureForConcept(Concept concept)
    {
        SpecificationCompositeFigure figure = null;
        if (concept instanceof Part)
        {
            figure = new PartFigure();
        }
        else if (concept instanceof Property)
        {
            figure = new PropertyFigure();
        }
        else if (concept instanceof Port)
        {
            figure = new PortFigure();
        }
        else if (concept instanceof Interface)
        {
            figure = new InterfaceFigure();
        }
        else if (concept instanceof Collaboration)
        {
            figure = new CollaborationFigure();
        }
        else if (concept instanceof CollaborationUse)
        {
            figure = new CollaborationUseFigure();
        }
        else if (concept instanceof Classe)
        {
            figure = new ClasseFigure();
        }
        return figure;
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationDrawing#createDesiredLineForConcept(ocean.framework.Concept)
     */
    @Override
    public SpecificationLineFigure createDesiredLineForConcept(Concept concept)
    {
        SpecificationLineFigure figure = null;
        if (concept instanceof AssociacaoBinaria)
        {
            figure = new AssociationLineConnection();
        }
        else if (concept instanceof Agregacao)
        {
            figure = new AggregationLineConnection();
        }
        else if (concept instanceof Composition)
        {
            figure = new CompositionLineConnection();
        }
        else if (concept instanceof Heranca)
        {
            figure = new InheritanceLineConnection();
        }
        else if (concept instanceof Realization)
        {
            figure = new RealizationLineConnection();
        }
        else if (concept instanceof Dependency)
        {
            figure = new DependencyLineConnection();
        }
        else if (concept instanceof Connector)
        {
            figure = new ConnectorFigure();
        }
        else if (concept instanceof Occurrence)
        {
            figure = new OccurrenceFigure();
        }
        else if (concept instanceof Represents)
        {
            figure = new RepresentsFigure();
        }
        return figure;
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationDrawing#startFigureFor(ocean.framework.Concept)
     */
    @Override
    public SpecificationCompositeFigure startFigureFor(Concept component)
    {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.jhotdraw.SpecificationDrawing#stopFigureFor(ocean.framework.Concept)
     */
    @Override
    public SpecificationCompositeFigure stopFigureFor(Concept component)
    {
        return null;
    }

}
