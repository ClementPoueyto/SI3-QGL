package fr.unice.polytech.si3.qgl.zecommit;

import fr.unice.polytech.si3.qgl.zecommit.visualisationtools.Engine;
import fr.unice.polytech.si3.qgl.zecommit.visualisationtools.settings.*;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * @author Nathan
 */
public class IntegrationTest {

    @Category(IntegrationTest.class)
    @Test
    public void week1Test(){
        String[] str = {" "};
        Engine.showWindow = false;
        Engine.showDeck = false;
        Engine.engineSettings = new EngineSettingsWeek1();
        assertDoesNotThrow(() -> Engine.main(str));
    }
    @Category(IntegrationTest.class)
    @Test
    public void week2Test(){
        String[] str = {" "};
        Engine.showWindow = false;
        Engine.showDeck = false;
        Engine.engineSettings = new EngineSettingsWeek2();
        assertDoesNotThrow(() -> Engine.main(str));
    }
    @Category(IntegrationTest.class)
    @Test
    public void week3Test(){
        String[] str = {" "};
        Engine.showWindow = false;
        Engine.showDeck = false;
        Engine.engineSettings = new EngineSettingsWeek3();
        assertDoesNotThrow(() -> Engine.main(str));
    }
    @Category(IntegrationTest.class)
    @Test
    public void week4Test(){
        String[] str = {" "};
        Engine.showWindow = false;
        Engine.showDeck = false;
        Engine.engineSettings = new EngineSettingsWeek4();
        assertDoesNotThrow(() -> Engine.main(str));
    }

    @Category(IntegrationTest.class)
    @Test
    public void week5Test(){
        String[] str = {" "};
        Engine.showWindow = false;
        Engine.showDeck = false;
        Engine.engineSettings = new EngineSettingsWeek5();
        assertDoesNotThrow(() -> Engine.main(str));
    }

    @Category(IntegrationTest.class)
    @Test
    public void week6Test(){
        String[] str = {" "};
        Engine.showWindow = false;
        Engine.showDeck = false;
        Engine.engineSettings = new EngineSettingsWeek6();
        assertDoesNotThrow(() -> Engine.main(str));
    }

    @Category(IntegrationTest.class)
    @Test
    public void week7Test(){
        String[] str = {" "};
        Engine.showWindow = false;
        Engine.showDeck = false;
        Engine.engineSettings = new EngineSettingsWeek7();
        assertDoesNotThrow(() -> Engine.main(str));
    }

    @Category(IntegrationTest.class)
    @Test
    @Disabled //Normal : tour du monde, course non officielle
    public void week8Test(){
        String[] str = {" "};
        Engine.showWindow = false;
        Engine.showDeck = false;
        Engine.engineSettings = new EngineSettingsWeek8();
        assertDoesNotThrow(() -> Engine.main(str));
    }

    @Category(IntegrationTest.class)
    @Test
    @Disabled // en cours de correction
    public void week9Test(){
        String[] str = {" "};
        Engine.showWindow = false;
        Engine.showDeck = false;
        Engine.engineSettings = new EngineSettingsWeek9();
        assertDoesNotThrow(() -> Engine.main(str));
    }
    @Category(IntegrationTest.class)
    @Test
    public void week10Test(){
        String[] str = {" "};
        Engine.showWindow = false;
        Engine.showDeck = false;
        Engine.engineSettings = new EngineSettingsWeek10();
        assertDoesNotThrow(() -> Engine.main(str));
    }
    @Category(IntegrationTest.class)
    @Test
    public void week11Test(){
        String[] str = {" "};
        Engine.showWindow = false;
        Engine.showDeck = false;
        Engine.engineSettings = new EngineSettingsWeek11();
        assertDoesNotThrow(() -> Engine.main(str));
    }
    @Category(IntegrationTest.class)
    @Test
    public void week12Test(){
        String[] str = {" "};
        Engine.showWindow = false;
        Engine.showDeck = false;
        Engine.engineSettings = new EngineSettingsWeek12();
        assertDoesNotThrow(() -> Engine.main(str));
    }
}
