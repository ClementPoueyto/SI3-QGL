package fr.unice.polytech.si3.qgl.zecommit.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import fr.unice.polytech.si3.qgl.zecommit.boat.Ship;
import fr.unice.polytech.si3.qgl.zecommit.crew.Sailor;
import fr.unice.polytech.si3.qgl.zecommit.goal.Goal;
import fr.unice.polytech.si3.qgl.zecommit.parser.InitGame;

import java.io.IOException;
import java.util.List;

/**
 * Classe de deserialisation de l'initGame
 */
public class InitGameDeserializer extends StdDeserializer<InitGame> {
    protected InitGameDeserializer(Class vc) {
        super(vc);
    }
    public InitGameDeserializer() {
        this(null);
    }

    @Override
    public InitGame deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        ObjectCodec codec = jsonParser.getCodec();
        JsonNode node = codec.readTree(jsonParser);

        Goal goal = objectMapper.readValue(node.get("goal").toPrettyString(), Goal.class);
        Ship ship = objectMapper.readValue(node.get("ship").toPrettyString(), Ship.class);
        List<Sailor> sailors = objectMapper.readValue(node.get("sailors").toPrettyString(), new TypeReference<>() {});

        if (node.has("shipCount")) {
            int shipCount = node.get("shipCount").asInt();
            return new InitGame(goal, ship, sailors, shipCount);
            }
        else {
            return new InitGame(goal, ship, sailors, 0);
        }

    }
}
