/*
 * @(#)Transition.java
 *
 * Historico de modificacoes:
 * Autor             Data           Descricao
 * ----------------  ------------   ----------------------------------------------------
 * thania           Feb 21, 2008        descrição
 */
package documents.concepts.state_machine_diagram;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import ocean.framework.Concept;
import ocean.smalltalk.OceanVector;
import documents.util.I18NProperties;

public class Transition extends ocean.documents.oo.concepts.Transition
{

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -3570721175653628567L;

    private State stateTerminal1;

    private State stateTerminal2;

    private Choice choiceTerminal1;

    private Choice choiceTerminal2;

    private EntryPoint entryPointTerminal1;

    private EntryPoint entryPointTerminal2;

    private ExitPoint exitPointTerminal1;

    private ExitPoint exitPointTerminal2;

    private InitialState initialStateTerminal1;

    private InitialState initialStateTerminal2;

    private FinalState finalStateTerminal1;

    private FinalState finalStateTerminal2;

    private Fork forkTerminal1;

    private Fork forkTerminal2;

    private Join joinTerminal1;

    private Join joinTerminal2;

    private Junction junctionTerminal1;

    private Junction junctionTerminal2;

    private SubmachineState submachineTerminal1;

    private SubmachineState submachineTerminal2;

    private Terminate terminateTerminal1;

    private Terminate terminateTerminal2;

    /**
     * Official constructor.
     */
    public Transition()
    {
        super();
        name(I18NProperties.getString("transition.concept.name"));
    }

    /**
     * @param stateTerminal1
     * @param stateTerminal2
     */
    public Transition(State stateTerminal1, State stateTerminal2)
    {
        this();
        this.stateTerminal1(stateTerminal1);
        this.stateTerminal2(stateTerminal2);
    }

    /**
     * @param stateTerminal1
     * @param stateTerminal2
     */
    public Transition(Choice choiceTerminal1, Choice choiceTerminal2)
    {
        this();
        this.choiceTerminal1(choiceTerminal1);
        this.choiceTerminal2(choiceTerminal2);
    }

    /**
     * @param stateTerminal1
     * @param choiceTerminal2
     */
    public Transition(State stateTerminal1, Choice choiceTerminal2)
    {
        this();
        this.stateTerminal1(stateTerminal1);
        this.choiceTerminal2(choiceTerminal2);
    }

    /**
     * @param choiceTerminal1
     * @param stateTerminal2
     */
    public Transition(Choice choiceTerminal1, State stateTerminal2)
    {
        this();
        this.choiceTerminal1(choiceTerminal1);
        this.stateTerminal2(stateTerminal2);
    }

    /**
     * @param initialState
     * @param state
     */
    public Transition(InitialState initialState, State state)
    {
        this();
        this.initialStateTerminal1(initialState);
        this.stateTerminal2(state);
    }

    /**
     * @param state
     * @param initialState
     */
    public Transition(State state, InitialState initialState)
    {
        this();
        this.stateTerminal1(state);
        this.initialStateTerminal2(initialState);
    }

    /**
     * @param initialState
     * @param choice
     */
    public Transition(InitialState initialState, Choice choice)
    {
        this();
        this.initialStateTerminal1(initialState);
        this.choiceTerminal2(choice);
    }

    /**
     * @param choice
     * @param initialState
     */
    public Transition(Choice choice, InitialState initialState)
    {
        this();
        this.choiceTerminal1(choice);
        this.initialStateTerminal2(initialState);
    }

    /**
     * @param initialState
     * @param entry
     */
    public Transition(InitialState initialState, EntryPoint entry)
    {
        this();
        this.initialStateTerminal1(initialState);
        this.entryPointTerminal2(entry);
    }

    /**
     * @param entry
     * @param initialState
     */
    public Transition(EntryPoint entry, InitialState initialState)
    {
        this();
        this.entryPointTerminal1(entry);
        this.initialStateTerminal2(initialState);
    }

    /**
     * @param initialState
     * @param exit
     */
    public Transition(InitialState initialState, ExitPoint exit)
    {
        this();
        this.initialStateTerminal1(initialState);
        this.exitPointTerminal2(exit);
    }

