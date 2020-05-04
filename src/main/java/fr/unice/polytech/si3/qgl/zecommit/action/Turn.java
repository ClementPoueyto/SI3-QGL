package fr.unice.polytech.si3.qgl.zecommit.action;

import java.util.Objects;

import fr.unice.polytech.si3.qgl.zecommit.Logs;

/**
 *  Classe représentant l'action : tourner avec le gouvernail
 */
public class Turn extends Action{

    private double rotation;

    public Turn(int id, double rotation){
        super(id,ActionType.TURN);
        if(rotation<=Math.PI/4&&rotation>=-Math.PI/4) {
            this.rotation = rotation;
            Logs.add("S" + sailorId + ": turn : " + rotation + "\n");
        }
        else{
            this.rotation=0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==this) return true;
        if(obj instanceof Turn){
            Turn act = (Turn) obj;
            return this.sailorId==act.sailorId && this.rotation==act.rotation;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sailorId,rotation);
    }


    public double getRotation(){
        return this.rotation;
    }
}
