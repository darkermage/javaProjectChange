package com.java.project;

import javax.swing.JTable;

public class Converter {
    
    private JTable table;
    private int i, j;
    private double rate;
    
    public Converter(JTable table, int i, int j) {
        this.table = table;
        this.i = i;
        this.j = j;
    }
    
    public double convertValue(Object inputField) {
        rate = (double) table.getModel().getValueAt(i, 2) / (double) table.getModel().getValueAt(j, 2);
        
        double amount = rate * Double.valueOf(inputField + "");
        
        return amount;
    }
    
    public double getRate() {
        return rate;
    }
}