package fr.unice.polytech.si3.qgl.zecommit.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import fr.unice.polytech.si3.qgl.zecommit.boat.Deck;
import fr.unice.polytech.si3.qgl.zecommit.boat.Position;
import fr.unice.polytech.si3.qgl.zecommit.boat.Ship;
import fr.unice.polytech.si3.qgl.zecommit.entite.Entity;
import fr.unice.polytech.si3.qgl.zecommit.shape.Shape;

import java.io.IOException;
import java.util.List;
/**
 * Classe de deserialisation du bateau
 */
@JsonDeserialize(using = ShipDeserializer.class)
public class ShipDeserializer extends JsonDeserializer {

    @Override
    public Ship deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);

        Position position = objectMapper.readValue(node.get("position").toPrettyString(), Position.class);

        Deck deck = objectMapper.readValue(node.get("deck").toPrettyString(), Deck.class);

        List<Entity> listEntitie = objectMapper.readValue(node.get("entities").toPrettyString(), new TypeReference<>() {});

        Shape shape = objectMapper.readValue(node.get("shape").toPrettyString(), Shape.class);

        return new Ship(node.get("type").asText(), node.get("life").asInt(), position, node.get("name").asText(), deck, listEntitie, shape);
    }
}
