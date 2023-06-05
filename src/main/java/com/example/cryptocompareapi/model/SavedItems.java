package com.example.cryptocompareapi.model;

import java.io.Serializable;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class SavedItems implements Serializable {
    private List<String> selectedItems;
    public List<String> getSelectedItems() {
        return selectedItems;
    }

    public void setSelectedItems(List<String> selectedItems) {
        this.selectedItems = selectedItems;
    }

    
    public static class NewsInfo {
        private String id;
        private Long published_on;
        private String title;
        private String url;
        private String imageURL;
        private String body;
        private String tags;
        private String categories;
        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        public Long getPublished_on() {
            return published_on;
        }
        public void setPublished_on(Long published_on) {
            this.published_on = published_on;
        }
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public String getUrl() {
            return url;
        }
        public void setUrl(String url) {
            this.url = url;
        }
        public String getImageURL() {
            return imageURL;
        }
        public void setImageURL(String imageURL) {
            this.imageURL = imageURL;
        }
        public String getBody() {
            return body;
        }
        public void setBody(String body) {
            this.body = body;
        }
        public String getTags() {
            return tags;
        }
        public void setTags(String tags) {
            this.tags = tags;
        }
        public String getCategories() {
            return categories;
        }
        public void setCategories(String categories) {
            this.categories = categories;
        }
        @Override
        public String toString() {
            return "NewsInfo [id=" + id + ", published_on=" + published_on + ", title=" + title + ", url=" + url
                    + ", imageURL=" + imageURL + ", body=" + body + ", tags=" + tags + ", categories=" + categories
                    + "]";
        }
       
        
    
    
    }

}