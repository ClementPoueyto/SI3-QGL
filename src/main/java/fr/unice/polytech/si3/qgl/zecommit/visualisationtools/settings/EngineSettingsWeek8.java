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
 * EngineSettiing du week8 : vent des globes
 */
public class EngineSettingsWeek8 extends EngineSettings {

    /*
     * ################################################ SETTINGS ################################################
     */

    @Override
    public void setVisibleEntities() {
        this.visibleEntities = new ArrayList<>();

        Polygone polygon = new Polygone(0, new Point[]{new Point(-155.0, -225.00000000000003), new Point( -230.0, -50.000000000000014), new Point( -5.0000000000000275, 150.0), new Point( 245.0, 175.0), new Point( 145.0, -50.00000000000001)});
        Position position = new Position(5405.0, 7125.0, 0.0);
        Polygone polygon0 = new Polygone(0, new Point[]{new Point(125.0, -25.0), new Point( 99.99999999999999, -225.0), new Point( -75.00000000000003, -225.0), new Point( -175.0 ,-25.00000000000004), new Point( -50.00000000000001, 200.0 ), new Point(74.99999999999997, 300.0)});
        Position position0 = new Position(8275.0, 5125.0 ,0.0);
        Polygone polygon1 = new Polygone(0, new Point[]{new Point( -249.99999999999997, -600.0), new Point( -950.0000000000001, -499.9999999999999 ), new Point(-850.0, 99.99999999999999), new Point( 2050.0000000000005, 1000.0)});
        Position position1 = new Position(6450.0, 9250.0 ,0.0);
        Polygone polygon2 = new Polygone(0, new Point[]{new Point( -543.75, -25.000000000000114), new Point( -418.75000000000006, 149.99999999999991), new Point( 356.25, 100.0), new Point( 606.2500000000001, -225.00000000000003)});
        Position position2 = new Position( 5843.75, 3475.0, 0.0);
        Polygone polygon3 = new Polygone(0, new Point[]{new Point( 91.66666666666653, -166.66666666666697), new Point( -133.33333333333348, 33.33333333333306), new Point( 41.6666666666665, 133.33333333333306)});
        Position position3 = new Position(  3408.3333333333335, 4416.666666666667, 0.0);
        Polygone polygon4 = new Polygone(0, new Point[]{new Point( -466.666666666667, -599.9999999999999), new Point( -916.6666666666669, -499.9999999999999), new Point( 1383.3333333333333, 1100.0)});
        Position position4 = new Position(  7116.666666666667, 9150.0, 0.0);
        Polygone polygon5 = new Polygone(0, new Point[]{new Point( -83.33333333333347, -166.6666666666665), new Point( 16.66666666666653, 183.33333333333348), new Point( 66.66666666666652 ,-16.666666666666515)});
        Position position5 = new Position(  3833.3333333333335 ,3716.6666666666665, 0.0);
        Polygone polygon6 = new Polygone(0, new Point[]{new Point( 660.0, -1430.0), new Point( 260.00000000000006, -1205.0 ), new Point(-790.0, 95.0 ), new Point(-990.0, 420.00000000000006 ), new Point(859.9999999999998, 2120.0)});
        Position position6 = new Position(  7640.0, 8130.0, 0.0);
        Polygone polygon7 = new Polygone(0, new Point[]{new Point( 1445.0, 270.0), new Point( 369.9999999999999, -830.0), new Point( -555.0 ,-579.9999999999999), new Point( -855.0, 370.00000000000006), new Point( -405.0000000000001, 770.0)});
        Position position7 = new Position(  6505.0, 6280.0, 0.0);
        Polygone polygon8 = new Polygone(0, new Point[]{new Point( 6.25000000000001, -268.75), new Point( -393.75, -168.75000000000003), new Point( -293.74999999999994, 431.25), new Point( 681.25, 6.250000000000001)});
        Position position8 = new Position(  2743.75 ,4918.75, 0.0);
        Polygone polygon9 = new Polygone(0, new Point[]{new Point( 168.75, 37.5), new Point( -106.25000000000004, -162.49999999999997), new Point( -106.25, 12.499999999999998), new Point( 43.75, 112.5)});
        Position position9 = new Position(  8706.25, 5037.5, 0.0);
        Polygone polygon10 = new Polygone(0, new Point[]{new Point( 37.5, -274.99999999999994 ), new Point(-212.5, 74.99999999999999), new Point( -62.50000000000003, 224.99999999999997 ), new Point(237.49999999999997, -24.999999999999996)});
        Position position10 = new Position(  3962.5, 3475.0, 0.0);
        Polygone polygon11 = new Polygone(0, new Point[]{new Point( 700.0, -262.49999999999994), new Point(750.0, -637.5), new Point( -1100.0, -137.49999999999991), new Point( -349.99999999999994, 1037.5000000000002)});
        Position position11 = new Position(  7200.0, 7187.5, 0.0);
        Polygone polygon12 = new Polygone(0, new Point[]{new Point( 393.75, -512.5), new Point( -331.24999999999994, -262.50000000000006), new Point( -156.25000000000003 ,337.5 ), new Point(93.75, 437.5)});
        Position position12 = new Position(  5556.25, 6212.5, 0.0);
        Polygone polygon13 = new Polygone(0, new Point[]{new Point( 16.666666666666966, 125.0), new Point( 116.66666666666696 ,-75.0 ), new Point(-133.33333333333303, -50.000000000000014)});
        Position position13 = new Position(  8133.333333333333, 3800.0, 0.0);
        Polygone polygon14 = new Polygone(0, new Point[]{new Point( -187.50000000000006, -525.0), new Point( -462.50000000000006, -574.9999999999999), new Point( -387.5, 75.00000000000006), new Point(  -87.50000000000001, 325.00000000000006), new Point(412.49999999999994, 525.0), new Point( 712.5, 175.0)});
        Position position14 = new Position(  2637.5, 5875.0, 0.0);
        Polygone polygon15 = new Polygone(0, new Point[]{new Point( -375.0, -333.3333333333333), new Point( -550.0000000000001 ,366.66666666666674), new Point( -450.00000000000006 ,516.6666666666666), new Point( 775.0, -133.33333333333326 ), new Point(424.99999999999994, -233.33333333333326), new Point( 175.0, -183.33333333333326)});
        Position position15 = new Position(  5225.0, 2033.3333333333333, 0.0);
        Polygone polygon16 = new Polygone(0, new Point[]{new Point( -245.0000000000001, 585.0), new Point( 5.000000000000012, 535.0000000000001), new Point( 204.99999999999997 ,-115.0), new Point( 205.00000000000003, -465.0), new Point( -170.00000000000006, -540.0)});
        Position position16 = new Position(  3595.0,5465.0, 0.0);
        Polygone polygon17 = new Polygone(0, new Point[]{new Point( -158.33333333333303, -208.33333333333303), new Point( -133.33333333333303 ,16.666666666666963), new Point( 291.66666666666697, 191.666666666667)});
        Position position17 = new Position(  5808.333333333333, 6858.333333333333 ,0.0);
        Polygone polygon18 = new Polygone(0, new Point[]{new Point( 316.66666666666697, 1212.5), new Point( 516.666666666667, 437.49999999999994), new Point( 316.66666666666697 ,-487.5 ), new Point(16.666666666666995, -412.5 ), new Point(-408.33333333333326 ,-862.4999999999999 ), new Point(-758.3333333333329, 112.49999999999984)});
        Position position18 = new Position(  7633.333333333333, 5337.5, 0.0);
        Polygone polygon19 = new Polygone(0, new Point[]{new Point( 124.99999999999999 ,-135.0), new Point( -299.99999999999994 ,-234.99999999999997 ), new Point(-400.00000000000006, 64.99999999999996 ), new Point(275.0 ,340.0 ), new Point(300.0, -35.00000000000001)});
        Position position19 = new Position(  3150.0, 4585.0, 0.0);
        Polygone polygon20 = new Polygone(0, new Point[]{new Point( -624.9999999999999 ,-91.6666666666671), new Point( 275.0, 608.333333333333), new Point( 350.0, -516.666666666667)});
        Position position20 = new Position(  3075.0, 5441.666666666667 ,0.0);
        Polygone polygon21 = new Polygone(0, new Point[]{new Point( -331.25, -512.5000000000001), new Point( -306.25000000000006, 187.5), new Point( 243.75000000000003, 337.5), new Point( 393.75 ,-12.5)});
        Position position21 = new Position(  5156.25 ,1512.5, 0.0);
        Polygone polygon22 = new Polygone(0, new Point[]{new Point( -583.333333333333, -266.66666666666686), new Point( 441.666666666667, 33.33333333333326 ), new Point(141.66666666666697, 233.33333333333326)});
        Position position22 = new Position(  5408.333333333333, 1266.6666666666667, 0.0);
        Polygone polygon23 = new Polygone(0, new Point[]{new Point( -91.66666666666609, -329.1666666666669), new Point( -141.66666666666606 ,-4.166666666666964), new Point( -141.66666666666606, 320.833333333333), new Point( 208.33333333333394, 245.833333333333), new Point( 108.33333333333394, -4.16666666666697), new Point( 58.33333333333393, -229.166666666667)});
        Position position23 = new Position(  8491.666666666666, 5429.166666666667, 0.0);
        Polygone polygon25 = new Polygone(0, new Point[]{new Point( 150.0, 50.00000000000001), new Point( -150.0, -75.00000000000003), new Point( 1.5308084989341915E-15, 25.0)});
        Position position25 = new Position(  3650.0, 4025.0 ,0.0);
        Polygone polygon26 = new Polygone(0, new Point[]{new Point( -521.4285714285716, -328.5714285714284), new Point( -1296.4285714285716, 321.4285714285715), new Point( -1096.4285714285716, 571.4285714285716), new Point( 3.5714285714284295, 571.4285714285716), new Point( 1153.5714285714284, 371.4285714285716 ), new Point(1053.5714285714284, -528.5714285714286), new Point( 703.5714285714284, -978.5714285714283)});
        Position position26 = new Position(  5296.428571428572, 2878.5714285714284, 0.0);
        Polygone polygon27 = new Polygone(0, new Point[]{new Point( -360.0000000000001, -1115.0), new Point( -409.99999999999994, -165.00000000000003), new Point( -210.00000000000017 ,3385.0), new Point( 990.0000000000001, -915.0000000000001), new Point( -10.00000000000011, -1190.0)});
        Position position27 = new Position(  8710.0, 6865.0, 0.0);
        Polygone polygon28 = new Polygone(0, new Point[]{new Point( 66.66666666666696, -75.00000000000001), new Point( -133.33333333333303, -25.000000000000014), new Point( 66.66666666666697, 100.0)});
        Position position28 = new Position(  7783.333333333333, 4400.0, 0.0);



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
        this.visibleEntities.add(new Reef(position10, polygon10));
        this.visibleEntities.add(new Reef(position11, polygon11));
        this.visibleEntities.add(new Reef(position12, polygon12));
        this.visibleEntities.add(new Reef(position13, polygon13));
        this.visibleEntities.add(new Reef(position14, polygon14));

        this.visibleEntities.add(new Reef(position15, polygon15));
        this.visibleEntities.add(new Reef(position16, polygon16));
        this.visibleEntities.add(new Reef(position17, polygon17));
        this.visibleEntities.add(new Reef(position18, polygon18));
        this.visibleEntities.add(new Reef(position19, polygon19));
        this.visibleEntities.add(new Reef(position20, polygon20));
        this.visibleEntities.add(new Reef(position21, polygon21));
        this.visibleEntities.add(new Reef(position22, polygon22));
        this.visibleEntities.add(new Reef(position23, polygon23));
        this.visibleEntities.add(new Reef(position25, polygon25));
        this.visibleEntities.add(new Reef(position26, polygon26));
        this.visibleEntities.add(new Reef(position27, polygon27));
        this.visibleEntities.add(new Reef(position28, polygon28));



        //STREAM
        Rectangle rect24 = new Rectangle(3000, 400,0);
        Position position24 = new Position(  5350.0 ,5200.0, -2.4);

        this.visibleEntities.add(new Stream(position24, rect24, 150));




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

    }

    @Override
    public void setGoal() {
        this.goal = new Regatta(new ArrayList<>(checkpoints));
    }

    @Override
    public void setCheckpoints() {

        this.checkpoints = new ArrayList<>();

        this.checkpoints.add(new Checkpoint(new Position(8500.0, 4950.0, 0), new Circle(100)));
        this.checkpoints.add(new Checkpoint(new Position(7000.0, 4350.0, 0), new Circle(100)));
        this.checkpoints.add(new Checkpoint(new Position(2250.0, 6400.0, 0), new Circle(100)));
        this.checkpoints.add(new Checkpoint(new Position(3350.0, 3850.0, 0), new Circle(100)));
        this.checkpoints.add(new Checkpoint(new Position(7925.0, 4050.0, 0), new Circle(100)));
        this.checkpoints.add(new Checkpoint(new Position(8500.0, 4950.0, 0), new Circle(100)));


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

}


