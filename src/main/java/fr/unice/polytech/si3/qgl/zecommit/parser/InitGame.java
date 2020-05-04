package fr.unice.polytech.si3.qgl.zecommit.parser;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import fr.unice.polytech.si3.qgl.zecommit.boat.Ship;
import fr.unice.polytech.si3.qgl.zecommit.crew.Sailor;
import fr.unice.polytech.si3.qgl.zecommit.deserializer.InitGameDeserializer;
import fr.unice.polytech.si3.qgl.zecommit.goal.Goal;

import java.util.List;

/**
 * parser de l'initgame
 */
@JsonDeserialize(using = InitGameDeserializer.class)
public class InitGame  {
    private Goal goal;
    private Ship ship;
    private List<Sailor> sailors;
    private int shipCount;

    public InitGame(Goal goal, Ship ship, List<Sailor> sailors, int shipCount) {
        this.goal = goal;
        this.ship = ship;
        this.sailors = sailors;
        this.ship.getDeck().setSailors(sailors);
        this.shipCount = shipCount;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public List<Sailor> getSailors() {
        return sailors;
    }

    public void setSailors(List<Sailor> sailors) {
        this.sailors = sailors;
    }

    public int getShipCount() {
        return shipCount;
    }

    public void setShipCount(int shipCount) {
        this.shipCount = shipCount;
    }
}
