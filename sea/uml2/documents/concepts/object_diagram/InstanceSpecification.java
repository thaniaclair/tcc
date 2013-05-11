package documents.concepts.object_diagram;

import java.util.LinkedHashMap;
import java.util.Map;

import ocean.documents.oo.concepts.Classe;
import ocean.framework.Concept;
import documents.util.I18NProperties;

public class InstanceSpecification extends Concept
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 2269841840215432627L;

    /**
     * The class concept.
     */
    private Classe classConcept = null;

    /**
     * The instance stereotype.
     */
    private String instanceType = null;

    /**
     * The attributes of the object.
     */
    private Map<String, String> attributes = null;

    /**
     * Official constructor.
     */
    public InstanceSpecification()
    {
        super();
        this.instanceType = new String("<<instance specification>>");
        this.attributes = new LinkedHashMap<String, String>();
        name(I18NProperties.getString("object.concept.name"));
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#conceptName()
     */
    public String conceptName()
    {
        return I18NProperties.getString("object.concept.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("object.concept.name.for.tree") + name();
    }

    /**
     * Returns the class.
     * 
     * @return
     */
    public Classe conceptClass()
    {
        if (this.classConcept == null)
        {
            this.classConcept = new Classe();
            this.classConcept.name("Class");
        }
        return this.classConcept;
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#mustHaveName()
     */
    public boolean mustHaveName()
    {
        return false;
    }

    /**
     * @return the instanceType
     */
    public String getInstanceType()
    {
        return instanceType;
    }

    /**
     * @param instanceType the instanceType to set
     */
    public void setInstanceType(String instanceType)
    {
        this.instanceType = instanceType;
    }

    /**
     * @return the attributes
     */
    public Map<String, String> getAttributes()
    {
        return attributes;
    }

    /**
     * @param attributes the attributes to set
     */
    public void setAttributes(Map<String, String> attributes)
    {
        this.attributes = attributes;
    }

}