package fr.unice.polytech.si3.qgl.zecommit.visualisationtools.settings;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.unice.polytech.si3.qgl.zecommit.boat.Deck;
import fr.unice.polytech.si3.qgl.zecommit.boat.Ship;
import fr.unice.polytech.si3.qgl.zecommit.crew.Sailor;
import fr.unice.polytech.si3.qgl.zecommit.entite.*;
import fr.unice.polytech.si3.qgl.zecommit.goal.Goal;
import fr.unice.polytech.si3.qgl.zecommit.other.*;
import fr.unice.polytech.si3.qgl.zecommit.shape.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Interface des engineSettings
 */
public interface EngineSettingsInterface {

    void resetSettings();

     void initiateSettings();

     void setWind(Wind wind);

     void setDeck(Deck deck);

     void setShip(Ship ship);

     void setWatch(Watch watch);

     void setRightSailors(ArrayList<Sailor> sailors);

     void setLeftSailors(ArrayList<Sailor> sailors);

     void setRotation(double rotation);

     void setOarList(ArrayList<Oar> oars);

     void setVisibleEntities(ArrayList<VisibleEntitie> visibles);

     void setSailors(ArrayList<Sailor> sailors);

     void setCheckpoints(ArrayList<Checkpoint> checkpoints);

     void setGoal(Goal goal);

     void setEntities(ArrayList<Entity> entities);

     void setShape(Shape shape);


    /**
     * ################################################ SETTINGS ################################################
     */


     void setVisibleEntities();


     void setShip();

     void setWind();

     void setSailors();

     void setGoal();

     void setCheckpoints();

     void setDeck();

     void setEntities();

     void setShape();

     void setNbSailUsed(int nbSailUsed);

     void setRudder(Rudder rudder);

     void sortEntities();

     void sortVisibleEntities();

     void setVisibleDistance(int distance);


    /*
     * ################################################ GETTERS ################################################
     */

     Goal getGoal();

    @JsonIgnore
     int getN();

    /**
     * @return the checkpoints
     */
    @JsonIgnore
     List<Checkpoint> getCheckpoints();

    /**
     * @return the ship
     */
     Ship getShip();

    /**
     * @return the deck
     */
    @JsonIgnore
     Deck getDeck();

    /**
     * @return the entities
     */
    @JsonIgnore
     List<Entity> getEntities();

    /**
     * @return the watch
     */
    @JsonIgnore
    Watch getWatch();

    /**
     * @return the shape
     */
    @JsonIgnore
     Shape getShape();

    /**
     * @return the sailors
     */
     List<Sailor> getSailors();

    /**
     * @return the visibleEntities
     */
     ArrayList<VisibleEntitie> getVisibleEntities();

     double getRotation();

     Rudder getRudder();

     Wind getWind();

     ObjectMapper getoM();

     ArrayList<Reef> getReefs();

     Random getRandom();

     ArrayList<Sailor> getLeftSailors();

     ArrayList<Sailor> getRightSailors();

     ArrayList<Oar> getOarArrayList();

     ArrayList<Sail> getSailArrayList();

     ArrayList<Stream> getStreams();

     ArrayList<VisibleEntitie> getVisibles();

     ArrayList<Wind> getWinds();

     int getNbSailUsed();

     ArrayList<Checkpoint> getAllCheckpoints();

    /**
     * @return the shipCount
     */
     int getShipCount();

     int getVisibleDistance();

}
