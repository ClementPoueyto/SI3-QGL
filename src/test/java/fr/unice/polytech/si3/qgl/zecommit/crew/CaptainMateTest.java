package fr.unice.polytech.si3.qgl.zecommit.crew;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.AbstractMap.SimpleEntry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.unice.polytech.si3.qgl.zecommit.action.Action;
import fr.unice.polytech.si3.qgl.zecommit.action.LiftSail;
import fr.unice.polytech.si3.qgl.zecommit.action.LowerSail;
import fr.unice.polytech.si3.qgl.zecommit.action.Moving;
import fr.unice.polytech.si3.qgl.zecommit.action.ToOar;
import fr.unice.polytech.si3.qgl.zecommit.action.Turn;
import fr.unice.polytech.si3.qgl.zecommit.action.UseWatch;
import fr.unice.polytech.si3.qgl.zecommit.boat.Deck;
import fr.unice.polytech.si3.qgl.zecommit.entite.Oar;
import fr.unice.polytech.si3.qgl.zecommit.entite.Rudder;
import fr.unice.polytech.si3.qgl.zecommit.entite.Sail;
import fr.unice.polytech.si3.qgl.zecommit.entite.Watch;

public class CaptainMateTest {
    List<Sailor> sailors;
    Sailor sailor;
    SimpleEntry<Sailor,Double> sailorAndAngle;
    Captain captain;
    CaptainMate captainMate;
    List<Action> actions;

    @BeforeEach
    void setup(){
        captain = mock(Captain.class);
        doNothing().when(captain).attributeEntitiesToSailors();
        when(captain.doMoveSailors()).thenReturn(new ArrayList<>());
        when(captain.doActivateOars()).thenReturn(new ArrayList<>());
        when(captain.doLiftSail()).thenReturn(new ArrayList<>());
        when(captain.doLowerSail()).thenReturn(new ArrayList<>());
        when(captain.doTurn()).thenReturn(null);
        when(captain.doUseWatch()).thenReturn(null);
        when(captain.pursueGame()).thenReturn(true);
        captainMate = new CaptainMate(captain);
        actions = new ArrayList<>();
    }


    @Test
    void toActivateOarsTest(){
        Oar o1 = new Oar(0, 0);
        Oar o2 = new Oar(0, 1);
        Sailor sailor1 = new Sailor(0,0,0,"Bon");
        Sailor sailor2 = new Sailor(1,1,0,"Mauvais");
        sailor1.setOnEntity(o1);
        sailor2.setOnEntity(o2);
        sailors = Arrays.asList(sailor1,sailor2);
        actions.add(new ToOar(sailor1.getId()));
        when(captain.doActivateOars()).thenReturn(sailors);
        assertEquals(actions, captainMate.actions());
        actions.removeAll(actions);
        when(captain.doActivateOars()).thenReturn(new ArrayList<>());
        assertEquals(actions, captainMate.actions());
        sailors = Arrays.asList(sailor2);
        when(captain.doActivateOars()).thenReturn(sailors);
        assertEquals(actions, captainMate.actions());
    }

    @Test
    void toTurnTest(){
        when(captain.doTurn()).thenReturn(null);
        assertEquals(actions, captainMate.actions());
        sailorAndAngle = new SimpleEntry<>(sailor, 0.0);
        when(captain.doTurn()).thenReturn(sailorAndAngle);
        assertEquals(actions, captainMate.actions());
        sailor = new Sailor(1, 0, 0, "mauvais");
        sailorAndAngle = new SimpleEntry<>(sailor, null);
        assertEquals(actions, captainMate.actions());
        Rudder rudder = new Rudder(1,1);
        sailor.setOnEntity(rudder);
        sailorAndAngle = new SimpleEntry<>(sailor, 0.5);
        assertEquals(actions, captainMate.actions());
        sailor.move(1, 1);
        actions.add(new Turn(sailor.getId(), 0.5));
        when(captain.doTurn()).thenReturn(sailorAndAngle);
        assertEquals(actions, captainMate.actions());
        sailorAndAngle = new SimpleEntry<>(sailor, 2.0);
        when(captain.doTurn()).thenReturn(sailorAndAngle);
        actions.clear();
        actions.add(new Turn(sailor.getId(), Math.PI/4));
        assertEquals(actions, captainMate.actions());
        sailorAndAngle = new SimpleEntry<>(sailor, -0.5);
        when(captain.doTurn()).thenReturn(sailorAndAngle);
        actions.clear();
        actions.add(new Turn(sailor.getId(), -0.5));
        assertEquals(actions, captainMate.actions());
        sailorAndAngle = new SimpleEntry<>(sailor, -2.0);
        when(captain.doTurn()).thenReturn(sailorAndAngle);
        actions.clear();
        actions.add(new Turn(sailor.getId(), -Math.PI/4));
        assertEquals(actions, captainMate.actions());
    }

