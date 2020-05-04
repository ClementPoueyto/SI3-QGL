package fr.unice.polytech.si3.qgl.zecommit.other;


import fr.unice.polytech.si3.qgl.zecommit.boat.Position;
import fr.unice.polytech.si3.qgl.zecommit.shape.Shape;

import java.util.Objects;

/**
 * Classe modélisant les courants marins
 * @author Nathan
 */
public class Stream extends VisibleEntitie {

    private double strength;

    public Stream(Position position, Shape shape, double strength) {
        super(VisibleEntityType.stream, position, shape);
        this.strength = strength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stream stream = (Stream) o;
        return Double.compare(stream.strength, strength) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strength);
    }

    @Override
    public String toString() {
        return "Stream{" +
                super.getPosition()
                +
                "strength=" + strength +
                '}';
    }


    //------------------------------GETTER-------------------------//

    public double getStrength() {
        return strength;
    }


    //------------------------------SETTER-------------------------//

    public void setStrength(double strength) {
        this.strength = strength;
    }
}
