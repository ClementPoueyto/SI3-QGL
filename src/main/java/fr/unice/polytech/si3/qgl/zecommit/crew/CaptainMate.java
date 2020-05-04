package fr.unice.polytech.si3.qgl.zecommit.crew;

import fr.unice.polytech.si3.qgl.zecommit.action.*;
import fr.unice.polytech.si3.qgl.zecommit.entite.EntityType;
import fr.unice.polytech.si3.qgl.zecommit.entite.Sail;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe correspondant au second
 */
public class CaptainMate {

    private Captain captain;
    private List<Action> actions;
    private boolean initGame;

    public CaptainMate(Captain captain) {
        this.captain = captain;
        this.actions = new ArrayList<>();
        this.initGame = true;
    }

    /**
     * Déplace les marins aux entités associés
     * @param sailors
     */
    public void moveSailorsToTheirEntity(List<Sailor> sailors) {
        if (!sailors.isEmpty()) {
            for (Sailor sailor : sailors) {
                if (sailor.hasEntity() && !sailor.isOnEntity()) {
                    actions.add(captain.getDeck().moveSailor(sailor, sailor.getEntity().getX() - sailor.getX(),
                            sailor.getEntity().getY() - sailor.getY()));


                }
            }
        }
    }

    /**
     * Active les rames associés aux marins de sailors
     * @param sailors
     */
    public void activateOars(List<Sailor> sailors) {
        if(!sailors.isEmpty())
            sailors.forEach(sailor -> {
                if(sailor.getEntity()!=null && sailor.getEntity().getType()==EntityType.oar && sailor.isOnEntity())
                    actions.add(new ToOar(sailor.getId()));
            });

    }

    /**
     * Active le gouvernail avec l'angle associé
     * @param sailorAndAngle
     */
    public void toTurn(SimpleEntry<Sailor,Double> sailorAndAngle) {
        if(sailorAndAngle!=null && sailorAndAngle.getValue()!=null && sailorAndAngle.getValue()!=0.0){
            double angle = sailorAndAngle.getValue();
            if(angle>0)
                angle = Math.min(Math.PI/4, angle);
            else
                angle = Math.max(-Math.PI/4, angle);
            Sailor sailor = sailorAndAngle.getKey();
            if(sailorAndAngle.getKey()!=null && sailor.getEntity()!=null && sailor.getEntity().getType()==EntityType.rudder && sailor.isOnEntity())
                actions.add(new Turn(sailorAndAngle.getKey().getId(), angle));
        }

    }

    /**
     * Monte les voiles associées aux marins de sailors
     * @param sailors
     */
    public void toLiftSail(List<Sailor> sailors) {
        if(!sailors.isEmpty()){
            sailors.forEach(sailor -> {
                if(sailor.getEntity()!=null && sailor.getEntity().getType()==EntityType.sail && sailor.isOnEntity()){
                    actions.add(new LiftSail(sailor.getId()));
                    Sail sail = (Sail)sailor.getEntity();
                    sail.setOpenned(true);
                }
            });
        }
    }

    /**
     * Baisse les voiles associées aux marins de sailors 
     * @param sailors
     */
    public void toLowerSail(List<Sailor> sailors) {
        if(!sailors.isEmpty()){
            sailors.forEach(sailor -> {
                if(sailor.getEntity()!=null && sailor.getEntity().getType()==EntityType.sail && sailor.isOnEntity()){
                    actions.add(new LowerSail(sailor.getId()));
                    Sail sail = (Sail)sailor.getEntity();
                    sail.setOpenned(false);
                }
            });
        }
    }

    /**
     * Utilise la vigie
     * @param sailor
     */
    public void toUseWatch(Sailor sailor){
        if(sailor!=null && sailor.getEntity()!=null && sailor.getEntity().getType()==EntityType.watch && sailor.isOnEntity()){
            actions.add(new UseWatch(sailor.getId()));
        }
    }

    /**
     * Génère la liste d'actions réalisées
     * @return la liste d'actions
     */
    public List<Action> actions(){
        refreshData();
        if(this.initGame){
            captain.attributeEntitiesToSailors();
            this.initGame = false;
        }
        if(captain.pursueGame()){
            moveSailorsToTheirEntity(captain.doMoveSailors());
            activateOars(captain.doActivateOars());
            toTurn(captain.doTurn());
            toLiftSail(captain.doLiftSail());
            toLowerSail(captain.doLowerSail());
            toUseWatch(captain.doUseWatch());
        }
        return this.actions;

    }

    public void refreshData(){
        this.actions.removeAll(this.actions);
    }

}
