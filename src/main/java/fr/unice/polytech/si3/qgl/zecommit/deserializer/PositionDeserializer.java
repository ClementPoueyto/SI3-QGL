package fr.unice.polytech.si3.qgl.zecommit.deserializer;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import fr.unice.polytech.si3.qgl.zecommit.boat.Position;

import java.io.IOException;

/**
 * Classe de deserialisation des Positions
 */
public class PositionDeserializer extends JsonDeserializer {

    @Override
    public Position deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);
        return new Position(node.get("x").asDouble(), node.get("y").asDouble(), node.get("orientation").asDouble());
    }
}
