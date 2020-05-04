package fr.unice.polytech.si3.qgl.zecommit.visualisationtools.settings;

import fr.unice.polytech.si3.qgl.zecommit.boat.Deck;
import fr.unice.polytech.si3.qgl.zecommit.boat.Position;
import fr.unice.polytech.si3.qgl.zecommit.boat.Ship;
import fr.unice.polytech.si3.qgl.zecommit.crew.Sailor;
import fr.unice.polytech.si3.qgl.zecommit.entite.Oar;
import fr.unice.polytech.si3.qgl.zecommit.entite.Rudder;
import fr.unice.polytech.si3.qgl.zecommit.goal.Regatta;
import fr.unice.polytech.si3.qgl.zecommit.other.Checkpoint;
import fr.unice.polytech.si3.qgl.zecommit.other.Wind;
import fr.unice.polytech.si3.qgl.zecommit.shape.Circle;
import fr.unice.polytech.si3.qgl.zecommit.shape.Rectangle;

import java.util.ArrayList;

public class EngineSettingsWeek3 extends EngineSettings {

    @Override
    public void setShip() {
        this.ship = new Ship("ship", 300, new Position(0, 0, 0), "ZECOMMIT", deck, entities, shape);
    }

    @Override
    public void setSailors() {
        this.sailors = new ArrayList<>();
        this.sailors.add(new Sailor(0, 0, 0, "jean"));
        this.sailors.add(new Sailor(1, 1, 0, "paul"));
        this.sailors.add(new Sailor(2, 0, 0, "jean"));
        this.sailors.add(new Sailor(3, 1, 0, "paul"));
    }

    @Override
    public void setGoal() {
        this.goal = new Regatta(new ArrayList<>(checkpoints));
    }

    @Override
    public void setCheckpoints() {
        this.checkpoints = new ArrayList<>();
        this.checkpoints.add(new Checkpoint(new Position(50, 1000, 0), new Circle(50)));
        this.checkpoints.add(new Checkpoint(new Position(500, -200, 0), new Circle(50)));
        this.checkpoints.add(new Checkpoint(new Position(-500, 1250, 0), new Circle(60)));
        this.allCheckpoints = new ArrayList<>(checkpoints);
    }

    @Override
    public void setDeck() {
        this.deck = new Deck(4, 3);
        this.deck.setSailors(sailors);
    }

    @Override
    public void setEntities() {
        this.entities = new ArrayList<>();
        this.entities.add(new Oar(0,0));
        this.entities.add(new Oar(0,2));
        this.entities.add(new Oar(1,0));
        this.entities.add(new Oar(1,2));
        this.entities.add(new Oar(2,0));
        this.entities.add(new Oar(2,2));
        this.entities.add(new Rudder(3,1));
    }

    @Override
    public void setShape() {
        this.shape = new Rectangle(4, 2, 0);
    }

    @Override
    public void setWind(){
        this.wind = new Wind(0,0);
    }


}
