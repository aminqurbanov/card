package com.example.cardbalance.dao.repository;


import com.example.cardbalance.dao.entity.CardEntity;
import com.example.cardbalance.model.enums.CardStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<CardEntity,Long> {
    List<CardEntity> findAll();

    List<CardEntity> findByStatus(CardStatus status);
}
