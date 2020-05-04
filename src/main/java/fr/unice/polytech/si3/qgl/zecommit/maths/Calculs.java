package fr.unice.polytech.si3.qgl.zecommit.maths;


import fr.unice.polytech.si3.qgl.zecommit.boat.Position;

import fr.unice.polytech.si3.qgl.zecommit.other.Reef;
import fr.unice.polytech.si3.qgl.zecommit.shape.Polygone;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe effectuant les calculs
 * @author Nathan
 */
public class Calculs {

    private Calculs() {
        //constructeur vide
    }

    /**
     * Permet d'obtenir un angle le plus petit possible, évite de faire un virage trop grand
     *
     * @param angle l'angle en paramètre
     * @return l'angle compris entre -PI;PI
     */
    public static double shortestAngle(double angle) {
        if (angle > Math.PI)
            return angle - (2 * Math.PI);
        if (angle < -Math.PI)
            return angle + (2 * Math.PI);
        return angle;
    }


    /**
     * Subdivise le trajet en une liste de Positions
     *
     * @param position      du bateau
     * @param finalPosition la position prévue
     * @return liste de positions
     */
    public static List<Position> subdiviseRoute(Position position, Position finalPosition) {
        List<Position> resPositions = new ArrayList<>();
        double xStart = position.getX();
        double yStart = position.getY();
        double xFinish = finalPosition.getX();
        double yFinish = finalPosition.getY();
        double xDiff = Math.abs(xFinish - xStart);
        double yDiff = Math.abs(yFinish - yStart);
        resPositions.add(position);
        int step = 500;

        if (xStart < xFinish && yStart < yFinish) {
            for (int k = 1; k < step; k++) {
                resPositions.add(new Position(xStart + (double) 1 / step * k * xDiff, yStart + (double) 1 / step * k * yDiff, position.getOrientation()));
            }
        }

        if (xStart > xFinish && yStart < yFinish) {
            for (int k = 1; k < step; k++) {
                resPositions.add(new Position(xStart - (double) 1 / step * k * xDiff, yStart + (double) 1 / step * k * yDiff, position.getOrientation()));
            }
        }

        if (xStart > xFinish && yStart > yFinish) {
            for (int k = 1; k < step; k++) {
                resPositions.add(new Position(xStart - (double) 1 / step * k * xDiff, yStart - (double) 1 / step * k * yDiff, position.getOrientation()));
            }
        }

        if (xStart < xFinish && yStart > yFinish) {
            for (int k = 1; k < step; k++) {
                resPositions.add(new Position(xStart + (double) 1 / step * k * xDiff, yStart - (double) 1 / step * k * yDiff, position.getOrientation()));
            }
        }

        if (xStart == xFinish && yStart > yFinish) {
            for (int k = 1; k < step; k++) {
                resPositions.add(new Position(xStart, yStart - (double) 1 / step * k * yDiff, position.getOrientation()));
            }
        }
        if (xStart == xFinish && yStart < yFinish) {
            for (int k = 1; k < step; k++) {
                resPositions.add(new Position(xStart, yStart + (double) 1 / step * k * yDiff, position.getOrientation()));
            }
        }

        if (xStart > xFinish && yStart == yFinish) {
            for (int k = 1; k < step; k++) {
                resPositions.add(new Position(xStart - (double) 1 / step * k * xDiff, yStart, position.getOrientation()));
            }
        }
        if (xStart < xFinish && yStart == yFinish) {
            for (int k = 1; k < step; k++) {
                resPositions.add(new Position(xStart + (double) 1 / step * k * xDiff, yStart, position.getOrientation()));
            }
        }
        resPositions.add(finalPosition);
        return resPositions;
    }


    /**
     * Méthode vérifiant les collisions avec tous les récifs présents
     * @param reefs les récifs
     * @param route une liste de positions correspondant au chemin emprunté
     * @return boolean, true en cas de collision
     */
    public static boolean checkCollision(List<Reef> reefs, List<Position> route) {
        boolean res = false;

        for (Reef reef : reefs) {
            for (Position nextPosition : route) {
                if(!reef.getShape().isRectangle() && !reef.getShape().isCircle() && reef.getPosition().getOrientation()!=0){
                    ((Polygone)reef.getShape()).setOrientation(reef.getPosition().getOrientation()+reef.getShape().getShapeOrientation());
                }

                Collision collision = new Collision(reef.getShape(), reef.getPosition(), nextPosition);
                if (collision.collide()) {
                    res = true;
                }
            }
        }
        return res;
    }


