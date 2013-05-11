package documents.specifications;

import ocean.documents.oo.specifications.SEASpecification;
import ocean.smalltalk.OceanVector;
import documents.models.*;
import documents.util.I18NProperties;

public class UML2SEASpecification extends SEASpecification
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 3621842892413105154L;

    /**
     * Constructor.
     */
    public UML2SEASpecification()
    {
        super();
    }

    /**
     * @param documentCode The document code.
     */
    public UML2SEASpecification(String documentCode)
    {
        super(documentCode);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Specification#modeloLista()
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public OceanVector modeloLista()
    {
        OceanVector aList = super.modeloLista();
        aList.add(ObjectDiagram.class);
        aList.add(PackageDiagram.class);
        aList.add(ComponentDiagram.class);
        aList.add(DeploymentDiagram.class);
        aList.add(CommunicationDiagram.class);
        aList.add(CompositeStructureDiagram.class);
        aList.add(StateMachineDiagram.class);
        aList.add(ActivityDiagram.class);
        return aList;
    }

    /**
     * Gets the id type.
     */
    public static String getIdType()
    {
        return "uml2.specification";
    }

    /**
     * Gets the ID.
     */
    public static String getId()
    {
        return I18NProperties.getString("uml2.specification");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("uml2.specification.for.tree");
    }

}
