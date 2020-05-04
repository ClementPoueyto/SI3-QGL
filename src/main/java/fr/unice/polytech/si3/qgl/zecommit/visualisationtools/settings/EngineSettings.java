package fr.unice.polytech.si3.qgl.zecommit.visualisationtools.settings;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.unice.polytech.si3.qgl.zecommit.boat.Deck;
import fr.unice.polytech.si3.qgl.zecommit.boat.Position;
import fr.unice.polytech.si3.qgl.zecommit.boat.Ship;
import fr.unice.polytech.si3.qgl.zecommit.crew.Sailor;
import fr.unice.polytech.si3.qgl.zecommit.entite.*;
import fr.unice.polytech.si3.qgl.zecommit.goal.Goal;
import fr.unice.polytech.si3.qgl.zecommit.goal.Regatta;
import fr.unice.polytech.si3.qgl.zecommit.other.*;
import fr.unice.polytech.si3.qgl.zecommit.shape.Rectangle;
import fr.unice.polytech.si3.qgl.zecommit.shape.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Classe mère des engineSettings
 */
public abstract class EngineSettings implements EngineSettingsInterface{
    protected Goal goal;
    protected ArrayList<Checkpoint> allCheckpoints;
    protected ArrayList<Checkpoint> checkpoints;
    protected Ship ship;
    protected Deck deck;
    protected ArrayList<Entity> entities;
    protected Shape shape;
    protected ArrayList<Sailor> sailors;
    protected ArrayList<VisibleEntitie> visibleEntities;
    protected ObjectMapper oM;

    ///////////////////////////

    protected ArrayList<Sailor> leftSailors;
    protected ArrayList<Sailor> rightSailors;
    @JsonIgnore
    protected int visibleDistance =1000;
    static final int n = 100;
    protected int shipCount = 1;
    protected double rotation = 0;
    protected int nbSailUsed = 0;
    protected ArrayList<Oar> oarArrayList;
    protected ArrayList<Sail> sailArrayList;
    protected Rudder rudder;
    protected Watch watch;
    protected Wind wind;
    @JsonIgnore
    protected ArrayList<Wind> winds;
    @JsonIgnore
    protected Random random = new Random();

    @JsonIgnore
    ArrayList<Stream> streams;
    @JsonIgnore
    ArrayList<Reef> reefs;
    @JsonIgnore
    ArrayList<VisibleEntitie> visibles;

    @JsonIgnore
    public EngineSettings() {
        this.entities = new ArrayList<>();
        this.sailors = new ArrayList<>();
        this.oarArrayList = new ArrayList<>();
        this.sailArrayList = new ArrayList<>();
        this.winds = new ArrayList<>();
        this.streams = new ArrayList<>();
        this.reefs = new ArrayList<>();
        this.visibles = new ArrayList<>();
        this.oM = new ObjectMapper();

        this.rightSailors = new ArrayList<>();
        this.leftSailors = new ArrayList<>();
    }

    public void resetSettings() {
        setCheckpoints(new ArrayList<>());
        setGoal(new Regatta(new ArrayList<>()));
        setEntities(new ArrayList<>());
        setSailors(new ArrayList<>());
        setDeck(new Deck(0, 0));
        setShape(new Rectangle(0, 0, 0));
        setShip(new Ship("ship", 100, new Position(0, 0, 0), "ZECOMMIT", deck, entities, shape));
        setVisibleEntities(new ArrayList<>());
        //setWind(new Wind(0, 0));
    }


    public void initiateSettings() {
        setCheckpoints();
        setGoal();
        setEntities();
        setSailors();
        setDeck();
        setShape();
        setShip();
        setVisibleEntities();
        if(visibleEntities!=null)
            sortVisibleEntities();
        sortEntities();
        setWind();
    }


    public void setWind(Wind wind) {
        this.wind = wind;
    }


    public void setDeck(Deck deck) {
        this.deck = deck;
    }


    public void setShip(Ship ship) {
        this.ship = ship;
    }


    public void setRightSailors(ArrayList<Sailor> sailors) {
        this.rightSailors = sailors;
    }


    public void setLeftSailors(ArrayList<Sailor> sailors) {
        this.leftSailors = sailors;
    }


    public void setRotation(double rotation) {
        this.rotation = rotation;
    }


    public void setOarList(ArrayList<Oar> oars) {
        this.oarArrayList = oars;
    }


    public void setVisibleEntities(ArrayList<VisibleEntitie> visibles) {
        this.visibleEntities = visibles;
    }


