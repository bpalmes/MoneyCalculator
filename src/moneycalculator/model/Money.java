package moneycalculator.model;

public class Money {

    private final Currency currency;
    private final float amount;

    public Money(Currency currency, float amount) {
        this.currency = currency;
        this.amount = amount;
    }

    

    public Currency getCurrency() {
        return currency;
    }

    public float getAmount() {
        return amount;
    }
    
    
    
}