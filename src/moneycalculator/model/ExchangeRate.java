package moneycalculator.model;

public class ExchangeRate {


    private final String codefrom;
    private final String codeto;
    private final float rate;

    public ExchangeRate(String from, String to, float rate) {
        this.codefrom = from;
        this.codeto = to;
        this.rate = rate;
    }

    public String getFrom() {
        return codefrom;
    }

    public String getTo() {
        return codeto;
    }

    public float getRate() {
        return rate;
    }

    
   
    
    
}