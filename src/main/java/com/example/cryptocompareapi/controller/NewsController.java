package com.example.cryptocompareapi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.cryptocompareapi.model.Data;
import com.example.cryptocompareapi.model.SavedItems;
import com.example.cryptocompareapi.model.SavedItems.NewsInfo;
import com.example.cryptocompareapi.service.NewsService;



@Controller
public class NewsController {

    @Autowired
    private NewsService newsSvc;
    
    @GetMapping(path="/")
    public String getNews(Model m) throws IOException{
        List<Data> news = newsSvc.getArticles();
        m.addAttribute("latestNews", news);
        m.addAttribute("saveditems", new SavedItems());
        return "news";
    }

    @PostMapping(path="/articles")
    public String saveArticles(@ModelAttribute("savedItems") SavedItems savedItems, Model m) throws IOException{
        List<String> selectedNews = savedItems.getSelectedItems();
        List<String> selectedItems = new ArrayList<>();
    
        // for (SavedItems.NewsInfo newsInfo : selectedNews) {
        //     String item = newsInfo.getId() + "," +
        //                   newsInfo.getPublished_on() + "," +
        //                   newsInfo.getTitle() + "," +
        //                   newsInfo.getUrl() + "," +
        //                   newsInfo.getImageURL() + "," +
        //                   newsInfo.getBody() + "," +
        //                   newsInfo.getTags() + "," +
        //                   newsInfo.getCategories();
    
        //     selectedItems.add(item);
        // }
        savedItems.setSelectedItems(selectedItems);
        m.addAttribute("savedItems", savedItems);
        System.out.println("selected news-----> " + selectedNews);

        return "articles";
    }
}
