package moneycalculator.persistence;

import moneycalculator.model.Currency;
import moneycalculator.model.CurrencySet;

public class CurrencySetLoader {
    
    private static final String path = "C:\\Users\\Laura\\Documents\\GitHub\\MoneyCalculator\\CurrencyList";
    private CurrencyReader reader;
    
    public CurrencySetLoader() {
            this.reader = new CurrencyReader(path);
    }

    
    public CurrencySet load(){
        
        CurrencySet result = new CurrencySet();
        Currency newCurrency;
       
        while(reader.hasCurrencies()){
            newCurrency = reader.getNextCurrency();
            result.add(newCurrency.getCode(), newCurrency);
        }
        
        
        return result;
    }
}