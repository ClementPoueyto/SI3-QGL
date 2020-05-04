package fr.unice.polytech.si3.qgl.zecommit.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import fr.unice.polytech.si3.qgl.zecommit.other.Checkpoint;
import fr.unice.polytech.si3.qgl.zecommit.other.Checkpoints;

import java.io.IOException;
import java.util.List;

public
/**
 * Classe de deserialisation des Checkpoints
 */
class CheckpointsDeserializer extends StdDeserializer<Checkpoints> {


    protected CheckpointsDeserializer(Class<?> vc) {
        super(vc);
    }
    public CheckpointsDeserializer() {
        this(null);
    }


    @Override
    public Checkpoints deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        ObjectCodec codec = jsonParser.getCodec();
        JsonNode node = codec.readTree(jsonParser);

        List<Checkpoint> checkpoints = objectMapper.readValue(node.get("checkpoints").toPrettyString(), new TypeReference<>() {});

        return new Checkpoints(checkpoints);
    }
}
