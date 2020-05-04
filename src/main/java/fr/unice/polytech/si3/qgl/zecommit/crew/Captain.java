package fr.unice.polytech.si3.qgl.zecommit.crew;

import fr.unice.polytech.si3.qgl.zecommit.Game;
import fr.unice.polytech.si3.qgl.zecommit.Logs;
import fr.unice.polytech.si3.qgl.zecommit.boat.Deck;
import fr.unice.polytech.si3.qgl.zecommit.boat.Position;
import fr.unice.polytech.si3.qgl.zecommit.boat.Ship;
import fr.unice.polytech.si3.qgl.zecommit.entite.Entity;
import fr.unice.polytech.si3.qgl.zecommit.entite.Oar;
import fr.unice.polytech.si3.qgl.zecommit.entite.Rudder;
import fr.unice.polytech.si3.qgl.zecommit.entite.Sail;
import fr.unice.polytech.si3.qgl.zecommit.entite.Watch;
import fr.unice.polytech.si3.qgl.zecommit.goal.Goal;
import fr.unice.polytech.si3.qgl.zecommit.goal.Regatta;
import fr.unice.polytech.si3.qgl.zecommit.maths.*;
import fr.unice.polytech.si3.qgl.zecommit.other.*;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.stream.Collectors;

/**
 * Classe désignant le capitaine du navire
 */
public class Captain implements CaptainInterface {

    private Ship ship;
    private Regatta goal;
    private OrientationTable orientationTable;
    private Wind wind;
    private List<VisibleEntitie> visibleEntities;
    private int chosenAngle;

    public Captain(Game game) {
        this.ship = game.getShip();
        this.goal = (Regatta) game.getGoal();
        this.orientationTable = new OrientationTable(ship.getDeck().getOars().size());
        this.wind = game.getWind();
        this.visibleEntities = game.getVisibleEntities();
    }

    @Override
    public void attributeEntitiesToSailors() {
        List<Sailor> sailors = new ArrayList<>(ship.getDeckSailors());
        List<Entity> oars = new ArrayList<>(ship.getDeckOars());
        List<Sail> sails = new ArrayList<>(ship.getDeckSails());
        Optional<Rudder> rudder = ship.getDeckRudder();
        sailors.sort(Comparator.comparingInt(a -> a.distanceToNearestEntity(oars)));
        if (sailors.size() > 4 && rudder.isPresent()) {
            sailors.remove(sailors.size() - 1).setOnEntity(rudder.get());
        }
        int i = 0;
        while(i < oars.size()) {
            Oar oar = (Oar) oars.get(i);
            Optional<Sailor> closestSailor = sailors.stream().min(Comparator.comparingInt(a -> a.distanceToEntity(oar)));
            if (closestSailor.isPresent() && !closestSailor.get().hasEntity()) {
                closestSailor.get().setOnEntity(oar);
                oars.remove(oar);
                sailors.remove(closestSailor.get());
                i--;
            }
            i++;
        }
        if (!sailors.isEmpty() && !sails.isEmpty()) {
            for (Sailor sailor : sailors) {
                Optional<Sail> sail = sails.stream().min(Comparator.comparingInt(sailor::distanceToEntity));
                if (sail.isPresent() && !sail.get().hasSailorOn()) {
                    sailor.setOnEntity(sail.get());
                    sails.remove(sail.get());
                }
            }
        }
        attributeWatchToSailors(sailors);
    }

    public void attributeWatchToSailors(List<Sailor> sailors) {
        Optional<Sailor> leftSailor = sailors.stream().filter(Sailor::hasEntity).findAny();
        Optional<Watch> watch = ship.getDeckWatch();
        if(leftSailor.isPresent() && watch.isPresent() && !watch.get().hasSailorOn()) {
            leftSailor.get().setOnEntity(watch.get());
        }
    }

    @Override
    public List<Sailor> doMoveSailors() {
        if (!ship.getDeck().sailorsAreOnTheirEntity())
            return ship.getDeckSailors();
        return new ArrayList<>();
    }

