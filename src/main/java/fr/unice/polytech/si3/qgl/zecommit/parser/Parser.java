package fr.unice.polytech.si3.qgl.zecommit.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Classe appelant les différents parser
 */
public class Parser {
    Parser() {
        //constructeur vide
    }

    /**
     * Parse le json d'initialisation (string) en objet
     * @param jsonString
     * @return
     * @throws JsonProcessingException
     */
    public static InitGame parseInitGame(String jsonString) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return mapper.readValue(jsonString, InitGame.class);
    }

    /**
     * Parse le json de chaque Round en objet
     * @param jsonString
     * @return
     * @throws JsonProcessingException
     */
    public static NextRound parseNextRound(String jsonString) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return mapper.readValue(jsonString, NextRound.class);
    }


}
