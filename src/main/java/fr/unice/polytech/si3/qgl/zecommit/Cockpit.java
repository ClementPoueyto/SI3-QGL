package fr.unice.polytech.si3.qgl.zecommit;

import com.fasterxml.jackson.core.JsonProcessingException;
import fr.unice.polytech.si3.qgl.regatta.cockpit.ICockpit;
import fr.unice.polytech.si3.qgl.zecommit.action.Action;
import fr.unice.polytech.si3.qgl.zecommit.boat.Deck;
import fr.unice.polytech.si3.qgl.zecommit.boat.Position;
import fr.unice.polytech.si3.qgl.zecommit.boat.Ship;
import fr.unice.polytech.si3.qgl.zecommit.crew.Captain;
import fr.unice.polytech.si3.qgl.zecommit.crew.CaptainMate;
import fr.unice.polytech.si3.qgl.zecommit.goal.Regatta;
import fr.unice.polytech.si3.qgl.zecommit.other.Checkpoint;
import fr.unice.polytech.si3.qgl.zecommit.parser.InitGame;
import fr.unice.polytech.si3.qgl.zecommit.parser.NextRound;
import fr.unice.polytech.si3.qgl.zecommit.parser.Output;
import fr.unice.polytech.si3.qgl.zecommit.parser.Parser;
import fr.unice.polytech.si3.qgl.zecommit.shape.Circle;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe appelée pour lancer le projet
 */
public class Cockpit implements ICockpit {
	Game game;
	CaptainMate captainMate;
	Captain captain;

	/**
	 * Construit Game Captain et CaptainMate
	 * @param jsonInitGame le json d'entrée
	 */
	public void initGame(String jsonInitGame) {
		try {
			game = new Game();
			InitGame initGame = Parser.parseInitGame(jsonInitGame);
			setGameInfo(initGame);
			initCaptain();

		} catch (JsonProcessingException e) {
			Logs.add("Erreur Parseur InitGame");
			Logs.add(e.getMessage());
			System.err.println(Logs.sortie());
		}
	}

	public String nextRound(String jsonNextRound) {
		String res;
		try {
			Logs.add("\n - - - \n");
			Logs.add("" + game.getShip().getPosition());
			updateGame(Parser.parseNextRound(jsonNextRound));
			List<Action> actions = new ArrayList<>();
			if(game.getGoal().isRegatta()){
				actions = captainMate.actions();
			}

			Output output = new Output();
			res = output.afficheRound(actions);

		} catch (JsonProcessingException e) {
			Logs.add("Erreur Parseur nextRound");
			res = "[ ]";
			System.err.println(Logs.sortie());

		}

		return res;
	}


	@Override
	public List<String> getLogs() {
		return Logs.sortie();
	}


	/**
	 * Création et initialisation de l'objet Game
	 * @param initGame l'initgame créé
	 */
	public void setGameInfo(InitGame initGame) {
		game.setGoal(initGame.getGoal());
		game.setShip(initGame.getShip());
		game.setSailors(initGame.getSailors());
		game.setShipCount(initGame.getShipCount());
		Logs.add("nbSailors :" + game.getSailors().size());
		Logs.add(" nbOar :" + game.getShip().getDeckOars().size());
		if (game.getGoal().isRegatta()) {
			Logs.add(((Regatta) game.getGoal()).getCheckpoints() + "\n");
			Checkpoint cp = new Checkpoint(new Position(initGame.getShip().getXPosition(), initGame.getShip().getYPosition(), initGame.getShip().getPosition().getOrientation()), new Circle(50));
			cp.setFake(true);
			((Regatta) game.getGoal()).addFirstCheckpoint(cp);
		}
	}

	/**
	 * Création du CaptainMate et du Captain
	 */
	public void initCaptain() {
		this.captain = new Captain(game);
		this.captainMate = new CaptainMate(captain);
		Logs.add(captain.getOrientationTable().toString());
	}

	/**
	 * Met à jour l'objet Game
	 * @param nextRound le nextRound créé
	 */
	public void updateGame(NextRound nextRound) {
		Deck deck = game.getShip().getDeck();
		Ship newShip = nextRound.getShip();
		deck.updateSails(newShip.getEntities());
		newShip.setDeck(deck);
		game.setShip(newShip);
		captain.setShip(newShip);
		game.setVisibleEntities(nextRound.getVisibleEntities());
		captain.setVisibleEntities(nextRound.getVisibleEntities());
		game.setWind(nextRound.getWind());
		captain.setWind(nextRound.getWind());
	}

}
