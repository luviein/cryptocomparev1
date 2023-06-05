package com.example.cryptocompareapi.model;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class Data implements Serializable {
    private List<NewsInfo> newsInfo = new LinkedList<>();

    public static Data createJSON(String json) throws IOException {
        var data = new Data();
        try(InputStream is = new ByteArrayInputStream(json.getBytes())){
            JsonReader r = Json.createReader(is);
            JsonObject o = r.readObject();
            data.newsInfo = o.getJsonArray("Data")
                .stream()
                .map(v -> (JsonObject) v)
                .map(v -> NewsInfo.createJSONObject(v))
                .toList()
                ;



        }
        return data;
        
    }


}
