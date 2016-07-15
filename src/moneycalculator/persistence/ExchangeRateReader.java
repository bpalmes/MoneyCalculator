package moneycalculator.persistence;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import moneycalculator.model.Currency;
import moneycalculator.model.ExchangeRate;

class ExchangeRateReader {

    private BufferedReader reader;
    private String nextLine;
    
    
    public ExchangeRateReader (String path){
        reader = null;
        try {
            reader = new BufferedReader( new FileReader(path));
            this.nextLine = read();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExchangeRateReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExchangeRateReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    private String read () throws IOException{
        return reader.readLine();
    }
    
    public boolean hasNext(){
        return !(nextLine == null);
    }
    
    public ExchangeRate getNext(){
        ExchangeRate result ;
        
        String[] exRateComponents = this.nextLine.split(",");
        
        result = new ExchangeRate(exRateComponents[0],
                "EUR",
                RateParser.parse(exRateComponents[1]));
        
        updateNextLine();
        
        return result;
    }
    
    private void updateNextLine(){
        try {
            this.nextLine = read();
        } catch (IOException ex) {
            Logger.getLogger(ExchangeRateReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}