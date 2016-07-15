package moneycalculator.gui.swing;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.JTextField;
import moneycalculator.gui.ExchangeDialog;
import moneycalculator.model.Currency;
import moneycalculator.model.CurrencySet;
import moneycalculator.model.Exchange;
import moneycalculator.model.Money;

public class ExchangeArea extends JPanel implements ExchangeDialog {

    private double amount;
    private Currency fromCurrency;
    private Currency toCurrency;
    
    public ExchangeArea(String[] options, CurrencySet currencies) {
        
        amount = 0;
        
        this.setLayout(new FlowLayout());
        this.add(createAmountField(),0);
        this.add(createCurrencySelectorFrom(options,currencies),1);
        this.add(createCurrencySelectorTo(options,currencies),2);
        

    }

    private JTextField createAmountField() {
        final JTextField input = new JTextField();
        input.setColumns(20);
        input.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                amount = Double.parseDouble(input.getText());
            }
        });
        return input;
    }
    
    private CurrencySelector createCurrencySelectorFrom(String[] options, CurrencySet currencies){
        final CurrencySelector cSelector = 
                new CurrencySelector(options,currencies);
        cSelector.addItemListener( new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() != ItemEvent.SELECTED) return;
                fromCurrency = 
                        cSelector.getSelectedCurrency();
            }
        });
        
        return cSelector;
    }

    private CurrencySelector createCurrencySelectorTo(String[] options, CurrencySet currencies){
        final CurrencySelector cSelector = 
                new CurrencySelector(options,currencies);
        cSelector.addItemListener( new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() != ItemEvent.SELECTED) return;
                toCurrency = 
                         cSelector.getSelectedCurrency();
            }
        });
        
        return cSelector;
    }
    
    @Override
    public Exchange getExchange() {
        return new Exchange(new Money(
                fromCurrency, (float) amount), toCurrency);
    }

}