package fr.unice.polytech.si3.qgl.zecommit.action;

import fr.unice.polytech.si3.qgl.zecommit.Logs;

/**
 *  Classe représentant l'action : baisser la voile
 */
public class LowerSail extends Action {
    public LowerSail(int id) {
        super(id,ActionType.LOWER_SAIL);
        Logs.add("S" + sailorId + ": lowering sail");
        Logs.add("\n                         v  ~.      v\n" +
                "                v            |\n" +
                "                             |          v\n" +
                "                    v      __|__\n" +
                "                        \\--------/\n" +
                "      ~~~~~~~~~~~~~~~~~~~`~~~~~~'~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

    }
}
