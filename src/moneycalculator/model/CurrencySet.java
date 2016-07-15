package moneycalculator.model;

import java.util.HashMap;
import java.util.Set;

public class CurrencySet {

    private final HashMap<String, Currency> map;

    public CurrencySet() {
        this.map = new HashMap<>();
    }

    public void add(String code, Currency currency) {
        map.put(code, currency);
    }

    public Set<String> getCodes() {
        return map.keySet();
    }

    public Currency getCurrencyFromCode(String code){
        return map.get(code);
    }
    
    public int size(){
        return map.size();
    }
    
    
}