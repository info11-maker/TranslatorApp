package com.example.translatorapp.model;

import com.google.gson.Gson;

import java.util.ArrayList;

public class Word {
    public String word;
    public String word_en;
    public String type;
    public ArrayList<String> singular;
    public ArrayList<String> plural;
    public ArrayList<Definition> definitions;

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}