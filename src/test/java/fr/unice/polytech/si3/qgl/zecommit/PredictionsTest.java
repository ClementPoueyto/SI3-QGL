package fr.unice.polytech.si3.qgl.zecommit;

import fr.unice.polytech.si3.qgl.zecommit.boat.Deck;
import fr.unice.polytech.si3.qgl.zecommit.boat.Position;
import fr.unice.polytech.si3.qgl.zecommit.boat.Ship;
import fr.unice.polytech.si3.qgl.zecommit.entite.Entity;
import fr.unice.polytech.si3.qgl.zecommit.entite.Oar;
import fr.unice.polytech.si3.qgl.zecommit.entite.Sail;
import fr.unice.polytech.si3.qgl.zecommit.maths.Predictions;
import fr.unice.polytech.si3.qgl.zecommit.other.Reef;
import fr.unice.polytech.si3.qgl.zecommit.other.Stream;
import fr.unice.polytech.si3.qgl.zecommit.other.VisibleEntitie;
import fr.unice.polytech.si3.qgl.zecommit.other.Wind;
import fr.unice.polytech.si3.qgl.zecommit.shape.Circle;
import fr.unice.polytech.si3.qgl.zecommit.shape.Rectangle;
import fr.unice.polytech.si3.qgl.zecommit.shape.Shape;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Nathan
 */
public class PredictionsTest {

    private Ship ship;
    private List<VisibleEntitie> visibleEntities;
    private Predictions predictions;
    private Deck deck;



    @BeforeEach
    void setup() {
        deck = mock(Deck.class);
        List<Entity> entities = new ArrayList<>();
        ship = new Ship("boat", 100, new Position(0, 0, 0), "zeBoat", deck, entities, new Rectangle(5, 7, 0));
        visibleEntities = new ArrayList<>();
    }

    /**
     * pas de collision
     */
    @Test
    public void checkCollisionTest(){
        visibleEntities.add(new Reef(new Position(1500, 500, 0.78539816339), new Rectangle(1250.0, 1300, 0)));
        visibleEntities.add(new Reef(new Position(500, 1500, 0.78539816339), new Rectangle(1250.0, 1300.0, 0.0)));
        predictions = new Predictions(4,4,ship, visibleEntities, 0, new Wind(0,0), false);
        assertFalse(predictions.checkCollision());
    }
    /**
     * pas de collision : récifs trop loins
     */
    @Test
    public void checkCollisionTest2(){
        visibleEntities.add(new Reef(new Position(1300, 500, 0.78539816339), new Rectangle(1250.0, 1500, 0)));
        visibleEntities.add(new Reef(new Position(500, 1300, 0.78539816339), new Rectangle(1250.0, 1500, 0.0)));
        predictions = new Predictions(4,4,ship, visibleEntities, 0, new Wind(0,0), false);
        assertFalse(predictions.checkCollision());
    }

    /**
     * collision
     */
    @Test
    public void checkCollisionTest3(){
        ship.setPosition(new Position(500,300,0));
        visibleEntities.add(new Reef(new Position(1300, 500, 0.78539816339), new Rectangle(1250.0, 1500, 0)));
        visibleEntities.add(new Reef(new Position(500, 1300, 0.78539816339), new Rectangle(1250.0, 1500, 0.0)));
        predictions = new Predictions(4,4,ship, visibleEntities, 0, new Wind(0,0), false);
        assertTrue(predictions.checkCollision());
    }

    @Test
    public void getFirstReefTest(){
        ship.setPosition(new Position(300,500,0));
        visibleEntities.add(new Stream(new Position(1500, 500, 0.78539816339), new Rectangle(1250.0, 1300, 0), 150));
        visibleEntities.add(new Reef(new Position(1500, 500, 0.78539816339), new Rectangle(1250.0, 1300, 0)));
        visibleEntities.add(new Reef(new Position(500, 1500, 0.78539816339), new Rectangle(1250.0, 1300.0, 0.0)));
        predictions = new Predictions(4,4,ship, visibleEntities, 0, new Wind(0,0), false);
        assertEquals(visibleEntities.get(2), predictions.getFirstReef());
    }

    @Test
    public void getFirstReefTest2(){
        ship.setPosition(new Position(500,400,0));
        visibleEntities.add(new Stream(new Position(1500, 500, 0.78539816339), new Rectangle(1250.0, 1300, 0), 150));
        visibleEntities.add(new Reef(new Position(1500, 500, 0.78539816339), new Rectangle(1250.0, 1300, 0)));
        visibleEntities.add(new Reef(new Position(500, 1500, 0.78539816339), new Rectangle(1250.0, 1300.0, 0.0)));
        predictions = new Predictions(4,4,ship, visibleEntities, 0, new Wind(0,0), false);
        assertEquals(visibleEntities.get(1), predictions.getFirstReef());
    }


