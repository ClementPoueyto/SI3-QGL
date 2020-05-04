package fr.unice.polytech.si3.qgl.zecommit;

import fr.unice.polytech.si3.qgl.zecommit.boat.Ship;
import fr.unice.polytech.si3.qgl.zecommit.crew.Sailor;
import fr.unice.polytech.si3.qgl.zecommit.entite.Entity;
import fr.unice.polytech.si3.qgl.zecommit.goal.Goal;
import fr.unice.polytech.si3.qgl.zecommit.other.VisibleEntitie;
import fr.unice.polytech.si3.qgl.zecommit.other.Wind;

import java.util.List;

/**
 * Classe contenant les informations de la partie
 */
public class Game {
    private Goal goal;
    private Ship ship;
    private List<Sailor> sailors;
    private List<Entity> entityList;
    private int shipCount;
    private Wind wind;
    private List<VisibleEntitie> visibleEntities;


    //------------------------GETTER-------------------------------------------


    public Ship getShip() {
        return ship;
    }

    public Goal getGoal() {
        return goal;
    }

    public int getShipCount() {
        return shipCount;
    }

    public List<Sailor> getSailors() {
        return sailors;
    }

    public List<Entity> getEntityList() {
        return entityList;
    }

    public List<VisibleEntitie> getVisibleEntities() {
        return visibleEntities;
    }

    public Wind getWind() {
        return wind;
    }

    //------------------------SETTER-----------------------------


    public void setEntityList(List<Entity> entityList) {
        this.entityList = entityList;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public void setSailors(List<Sailor> sailors) {
        this.sailors = sailors;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public void setShipCount(int shipCount) {
        this.shipCount = shipCount;
    }

    public void setVisibleEntities(List<VisibleEntitie> visibleEntities) {
        this.visibleEntities = visibleEntities;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }
}

