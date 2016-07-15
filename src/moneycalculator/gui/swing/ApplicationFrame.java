package moneycalculator.gui.swing;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import moneycalculator.gui.ExchangeDialog;
import moneycalculator.model.CurrencySet;
import moneycalculator.model.Exchange;
import moneycalculator.model.Money;

public class ApplicationFrame extends JFrame implements ExchangeDialog {
    
    
    private ExchangeDialog exchage;
    private MoneyDisplay display;
    
    public  ApplicationFrame (CurrencySet currencies){
        
        this.setTitle("Money calculator");
        this.setSize(500,100);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.getContentPane().add(createExchangeDialogPanel(currencies),BorderLayout.NORTH);
        this.getContentPane().add(createMoneyPanel(), BorderLayout.SOUTH);
        
        this.setVisible(true);
        
    }

    private ExchangeDialogPanel createExchangeDialogPanel(CurrencySet currencies) {
        this.exchage = new ExchangeDialogPanel(currencies);
        
        return (ExchangeDialogPanel) this.exchage;
    }

    private MoneyDisplay createMoneyPanel() {
        this.display = new MoneyDisplay();
        return this.display;
    }
    
    public void updateDisplay(Money money){
        display.setMoney(money);
    }

    @Override
    public Exchange getExchange() {
        return this.exchage.getExchange();
    }
    
    public void register(ActionListener aL){
        ((ExchangeDialogPanel)this.exchage).register(aL);
    }
}