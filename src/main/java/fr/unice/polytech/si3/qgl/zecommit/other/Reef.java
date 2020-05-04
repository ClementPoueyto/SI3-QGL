package fr.unice.polytech.si3.qgl.zecommit.other;


import fr.unice.polytech.si3.qgl.zecommit.boat.Position;
import fr.unice.polytech.si3.qgl.zecommit.shape.Shape;

/**
 * Classe correspondant aux récifs
 * @author Nathan
 */
public class Reef extends VisibleEntitie {

    public Reef(Position position, Shape shape) {
        super(VisibleEntityType.reef, position, shape);
    }

}

