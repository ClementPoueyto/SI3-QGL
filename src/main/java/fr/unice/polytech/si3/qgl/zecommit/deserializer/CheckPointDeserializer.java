package fr.unice.polytech.si3.qgl.zecommit.deserializer;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import fr.unice.polytech.si3.qgl.zecommit.boat.Position;
import fr.unice.polytech.si3.qgl.zecommit.other.Checkpoint;
import fr.unice.polytech.si3.qgl.zecommit.shape.Shape;

import java.io.IOException;

/**
 * Classe de deserialisation d'un Checkpoint
 */
public class CheckPointDeserializer extends StdDeserializer<Checkpoint> {

    protected CheckPointDeserializer(Class<?> vc) {
        super(vc);
    }
    public CheckPointDeserializer() {
        this(null);
    }

    @Override
    public Checkpoint deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);

        Position position = objectMapper.readValue(node.get("position").toPrettyString(), Position.class);
        Shape shape = objectMapper.readValue(node.get("shape").toPrettyString(), Shape.class);

        return new Checkpoint(position, shape);
    }
}
