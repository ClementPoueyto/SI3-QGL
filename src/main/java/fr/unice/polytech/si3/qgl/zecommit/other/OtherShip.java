package fr.unice.polytech.si3.qgl.zecommit.other;

import java.util.Objects;

import fr.unice.polytech.si3.qgl.zecommit.boat.Position;
import fr.unice.polytech.si3.qgl.zecommit.shape.Shape;

/**
 * Classe correspondant à un autre bateau
 */
public class OtherShip extends VisibleEntitie {

    private int life;

    public OtherShip(String type, Position position, Shape shape, int life){
        super(VisibleEntityType.ship ,position, shape);
        this.life = life;

    }

    @Override
    public boolean equals(Object obj) {
        if(obj==this) return true;
        if(obj instanceof OtherShip){
            OtherShip  otherShip= (OtherShip)obj;
            return (this.type.equals(otherShip.type) && this.position.getX()==otherShip.position.getX() && this.position.getY()==otherShip.position.getY() && this.life == otherShip.life);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, position.getX(), position.getY(), life);
    }


    //--------------------GETTER -------------------------//

    public int getLife() {
        return life;
    }

    //--------------------SETTER -------------------------//

    public void setLife(int life) {
        this.life = life;
    }

}
