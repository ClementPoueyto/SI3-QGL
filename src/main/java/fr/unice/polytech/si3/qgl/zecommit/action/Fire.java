package fr.unice.polytech.si3.qgl.zecommit.action;

import fr.unice.polytech.si3.qgl.zecommit.Logs;

/**
 * Classe représentant l'action : tirer avec le canon
 * @author Nathan
 */

public class Fire extends Action {

    public Fire(int sailorId) {
        super(sailorId, ActionType.FIRE);
            Logs.add("S" + sailorId + ": fire\n");

    }
}
