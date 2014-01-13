package com.java.project;

import javax.swing.JTable;

/**
 * A class used for doing the exchange.
 * 
 * @author Ivo Mishev 
 * @author Kristiyan Georgiev
 * @author Tony Monov
 * @author Deyan Deyanov 
 */
public class Converter {
    
    private JTable table, bnbTable;
    private int i, j, col;
    private double rate, bnbRate, profit;
    
    /**
     * 5 - Argument constructor.
     * 
     * @param table     The table that contains the local (buy and sell) rates
     * @param bnbTable  The table that contains the original rates from BNB's site
     * @param i         The index of the input currency
     * @param j         The index of the output currency
     * @param col       The column from the localRatesTable which will be used for
     *                  this exchange (buy or sell accordingly)
     */
    public Converter(JTable table, JTable bnbTable, int i, int j, int col) {
        this.table = table;
        this.bnbTable = bnbTable;
        this.i = i;
        this.j = j;
        this.col = col;
    }
    
    /**
     * The method that does the exchange and calculates the profit.
     * 
     * @param inputField    The amount of the input currency
     * 
     * @return              The amount of the output currency
     */
    public double convertValue(Object inputField) {
        rate = (double) table.getModel().getValueAt(i, col) / (double) table.getModel().getValueAt(j, col);
        bnbRate = (double) bnbTable.getModel().getValueAt(i, 1) / (double) bnbTable.getModel().getValueAt(j, 1);
        double amount = rate * Double.valueOf(String.valueOf(inputField));
        profit = Math.abs(bnbRate - rate) * Double.valueOf(String.valueOf(inputField));
        return amount;
    }
    
    /**
     * The method returns the profit made for this transaction.
     * 
     * @return  The profit
     */
    public double getProfit() {
        return profit;
    }
    
    /**
     * The method returns the rate which was used for the exchange.
     * 
     * @return  The rate
     */
    public double getRate() {
        return rate;
    }
}