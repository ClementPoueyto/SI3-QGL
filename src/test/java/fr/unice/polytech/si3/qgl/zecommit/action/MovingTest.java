package fr.unice.polytech.si3.qgl.zecommit.action;

import fr.unice.polytech.si3.qgl.zecommit.crew.Sailor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovingTest {

    Sailor s = new Sailor(1, 0, 0, "Mousson");
    /**
     * On construit un objet Moving avec une distance respectant la spec
     */
    @Test
    void mouvAvecDistanceCorrecteTest() {
        Moving moving = new Moving(s.getId(), 2,1);
        assertEquals(2, moving.getXDistance());
        assertEquals(1, moving.getYDistance());
    }

    /**
     * On construit un objet Moving avec une distance respectant la spec
     * Conditions limites
     */
    @Test
    void mouvAvecDistanceCorrecteCdtLmtTest() {
        Moving moving = new Moving(s.getId(), 3,2);
        assertEquals(3, moving.getXDistance());
        assertEquals(2, moving.getYDistance());
    }

    /**
     * On construit un objet Moving avec une distance ne respectant pas la spec
     * On veut donc que la distance soit nulle
     */
    @Test
    void mouvAvecDistanceNonCorrecteTest() {
        Moving moving = new Moving(s.getId(), 5,3);
        assertEquals(5, moving.getXDistance());
        assertEquals(0, moving.getYDistance());
    }

    @Test
    void mouvAvecDistanceNegativeTest() {
        Moving moving = new Moving(s.getId(), 3,-3);
        assertEquals(3, moving.getXDistance());
        assertEquals(-2, moving.getYDistance());
    }


    @Test
    void mouvAvecDistanceNegativeTest2() {
        Moving moving = new Moving(s.getId(), -7,-3);
        assertEquals(-5, moving.getXDistance());
        assertEquals(0, moving.getYDistance());
    }

    @Test
    void mouvTest() {
        Moving moving = new Moving(s.getId(), 7,-3);
        assertEquals(5, moving.getXDistance());
        assertEquals(0, moving.getYDistance());
    }

}
