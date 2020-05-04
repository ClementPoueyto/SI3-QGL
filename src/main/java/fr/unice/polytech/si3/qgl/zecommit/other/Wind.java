package fr.unice.polytech.si3.qgl.zecommit.other;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import fr.unice.polytech.si3.qgl.zecommit.deserializer.WindDeserializer;

import java.util.Objects;

/**
 * Classe correspondant au vent
 * @author Nathan
 */
@JsonDeserialize(using = WindDeserializer.class)
public class Wind {
    private double orientation;
    private double strength;


    public Wind(double orientation, double strength) {

        this.orientation = orientation;
        this.strength = strength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wind wind = (Wind) o;
        return Double.compare(wind.orientation, orientation) == 0 &&
                Double.compare(wind.strength, strength) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orientation, strength);
    }

    @Override
    public String toString() {
        return "Wind{" +
                "orientation=" + orientation +
                ", strength=" + strength +
                '}';
    }

    //------------------------------GETTER-------------------------//

    public double getOrientation() {
        return orientation;
    }

    public double getStrength() {
        return strength;
    }


    //------------------------------SETTER-------------------------//


    public void setOrientation(double orientation) {
        this.orientation = orientation;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }
}
