package fr.unice.polytech.si3.qgl.zecommit;

import fr.unice.polytech.si3.qgl.zecommit.action.Moving;
import fr.unice.polytech.si3.qgl.zecommit.boat.Deck;
import fr.unice.polytech.si3.qgl.zecommit.crew.Sailor;
import fr.unice.polytech.si3.qgl.zecommit.entite.Oar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {
    Oar oar1;
    Oar oar2;
    Oar oar3;
    Oar oar4;
    Oar oar5;
    Oar oar6;
    Oar oar7;
    Oar oar8;
    Oar oar9;
    Oar oar10;
    List<Oar> oars;
    List<Oar> oarsLeft;
    List<Oar> oarsRight;



    @BeforeEach
    public void setup(){
        oars = new ArrayList<>();
        oarsLeft = new ArrayList<>();
        oarsRight = new ArrayList<>();

        oar1 = new Oar(7,0);
        oar2 = new Oar(4,0);
        oar3 = new Oar(1,1);
        oar4 = new Oar(9,1);
        oar5 = new Oar(3,2);
        oar6 = new Oar(12,3);
        oar7 = new Oar(13,3);
        oar8 = new Oar(17,4);
        oar9 = new Oar(-27,3);
        oar10 = new Oar(124,4);

        oars.add(oar1);
        oars.add(oar2);
        oars.add(oar3);
        oars.add(oar4);
        oars.add(oar5);
        oars.add(oar6);
        oars.add(oar7);
        oars.add(oar8);
        oars.add(oar9);
        oars.add(oar10);

        oarsLeft.add(oar1);
        oarsLeft.add(oar2);
        oarsLeft.add(oar3);
        oarsLeft.add(oar4);

        oarsRight.add(oar5);
        oarsRight.add(oar6);
        oarsRight.add(oar7);
        oarsRight.add(oar8);
        oarsRight.add(oar9);
        oarsRight.add(oar10);


    }

    @Test
    public void getLeftOarsTest(){
        Deck deck = new Deck(5, 23);
        deck.setOars(oars);
        assertEquals(oarsLeft, deck.getLeftOars());
        assertEquals(oarsRight, deck.getRightOars());

    }

    @Test
    public void getLeftOarsTest2(){
        Deck deck = new Deck(4, 23);
        deck.setOars(oars);
        assertEquals(oarsLeft, deck.getLeftOars());
        assertEquals(oarsRight, deck.getRightOars());
    }

    @Test
    public void moveSailorTest(){
        Deck deck = new Deck(4, 23);
        Moving moving = deck.moveSailor(new Sailor(1,3,3,"marin"), 3, 3);
        assertEquals(3, moving.getXDistance());
        assertEquals(2, moving.getYDistance());

    }

    @Test
    public void moveSailorTest2(){
        Deck deck = new Deck(4, 23);
        Moving moving = deck.moveSailor(new Sailor(1,3,3,"marin"), 0, 0);
        assertNull(moving);

    }


    @Test
    public void sailorsAreOnTheirEntityTest(){
        Deck deck = new Deck(4, 23);
        List<Sailor> sailors = new ArrayList<>();
        sailors.add(new Sailor(1,3,3,"marin"));
        deck.setSailors(sailors);

        assertTrue(deck.sailorsAreOnTheirEntity());

    }


    @Test
    public void sailorsAreOnTheirEntityTest2(){
        Deck deck = new Deck(4, 23);
        List<Sailor> sailors = new ArrayList<>();
        Sailor sailor = new Sailor(1,3,3,"marin");
        sailor.setOnEntity(oar1);

        sailors.add(sailor);
        deck.setSailors(sailors);

        assertFalse(deck.sailorsAreOnTheirEntity());

    }

    @Test
    public void sailorsAreOnTheirEntityTest3(){
        Deck deck = new Deck(4, 23);
        List<Sailor> sailors = new ArrayList<>();
        Sailor sailor = new Sailor(1,7,0,"marin");
        sailor.setOnEntity(oar1);

        sailors.add(sailor);
        deck.setSailors(sailors);

        assertTrue(deck.sailorsAreOnTheirEntity());

    }
}

