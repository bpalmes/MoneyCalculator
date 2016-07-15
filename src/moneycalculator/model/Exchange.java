package moneycalculator.model;

public class Exchange {

    private Money money;
    private Currency currency;

    public Exchange(Money money, Currency currency) {
        this.money = money;
        this.currency = currency;
    }

    public Money getMoney() {
        return money;
    }

    public Currency getCurrency() {
        return currency;
    }
    
    
}