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
        double rate = Double.parseDouble((String) table.getModel().getValueAt(i, 2)) / Double.parseDouble((String) table.getModel().getValueAt(j, 2)) * Double.valueOf(inputField + "");
        return rate;
    }
}