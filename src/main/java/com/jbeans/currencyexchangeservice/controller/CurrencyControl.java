package com.jbeans.currencyexchangeservice.controller;

import com.jbeans.currencyexchangeservice.CurrencyExchangeServiceApplication;
import com.jbeans.currencyexchangeservice.dto.CurrencyExchange;
import com.jbeans.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyControl {

    @Autowired
    private Environment env;

    @Autowired
    private CurrencyExchangeRepository currentrepo;

    public String getMSG(){
        return "$$$$$ Welcome to Currency control $$$$$";
    }

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchange(
            @PathVariable String from,
            @PathVariable String to) {
         CurrencyExchange currencyExchange = new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(50),"");
         currencyExchange= currentrepo.findByFromAndTo(from,to);
            String port = env.getProperty("local.server.port");
            currencyExchange.setEnvironment(port);
        return currencyExchange;

    }
}