/*
 * @(#)Occurrence.java
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

public class Occurrence extends Concept
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 5335653611152588878L;

    private Interface occurrencedInterface;

    private Interface occurrencerInterface;

    private Collaboration occurrencedCollaboration;

    private Collaboration occurrencerCollaboration;

    private CollaborationUse occurrencedCollaborationUse;

    private CollaborationUse occurrencerCollaborationUse;

    private Classe occurrencedClass;

    private Classe occurrencerClass;

    /**
     * Official constructor.
     */
    public Occurrence()
    {
        super();
        name(I18NProperties.getString("occurrence.concept.name"));
    }

    /**
     * @param interface1
     * @param interface2
     */
    public Occurrence(Interface interface1, Interface interface2)
    {
        this();
        this.occurrencerInterface(interface1);
        this.occurrencedInterface(interface2);
    }
    
    /**
     * @param interface1
     * @param collaboration
     */
    public Occurrence(Interface interface1, Collaboration collaboration)
    {
        this();
        this.occurrencerInterface(interface1);
        this.occurrencedCollaboration(collaboration);
    }

    /**
     * @param collaboration
     * @param interface1
     */
    public Occurrence(Collaboration collaboration, Interface interface1)
    {
        this();
        this.occurrencerCollaboration(collaboration);
        this.occurrencedInterface(interface1);
    }

    /**
     * @param interface1
     * @param collaboration
     */
    public Occurrence(Interface interface1, CollaborationUse collaboration)
    {
        this();
        this.occurrencerInterface(interface1);
        this.occurrencedCollaborationUse(collaboration);
    }

    /**
     * @param collaboration
     * @param interface1
     */
    public Occurrence(CollaborationUse collaboration, Interface interface1)
    {
        this();
        this.occurrencerCollaborationUse(collaboration);
        this.occurrencedInterface(interface1);
    }

    /**
     * @param classe
     * @param classe2
     */
    public Occurrence(Classe classe, Classe classe2)
    {
        this();
        this.occurrencerClass(classe);
        this.occurrencedClass(classe2);
    }

    /**
     * @param classe
     * @param interface1
     */
    public Occurrence(Classe classe, Interface interface1)
    {
        this();
        this.occurrencerClass(classe);
        this.occurrencedInterface(interface1);
    }

    /**
     * @param interface1
     * @param classe
     */
    public Occurrence(Interface interface1, Classe classe)
    {
        this();
        this.occurrencerInterface(interface1);
        this.occurrencedClass(classe);
    }

    /**
     * @param classe
     * @param collaboration
     */
    public Occurrence(Classe classe, Collaboration collaboration)
    {
        this();
        this.occurrencerClass(classe);
        this.occurrencedCollaboration(collaboration);
    }

    /**
     * @param classe
     * @param collaboration
     */
    public Occurrence(Collaboration collaboration, Classe classe)
    {
        this();
        this.occurrencerCollaboration(collaboration);
        this.occurrencedClass(classe);
    }

    /**
     * @param classe
     * @param collaboration
     */
    public Occurrence(Classe classe, CollaborationUse collaboration)
    {
        this();
        this.occurrencerClass(classe);
        this.occurrencedCollaborationUse(collaboration);
    }

    /**
     * @param classe
     * @param collaboration
     */
    public Occurrence(CollaborationUse collaboration, Classe classe)
    {
        this();
        this.occurrencerCollaborationUse(collaboration);
        this.occurrencedClass(classe);
    }

    /**
     * @param collaboration
     * @param collaboration2
     */
    public Occurrence(Collaboration collaboration, Collaboration collaboration2)
    {
        this();
        this.occurrencerCollaboration(collaboration);
        this.occurrencedCollaboration(collaboration2);
    }

    /**
     * @param collaboration
     * @param collaborationUse
     */
    public Occurrence(Collaboration collaboration, CollaborationUse collaborationUse)
    {
        this();
        this.occurrencerCollaboration(collaboration);
        this.occurrencedCollaborationUse(collaborationUse);
    }

    /**
     * @param collaborationUse
     * @param collaboration
     */
    public Occurrence(CollaborationUse collaborationUse, Collaboration collaboration)
    {
        this();
        this.occurrencerCollaborationUse(collaborationUse);
        this.occurrencedCollaboration(collaboration);
    }

    /**
     * @param collaborationUse
     * @param collaborationUse2
     */
    public Occurrence(CollaborationUse collaborationUse, CollaborationUse collaborationUse2)
    {
        this();
        this.occurrencerCollaborationUse(collaborationUse);
        this.occurrencedCollaborationUse(collaborationUse2);
    }

    /**
     * @param classe
     */
    public void occurrencerClass(Classe classe)
    {
        this.occurrencerClass = classe;
    }

    /**
     * @param classe
     */
    public void occurrencedClass(Classe classe)
    {
        this.occurrencedClass = classe;
    }

    /**
     * @param collaboration
     */
    public void occurrencerCollaboration(Collaboration collaboration)
    {
        this.occurrencerCollaboration = collaboration;
    }

    /**
     * @param collaboration
     */
    public void occurrencedCollaboration(Collaboration collaboration)
    {
        this.occurrencedCollaboration = collaboration;
    }

    /**
     * @param collaboration
     */
    public void occurrencerCollaborationUse(CollaborationUse collaboration)
    {
        this.occurrencerCollaborationUse = collaboration;
    }

    /**
     * @param collaboration
     */
    public void occurrencedCollaborationUse(CollaborationUse collaboration)
    {
        this.occurrencedCollaborationUse = collaboration;
    }

    /**
     * @param anotherInterface
     */
    public void occurrencerInterface(Interface anotherInterface)
    {
        this.occurrencerInterface = anotherInterface;
    }

    /**
     * @param interface1
     */
    public void occurrencedInterface(Interface interface1)
    {
        this.occurrencedInterface = interface1;
    }

    /**
     * @return
     */
    public Collaboration occurrencerCollaboration()
    {
        return this.occurrencerCollaboration;
    }

    /**
     * @return
     */
    public Collaboration occurrencedCollaboration()
    {
        return this.occurrencedCollaboration;
    }

    /**
     * @return
     */
    public CollaborationUse occurrencerCollaborationUse()
    {
        return this.occurrencerCollaborationUse;
    }

    /**
     * @return
     */
    public CollaborationUse occurrencedCollaborationUse()
    {
        return this.occurrencedCollaborationUse;
    }

    /**
     * @return
     */
    public Classe occurrencerClass()
    {
        return this.occurrencerClass;
    }

    /**
     * @return
     */
    public Classe occurrencedClass()
    {
        return this.occurrencedClass;
    }

    /**
     * @return
     */
    public Interface occurrencerInterface()
    {
        return this.occurrencerInterface;
    }

    /**
     * @return
     */
    public Interface occurrencedInterface()
    {
        return this.occurrencedInterface;
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
        auxList.add(this.occurrencedInterface());
        auxList.add(this.occurrencerInterface());
        auxList.add(this.occurrencedClass());
        auxList.add(this.occurrencerClass());
        auxList.add(this.occurrencedCollaboration());
        auxList.add(this.occurrencerCollaboration());
        auxList.add(this.occurrencedCollaborationUse());
        auxList.add(this.occurrencerCollaborationUse());
        return auxList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#conceptName()
     */
    public String conceptName()
    {
        return I18NProperties.getString("occurrence.concept.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("occurrence.concept.name.for.tree") + name();
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
