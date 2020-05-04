package fr.unice.polytech.si3.qgl.zecommit.action;

import java.util.Objects;

import fr.unice.polytech.si3.qgl.zecommit.Logs;

/**
 *  Classe représentant l'action : deplacer un marin
 */
public class Moving extends Action{

    private int xdistance;
    private int ydistance;

    public Moving(int sailorId, int xdistance, int ydistance){
        super(sailorId, ActionType.MOVING);
        if ((Math.abs(xdistance) + Math.abs(ydistance)) <= 5) {
            this.xdistance = xdistance;
            this.ydistance = ydistance;
        }
        else {
            if (Math.abs(xdistance) <= 5) {
                this.xdistance = xdistance;
                if(ydistance<0)
                    this.ydistance = - Math.min(5-Math.abs(this.xdistance), Math.abs(ydistance));
                else
                    this.ydistance = Math.min(5-Math.abs(this.xdistance), Math.abs(ydistance));
            }
            else {
                if(xdistance<0)
                    this.xdistance = -5;
                else
                    this.xdistance = 5;
                this.ydistance = 0;

            }

        }
        Logs.add("S" + sailorId + ": move: " + this.xdistance +"x, " + this.ydistance +"y");


    }

    @Override
    public boolean equals(Object obj) {
        if(obj==this) return true;
        if(obj instanceof Moving){
            Moving act = (Moving) obj;
            return (this.type.equals(act.type) && this.sailorId==act.sailorId && xdistance==act.xdistance && ydistance==act.ydistance);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sailorId,xdistance,ydistance);
    }

    //------------------------------GETTER-------------------------//

    public int getXDistance(){
        return this.xdistance;
    }

    public int getYDistance(){
        return this.ydistance;
    }
}
