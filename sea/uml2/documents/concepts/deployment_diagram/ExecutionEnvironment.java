/*
 * @(#)Node.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Jan 24, 2008        descrição
 */
package documents.concepts.deployment_diagram;

import ocean.framework.Concept;
import ocean.smalltalk.OceanVector;
import documents.util.I18NProperties;

public class ExecutionEnvironment extends Concept
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -6669535748463091739L;

    /**
     * The execution environment name.
     */
    private String executionName = null;

    /**
     * The execution environment type.
     */
    private String executionType = null;

    /**
     * Constructor.
     */
    public ExecutionEnvironment()
    {
        super();
        this.executionName = new String("node");
        this.executionType = new String("<<execution environment>>");
        name(I18NProperties.getString("execution.concept.name"));
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#conceptName()
     */
    public String conceptName()
    {
        return I18NProperties.getString("execution.concept.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("execution.concept.name.for.tree");
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
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#name()
     */
    public String name()
    {
        return I18NProperties.getString("execution.concept.name");
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
     * @return the executionName
     */
    public String getExecutionName()
    {
        return executionName;
    }

    /**
     * @param executionName the executionName to set
     */
    public void setExecutionName(String executionName)
    {
        this.executionName = executionName;
    }

    /**
     * @return the executionType
     */
    public String getExecutionType()
    {
        return executionType;
    }

    /**
     * @param executionType the executionType to set
     */
    public void setExecutionType(String executionType)
    {
        this.executionType = executionType;
    }

}