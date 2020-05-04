package fr.unice.polytech.si3.qgl.zecommit.visualisationtools.settings;

import fr.unice.polytech.si3.qgl.zecommit.boat.Deck;
import fr.unice.polytech.si3.qgl.zecommit.boat.Position;
import fr.unice.polytech.si3.qgl.zecommit.boat.Ship;
import fr.unice.polytech.si3.qgl.zecommit.crew.Sailor;
import fr.unice.polytech.si3.qgl.zecommit.entite.Oar;

import fr.unice.polytech.si3.qgl.zecommit.goal.Regatta;
import fr.unice.polytech.si3.qgl.zecommit.other.Checkpoint;
import fr.unice.polytech.si3.qgl.zecommit.shape.Circle;
import fr.unice.polytech.si3.qgl.zecommit.shape.Rectangle;

import java.util.ArrayList;

public class EngineSettingsWeek1 extends EngineSettings {

    @Override
    public void setShip() {
        this.ship = new Ship("ship", 100, new Position(0, 0, 0), "ZECOMMIT", deck, entities, shape);
    }

    @Override
    public void setSailors() {
        this.sailors = new ArrayList<>();
        this.sailors.add(new Sailor(0, 0, 0, "jean"));
        this.sailors.add(new Sailor(1, 1, 0, "paul"));
    }

    @Override
    public void setGoal() {
        this.goal = new Regatta(new ArrayList<>(checkpoints));
    }

    @Override
    public void setCheckpoints() {
        this.checkpoints = new ArrayList<>();
        this.checkpoints.add(new Checkpoint(new Position(1000, 0, 0), new Circle(50)));
        this.allCheckpoints = new ArrayList<>(checkpoints);
    }

    @Override
    public void setDeck() {
        this.deck = new Deck(2, 1);
        this.deck.setSailors(sailors);
    }

    @Override
    public void setEntities() {
        this.entities = new ArrayList<>();
        this.entities.add(new Oar(0,0));
        this.entities.add(new Oar(0,1));
    }

    @Override
    public void setShape() {
        this.shape = new Rectangle(2, 3, 0);
    }


}