    @Test
    public void getAngleToCenterOfReefTest(){
        ship.setPosition(new Position(0,0,Math.PI/4));
        visibleEntities.add(new Reef(new Position(1500, 1500, 0.78539816339), new Circle(50)));
        predictions = new Predictions(4,4,ship, visibleEntities, 0, new Wind(0,0), false);
        assertEquals(0, predictions.getAngleToCenterOfReef((Reef)visibleEntities.get(0)));
    }

    @Test
    public void getAngleToCenterOfReefTest2(){
        ship.setPosition(new Position(0,0,Math.PI/4));
        visibleEntities.add(new Reef(new Position(0, 1500, -0.78539816339), new Circle(50)));
        predictions = new Predictions(4,4,ship, visibleEntities, 0, new Wind(0,0), false);
        assertEquals(Math.PI/4, predictions.getAngleToCenterOfReef((Reef)visibleEntities.get(0)));
    }

    @Test
    public void getAngleToCenterOfReefTest3(){
        ship.setPosition(new Position(1500,1500,-Math.PI/4));
        visibleEntities.add(new Reef(new Position(0, 0, 0), new Circle(50)));
        predictions = new Predictions(4,4,ship, visibleEntities, 0, new Wind(0,0), false);
        assertEquals(-2*Math.PI/4, predictions.getAngleToCenterOfReef((Reef)visibleEntities.get(0)));
    }

    @Test
    public void getAngleToCenterOfReefTest4(){
        ship.setPosition(new Position(0,0,-Math.PI/4));
        visibleEntities.add(new Reef(new Position(0, 0, 0), new Circle(50)));
        predictions = new Predictions(4,4,ship, visibleEntities, 0, new Wind(0,0), false);
        assertEquals(0, predictions.getAngleToCenterOfReef((Reef)visibleEntities.get(0)));
    }

    @Test
    public void predictFinalPositionTest() {
        ship.setPosition(new Position(0, 0, 0));
        List<Oar> res = new ArrayList<>();
        for (int i = 0; i < 8; i++)
            res.add(new Oar(i, i));
        when(deck.getOars()).thenReturn(res);
        predictions = new Predictions(4, 4, ship, visibleEntities, 0, new Wind(0, 0), false);
        assertEquals( new Position(165, 0, 0), predictions.predictFinalPosition(ship.getPosition(), 1));
    }

    @Test
    public void predictFinalPositionWithStreamTest() {
        ship.setPosition(new Position(0, 0, 0));
        List<Oar> res = new ArrayList<>();
        for (int i = 0; i < 8; i++)
            res.add(new Oar(i, i));
        when(deck.getOars()).thenReturn(res);
        visibleEntities.add(new Stream(new Position(82.5, 0,0), new Circle(500), 100));
        predictions = new Predictions(4, 4, ship, visibleEntities, 0, new Wind(0, 0), false);
        assertEquals(new Position(265, 0, 0), predictions.predictFinalPosition(ship.getPosition(), 1));
    }

    @Test
    public void predictFinalPositionWithStreamAndWinTest() {
        ship.setPosition(new Position(0, 0, 0));
        List<Oar> res = new ArrayList<>();
        for (int i = 0; i < 8; i++)
            res.add(new Oar(i, i));
        when(deck.getOars()).thenReturn(res);

        List<Sail> sails = new ArrayList<>();
        sails.add(new Sail(1,1, true));
        when(deck.getSails()).thenReturn(sails);

        visibleEntities.add(new Stream(new Position(82.5, 0,0), new Circle(500), 100));
        predictions = new Predictions(4, 4, ship, visibleEntities, 0, new Wind(0, 100), true);
        assertEquals( new Position(365, 0, 0), predictions.predictFinalPosition(ship.getPosition(), 1));
    }

    @Test
    public void predictFinalPositionWithStreamAndWinTest2() {
        ship.setPosition(new Position(0, 0, Math.PI/2));
        List<Oar> res = new ArrayList<>();
        for (int i = 0; i < 8; i++)
            res.add(new Oar(i, i));
        when(deck.getOars()).thenReturn(res);

        List<Sail> sails = new ArrayList<>();
        sails.add(new Sail(1,1, true));
        when(deck.getSails()).thenReturn(sails);

        visibleEntities.add(new Stream(new Position(0, 82.5,Math.PI/2), new Rectangle(1000, 1000, Math.PI/2), 100));
        predictions = new Predictions(4, 4, ship, visibleEntities, 0, new Wind(Math.PI/2, 100), true);
        Position finalPosition = predictions.predictFinalPosition(ship.getPosition(), 1);
        assertEquals(0, finalPosition.getX(), 1e-5);
        assertEquals(365, finalPosition.getY());
        assertEquals(Math.PI/2, finalPosition.getOrientation());
    }

}
