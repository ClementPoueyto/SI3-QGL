package fr.unice.polytech.si3.qgl.zecommit.shape;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import fr.unice.polytech.si3.qgl.zecommit.deserializer.ShapeDeserializer;


/**
 * Model de Forme
 * @author Clement P
 */
@JsonDeserialize(using = ShapeDeserializer.class)
public abstract class Shape {
    private String type;
    @JsonIgnore private boolean isCircle;
    @JsonIgnore private boolean isRectangle;

    public Shape(String type){
        this.type=type;
        this.isCircle=false;
        this.isRectangle=false;
    }
    @JsonIgnore
    public boolean isCircle(){
        return this.isCircle;
    }

    @JsonIgnore
    public boolean isRectangle(){
        return this.isRectangle;
    }

    //------------------------GETTER----------------------//

    public String getType() {
        return type;
    }

    @JsonIgnore
    public double getShapeRadius() {
        if(isCircle && !isRectangle)
            return ((Circle)this).getRadius();
        if(!isCircle && isRectangle)
            return ((Rectangle)this).getRadius();
        else
            return ((Polygone)this).getRadius();
    }

    @JsonIgnore
    public double getShapeOrientation(){
        if(isCircle && !isRectangle)
            return 0;
        if(!isCircle && isRectangle)
            return ((Rectangle)this).getOrientation();
        else
            return ((Polygone)this).getOrientation();
    }

    //------------------------SETTER----------------------//


    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public void setCircle(boolean circle) {
        isCircle = circle;
    }

    @JsonIgnore
    public void setRectangle(boolean rectangle) {
        isRectangle = rectangle;
    }

    @Override
    public String toString() {
        return "Shape{" + "Type=" + type + "'" + "}";
    }

}
