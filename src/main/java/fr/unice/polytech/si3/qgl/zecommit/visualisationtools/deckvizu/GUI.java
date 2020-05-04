package fr.unice.polytech.si3.qgl.zecommit.visualisationtools.deckvizu;

import fr.unice.polytech.si3.qgl.zecommit.crew.Sailor;
import fr.unice.polytech.si3.qgl.zecommit.entite.Entity;

import fr.unice.polytech.si3.qgl.zecommit.visualisationtools.Engine;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

/**
 * Classe pour la visualisation du deck
 */
public class GUI extends JFrame {

    int round = 0;
    int spacing = 5;
    int size = 80;
    int row = Engine.engineSettings.getDeck().getWidth();
    int column = Engine.engineSettings.getDeck().getLength();
    String[][] tabSailors;

    List<List<Sailor>> sailorsDeck = Engine.SAILORS_VIZU;
    List<Entity> entitiesDeck = Engine.ENTITIES_VIZU;




    Color colorOar = Color.BLUE;
    Color colorRudder = Color.RED;
    Color colorSail = Color.YELLOW;
    Color colorWatch = Color.cyan;

    public GUI() {
        this.setTitle("BoatDeck");
        this.setSize(1280,720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        Board board = new Board();
        this.setContentPane(board);

        Move move = new Move();
        this.addMouseMotionListener(move);

        Click click = new Click();
        this.addMouseListener(click);

        List<Sailor> sailorsAtTurn= sailorsDeck.get(round);

        tabSailors = new String[column][row];
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                tabSailors[i][j] = "";
            }
        }

        System.out.println("Sailor DEck : " + sailorsDeck);
        System.out.println("Sailors At Turn : " + sailorsAtTurn);

        for (Sailor sailor: sailorsAtTurn) {
            int x = sailor.getX();
            int y = sailor.getY();
            if (sailor.getId() < 10) {
                tabSailors[x][y] = "ID :0" + sailor.getId();
            }
            else {
                tabSailors[x][y] = "ID :" + sailor.getId();
            }
        }

        for (Entity entity: entitiesDeck) {
            int x = entity.getX();
            int y = entity.getY();
            tabSailors[x][y] += " E :" + entity.getType();
        }

        for (int i = 0; i < tabSailors.length; i++) {
            for (int j = 0; j < tabSailors[i].length; j++) {
                System.out.println("TAB sailors => i:"+i+"j:"+j+ "tab : " + tabSailors[i][j]);
            }
        }

    }



    public class Board extends JPanel {
        public void paintComponent(Graphics g) {
            g.setColor(Color.DARK_GRAY);
            g.fillRect(0,0,1280,720);
            for (int i = 0; i < column; i++) {
                for (int j = 0; j < row; j++) {

                    if (tabSailors[i][j].equals("")) {
                        g.setColor(Color.LIGHT_GRAY);
                        g.fillRect(spacing + i * size, spacing + j * size, size - spacing, size - spacing);
                    }
                    else if (tabSailors[i][j].length() == 8) {
                        g.setColor(colorSail);
                        g.fillRect(spacing + i * size, spacing + j * size, size - spacing, size - spacing);
                    }
                    else if (tabSailors[i][j].length() == 7) {
                        g.setColor(colorOar);
                        g.fillRect(spacing + i * size, spacing + j * size, size - spacing, size - spacing);
                    }
                    else if (tabSailors[i][j].length() == 10) {
                        g.setColor(colorRudder);
                        g.fillRect(spacing + i * size, spacing + j * size, size - spacing, size - spacing);
                    }
                    else if (tabSailors[i][j].length() == 9) {
                        g.setColor(colorWatch);
                        g.fillRect(spacing + i * size, spacing + j * size, size - spacing, size - spacing);
                    }

                    else {
                        if (tabSailors[i][j].substring(0,2).equals("ID")) {
                            if (tabSailors[i][j].length() == 13) {
                                g.setColor(colorOar);
                            }
                            else if (tabSailors[i][j].length() == 16) {
                                g.setColor(colorRudder);
                            }
                            else if (tabSailors[i][j].length() == 14) {
                                g.setColor(colorSail);
                            }
                            else if (tabSailors[i][j].length() == 15) {
                                g.setColor(colorWatch);
                            }
                            else {
                                g.setColor(Color.LIGHT_GRAY);
                            }
                            g.fillRect(spacing + i * size, spacing + j * size, size - spacing, size - spacing);
                            g.setColor(Color.BLACK);
                            g.setFont(new Font("Serial", Font.PLAIN, 14));
                            g.drawString(tabSailors[i][j].substring(0,6), spacing + i * size + (size/3), spacing + j * size + (size/2));
                        }
                    }
                }
            }
        }
    }

    public static class Move implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent e) {
            //vide
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            //vide
        }
    }

    public static class Click implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            //vide
        }

        @Override
        public void mousePressed(MouseEvent e) {
            //vide
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            //vide
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            //vide
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //vide
        }
    }

}
