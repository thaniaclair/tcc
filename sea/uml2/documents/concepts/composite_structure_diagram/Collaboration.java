/*
 * @(#)Collaboration.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Feb 16, 2008        descrição
 */
package documents.concepts.composite_structure_diagram;

import java.util.LinkedList;
import java.util.List;

import ocean.documents.oo.concepts.Classe;
import ocean.framework.Concept;
import ocean.smalltalk.OceanVector;
import documents.util.I18NProperties;

public class Collaboration extends Concept
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 9171606982204581416L;

    /**
     * The collaboration name.
     */
    private String collaborationName = null;

    /**
     * A list of classes.
     */
    private List<Classe> classList = new LinkedList<Classe>();

    /**
     * Official constructor.
     */
    public Collaboration()
    {
        super();
        this.collaborationName = new String("Collaboration");
        name(I18NProperties.getString("collaboration.concept.name"));
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#conceptName()
     */
    public String conceptName()
    {
        return I18NProperties.getString("collaboration.concept.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("collaboration.concept.name.for.tree") + name();
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
     * @return the collaborationName
     */
    public String getCollaborationName()
    {
        return collaborationName;
    }

    /**
     * @param collaborationName the collaborationName to set
     */
    public void setCollaborationName(String collaborationName)
    {
        this.collaborationName = collaborationName;
    }

    /**
     * @return the classList
     */
    public List<Classe> getClassList()
    {
        return classList;
    }

    /**
     * @param classList the classList to set
     */
    public void setClassList(List<Classe> classList)
    {
        this.classList = classList;
    }
}
