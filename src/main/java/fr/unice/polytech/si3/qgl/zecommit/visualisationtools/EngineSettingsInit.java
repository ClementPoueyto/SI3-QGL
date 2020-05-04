package fr.unice.polytech.si3.qgl.zecommit.visualisationtools;

import fr.unice.polytech.si3.qgl.zecommit.boat.Ship;
import fr.unice.polytech.si3.qgl.zecommit.crew.Sailor;
import fr.unice.polytech.si3.qgl.zecommit.goal.Goal;

import java.util.List;

/**
 * Structure du Json d'entrée fourni à l'initialisation de la simulation
 * @author Clement
 */
class EngineSettingsInit {
    private Goal goal;
    private int shipCount;
    private Ship ship;
    private List<Sailor> sailors;

    EngineSettingsInit(Goal goal, Ship s, List<Sailor> sailors) {
        this.goal = goal;
        this.shipCount = 1;
        this.ship = s;
        this.sailors = sailors;
    }

    public Goal getGoal() {
        return goal;
    }

    public int getShipCount() {
        return shipCount;
    }

    public Ship getShip() {
        return ship;
    }

    public List<Sailor> getSailors() {
        return sailors;
    }

}
