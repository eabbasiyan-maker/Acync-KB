package com.async.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Created by h.mehrara on 1/28/2015.
 */
public class JsonUtil {
    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    private static final ObjectMapper mapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true)
            .setSerializationInclusion(JsonInclude.Include.NON_NULL);

    public static String getJson(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            logger.warn("An exception occurred", e);
            throw new RuntimeException(e);
        }
    }

    public static <T> T getObject(byte[] json, Class<T> classOfT) {
        try {
            return mapper.readValue(new String(json, StandardCharsets.UTF_8), classOfT);
        } catch (IOException e) {
            logger.warn("An exception occurred", e);
            throw new RuntimeException(e);
        }
    }

    public static <T> T getObject(String json, Class<T> classOfT) {
        try {
//            logger.debug("classOfT = {}", classOfT);
//            if (json.length() > 15) {
//                logger.warn(classOfT.getSimpleName() + " - json = " + json);
//            }
            return mapper.readValue(json, classOfT);
        } catch (IOException e) {
            logger.warn("An exception occurred " + json, e);
            throw new RuntimeException(e);
        }
    }

    public static <T> T getObject(String json, TypeReference<T> typeReference) {
        try {
//            logger.info("type = " + type);
//            logger.warn("json = " + json);
            return mapper.readValue(json, typeReference);
        } catch (IOException e) {
            logger.warn("An exception occurred", e);
            throw new RuntimeException(e);
        }
    }

    public static JsonNode getJsonObject(String json) {
        try {
//            logger.warn("json = " + json);
            return json == null ? null : mapper.readTree(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static JsonNode getJsonObject(File jsonFile) {
        try {
            return jsonFile != null && jsonFile.exists() ? mapper.readTree(jsonFile) : null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeJsonObjectToFile(JsonNode jsonNode, File jsonFile) {
        try {
            if (jsonFile != null && jsonNode != null) {
                 mapper.writeValue(jsonFile, jsonNode);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println();
/*
        JsonElement jsonObject = getJsonObject("{\"type\":5,\"content\":\"{\\\"peerName\\\":null,\\\"receivers\\\":[1686533],\\\"collapseId\\\":0,\\\"groupId\\\":0,\\\"index\\\":0,\\\"messageId\\\":11565248,\\\"ttl\\\":60000,\\\"content\\\":\\\"{\\\\\\\"type\\\\\\\":5,\\\\\\\"content\\\\\\\":\\\\\\\"{\\\\\\\\\\\\\\\"id\\\\\\\\\\\\\\\":5,\\\\\\\\\\\\\\\"name\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"علی\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"applicant\\\\\\\\\\\\\\\":true,\\\\\\\\\\\\\\\"gameId\\\\\\\\\\\\\\\":2,\\\\\\\\\\\\\\\"leagueId\\\\\\\\\\\\\\\":3,\\\\\\\\\\\\\\\"matchId\\\\\\\\\\\\\\\":1114945,\\\\\\\\\\\\\\\"opponentData\\\\\\\\\\\\\\\":{\\\\\\\\\\\\\\\"id\\\\\\\\\\\\\\\":80682,\\\\\\\\\\\\\\\"name\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"★߅ℳɨの\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"sessionId\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"1686548\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"image\\\\\\\\\\\\\\\":{\\\\\\\\\\\\\\\"id\\\\\\\\\\\\\\\":3285,\\\\\\\\\\\\\\\"name\\\\\\\\\\\\\\\":null,\\\\\\\\\\\\\\\"description\\\\\\\\\\\\\\\":null,\\\\\\\\\\\\\\\"actualWidth\\\\\\\\\\\\\\\":512,\\\\\\\\\\\\\\\"actualHeight\\\\\\\\\\\\\\\":512,\\\\\\\\\\\\\\\"width\\\\\\\\\\\\\\\":512,\\\\\\\\\\\\\\\"height\\\\\\\\\\\\\\\":512,\\\\\\\\\\\\\\\"hashCode\\\\\\\\\\\\\\\":null},\\\\\\\\\\\\\\\"rank\\\\\\\\\\\\\\\":{\\\\\\\\\\\\\\\"playerID\\\\\\\\\\\\\\\":80682,\\\\\\\\\\\\\\\"played\\\\\\\\\\\\\\\":1488,\\\\\\\\\\\\\\\"field1\\\\\\\\\\\\\\\":2948,\\\\\\\\\\\\\\\"field2\\\\\\\\\\\\\\\":18260,\\\\\\\\\\\\\\\"field3\\\\\\\\\\\\\\\":46318,\\\\\\\\\\\\\\\"field4\\\\\\\\\\\\\\\":28058,\\\\\\\\\\\\\\\"field5\\\\\\\\\\\\\\\":976,\\\\\\\\\\\\\\\"field6\\\\\\\\\\\\\\\":492,\\\\\\\\\\\\\\\"field7\\\\\\\\\\\\\\\":20,\\\\\\\\\\\\\\\"rank\\\\\\\\\\\\\\\":37,\\\\\\\\\\\\\\\"playerName\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"★߅ℳɨの\\\\\\\\\\\\\\\"}},\\\\\\\\\\\\\\\"sessionId\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"1686533\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"packageName\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"com.nozhaco.reversi\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"requestId\\\\\\\\\\\\\\\":4941671,\\\\\\\\\\\\\\\"isQuick\\\\\\\\\\\\\\\":false,\\\\\\\\\\\\\\\"leagueName\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"اتللو\\\\\\\\\\\\\\\",\\\\\\\\\\\\\\\"image\\\\\\\\\\\\\\\":{\\\\\\\\\\\\\\\"id\\\\\\\\\\\\\\\":1265,\\\\\\\\\\\\\\\"name\\\\\\\\\\\\\\\":null,\\\\\\\\\\\\\\\"description\\\\\\\\\\\\\\\":null,\\\\\\\\\\\\\\\"actualWidth\\\\\\\\\\\\\\\":679,\\\\\\\\\\\\\\\"actualHeight\\\\\\\\\\\\\\\":905,\\\\\\\\\\\\\\\"width\\\\\\\\\\\\\\\":679,\\\\\\\\\\\\\\\"height\\\\\\\\\\\\\\\":905,\\\\\\\\\\\\\\\"hashCode\\\\\\\\\\\\\\\":null},\\\\\\\\\\\\\\\"rank\\\\\\\\\\\\\\\":{\\\\\\\\\\\\\\\"playerID\\\\\\\\\\\\\\\":5,\\\\\\\\\\\\\\\"played\\\\\\\\\\\\\\\":424,\\\\\\\\\\\\\\\"field1\\\\\\\\\\\\\\\":469,\\\\\\\\\\\\\\\"field2\\\\\\\\\\\\\\\":-766,\\\\\\\\\\\\\\\"field3\\\\\\\\\\\\\\\":6570,\\\\\\\\\\\\\\\"field4\\\\\\\\\\\\\\\":7361,\\\\\\\\\\\\\\\"field5\\\\\\\\\\\\\\\":155,\\\\\\\\\\\\\\\"field6\\\\\\\\\\\\\\\":265,\\\\\\\\\\\\\\\"field7\\\\\\\\\\\\\\\":4,\\\\\\\\\\\\\\\"rank\\\\\\\\\\\\\\\":244,\\\\\\\\\\\\\\\"playerName\\\\\\\\\\\\\\\":\\\\\\\\\\\\\\\"علی\\\\\\\\\\\\\\\"}}\\\\\\\"}\\\",\\\"priority\\\":0}\"}");
        System.out.println(jsonObject);
        jsonObject = getJsonObject(jsonObject.getAsJsonObject().get("content").getAsString());
        System.out.println(jsonObject);
        jsonObject = getJsonObject(jsonObject.getAsJsonObject().get("content").getAsString());
        System.out.println(jsonObject);
        jsonObject = getJsonObject(jsonObject.getAsJsonObject().get("content").getAsString());
        System.out.println(jsonObject);
*/
    }
}
