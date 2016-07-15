package moneycalculator.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import moneycalculator.gui.swing.ApplicationFrame;
import moneycalculator.model.CurrencySet;
import moneycalculator.model.Exchange;
import moneycalculator.model.ExchangeRate;
import moneycalculator.model.Money;
import moneycalculator.persistence.CVSExchangeRateLoader;
import moneycalculator.process.Exchanger;

public class ExchangeCommand {

    private CurrencySet currencyset;
    private CVSExchangeRateLoader cvs;
    private ActionListener userListener;
    private ApplicationFrame gui;
    
    public ExchangeCommand(CurrencySet currencyset, CVSExchangeRateLoader cvs) {
        this.currencyset = currencyset;
        this.cvs = cvs;
        this.gui = new ApplicationFrame(currencyset);
        this.userListener = userListener();
        this.gui.register(userListener);
    }
    
    public void execute(){
        
    }

    private ActionListener userListener() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Exchange userWish = gui.getExchange();
                ExchangeRate cvsInfo = cvs.load(userWish);
                Money calculator = Exchanger.exchange(userWish, cvsInfo);
                gui.updateDisplay(calculator);
            }
        };
    }
}