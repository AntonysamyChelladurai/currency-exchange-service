package com.jbeans.currencyexchangeservice.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;

//@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class CurrencyExchange {
    @Id
    private long id;

    @Column(name = "CURRENCY_FROM")
    private String from;
    @Column(name = "CURRENCY_TO")
    private String to;
    private BigDecimal conversion_Multiple;
    private String environment;
}
