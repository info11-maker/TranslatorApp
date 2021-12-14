package com.example.translatorapp.repository;

import com.example.translatorapp.model.Definition;
import com.example.translatorapp.model.Word;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TranslatorRepository {
    private Gson gson = new Gson();

    public String translateWord(String s, String word){
        String fileName = "src/main/resources/translations/"  + word + ".json";

        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(fileName));
            Word wordModel = gson.fromJson(reader, Word.class);
            reader.close();
            return wordModel.toString();
        } catch (Exception e) {
            return "word not found";
        }
    }

    public boolean addWord(Word word, String language){
        String fileName = "src/main/resources/translations/" +  language + "/"  + word.word + ".json";
        try {
            Writer writer = new FileWriter(fileName);
            gson.toJson(word, writer);
            writer.close();
        } catch (Exception e){
            return false;
        }
        return true;
    }

    public boolean deleteWord(String word, String language){
        String fileName = "src/main/resources/translations/" +  language + "/"  + word + ".json";
        try {
            File file = new File(fileName);
            file.delete();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

   public boolean addDefinitionForWord(String word, String language, Definition definition) {
        String fileName = "src/main/resources/translations/" + language + "/" + word + ".json";
        try {
            Reader reader = Files.newBufferedReader(Paths.get(fileName));
            Word wordModel = gson.fromJson(reader, Word.class);
            reader.close();
            //wordModel.definitions.add(definition);//todo
            try {
                Writer writer = new FileWriter(fileName);
                gson.toJson(wordModel, writer);
                writer.close();
            } catch (Exception e) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}