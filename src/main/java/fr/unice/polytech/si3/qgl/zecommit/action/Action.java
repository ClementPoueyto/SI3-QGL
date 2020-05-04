package fr.unice.polytech.si3.qgl.zecommit.action;

import java.util.Objects;

/**
 * Classe mère désignant les actions
 * @author Loic Bertolotto
 */
public abstract class Action{
    int sailorId;
    ActionType type;

    Action(int sailorId, ActionType type){
        this.sailorId = sailorId;
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==this) return true;
        if(obj instanceof Action){
            Action act = (Action) obj;
            return (this.type.equals(act.type) && this.sailorId==act.sailorId);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sailorId);
    }

    //------------------------------GETTER-------------------------//

    public int getSailorId(){
        return this.sailorId;
    }

    public ActionType getType(){
        return this.type;
    }





}
