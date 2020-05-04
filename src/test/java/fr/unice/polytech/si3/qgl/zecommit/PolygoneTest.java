package fr.unice.polytech.si3.qgl.zecommit;

import fr.unice.polytech.si3.qgl.zecommit.boat.Position;
import fr.unice.polytech.si3.qgl.zecommit.shape.Point;
import fr.unice.polytech.si3.qgl.zecommit.shape.Polygone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PolygoneTest {

    private static final double DELTA = 1e-2;


    @Test
    public void getRadiusTest() {

        Point[] points = new Point[6];
        points[0] = new Point(8, 5);
        points[1] = new Point(9, 6);
        points[2] = new Point(10, 6);
        points[3] = new Point(11, 5);
        points[4] = new Point(10, 4);
        points[5] = new Point(9, 4);

        Polygone polygone = new Polygone(0, points);

        assertEquals(1.12, polygone.getRadius(), 0.01);
    }

    @Test
    public void barycentreTest() {
        Polygone polygone = new Polygone(0, new Point[]{new Point(-2, 2), new Point(3, -3), new Point(3, 3)});
        assertEquals(1.33, polygone.calculateCentroid().getX(), DELTA);
        assertEquals(0.67, polygone.calculateCentroid().getY(), DELTA);

    }

    @Test
    public void getRelativeVerticeListTest() {
        Position position = new Position(0, 0, 0);
        Polygone polygone = new Polygone(0, new Point[]{new Point(-2, 2), new Point(3, -3), new Point(3, 3)});
        assertEquals(-2, polygone.getRelativeVerticeList(position)[0].getX(), DELTA);
        assertEquals(2, polygone.getRelativeVerticeList(position)[0].getY(), DELTA);

    }

    @Test
    public void getRelativeVerticeListTest2() {
        Position position = new Position(0, 0, 0);
        Polygone polygone = new Polygone(Math.PI / 4, new Point[]{new Point(-2, 2), new Point(3, -3), new Point(3, 3)});
        assertEquals(0, polygone.getRelativeVerticeList(position)[2].getX(), DELTA);
        assertEquals(4.24, polygone.getRelativeVerticeList(position)[2].getY(), DELTA);
    }
}
