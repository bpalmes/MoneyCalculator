package moneycalculator.persistence;

import moneycalculator.model.Exchange;
import moneycalculator.model.ExchangeRate;

public class CVSExchangeRateLoader extends ExchangeRateLoader {

    private final ExchangeRateMap map;

    public CVSExchangeRateLoader() {
        this.map = new ExchangeRateMap();
    }
    
    
    @Override
     public  ExchangeRate load (Exchange exchange){
        String codeTo = exchange.getCurrency().getCode();
        String codeFrom = exchange.getMoney().getCurrency().getCode();
        
        float rate = map.getExchangeFrom(codeFrom) / map.getExchangeFrom(codeTo);
        
        return new ExchangeRate(
                codeFrom,
                codeTo,
                rate
        );
    }
}