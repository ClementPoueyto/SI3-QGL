package fr.unice.polytech.si3.qgl.zecommit;

import fr.unice.polytech.si3.qgl.zecommit.boat.Position;
import fr.unice.polytech.si3.qgl.zecommit.maths.Calculs;
import fr.unice.polytech.si3.qgl.zecommit.maths.Collision;
import fr.unice.polytech.si3.qgl.zecommit.other.Reef;
import fr.unice.polytech.si3.qgl.zecommit.shape.Point;
import fr.unice.polytech.si3.qgl.zecommit.shape.Polygone;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class CalculsTest {

    private static final double DELTA = 1e-8;


    /**
     * cas négatif
     */
    @Test
    public void shortestAngleTest() {
        assertEquals(Math.round(1000 * 2 * Math.PI / 3), Math.round(1000 * Calculs.shortestAngle(-4 * Math.PI / 3)));
    }

    /**
     * cas négatif
     */
    @Test
    public void shortestAngleTest2() {
        assertEquals(Math.round(1000 * Math.PI / 4), Math.round(1000 * Calculs.shortestAngle(-7 * Math.PI / 4)));
    }

    /**
     * cas positif
     */
    @Test
    public void shortestAngleTest3() {
        assertEquals(Math.round(1000 * 2 * -Math.PI / 3), Math.round(1000 * Calculs.shortestAngle(4 * Math.PI / 3)));
    }

    /**
     * cas positif
     */
    @Test
    public void shortestAngleTest4() {
        assertEquals(Math.round(1000 * -Math.PI / 4), Math.round(1000 * Calculs.shortestAngle(7 * Math.PI / 4)));
    }

    /**
     * cas limite
     */
    @Test
    public void shortestAngleTest5() {
        assertEquals(Math.PI, Calculs.shortestAngle(Math.PI));
    }


    @Test
    public void subdiviseRouteSizeTest() {
        assertEquals(501, Calculs.subdiviseRoute(new Position(0, 0, 0), new Position(200, 0, 0)).size());
        assertEquals(501, Calculs.subdiviseRoute(new Position(0, 0, 0), new Position(0, 200, 0)).size());
        assertEquals(501, Calculs.subdiviseRoute(new Position(0, 0, 0), new Position(200, 200, 0)).size());

        assertEquals(501, Calculs.subdiviseRoute(new Position(0, 0, 0), new Position(-200, 0, 0)).size());
        assertEquals(501, Calculs.subdiviseRoute(new Position(0, 0, 0), new Position(0, -200, 0)).size());
        assertEquals(501, Calculs.subdiviseRoute(new Position(0, 0, 0), new Position(-200, -200, 0)).size());

        assertEquals(501, Calculs.subdiviseRoute(new Position(200, 0, 0), new Position(0, 200, 0)).size());
        assertEquals(501, Calculs.subdiviseRoute(new Position(0, 2000, 0), new Position(200, 0, 0)).size());
    }

    @Test
    public void subdiviseRouteTest() {
        List<Position> res = new ArrayList<>();
        for (int k = 0; k < 501; k++) {
            res.add(new Position(k, 0, 0));
        }
        for (int i = 0; i < 500; i++) {
            assertEquals(res.get(i).getX(), Calculs.subdiviseRoute(new Position(0, 0, 0), new Position(500, 0, 0)).get(i).getX(), DELTA);
            assertEquals(res.get(i).getY(), Calculs.subdiviseRoute(new Position(0, 0, 0), new Position(500, 0, 0)).get(i).getY(), DELTA);
        }
    }


    @Test
    public void findIntersectionsCercleTest() {
        List<Position> expected = new ArrayList<>();
        expected.add(new Position(3, 6, 0));
        expected.add(new Position(6, -1, 0));

        List<Position> actual = new ArrayList<>();
        Calculs.findFakeCheckpointPositions(new Position(1, 1, 0), new Position(8, 4, 0), 1, actual);


        assertEquals(expected.get(0).getX(), actual.get(0).getX(), DELTA);
        assertEquals(expected.get(0).getY(), actual.get(0).getY(), DELTA);

        assertEquals(expected.get(1).getX(), actual.get(1).getX(), DELTA);
        assertEquals(expected.get(1).getY(), actual.get(1).getY(), DELTA);

    }


    /**
     * cas particulier : mêmes ordonnées
     */
    @Test
    public void findIntersectionsCercleTest2() {
        List<Position> expected = new ArrayList<>();
        expected.add(new Position(4.5, 4.5, 0));
        expected.add(new Position(4.5, -2.5, 0));

        List<Position> actual = new ArrayList<>();
        Calculs.findFakeCheckpointPositions(new Position(1, 1, 0), new Position(8, 1, 0), 1, actual);

        assertEquals(expected.get(0).getX(), actual.get(0).getX(), DELTA);
        assertEquals(expected.get(0).getY(), actual.get(0).getY(), DELTA);

        assertEquals(expected.get(1).getX(), actual.get(1).getX(), DELTA);
        assertEquals(expected.get(1).getY(), actual.get(1).getY(), DELTA);

    }

    /**
     * cas particulier : memes ordonnées
     */
    @Test
    public void findIntersectionsCercleTest3() {
        List<Position> expected = new ArrayList<>();
        expected.add(new Position(7, 0, 0));
        expected.add(new Position(7, -6, 0));

        List<Position> actual = new ArrayList<>();
        Calculs.findFakeCheckpointPositions(new Position(4, -3, 0), new Position(10, -3, 0), 1, actual);

        assertEquals(expected.get(0).getX(), actual.get(0).getX(), DELTA);
        assertEquals(expected.get(0).getY(), actual.get(0).getY(), DELTA);

        assertEquals(expected.get(1).getX(), actual.get(1).getX(), DELTA);
        assertEquals(expected.get(1).getY(), actual.get(1).getY(), DELTA);

    }

    /**
     * cas particulier : memes abscisses
     */
    @Test
    public void findIntersectionsCercleTest4() {
        List<Position> expected = new ArrayList<>();
        expected.add(new Position(2, -1, 0));
        expected.add(new Position(6, -1, 0));

        List<Position> actual = new ArrayList<>();
        Calculs.findFakeCheckpointPositions(new Position(4, -3, 0), new Position(4, 1, 0), 1, actual);

        assertEquals(expected.get(0).getX(), actual.get(0).getX(), DELTA);
        assertEquals(expected.get(0).getY(), actual.get(0).getY(), DELTA);

        assertEquals(expected.get(1).getX(), actual.get(1).getX(), DELTA);
        assertEquals(expected.get(1).getY(), actual.get(1).getY(), DELTA);

    }

    /**
     * test bug week12
     */
    @Test
    public void collideTest4() {
        Position position10 = new Position(11544.980443285524, -6132.812500000002, -0.5934119456780721);
        Polygone shape10 = new Polygone(0, new Point[]{new Point(2500, -3000), new Point(2500, 3000), new Point(-2500, 3000), new Point(-2500, -3000), new Point(-2500, -3000)});

        Position M = new Position(9400.26075619297, 227.8645833333388, 3.141592653589793);

        List<Reef> reefs = new ArrayList<>();
        reefs.add(new Reef(position10, shape10));
        List<Position> positions = new ArrayList<>();
        positions.add(M);

        assertFalse(Calculs.checkCollision(reefs, positions));
    }

}
