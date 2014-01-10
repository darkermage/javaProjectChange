package com.java.project;

import javax.swing.JTable;

public class Converter {
    
    private JTable table,bnbTable;
    private int i, j, course;
    private double rate,bnbRate,profit;
    
    public Converter(JTable table, JTable bnbTable, int i, int j, int course) {
        this.table = table;
        this.bnbTable = bnbTable;
        this.i = i;
        this.j = j;
        this.course = course;
    }
    
    public double convertValue(Object inputField) {
        rate = (double) table.getModel().getValueAt(i, course) / (double) table.getModel().getValueAt(j, course);
        bnbRate = (double) bnbTable.getModel().getValueAt(i, 1) / (double) bnbTable.getModel().getValueAt(j, 1);
        double amount = rate * Double.valueOf(inputField + "");
        profit = Math.abs(bnbRate - rate) * Double.valueOf(inputField + "");
        return amount;
    }
    
    public double getProfit() {
        return profit;
    }
    
    public double getRate() {
        return rate;
    }
}