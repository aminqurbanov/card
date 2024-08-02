package com.example.cardbalance.services.concrete;


import com.example.cardbalance.dao.entity.CardEntity;
import com.example.cardbalance.dao.repository.CardRepository;
import com.example.cardbalance.exception.NotFoundException;
import com.example.cardbalance.model.request.CreateOrUpdateCardRequest;
import com.example.cardbalance.model.response.CardResponse;
import com.example.cardbalance.services.abstraction.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import static com.example.cardbalance.mapper.CardMapper.CARD_MAPPER;
import static com.example.cardbalance.model.enums.CardStatus.DELETED;
import static com.example.cardbalance.model.enums.CardStatus.INACTIVE;
import static com.example.cardbalance.model.enums.ExceptionConstants.CARD_NOT_FOUND;;

@Slf4j
@Service
@RequiredArgsConstructor
public class CardServiceHandler implements CardService {

    private final CardRepository cardRepository;

    @Override
    public void createCard(CreateOrUpdateCardRequest request){
        cardRepository.save(CARD_MAPPER.buildtocard(request));

    }
    @Override
    public CardResponse getCard(Long id){
        log.info("ActionLog.getOrder.start id:{}",id);
        var card = fetchCardExist(id);
        log.info("ActionLog.getOrder.success id:{}",id);
        return  CARD_MAPPER.buildtoCardResponse(card);
    }

    @Override
    public List<CardResponse> getAllCard(){
        return cardRepository.findAll().stream().map(CARD_MAPPER::buildtoCardResponse).toList();
    }

    @Override
    public void updateCard(Long id, CreateOrUpdateCardRequest request){
        var card = fetchCardExist(id);
        card.setBalance(request.getBalance());
        cardRepository.save(card);
    }

    public void deleteCard(Long id){
        var card = fetchCardExist(id);
        card.setStatus(INACTIVE);
        cardRepository.save(card);
    }

    @Override
    public void deleteAllInactiveCard() {
        log.info("ActionLog.deleteAllInactiveCard.start");
        var cards = cardRepository.findByStatus(INACTIVE);
        cards.forEach(it->it.setStatus( DELETED));
        cardRepository.saveAll(cards);
        log.info("ActionLog.deleteAllInactiveCard.success");

    }

    @Override
    public void updateBalance() {
        log.info("ActionLog.updateBalance.start");
        var cards = cardRepository.findAll();
        cards.forEach(it-> it.setBalance(increaseByPercent(it.getBalance())));
        cardRepository.saveAll(cards);
        log.info("ActionLog.updateBalance.success");


    }
    private BigDecimal increaseByPercent(BigDecimal balance) {

        BigDecimal percentage = BigDecimal.valueOf(5);
        BigDecimal hundred = BigDecimal.valueOf(100);

        BigDecimal increment = balance.multiply(percentage).divide(hundred);


        return balance.add(increment);
    }




    private CardEntity fetchCardExist(Long id){
        return cardRepository.findById(id).orElseThrow(()->{
            log.error("ActionLog.fetchCardExist.error card with id:{}",id);
            return new NotFoundException(CARD_NOT_FOUND.getCode(),CARD_NOT_FOUND.getMessage());}
        );
    }

}