    /**
     * @param exit
     * @param initialState
     */
    public Transition(ExitPoint exit, InitialState initialState)
    {
        this();
        this.exitPointTerminal1(exit);
        this.initialStateTerminal2(initialState);
    }

    /**
     * @param initialState
     * @param finalState
     */
    public Transition(InitialState initialState, FinalState finalState)
    {
        this();
        this.initialStateTerminal1(initialState);
        this.finalStateTerminal2(finalState);
    }

    /**
     * @param initialState
     * @param fork
     */
    public Transition(InitialState initialState, Fork fork)
    {
        this();
        this.initialStateTerminal1(initialState);
        this.forkTerminal2(fork);
    }

    /**
     * @param fork
     * @param initialState
     */
    public Transition(Fork fork, InitialState initialState)
    {
        this();
        this.forkTerminal1(fork);
        this.initialStateTerminal2(initialState);
    }

    /**
     * @param initialState
     * @param join
     */
    public Transition(InitialState initialState, Join join)
    {
        this();
        this.initialStateTerminal1(initialState);
        this.joinTerminal2(join);
    }

    /**
     * @param join
     * @param initialState
     */
    public Transition(Join join, InitialState initialState)
    {
        this();
        this.joinTerminal1(join);
        this.initialStateTerminal2(initialState);
    }

    /**
     * @param initialState
     * @param junction
     */
    public Transition(InitialState initialState, Junction junction)
    {
        this();
        this.initialStateTerminal1(initialState);
        this.junctionTerminal2(junction);
    }

    /**
     * @param junction
     * @param initialState
     */
    public Transition(Junction junction, InitialState initialState)
    {
        this();
        this.junctionTerminal1(junction);
        this.initialStateTerminal2(initialState);
    }

    /**
     * @param initialState
     * @param submachine
     */
    public Transition(InitialState initialState, SubmachineState submachine)
    {
        this();
        this.initialStateTerminal1(initialState);
        this.submachineTerminal2(submachine);
    }

    /**
     * @param submachine
     * @param initialState
     */
    public Transition(SubmachineState submachine, InitialState initialState)
    {
        this();
        this.submachineTerminal1(submachine);
        this.initialStateTerminal2(initialState);
    }

    /**
     * @param initialState
     * @param terminate
     */
    public Transition(InitialState initialState, Terminate terminate)
    {
        this();
        this.initialStateTerminal1(initialState);
        this.terminateTerminal2(terminate);
    }

    /**
     * @param terminate
     * @param initialState
     */
    public Transition(Terminate terminate, InitialState initialState)
    {
        this();
        this.terminateTerminal1(terminate);
        this.initialStateTerminal2(initialState);
    }

    /**
     * @param choice
     * @param entry
     */
    public Transition(Choice choice, EntryPoint entry)
    {
        this();
        this.choiceTerminal1(choice);
        this.entryPointTerminal2(entry);
    }

    /**
     * @param entry
     * @param choice
     */
    public Transition(EntryPoint entry, Choice choice)
    {
        this();
        this.entryPointTerminal1(entry);
        this.choiceTerminal2(choice);
    }

    /**
     * @param choice
     * @param exit
     */
    public Transition(Choice choice, ExitPoint exit)
    {
        this();
        this.choiceTerminal1(choice);
        this.exitPointTerminal2(exit);
    }

    /**
     * @param exit
     * @param choice
     */
    public Transition(ExitPoint exit, Choice choice)
    {
        this();
        this.exitPointTerminal1(exit);
        this.choiceTerminal2(choice);
    }

    /**
     * @param choice
     * @param finalState
     */
    public Transition(Choice choice, FinalState finalState)
    {
        this();
        this.choiceTerminal1(choice);
        this.finalStateTerminal2(finalState);
    }

    /**
     * @param choice
     * @param fork
     */
    public Transition(Choice choice, Fork fork)
    {
        this();
        this.choiceTerminal1(choice);
        this.forkTerminal2(fork);
    }

    /**
     * @param fork
     * @param choice
     */
    public Transition(Fork fork, Choice choice)
    {
        this();
        this.forkTerminal1(fork);
        this.choiceTerminal2(choice);
    }

    /**
     * @param choice
     * @param join
     */
    public Transition(Choice choice, Join join)
    {
        this();
        this.choiceTerminal1(choice);
        this.joinTerminal2(join);
    }

