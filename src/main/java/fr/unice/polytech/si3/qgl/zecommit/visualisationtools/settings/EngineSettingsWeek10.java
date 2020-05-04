package fr.unice.polytech.si3.qgl.zecommit.visualisationtools.settings;

import fr.unice.polytech.si3.qgl.zecommit.boat.Deck;
import fr.unice.polytech.si3.qgl.zecommit.boat.Position;
import fr.unice.polytech.si3.qgl.zecommit.boat.Ship;
import fr.unice.polytech.si3.qgl.zecommit.crew.Sailor;
import fr.unice.polytech.si3.qgl.zecommit.entite.Oar;
import fr.unice.polytech.si3.qgl.zecommit.entite.Rudder;
import fr.unice.polytech.si3.qgl.zecommit.entite.Sail;
import fr.unice.polytech.si3.qgl.zecommit.entite.Watch;
import fr.unice.polytech.si3.qgl.zecommit.goal.Regatta;
import fr.unice.polytech.si3.qgl.zecommit.other.Checkpoint;
import fr.unice.polytech.si3.qgl.zecommit.other.Reef;
import fr.unice.polytech.si3.qgl.zecommit.other.Stream;
import fr.unice.polytech.si3.qgl.zecommit.other.Wind;
import fr.unice.polytech.si3.qgl.zecommit.shape.Circle;
import fr.unice.polytech.si3.qgl.zecommit.shape.Point;
import fr.unice.polytech.si3.qgl.zecommit.shape.Polygone;
import fr.unice.polytech.si3.qgl.zecommit.shape.Rectangle;

import java.util.ArrayList;

/**
 * EngineSettiing du week10 : Archipel
 */
public class EngineSettingsWeek10 extends EngineSettings {

    /*
     * ################################################ SETTINGS ################################################
     */

    @Override
    public void setVisibleEntities() {
        this.visibleEntities = new ArrayList<>();

        Position position1 = new Position(3193.2773109243703, 2466.98679471789, 0);
        Circle shape1 = new Circle(250);

        Position position2 = new Position(4133.168823084799, 3071.6997910275236, 0);
        Polygone shape2 = new Polygone(5.358160803622591, new Point[]{new Point(200, -350), new Point(300, 150), new Point(-300, 150)});

        Position position3 = new Position(4261.7046818727495, 1788.7154861944798, 5.410520681182422);
        Rectangle shape3 = new Rectangle(150, 500, 0);

        Position position4 = new Position(4987.995198079245, 2644.0576230492193, 0);
        Polygone shape4 = new Polygone(0, new Point[]{new Point(350, 0), new Point(250, 250), new Point(-100, 150), new Point(-150, -150), new Point(250, -200)});

        Position position5 = new Position(4375.750300120048, 3955.5822328931586, 2.5132741228718345);
        Rectangle shape5 = new Rectangle(400, 500, 0);

        Position position6 = new Position(4669.867947178872, 3193.2773109243712, 0);
        Circle shape6 = new Circle(100);

        Position position7 = new Position(3481.392557022809, 3229.2917166866755, 0);
        Polygone shape7 = new Polygone(0.6457718232379019, new Point[]{new Point(150, 150), new Point(-150, 50), new Point(0, -200)});

        Position position8 = new Position(4171.668667466992, 2286.914765906367, 0);
        Rectangle shape8 = new Rectangle(200, 1000, 0);


        Position position9 = new Position(3805.5222088835535, 3151.2605042016826, 4.39822971502571);
        Rectangle shape9 = new Rectangle(200, 1000, 0);

       /* this.visibleEntities.add(new Reef(new Position(4787.9655830888405, 2113.3604670048157,0), new Circle(10)));
        this.visibleEntities.add(new Reef(new Position(4670.44557868102, 2226.446487187177,0), new Circle(10)));
        this.visibleEntities.add(new Reef(new Position(4538.84258332067, 2311.1385718378983,0), new Circle(10)));
        this.visibleEntities.add(new Reef(new Position(4491.455365691989, 2404.4605042766902,0), new Circle(10)));
        this.visibleEntities.add(new Reef(new Position(4481.809904794973, 2569.1782686732695,0), new Circle(10)));
        this.visibleEntities.add(new Reef(new Position(4425.46476260358, 2662.4701207517437,0), new Circle(10)));
        this.visibleEntities.add(new Reef(new Position(4196.175615460134, 2799.8311814272865,0), new Circle(10)));

        */
        //this.visibleEntities.add(new Reef(new Position(4283.381929688104, 2746.3596722005063,0), new Circle(10)));

        this.visibleEntities.add(new Reef(position1, shape1));
        this.visibleEntities.add(new Reef(position2, shape2));
        this.visibleEntities.add(new Reef(position3, shape3));
        this.visibleEntities.add(new Reef(position4, shape4));
        this.visibleEntities.add(new Reef(position5, shape5));
        this.visibleEntities.add(new Reef(position6, shape6));
        this.visibleEntities.add(new Reef(position7, shape7));
        this.visibleEntities.add(new Stream(position8, shape8, 10));
        this.visibleEntities.add(new Stream(position9, shape9, 10));


    }

