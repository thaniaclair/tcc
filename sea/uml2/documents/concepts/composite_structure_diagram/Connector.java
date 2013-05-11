/*
 * @(#)Connector.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Feb 16, 2008        descrição
 */
package documents.concepts.composite_structure_diagram;

import ocean.framework.Concept;
import ocean.smalltalk.OceanVector;
import documents.concepts.component_diagram.Port;
import documents.util.I18NProperties;

public class Connector extends Concept
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 9171606982204581416L;

    private Port portTerminal1 = null;

    private Port portTerminal2 = null;

    /**
     * Official constructor.
     */
    public Connector()
    {
        super();
        name(I18NProperties.getString("connector.concept.name"));
    }

    /**
     * @param connecterPort
     * @param connectedPort
     */
    public Connector(Port port1, Port port2)
    {
        this.portTerminal1(port1);
        this.portTerminal2(port2);
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#attacherComponent()
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public Object attacherComponent()
    {
        OceanVector auxList = new OceanVector();
        auxList.add(this.portTerminal1());
        auxList.add(this.portTerminal2());
        return auxList;
    }

    /**
     * @return
     */
    public Port portTerminal2()
    {
        return this.portTerminal2;
    }

    /**
     * @return
     */
    public Port portTerminal1()
    {
        return this.portTerminal1;
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#attacherComponent()
     */
    public void portTerminal1(Port port1)
    {
        this.portTerminal1 = port1;
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#attacherComponent()
     */
    public void portTerminal2(Port port2)
    {
        this.portTerminal2 = port2;
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#conceptName()
     */
    public String conceptName()
    {
        return I18NProperties.getString("connector.concept.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("connector.concept.name.for.tree") + name();
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