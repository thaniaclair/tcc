package documents.models;

import ocean.documents.oo.concepts.AssociacaoBinaria;
import ocean.documents.oo.concepts.Classe;
import ocean.documents.oo.concepts.Heranca;
import ocean.framework.ConceptualModel;
import ocean.framework.SpecificationElement;
import ocean.jhotdraw.SpecificationDrawing;
import ocean.smalltalk.OceanVector;
import documents.concepts.object_diagram.Dependency;
import documents.concepts.object_diagram.Realization;
import documents.concepts.package_diagram.*;
import documents.concepts.package_diagram.Package;
import documents.graphical.package_diagram.PackageDiagramDrawing;
import documents.util.I18NProperties;

public class PackageDiagram extends ConceptualModel
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 1728189157639079058L;

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.ConceptualModel#initialize()
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public void initialize()
    {
        elementKeeperList = new OceanVector();
        elementKeeperList.add(SpecificationElement.construtor(AssociacaoBinaria.class));
        elementKeeperList.add(SpecificationElement.construtor(Heranca.class));
        elementKeeperList.add(SpecificationElement.construtor(Dependency.class));
        elementKeeperList.add(SpecificationElement.construtor(Realization.class));
        elementKeeperList.add(SpecificationElement.construtor(Access.class));
        elementKeeperList.add(SpecificationElement.construtor(Import.class));
        elementKeeperList.add(SpecificationElement.construtor(Merge.class));
        elementKeeperList.add(SpecificationElement.construtor(Package.class));
        elementKeeperList.add(SpecificationElement.construtor(Classe.class));
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.ConceptualModel#createEmptyDrawing()
     */
    @Override
    public SpecificationDrawing createEmptyDrawing()
    {
        return new PackageDiagramDrawing();
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
        aList.add(AssociacaoBinaria.class);
        aList.add(Heranca.class);
        aList.add(Dependency.class);
        aList.add(Realization.class);
        aList.add(Access.class);
        aList.add(Import.class);
        aList.add(Merge.class);
        aList.add(Package.class);
        // aList.add(Subsystem.class);
        aList.add(Classe.class);
        return aList;
    }

    /*
     * (non-Javadoc) Realization
     * 
     * @see ocean.framework.ConceptualModel#modelName()
     */
    public String modelName()
    {
        return I18NProperties.getString("package.diagram.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("package.diagram.name.for.tree") + name;
    }

}