    /**
     * @param join
     * @param choice
     */
    public Transition(Join join, Choice choice)
    {
        this();
        this.joinTerminal1(join);
        this.choiceTerminal2(choice);
    }

    /**
     * @param choice
     * @param junction
     */
    public Transition(Choice choice, Junction junction)
    {
        this();
        this.choiceTerminal1(choice);
        this.junctionTerminal2(junction);
    }

    /**
     * @param junction
     * @param choice
     */
    public Transition(Junction junction, Choice choice)
    {
        this();
        this.junctionTerminal1(junction);
        this.choiceTerminal2(choice);
    }

    /**
     * @param choice
     * @param submachine
     */
    public Transition(Choice choice, SubmachineState submachine)
    {
        this();
        this.choiceTerminal1(choice);
        this.submachineTerminal2(submachine);
    }

    /**
     * @param submachine
     * @param choice
     */
    public Transition(SubmachineState submachine, Choice choice)
    {
        this();
        this.submachineTerminal1(submachine);
        this.choiceTerminal2(choice);
    }

    /**
     * @param choice
     * @param terminate
     */
    public Transition(Choice choice, Terminate terminate)
    {
        this();
        this.choiceTerminal1(choice);
        this.terminateTerminal2(terminate);
    }

    /**
     * @param terminate
     * @param choice
     */
    public Transition(Terminate terminate, Choice choice)
    {
        this();
        this.terminateTerminal1(terminate);
        this.choiceTerminal2(choice);
    }

    /**
     * @param state
     * @param entry
     */
    public Transition(State state, EntryPoint entry)
    {
        this();
        this.stateTerminal1(state);
        this.entryPointTerminal2(entry);
    }

    /**
     * @param entry
     * @param state
     */
    public Transition(EntryPoint entry, State state)
    {
        this();
        this.entryPointTerminal1(entry);
        this.stateTerminal2(state);
    }

    /**
     * @param state
     * @param exit
     */
    public Transition(State state, ExitPoint exit)
    {
        this();
        this.stateTerminal1(state);
        this.exitPointTerminal2(exit);
    }

    /**
     * @param exit
     * @param state
     */
    public Transition(ExitPoint exit, State state)
    {
        this();
        this.exitPointTerminal1(exit);
        this.stateTerminal2(state);
    }

    /**
     * @param state
     * @param finalState
     */
    public Transition(State state, FinalState finalState)
    {
        this();
        this.stateTerminal1(state);
        this.finalStateTerminal2(finalState);
    }

    /**
     * @param state
     * @param fork
     */
    public Transition(State state, Fork fork)
    {
        this();
        this.stateTerminal1(state);
        this.forkTerminal2(fork);
    }

    /**
     * @param fork
     * @param state
     */
    public Transition(Fork fork, State state)
    {
        this();
        this.forkTerminal1(fork);
        this.stateTerminal2(state);
    }

    /**
     * @param state
     * @param join
     */
    public Transition(State state, Join join)
    {
        this();
        this.stateTerminal1(state);
        this.joinTerminal2(join);
    }

    /**
     * @param join
     * @param state
     */
    public Transition(Join join, State state)
    {
        this();
        this.joinTerminal1(join);
        this.stateTerminal2(state);
    }

    /**
     * @param state
     * @param junction
     */
    public Transition(State state, Junction junction)
    {
        this();
        this.stateTerminal1(state);
        this.junctionTerminal2(junction);
    }

    /**
     * @param junction
     * @param state
     */
    public Transition(Junction junction, State state)
    {
        this();
        this.junctionTerminal1(junction);
        this.stateTerminal2(state);
    }

    /**
     * @param state
     * @param submachine
     */
    public Transition(State state, SubmachineState submachine)
    {
        this();
        this.stateTerminal1(state);
        this.submachineTerminal2(submachine);
    }

    /**
     * @param submachine
     * @param state
     */
    public Transition(SubmachineState submachine, State state)
    {
        this();
        this.submachineTerminal1(submachine);
        this.stateTerminal2(state);
    }

    /**
     * @param state
     * @param terminate
     */
    public Transition(State state, Terminate terminate)
    {
        this();
        this.stateTerminal1(state);
        this.terminateTerminal2(terminate);
    }

