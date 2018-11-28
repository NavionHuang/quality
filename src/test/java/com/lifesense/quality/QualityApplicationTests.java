package com.lifesense.quality;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lifesense.quality.domain.ProcessFlow;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class QualityApplicationTests {

    public static void main(String[] args) {
        String json = "{\"json\":[{\"sn\":\"CG000001\",\"productLine\":\"A1\",\"processCode\":\"T06\",\"result\":\"NG\",\"data\":null},{\"sn\":\"CG000002\",\"productLine\":\"A1\",\"processCode\":\"T06\",\"result\":\"NG\",\"data\":{\"n1\":\"50.1\",\"n2\":\"50.2\",\"n3\":\"50.3\"}}]}";
        JsonElement parse = new JsonParser().parse(json);
        System.out.println(parse.isJsonArray());
        System.out.println(parse.isJsonObject());
        System.out.println(parse.isJsonNull());
        JsonObject jsonObject = parse.getAsJsonObject();
        JsonElement json1 = jsonObject.get("json");
        System.out.println(json1.isJsonArray());
        System.out.println(json1.isJsonObject());
        System.out.println(json1.isJsonNull());
    }
}
