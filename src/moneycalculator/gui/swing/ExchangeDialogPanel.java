package moneycalculator.gui.swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import moneycalculator.gui.ExchangeDialog;
import moneycalculator.model.CurrencySet;
import moneycalculator.model.Exchange;

public class ExchangeDialogPanel extends JPanel implements ExchangeDialog {

    private ActionListener actionListener;
    private ExchangeArea exchangeArea;
    
    public ExchangeDialogPanel(CurrencySet set){
        
        String[] options = CurrencySelector.buildOptionsArray(set);
        this.setLayout(new BorderLayout());
        this.add(createExchangeArea(options,set) , BorderLayout.LINE_START );
        this.add(createActionButton(), BorderLayout.CENTER);
    }
            
    @Override
    public Exchange getExchange() {
        return exchangeArea.getExchange();
    }

    private ExchangeArea createExchangeArea(String[] options, CurrencySet currencies) {
        this.exchangeArea =  new ExchangeArea(options, currencies);
        return this.exchangeArea;
    }

    private JButton createActionButton() {
        JButton button = new JButton("Calcular");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                actionListener.actionPerformed(e);
            }
        });
        return button;
    }
    
    public void register(ActionListener actionListener) {
        this.actionListener = actionListener;
    }
    
}