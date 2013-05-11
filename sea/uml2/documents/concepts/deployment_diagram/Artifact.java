/*
 * @(#)Artifact.java
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

public class Artifact extends Concept
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 1329096864188592714L;

    /**
     * The name of artifact.
     */
    private String artifactName = null;

    /**
     * The type of artifact.
     */
    private String artifactType = null;

    /**
     * Constructor.
     */
    public Artifact()
    {
        super();
        this.artifactName = new String("artefato");
        this.artifactType = new String("<<artifact>>");
        name(I18NProperties.getString("artifact.concept.name"));
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#conceptName()
     */
    public String conceptName()
    {
        return I18NProperties.getString("artifact.concept.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("artifact.concept.name.for.tree");
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
        return I18NProperties.getString("artifact.concept.name");
    }

    /**
     * @return the artifactName
     */
    public String getArtifactName()
    {
        return artifactName;
    }

    /**
     * @param artifactName the artifactName to set
     */
    public void setArtifactName(String artifactName)
    {
        this.artifactName = artifactName;
    }

    /**
     * @return the artifactType
     */
    public String getArtifactType()
    {
        return artifactType;
    }

    /**
     * @param artifactType the artifactType to set
     */
    public void setArtifactType(String artifactType)
    {
        this.artifactType = artifactType;
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