package fr.unice.polytech.si3.qgl.zecommit.shape;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.unice.polytech.si3.qgl.zecommit.boat.Position;

/**
 * Classe définissant un polygone
 * @author clement
 * @author Nathan
 */
public class Polygone extends Shape {

    protected double orientation;
    protected Point[] vertices;


    public Polygone(double orientation,Point[] vertices) {
        super(ShapeType.polygon.toString());
        setCircle(false);
        setRectangle(false);
        this.orientation=orientation;
        this.vertices=vertices;
    }


    /////////////////////////////// GETTER //////////////////////////////


    public double getOrientation() {
        return orientation;
    }


    public Point[] getVertices() {
        return vertices;
    }


    @JsonIgnore
    public Point getRelativeVertice(int index, Position position){
        return getRelativeVerticeList(position)[index];
    }

    @JsonIgnore
    public Point[] getRelativeVerticeList(Position position){
        int i;
        double t;
        double v;
        int n = vertices.length;
        Point[] rotateVertices = new Point[n];
        Point centre = new Point(position.getX(), position.getY());
        double xp = centre.getX();
        double yp = centre.getY();
        double radian = getShapeOrientation();
        double xRotate;
        double yRotate;
        for(i=0;i<n;i++) {
            t=vertices[i].getX();
            v=vertices[i].getY();
            xRotate=(xp+t*Math.cos(radian)-v*Math.sin(radian));
            yRotate=(yp+v*Math.cos(radian)+t*Math.sin(radian));
            rotateVertices[i]=new Point(xRotate, yRotate);
        }
        return  rotateVertices;
    }


    @JsonIgnore
    public int[] getVerticesIntX(Position position){
        int[] x= new int[this.vertices.length];
        for (int i=0; i<this.vertices.length;i++) {
            x[i]=(int)getRelativeVertice(i, position).getX();

        }
        return x;
    }
    @JsonIgnore
    public int[] getVerticesIntY(Position position){
        int[] y= new int[this.vertices.length];
        for (int i=0; i<this.vertices.length;i++) {
            y[i]=(int)getRelativeVertice(i, position).getY();
        }
        return y;
    }

    @JsonIgnore
    public double getRadius() {
        double max = 0;
        int nbVertices = vertices.length;
        for (int i = 0; i < nbVertices; i++) {
            int k = vertices.length/2;
            double distance = vertices[i].distanceTo(vertices[(i+1+k)%nbVertices]);
            if(max < distance)
                max = distance;
        }
        return max/2;
    }

    /**
     * méthode déterminant le barycentre d'un polygone
     * @return Point : le barycentre du polygone
     */
    @JsonIgnore
    public Point calculateCentroid() {
        double x = 0;
        double y = 0;
        int pointCount = vertices.length;
        for (int i = 0;i < pointCount;i++){
            Point point = vertices[i];
            x += point.getX();
            y += point.getY();
        }

        x = x/pointCount;
        y = y/pointCount;

        return new Point(x, y);
    }

    public void setOrientation(double orientation) {
        this.orientation = orientation;
    }
}
