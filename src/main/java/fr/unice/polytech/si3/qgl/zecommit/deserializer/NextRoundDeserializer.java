package fr.unice.polytech.si3.qgl.zecommit.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import fr.unice.polytech.si3.qgl.zecommit.boat.Ship;
import fr.unice.polytech.si3.qgl.zecommit.other.VisibleEntitie;
import fr.unice.polytech.si3.qgl.zecommit.other.Wind;
import fr.unice.polytech.si3.qgl.zecommit.parser.NextRound;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de deserialisation des NextRound
 */
public class NextRoundDeserializer extends StdDeserializer<NextRound> {
    protected NextRoundDeserializer(Class<?> vc) {
        super(vc);
    }
    public NextRoundDeserializer() {
        this(null);
    }

    @Override
    public NextRound deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        ObjectCodec codec = jsonParser.getCodec();
        JsonNode node = codec.readTree(jsonParser);

        Ship ship = objectMapper.readValue(node.get("ship").toPrettyString(), Ship.class);

        List<VisibleEntitie> visibleEntities = new ArrayList<>();
        if (node.has("visibleEntities")) {
            visibleEntities = objectMapper.readValue(node.get("visibleEntities").toPrettyString(), new TypeReference<>() {
            });
        }

        if (node.has("wind")) {
            Wind wind = objectMapper.readValue(node.get("wind").toPrettyString(), Wind.class);
            return new NextRound(ship, visibleEntities, wind);
        }
        else {
            Wind wind = new Wind(0,0);
            return new NextRound(ship, visibleEntities, wind);
        }
    }
}
