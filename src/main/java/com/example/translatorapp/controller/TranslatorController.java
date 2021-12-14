package com.example.translatorapp.controller;

import com.example.translatorapp.model.Definition;
import com.example.translatorapp.model.Word;
import com.example.translatorapp.repository.TranslatorRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class TranslatorController {
    private TranslatorRepository translatorRepository = new TranslatorRepository();

    @GetMapping(path = "translate/word/{language}/{word}")
    public String translateWord(@PathVariable String language, @PathVariable String word){
        return translatorRepository.translateWord(word,language);
    }
    @GetMapping(path = "translate/word/{language}")
    public boolean addWord(@RequestBody Word word, @PathVariable String language){
        return translatorRepository.addWord(word,language);
    }
    @GetMapping(path = "translate/word/{language}/{word}")
    public boolean deleteWord(@PathVariable String language, @PathVariable String word){
        return translatorRepository.deleteWord(word,language);
    }
}
