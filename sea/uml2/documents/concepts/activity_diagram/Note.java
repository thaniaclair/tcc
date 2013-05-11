/*
 * @(#)Note.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Mar 19, 2008        descrição
 */
package documents.concepts.activity_diagram;

import ocean.framework.Concept;
import ocean.smalltalk.OceanVector;
import documents.util.I18NProperties;

public class Note extends Concept
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 7739046036915738666L;

    /**
     * Official constructor.
     */
    public Note()
    {
        super();
        name(I18NProperties.getString("note.concept.name"));
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#conceptName()
     */
    public String conceptName()
    {
        return I18NProperties.getString("note.concept.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("note.concept.name.for.tree") + name();
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
}
