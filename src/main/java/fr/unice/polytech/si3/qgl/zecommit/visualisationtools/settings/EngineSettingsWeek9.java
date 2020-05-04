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
 * EngineSettiing du week9 : ZeSnake
 */
public class EngineSettingsWeek9 extends EngineSettings {

    /*
     * ################################################ SETTINGS ################################################
     */

    @Override
    public void setVisibleEntities() {
        this.visibleEntities = new ArrayList<>();

        Polygone polygon = new Polygone(0, new Point[]{new Point( -597.3333333333334, 23.999999999999893), new Point( -345.33333333333337, -103.99999999999997), new Point( 942.6666666666666, 80.0)});
        Position position = new Position(657.3333333333334, 2080.0, 0.0);
        Polygone polygon1 = new Polygone(0, new Point[]{new Point( -107.20000000000006, 131.20000000000005), new Point( -175.20000000000002, -92.79999999999997), new Point( -51.20000000000007, -112.79999999999995), new Point( 244.79999999999995, -28.799999999999955), new Point( 88.79999999999995, 103.20000000000003)});
        Position position1 = new Position( 955.2, 1228.8, 0.0);
        Polygone polygon2 = new Polygone(0, new Point[]{new Point( -56.0, -16.00000000000001), new Point( -40.00000000000001, -104.0), new Point( 96.0, 119.99999999999999)});
        Position position2 = new Position( 600.0, 1648.0, 0.0);
        Polygone polygon3 = new Polygone(0, new Point[]{new Point( -542.0, 53.999999999999886), new Point( -158.0, -154.0), new Point( -46.000000000000014, -138.0), new Point( 746.0, 238.00000000000003)});
        Position position3 = new Position( 854.0, 1922.0, 0.0);
        Polygone polygon4 = new Polygone(0, new Point[]{new Point( -93.33333333333326, 2.6666666666667567), new Point( 62.666666666666714, -129.33333333333326), new Point( 30.66666666666674, 126.66666666666676)});
        Position position4 = new Position( 1137.3333333333333, 1329.3333333333333, 0.0);
        Polygone polygon5 = new Polygone(0, new Point[]{new Point( -152.0, 304.0), new Point( -40.00000000000007, -432.0), new Point( 96.00000000000001, -704.0), new Point( 95.99999999999997, 832.0)});
        Position position5 = new Position( 1504.0, 1328.0, 0.0);
        Polygone polygon6 = new Polygone(0, new Point[]{new Point( 182.0, 16.0), new Point( -66.00000000000001, 152.0), new Point( -618.0000000000001, 335.9999999999999), new Point( 501.99999999999994, -504.0)});
        Position position6 = new Position( 658.0, 576.0, 0.0);
        Polygone polygon7 = new Polygone(0, new Point[]{new Point( -76.0, 93.0), new Point( -88.0, 8.999999999999993), new Point( 152.0, -195.00000000000003), new Point( 11.999999999999991, 93.0)});
        Position position7 = new Position( 628.0, 1331.0, 0.0);
        Polygone polygon8 = new Polygone(0, new Point[]{new Point( -205.33333333333326,-128.0), new Point( -21.333333333333275,-200.0), new Point( 226.66666666666674, 328.00000000000006)});
        Position position8 = new Position( 1373.3333333333333, 1832.0, 0.0);
        Polygone polygon9 = new Polygone(0, new Point[]{new Point( -122.99999999999999, 57.99999999999999), new Point( 17.000000000000018, -229.99999999999997), new Point( 85.0, -5.999999999999999), new Point( 20.999999999999996, 178.00000000000003)});
        Position position9 = new Position( 763.0, 1366.0, 0.0);
        Polygone polygon10 = new Polygone(0, new Point[]{new Point( -334.0, -17.999999999999943), new Point( -150.00000000000003, -242.0), new Point( 26.000000000000007, -98.0), new Point( 458.00000000000006, 358.00000000000006)});
        Position position10 = new Position( 1142.0, 1802.0, 0.0);
        Polygone polygon11 = new Polygone(0, new Point[]{new Point( -205.33333333333334, 184.0), new Point( 26.66666666666661, -160.0), new Point( 178.66666666666663, -23.999999999999996)});
        Position position11 = new Position(517.3333333333334, 1792.0, 0.0);
        Polygone polygon12 = new Polygone(0, new Point[]{new Point( 9.000000000000004, -110.0), new Point( 217.0, 10.0), new Point(-23.000000000000018, 214.00000000000003), new Point( -203.00000000000003, -113.99999999999997)});
        Position position12 = new Position( 563.0, 1126.0, 0.0);
        Polygone polygon13 = new Polygone(0, new Point[]{new Point(201.0, -189.0), new Point( 181.0, 99.00000000000001), new Point( -31.0, 95.0), new Point( -351.00000000000006, -4.999999999999924)});
        Position position13 = new Position( 391.0, 917.0, 0.0);
        Polygone polygon14 = new Polygone(0, new Point[]{new Point(197.99999999999997, 350.0), new Point( -426.0, 45.99999999999994), new Point( -106.00000000000007, -474.0), new Point( 334.0, 77.99999999999999)});
        Position position14 = new Position( 1266.0, 546.0, 0.0);


        this.visibleEntities.add(new Reef(position, polygon));
        this.visibleEntities.add(new Reef(position1, polygon1));
        this.visibleEntities.add(new Reef(position2, polygon2));
        this.visibleEntities.add(new Reef(position3, polygon3));
        this.visibleEntities.add(new Reef(position4, polygon4));
        this.visibleEntities.add(new Reef(position5, polygon5));
        this.visibleEntities.add(new Reef(position6, polygon6));
        this.visibleEntities.add(new Reef(position7, polygon7));

        this.visibleEntities.add(new Reef(position8, polygon8));
        this.visibleEntities.add(new Reef(position9, polygon9));
        this.visibleEntities.add(new Reef(position10, polygon10));
        this.visibleEntities.add(new Reef(position11, polygon11));
        this.visibleEntities.add(new Reef(position12, polygon12));
        this.visibleEntities.add(new Reef(position13, polygon13));
        this.visibleEntities.add(new Reef(position14, polygon14));



    }

