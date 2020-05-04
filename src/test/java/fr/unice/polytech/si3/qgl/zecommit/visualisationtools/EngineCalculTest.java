package fr.unice.polytech.si3.qgl.zecommit.visualisationtools;

import fr.unice.polytech.si3.qgl.zecommit.action.Turn;
import fr.unice.polytech.si3.qgl.zecommit.boat.Deck;
import fr.unice.polytech.si3.qgl.zecommit.boat.Position;
import fr.unice.polytech.si3.qgl.zecommit.boat.Ship;
import fr.unice.polytech.si3.qgl.zecommit.crew.Sailor;
import fr.unice.polytech.si3.qgl.zecommit.visualisationtools.settings.EngineSettingsWeek7;
import fr.unice.polytech.si3.qgl.zecommit.entite.Oar;
import fr.unice.polytech.si3.qgl.zecommit.entite.Rudder;
import fr.unice.polytech.si3.qgl.zecommit.entite.Sail;
import fr.unice.polytech.si3.qgl.zecommit.other.Reef;
import fr.unice.polytech.si3.qgl.zecommit.other.Stream;
import fr.unice.polytech.si3.qgl.zecommit.other.VisibleEntitie;
import fr.unice.polytech.si3.qgl.zecommit.other.Wind;
import fr.unice.polytech.si3.qgl.zecommit.shape.Circle;
import fr.unice.polytech.si3.qgl.zecommit.shape.Rectangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class EngineCalculTest {
    String json1;
    EngineSettingsWeek7 engineSettings;
    EngineCalcul engineCalcul;

    @BeforeEach
    void setUp() {
        engineSettings = new EngineSettingsWeek7();
        engineCalcul = new EngineCalcul(engineSettings);

        json1 = "{\n" +
                "  \"goal\" : {\n" +
                "    \"mode\" : \"REGATTA\",\n" +
                "    \"checkpoints\" : [ {\n" +
                "      \"position\" : {\n" +
                "        \"x\" : 1000.0,\n" +
                "        \"y\" : 0.0,\n" +
                "        \"orientation\" : 0.0\n" +
                "      },\n" +
                "      \"shape\" : {\n" +
                "        \"type\" : \"circle\",\n" +
                "        \"radius\" : 50.0\n" +
                "      }\n" +
                "    } ]\n" +
                "  },\n" +
                "  \"shipCount\" : 1,\n" +
                "  \"ship\" : {\n" +
                "    \"type\" : \"ship\",\n" +
                "    \"life\" : 100,\n" +
                "    \"position\" : {\n" +
                "      \"x\" : 0.0,\n" +
                "      \"y\" : 0.0,\n" +
                "      \"orientation\" : 0.0\n" +
                "    },\n" +
                "    \"name\" : \"Les copaings d'abord!\",\n" +
                "    \"deck\" : {\n" +
                "      \"width\" : 2,\n" +
                "      \"length\" : 1\n" +
                "    },\n" +
                "    \"entities\" : [ {\n" +
                "      \"type\" : \"oar\",\n" +
                "      \"x\" : 0,\n" +
                "      \"y\" : 0\n" +
                "    }, {\n" +
                "      \"type\" : \"oar\",\n" +
                "      \"x\" : 0,\n" +
                "      \"y\" : 1\n" +
                "    } ],\n" +
                "    \"shape\" : {\n" +
                "      \"type\" : \"rectangle\",\n" +
                "      \"width\" : 2.0,\n" +
                "      \"height\" : 3.0,\n" +
                "      \"orientation\" : 0.0\n" +
                "    }\n" +
                "  },\n" +
                "  \"sailors\" : [ {\n" +
                "    \"id\" : 0,\n" +
                "    \"x\" : 0,\n" +
                "    \"y\" : 0,\n" +
                "    \"name\" : \"Edward Teach\"\n" +
                "  }, {\n" +
                "    \"id\" : 1,\n" +
                "    \"x\" : 0,\n" +
                "    \"y\" : 1,\n" +
                "    \"name\" : \"Tom Pouce\"\n" +
                "  } ]\n" +
                "}";
    }


    @Test
    void engineTurnTestFalse() {
        engineSettings.getSailors().add(new Sailor(1, 2, 3, "name"));
        engineSettings.getEntities().add(new Rudder(3, 3));
        engineSettings.sortEntities();
        Turn turn = mock(Turn.class);
        when(turn.getSailorId()).thenReturn(1);
        when(turn.getRotation()).thenReturn(1.3);
        engineCalcul.engineTurn(turn);
        assertNotEquals(1.3, engineSettings.getRotation(), 0.0);
        assertEquals(0, engineSettings.getRotation());
    }

    @Test
    void engineOarLeftRightTest() {
        Sailor sailorTest = new Sailor(3, 7, 3, "name");
        engineSettings.setDeck(new Deck(5, 10));
        engineSettings.getSailors().add(sailorTest);
        engineSettings.getEntities().add(new Oar(7, 3));
        engineSettings.sortEntities();
        engineCalcul.engineOarLeftRight(sailorTest);
        assertEquals(1, engineSettings.getRightSailors().size());
        assertEquals(0, engineSettings.getLeftSailors().size());
    }

    @Test
    void engineOarLeftRightTest2() {
        Sailor sailorTest = new Sailor(3, 7, 1, "name");
        engineSettings.setDeck(new Deck(5, 10));
        engineSettings.getSailors().add(sailorTest);
        engineSettings.getEntities().add(new Oar(7, 1));
        engineSettings.sortEntities();
        engineCalcul.engineOarLeftRight(sailorTest);
        assertEquals(0, engineSettings.getRightSailors().size());
        assertEquals(1, engineSettings.getLeftSailors().size());
    }

    @Test
    void engineLiftSailActionTest() {
        Sailor sailorTest = new Sailor(3, 0, 1, "name");
        engineSettings.getSailors().add(sailorTest);
        engineSettings.getEntities().add(new Sail(0, 1, false));
        engineSettings.sortEntities();
        engineCalcul.engineLiftSailAction(sailorTest);
        assertEquals(1, engineSettings.getNbSailUsed());
    }

    @Test
    void engineLiftSailActionTest2() {
        Sailor sailorTest = new Sailor(3, 0, 1, "name");
        engineSettings.getSailors().add(sailorTest);
        engineSettings.getEntities().add(new Sail(1, 1, false));
        engineSettings.sortEntities();
        engineCalcul.engineLiftSailAction(sailorTest);
        assertEquals(0, engineSettings.getNbSailUsed());
    }

    @Test
    void engineLowerSailActionTest() {
        Sailor sailorTest = new Sailor(3, 0, 1, "name");
        engineSettings.getSailors().add(sailorTest);
        engineSettings.getEntities().add(new Sail(0, 1, false));
        engineSettings.sortEntities();
        engineCalcul.engineLiftSailAction(sailorTest);
        engineCalcul.engineLowerSailAction(sailorTest);
        assertEquals(0, engineSettings.getNbSailUsed());
    }

    @Test
    void engineLowerSailActionTest2() {
        Sailor sailorTest = new Sailor(3, 0, 1, "name");
        engineSettings.getSailors().add(sailorTest);
        engineSettings.getEntities().add(new Sail(0, 1, false));
        engineSettings.sortEntities();
        engineCalcul.engineLowerSailAction(sailorTest);
        assertEquals(0, engineSettings.getNbSailUsed());
    }

    @Test
    void calculWindTest() {
        Sailor sailorTest = new Sailor(3, 0, 1, "name");
        Ship shiptest = mock(Ship.class);
        Position posTest = mock(Position.class);
        when(shiptest.getPosition()).thenReturn(posTest);
        when(shiptest.getPosition().getOrientation()).thenReturn(0.0);
        engineSettings.setShip(shiptest);
        engineSettings.getSailors().add(sailorTest);
        engineSettings.setWind(new Wind(0, 100));
        engineSettings.getEntities().add(new Sail(0, 1, false));
        engineSettings.sortEntities();
        engineCalcul.engineLiftSailAction(sailorTest);
        assertEquals(100 / engineSettings.getN(), engineCalcul.calculWind());
    }

    @Test
    void calculWindTest2() {
        Sailor sailorTest = new Sailor(3, 0, 1, "name");
        Ship shiptest = mock(Ship.class);
        Position posTest = mock(Position.class);
        when(shiptest.getPosition()).thenReturn(posTest);
        when(shiptest.getPosition().getOrientation()).thenReturn(0.0);
        engineSettings.setShip(shiptest);
        engineSettings.getSailors().add(sailorTest);
        engineSettings.setWind(new Wind(-Math.PI, 100));
        engineSettings.getEntities().add(new Sail(0, 1, false));
        engineSettings.sortEntities();
        engineCalcul.engineLiftSailAction(sailorTest);
        assertEquals(-100 / engineSettings.getN(), engineCalcul.calculWind());
    }


    @Test
    void angleCalculTest() {
        final double orientation = Math.PI / 2;
        Ship shiptest = mock(Ship.class);
        Position posTest = mock(Position.class);
        when(shiptest.getPosition()).thenReturn(posTest);
        when(shiptest.getPosition().getOrientation()).thenReturn(orientation);
        engineSettings.setShip(shiptest);
        ArrayList<Sailor> leftListMock = mock(ArrayList.class);
        when(leftListMock.size()).thenReturn(0);
        ArrayList<Sailor> rightListMock = mock(ArrayList.class);
        when(rightListMock.size()).thenReturn(3);
        ArrayList<Oar> oarListMock = mock(ArrayList.class);
        when(oarListMock.size()).thenReturn(6);
        engineSettings.setOarList(oarListMock);
        engineSettings.setLeftSailors(leftListMock);
        engineSettings.setRightSailors(rightListMock);
        engineSettings.setRotation(0);
        assertEquals(orientation + (orientation / engineSettings.getN()), engineCalcul.angleCalcul());
    }

    @Test
    void angleCalculTest2() {
        final double orientation = Math.PI;
        Ship shiptest = mock(Ship.class);
        Position posTest = mock(Position.class);
        when(shiptest.getPosition()).thenReturn(posTest);
        when(shiptest.getPosition().getOrientation()).thenReturn(orientation);
        engineSettings.setShip(shiptest);
        ArrayList<Sailor> leftListMock = mock(ArrayList.class);
        when(leftListMock.size()).thenReturn(3);
        ArrayList<Sailor> rightListMock = mock(ArrayList.class);
        when(rightListMock.size()).thenReturn(3);
        ArrayList<Oar> oarListMock = mock(ArrayList.class);
        when(oarListMock.size()).thenReturn(6);
        engineSettings.setOarList(oarListMock);
        engineSettings.setLeftSailors(leftListMock);
        engineSettings.setRightSailors(rightListMock);
        engineSettings.setRotation(0.1);
        assertEquals(-orientation + (0.1 / engineSettings.getN()), engineCalcul.angleCalcul());
    }

    @Test
    void giveVisibleEntitiesTest() {
        Ship shiptest = mock(Ship.class);
        Position pos = new Position(0, 0, 0);
        when(shiptest.getPosition()).thenReturn(pos);
        engineSettings.setShip(shiptest);
        ArrayList<VisibleEntitie> visibleEntities = new ArrayList<>();
        visibleEntities.add(new Stream(new Position(1000, 0, 0), new Rectangle(10, 10, 0), 100));
        engineSettings.setVisibleEntities(visibleEntities);
        engineCalcul.giveVisibleEntities();
        assertEquals(1, engineSettings.getVisibles().size());
    }

    @Test
    void giveVisibleEntitiesTest2() {
        Ship shiptest = mock(Ship.class);
        Position pos = new Position(0, 0, 0);
        when(shiptest.getPosition()).thenReturn(pos);
        engineSettings.setShip(shiptest);
        ArrayList<VisibleEntitie> visibleEntities = new ArrayList<>();
        visibleEntities.add(new Stream(new Position(700, 700, 0), new Rectangle(10, 10, 0), 100));
        engineSettings.setVisibleEntities(visibleEntities);
        engineCalcul.giveVisibleEntities();
        assertEquals(1, engineSettings.getVisibles().size());
    }

    @Test
    void giveVisibleEntitiesTest3() {
        Ship shiptest = mock(Ship.class);
        Position pos = new Position(0, 0, 0);
        when(shiptest.getPosition()).thenReturn(pos);
        engineSettings.setShip(shiptest);
        ArrayList<VisibleEntitie> visibleEntities = new ArrayList<>();
        visibleEntities.add(new Stream(new Position(800, 800, 0), new Rectangle(10, 10, 0), 100));
        engineSettings.setVisibleEntities(visibleEntities);
        engineCalcul.giveVisibleEntities();
        assertEquals(0, engineSettings.getVisibles().size());
    }

    @Test
    void checkCollisionTest(){
        Position pos1 = new Position(0,0,0);
        Reef reef1= new Reef(pos1, new Circle(10) );
        engineSettings.getReefs().add(reef1);
        assertTrue(engineCalcul.checkCollision(pos1));

        engineSettings.getReefs().remove(reef1);

        Reef reef2= new Reef(new Position(5,5,0), new Circle(10) );
        engineSettings.getReefs().add(reef2);
        assertTrue(engineCalcul.checkCollision(pos1));

        engineSettings.getReefs().remove(reef2);

        Reef reef3= new Reef(new Position(8,8,0), new Circle(10) );
        engineSettings.getReefs().add(reef3);
        assertFalse(engineCalcul.checkCollision(pos1));

    }

    @Test
    void getCurrentOnTest(){
        Ship shiptest = mock(Ship.class);
        Position pos = new Position(0, 0, 0);
        when(shiptest.getPosition()).thenReturn(pos);
        engineSettings.setShip(shiptest);
        ArrayList<VisibleEntitie> visibleEntities = new ArrayList<>();
        visibleEntities.add(new Stream(new Position(0, 0, 0), new Rectangle(10, 10, 0), 100));
        engineSettings.setVisibleEntities(visibleEntities);
        assertNotNull(engineCalcul.getCurrentOn());
        visibleEntities = new ArrayList<>();
        engineSettings.setVisibleEntities(visibleEntities);
        assertNull(engineCalcul.getCurrentOn());
    }
}
