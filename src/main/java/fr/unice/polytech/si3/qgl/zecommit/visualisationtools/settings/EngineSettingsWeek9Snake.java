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
 * EngineSettiing Snake
 */
public class EngineSettingsWeek9Snake extends EngineSettings {

    /*
     * ################################################ SETTINGS ################################################
     */

    @Override
    public void setVisibleEntities() {
        this.visibleEntities = new ArrayList<>();



        Circle circle1 = new Circle(90.18);
        Position position1 = new Position(67.75, 298.82, 0);
        Circle circle2 = new Circle(116.49);
        Position position2 = new Position(93.3, 414.95, 0);
        Circle circle3 = new Circle(78.82);
        Position position3 = new Position(209.42, 519.46, 0);
        Circle circle4 = new Circle(84.18);
        Position position4 = new Position(332.51, 143.22, 0);
        Circle circle5 = new Circle(62.48);
        Position position5 = new Position(332.51, 203.6, 0);
        Circle circle6 = new Circle(45);
        Position position6 = new Position(332.51, 287.21, 0);
        Circle circle7 = new Circle(79.44);
        Position position7 = new Position(330.9, 554.3, 0);
        Circle circle8 = new Circle(45);
        Position position8 = new Position(443.99, 507.85, 0);
        Circle circle9 = new Circle(45.09);
        Position position9 = new Position(478.83, 431.2, 0);


        this.visibleEntities.add(new Reef(position1, circle1));
        this.visibleEntities.add(new Reef(position2, circle2));
        this.visibleEntities.add(new Reef(position3, circle3));
        this.visibleEntities.add(new Reef(position4, circle4));
        this.visibleEntities.add(new Reef(position5, circle5));
        this.visibleEntities.add(new Reef(position6, circle6));
        this.visibleEntities.add(new Reef(position7, circle7));
        this.visibleEntities.add(new Reef(position8, circle8));
        this.visibleEntities.add(new Reef(position9, circle9));


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

        this.checkpoints.add(new Checkpoint(new Position(200, 200, 0), new Circle(50)));
        this.checkpoints.add(new Checkpoint(new Position(295.35, 410.3, 0), new Circle(50)));
        this.checkpoints.add(new Checkpoint(new Position(460.25, 217.54, 0), new Circle(50)));
        this.checkpoints.add(new Checkpoint(new Position(601.92, 433.53, 0), new Circle(50)));

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
