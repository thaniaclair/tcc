/*
 * @(#)State.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Feb 21, 2008        descrição
 */
package documents.concepts.state_machine_diagram;

import ocean.framework.Concept;
import ocean.smalltalk.OceanVector;
import documents.util.I18NProperties;

public class State extends Concept
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 4626406144916156273L;

    /**
     * The description of the state.
     */
    private String stateDescription = null;

    /**
     * Official constructor.
     */
    public State()
    {
        super();
        this.stateDescription = new String("state");
        name(I18NProperties.getString("state.concept.name"));
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#conceptName()
     */
    public String conceptName()
    {
        return I18NProperties.getString("state.concept.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("state.concept.name.for.tree") + name();
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
     * @return the stateDescription
     */
    public String getStateDescription()
    {
        return stateDescription;
    }

    /**
     * @param stateDescription the stateDescription to set
     */
    public void setStateDescription(String stateDescription)
    {
        this.stateDescription = stateDescription;
    }

}