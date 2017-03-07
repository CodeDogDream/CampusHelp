package com.dream.work.utils;

import com.google.gson.*;

/**
 * Created by Dream on 2017/3/5.
 */
public class ResponseUtils {
    private static Gson gson = new GsonBuilder().create();
    private static JsonParser jsonParser = new JsonParser();

    public static String getBasicResponse(JsonElement data) {
        JsonObject object = new JsonObject();
        object.addProperty("code", 0);
        object.addProperty("msg", "success");
        object.add("data", data);
        return object.toString();
    }

    public static String getErrorResponseJson(String msg) {
        JsonObject object = new JsonObject();
        object.addProperty("error", msg);
        return object.toString();
    }

    public static <T> String getSuccessResponse(T t) {
        JsonElement jsonElement = jsonParser.parse(gson.toJson(t));
        return getBasicResponse(jsonElement);
    }

}
