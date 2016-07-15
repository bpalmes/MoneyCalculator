package moneycalculator.persistence;

import moneycalculator.model.Exchange;
import moneycalculator.model.ExchangeRate;

public abstract class ExchangeRateLoader {
            
    public abstract  ExchangeRate load (Exchange exchange);
}