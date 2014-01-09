package com.java.project;

import javax.swing.JTable;

public class Converter {
    
    private JTable table;
    private int i, j;
    
    public Converter(JTable table, int i, int j) {
        this.table = table;
        this.i = i;
        this.j = j;
    }
    
    public double convertValue(Object inputField) {
        double rate = (double) table.getModel().getValueAt(i, 1) / (double) table.getModel().getValueAt(j, 1) * Double.valueOf(inputField + "");
        return rate;
    }
}