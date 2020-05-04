package fr.unice.polytech.si3.qgl.zecommit;

import fr.unice.polytech.si3.qgl.zecommit.action.*;
import fr.unice.polytech.si3.qgl.zecommit.crew.Sailor;
import fr.unice.polytech.si3.qgl.zecommit.parser.Output;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class OutputTest {
    Output s;
    ArrayList<Action> actions;
    Sailor s2 = new Sailor(2, 0, 0, "Mousson");

    @Test
    void afficheSortieTest() {
        String resultString = "[{\"sailorId\":1,\"type\":\"OAR\"},"+
        "{\"sailorId\":2,\"type\":\"MOVING\",\"xdistance\":3,\"ydistance\":2},"+
        "{\"sailorId\":3,\"type\":\"LIFT_SAIL\"},"+
        "{\"sailorId\":4,\"type\":\"LOWER_SAIL\"},"+
        "{\"sailorId\":5,\"type\":\"TURN\",\"rotation\":0.0},"+
        "{\"sailorId\":6,\"type\":\"USE_WATCH\"}]";
        s = new Output();
        Action o1 = new ToOar(1);
        Action o2 = new Moving(s2.getId(), 3, 4);
        Action o3 = new LiftSail(3);
        Action o4 = new LowerSail(4);
        Action o5 = new Turn(5, 3.5);
        Action o6 = new UseWatch(6);
        List<Action> actions = List.of(o1, o2, o3, o4, o5, o6);
        assertEquals(resultString, s.afficheRound(actions));

    }
}
