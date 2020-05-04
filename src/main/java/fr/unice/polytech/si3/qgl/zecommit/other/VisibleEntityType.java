package fr.unice.polytech.si3.qgl.zecommit.other;

/**
 * Enum des différentes visibleEntities
 */
public enum VisibleEntityType{
    stream,ship,reef; //en miniscule sinon problème lors de la création du JSON par le moteur


    @Override
    public String toString(){
        return this.name().toLowerCase();
    }
}
