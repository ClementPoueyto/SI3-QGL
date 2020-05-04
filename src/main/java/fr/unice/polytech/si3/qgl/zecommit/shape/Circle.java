package fr.unice.polytech.si3.qgl.zecommit.shape;


/**
 * Forme definissant un cercle
 * @author  Clement P
 */
public class Circle extends Shape {
    private double radius;


    public Circle(double radius){
        super(ShapeType.circle.toString());

        this.radius=radius;
        setCircle(true);
        setRectangle(false);
    }

    @Override
    public String toString() {
        return  "type : "+super.getType()+
                " [ radius : "+this.radius+" ] ";
    }

    //--------------------GETTER -------------------------//

    /**
     * Getter du rayon du cercle
     * @return radius
     */
    public double getRadius() {
        return radius;
    }

    //--------------------SETTER -------------------------//

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
