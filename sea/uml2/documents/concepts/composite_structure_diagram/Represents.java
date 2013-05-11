/*
 * @(#)Represents.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Feb 16, 2008        descrição
 */
package documents.concepts.composite_structure_diagram;

import ocean.documents.oo.concepts.Classe;
import ocean.framework.Concept;
import ocean.smalltalk.OceanVector;
import documents.concepts.component_diagram.Interface;
import documents.util.I18NProperties;

public class Represents extends Concept
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 5062289980503642051L;

    private Interface representedInterface;

    private Interface representerInterface;

    private Collaboration representedCollaboration;

    private Collaboration representerCollaboration;

    private CollaborationUse representedCollaborationUse;

    private CollaborationUse representerCollaborationUse;

    private Classe representedClass;

    private Classe representerClass;

    /**
     * Official constructor.
     */
    public Represents()
    {
        super();
        name(I18NProperties.getString("represents.concept.name"));
    }

    /**
     * @param interface1
     * @param interface2
     */
    public Represents(Interface interface1, Interface interface2)
    {
        this();
        this.representerInterface(interface1);
        this.representedInterface(interface2);
    }

    /**
     * @param interface1
     * @param collaboration
     */
    public Represents(Interface interface1, Collaboration collaboration)
    {
        this();
        this.representerInterface(interface1);
        this.representedCollaboration(collaboration);
    }

    /**
     * @param collaboration
     * @param interface1
     */
    public Represents(Collaboration collaboration, Interface interface1)
    {
        this();
        this.representerCollaboration(collaboration);
        this.representedInterface(interface1);
    }

    /**
     * @param interface1
     * @param collaboration
     */
    public Represents(Interface interface1, CollaborationUse collaboration)
    {
        this();
        this.representerInterface(interface1);
        this.representedCollaborationUse(collaboration);
    }

    /**
     * @param collaboration
     * @param interface1
     */
    public Represents(CollaborationUse collaboration, Interface interface1)
    {
        this();
        this.representerCollaborationUse(collaboration);
        this.representedInterface(interface1);
    }

    /**
     * @param classe
     * @param classe2
     */
    public Represents(Classe classe, Classe classe2)
    {
        this();
        this.representerClass(classe);
        this.representedClass(classe2);
    }

    /**
     * @param classe
     * @param interface1
     */
    public Represents(Classe classe, Interface interface1)
    {
        this();
        this.representerClass(classe);
        this.representedInterface(interface1);
    }

    /**
     * @param interface1
     * @param classe
     */
    public Represents(Interface interface1, Classe classe)
    {
        this();
        this.representerInterface(interface1);
        this.representedClass(classe);
    }

    /**
     * @param classe
     * @param collaboration
     */
    public Represents(Classe classe, Collaboration collaboration)
    {
        this();
        this.representerClass(classe);
        this.representedCollaboration(collaboration);
    }

    /**
     * @param classe
     * @param collaboration
     */
    public Represents(Collaboration collaboration, Classe classe)
    {
        this();
        this.representerCollaboration(collaboration);
        this.representedClass(classe);
    }

    /**
     * @param classe
     * @param collaboration
     */
    public Represents(Classe classe, CollaborationUse collaboration)
    {
        this();
        this.representerClass(classe);
        this.representedCollaborationUse(collaboration);
    }

    /**
     * @param classe
     * @param collaboration
     */
    public Represents(CollaborationUse collaboration, Classe classe)
    {
        this();
        this.representerCollaborationUse(collaboration);
        this.representedClass(classe);
    }

    /**
     * @param collaboration
     * @param collaboration2
     */
    public Represents(Collaboration collaboration, Collaboration collaboration2)
    {
        this();
        this.representerCollaboration(collaboration);
        this.representedCollaboration(collaboration2);
    }

    /**
     * @param collaboration
     * @param collaborationUse
     */
    public Represents(Collaboration collaboration, CollaborationUse collaborationUse)
    {
        this();
        this.representerCollaboration(collaboration);
        this.representedCollaborationUse(collaborationUse);
    }

    /**
     * @param collaborationUse
     * @param collaboration
     */
    public Represents(CollaborationUse collaborationUse, Collaboration collaboration)
    {
        this();
        this.representerCollaborationUse(collaborationUse);
        this.representedCollaboration(collaboration);
    }

    /**
     * @param collaborationUse
     * @param collaborationUse2
     */
    public Represents(CollaborationUse collaborationUse, CollaborationUse collaborationUse2)
    {
        this();
        this.representerCollaborationUse(collaborationUse);
        this.representedCollaborationUse(collaborationUse2);
    }

    /**
     * @param classe
     */
    public void representerClass(Classe classe)
    {
        this.representerClass = classe;
    }

    /**
     * @param classe
     */
    public void representedClass(Classe classe)
    {
        this.representedClass = classe;
    }

    /**
     * @param collaboration
     */
    public void representerCollaboration(Collaboration collaboration)
    {
        this.representerCollaboration = collaboration;
    }

    /**
     * @param collaboration
     */
    public void representedCollaboration(Collaboration collaboration)
    {
        this.representedCollaboration = collaboration;
    }

    /**
     * @param collaboration
     */
    public void representerCollaborationUse(CollaborationUse collaboration)
    {
        this.representerCollaborationUse = collaboration;
    }

    /**
     * @param collaboration
     */
    public void representedCollaborationUse(CollaborationUse collaboration)
    {
        this.representedCollaborationUse = collaboration;
    }

    /**
     * @param anotherInterface
     */
    public void representerInterface(Interface anotherInterface)
    {
        this.representerInterface = anotherInterface;
    }

    /**
     * @param interface1
     */
    public void representedInterface(Interface interface1)
    {
        this.representedInterface = interface1;
    }

    /**
     * @return
     */
    public Collaboration representerCollaboration()
    {
        return this.representerCollaboration;
    }

    /**
     * @return
     */
    public Collaboration representedCollaboration()
    {
        return this.representedCollaboration;
    }

    /**
     * @return
     */
    public CollaborationUse representerCollaborationUse()
    {
        return this.representerCollaborationUse;
    }

    /**
     * @return
     */
    public CollaborationUse representedCollaborationUse()
    {
        return this.representedCollaborationUse;
    }

    /**
     * @return
     */
    public Classe representerClass()
    {
        return this.representerClass;
    }

    /**
     * @return
     */
    public Classe representedClass()
    {
        return this.representedClass;
    }

    /**
     * @return
     */
    public Interface representerInterface()
    {
        return this.representerInterface;
    }

    /**
     * @return
     */
    public Interface representedInterface()
    {
        return this.representedInterface;
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
        auxList.add(this.representedInterface());
        auxList.add(this.representerInterface());
        auxList.add(this.representedClass());
        auxList.add(this.representerClass());
        auxList.add(this.representedCollaboration());
        auxList.add(this.representerCollaboration());
        auxList.add(this.representedCollaborationUse());
        auxList.add(this.representerCollaborationUse());
        return auxList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#conceptName()
     */
    public String conceptName()
    {
        return I18NProperties.getString("represents.concept.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("represents.concept.name.for.tree") + name();
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
