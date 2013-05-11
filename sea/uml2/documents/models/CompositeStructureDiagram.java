package documents.models;

import ocean.documents.oo.concepts.*;
import ocean.framework.ConceptualModel;
import ocean.framework.SpecificationElement;
import ocean.jhotdraw.SpecificationDrawing;
import ocean.smalltalk.OceanVector;
import documents.concepts.component_diagram.Interface;
import documents.concepts.component_diagram.Port;
import documents.concepts.composite_structure_diagram.*;
import documents.concepts.object_diagram.Dependency;
import documents.concepts.object_diagram.InstanceSpecification;
import documents.concepts.object_diagram.Realization;
import documents.graphical.composite_structure_diagram.CompositeStructureDiagramDrawing;
import documents.util.I18NProperties;

public class CompositeStructureDiagram extends ConceptualModel
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -73604485105160495L;

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.ConceptualModel#initialize()
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public void initialize()
    {
        elementKeeperList = new OceanVector();
        elementKeeperList.add(SpecificationElement.construtor(Classe.class));
        elementKeeperList.add(SpecificationElement.construtor(InstanceSpecification.class));
        elementKeeperList.add(SpecificationElement.construtor(Part.class));
        elementKeeperList.add(SpecificationElement.construtor(Property.class));
        elementKeeperList.add(SpecificationElement.construtor(Port.class));
        elementKeeperList.add(SpecificationElement.construtor(Interface.class));
        elementKeeperList.add(SpecificationElement.construtor(AssociacaoBinaria.class));
        elementKeeperList.add(SpecificationElement.construtor(Agregacao.class));
        elementKeeperList.add(SpecificationElement.construtor(Composition.class));
        elementKeeperList.add(SpecificationElement.construtor(Heranca.class));
        elementKeeperList.add(SpecificationElement.construtor(Dependency.class));
        elementKeeperList.add(SpecificationElement.construtor(Realization.class));
        elementKeeperList.add(SpecificationElement.construtor(Connector.class));
        elementKeeperList.add(SpecificationElement.construtor(Collaboration.class));
        elementKeeperList.add(SpecificationElement.construtor(CollaborationUse.class));
        elementKeeperList.add(SpecificationElement.construtor(Represents.class));
        elementKeeperList.add(SpecificationElement.construtor(Occurrence.class));
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.ConceptualModel#createEmptyDrawing()
     */
    @Override
    public SpecificationDrawing createEmptyDrawing()
    {
        return new CompositeStructureDiagramDrawing();
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
        aList.add(InstanceSpecification.class);
        aList.add(Classe.class);
        aList.add(Part.class);
        aList.add(Property.class);
        aList.add(Port.class);
        aList.add(Interface.class);
        aList.add(AssociacaoBinaria.class);
        aList.add(Agregacao.class);
        aList.add(Composition.class);
        aList.add(Heranca.class);
        aList.add(Dependency.class);
        aList.add(Realization.class);
        aList.add(Connector.class);
        aList.add(Collaboration.class);
        aList.add(CollaborationUse.class);
        aList.add(Represents.class);
        aList.add(Occurrence.class);
        return aList;
    }

    /*
     * (non-Javadoc) Realization
     * 
     * @see ocean.framework.ConceptualModel#modelName()
     */
    public String modelName()
    {
        return I18NProperties.getString("composite.diagram.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("composite.diagram.name.for.tree") + name;
    }

}