    /**
     * @param terminate
     * @param state
     */
    public Transition(Terminate terminate, State state)
    {
        this();
        this.terminateTerminal1(terminate);
        this.stateTerminal2(state);
    }

    /**
     * @param entryPoint
     * @param entry
     */
    public Transition(EntryPoint entryPoint, EntryPoint entry)
    {
        this();
        this.entryPointTerminal1(entryPoint);
        this.entryPointTerminal2(entry);
    }

    /**
     * @param entryPoint
     * @param exit
     */
    public Transition(EntryPoint entryPoint, ExitPoint exit)
    {
        this();
        this.entryPointTerminal1(entryPoint);
        this.exitPointTerminal2(exit);
    }

    /**
     * @param exit
     * @param entryPoint
     */
    public Transition(ExitPoint exit, EntryPoint entryPoint)
    {
        this();
        this.exitPointTerminal1(exit);
        this.entryPointTerminal2(entryPoint);
    }

    /**
     * @param entryPoint
     * @param finalState
     */
    public Transition(EntryPoint entryPoint, FinalState finalState)
    {
        this();
        this.entryPointTerminal1(entryPoint);
        this.finalStateTerminal2(finalState);
    }

    /**
     * @param entryPoint
     * @param fork
     */
    public Transition(EntryPoint entryPoint, Fork fork)
    {
        this();
        this.entryPointTerminal1(entryPoint);
        this.forkTerminal2(fork);
    }

    /**
     * @param fork
     * @param entryPoint
     */
    public Transition(Fork fork, EntryPoint entryPoint)
    {
        this();
        this.forkTerminal1(fork);
        this.entryPointTerminal2(entryPoint);
    }

    /**
     * @param entryPoint
     * @param join
     */
    public Transition(EntryPoint entryPoint, Join join)
    {
        this();
        this.entryPointTerminal1(entryPoint);
        this.joinTerminal2(join);
    }

    /**
     * @param join
     * @param entryPoint
     */
    public Transition(Join join, EntryPoint entryPoint)
    {
        this();
        this.joinTerminal1(join);
        this.entryPointTerminal2(entryPoint);
    }

    /**
     * @param entryPoint
     * @param junction
     */
    public Transition(EntryPoint entryPoint, Junction junction)
    {
        this();
        this.entryPointTerminal1(entryPoint);
        this.junctionTerminal2(junction);
    }

    /**
     * @param junction
     * @param entryPoint
     */
    public Transition(Junction junction, EntryPoint entryPoint)
    {
        this();
        this.junctionTerminal1(junction);
        this.entryPointTerminal2(entryPoint);
    }

    /**
     * @param entryPoint
     * @param submachine
     */
    public Transition(EntryPoint entryPoint, SubmachineState submachine)
    {
        this();
        this.entryPointTerminal1(entryPoint);
        this.submachineTerminal2(submachine);
    }

    /**
     * @param submachine
     * @param entryPoint
     */
    public Transition(SubmachineState submachine, EntryPoint entryPoint)
    {
        this();
        this.submachineTerminal1(submachine);
        this.entryPointTerminal2(entryPoint);
    }

    /**
     * @param entryPoint
     * @param terminate
     */
    public Transition(EntryPoint entryPoint, Terminate terminate)
    {
        this();
        this.entryPointTerminal1(entryPoint);
        this.terminateTerminal2(terminate);
    }

    /**
     * @param terminate
     * @param entryPoint
     */
    public Transition(Terminate terminate, EntryPoint entryPoint)
    {
        this();
        this.terminateTerminal1(terminate);
        this.entryPointTerminal2(entryPoint);
    }

    /**
     * @param exitPoint
     * @param exit
     */
    public Transition(ExitPoint exitPoint, ExitPoint exit)
    {
        this();
        this.exitPointTerminal1(exitPoint);
        this.exitPointTerminal2(exit);
    }

    /**
     * @param exitPoint
     * @param finalState
     */
    public Transition(ExitPoint exitPoint, FinalState finalState)
    {
        this();
        this.exitPointTerminal1(exitPoint);
        this.finalStateTerminal2(finalState);
    }

