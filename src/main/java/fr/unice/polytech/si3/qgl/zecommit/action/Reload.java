package fr.unice.polytech.si3.qgl.zecommit.action;

import fr.unice.polytech.si3.qgl.zecommit.Logs;

/**
 * Classe représentant l'action : recharger le canon
 * @author Nathan
 */

public class Reload extends Action {

    public Reload(int sailorId) {
        super(sailorId, ActionType.RELOAD);
        Logs.add("S" + sailorId + ": reload\n");

    }
}
