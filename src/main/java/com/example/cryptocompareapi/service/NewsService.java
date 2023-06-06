package com.example.cryptocompareapi.service;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.cryptocompareapi.model.Data;
import com.example.cryptocompareapi.model.NewsInfo;

import jakarta.json.Json;

@Service
public class NewsService {

    @Autowired
    private RedisTemplate<String, Object> template;

    @Value("${crypto.compare.url}")
    private String cryptoCompareAPIUrl;
    @Value("${crypto.compare.key}")
    private String cryptoCompareAPIKey;
    
    public List<Data> getArticles() throws IOException{
        String newsURL = UriComponentsBuilder.fromUriString(cryptoCompareAPIUrl)
            .queryParam("appId", cryptoCompareAPIKey)
            .toUriString();


        RestTemplate template = new RestTemplate();
        ResponseEntity<String> res = template.getForEntity(newsURL, String.class);
        Data d =  Data.createJSON(res.getBody());
        if(d != null){
            List<Data> dataList = new LinkedList<>();
            dataList.add(d);
            return dataList;
        }
        return Collections.emptyList();
    }

    public void saveArticles(List<String> savedItems){

            template.opsForValue().set("test", savedItems.toString());

        
    }

}
