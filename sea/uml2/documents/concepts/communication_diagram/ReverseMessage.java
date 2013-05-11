/*
 * @(#)ReverseMessage.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Feb 9, 2008        descrição
 */
package documents.concepts.communication_diagram;

import ocean.framework.Concept;
import ocean.smalltalk.OceanVector;
import documents.util.I18NProperties;

public class ReverseMessage extends Concept
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -3118364627779217321L;

    /**
     * The name of the message.
     */
    private String messageName = null;

    /**
     * The number of the message.
     */
    private String messageNumber = null;

    /**
     * The degree of the message arrow.
     */
    private int degreeArrow = 0;

    /**
     * Official constructor.
     */
    public ReverseMessage()
    {
        super();
        this.messageName = new String("reverseMessage()");
        this.messageNumber = new String("1");
        this.degreeArrow = 0;
        name(I18NProperties.getString("reverse.message.concept.name"));
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#conceptName()
     */
    public String conceptName()
    {
        return I18NProperties.getString("reverse.message.concept.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("reverse.message.concept.name.for.tree") + name();
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
     * @return the messageName
     */
    public String getMessageName()
    {
        return messageName;
    }

    /**
     * @param messageName the messageName to set
     */
    public void setMessageName(String messageName)
    {
        this.messageName = messageName;
    }

    /**
     * @return the messageNumber
     */
    public String getMessageNumber()
    {
        return messageNumber;
    }

    /**
     * @param messageNumber the messageNumber to set
     */
    public void setMessageNumber(String messageNumber)
    {
        this.messageNumber = messageNumber;
    }

    /**
     * @return the degreeArrow
     */
    public int getDegreeArrow()
    {
        return degreeArrow;
    }

    /**
     * @param degreeArrow the degreeArrow to set
     */
    public void setDegreeArrow(int degreeArrow)
    {
        this.degreeArrow = degreeArrow;
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