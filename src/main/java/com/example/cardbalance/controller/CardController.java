package com.example.cardbalance.controller;


import com.example.cardbalance.model.request.CreateOrUpdateCardRequest;
import com.example.cardbalance.model.response.CardResponse;
import com.example.cardbalance.services.abstraction.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/cards")
public class CardController {
    private final CardService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCard(@RequestBody CreateOrUpdateCardRequest request){
        service.createCard(request);
    }

    @GetMapping("{id}")
    public CardResponse getCard(@PathVariable Long id){
        System.out.println( service.getCard(id).toString()+"coneadsa");
        return service.getCard(id);
    }

    @GetMapping
    public List<CardResponse> getAllCards(){
        return service.getAllCard();
    }

    @PatchMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void updateCard(@PathVariable Long id,@RequestBody CreateOrUpdateCardRequest request){
        service.updateCard(id,request);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteCard(@PathVariable Long id){
        service.deleteCard(id);
    }



}
