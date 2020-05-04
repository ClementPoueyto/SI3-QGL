package fr.unice.polytech.si3.qgl.zecommit.deserializer;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import fr.unice.polytech.si3.qgl.zecommit.shape.*;

import java.io.IOException;

/**
 * Classe de deserialisation des formes
 */
@JsonDeserialize(using = ShapeDeserializer.class)
public class ShapeDeserializer extends JsonDeserializer {

    public ShapeDeserializer(Class<?> vc) {super();}
    public ShapeDeserializer(){
        this(null);
    }


    @Override

    public Shape deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        ObjectCodec codec = jsonParser.getCodec();
        JsonNode nodeShape = codec.readTree(jsonParser);

        String type = nodeShape.get("type").asText();

        if (type.equals("circle")) {
             return new Circle(nodeShape.get("radius").asDouble());
        }

        else if (type.equals("rectangle")) {
            return new Rectangle(nodeShape.get("width").asDouble(), nodeShape.get("height").asDouble(), nodeShape.get("orientation").asDouble());
        }

        else {
            Point[] points = objectMapper.readValue(nodeShape.get("vertices").toPrettyString(), new TypeReference<>() {
            });
            return new Polygone(nodeShape.get("orientation").asDouble(), points);
        }

    }
}