    public void setSailors(ArrayList<Sailor> sailors) {
        this.sailors = sailors;
    }


    public void setCheckpoints(ArrayList<Checkpoint> checkpoints) {
        this.checkpoints = checkpoints;
    }


    public void setGoal(Goal goal) {
        this.goal = goal;
    }


    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }


    public void setShape(Shape shape) {
        this.shape = shape;
    }


    /**
     * ################################################ SETTINGS ################################################
     */



    public void setVisibleEntities() {
    }



    public void setShip() {
    }


    public void setWind() {

    }


    public void setSailors() {

    }


    public void setGoal() {
    }


    public void setCheckpoints() {

    }


    public void setDeck() {

    }

    public void setWatch(Watch watch){
        this.watch=watch;
    }


    public void setEntities() {


    }


    public void setShape() {
    }


    public void setNbSailUsed(int nbSailUsed) {
        this.nbSailUsed = nbSailUsed;
    }


    public void setRudder(Rudder rudder) {
        this.rudder = rudder;
    }


    public void setVisibleDistance(int distance){
        this.visibleDistance=distance;
    }



    public void sortEntities() {
        for (Entity entity : entities) {
            if (entity.getType().equals(EntityType.oar)) {
                this.oarArrayList.add((Oar) entity);
            }
            if (entity.getType().equals(EntityType.rudder)) {
                this.rudder = new Rudder(entity.getX(), entity.getY());
            }
            if (entity.getType().equals(EntityType.sail)) {
                this.sailArrayList.add((Sail) entity);
            }
            if (entity.getType().equals(EntityType.watch)) {
                this.watch=(Watch) entity;
            }
        }
    }



    public void sortVisibleEntities() {
        for (VisibleEntitie entity : visibleEntities) {
            if (entity.getType().equals(VisibleEntityType.stream)) {
                this.streams.add((Stream) entity);
            }
            if (entity.getType().equals(VisibleEntityType.ship)) {
            }
            if (entity.getType().equals(VisibleEntityType.reef)) {
                this.reefs.add((Reef) entity);
            }
        }
    }


    /**
     * ################################################ GETTERS ################################################
     */


    public Goal getGoal() {
        return this.goal;
    }

    @JsonIgnore

    public int getN() {
        return n;
    }

    /**
     * @return the checkpoints
     */
    @JsonIgnore

    public List<Checkpoint> getCheckpoints() {
        return checkpoints;
    }

    /**
     * @return the ship
     */

    public Ship getShip() {
        return ship;
    }

    /**
     * @return the deck
     */
    @JsonIgnore

    public Deck getDeck() {
        return deck;
    }

    /**
     * @return the entities
     */
    @JsonIgnore

    public List<Entity> getEntities() {
        return entities;
    }

    /**
     * @return the shape
     */
    @JsonIgnore

    public Shape getShape() {
        return shape;
    }


    public Watch getWatch(){return watch;}
    /**
     * @return the sailors
     */

    public List<Sailor> getSailors() {
        return sailors;
    }

    /**
     * @return the visibleEntities
     */

    public ArrayList<VisibleEntitie> getVisibleEntities() {
        return visibleEntities;
    }


    public double getRotation() {
        return rotation;
    }


    public Rudder getRudder() {
        return rudder;
    }


    public Wind getWind() {
        return wind;
    }


    public ObjectMapper getoM() {
        return oM;
    }


    public ArrayList<Reef> getReefs() {
        return reefs;
    }


    public Random getRandom() {
        return random;
    }


    public ArrayList<Sailor> getLeftSailors() {
        return leftSailors;
    }


    public ArrayList<Sailor> getRightSailors() {
        return rightSailors;
    }


    public ArrayList<Oar> getOarArrayList() {
        return oarArrayList;
    }


    public ArrayList<Sail> getSailArrayList() {
        return sailArrayList;
    }


    public ArrayList<Stream> getStreams() {
        return streams;
    }


    public ArrayList<VisibleEntitie> getVisibles() {
        return visibles;
    }


    public ArrayList<Wind> getWinds() {
        return winds;
    }


    public int getNbSailUsed() {
        return nbSailUsed;
    }


    public ArrayList<Checkpoint> getAllCheckpoints() {
        return allCheckpoints;
    }

    /**
     * @return the shipCount
     */

    public int getShipCount() {
        return shipCount;
    }


    public int getVisibleDistance(){
        return visibleDistance;
    }

}