    /**
     * @param exitPoint
     * @param fork
     */
    public Transition(ExitPoint exitPoint, Fork fork)
    {
        this();
        this.exitPointTerminal1(exitPoint);
        this.forkTerminal2(fork);
    }

    /**
     * @param fork
     * @param exitPoint
     */
    public Transition(Fork fork, ExitPoint exitPoint)
    {
        this();
        this.forkTerminal1(fork);
        this.exitPointTerminal2(exitPoint);
    }

    /**
     * @param exitPoint
     * @param join
     */
    public Transition(ExitPoint exitPoint, Join join)
    {
        this();
        this.exitPointTerminal1(exitPoint);
        this.joinTerminal2(join);
    }

    /**
     * @param join
     * @param exitPoint
     */
    public Transition(Join join, ExitPoint exitPoint)
    {
        this();
        this.joinTerminal1(join);
        this.exitPointTerminal2(exitPoint);
    }

    /**
     * @param exitPoint
     * @param junction
     */
    public Transition(ExitPoint exitPoint, Junction junction)
    {
        this();
        this.exitPointTerminal1(exitPoint);
        this.junctionTerminal2(junction);
    }

    /**
     * @param junction
     * @param exitPoint
     */
    public Transition(Junction junction, ExitPoint exitPoint)
    {
        this();
        this.junctionTerminal1(junction);
        this.exitPointTerminal2(exitPoint);
    }

    /**
     * @param exitPoint
     * @param submachine
     */
    public Transition(ExitPoint exitPoint, SubmachineState submachine)
    {
        this();
        this.exitPointTerminal1(exitPoint);
        this.submachineTerminal2(submachine);
    }

    /**
     * @param submachine
     * @param exitPoint
     */
    public Transition(SubmachineState submachine, ExitPoint exitPoint)
    {
        this();
        this.submachineTerminal1(submachine);
        this.exitPointTerminal2(exitPoint);
    }

    /**
     * @param exitPoint
     * @param terminate
     */
    public Transition(ExitPoint exitPoint, Terminate terminate)
    {
        this();
        this.exitPointTerminal1(exitPoint);
        this.terminateTerminal2(terminate);
    }

    /**
     * @param terminate
     * @param exitPoint
     */
    public Transition(Terminate terminate, ExitPoint exitPoint)
    {
        this();
        this.terminateTerminal1(terminate);
        this.exitPointTerminal2(exitPoint);
    }

    /**
     * @param fork
     * @param finalState
     */
    public Transition(Fork fork, FinalState finalState)
    {
        this();
        this.forkTerminal1(fork);
        this.finalStateTerminal2(finalState);
    }

    /**
     * @param join
     * @param finalState
     */
    public Transition(Join join, FinalState finalState)
    {
        this();
        this.joinTerminal1(join);
        this.finalStateTerminal2(finalState);
    }

    /**
     * @param junction
     * @param finalState
     */
    public Transition(Junction junction, FinalState finalState)
    {
        this();
        this.junctionTerminal1(junction);
        this.finalStateTerminal2(finalState);
    }

    /**
     * @param submachine
     * @param finalState
     */
    public Transition(SubmachineState submachine, FinalState finalState)
    {
        this();
        this.submachineTerminal1(submachine);
        this.finalStateTerminal2(finalState);
    }

    /**
     * @param terminate
     * @param finalState
     */
    public Transition(Terminate terminate, FinalState finalState)
    {
        this();
        this.terminateTerminal1(terminate);
        this.finalStateTerminal2(finalState);
    }

    /**
     * @param fork
     * @param fork
     */
    public Transition(Fork fork, Fork fork2)
    {
        this();
        this.forkTerminal1(fork);
        this.forkTerminal2(fork2);
    }

    /**
     * @param fork
     * @param join
     */
    public Transition(Fork fork, Join join)
    {
        this();
        this.forkTerminal1(fork);
        this.joinTerminal2(join);
    }

    /**
     * @param join
     * @param fork
     */
    public Transition(Join join, Fork fork)
    {
        this();
        this.joinTerminal1(join);
        this.forkTerminal2(fork);
    }

    /**
     * @param fork
     * @param junction
     */
    public Transition(Fork fork, Junction junction)
    {
        this();
        this.forkTerminal1(fork);
        this.junctionTerminal2(junction);
    }

