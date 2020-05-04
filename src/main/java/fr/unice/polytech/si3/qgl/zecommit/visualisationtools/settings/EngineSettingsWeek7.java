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
 * EngineSettiing du week7 : tour de ré
 */
public class EngineSettingsWeek7 extends EngineSettings{

    /*
     * ################################################ SETTINGS ################################################
     */

    @Override
    public void setVisibleEntities() {
        this.visibleEntities = new ArrayList<>();

        //TOUR DE RE
        Polygone polygon = new Polygone(0, new Point[]{new Point(-135.99999999999997, -596.0), new Point(163.99999999999997, -336.0), new Point(324.0, 64.0), new Point(284.00000000000006, 704.0), new Point(-636.0, 164.00000000000006)});
        Position position = new Position(1876.0, 2096.0, 0.0);
        Polygone polygon0 = new Polygone(0, new Point[]{new Point(285.00000000000006, -435.00000000000006), new Point(185.0, -35.0), new Point(-255.00000000000006, 464.9999999999999), new Point(-215.0, 5.00000000000002)});
        Position position0 = new Position(1015.0, 835.0, 0.0);
        Polygone polygon1 = new Polygone(0, new Point[]{new Point(-454.99999999999994, -345.0), new Point(145.0, -105.0), new Point(225.0, 95.0), new Point(85.00000000000003, 355.0)});
        Position position1 = new Position(1655.0, 1145.0, 0.0);
        Polygone polygon2 = new Polygone(0, new Point[]{new Point(27.9999999999996, -748.0000000000001), new Point(568.0, -48.0), new Point(67.99999999999994, 711.9999999999999), new Point(-251.99999999999991, 332.00000000000006), new Point(-411.99999999999994, -248.00000000000006)});
        Position position2 = new Position(1172.0, 1548.0, 0.0);
        Polygone polygon3 = new Polygone(0, new Point[]{new Point(63.99999999999998, -224.0), new Point(564.0, 576.0), new Point(-96.0, 276.00000000000006), new Point(-295.99999999999994, -224.00000000000006), new Point(-236.00000000000014, -403.9999999999999)});
        Position position3 = new Position(2196.0, 4684.0, 0.0);
        Polygone polygon4 = new Polygone(0, new Point[]{new Point(-283.99999999999994, -440.00000000000006), new Point(336.0, 140.0), new Point(376.00000000000006, 460.0), new Point(36.0, 320.0), new Point(-463.9999999999999, -480.00000000000017)});
        Position position4 = new Position(2724.0, 4940.0, 0.0);
        Polygone polygon5 = new Polygone(0, new Point[]{new Point(-583.3333333333335, 96.66666666666704), new Point(-223.33333333333348, -643.333333333333), new Point(16.66666666666649, -283.33333333333303), new Point(376.6666666666665, -43.33333333333303), new Point(376.6666666666665, 196.66666666666697), new Point(36.666666666666565, 676.666666666667)});
        Position position5 = new Position(3023.3333333333335, 4403.333333333333, 0.0);
        Polygone polygon6 = new Polygone(0, new Point[]{new Point(210.0, -265.0), new Point(330.00000000000006, 335.0), new Point(170.00000000000006, 734.9999999999999), new Point(-710.0000000000001, -805.0)});
        Position position6 = new Position(1950.0, 3065.0, 0.0);
        Polygone polygon7 = new Polygone(0, new Point[]{new Point(-40.00000000000003, -375.0), new Point(140.0, -15.0), new Point(100.00000000000001, 285.0), new Point(-200.00000000000003, 104.99999999999999)});
        Position position7 = new Position(2160.0, 4175.0, 0.0);
        Polygone polygon8 = new Polygone(0, new Point[]{new Point(15.000000000000028, -390.0), new Point(95.0, 10.0), new Point(34.99999999999999, 369.99999999999994), new Point(-144.99999999999997, 9.999999999999986)});
        Position position8 = new Position(2265.0, 3790.0, 0.0);
        Polygone polygon9 = new Polygone(0, new Point[]{new Point(-112.00000000000004, -207.99999999999997), new Point(168.0, -408.0), new Point(148.0, 352.0), new Point(-52.0, 272.0), new Point(-152.0, -7.999999999999985)});
        Position position9 = new Position(2592.0, 3408.0, 0.0);

        this.visibleEntities.add(new Reef(position, polygon));
        this.visibleEntities.add(new Reef(position0, polygon0));
        this.visibleEntities.add(new Reef(position1, polygon1));
        this.visibleEntities.add(new Reef(position2, polygon2));
        this.visibleEntities.add(new Reef(position3, polygon3));
        this.visibleEntities.add(new Reef(position4, polygon4));
        this.visibleEntities.add(new Reef(position5, polygon5));
        this.visibleEntities.add(new Reef(position6, polygon6));
        this.visibleEntities.add(new Reef(position7, polygon7));
        this.visibleEntities.add(new Reef(position8, polygon8));
        this.visibleEntities.add(new Reef(position9, polygon9));

        //STREAM
        Polygone polygon10 = new Polygone(0, new Point[]{new Point(700.0, -49.99999999999999), new Point(700.0, 49.99999999999999), new Point(-700.0, 50.00000000000004), new Point(-700.0, -50.00000000000004)});
        Position position10 = new Position(1000.0, 1000.0, 0.78539816339);
        this.visibleEntities.add(new Stream(position10, polygon10, 150));


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

        this.checkpoints.add(new Checkpoint(new Position(300.0, 1800.0, 0), new Circle(150)));
        this.checkpoints.add(new Checkpoint(new Position(1900.0, 3800.0, 0), new Circle(150)));
        this.checkpoints.add(new Checkpoint(new Position(2000.0, 5240.0, 0), new Circle(150)));
        this.checkpoints.add(new Checkpoint(new Position(3600.0, 5160.0, 0), new Circle(150)));
        this.checkpoints.add(new Checkpoint(new Position(3300.0, 3500.0, 0), new Circle(150)));
        this.checkpoints.add(new Checkpoint(new Position(2400.0, 2000.0, 0), new Circle(150)));
        this.checkpoints.add(new Checkpoint(new Position(1800.0, 360.0, 0), new Circle(150)));
        this.checkpoints.add(new Checkpoint(new Position(360.0, 320.0, 0), new Circle(150)));


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
