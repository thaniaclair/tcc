package documents.models;

import ocean.framework.ConceptualModel;
import ocean.framework.SpecificationElement;
import ocean.jhotdraw.SpecificationDrawing;
import ocean.smalltalk.OceanVector;
import documents.concepts.communication_diagram.Label;
import documents.concepts.state_machine_diagram.*;
import documents.graphical.state_machine_diagram.StateMachineDiagramDrawing;
import documents.util.I18NProperties;

public class StateMachineDiagram extends ConceptualModel
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 2232046358676034753L;

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.ConceptualModel#initialize()
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public void initialize()
    {
        elementKeeperList = new OceanVector();
        elementKeeperList.add(SpecificationElement.construtor(Choice.class));
        elementKeeperList.add(SpecificationElement.construtor(EntryPoint.class));
        elementKeeperList.add(SpecificationElement.construtor(ExitPoint.class));
        elementKeeperList.add(SpecificationElement.construtor(FinalState.class));
        elementKeeperList.add(SpecificationElement.construtor(Fork.class));
        elementKeeperList.add(SpecificationElement.construtor(InitialState.class));
        elementKeeperList.add(SpecificationElement.construtor(Join.class));
        elementKeeperList.add(SpecificationElement.construtor(Junction.class));
        elementKeeperList.add(SpecificationElement.construtor(State.class));
        elementKeeperList.add(SpecificationElement.construtor(SubmachineState.class));
        elementKeeperList.add(SpecificationElement.construtor(Terminate.class));
        elementKeeperList.add(SpecificationElement.construtor(Transition.class));
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.ConceptualModel#createEmptyDrawing()
     */
    @Override
    public SpecificationDrawing createEmptyDrawing()
    {
        return new StateMachineDiagramDrawing();
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
        aList.add(Choice.class);
        aList.add(EntryPoint.class);
        aList.add(ExitPoint.class);
        aList.add(FinalState.class);
        aList.add(Fork.class);
        aList.add(InitialState.class);
        aList.add(Join.class);
        aList.add(Junction.class);
        aList.add(State.class);
        aList.add(SubmachineState.class);
        aList.add(Terminate.class);
        aList.add(Transition.class);
        return aList;
    }

    /*
     * (non-Javadoc) Realization
     * 
     * @see ocean.framework.ConceptualModel#modelName()
     */
    public String modelName()
    {
        return I18NProperties.getString("state.machine.diagram.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("state.machine.diagram.name.for.tree") + name;
    }

}
