package fr.unice.polytech.si3.qgl.zecommit.crew;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import fr.unice.polytech.si3.qgl.zecommit.deserializer.SailorDeserializer;
import fr.unice.polytech.si3.qgl.zecommit.entite.Entity;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;


/**
 * Classe correspondant au marin
 * @author joris Liebgott
 */
@JsonDeserialize(using = SailorDeserializer.class)
public class Sailor {
    private int id;
    private int x;
    private int y;
    private String name;
    @JsonIgnore
    private Entity entity;

    public Sailor(int id,int x, int y, String name) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.name = name;
        this.entity = null;
    }

    public void move(int xdistance, int ydistance){
        this.x+=xdistance;
        this.y+=ydistance;
    }

    public int distanceToEntity(Entity e){
        return Math.abs(x-e.getX()) + Math.abs(y-e.getY());
    }

    /**
     * @return true si le marin est sur son entité, false sinon
     */
    @JsonIgnore
    public boolean isOnEntity(){
        return hasEntity() && this.x==this.entity.getX() && this.y==this.entity.getY();
    }

    /**
     * @return true si le marin est associé à une entité, false sinon
     */
    @JsonIgnore
    public boolean hasEntity(){
        return this.entity!=null;
    }

    /**
     * @param e liste d'entités
     * @return la distance avec l'entité la plus proche du marin
     */
    public int distanceToNearestEntity(List<Entity> e){
        Stream<Entity> en = e.stream();
        Optional<Entity> min = en.min(Comparator.comparingInt(this::distanceToEntity));
        if(min.isPresent())
            return distanceToEntity(min.get());
        return 0;
    }


    //--------------------GETTER -------------------------//

    public Entity getEntity(){
        return this.entity;
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getName() {
        return name;
    }


    //------------------------------SETTER-------------------------//


    public void setId(int id) {
        this.id = id;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOnEntity(Entity e){
        if(this.entity != null)
            this.entity.putSailorOn(null);
        this.entity = e;
        this.entity.putSailorOn(this);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sailor sailor = (Sailor) o;
        return id == sailor.id &&
                x == sailor.x &&
                y == sailor.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, x, y);
    }


    @Override
    public String toString(){
        return "\n[id : "+this.id+
                "\nx : "+this.x+
                "\ny : "+this.y+
                "\nname : "+this.name+"]";
    }
}
