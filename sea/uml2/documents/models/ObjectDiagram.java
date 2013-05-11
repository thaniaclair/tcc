package documents.models;

import ocean.documents.oo.concepts.*;
import ocean.framework.ConceptualModel;
import ocean.framework.SpecificationElement;
import ocean.jhotdraw.SpecificationDrawing;
import ocean.smalltalk.OceanVector;
import documents.concepts.object_diagram.Dependency;
import documents.concepts.object_diagram.Realization;
import documents.graphical.object_diagram.ObjectDiagramDrawing;
import documents.util.I18NProperties;

public class ObjectDiagram extends ConceptualModel
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 5511381289512273235L;

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.ConceptualModel#initialize()
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public void initialize()
    {
        elementKeeperList = new OceanVector();
        elementKeeperList.add(SpecificationElement
            .construtor(documents.concepts.object_diagram.InstanceSpecification.class));
        elementKeeperList.add(SpecificationElement.construtor(AssociacaoBinaria.class));
        elementKeeperList.add(SpecificationElement.construtor(Heranca.class));
        elementKeeperList.add(SpecificationElement.construtor(Agregacao.class));
        elementKeeperList.add(SpecificationElement.construtor(Composition.class));
        elementKeeperList.add(SpecificationElement.construtor(Dependency.class));
        elementKeeperList.add(SpecificationElement.construtor(Realization.class));
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.ConceptualModel#createEmptyDrawing()
     */
    @Override
    public SpecificationDrawing createEmptyDrawing()
    {
        return new ObjectDiagramDrawing();
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
        aList.add(documents.concepts.object_diagram.InstanceSpecification.class);
        aList.add(AssociacaoBinaria.class);
        aList.add(Agregacao.class);
        aList.add(Composition.class);
        aList.add(Heranca.class);
        aList.add(Dependency.class);
        aList.add(Realization.class);
        return aList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.ConceptualModel#modelName()
     */
    public String modelName()
    {
        return I18NProperties.getString("object.model.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("object.model.name.for.tree") + name;
    }

}
