package fr.unice.polytech.si3.qgl.zecommit.other;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import fr.unice.polytech.si3.qgl.zecommit.deserializer.CheckpointsDeserializer;

import java.util.List;

/**
 * Classe correspondant à la liste des checkpoints
 */
@JsonDeserialize(using = CheckpointsDeserializer.class)
public class Checkpoints {

    List<Checkpoint> myCheckpoints;

    public Checkpoints(List<Checkpoint> checkpoints) {
        this.myCheckpoints = checkpoints;
    }

    public List<Checkpoint> getCheckpoints() {
        return myCheckpoints;
    }

    public void setCheckpoints(List<Checkpoint> checkpoints) {
        this.myCheckpoints = checkpoints;
    }
}
