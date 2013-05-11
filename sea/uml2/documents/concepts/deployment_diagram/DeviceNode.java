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

public class DeviceNode extends Concept
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -420849473419893304L;

    /**
     * The device name.
     */
    private String deviceName = null;

    /**
     * The device type.
     */
    private String deviceType = null;

    /**
     * Constructor.
     */
    public DeviceNode()
    {
        super();
        this.deviceName = new String("node");
        this.deviceType = new String("<<device>>");
        name(I18NProperties.getString("device.node.concept.name"));
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#conceptName()
     */
    public String conceptName()
    {
        return I18NProperties.getString("device.node.concept.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("device.node.concept.name.for.tree");
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
        return I18NProperties.getString("device.node.concept.name");
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
     * @return the deviceName
     */
    public String getDeviceName()
    {
        return deviceName;
    }

    /**
     * @param deviceName the deviceName to set
     */
    public void setDeviceName(String deviceName)
    {
        this.deviceName = deviceName;
    }

    /**
     * @return the deviceType
     */
    public String getDeviceType()
    {
        return deviceType;
    }

    /**
     * @param deviceType the deviceType to set
     */
    public void setDeviceType(String deviceType)
    {
        this.deviceType = deviceType;
    }

}