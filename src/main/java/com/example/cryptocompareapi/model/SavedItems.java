package com.example.cryptocompareapi.model;

import java.io.Serializable;
import java.util.List;

public class SavedItems implements Serializable {
    private List<String> selectedItems;
    public List<String> getSelectedItems() {
        return selectedItems;
    }

    public void setSelectedItems(List<String> selectedItems) {
        this.selectedItems = selectedItems;
    }
    

}  


