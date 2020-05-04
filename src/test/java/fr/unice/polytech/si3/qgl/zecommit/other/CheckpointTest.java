package fr.unice.polytech.si3.qgl.zecommit.other;

import fr.unice.polytech.si3.qgl.zecommit.boat.Position;
import fr.unice.polytech.si3.qgl.zecommit.shape.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;


class CheckpointTest {
    Checkpoint cpCircle;
    Checkpoint cpRect;
    Checkpoint cpPoly;
    Position posMock;
    Shape circle;
    Shape rect;
    Shape poly;


    @BeforeEach
    void setUp() {
        circle = new Circle(1);
        rect = new Rectangle(1, 1, 0);
        poly = new Polygone(0, new Point[]{new Point(1, 1), new Point(1, -1), new Point(-1, 1), new Point(-1, -1)});

        posMock = mock(Position.class);
        cpCircle = new Checkpoint(posMock, circle);
        cpRect = new Checkpoint(posMock, rect);
        cpPoly = new Checkpoint(posMock, poly);
    }

    /**
     * Renvoie true car le cp est un cercle
     */
    @Test
    void isCircleTrueTest() {
        assertTrue(cpCircle.isCircle());
    }


    /**
     * Renvoie false car le cp est un rectangle
     */
    @Test
    void isCircleFalseTest() {
        assertFalse(cpRect.isCircle());
    }

    @Test
    void getCircleRadiusTest() {
        assertEquals(1, cpCircle.getCircleRadius());
    }

    @Test
    void getRectangleRadiusTest() {
        assertEquals(1, cpRect.getCircleRadius());
    }

    @Test
    void getPolygoneRadiusTest() {
        assertEquals(Math.sqrt(2), cpPoly.getCircleRadius());
    }


}
