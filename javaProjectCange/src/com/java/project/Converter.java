package com.java.project;

import javax.swing.JTable;

public class Converter {
    
    private JTable table;
    private int i, j, course;
    private double rate;
    
    public Converter(JTable table, int i, int j, int course) {
        this.table = table;
        this.i = i;
        this.j = j;
        this.course = course;
    }
    
    public double convertValue(Object inputField) {
        rate = (double) table.getModel().getValueAt(i, course) / (double) table.getModel().getValueAt(j, course);
        
        double amount = rate * Double.valueOf(inputField + "");
        
        return amount;
    }
    
    public double getRate() {
        return rate;
    }
}