    /**
     * @param junction
     * @param fork
     */
    public Transition(Junction junction, Fork fork)
    {
        this();
        this.junctionTerminal1(junction);
        this.forkTerminal2(fork);
    }

    /**
     * @param fork
     * @param submachine
     */
    public Transition(Fork fork, SubmachineState submachine)
    {
        this();
        this.forkTerminal1(fork);
        this.submachineTerminal2(submachine);
    }

    /**
     * @param submachine
     * @param fork
     */
    public Transition(SubmachineState submachine, Fork fork)
    {
        this();
        this.submachineTerminal1(submachine);
        this.forkTerminal2(fork);
    }

    /**
     * @param fork
     * @param terminate
     */
    public Transition(Fork fork, Terminate terminate)
    {
        this();
        this.forkTerminal1(fork);
        this.terminateTerminal2(terminate);
    }

    /**
     * @param terminate
     * @param fork
     */
    public Transition(Terminate terminate, Fork fork)
    {
        this();
        this.terminateTerminal1(terminate);
        this.forkTerminal2(fork);
    }

    /**
     * @param join
     * @param join
     */
    public Transition(Join join, Join join2)
    {
        this();
        this.joinTerminal1(join);
        this.joinTerminal2(join2);
    }

    /**
     * @param join
     * @param junction
     */
    public Transition(Join join, Junction junction)
    {
        this();
        this.joinTerminal1(join);
        this.junctionTerminal2(junction);
    }

    /**
     * @param junction
     * @param join
     */
    public Transition(Junction junction, Join join)
    {
        this();
        this.junctionTerminal1(junction);
        this.joinTerminal2(join);
    }

    /**
     * @param join
     * @param submachine
     */
    public Transition(Join join, SubmachineState submachine)
    {
        this();
        this.joinTerminal1(join);
        this.submachineTerminal2(submachine);
    }

    /**
     * @param submachine
     * @param join
     */
    public Transition(SubmachineState submachine, Join join)
    {
        this();
        this.submachineTerminal1(submachine);
        this.joinTerminal2(join);
    }

    /**
     * @param join
     * @param terminate
     */
    public Transition(Join join, Terminate terminate)
    {
        this();
        this.joinTerminal1(join);
        this.terminateTerminal2(terminate);
    }

    /**
     * @param terminate
     * @param join
     */
    public Transition(Terminate terminate, Join join)
    {
        this();
        this.terminateTerminal1(terminate);
        this.joinTerminal2(join);
    }

    /**
     * @param junction
     * @param junction
     */
    public Transition(Junction junction, Junction junction2)
    {
        this();
        this.junctionTerminal1(junction);
        this.junctionTerminal2(junction2);
    }

    /**
     * @param junction
     * @param submachine
     */
    public Transition(Junction junction, SubmachineState submachine)
    {
        this();
        this.junctionTerminal1(junction);
        this.submachineTerminal2(submachine);
    }

    /**
     * @param submachine
     * @param junction
     */
    public Transition(SubmachineState submachine, Junction junction)
    {
        this();
        this.submachineTerminal1(submachine);
        this.junctionTerminal2(junction);
    }

    /**
     * @param junction
     * @param terminate
     */
    public Transition(Junction junction, Terminate terminate)
    {
        this();
        this.junctionTerminal1(junction);
        this.terminateTerminal2(terminate);
    }

    /**
     * @param terminate
     * @param junction
     */
    public Transition(Terminate terminate, Junction junction)
    {
        this();
        this.terminateTerminal1(terminate);
        this.junctionTerminal2(junction);
    }

    /**
     * @param submachine
     * @param submachine2
     */
    public Transition(SubmachineState submachine, SubmachineState submachine2)
    {
        this();
        this.submachineTerminal1(submachine);
        this.submachineTerminal2(submachine2);
    }

    /**
     * @param submachine
     * @param terminate
     */
    public Transition(SubmachineState submachine, Terminate terminate)
    {
        this();
        this.submachineTerminal1(submachine);
        this.terminateTerminal2(terminate);
    }

