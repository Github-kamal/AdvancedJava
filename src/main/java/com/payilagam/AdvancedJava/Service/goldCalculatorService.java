package com.payilagam.AdvancedJava.Service;

import org.springframework.stereotype.Service;

@Service
public class goldCalculatorService {
    double currentprice = 10500;
    double goldgrams;
    public double calculate (double amount)
    {
        goldgrams = amount/currentprice;
        return goldgrams;
    }

}
