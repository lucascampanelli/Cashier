package com.lucascampanelli.cashier.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author lucas
 */
public class CurrencyFieldFormat {
    NumberFormat format = NumberFormat.getCurrencyInstance();
    DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) format).getDecimalFormatSymbols();
    NumberFormatter formatter = new NumberFormatter(format);
    
    public CurrencyFieldFormat(){
        decimalFormatSymbols.setCurrencySymbol("");
        ((DecimalFormat) format).setDecimalFormatSymbols(decimalFormatSymbols);
        this.formatter.setAllowsInvalid(false);
        //this.formatter.setOverwriteMode(true);
    }
    
    public NumberFormatter getFormatter(){
        return this.formatter;
    }
}
