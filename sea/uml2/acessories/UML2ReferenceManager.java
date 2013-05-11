package acessories;

import ocean.accessories.AuxWindowAppModel;
import ocean.accessories.ReferenceManager;
import documents.graphical.communication_diagram.CommunicationDiagramWindow;
import documents.graphical.component_diagram.ComponentDiagramWindow;
import documents.graphical.composite_structure_diagram.CompositeStructureDiagramWindow;
import documents.graphical.deployment_diagram.DeploymentDiagramWindow;
import documents.graphical.object_diagram.ObjectDiagramWindow;
import documents.graphical.package_diagram.PackageDiagramWindow;
import documents.graphical.state_machine_diagram.StateMachineDiagramWindow;
import documents.models.*;

public class UML2ReferenceManager extends ReferenceManager
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 2228247889347210210L;

    /*
     * (non-Javadoc)
     * 
     * @see ocean.accessories.ReferenceManager#initialize()
     */
    public void initialize()
    {
        super.initialize();
        concModelWindowDict.at_put(ObjectDiagram.class, ObjectDiagramWindow.class);
        this.conceptWindowDict().at_put(ObjectDiagram.class, AuxWindowAppModel.class);
        concModelWindowDict.at_put(PackageDiagram.class, PackageDiagramWindow.class);
        this.conceptWindowDict().at_put(PackageDiagram.class, AuxWindowAppModel.class);
        concModelWindowDict.at_put(ComponentDiagram.class, ComponentDiagramWindow.class);
        this.conceptWindowDict().at_put(ComponentDiagram.class, AuxWindowAppModel.class);
        concModelWindowDict.at_put(DeploymentDiagram.class, DeploymentDiagramWindow.class);
        this.conceptWindowDict().at_put(DeploymentDiagram.class, AuxWindowAppModel.class);
        concModelWindowDict.at_put(CommunicationDiagram.class, CommunicationDiagramWindow.class);
        this.conceptWindowDict().at_put(CommunicationDiagram.class, AuxWindowAppModel.class);
        concModelWindowDict.at_put(CompositeStructureDiagram.class,
            CompositeStructureDiagramWindow.class);
        this.conceptWindowDict().at_put(CompositeStructureDiagram.class, AuxWindowAppModel.class);
        concModelWindowDict.at_put(StateMachineDiagram.class, StateMachineDiagramWindow.class);
        this.conceptWindowDict().at_put(StateMachineDiagram.class, AuxWindowAppModel.class);
    }
}