    /**
     * @param terminate
     * @param submachine
     */
    public Transition(Terminate terminate, SubmachineState submachine)
    {
        this();
        this.terminateTerminal1(terminate);
        this.submachineTerminal2(submachine);
    }

    /**
     * @param initialStateTerminal1
     */
    public void initialStateTerminal1(InitialState initialStateTerminal1)
    {
        this.initialStateTerminal1 = initialStateTerminal1;
    }

    /**
     * @param initialStateTerminal2
     */
    public void initialStateTerminal2(InitialState initialStateTerminal2)
    {
        this.initialStateTerminal2 = initialStateTerminal2;
    }

    /**
     * @param entryPointTerminal1
     */
    public void entryPointTerminal1(EntryPoint entryPointTerminal1)
    {
        this.entryPointTerminal1 = entryPointTerminal1;
    }

    /**
     * @param entryPointTerminal2
     */
    public void entryPointTerminal2(EntryPoint entryPointTerminal2)
    {
        this.entryPointTerminal2 = entryPointTerminal2;
    }

    /**
     * @param exitPointTerminal1
     */
    public void exitPointTerminal1(ExitPoint exitPointTerminal1)
    {
        this.exitPointTerminal1 = exitPointTerminal1;
    }

    /**
     * @param exitPointTerminal2
     */
    public void exitPointTerminal2(ExitPoint exitPointTerminal2)
    {
        this.exitPointTerminal2 = exitPointTerminal2;
    }

    /**
     * @param finalStateTerminal1
     */
    public void finalStateTerminal1(FinalState finalStateTerminal1)
    {
        this.finalStateTerminal1 = finalStateTerminal1;
    }

    /**
     * @param finalStateTerminal2
     */
    public void finalStateTerminal2(FinalState finalStateTerminal2)
    {
        this.finalStateTerminal2 = finalStateTerminal2;
    }

    /**
     * @param forkTerminal1
     */
    public void forkTerminal1(Fork forkTerminal1)
    {
        this.forkTerminal1 = forkTerminal1;
    }

    /**
     * @param forkTerminal2
     */
    public void forkTerminal2(Fork forkTerminal2)
    {
        this.forkTerminal2 = forkTerminal2;
    }

    /**
     * @param joinTerminal1
     */
    public void joinTerminal1(Join joinTerminal1)
    {
        this.joinTerminal1 = joinTerminal1;
    }

    /**
     * @param joinTerminal2
     */
    public void joinTerminal2(Join joinTerminal2)
    {
        this.joinTerminal2 = joinTerminal2;
    }

    /**
     * @param junctionTerminal1
     */
    public void junctionTerminal1(Junction junctionTerminal1)
    {
        this.junctionTerminal1 = junctionTerminal1;
    }

    /**
     * @param junctionTerminal2
     */
    public void junctionTerminal2(Junction junctionTerminal2)
    {
        this.junctionTerminal2 = junctionTerminal2;
    }

    /**
     * @param submachineTerminal1
     */
    public void submachineTerminal1(SubmachineState submachineTerminal1)
    {
        this.submachineTerminal1 = submachineTerminal1;
    }

    /**
     * @param submachineTerminal2
     */
    public void submachineTerminal2(SubmachineState submachineTerminal2)
    {
        this.submachineTerminal2 = submachineTerminal2;
    }

    /**
     * @param terminateTerminal1
     */
    public void terminateTerminal1(Terminate terminateTerminal1)
    {
        this.terminateTerminal1 = terminateTerminal1;
    }

    /**
     * @param terminateTerminal2
     */
    public void terminateTerminal2(Terminate terminateTerminal2)
    {
        this.terminateTerminal2 = terminateTerminal2;
    }

    /**
     * @param stateTerminal1
     */
    public void stateTerminal1(State stateTerminal1)
    {
        this.stateTerminal1 = stateTerminal1;
    }

    /**
     * @param stateTerminal2
     */
    public void stateTerminal2(State stateTerminal2)
    {
        this.stateTerminal2 = stateTerminal2;
    }

    /**
     * @return
     */
    public State stateTerminal1()
    {
        return this.stateTerminal1;
    }

    /**
     * @return
     */
    public State stateTerminal2()
    {
        return this.stateTerminal2;
    }

