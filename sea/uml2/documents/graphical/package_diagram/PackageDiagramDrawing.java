/*
 * @(#)PackageDiagramDrawing.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Jan 5, 2008        descrição
 */
package documents.graphical.package_diagram;

import java.awt.Rectangle;

import CH.ifa.draw.framework.Figure;
import CH.ifa.draw.framework.FigureEnumeration;
import ocean.documents.oo.concepts.AssociacaoBinaria;
import ocean.documents.oo.concepts.Classe;
import ocean.documents.oo.concepts.Heranca;
import ocean.documents.oo.graphical.classDiagram.MObjInheritanceLineFigure;
import ocean.documents.oo.graphical.classDiagram.MObjRelationshipLineFigure;
import ocean.framework.Concept;
import ocean.jhotdraw.SpecificationCompositeFigure;
import ocean.jhotdraw.SpecificationDrawing;
import ocean.jhotdraw.SpecificationLineFigure;
import documents.concepts.object_diagram.Dependency;
import documents.concepts.object_diagram.Realization;
import documents.concepts.package_diagram.Access;
import documents.concepts.package_diagram.Import;
import documents.concepts.package_diagram.Merge;
import documents.graphical.composite_structure_diagram.ExtendedClassFigure;
import documents.graphical.object_diagram.DependencyLineConnection;
import documents.graphical.object_diagram.RealizationLineConnection;

public class PackageDiagramDrawing extends SpecificationDrawing
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 2297179739301305415L;

    /**
     * Official constructor.
     */
    public PackageDiagramDrawing()
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
        if (component instanceof documents.concepts.package_diagram.Package)
        {
            figure = new PackageFigure();
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
        String concNameAssociacao = Concept.conceptName(AssociacaoBinaria.class);

        String concNameAccess = Concept.conceptName(Access.class);
        String concNameImport = Concept.conceptName(Import.class);
        String concNameMerge = Concept.conceptName(Merge.class);
        String concNameDep = Concept.conceptName(Dependency.class);
        String concNameRealization = Concept.conceptName(Realization.class);

        if (aComponent.conceptName().equals(concNameAssociacao))
        {
            auxComp = ((AssociacaoBinaria) aComponent).classeTerminal1();
        }
        else if (aComponent.conceptName().equals(concNameHeranca))
        {
            auxComp = ((Heranca) aComponent).subclasse();
        }
        else if (aComponent.conceptName().equals(concNameAccess))
        {
            auxComp = ((Access) aComponent).accessedPackage();
        }
        else if (aComponent.conceptName().equals(concNameImport))
        {
            auxComp = ((Import) aComponent).importedPackage();
        }
        else if (aComponent.conceptName().equals(concNameMerge))
        {
            auxComp = ((Merge) aComponent).mergedPackage();
        }
        else if (aComponent.conceptName().equals(concNameDep))
        {
            auxComp = ((Dependency) aComponent).dependencyPackage();
        }
        else if (aComponent.conceptName().equals(concNameRealization))
        {
            auxComp = ((Realization) aComponent).realizatedPackage();
        }
        return (SpecificationCompositeFigure) getFigureOfConcept(auxComp);
    }

    /*
     * (non-Javadoc) mponent.conceptName().equals(concNameAssociacao))
     * 
     * @see ocean.jhotdraw.SpecificationDrawing#stopFigureFor(ocean.framework.Concept)
     */
    public SpecificationCompositeFigure stopFigureFor(Concept aComponent)
    {
        Concept auxComp = null;

        String concNameHeranca = Concept.conceptName(Heranca.class);
        String concNameAssociacao = Concept.conceptName(AssociacaoBinaria.class);

        String concNameAccess = Concept.conceptName(Access.class);
        String concNameImport = Concept.conceptName(Import.class);
        String concNameMerge = Concept.conceptName(Merge.class);
        String concNameDependency = Concept.conceptName(Dependency.class);
        String concNameRealization = Concept.conceptName(Realization.class);

        if (aComponent.conceptName().equals(concNameAssociacao))
        {
            auxComp = ((AssociacaoBinaria) aComponent).classeTerminal2();
        }
        else if (aComponent.conceptName().equals(concNameHeranca))
        {
            auxComp = ((Heranca) aComponent).superclasse();
        }
        else if (aComponent.conceptName().equals(concNameAccess))
        {
            auxComp = ((Access) aComponent).accesserPackage();
        }
        else if (aComponent.conceptName().equals(concNameImport))
        {
            auxComp = ((Import) aComponent).importerPackage();
        }
        else if (aComponent.conceptName().equals(concNameMerge))
        {
            auxComp = ((Merge) aComponent).mergerPackage();
        }
        else if (aComponent.conceptName().equals(concNameDependency))
        {
            auxComp = ((Dependency) aComponent).dependentPackage();
        }
        else if (aComponent.conceptName().equals(concNameRealization))
        {
            auxComp = ((Realization) aComponent).realizaterPackage();
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
        String concNameAssociacao = Concept.conceptName(AssociacaoBinaria.class);

        String concNameAccess = Concept.conceptName(Access.class);
        String concNameImport = Concept.conceptName(Import.class);
        String concNameMerge = Concept.conceptName(Merge.class);
        String concNameDependency = Concept.conceptName(Dependency.class);
        String concNameRealization = Concept.conceptName(Realization.class);

        if (aComponent.conceptName().equals(concNameAssociacao))
        {
            aLine = new MObjRelationshipLineFigure();
        }
        else if (aComponent.conceptName().equals(concNameHeranca))
        {
            aLine = new MObjInheritanceLineFigure();
        }
        else if (aComponent.conceptName().equals(concNameAccess))
        {
            aLine = new AccessLineConnection();
        }
        else if (aComponent.conceptName().equals(concNameImport))
        {
            aLine = new ImportLineConnection();
        }
        else if (aComponent.conceptName().equals(concNameMerge))
        {
            aLine = new MergeLineConnection();
        }
        else if (aComponent.conceptName().equals(concNameDependency))
        {
            aLine = new DependencyLineConnection();
        }
        else if (aComponent.conceptName().equals(concNameRealization))
        {
            aLine = new RealizationLineConnection();
        }

        return aLine;
    }

}
