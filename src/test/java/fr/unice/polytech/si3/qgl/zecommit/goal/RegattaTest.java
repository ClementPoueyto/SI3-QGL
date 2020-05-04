package fr.unice.polytech.si3.qgl.zecommit.goal;

import fr.unice.polytech.si3.qgl.zecommit.other.Checkpoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class RegattaTest {
    Checkpoint cp1;
    Checkpoint cp2;
    List<Checkpoint> checkpoints;
    Regatta reg;

    @BeforeEach
    void setUp() {
        cp1 = mock(Checkpoint.class);
        cp2 = mock(Checkpoint.class);
        checkpoints = new ArrayList<>();
        checkpoints.add(cp1);
        checkpoints.add(cp2);

        reg = new Regatta(checkpoints);
    }

    @Test
    void getFirstCheckpoint() {
        assertEquals(reg.getFirstCheckpoint(), cp1);
    }
}
