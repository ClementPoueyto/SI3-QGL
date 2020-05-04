package fr.unice.polytech.si3.qgl.zecommit.action;

import fr.unice.polytech.si3.qgl.zecommit.Logs;
/**
 *  Classe représentant l'action : utiliser la vigie
 */
public class UseWatch extends Action{
    public UseWatch(int id){
        super(id,ActionType.USE_WATCH);
        Logs.add("S" + sailorId + ": watch");

    }
}
