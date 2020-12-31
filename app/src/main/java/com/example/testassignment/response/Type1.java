package com.example.testassignment.response;

import com.example.testassignment.model.TypeB;

import java.util.List;

public class Type1 {

    private List<TypeB> items;

    private String title;
    private String type;

    public List<TypeB> getItems() {
        return items;
    }

    public void setItems(List<TypeB> items) {
        this.items = items;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
