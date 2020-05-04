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
 * EngineSettiing du week12 : Iles lerins
 */
public class EngineSettingsWeek12 extends EngineSettings {

    /*
     * ################################################ SETTINGS ################################################
     */

    @Override
    public void setVisibleEntities() {
        this.visibleEntities = new ArrayList<>();

        Position position10 = new Position(11544.980443285524, -6132.812500000002, 0);
        Polygone shape10 = new Polygone(0.5934119456780721, new Point[]{new Point(2500, -3000), new Point(2500, 3000), new Point(-2500, 3000), new Point(-2500, -3000), new Point(-2500, -3000)});

        Position position11 = new Position(4263.363754889176, 3027.343749999999, 0);
        Polygone shape11 = new Polygone(0, new Point[]{new Point(186, 236), new Point(132, 670), new Point(-5, 689), new Point(-115, 560), new Point(-114, -632), new Point(-35, -724), new Point(40, -710), new Point(145, -450)});

        Position position4 = new Position(9282.92046936116, 10664.062500000007, 5.707226654021458);
        Rectangle shape4 = new Rectangle(1200, 500, 0);
        Position position5 = new Position(8943.937418513695, 9882.812500000011, 0);
        Rectangle shape5 = new Rectangle(150, 350, 0);
        Position position6 = new Position(14954.36766623208, 10625.000000000004, 0.5585053606381855);
        Rectangle shape6 = new Rectangle(3000, 6500, 0);
        Position position7 = new Position(11408.083441981737, 4270.833333333335, 4.258603374866164);
        Rectangle shape7 = new Rectangle(3000, 4500, 0);
        Position position8 = new Position(11773.142112125166, 260.41666666666475, 5.078908123303498);
        Rectangle shape8 = new Rectangle(4000, 5000, 0);
        Position position9 = new Position(9139.504563233377, 2304.6875000000023, 0.7853981633974483);
        Rectangle shape9 = new Rectangle(1000, 1000, 0);
        Position position0 = new Position(5867.014341590614, 3138.020833333336, 1.6406094968746698);
        Rectangle shape0 = new Rectangle(600, 3200, 0);
        Position position1 = new Position(13233.37679269882, 8020.833333333332, 6.126105674500097);
        Rectangle shape1 = new Rectangle(4000, 4000, 0);
        Position position2 = new Position(10469.361147327245, 10000.000000000002, 0);
        Rectangle shape2 = new Rectangle(1300, 2500, 0);
        Position position3 = new Position(9517.601043024764, -6.217248937900877e-13, 5.916666164260777);
        Rectangle shape3 = new Rectangle(150, 500, 0);


        //this.visibleEntities.add(new Reef(new Position(12487.123113118287 , -535.5330132438439, 0), new Circle(10)));
        //this.visibleEntities.add(new Reef(new Position(6907.726952070782 , 2202.3949924105227 , 0), new Circle(10)));

        this.visibleEntities.add(new Reef(position0, shape0));
        this.visibleEntities.add(new Reef(position1, shape1));
        this.visibleEntities.add(new Reef(position2, shape2));
        this.visibleEntities.add(new Reef(position3, shape3));
        this.visibleEntities.add(new Reef(position4, shape4));
        this.visibleEntities.add(new Reef(position5, shape5));
        this.visibleEntities.add(new Reef(position6, shape6));
        this.visibleEntities.add(new Reef(position7, shape7));
        this.visibleEntities.add(new Reef(position8, shape8));
        this.visibleEntities.add(new Reef(position9, shape9));
        this.visibleEntities.add(new Reef(position10, shape10));
        this.visibleEntities.add(new Reef(position11, shape11));


    }

    @Override
    public void setShip() {


        //Position depart = new Position(9380.704041721, 136.7187500000056, 3.141592653589793);
        //Position depart = new Position(9452.411994784887, 410.15625000000546, 3.1764992386296798);
        //Position depart = new Position(9465.449804432852, 488.28125000000523, 3.12413936106985);
        Position depart = new Position(9400.26075619297, 227.8645833333388, 3.141592653589793);
        //Position depart = new Position(9426.336375488936, 335.2864583333386, 3.141592653589793);


        this.ship = new Ship("ship", 900, depart, "ZECOMMIT", deck, entities, shape);
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
        this.sailors.add(new Sailor(3, 1, 0, "pierre"));
        this.sailors.add(new Sailor(4, 1, 1, "Vincent"));
        this.sailors.add(new Sailor(5, 1, 2, "Joris"));
        this.sailors.add(new Sailor(6, 2, 0, "jean"));
        this.sailors.add(new Sailor(7, 2, 1, "jean"));
        this.sailors.add(new Sailor(8, 2, 2, "jean"));
        this.sailors.add(new Sailor(9, 3, 0, "jean"));
        this.sailors.add(new Sailor(10, 3, 1, "jean"));
        this.sailors.add(new Sailor(11, 3, 2, "jean"));
        this.sailors.add(new Sailor(12, 4, 0, "jean"));


    }

    @Override
    public void setGoal() {
        this.goal = new Regatta(new ArrayList<>(checkpoints));
    }

    @Override
    public void setCheckpoints() {

        this.checkpoints = new ArrayList<>();
        //this.checkpoints.add(new Checkpoint(new Position(7000, 2929.6875, 0), new Circle(350)));

        this.checkpoints.add(new Checkpoint(new Position(16003.911342894391, 13684.895833333341, 0), new Circle(300)));
        this.checkpoints.add(new Checkpoint(new Position(8689.700130378087, 10117.1875, 0), new Circle(150)));
        this.checkpoints.add(new Checkpoint(new Position(4973.924380704037, 2929.6875, 0), new Circle(350)));



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

        this.entities.add(new Oar(1, 2));
        this.entities.add(new Oar(2, 2));
        this.entities.add(new Oar(3, 2));
        this.entities.add(new Oar(4, 2));
        this.entities.add(new Oar(1, 0));
        this.entities.add(new Oar(2, 0));
        this.entities.add(new Oar(3, 0));
        this.entities.add(new Oar(4, 0));
        this.entities.add(new Oar(5, 2));
        this.entities.add(new Oar(5, 4));

        this.entities.add(new Rudder(5, 1));
        this.entities.add(new Watch(0, 1));
        this.entities.add(new Sail(3, 1, false));

    }

    @Override
    public void setShape() {
        this.shape = new Rectangle(3,6,0);
    }


}