    @Override
    public void setShip() {
        this.ship = new Ship("ship", 900, new Position(1092.4369747899182, 1776.710684273709, 1.5707963267948966), "ZECOMMIT", deck, entities, shape);
    }

    @Override
    public void setWind() {
        this.winds.add(new Wind(0, 0));

    }

    @Override
    public void setSailors() {
        this.sailors = new ArrayList<>();


        this.sailors.add(new Sailor(0, 0, 0, "jean"));
        this.sailors.add(new Sailor(1, 0, 1, "paul"));
        this.sailors.add(new Sailor(2, 0, 2, "jacques"));
        this.sailors.add(new Sailor(3, 0, 3, "pierre"));
        this.sailors.add(new Sailor(4, 0, 4, "Vincent"));
        this.sailors.add(new Sailor(5, 1, 0, "Joris"));
        this.sailors.add(new Sailor(6, 1, 1, "jean"));
        this.sailors.add(new Sailor(7, 1, 2, "jean"));
        this.sailors.add(new Sailor(8, 1, 3, "jean"));
        this.sailors.add(new Sailor(9, 1, 4, "jean"));
        this.sailors.add(new Sailor(10, 2, 0, "jean"));
        this.sailors.add(new Sailor(11, 2, 1, "jean"));
        this.sailors.add(new Sailor(12, 2, 2, "jean"));

    }

    @Override
    public void setGoal() {
        this.goal = new Regatta(new ArrayList<>(checkpoints));
    }

    @Override
    public void setCheckpoints() {

        this.checkpoints = new ArrayList<>();

        this.checkpoints.add(new Checkpoint(new Position(2292.9171668667423, 2238.8955582232875, 0), new Circle(100)));
        this.checkpoints.add(new Checkpoint(new Position(5024.009603841534, 1620.6482593037217, 0), new Circle(100)));
        this.checkpoints.add(new Checkpoint(new Position(3661.4645858343365, 3841.536614645855, 0), new Circle(100)));



                /*
        this.checkpoints.add(new Checkpoint(new Position(5288.115246098437, 1650.6602641056418, 0), new Circle(100)));
        this.checkpoints.add(new Checkpoint(new Position(4273.709483793517, 3475.390156062426, 0), new Circle(100)));
        this.checkpoints.add(new Checkpoint(new Position(2983.193277310925, 1686.6746698679472, 0), new Circle(100)));
        this.checkpoints.add(new Checkpoint(new Position(3475.3901560624263, 3973.589435774311, 0), new Circle(100)));
        this.checkpoints.add(new Checkpoint(new Position(2052.8211284513804, 2262.9051620648256, 0), new Circle(100)));

                 */


        this.allCheckpoints = new ArrayList<>(checkpoints);
    }

    @Override
    public void setDeck() {
        this.deck = new Deck(3, 6);
        this.deck.setSailors(sailors);
    }

    @Override
    public void setEntities() {


        this.entities = new ArrayList<>();


        this.entities.add(new Oar(5, 0));
        this.entities.add(new Oar(5, 2));
        this.entities.add(new Oar(4, 0));
        this.entities.add(new Oar(3, 0));
        this.entities.add(new Oar(2, 0));
        this.entities.add(new Oar(1, 0));
        this.entities.add(new Oar(4, 2));
        this.entities.add(new Oar(3, 2));
        this.entities.add(new Oar(2, 2));
        this.entities.add(new Oar(1, 2));


        this.entities.add(new Rudder(5, 1));
        this.entities.add(new Watch(0, 1));
        this.entities.add(new Sail(3, 1, false));

    }

    @Override
    public void setShape() {
        this.shape = new Polygone(0, new Point[]{new Point(6, -2.5), new Point(-6, 2.5), new Point(-6, 2.5), new Point(-6, -2.5)});
    }


}
