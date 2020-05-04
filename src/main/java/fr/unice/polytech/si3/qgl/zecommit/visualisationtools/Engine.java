package fr.unice.polytech.si3.qgl.zecommit.visualisationtools;

import fr.unice.polytech.si3.qgl.zecommit.Cockpit;
import fr.unice.polytech.si3.qgl.zecommit.boat.Position;
import fr.unice.polytech.si3.qgl.zecommit.crew.Sailor;
import fr.unice.polytech.si3.qgl.zecommit.visualisationtools.deckvizu.DeckVizu;
import fr.unice.polytech.si3.qgl.zecommit.visualisationtools.exception.CollisionException;
import fr.unice.polytech.si3.qgl.zecommit.visualisationtools.exception.UnfinishedException;
import fr.unice.polytech.si3.qgl.zecommit.visualisationtools.settings.*;
import fr.unice.polytech.si3.qgl.zecommit.entite.Entity;

import java.util.ArrayList;
import java.util.List;


/**
 * Classe simulant l'appel du projet
 * @author Clement P
 */
public class Engine {
    public static boolean showWindow = true;
    public static boolean showDeck = false;
    public static List<List<Sailor>> SAILORS_VIZU;
    public static List<Entity> ENTITIES_VIZU;

    /**
     * Course à lancer
     */
    public static EngineSettingsInterface engineSettings = new EngineSettingsWeek12();//A modifier pour changer la simulation

    /**
     * Lance la simulation de la course engineSettings
     * @param args
     * @throws CollisionException si le bateau rentre en collision
     * @throws UnfinishedException pour d'autres erreurs
     */
    public static void main(String[] args) throws CollisionException, UnfinishedException {

        List<Position> positions = new ArrayList<>();
        SAILORS_VIZU = new ArrayList<>();

        engineSettings.initiateSettings();

        ENTITIES_VIZU = engineSettings.getEntities();

        EngineCalcul engineCalcul =  new EngineCalcul(engineSettings);
        String json = engineCalcul.thisToJson();
        System.out.println(json);
        EngineNextRound engineNextRound = new EngineNextRound();
        Cockpit cockpit = new Cockpit();
        cockpit.initGame(json);

        int currentStep = 0;
        int maxStep = 300;
        String output = "";
        while (!output.equals("[]") && currentStep < maxStep) {
            System.out.println("ROUND :" + currentStep);
            currentStep++;
            SAILORS_VIZU.add(engineSettings.getSailors());
            String json2 = engineCalcul.thisToJson2();
            //System.out.println(json2);
            output = cockpit.nextRound(json2);
            System.out.println(output);

            try {
                engineCalcul.updateEngine(engineNextRound.getEngineNextRound(output));
            } catch (Exception e) {
                System.err.println(e.getMessage());//affiche une exception en cas de collision
                throw new CollisionException();// a commenter pour ne pas interrompre le code
            }
            Position position = engineSettings.getShip().getPosition();
            positions.add(position);
            System.out.println(position + "\nFIN DU ROUND\n");
            if(currentStep==maxStep) {
                System.out.println(cockpit.getLogs());
                if(showWindow)
                    new Window(positions, engineSettings.getAllCheckpoints(), engineSettings.getVisibleEntities());
                throw new UnfinishedException();
            }
        }

        if(showWindow)
            new Window(positions, engineSettings.getAllCheckpoints(), engineSettings.getVisibleEntities());


        if(showDeck)
            new DeckVizu();

        String dieses = "##################################################################################################";
        System.out.println(dieses + "############################################## Logs ##############################################" + dieses);
        System.out.println(cockpit.getLogs());
        System.out.println(dieses + "########################################## Fin des Logs ##########################################" + dieses);

    }
}
