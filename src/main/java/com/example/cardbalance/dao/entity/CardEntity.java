package com.example.cardbalance.dao.entity;

import com.example.cardbalance.model.enums.CardStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Builder
@Table(name = "cards")
@Entity
public class CardEntity {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;


    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private CardStatus status;
}