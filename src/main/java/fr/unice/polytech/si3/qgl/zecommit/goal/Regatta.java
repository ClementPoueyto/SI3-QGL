package fr.unice.polytech.si3.qgl.zecommit.goal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.unice.polytech.si3.qgl.zecommit.Logs;
import fr.unice.polytech.si3.qgl.zecommit.boat.Position;
import fr.unice.polytech.si3.qgl.zecommit.boat.Ship;
import fr.unice.polytech.si3.qgl.zecommit.maths.Calculs;
import fr.unice.polytech.si3.qgl.zecommit.other.Checkpoint;
import fr.unice.polytech.si3.qgl.zecommit.other.Reef;
import fr.unice.polytech.si3.qgl.zecommit.shape.Circle;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe correspondant au mode de jeu regatta
 */
public class Regatta extends Goal {

    private List<Checkpoint> checkpoints;

    public Regatta(List<Checkpoint> checkpoints) {
        super("REGATTA");
        this.checkpoints = checkpoints;
        setRegatta(true);
    }

    @JsonIgnore
    public void validateCommonCheckpoint(){
        checkpoints.remove(0);
    }

    @JsonIgnore
    public double getCheckpointRadius(){
        return checkpoints.get(0).getCircleRadius();
    }

    /**
     * Créer et choisit des points de déviation en plaçant des CP intermédiaires
     */
    public void createIntermediateCheckpoint(Ship ship, List<Reef> reefs){
        if (getFirstCheckpoint().isFake()) {
            deleteFirstCheckpoint();
        }
        List<Position> route = Calculs.subdiviseRoute(ship.getPosition(), getFirstCheckpoint().getPosition());
        if (Calculs.checkCollision(reefs, route)) {//on regarde si un récif est sur notre itinéraire en ligne droite vers le CP
            Logs.add("Obstacle détecté sur votre trajet");
            List<Position> fakeCheckpointPositions = new ArrayList<>();
            Calculs.findFakeCheckpointPositions(ship.getPosition(), getFirstCheckpoint().getPosition(), 2, fakeCheckpointPositions);
            Calculs.findFakeCheckpointPositions(ship.getPosition(), getFirstCheckpoint().getPosition(), 1, fakeCheckpointPositions);
            Calculs.findFakeCheckpointPositions(ship.getPosition(), getFirstCheckpoint().getPosition(), 3, fakeCheckpointPositions);
            Calculs.findFakeCheckpointPositions(ship.getPosition(), getFirstCheckpoint().getPosition(), 4, fakeCheckpointPositions);

            for(Position position : fakeCheckpointPositions){
                if (!Calculs.checkCollision(reefs, Calculs.subdiviseRoute(ship.getPosition(), position))) {
                    Checkpoint fakeCP = new Checkpoint(position, new Circle(50));
                    fakeCP.setFake(true);
                    addFirstCheckpoint(fakeCP);
                    break;
                    //On crée un CP intermédiaire proche du récif
                }
            }
        }
    }

    //------------------------------GETTER-------------------------//

    public List<Checkpoint> getCheckpoints() {
        return checkpoints;
    }

    /**
     * Donne le premier checkpoint de la list de cp, renvoie null si plus de cp
     * @return le premier CP
     */
    @JsonIgnore
    public Checkpoint getFirstCheckpoint() {
        if (!this.checkpoints.isEmpty()) {
            return this.checkpoints.get(0);
        }
        else {
            Logs.add("PBCH");
            return null;
        }
    }

    @JsonIgnore
    public void addFirstCheckpoint(Checkpoint checkpoint){
        checkpoints.add(0, checkpoint);
    }

    @JsonIgnore
    public void deleteFirstCheckpoint(){
        checkpoints.remove(0);
    }



    //------------------------------SETTER-------------------------//


    public void setCheckpoints(List<Checkpoint> checkpoints) {
        this.checkpoints = checkpoints;
    }
}
