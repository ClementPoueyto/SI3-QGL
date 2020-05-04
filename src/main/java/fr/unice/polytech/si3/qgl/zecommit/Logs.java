package fr.unice.polytech.si3.qgl.zecommit;


import java.util.ArrayList;
import java.util.List;

/**
 * Classe générant les logs
 * @author Nathan
 */
public class Logs {
    Logs() {/*Constructeur vide*/ }

    protected static final List<String> myLogs = new ArrayList<>();

    public static void add(String s){
        myLogs.add(s);
    }

    public static List<String> sortie() {
        return myLogs;
    }


}
