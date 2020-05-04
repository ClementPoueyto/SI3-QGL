package fr.unice.polytech.si3.qgl.zecommit.parser;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import fr.unice.polytech.si3.qgl.zecommit.boat.Ship;
import fr.unice.polytech.si3.qgl.zecommit.deserializer.NextRoundDeserializer;
import fr.unice.polytech.si3.qgl.zecommit.other.VisibleEntitie;
import fr.unice.polytech.si3.qgl.zecommit.other.Wind;

import java.util.List;

/**
 * parser du nextRound
 */
@JsonDeserialize(using = NextRoundDeserializer.class)
public class NextRound {
    private Ship ship;
    private List<VisibleEntitie> visibleEntities;
    private Wind wind;

    public NextRound(Ship ship, List<VisibleEntitie> visibleEntities, Wind wind) {
        this.ship = ship;
        this.visibleEntities = visibleEntities;
        this.wind = wind;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public List<VisibleEntitie> getVisibleEntities() {
        return visibleEntities;
    }

    public void setVisibleEntities(List<VisibleEntitie> visibleEntities) {
        this.visibleEntities = visibleEntities;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }
}
