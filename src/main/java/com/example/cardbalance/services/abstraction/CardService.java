package com.example.cardbalance.services.abstraction;

import com.example.cardbalance.model.request.CreateOrUpdateCardRequest;
import com.example.cardbalance.model.response.CardResponse;

import java.util.List;

public interface CardService {
    void createCard(CreateOrUpdateCardRequest request);
    CardResponse getCard(Long id);
    List<CardResponse> getAllCard();
    void updateCard(Long id, CreateOrUpdateCardRequest request);
    void deleteCard(Long id);
    void deleteAllInactiveCard();
    void updateBalance();
}