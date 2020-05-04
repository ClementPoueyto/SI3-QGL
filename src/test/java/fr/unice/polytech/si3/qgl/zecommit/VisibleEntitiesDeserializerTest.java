package fr.unice.polytech.si3.qgl.zecommit;

import com.fasterxml.jackson.core.JsonProcessingException;
import fr.unice.polytech.si3.qgl.zecommit.boat.Position;
import fr.unice.polytech.si3.qgl.zecommit.other.Stream;
import fr.unice.polytech.si3.qgl.zecommit.other.VisibleEntitie;
import fr.unice.polytech.si3.qgl.zecommit.parser.NextRound;
import fr.unice.polytech.si3.qgl.zecommit.parser.Parser;
import fr.unice.polytech.si3.qgl.zecommit.shape.Rectangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VisibleEntitiesDeserializerTest {
    String json1;


    @BeforeEach
    void setUp() {
        json1 = "{\n" +
                "  \"ship\" : {\n" +
                "    \"type\" : \"ship\",\n" +
                "    \"life\" : 100,\n" +
                "    \"position\" : {\n" +
                "      \"x\" : 398.0628515078238,\n" +
                "      \"y\" : 1494.181057996063,\n" +
                "      \"orientation\" : -2.3561944901923177\n" +
                "    },\n" +
                "    \"name\" : \"ZECOMMIT\",\n" +
                "    \"deck\" : {\n" +
                "      \"width\" : 5,\n" +
                "      \"length\" : 11\n" +
                "    },\n" +
                "    \"entities\" : [ {\n" +
                "      \"type\" : \"oar\",\n" +
                "      \"x\" : 1,\n" +
                "      \"y\" : 0\n" +
                "    }, {\n" +
                "      \"type\" : \"oar\",\n" +
                "      \"x\" : 2,\n" +
                "      \"y\" : 0\n" +
                "    }, {\n" +
                "      \"type\" : \"oar\",\n" +
                "      \"x\" : 1,\n" +
                "      \"y\" : 4\n" +
                "    }, {\n" +
                "      \"type\" : \"oar\",\n" +
                "      \"x\" : 2,\n" +
                "      \"y\" : 4\n" +
                "    }, {\n" +
                "      \"type\" : \"rudder\",\n" +
                "      \"x\" : 10,\n" +
                "      \"y\" : 4\n" +
                "    }, {\n" +
                "      \"type\" : \"sail\",\n" +
                "      \"x\" : 5,\n" +
                "      \"y\" : 2,\n" +
                "      \"openned\" : false\n" +
                "    } ],\n" +
                "    \"shape\" : {\n" +
                "      \"type\" : \"rectangle\",\n" +
                "      \"width\" : 5.0,\n" +
                "      \"height\" : 11.0,\n" +
                "      \"orientation\" : 0.0\n" +
                "    }\n" +
                "  },\n" +
                "  \"visibleEntities\" : [ {\n" +
                "    \"position\" : {\n" +
                "      \"x\" : 0.0,\n" +
                "      \"y\" : 100.0,\n" +
                "      \"orientation\" : 0.0\n" +
                "    },\n" +
                "    \"shape\" : {\n" +
                "      \"type\" : \"rectangle\",\n" +
                "      \"width\" : 100.0,\n" +
                "      \"height\" : 50.0,\n" +
                "      \"orientation\" : 0.0\n" +
                "    },\n" +
                "    \"type\" : \"stream\",\n" +
                "    \"strength\" : 100.0\n" +
                "  } ],\n" +
                "  \"wind\" : {\n" +
                "    \"orientation\" : 7.0,\n" +
                "    \"strength\" : 89.0\n" +
                "  }\n" +
                "}";
    }

    @Test
    void streamTest() throws JsonProcessingException {
        NextRound nextRound = Parser.parseNextRound(json1);
        List<VisibleEntitie> visibleEntities = nextRound.getVisibleEntities();
        Stream stream = new Stream(new Position(0,100,0), new Rectangle(100,50,0),100);
        assertEquals(visibleEntities.get(0), stream);
    }


}
