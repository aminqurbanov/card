package com.example.cardbalance.mapper;

import com.example.cardbalance.dao.entity.CardEntity;
import com.example.cardbalance.model.enums.CardStatus;
import com.example.cardbalance.model.request.CreateOrUpdateCardRequest;
import com.example.cardbalance.model.response.CardResponse;

import static com.example.cardbalance.model.enums.CardStatus.ACTIVE;

public enum CardMapper {
    CARD_MAPPER;


    public CardEntity buildtocard(CreateOrUpdateCardRequest request){
        return  CardEntity.builder().
                balance(request.getBalance()).
                status(ACTIVE).build();
    }

    public CardResponse buildtoCardResponse(CardEntity entity){
        return  CardResponse.builder().
                id(entity.getId()).
                balance(entity.getBalance()).
                status(entity.getStatus()).build();
    }

}


