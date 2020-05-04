package fr.unice.polytech.si3.qgl.zecommit.action;

import fr.unice.polytech.si3.qgl.zecommit.Logs;

/**
 * Classe représentant l'action : orienter le canon
 * @author Nathan
 */

public class Aim extends Action {

    private double angle;

    public Aim(int sailorId, double angle) {
        super(sailorId, ActionType.AIM);
        if (angle <= Math.PI / 4 && angle >= -Math.PI / 4) {
            this.angle = angle;
            Logs.add("S" + sailorId + ": aim : " + angle + "\n");

        }
    }

    public double getAngle() {
        return angle;
    }
}
