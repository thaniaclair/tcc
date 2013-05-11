/*
 * @(#)Package.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Jan 5, 2008        descrição
 */
package documents.concepts.package_diagram;

import java.util.LinkedList;
import java.util.List;

import ocean.documents.oo.concepts.Classe;
import ocean.framework.Concept;
import documents.util.I18NProperties;

public class Package extends Concept
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 199788668070128202L;

    /**
     * The name of the package.
     */
    private String packageName = null;

    /**
     * A list of classes.
     */
    private List<Classe> classList = new LinkedList<Classe>();

    /**
     * Official constructor.
     */
    public Package()
    {
        super();
        this.packageName = new String("package");
        name("package");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#conceptName()
     */
    public String conceptName()
    {
        return I18NProperties.getString("package.concept.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("package.concept.name.for.tree") + name();
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
     * @return the packageName
     */
    public String getPackageName()
    {
        return packageName;
    }

    /**
     * @param packageName the packageName to set
     */
    public void setPackageName(String packageName)
    {
        this.packageName = packageName;
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
