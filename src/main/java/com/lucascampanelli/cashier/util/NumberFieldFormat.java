package com.lucascampanelli.cashier.util;

import java.text.NumberFormat;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author lucas
 */
public class NumberFieldFormat{
    
    NumberFormat format = NumberFormat.getInstance();
    NumberFormatter formatter = new NumberFormatter(format);
    
    public NumberFieldFormat(){
        this.formatter.setValueClass(Integer.class);
        this.formatter.setMinimum(0);
        this.formatter.setMaximum(Integer.MAX_VALUE);
        this.formatter.setAllowsInvalid(false);
    }
    
    public NumberFormatter getFormatter(){
        return this.formatter;
    }
    
}
