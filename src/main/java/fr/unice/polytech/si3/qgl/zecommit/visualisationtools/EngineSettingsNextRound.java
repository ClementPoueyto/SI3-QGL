package fr.unice.polytech.si3.qgl.zecommit.visualisationtools;

import fr.unice.polytech.si3.qgl.zecommit.boat.Ship;
import fr.unice.polytech.si3.qgl.zecommit.other.VisibleEntitie;
import fr.unice.polytech.si3.qgl.zecommit.other.Wind;

import java.util.ArrayList;

/**
 * Structure du Json d'entrée fourni à chaque Round de la simulation
 */
public class EngineSettingsNextRound {
    private Ship ship;
    private ArrayList<VisibleEntitie> visibleEntities;
    private Wind wind;

    EngineSettingsNextRound(Ship s, ArrayList<VisibleEntitie> vE, Wind w) {
        this.ship = s;
        this.visibleEntities = vE;
        this.wind = w;
    }

    public Ship getShip() {
        return ship;
    }

    public ArrayList<VisibleEntitie> getVisibleEntities() {
        return visibleEntities;
    }

    public Wind getWind() {
        return wind;
    }
}
