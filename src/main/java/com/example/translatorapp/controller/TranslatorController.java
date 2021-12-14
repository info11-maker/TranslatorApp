package com.example.translatorapp.controller;

import com.example.translatorapp.model.Definition;
import com.example.translatorapp.model.Word;
import com.example.translatorapp.repository.TranslatorRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class TranslatorController {
    private TranslatorRepository translatorRepository = new TranslatorRepository();

    @GetMapping(path = "translate/word/{language}/{word}")
    public String translateWord(@PathVariable String word, @PathVariable String language){
        return translatorRepository.translateWord(word,language);
    }
    @PostMapping(path = "translate/word/{language}")
    public boolean addWord(@RequestBody Word word, @PathVariable String language){
        return translatorRepository.addWord(word,language);
    }
    @DeleteMapping(path = "translate/word/{language}/{word}")
    public boolean deleteWord(@PathVariable String word, @PathVariable String language){
        return translatorRepository.deleteWord(word,language);
    }
    @PostMapping(path = "translate/word/{language}/{word}")
    public boolean addDefinitionForWord(@PathVariable String word, @PathVariable String language, @RequestBody Definition definition){
        return translatorRepository.addDefinitionForWord(word, language, definition);
    }
    @DeleteMapping(path = "translate/word/definition/{language}/{word}/{dictionary}")
    public boolean deleteDefinitionForWord(@PathVariable String word, @PathVariable String language,  @PathVariable String dictionary, @RequestBody Definition definition) {
        return translatorRepository.deleteDefinitionForWord(word, language,dictionary, definition);
    }
    @GetMapping(path = "translate/word/sentence/{language}/{word}")
    public String translateSentence(@PathVariable String sentence, @PathVariable String fromLanguage, @PathVariable String toLanguage){
        return translatorRepository.translateSentence(sentence, fromLanguage, toLanguage);
    }

}