    @Test
    void toLiftSailTest(){
        assertEquals(new ArrayList<>(), captainMate.actions());
        sailor = new Sailor(1,0,0,"Boris");
        when(captain.doLiftSail()).thenReturn(Arrays.asList(sailor));
        assertEquals(new ArrayList<>(), captainMate.actions());
        Sail sail = new Sail(1,0,false);
        sailor.setOnEntity(sail);
        assertEquals(new ArrayList<>(), captainMate.actions());
        sailor.move(1, 0);
        actions = Arrays.asList(new Action[]{new LiftSail(1)});
        assertEquals(actions, captainMate.actions());
    }

    @Test
    void toLowerSailTest(){
        assertEquals(new ArrayList<>(), captainMate.actions());
        sailor = new Sailor(1,0,0,"Boris");
        when(captain.doLowerSail()).thenReturn(Arrays.asList(sailor));
        assertEquals(new ArrayList<>(), captainMate.actions());
        Sail sail = new Sail(1,0,true);
        sailor.setOnEntity(sail);
        assertEquals(new ArrayList<>(), captainMate.actions());
        sailor.move(1, 0);
        actions = Arrays.asList(new Action[]{new LowerSail(1)});
        assertEquals(actions, captainMate.actions());
    }

    @Test
    void toUseWatchTest(){
        sailor = new Sailor(1,0,0,"Boris");
        Watch watch = new Watch(1, 0);
        assertEquals(new ArrayList<>(), captainMate.actions());
        when(captain.doUseWatch()).thenReturn(sailor);
        assertEquals(new ArrayList<>(), captainMate.actions());
        sailor.setOnEntity(watch);
        assertEquals(new ArrayList<>(), captainMate.actions());
        sailor.move(1, 0);
        actions = Arrays.asList(new Action[]{new UseWatch(1)});
        assertEquals(actions, captainMate.actions());
    }

    @Test
    void moveSailorsToTheirEntityTest(){
        Deck deck = new Deck(6, 4);
        sailor = new Sailor(0,5,3,"Dwyane");
        Sailor sailor1 = new Sailor(1,0,0,"Georges");
        Sailor sailor2 = new Sailor(2,0,3,"Philippe");
        Sailor sailor3 = new Sailor(3,3,0,"Mathias");
        Sailor sailor4 = new Sailor(4,2,2,"Anne-Marie");
        Oar o1 = new Oar(0, 2);
        Oar o2 = new Oar(1, 0);
        Oar o3 = new Oar(2, 0);
        Oar o4 = new Oar(2, 2);
        sailor1.setOnEntity(o1);
        sailor2.setOnEntity(o2);
        sailor3.setOnEntity(o3);
        sailor4.setOnEntity(o4);
        sailors = Arrays.asList(sailor,sailor1,sailor2,sailor3,sailor4);
        Moving m1 = new Moving(1, 0, 2);
        Moving m2 = new Moving(2, 1, -3);
        Moving m3 = new Moving(3, -1, 0);
        actions = Arrays.asList(new Action[]{m1,m2,m3});
        when(captain.getDeck()).thenReturn(deck);
        when(captain.doMoveSailors()).thenReturn(sailors);
        assertEquals(actions, captainMate.actions());
    }

}