    /**
     * @param choiceTerminal1
     */
    public void choiceTerminal1(Choice choiceTerminal1)
    {
        this.choiceTerminal1 = choiceTerminal1;
    }

    /**
     * @param choiceTerminal2
     */
    public void choiceTerminal2(Choice choiceTerminal2)
    {
        this.choiceTerminal2 = choiceTerminal2;
    }

    /**
     * @return
     */
    public Choice choiceTerminal1()
    {
        return this.choiceTerminal1;
    }

    /**
     * @return
     */
    public Choice choiceTerminal2()
    {
        return this.choiceTerminal2;
    }

    /**
     * @return
     */
    public EntryPoint entryPointTerminal1()
    {
        return this.entryPointTerminal1;
    }

    /**
     * @return
     */
    public EntryPoint entryPointTerminal2()
    {
        return this.entryPointTerminal2;
    }

    /**
     * @return
     */
    public ExitPoint exitPointTerminal1()
    {
        return this.exitPointTerminal1;
    }

    /**
     * @return
     */
    public ExitPoint exitPointTerminal2()
    {
        return this.exitPointTerminal2;
    }

    /**
     * @return
     */
    public FinalState finalStateTerminal1()
    {
        return this.finalStateTerminal1;
    }

    /**
     * @return
     */
    public FinalState finalStateTerminal2()
    {
        return this.finalStateTerminal2;
    }

    /**
     * @return
     */
    public InitialState initialStateTerminal1()
    {
        return this.initialStateTerminal1;
    }

    /**
     * @return
     */
    public InitialState initialStateTerminal2()
    {
        return this.initialStateTerminal2;
    }

    /**
     * @return
     */
    public Fork forkTerminal1()
    {
        return this.forkTerminal1;
    }

    /**
     * @return
     */
    public Fork forkTerminal2()
    {
        return this.forkTerminal2;
    }

    /**
     * @return
     */
    public Join joinTerminal1()
    {
        return this.joinTerminal1;
    }

    /**
     * @return
     */
    public Join joinTerminal2()
    {
        return this.joinTerminal2;
    }

    /**
     * @return
     */
    public Junction junctionTerminal1()
    {
        return this.junctionTerminal1;
    }

    /**
     * @return
     */
    public Junction junctionTerminal2()
    {
        return this.junctionTerminal2;
    }

    /**
     * @return
     */
    public SubmachineState submachineTerminal1()
    {
        return this.submachineTerminal1;
    }

    /**
     * @return
     */
    public SubmachineState submachineTerminal2()
    {
        return this.submachineTerminal2;
    }

    /**
     * @return
     */
    public Terminate terminateTerminal1()
    {
        return this.terminateTerminal1;
    }

    /**
     * @return
     */
    public Terminate terminateTerminal2()
    {
        return this.terminateTerminal2;
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#conceptName()
     */
    public String conceptName()
    {
        return I18NProperties.getString("transition.concept.name");
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.OceanDocument#getNameForTree()
     */
    public String getNameForTree()
    {
        return I18NProperties.getString("transition.concept.name.for.tree") + name();
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
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see ocean.framework.Concept#attacherComponent()
     */
    @SuppressWarnings( { "deprecation", "unchecked" })
    public Object attacherComponent()
    {
        OceanVector auxList;

        auxList = new OceanVector();
        auxList.add(this.stateTerminal1());
        auxList.add(this.stateTerminal2());
        auxList.add(this.choiceTerminal1());
        auxList.add(this.choiceTerminal2());
        auxList.add(this.entryPointTerminal1());
        auxList.add(this.entryPointTerminal2());
        auxList.add(this.exitPointTerminal1());
        auxList.add(this.exitPointTerminal2());
        auxList.add(this.finalStateTerminal1());
        auxList.add(this.finalStateTerminal2());
        auxList.add(this.forkTerminal1());
        auxList.add(this.forkTerminal2());
        auxList.add(this.joinTerminal1());
        auxList.add(this.joinTerminal2());
        auxList.add(this.junctionTerminal1());
        auxList.add(this.junctionTerminal2());
        auxList.add(this.submachineTerminal1());
        auxList.add(this.submachineTerminal2());
        auxList.add(this.terminateTerminal1());
        auxList.add(this.terminateTerminal2());

        return auxList;
    }

}