    @Override
    public void setShip() {
        this.ship = new Ship("ship", 800, new Position(120, 1728, 0), "ZECOMMIT", deck, entities, shape);
    }

    @Override
    public void setWind() {
        this.winds.add(new Wind(0, 25));
    }

    @Override
    public void setVisibleDistance(int distance){
        this.visibleDistance=distance;
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
        this.sailors.add(new Sailor(7, 2, 1, "Tom"));
        this.sailors.add(new Sailor(8, 2, 2, "Pouce"));

    }

    @Override
    public void setGoal() {
        this.goal = new Regatta(new ArrayList<>(checkpoints));
    }

    @Override
    public void setCheckpoints() {

        this.checkpoints = new ArrayList<>();

        this.checkpoints.add(new Checkpoint(new Position(480.0, 1488.0, 0), new Circle(150)));
        this.checkpoints.add(new Checkpoint(new Position(800.0, 856.0, 0), new Circle(150)));
        this.checkpoints.add(new Checkpoint(new Position(120.0, 1488.0, 0), new Circle(150)));

        this.allCheckpoints = new ArrayList<>(checkpoints);
    }

    @Override
    public void setDeck() {
        this.deck = new Deck(3, 5);
        this.deck.setSailors(sailors);
    }

    @Override
    public void setEntities() {

        this.entities = new ArrayList<>();
        this.entities.add(new Oar(1, 0));
        this.entities.add(new Oar(2, 0));
        this.entities.add(new Oar(3, 0));
        this.entities.add(new Oar(1, 2));
        this.entities.add(new Oar(2, 2));
        this.entities.add(new Oar(3, 2));
        this.entities.add(new Rudder(4, 1));
        this.entities.add(new Watch(0, 1));
        this.entities.add(new Sail(2, 1, false));

    }

    @Override
    public void setShape() {
        this.shape = new Polygone(0, new Point[]{new Point(2.5, -1.5000000000000002),new Point( 2.5, 1.5000000000000002),new Point( -2.5, 1.5000000000000002),new Point( -2.5, -1.5000000000000002)});
    }

}



