package com.example.cryptocompareapi.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.cryptocompareapi.model.Data;
import com.example.cryptocompareapi.service.NewsService;



@Controller
public class NewsController {

    @Autowired
    private NewsService newsSvc;
    
    @GetMapping(path="/")
    public String getNews(Model m) throws IOException{
        List<Data> news = newsSvc.getArticles();
        System.out.println("news ---->" + Arrays.toString(news.toArray()));
        m.addAttribute("latestNews", news);
        return "news";
    }
}
