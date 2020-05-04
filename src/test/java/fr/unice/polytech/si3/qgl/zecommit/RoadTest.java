package fr.unice.polytech.si3.qgl.zecommit;

import fr.unice.polytech.si3.qgl.zecommit.boat.Position;
import fr.unice.polytech.si3.qgl.zecommit.boat.Ship;
import fr.unice.polytech.si3.qgl.zecommit.maths.Road;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RoadTest {

    private static final double DELTA = 1e-2;

    Road roadTest;
    Road roadTest2;

    Ship shipMock;


    @BeforeEach
    void setUp() {
        Position startpos1 = new Position(1, 3, 0);
        Position endPos1 = new Position(7, 6, Math.PI / 2);
        roadTest = new Road(startpos1, endPos1);
        roadTest2 = new Road(endPos1, startpos1);

        shipMock = mock(Ship.class);

    }

    @Test
    void distanceXToGoalTest() {
        assertEquals(6, roadTest.xDistanceToGoal());
        assertEquals(6, roadTest2.xDistanceToGoal());

    }

    @Test
    void distanceYToGoalTest() {
        assertEquals(3, roadTest.yDistanceToGoal());
        assertEquals(3, roadTest2.yDistanceToGoal());
    }

    @Test
    void distanceToGoalTest() {
        assertEquals(Math.sqrt(3 * 3 + 6 * 6), roadTest.distanceToGoal());
        assertEquals(Math.sqrt(3 * 3 + 6 * 6), roadTest2.distanceToGoal());
    }

    @Test
    void orientationToGoalTest() {
        Position start = new Position(0, 0, 0);
        Position end = new Position(0, 1, 0);
        Road road = new Road(start, end);
        assertEquals(Math.PI / 2, road.orientationToGoal());

        road = new Road(start, new Position(1, 1, 0));
        assertEquals(Math.PI / 4, road.orientationToGoal());

        road = new Road(start, new Position(-1, -1, 0));
        assertEquals(-3 * Math.PI / 4, road.orientationToGoal());

        road = new Road(start, new Position(-100, 0, 0));
        assertEquals(-Math.PI, road.orientationToGoal());

    }

    @Test
    void orientationToGoalPositivePositionTest() {
        //Position positive, position checkpoint positive
        Road road = new Road(new Position(2, 3, Math.PI / 4), new Position(2, 8, 0));
        assertEquals(Math.PI / 4, road.orientationToGoal());

        //Position positive, position checkpoint négative
        road = new Road(new Position(3, 2, Math.PI / 4), new Position(-2, 7, 0));
        assertEquals(Math.PI / 2, road.orientationToGoal());

    }

    @Test
    void orientationToGoalNegativePositionTest() {
        //Position négative, position checkpoint positive
        Road road = new Road(new Position(-2, -3, Math.PI / 4), new Position(2, 7, 0));
        assertEquals(0.4, road.orientationToGoal(), DELTA);

        //Position positive, position checkpoint négative
        road = new Road(new Position(-2, -3, Math.PI / 4), new Position(-2, -5, 0));
        assertEquals(-3 * Math.PI / 4, road.orientationToGoal());

        road = new Road(new Position(-2, -3, Math.PI / 4), new Position(2, 7, 0));
        assertEquals(0.4, road.orientationToGoal(), DELTA);

        //Position positive, position checkpoint négative
        road = new Road(new Position(-2, -3, Math.PI / 4), new Position(-2, -5, 0));
        assertEquals(-3 * Math.PI / 4, road.orientationToGoal());

        road = new Road(new Position(0, 0, Math.PI / 4), new Position(-5, -5, 0));
        assertEquals(-Math.PI, road.orientationToGoal());

    }

    /**
     * Cas limites
     */
    @Test
    void orientationToGoalTest2() {
        // Bateau et Checkpoint sur le meme axe vertical
        Road road = new Road(new Position(3, 2, Math.PI / 3), new Position(3, 5, 0));
        assertEquals(0.52, road.orientationToGoal(), DELTA);

        // Bateau et Checkpoint sur le meme axe horizontal
        road = new Road(new Position(1, -3, Math.PI / 4), new Position(7, -3, 0));
        assertEquals(-Math.PI / 4, road.orientationToGoal());

        // Bateau et Checkpoint confondu
        road = new Road(new Position(-7, 3, Math.PI / 4), new Position(-7, 3, 0));
        assertEquals(0, road.orientationToGoal());


        road = new Road(new Position(-7, 3, 3 * Math.PI / 4), new Position(-5, 1, 0));
        assertEquals(-Math.PI, road.orientationToGoal());

    }

    /**
     * Renvoie PI/4 à la place de 7*PI/4
     */
    @Test
    void shortestAngle1Test() {
        Position start = new Position(0, 0, Math.PI / 4);
        Position end = new Position(0, 4, 0);

        Road road = new Road(start, end);

        assertEquals(road.orientationToGoal(), Math.PI / 4);
    }


    /**
     * Renvoie -(3*PI)/4 à la place de (5*PI)/4
     */
    @Test
    void shortestAngle2Test() {
        Position start = new Position(0, 0, Math.PI / 4);
        Position end = new Position(0, -4, 0);

        Road road = new Road(start, end);

        assertEquals(road.orientationToGoal(), -3 * Math.PI / 4);
    }

    /**
     *
     */
    @Test
    void shortestAngle3Test() {
        Position start = new Position(0, 0, Math.PI / 4);
        Position end = new Position(-4, -4, 0);

        Road road = new Road(start, end);

        assertEquals(road.orientationToGoal(), -Math.PI);
    }

    @Test
    public void findClosestPossibleAngleWithRudderTest() {
        Position posMock = mock(Position.class);
        Road road = new Road(new Position(0, 0, 0), posMock);
        when(posMock.getOrientation()).thenReturn(0.0);
        when(posMock.getX()).thenReturn(5000.0);
        when(posMock.getY()).thenReturn(-12071.0);
        assertEquals(1, road.findClosestPossibleAngle(4, true)); //pour un angle de -3pi/8
        when(posMock.getX()).thenReturn(4.0);
        when(posMock.getY()).thenReturn(-4.0);
        assertEquals(1, road.findClosestPossibleAngle(4, true)); //pour un angle de -pi/4
        when(posMock.getX()).thenReturn(10000.0);
        when(posMock.getY()).thenReturn(-19209.0);
        assertEquals(1, road.findClosestPossibleAngle(4, true)); //pour un angle -25pi/72
        when(posMock.getX()).thenReturn(5000.0);
        when(posMock.getY()).thenReturn(437.0);
        assertEquals(2, road.findClosestPossibleAngle(4, true)); //pour un angle de pi/36
        when(posMock.getX()).thenReturn(5000.0);
        when(posMock.getY()).thenReturn(12072.0);
        assertEquals(4, road.findClosestPossibleAngle(4, true)); //pour un angle de 3pi/8
        when(posMock.getX()).thenReturn(100.0);
        when(posMock.getY()).thenReturn(1143.0);
        assertEquals(4, road.findClosestPossibleAngle(4, true)); //pour un angle de 17pi/36

    }

    @Test
    public void findClosestPossibleAngleTestWithRudder3() {
        Position posMock = mock(Position.class);
        Road road = new Road(new Position(0, 0, 0), posMock);
        when(posMock.getX()).thenReturn(10000.0);
        when(posMock.getY()).thenReturn(9696.7);
        assertEquals(3, road.findClosestPossibleAngle(6, true));

    }

    @Test
    public void findClosestPossibleAngleTestWithRudder2() {
        Position posMock = mock(Position.class);
        Road road = new Road(new Position(0, 0, 0), posMock);
        when(posMock.getX()).thenReturn(0.0);
        when(posMock.getY()).thenReturn(-1.0);
        assertEquals(0, road.findClosestPossibleAngle(3, true)); //pour un angle de -pi/2
        when(posMock.getX()).thenReturn(3.0);
        when(posMock.getY()).thenReturn(-Math.sqrt(3));
        assertEquals(2, road.findClosestPossibleAngle(3, true)); //pour un angle de -pi/6
        when(posMock.getX()).thenReturn(10000.0);
        when(posMock.getY()).thenReturn(-4663.0);
        assertEquals(2, road.findClosestPossibleAngle(3, true)); //pour un angle de -5pi/36
        when(posMock.getX()).thenReturn(5000.0);
        when(posMock.getY()).thenReturn(437.0);
        assertEquals(2, road.findClosestPossibleAngle(3, true)); //pour un angle de pi/36
        when(posMock.getX()).thenReturn(3.0);
        when(posMock.getY()).thenReturn(Math.sqrt(3));
        assertEquals(2, road.findClosestPossibleAngle(3, true)); //pour un angle de pi/6
        when(posMock.getX()).thenReturn(1.0);
        when(posMock.getY()).thenReturn(Math.sqrt(3));
        assertEquals(3, road.findClosestPossibleAngle(3, true)); //pour un angle de pi/3
        when(posMock.getX()).thenReturn(0.0);
        when(posMock.getY()).thenReturn(1.0);
        assertEquals(3, road.findClosestPossibleAngle(3, true)); //pour un angle de pi/2

    }

    @Test
    public void findClosestPossibleAngleWithoutRudderTest() {
        Position posMock = mock(Position.class);
        Road road = new Road(new Position(0, 0, 0), posMock);
        when(posMock.getOrientation()).thenReturn(0.0);
        when(posMock.getX()).thenReturn(5000.0);
        when(posMock.getY()).thenReturn(-12071.0);
        assertEquals(1, road.findClosestPossibleAngle(4, false)); //pour un angle de -3pi/8
        when(posMock.getX()).thenReturn(4.0);
        when(posMock.getY()).thenReturn(-4.0);
        assertEquals(1, road.findClosestPossibleAngle(4, false)); //pour un angle de -pi/4
        when(posMock.getX()).thenReturn(10000.0);
        when(posMock.getY()).thenReturn(-19209.0);
        assertEquals(1, road.findClosestPossibleAngle(4, false)); //pour un angle -25pi/72
        when(posMock.getX()).thenReturn(5000.0);
        when(posMock.getY()).thenReturn(437.0);
        assertEquals(2, road.findClosestPossibleAngle(4, false)); //pour un angle de pi/36
        when(posMock.getX()).thenReturn(5000.0);
        when(posMock.getY()).thenReturn(12072.0);
        assertEquals(4, road.findClosestPossibleAngle(4, false)); //pour un angle de 3pi/8
        when(posMock.getX()).thenReturn(100.0);
        when(posMock.getY()).thenReturn(1143.0);
        assertEquals(4, road.findClosestPossibleAngle(4, false)); //pour un angle de 17pi/36

    }

    @Test
    public void findClosestPossibleAngleTestWithoutRudder3() {
        Position posMock = mock(Position.class);
        Road road = new Road(new Position(0, 0, 0), posMock);
        when(posMock.getX()).thenReturn(10000.0);
        when(posMock.getY()).thenReturn(9696.7);
        assertEquals(4, road.findClosestPossibleAngle(6, false));

    }

    @Test
    public void findClosestPossibleAngleTestWithoutRudder2() {
        Position posMock = mock(Position.class);
        Road road = new Road(new Position(0, 0, 0), posMock);
        when(posMock.getX()).thenReturn(0.0);
        when(posMock.getY()).thenReturn(-1.0);
        assertEquals(0, road.findClosestPossibleAngle(3, false)); //pour un angle de -pi/2
        when(posMock.getX()).thenReturn(3.0);
        when(posMock.getY()).thenReturn(-Math.sqrt(3));
        assertEquals(1, road.findClosestPossibleAngle(3, false)); //pour un angle de -pi/6
        when(posMock.getX()).thenReturn(10000.0);
        when(posMock.getY()).thenReturn(-4663.0);
        assertEquals(1, road.findClosestPossibleAngle(3, false)); //pour un angle de -5pi/36
        when(posMock.getX()).thenReturn(5000.0);
        when(posMock.getY()).thenReturn(437.0);
        assertEquals(2, road.findClosestPossibleAngle(3, false)); //pour un angle de pi/36
        when(posMock.getX()).thenReturn(3.0);
        when(posMock.getY()).thenReturn(Math.sqrt(3));
        assertEquals(2, road.findClosestPossibleAngle(3, false)); //pour un angle de pi/6
        when(posMock.getX()).thenReturn(1.0);
        when(posMock.getY()).thenReturn(Math.sqrt(3));
        assertEquals(3, road.findClosestPossibleAngle(3, false)); //pour un angle de pi/3
        when(posMock.getX()).thenReturn(0.0);
        when(posMock.getY()).thenReturn(1.0);
        assertEquals(3, road.findClosestPossibleAngle(3, false)); //pour un angle de pi/2

    }
}