    /**
     * Méthode permettant de determiner deux positions de CP potentiels
     * On a deux points A et B (bateau et CP)
     * On trouve C, milieu de [AB]
     * On trouve les points D et E équidistants de A et B en trouvant les intersections entre
     * le cercle de centre A de rayon AE (AE= sqrt(2 * AC**2)) et le cercle de centre B et rayon BE=AE
     * <p>
     *                  x E
     *  x              /
     * A              /
     *               /
     *              x
     *             / C
     *            /
     *           /              x
     *        D x                B
     *
     * @param position1 celle du bateau
     * @param position2 celle du CP
     * @param strategy true si l'on place les CP très loin
     * @return la list de positions des CP intermédiaires
     */
    public static void findFakeCheckpointPositions(Position position1, Position position2, int strategy, List<Position> res) {
        double x1 = position1.getX();
        double y1 = position1.getY();
        double x2 = position2.getX();
        double y2 = position2.getY();

        double xCenter = (x1 + x2) / 2;
        double yCenter = (y1 + y2) / 2;
        Position center = new Position(xCenter, yCenter, 0);

        double rayon = center.distanceTo(position1);
        double r1;
        if(strategy==2)
            r1 = Math.sqrt(rayon * rayon + rayon/2 * rayon/2);
        else
            r1 = Math.sqrt(rayon * rayon + rayon * rayon);

        double xc1 = position1.getX(); // abscisse du centre du premier cercle
        double yc1 = position1.getY(); // ordonnée du centre du premier cercle
        double rc1 = r1; // rayon du premier cercle
        double xc2 = position2.getX(); // abscisse du centre du second cercle
        double yc2 = position2.getY(); // ordonnée du centre du second cercle
        double rc2 = r1; // rayon du second cercle
        if(strategy==3)
            rc2=2*r1;
        if(strategy==4){
            rc1=0.3*r1;
            rc2 = rayon;
            xc2 = xCenter;
            yc2 = yCenter;
        }
        double xia;
        double xib;
        double yia;
        double yib;

        if (yc1 == yc2) { // si les deux cercles sont sur la même ordonnée, on utilise Pythagore...

            double a = Math.abs(xc1 - xc2);
            xia = (Math.pow(rc2, 2) - Math.pow(a, 2) - Math.pow(rc1, 2)) / (-2 * a) + xc1;
            xib = (Math.pow(rc2, 2) - Math.pow(a, 2) - Math.pow(rc1, 2)) / (-2 * a) + xc1;
            yia = -Math.sqrt(Math.pow(rc2, 2) - Math.pow(a - xia + xc1, 2)) + yc1;
            yib = -yia + 2 * yc1;
        } else // ...sinon, cas général
        {
            double a = (-Math.pow(xc1, 2) - Math.pow(yc1, 2) + Math.pow(xc2, 2) + Math.pow(yc2, 2) + Math.pow(rc1, 2) - Math.pow(rc2, 2)) / (2 * (yc2 - yc1));
            double d = (xc2 - xc1) / (yc2 - yc1);
            double e = Math.pow(d, 2) + 1;
            double f = -2 * xc1 + 2 * yc1 * d - 2 * a * d;
            double g = Math.pow(xc1, 2) + Math.pow(yc1, 2) - 2 * yc1 * a + Math.pow(a, 2) - Math.pow(rc1, 2);
            double delta = Math.pow(f, 2) - 4 * e * g;
            xia = (-f + Math.sqrt(delta)) / (2 * e);
            xib = (-f - Math.sqrt(delta)) / (2 * e);
            yia = a - ((-f + Math.sqrt(delta)) / (2 * e)) * d;
            yib = a - ((-f - Math.sqrt(delta)) / (2 * e)) * d;
        }

        // si les cercles ne se touchent pas ou bien sont identiques on n'ajoute rien
        // coordonnées des deux points d'intersection (nb : seront identiques si les cercles ne se touchent qu'en un seul point)
        if (!Double.isNaN(xib) && !Double.isNaN(yib))
            res.add(new Position(xib, yib, 0));
        if (!Double.isNaN(xia) && !Double.isNaN(yia))
            res.add(new Position(xia, yia, 0));
    }


    public static double adjustAngle(double angle, Position startPosition, Position finishPosition, double shipOrientation) {
        if (finishPosition.getX() < startPosition.getX() && finishPosition.getY() <= startPosition.getY()) {
            angle -= Math.PI;
            angle -= shipOrientation;
        }
        if (finishPosition.getX() < startPosition.getX() && finishPosition.getY() > startPosition.getY()) {
            angle += Math.PI - shipOrientation;
        }
        if (finishPosition.getX() >= startPosition.getX() && finishPosition.getY() < startPosition.getY()) {
            angle -= shipOrientation;
        }
        if (finishPosition.getX() >= startPosition.getX() && finishPosition.getY() >= startPosition.getY()) {
            angle -= shipOrientation;
        }
        return angle;
    }

}
