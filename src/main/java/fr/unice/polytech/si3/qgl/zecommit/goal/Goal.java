package fr.unice.polytech.si3.qgl.zecommit.goal;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import fr.unice.polytech.si3.qgl.zecommit.deserializer.GoalDeserializer;

/**
 * Classe correspondant au mode de jeu
 */
@JsonDeserialize(using = GoalDeserializer.class)
public abstract class Goal {

    private String mode;
    private boolean isRegatta;

    public Goal(String mode){
        this.mode = mode;
    }

    @Override
    public String toString() {
        return this.mode;
    }

    @JsonIgnore
    public boolean isRegatta(){
        return this.isRegatta;
    }



    //------------------------------GETTER-------------------------//

    public String getMode() {
        return mode;
    }


    //------------------------------SETTER-------------------------//


    public void setMode(String mode) {
        this.mode = mode;
    }

    public void setRegatta(boolean regatta) {
        isRegatta = regatta;
    }
}
