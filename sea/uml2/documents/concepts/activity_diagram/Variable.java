/*
 * @(#)Variable.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Mar 10, 2008        descrição
 */
package documents.concepts.activity_diagram;

import java.util.LinkedList;
import java.util.List;

import ocean.framework.Concept;
import ocean.smalltalk.OceanVector;
import documents.util.I18NProperties;

public class Variable extends Comment
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -7478120789722223323L;

    /**
     * The variables list.
     */
    private List<String> variablesList = new LinkedList<String>();

    /**
     * Official constructor.
     */
    public Variable()
    {
        super();
        name(I18NProperties.getString("variable.concept.name"));
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#conceptName()
     */
    public String conceptName()
    {
        return I18NProperties.getString("variable.concept.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("variable.concept.name.for.tree") + name();
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
     * @return the variablesList
     */
    public List<String> getVariablesList()
    {
        return variablesList;
    }

    /**
     * @param variablesList the variablesList to set
     */
    public void setVariablesList(List<String> variablesList)
    {
        this.variablesList = variablesList;
    }

}
