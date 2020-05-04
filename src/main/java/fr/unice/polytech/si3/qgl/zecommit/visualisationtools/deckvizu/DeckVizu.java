package fr.unice.polytech.si3.qgl.zecommit.visualisationtools.deckvizu;

/**
 * Classe de visualisation du deck
 */
public class DeckVizu implements Runnable {


    GUI gui = new GUI();

    public static void main(String[] args) {
        new Thread(new DeckVizu()).start();
    }
    @Override
    public void run() {
        while(true) {
            gui.repaint();
        }
    }
}
