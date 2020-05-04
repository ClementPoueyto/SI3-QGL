package fr.unice.polytech.si3.qgl.zecommit.entite;


import java.util.Objects;

/**
 * Entite definissant l'objet Canon sur le bateau
 * @author Nathan
 *
 */

public class Canon extends Entity {
    private boolean loaded;
    private double angle;

    public Canon(int x, int y, boolean loaded, double angle){
        super(EntityType.canon,x,y);
        this.loaded=loaded;
        this.angle=angle;
    }

    /**
     * @return the angle
     */
    public double getAngle() {
        return angle;
    }

    /**
     * @return loaded
     */
    public boolean getLoaded() {
        return loaded;
    }



    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Canon canon = (Canon) o;
        return loaded == canon.loaded &&
                Double.compare(canon.angle, angle) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), loaded, angle);
    }
}
