package moneycalculator.gui.swing;

import javax.swing.JComboBox;
import moneycalculator.model.Currency;
import moneycalculator.model.CurrencySet;

public class CurrencySelector extends JComboBox {
    
    private CurrencySet currencySet;
    private String[] options;
    
  
    public CurrencySelector(String[] options, CurrencySet set) {
        super(options);
        this.currencySet = set;
        this.setEditable(false);
        this.setAutoscrolls(true);
        this.doLayout();
    }

    
    public Currency getSelectedCurrency(){
        return currencySet.getCurrencyFromCode(
                (String)this.getSelectedItem() );
    }
    
    public static String[] buildOptionsArray(CurrencySet currencySet){
        
        String[] result = new String[currencySet.size()];
        
        int index = 0;
        for(String code : currencySet.getCodes()){
             result[index] = code ;
             index++;
        }
        
        return result;
    }
}