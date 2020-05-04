package fr.unice.polytech.si3.qgl.zecommit.visualisationtools.settings;


import fr.unice.polytech.si3.qgl.zecommit.boat.Deck;
import fr.unice.polytech.si3.qgl.zecommit.boat.Position;
import fr.unice.polytech.si3.qgl.zecommit.boat.Ship;
import fr.unice.polytech.si3.qgl.zecommit.crew.Sailor;
import fr.unice.polytech.si3.qgl.zecommit.entite.*;
import fr.unice.polytech.si3.qgl.zecommit.goal.Regatta;
import fr.unice.polytech.si3.qgl.zecommit.other.*;
import fr.unice.polytech.si3.qgl.zecommit.shape.Circle;
import fr.unice.polytech.si3.qgl.zecommit.shape.Rectangle;
import java.util.ArrayList;

/**
 * EngineSettiing du week6 : passage entre les deux carrés
 */
public class EngineSettingsWeek6 extends EngineSettings{

    /*
     * ################################################ SETTINGS ################################################
     */


    @Override
    public void setVisibleEntities() {
        this.visibleEntities = new ArrayList<>();

        this.visibleEntities.add(new Reef(new Position(1500, 500, 0.78539816339), new Rectangle(1250.0, 1300, 0)));

        this.visibleEntities.add(new Reef(new Position(500, 1500, 0.78539816339), new Rectangle(1250.0, 1300.0, 0.0)));

        this.visibleEntities.add(new Stream(new Position(1000,1000,0.78539816339), new Rectangle(100,1400, 0), 50));

    }


    @Override
    public void setShip() {
        this.ship = new Ship("ship", 100, new Position(0, 0, 0), "ZECOMMIT", deck, entities, shape);
    }

    @Override
    public void setWind() {
        this.winds.add(new Wind(0.75, 50));

    }

    @Override
    public void setSailors() {
        this.sailors = new ArrayList<>();

        this.sailors.add(new Sailor(0, 0, 0, "jean"));
        this.sailors.add(new Sailor(1, 0, 1, "paul"));
        this.sailors.add(new Sailor(2,0,2,"jacques"));
        this.sailors.add(new Sailor(3,0,3,"pierre"));
        this.sailors.add(new Sailor(4,0,4,"Vincent"));
        this.sailors.add(new Sailor(5,1,0,"Joris"));
        this.sailors.add(new Sailor(6,1,1,"jean"));
        this.sailors.add(new Sailor(7,1,2,"paul"));
        this.sailors.add(new Sailor(8,1,3,"jacques"));
        this.sailors.add(new Sailor(9,1,4,"pierre"));
        this.sailors.add(new Sailor(10,2,0,"Vincent"));
        this.sailors.add(new Sailor(11,2,1,"Joris"));
        this.sailors.add(new Sailor(12,2,2,"jean"));
        this.sailors.add(new Sailor(13,2,3,"paul"));
        this.sailors.add(new Sailor(14,2,4,"jacques"));
        this.sailors.add(new Sailor(15,3,0,"pierre"));
        this.sailors.add(new Sailor(16,3,1,"Vincent"));
        this.sailors.add(new Sailor(17,3,2,"Joris"));
        this.sailors.add(new Sailor(18,3,3,"Joris"));
        this.sailors.add(new Sailor(19,3,4,"Joris"));

    }

    @Override
    public void setGoal() {
        this.goal = new Regatta(new ArrayList<>(checkpoints));
    }

    @Override
    public void setCheckpoints() {

        this.checkpoints = new ArrayList<>();
        this.checkpoints.add(new Checkpoint(new Position(500, 500, 0), new Circle(50)));
        this.checkpoints.add(new Checkpoint(new Position(1000, 1000, 0), new Circle(50)));
        this.checkpoints.add(new Checkpoint(new Position(1500, 1500, 0), new Circle(60)));

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
        this.entities.add(new Oar(3,0));
        this.entities.add(new Oar(4,0));
        this.entities.add(new Oar(5,0));
        this.entities.add(new Oar(6,0));
        this.entities.add(new Oar(7,0));
        this.entities.add(new Oar(8,0));
        this.entities.add(new Oar(9,0));
        this.entities.add(new Oar(1,4));
        this.entities.add(new Oar(2,4));
        this.entities.add(new Oar(3,4));
        this.entities.add(new Oar(4,4));
        this.entities.add(new Oar(5,4));
        this.entities.add(new Oar(6,4));
        this.entities.add(new Oar(7,4));
        this.entities.add(new Oar(8,4));
        this.entities.add(new Oar(9,4));
        this.entities.add(new Rudder(10,4));

        this.entities.add(new Sail(5,2,false));

    }


    @Override
    public void setShape() {
        this.shape = new Rectangle(5, 11, 0);
    }



}

