package fr.unice.polytech.si3.qgl.zecommit.other;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import fr.unice.polytech.si3.qgl.zecommit.boat.Position;
import fr.unice.polytech.si3.qgl.zecommit.deserializer.VisibleEntitiesDeserializer;
import fr.unice.polytech.si3.qgl.zecommit.shape.Shape;

import java.util.Objects;


/**
 * Classe mère des visibleEntities
 * @author Nathan
 */
@JsonDeserialize(using = VisibleEntitiesDeserializer.class)
public abstract class VisibleEntitie {
    protected VisibleEntityType type;
    protected Position position;
    protected Shape shape;

    public VisibleEntitie (VisibleEntityType type, Position position,Shape shape){
        this.type=type;
        this.position=position;
        this.shape=shape;
    }
    //------------------------------GETTER-------------------------//

    public VisibleEntityType getType(){return this.type;}

    public Position getPosition() {
        return position;
    }

    public Shape getShape() {
        return shape;
    }

    //------------------------------SETTER-------------------------//


    public void setPosition(Position position) {
        this.position = position;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }


    @Override
    public String toString() {
        return "VisibleEntitie{" +
                "type=" + type +
                ", position=" + position +
                ", shape=" + shape +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisibleEntitie that = (VisibleEntitie) o;
        return type == that.type &&
                Objects.equals(position, that.position) &&
                Objects.equals(shape, that.shape);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, position, shape);
    }
}
