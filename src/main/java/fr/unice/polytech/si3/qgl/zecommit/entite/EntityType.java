package fr.unice.polytech.si3.qgl.zecommit.entite;

/**
 * Enum des différentes entités présentes sur le bateau
 */
public enum EntityType{
    oar,rudder,sail,watch, canon; //en miniscule sinon problème lors de la création du JSON par le moteur


    @Override
    public String toString(){
        return this.name().toLowerCase();
    }
}
