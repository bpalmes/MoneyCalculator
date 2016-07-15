package moneycalculator;

import java.util.Set;
import moneycalculator.control.ExchangeCommand;
import moneycalculator.model.CurrencySet;
import moneycalculator.persistence.CVSExchangeRateLoader;
import moneycalculator.persistence.CurrencySetLoader;

public class MoneyCalculator {
    
    private static CurrencySet currencySet;
    private static CVSExchangeRateLoader cvs;
    
    
    public static void main(String[] args) {
        
        currencySet = new CurrencySetLoader().load();
        cvs = new CVSExchangeRateLoader();
        
        ExchangeCommand cmd = new ExchangeCommand(currencySet,cvs);
        
        /*
        OJO: Aquí debería añadir el cvs como parámetro
       
        cmd.execute();*/
    }
    
    /*
    private static  void showTest(){
        
        Set<String> codes = currencySet.getCodes();
        
        for (String code : codes) {
            System.out.println(code);
        }
    }*/
}