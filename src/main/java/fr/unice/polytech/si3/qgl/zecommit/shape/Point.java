package fr.unice.polytech.si3.qgl.zecommit.shape;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * Classe correspondant à la définition d'un point
 */
public class Point {
    @JsonProperty("x")
    private double x;
    @JsonProperty("y")
    private double y;

    public Point(@JsonProperty("x") double x, @JsonProperty("y") double y){
        this.x=x;
        this.y=y;
    }

    /**
     * Calcul de la distance entre deux points
     * @param a
     * @return une distance
     */
    public double distanceTo(Point a) {
        return Math.sqrt(Math.pow(a.getX() - this.getX(), 2) + Math.pow(a.getY() - this.getY(), 2));
    }

    ///////////////////// GETTER //////////////////////////


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }


    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Point)) {
            return false;
        }
        Point point = (Point) obj;
        return(point.x == this.x && point.y == this.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
