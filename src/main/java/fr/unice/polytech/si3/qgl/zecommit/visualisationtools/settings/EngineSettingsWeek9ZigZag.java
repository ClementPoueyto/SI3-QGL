package fr.unice.polytech.si3.qgl.zecommit.visualisationtools.settings;

import fr.unice.polytech.si3.qgl.zecommit.boat.Deck;
import fr.unice.polytech.si3.qgl.zecommit.boat.Position;
import fr.unice.polytech.si3.qgl.zecommit.boat.Ship;
import fr.unice.polytech.si3.qgl.zecommit.crew.Sailor;
import fr.unice.polytech.si3.qgl.zecommit.entite.*;
import fr.unice.polytech.si3.qgl.zecommit.goal.Regatta;
import fr.unice.polytech.si3.qgl.zecommit.other.*;
import fr.unice.polytech.si3.qgl.zecommit.shape.*;

import java.util.ArrayList;

/**
 * EngineSettiing ZigZag
 */
public class EngineSettingsWeek9ZigZag extends EngineSettings {

    /*
     * ################################################ SETTINGS ################################################
     */

    @Override
    public void setVisibleEntities() {
        this.visibleEntities = new ArrayList<>();

        Circle circle1 = new Circle(100);
        Position position1 = new Position(1300, 0,0);
        Circle circle2 = new Circle(80);
        Position position2 = new Position(1560, 0,0);
        Circle circle3 = new Circle(40);
        Position position3 = new Position(480, 0,0);



        this.visibleEntities.add(new Reef(position1, circle1));
        this.visibleEntities.add(new Reef(position2, circle2));
        //this.visibleEntities.add(new Reef(position3, circle3));


    }

    @Override
    public void setShip() {
        this.ship = new Ship("ship", 100, new Position(0, 0, 0), "ZECOMMIT", deck, entities, shape);
    }

    @Override
    public void setWind() {
        this.winds.add(new Wind(0, 150));

    }

    @Override
    public void setSailors() {
        this.sailors = new ArrayList<>();

        this.sailors.add(new Sailor(0, 0, 0, "jean"));
        this.sailors.add(new Sailor(1, 0, 1, "paul"));
        this.sailors.add(new Sailor(2, 0, 2, "jacques"));
        this.sailors.add(new Sailor(3, 1, 0, "pierre"));
        this.sailors.add(new Sailor(4, 1, 1, "Vincent"));
        this.sailors.add(new Sailor(5, 1, 2, "Joris"));
        this.sailors.add(new Sailor(6, 2, 0, "jean"));

    }

    @Override
    public void setGoal() {
        this.goal = new Regatta(new ArrayList<>(checkpoints));
    }

    @Override
    public void setCheckpoints() {

        this.checkpoints = new ArrayList<>();

        this.checkpoints.add(new Checkpoint(new Position(1440, 0, 0), new Circle(35)));
        this.checkpoints.add(new Checkpoint(new Position(1680, 0, 0), new Circle(35)));
        //this.checkpoints.add(new Checkpoint(new Position(41, 410.3, 0), new Circle(50)));


        this.allCheckpoints = new ArrayList<>(checkpoints);
    }

    @Override
    public void setDeck() {
        this.deck = new Deck(3, 4);
        this.deck.setSailors(sailors);
    }

    @Override
    public void setEntities() {

        this.entities = new ArrayList<>();
        this.entities.add(new Oar(1, 0));
        this.entities.add(new Oar(2, 0));
        this.entities.add(new Oar(1, 2));
        this.entities.add(new Oar(2, 2));
        this.entities.add(new Rudder(3, 1));
        this.entities.add(new Watch(0, 1));
        this.entities.add(new Sail(1, 1, false));

    }

    @Override
    public void setShape() {
        this.shape = new Rectangle(5, 11, 0);
    }

}
