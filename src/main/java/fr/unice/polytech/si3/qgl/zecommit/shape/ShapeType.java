package fr.unice.polytech.si3.qgl.zecommit.shape;

/**
 * Enum des différentes formes
 */
public enum ShapeType {
        rectangle,circle,polygon;

        @Override
        public String toString(){
            return this.name().toLowerCase();
        }

}
