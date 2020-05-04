

package fr.unice.polytech.si3.qgl.zecommit.boat;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import fr.unice.polytech.si3.qgl.zecommit.deserializer.PositionDeserializer;

import java.util.Objects;
/**
  Definie la position du bateau sur une carte
  @author Clement P
 */
@JsonDeserialize(using = PositionDeserializer.class)
public class Position {

    double x;
    double y;
    double orientation;

    public Position(double x, double y, double orientation){
        this.x=x;
        this.y=y;
        this.orientation=orientation;
    }

    public double distanceTo(Position position) {
        return Math.sqrt(Math.pow(position.getX() - this.getX(),2) + Math.pow(position.getY() - this.getY(),2));
    }

    @Override
    public String toString() {
        return "P{ " + this.x + " , " + this.y + " }";
    }
    //------------------------------GETTER-------------------------//

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getOrientation() {
        return orientation;
    }


    //------------------------------SETTER-------------------------//

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setOrientation(double orientation) {
        this.orientation = orientation;
    }

    //-------------------------------------------------------------//


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Double.compare(position.x, x) == 0 &&
                Double.compare(position.y, y) == 0 &&
                Double.compare(position.orientation, orientation) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, orientation);
    }
}