    @Override
    public List<Sailor> doActivateOars() {
        if (ship.isInCheckpoint(goal.getFirstCheckpoint()) && goal.getCheckpoints().size() > 1) {
            goal.validateCommonCheckpoint();
            Logs.add("Checkpoint done");
        }
        Road road = new Road(ship.getPosition(), goal.getFirstCheckpoint().getPosition());
        chosenAngle = road.findClosestPossibleAngle(ship.getDeckOars().size(), ship.getDeck().canUseRudder());
        return decisionOrientation(road);
    }

    @Override
    public SimpleEntry<Sailor, Double> doTurn() {
        Road road = new Road(ship.getPosition(), goal.getFirstCheckpoint().getPosition());
        Optional<Rudder> res = ship.getDeckRudder();
        double angle = road.orientationToGoal()
                - orientationTable.getAngleTable().get(road.findClosestPossibleAngle(ship.getDeck().getOars().size(), ship.getDeck().canUseRudder()));

        if (res.isPresent() && ship.getDeck().canUseRudder()) {
            return new SimpleEntry<>(res.get().getSailorOn(), angle);
        }

        return null;
    }

    @Override
    public List<Sailor> doLiftSail() {
        if (upSail()) {
            return ship.getDeckSails().stream().filter(sail -> !sail.isOpenned() && sail.hasSailorOn() && sail.getSailorOn().isOnEntity()).map(Sail::getSailorOn).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    @Override
    public List<Sailor> doLowerSail() {
        if (!upSail()) {
            return ship.getDeckSails().stream().filter(sail -> sail.isOpenned() && sail.hasSailorOn() && sail.getSailorOn().isOnEntity()).map(Sail::getSailorOn).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    @Override
    public Sailor doUseWatch() {
        Optional<Watch> watch = ship.getDeckWatch();
        if(watch.isPresent() && watch.get().hasSailorOn() && watch.get().getSailorOn().isOnEntity()){
            return watch.get().getSailorOn();
        }
        return null;
    }

    @Override
    public boolean pursueGame() {
        goal.createIntermediateCheckpoint(ship, getReefs());
        return !(ship.isInCheckpoint(goal.getCheckpoints().get(goal.getCheckpoints().size() - 1))
                && goal.getCheckpoints().size() == 1);
    }

    /**
     * Effectue l'ordre d'activation des marins aux rames et au gouvernail
     *
     * @param compo la compo choisie
     * @return la liste des marins
     */
    public List<Sailor> activateSailors(Compo compo) {
        ArrayList<Sailor> usedSailors = new ArrayList<>();
        // Activation des marins de gauche
        int l = 0;
        while (l < compo.getSailorsLeft()) {
            usedSailors.add(ship.getDeck().leftSailors().get(l));
            l++;
        }

        // Activation des marins de droite
        int r = 0;
        while (r < compo.getSailorsRight()) {
            usedSailors.add(ship.getDeck().rightSailors().get(r));
            r++;
        }
        return usedSailors;
    }

    public List<Sailor> decisionOrientation(Road road) {

        boolean isNear = road.distanceToGoal() < (165 - goal.getFirstCheckpoint().getCircleRadius());
        List<Sailor> rightSailors = ship.getDeck().rightSailors();
        List<Sailor> leftSailors = ship.getDeck().leftSailors();

        int nbSailorsRight = rightSailors.size();
        int nbSailorsLeft = leftSailors.size();

        if (!isNear) {// si le bateau est loin du checkpoint
            Compo compo = orientationTable.getGoodCompo(orientationTable.getLastCompo(chosenAngle), nbSailorsRight, nbSailorsLeft);
            recalculateChosenAngle(compo.getSailorsLeft(), compo.getSailorsRight());
            return activateSailors(orientationTable.getGoodCompo(orientationTable.getLastCompo(chosenAngle),
                    nbSailorsRight, nbSailorsLeft));// on choisit la compo permettant d'aller le plus vite

        } else {
            if (isInCounterStream()) {
                Compo compo = orientationTable.getGoodCompo(orientationTable.getLastCompo(chosenAngle), nbSailorsRight, nbSailorsLeft);
                recalculateChosenAngle(compo.getSailorsLeft(), compo.getSailorsRight());
                return activateSailors(orientationTable.getGoodCompo(orientationTable.getLastCompo(chosenAngle),
                        nbSailorsRight, nbSailorsLeft));// on choisit la compo permettant d'aller le plus vite
            } else {
                Compo compo = orientationTable.getGoodCompo(orientationTable.getCompo(chosenAngle, 0), nbSailorsRight, nbSailorsLeft);
                recalculateChosenAngle(compo.getSailorsLeft(), compo.getSailorsRight());
                return activateSailors(orientationTable.getGoodCompo(orientationTable.getCompo(chosenAngle, 0),
                        nbSailorsRight, nbSailorsLeft));// on choisit la compo permettant d'aller le plus lentement
            }

        }

    }

    private void recalculateChosenAngle(int leftSailorsSize, int rightSailorsSize) {
        Predictions predictions = new Predictions(leftSailorsSize, rightSailorsSize, ship, visibleEntities, chosenAngle, wind, upSail());
        if (predictions.checkCollision()) {
            Logs.add("Votre Capitaine a detecté un iceberg...");

            Position nextPosition = predictions.predictFinalPosition(ship.getPosition(), 1);
            List<Position> route = Calculs.subdiviseRoute(ship.getPosition(), nextPosition);
            if (Calculs.checkCollision(getReefs(), route)) {//on regarde si un récif est sur notre itinéraire en ligne droite vers la prochaine position
                Logs.add("On frôle le récif capitaine !");


            }
        }
    }

    /**
     * Méthode indiquant quand activer la voile
     *
     * @return boolean true pour ouvrir la voile
     */
    public boolean upSail() {
        Road road = new Road(ship.getPosition(), goal.getFirstCheckpoint().getPosition());
        List<Sail> activeSails = ship.getDeckSails().stream().filter(sail -> sail.hasSailorOn() && sail.getSailorOn().isOnEntity()).collect(Collectors.toList());
        return (wind != null
                && Math.abs(ship.getPosition().getOrientation() - wind.getOrientation()) >= 0
                && Math.abs(ship.getPosition().getOrientation() - wind.getOrientation()) < Math.PI / 2)
                && road.distanceToGoal() > (165 + wind.getStrength() * activeSails.size());
    }



    /**
     * Méthode indiquant quand le bateau est à contre courant
     *
     * @return boolean true si on est a contre courant
     */
    public boolean isInCounterStream() {
        boolean res = false;
        if(visibleEntities!=null) {
            for (VisibleEntitie visibleEntitie : visibleEntities)
                if (visibleEntitie.getType().equals(VisibleEntityType.stream)) {
                    Stream stream = (Stream) visibleEntitie;
                    Collision collision = new Collision(stream.getShape(), stream.getPosition(), ship.getPosition());
                    if (collision.collide()
                            && Math.abs(ship.getPosition().getOrientation() + ship.getShape().getShapeOrientation() - stream.getShape().getShapeOrientation()) < 0
                            && Math.abs(ship.getPosition().getOrientation() + ship.getShape().getShapeOrientation() - stream.getShape().getShapeOrientation()) >= Math.PI / 4)
                        res = true;
                }
        }
        return res;
    }



    ////////////////////// GETTER ////////////////////////////////////////////

    public Deck getDeck() {
        return this.ship.getDeck();
    }

    public Goal getGoal() {
        return this.goal;
    }

    /**
     * @return the ship
     */
    public Ship getShip() {
        return ship;
    }

    public OrientationTable getOrientationTable() {
        return orientationTable;
    }

    public List<Reef> getReefs() {
        List<Reef> reefs = new ArrayList<>();
        if(visibleEntities!=null) {
            for (VisibleEntitie visibleEntitie : visibleEntities)
                if (visibleEntitie.getType().equals(VisibleEntityType.reef))
                    reefs.add((Reef) visibleEntitie);
        }
        return reefs;
    }

    /**
     * @param ship the ship to set
     */
    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public void setVisibleEntities(List<VisibleEntitie> visibleEntities) {
        this.visibleEntities = visibleEntities;
    }

}
