package fr.unice.polytech.si3.qgl.zecommit.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import fr.unice.polytech.si3.qgl.zecommit.crew.Sailor;

import java.io.IOException;

/**
 * Classe de deserialisation des marins
 */
public class SailorDeserializer extends StdDeserializer {
    public SailorDeserializer(Class vc) {
        super(vc);
    }
    public SailorDeserializer() {
        this(null);
    }

    @Override
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);

        return new Sailor(node.get("id").asInt(), node.get("x").asInt(), node.get("y").asInt(), node.get("name").asText());
    }
}
