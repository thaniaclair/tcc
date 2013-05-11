/*
 * @(#)SubmachineState.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Feb 21, 2008        descrição
 */
package documents.concepts.state_machine_diagram;

import java.util.LinkedList;
import java.util.List;

import ocean.framework.Concept;
import ocean.smalltalk.OceanVector;
import documents.util.I18NProperties;

public class SubmachineState extends Concept
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 8953832714544751186L;

    /**
     * The description of the submachine.
     */
    private String submachineDescription = null;

    /**
     * The state list.
     */
    private List<State> stateList = new LinkedList<State>();

    /**
     * Official constructor.
     */
    public SubmachineState()
    {
        super();
        this.submachineDescription = new String("submachine");
        name(I18NProperties.getString("submachine.state.concept.name"));
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#conceptName()
     */
    public String conceptName()
    {
        return I18NProperties.getString("submachine.state.concept.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("submachine.state.concept.name.for.tree") + name();
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
     * @return the submachineDescription
     */
    public String getSubmachineDescription()
    {
        return submachineDescription;
    }

    /**
     * @param submachineDescription the submachineDescription to set
     */
    public void setSubmachineDescription(String submachineDescription)
    {
        this.submachineDescription = submachineDescription;
    }

    /**
     * @return the stateList
     */
    public List<State> getStateList()
    {
        return stateList;
    }

    /**
     * @param stateList the stateList to set
     */
    public void setStateList(List<State> stateList)
    {
        this.stateList = stateList;
    }

}
