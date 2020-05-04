package fr.unice.polytech.si3.qgl.zecommit.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import fr.unice.polytech.si3.qgl.zecommit.other.Wind;

import java.io.IOException;

/**
 * Classe de deserialisation du vent
 */
public class WindDeserializer extends StdDeserializer {
    public WindDeserializer(Class vc) {
        super(vc);
    }
    public WindDeserializer() {
        this(null);
    }

    @Override
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);

        return new Wind(node.get("orientation").asDouble(), node.get("strength").asDouble());
    }
}
