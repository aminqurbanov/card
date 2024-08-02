package com.example.cardbalance.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
    public class CreateOrUpdateCardRequest {

        private BigDecimal balance;

    }

