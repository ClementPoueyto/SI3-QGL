package fr.unice.polytech.si3.qgl.zecommit.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import fr.unice.polytech.si3.qgl.zecommit.boat.Deck;

import java.io.IOException;

/**
 * Classe de deserialisation du deck
 */
public class DeckDeserializer extends JsonDeserializer {

    @Override
    public Deck deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);
        return new Deck(node.get("width").asInt(), node.get("length").asInt());
    }
}


