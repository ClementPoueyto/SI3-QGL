package fr.unice.polytech.si3.qgl.zecommit.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import fr.unice.polytech.si3.qgl.zecommit.entite.*;

import java.io.IOException;

/**
 * Classe de deserialisation des entités
 */
public class EntityDeserializer extends JsonDeserializer {


    @Override
    public Entity deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {


        ObjectCodec codec = jsonParser.getCodec();
        JsonNode nodeEntities = codec.readTree(jsonParser);

        String type = nodeEntities.get("type").asText();

        switch (type) {
            case "oar" :
                return new Oar(nodeEntities.get("x").asInt(), nodeEntities.get("y").asInt());

            case "sail" :
                return new Sail(nodeEntities.get("x").asInt(), nodeEntities.get("y").asInt(), nodeEntities.get("openned").asBoolean());

            case "rudder" :
                return new Rudder(nodeEntities.get("x").asInt(),nodeEntities.get("y").asInt());

            case "watch" :
                return new Watch(nodeEntities.get("x").asInt(), nodeEntities.get("y").asInt());
            case "canon":
                return new Canon(nodeEntities.get("x").asInt(), nodeEntities.get("y").asInt(), nodeEntities.get("loaded").asBoolean(), nodeEntities.get("angle").asDouble());

            default :
                return null;

        }
    }
}


