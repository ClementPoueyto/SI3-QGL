package fr.unice.polytech.si3.qgl.zecommit.action;

import fr.unice.polytech.si3.qgl.zecommit.Logs;

/**
 *  Classe représentant l'action : lever la voile
 */
public class LiftSail extends Action{
    public LiftSail(int id){
        super(id,ActionType.LIFT_SAIL);
        Logs.add("S" + sailorId + ": liftening sail");
        Logs.add("\n                         v  ~.      v\n" +
                "                v           /|\n" +
                "                           / |          v\n" +
                "                    v     /__|__\n" +
                "                        \\--------/\n" +
                "      ~~~~~~~~~~~~~~~~~~~`~~~~~~'~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }
}
