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
public class EngineSettingsWeek11 extends EngineSettings {

    /*
     * ################################################ SETTINGS ################################################
     */

    @Override
    public void setVisibleEntities() {
        this.visibleEntities = new ArrayList<>();

        Position position4 = new Position(4192.6182237600915, 2376.0092272203005, 0);
        Polygone shape4 = new Polygone(0, new Point[]{new Point(4400, 0), new Point(3000, 2700), new Point(-3000, 3250), new Point(-4500, -150), new Point(-3000,-3000), new Point(3000,-3200)});

        Position position0 = new Position(3350.6343713956185, -865.0519031141873, 0);
        Rectangle shape0 = new Rectangle(350, 50, 0);

        Position position1 = new Position(4036.9088811995425, -893.8869665513254, 0);
        Rectangle shape1 = new Rectangle(350, 50, 0);

        Position position2 = new Position(3401.095732410614, -1060.4094579008072, 0);
        Rectangle shape2 = new Rectangle(50, 150, 0);

        Position position3 = new Position(3886.9665513264113, -1071.222606689735, 0);
        Rectangle shape3 = new Rectangle(50, 350, 0);

        Position positionStream = new Position(5273.93310265283, 5654.555940023063, 3.0543261909900763);
        Rectangle shapeStream =  new Rectangle(500, 5000, 0);

        Position positionStream2 = new Position(8503.460207612477, 671.8569780853505, 1.2042771838760873);
        Rectangle shapeStream2 =  new Rectangle(750, 6500, 0);

        Position positionStream3 = new Position(-331.60322952710067, 741.0611303344853, 5.183627878423159);
        Rectangle shapeStream3 =  new Rectangle(1300, 6000, 0);

        Position positionStream4 = new Position(3621.6839677047265, -1251.4417531718555, 4.537856055185257);
        Rectangle shapeStream4 =  new Rectangle(50, 160, 0);

        this.visibleEntities.add(new Reef(position1, shape1));
        this.visibleEntities.add(new Reef(position2, shape2));
        this.visibleEntities.add(new Reef(position3, shape3));
        this.visibleEntities.add(new Reef(position4, shape4));
        this.visibleEntities.add(new Reef(position0, shape0));

        this.visibleEntities.add(new Stream(positionStream, shapeStream, 50));
        this.visibleEntities.add(new Stream(positionStream2, shapeStream2, 30));
        this.visibleEntities.add(new Stream(positionStream3, shapeStream3, 80));
        this.visibleEntities.add(new Stream(positionStream4, shapeStream4, 10));


    }

    @Override
    public void setShip() {

        Position depart = new Position(3460.207612456746, -765.5709342560549, 4.799655442984406);
        //Position depart = new Position(3875.432525951556, -803.0565167243366, 3.9444441095071845);
        //Position depart = new Position(3657.187139561704, -785.7554786620523, 4.729842272904633);

        this.ship = new Ship("ship", 3000, depart , "ZECOMMIT", deck, entities, shape);
    }

    @Override
    public void setWind() {
        this.winds.add(new Wind(0, 65));

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

        this.checkpoints.add(new Checkpoint(new Position(3556.2644175317155, -1430.219146482121, 0), new Circle(100)));
        this.checkpoints.add(new Checkpoint(new Position(2290.4051326412828, 6279.555940023068, 0), new Circle(500)));
        this.checkpoints.add(new Checkpoint(new Position(5208.513552479799, -1990.3402537485556, 0), new Circle(350)));
        this.checkpoints.add(new Checkpoint(new Position(3590.866493656281, -1063.2929642445185, 0), new Circle(100)));



        this.allCheckpoints = new ArrayList<>(checkpoints);
    }

    @Override
    public void setDeck() {
        this.deck = new Deck(5, 12);
        this.deck.setSailors(sailors);
    }

    @Override
    public void setEntities() {


        this.entities = new ArrayList<>();
        this.entities.add(new Oar(9, 0));
        this.entities.add(new Oar(8, 0));
        this.entities.add(new Oar(7, 0));
        this.entities.add(new Oar(6, 0));
        this.entities.add(new Oar(5, 0));
        this.entities.add(new Oar(4, 0));
        this.entities.add(new Oar(3, 0));
        this.entities.add(new Oar(2, 0));

        this.entities.add(new Oar(9, 4));
        this.entities.add(new Oar(8, 4));
        this.entities.add(new Oar(7, 4));
        this.entities.add(new Oar(6, 4));
        this.entities.add(new Oar(5, 4));
        this.entities.add(new Oar(4, 4));
        this.entities.add(new Oar(3, 4));
        this.entities.add(new Oar(2, 4));

        this.entities.add(new Rudder(11, 2));
        this.entities.add(new Watch(0, 2));
        this.entities.add(new Sail(7, 2, false));

    }

    @Override
    public void setShape() {
        this.shape = new Polygone(0, new Point[]{new Point(6, -2.5), new Point(-6, 2.5), new Point(-6, 2.5), new Point(-6, -2.5)});
    }


}
