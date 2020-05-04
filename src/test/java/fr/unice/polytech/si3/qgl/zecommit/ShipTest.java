package fr.unice.polytech.si3.qgl.zecommit;

import fr.unice.polytech.si3.qgl.zecommit.boat.Deck;
import fr.unice.polytech.si3.qgl.zecommit.boat.Position;
import fr.unice.polytech.si3.qgl.zecommit.boat.Ship;
import fr.unice.polytech.si3.qgl.zecommit.entite.Entity;
import fr.unice.polytech.si3.qgl.zecommit.other.Checkpoint;
import fr.unice.polytech.si3.qgl.zecommit.other.Reef;
import fr.unice.polytech.si3.qgl.zecommit.shape.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author joris Liebgott
 */
class ShipTest {

    Ship ship;
    Shape circle10;

    @BeforeEach
    void setUp() {
        // Création de ship
        Position shipPosition = new Position(0,0,0);
        Deck deck = new Deck(5,5);
        Shape shape = new Rectangle(3,3,0);
        List<Entity> list = new ArrayList<>();

        ship = new Ship("ship",0, shipPosition,"zeBoat",deck, list, shape);

        circle10 = new Circle(10);

    }

    /**
     * calcul dans les negatifs bateau en (0,0)
     */
    @Test
    void distanceToNegatifTest() {

        Position position = new Position(-2,-5,0);

        assertEquals(ship.distanceTo(position), Math.sqrt(29));
    }

    /**
     * calcul dans les positifs bateau en (0,0)
     */
    @Test
    void distanceToPositifTest() {
        Position position = new Position(2,5,0);

        assertEquals(ship.distanceTo(position), Math.sqrt(29));
    }

    /**
     *
     */
    @Test
    void isInFrontOfCheckpointTestTrue(){
        Checkpoint mockCheckpoint= mock(Checkpoint.class);
        when(mockCheckpoint.getPosition()).thenReturn(new Position(10,10,0));
        assertTrue(ship.isInFrontOfCheckpoint(mockCheckpoint));
        when(mockCheckpoint.getPosition()).thenReturn(new Position(10,0,0));
        assertTrue(ship.isInFrontOfCheckpoint(mockCheckpoint));

        Position shipPosition=new Position(0,0,Math.PI/2);
        ship.setPosition(shipPosition);
        when(mockCheckpoint.getPosition()).thenReturn(new Position(10,10,0));
        assertTrue(ship.isInFrontOfCheckpoint(mockCheckpoint));
        when(mockCheckpoint.getPosition()).thenReturn(new Position(-10,10,0));
        assertTrue(ship.isInFrontOfCheckpoint(mockCheckpoint));

        shipPosition=new Position(0,0,-Math.PI/2);
        ship.setPosition(shipPosition);
        when(mockCheckpoint.getPosition()).thenReturn(new Position(-10,-10,0));
        assertTrue(ship.isInFrontOfCheckpoint(mockCheckpoint));
        when(mockCheckpoint.getPosition()).thenReturn(new Position(-10,0,0));
        assertTrue(ship.isInFrontOfCheckpoint(mockCheckpoint));

        shipPosition=new Position(0,0,-Math.PI);
        ship.setPosition(shipPosition);
        when(mockCheckpoint.getPosition()).thenReturn(new Position(-10,-10,0));
        assertTrue(ship.isInFrontOfCheckpoint(mockCheckpoint));
        when(mockCheckpoint.getPosition()).thenReturn(new Position(-10,0,0));
        assertTrue(ship.isInFrontOfCheckpoint(mockCheckpoint));
        when(mockCheckpoint.getPosition()).thenReturn(new Position(0,-10,0));
        assertTrue(ship.isInFrontOfCheckpoint(mockCheckpoint));
    }

    @Test
    void isInFrontOfCheckpointTestFalse(){
        Checkpoint mockCheckpoint= mock(Checkpoint.class);
        when(mockCheckpoint.getPosition()).thenReturn(new Position(-10,10,0));
        assertFalse(ship.isInFrontOfCheckpoint(mockCheckpoint));
        when(mockCheckpoint.getPosition()).thenReturn(new Position(-10,0,0));
        assertFalse(ship.isInFrontOfCheckpoint(mockCheckpoint));

        Position shipPosition=new Position(0,0,Math.PI/2);
        ship.setPosition(shipPosition);
        when(mockCheckpoint.getPosition()).thenReturn(new Position(-10,-10,0));
        assertFalse(ship.isInFrontOfCheckpoint(mockCheckpoint));
        when(mockCheckpoint.getPosition()).thenReturn(new Position(-10,-1,0));
        assertFalse(ship.isInFrontOfCheckpoint(mockCheckpoint));



    }

    /**
     * bateau (0,0) dans le checkpointCibleIn (1,1,cercle:10 radius)
     */
    @Test
    void isInCheckpoint_IN_Test() {
        // Création du checkpointCibleIn
        Position cpPosition = new Position(1,1,0);

        Checkpoint checkpointCibleIn = new Checkpoint(cpPosition, circle10);

        assertTrue(ship.isInCheckpoint(checkpointCibleIn));

    }

    /**
     * bateau (0,0) hors du checkpointcibleOut (15,15,cercle:10 radius)
     */
    @Test
    void isInCheckpoint_OUT_Test() {
        Position cpPosition = new Position(15,15,0);

        Checkpoint checkpointCibleOut = new Checkpoint(cpPosition, circle10);

        assertFalse(ship.isInCheckpoint(checkpointCibleOut));

    }

    @Test
    void distanceToForReefTest(){
        Position position = new Position(5,5,0);
        Polygone shape = new Polygone(0, new Point[]{new Point(-2, -1), new Point(1, 1), new Point(1, -3)});
        Reef reefPolygone = new Reef(position, shape);
        assertEquals(5, ship.distanceToforReef(reefPolygone));
    }

    @Test
    void distanceToForReefTest2(){
        Position position = new Position(5,5,0);
        Circle shape = new Circle(5);
        Reef reef = new Reef(position, shape);
        assertEquals(2.071, ship.distanceToforReef(reef), 1e-3);
    }

    @Test
    void distanceToForReefTest3(){
        Position position = new Position(5,5,0);
        Rectangle shape = new Rectangle(4, 2, 0);
        Reef reef = new Reef(position, shape);
        assertEquals(4.835, ship.distanceToforReef(reef), 1e-3);
    }


}
