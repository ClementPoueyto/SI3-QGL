package fr.unice.polytech.si3.qgl.zecommit.maths;

import fr.unice.polytech.si3.qgl.zecommit.boat.Position;

/**
 * Classe qui détermine la trajectoire à prendre
 */
public class Road {

    private Position startPosition;
    private Position finishPosition;
    private double shipOrientation;

    public Road(Position start, Position finish) {
        this.shipOrientation = start.getOrientation();
        this.startPosition = start;
        this.finishPosition = finish;
    }

    public double xDistanceToGoal() {
        return Math.abs(startPosition.getX() - finishPosition.getX());
    }

    public double yDistanceToGoal() {
        return Math.abs(startPosition.getY() - finishPosition.getY());
    }

    public double distanceToGoal() {
        return Math.sqrt(Math.pow(xDistanceToGoal(), 2) + Math.pow(yDistanceToGoal(), 2));
    }


    /**
     * Retourne l'angle entre l'orientation du bateau et l'objectif.
     * Si le bateau est parfaitement orienté avec l'objectif, on regarde s'il point vers l'objectif ou s'en éloigne
     *
     * @return double, l'orientation visée
     */
    public double orientationToGoal() {
        double angle = shipOrientation;
        double x = (finishPosition.getX() - startPosition.getX());
        double y = (finishPosition.getY() - startPosition.getY());
        if (x == 0 && y == 0) {
            return 0;

        }
        if (x == 0) {
            if (y > 0)
                angle = Math.PI / 2;
            if (y < 0)
                angle = -Math.PI / 2;
        } else {
            angle = Calculs.shortestAngle(Math.atan(y / x));
        }
        return Calculs.shortestAngle(Calculs.adjustAngle((angle), startPosition, finishPosition, shipOrientation));

    }


    /**
     * Méthode renvoyant la tranche dans laquelle se situe l'angle souhaité
     * @param oarsNb le nombre de marins
     * @param canUseRuddder boolean true si gouvernail présent et utilisable
     * @return un int correspondant au cap
     */
    public int findClosestPossibleAngle(int oarsNb, boolean canUseRuddder) {
        double angle;
        angle = orientationToGoal();
        if (orientationToGoal() > -Math.PI / 4 && orientationToGoal() < Math.PI / 4 && canUseRuddder)
            angle = 0;
        double step = Math.PI / (2 * oarsNb);
        int res = 0;
        for (int k = 0; k < 2 * oarsNb; k++) {

            if (k * step - Math.PI / 2 <= angle && angle <= (k + 1) * step - Math.PI / 2)

                res = k;
        }
        if (turnAroundLeft())
            return oarsNb;
        if (turnAroundRight())
            return 0;

        if (res == 0)
            return 0;
        if (res == 2 * oarsNb - 1)
            return oarsNb;
        else
            return (res + 1) / 2;
    }

    /**
     * demi tour gauche ?
     *
     * @return boolean, true s'il faut faire demi tour à gauche
     */
    public boolean turnAroundLeft() {
        return (orientationToGoal() > Math.PI / 2 && orientationToGoal() <= Math.PI);
    }


    /**
     * demi tour droite ?
     *
     * @return boolean, true s'il faut faire demi tour à droite
     */
    public boolean turnAroundRight() {
        return (orientationToGoal() < -Math.PI / 2 && orientationToGoal() > -Math.PI);
    }


    //------------------------GETTER----------------------------
    public double getOrientation() {
        return shipOrientation;
    }

    public Position getFinishPosition() {
        return finishPosition;
    }

    public Position getStartPosition() {
        return startPosition;
    }
}
