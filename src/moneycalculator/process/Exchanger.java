package moneycalculator.process;

import moneycalculator.model.Exchange;
import moneycalculator.model.ExchangeRate;
import moneycalculator.model.Money;

public class Exchanger {
    

    public static Money exchange (Exchange exchange, ExchangeRate rate){
        return new Money(exchange.getCurrency(), computeAmount(exchange, rate));
    }

    private static float computeAmount(Exchange exchange, ExchangeRate rate) {
        return exchange.getMoney().getAmount()*rate.getRate();
    }
}