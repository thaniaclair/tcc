package documents.models;

import ocean.documents.oo.concepts.AssociacaoBinaria;
import ocean.documents.oo.concepts.Heranca;
import ocean.documents.oo.concepts.UseCaseActor;
import ocean.framework.ConceptualModel;
import ocean.framework.SpecificationElement;
import ocean.jhotdraw.SpecificationDrawing;
import ocean.smalltalk.OceanVector;
import documents.concepts.communication_diagram.Label;
import documents.concepts.communication_diagram.Message;
import documents.concepts.communication_diagram.ReverseMessage;
import documents.concepts.object_diagram.Dependency;
import documents.concepts.object_diagram.InstanceSpecification;
import documents.graphical.communication_diagram.CommunicationDiagramDrawing;
import documents.util.I18NProperties;

public class CommunicationDiagram extends ConceptualModel
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
        elementKeeperList.add(SpecificationElement.construtor(Label.class));
        elementKeeperList.add(SpecificationElement.construtor(InstanceSpecification.class));
        elementKeeperList.add(SpecificationElement.construtor(AssociacaoBinaria.class));
        elementKeeperList.add(SpecificationElement.construtor(Message.class));
        elementKeeperList.add(SpecificationElement.construtor(ReverseMessage.class));
        elementKeeperList.add(SpecificationElement.construtor(UseCaseActor.class));
        elementKeeperList.add(SpecificationElement.construtor(Heranca.class));
        elementKeeperList.add(SpecificationElement.construtor(Dependency.class));
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.ConceptualModel#createEmptyDrawing()
     */
    @Override
    public SpecificationDrawing createEmptyDrawing()
    {
        return new CommunicationDiagramDrawing();
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
        aList.add(Label.class);
        aList.add(InstanceSpecification.class);
        aList.add(AssociacaoBinaria.class);
        aList.add(Message.class);
        aList.add(ReverseMessage.class);
        aList.add(UseCaseActor.class);
        aList.add(Heranca.class);
        aList.add(Dependency.class);
        return aList;
    }

    /*
     * (non-Javadoc) Realization
     * 
     * @see ocean.framework.ConceptualModel#modelName()
     */
    public String modelName()
    {
        return I18NProperties.getString("communication.diagram.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("communication.diagram.name.for.tree") + name;
    }

}