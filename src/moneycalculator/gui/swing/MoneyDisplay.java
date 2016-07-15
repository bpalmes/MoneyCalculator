package moneycalculator.gui.swing;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import moneycalculator.model.Money;

public class MoneyDisplay extends JPanel {

    
    public MoneyDisplay(){
        this.add(createMoneyLabel(), 0 );
    }

    private JTextArea createMoneyLabel() {
        JTextArea moneyDisplayer = new JTextArea();
        moneyDisplayer.setText("Convertion");
        moneyDisplayer.setColumns(20);
        moneyDisplayer.setVisible(true); 
        return moneyDisplayer;
    }
    
    public void setMoney(Money money){
        String text = money.getAmount() + money.getCurrency().getSymbol();
        JTextArea label =((JTextArea)this.getComponent(0));
        label.setText(text);
        label.repaint();        
    }
}