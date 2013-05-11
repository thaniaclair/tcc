/*
 * @(#)CollaborationUse.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Feb 16, 2008        descrição
 */
package documents.concepts.composite_structure_diagram;

import ocean.framework.Concept;
import ocean.smalltalk.OceanVector;
import documents.util.I18NProperties;

public class CollaborationUse extends Concept
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 8499089419314320527L;

    /**
     * The collaboration name.
     */
    private String collaborationUseName = null;

    /**
     * Official constructor.
     */
    public CollaborationUse()
    {
        super();
        this.collaborationUseName = new String("Collaboration Use");
        name(I18NProperties.getString("collaboration.use.concept.name"));
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#conceptName()
     */
    public String conceptName()
    {
        return I18NProperties.getString("collaboration.use.concept.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("collaboration.use.concept.name.for.tree") + name();
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

    /*
     * FIXME (non-Javadoc)
     * 
     * @see ocean.framework.Concept#duplicityIn(ocean.smalltalk.OceanVector)
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public Concept duplicityIn(OceanVector aConceptList)
    {
        return super.duplicityIn(aConceptList);
    }

    /**
     * @return the collaborationUseName
     */
    public String getCollaborationUseName()
    {
        return collaborationUseName;
    }

    /**
     * @param collaborationUseName the collaborationUseName to set
     */
    public void setCollaborationUseName(String collaborationUseName)
    {
        this.collaborationUseName = collaborationUseName;
    }

}
