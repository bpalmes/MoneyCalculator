package moneycalculator.persistence;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import moneycalculator.model.Currency;



public class CurrencyReader {

    private String nextCurrencyToMount;
    private BufferedReader reader;
    
    public CurrencyReader(String path) {
        try {
            reader = new BufferedReader(new FileReader(path));
            nextCurrencyToMount = readCurrencyLine();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CurrencyReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String readCurrencyLine(){
       
        String result = null;
        try {
            result = reader.readLine();
        
        } catch (IOException ex) {
            Logger.getLogger(CurrencyReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
    
    public boolean hasCurrencies(){
        return !(nextCurrencyToMount == null);
    }
    
    public Currency getNextCurrency(){
        return mountCurrency();
    }
    
    private Currency mountCurrency(){
        String[] currencyComponents = nextCurrencyToMount.split(",");
        if(currencyComponents.length < 3) return null;
        
        Currency result = new Currency(
                currencyComponents[0],
                currencyComponents[1],
                currencyComponents[2]);
        
        updateNext();
        
        return result;
    }
    
    private void updateNext(){
        this.nextCurrencyToMount = this.readCurrencyLine();
    }
}