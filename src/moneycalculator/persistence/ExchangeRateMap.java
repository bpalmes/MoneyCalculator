package moneycalculator.persistence;

import java.util.HashMap;
import moneycalculator.model.ExchangeRate;

public class ExchangeRateMap {
    
    private  HashMap<String,Float> map;
    private ExchangeRateReader reader;
    
    public ExchangeRateMap() {
        this.map = new HashMap<>();
        this.reader = 
                new ExchangeRateReader("C:\\Users\\Laura\\Documents\\GitHub\\MoneyCalculator\\ExchangeList");
        load();
    }

    private void load() {
        
        ExchangeRate aux;
        
        while(reader.hasNext()){
            aux = reader.getNext();
            map.put(aux.getFrom(),aux.getRate());
        }
    
    }
    
    public float getExchangeFrom( String code){
        return map.get(code);
    }
    
}