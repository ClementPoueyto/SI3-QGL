package fr.unice.polytech.si3.qgl.zecommit.action;

/**
 * Enum des actions possibles
 */
public enum ActionType{
    LIFT_SAIL,LOWER_SAIL,MOVING,OAR,TURN,USE_WATCH,AIM,FIRE,RELOAD;

    @Override
    public String toString(){
        return this.name();
    }

}
