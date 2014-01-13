package com.java.project;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * A class used for generating an invoice.
 * 
 * @author Ivo Mishev 
 * @author Kristiyan Georgiev
 * @author Tony Monov
 * @author Deyan Deyanov 
 */
public class Invoice {
    
    private static int invoiceNumber = 1;
    private String city, name, egn;
    
    /**
     * 3 - Argument constructor.
     * 
     * @param name      The name of the person doing the transaction
     * @param city      The city where that person lives
     * @param egn       Identificational information for that person
     */
    public Invoice(String name, String city, String egn) {
        this.city = city;
        this.name = name;
        this.egn = egn;
    }
    
    /**
     * A method that is generating the invoice and is saving that invoice into
     * C:\\ partition on the hard disk.
     * 
     * @param filePath      The file path where the invoice will be saved 
     * @param codeFrom      The name of the input currency
     * @param action        Indicates whether the customer is buying or selling
     * @param amountFrom    The amount from the input currency
     * @param rate          The exchange rate for this transaction
     * @param codeTo        The name of the output currency
     * @param amountTo      The amount of the output currency
     */
    public void setInvoice(String filePath, String codeFrom, String reason, double amountFrom, double rate, String codeTo, double amountTo) {
        PrintWriter writeInvoice = null;
        
        try {
            writeInvoice = new PrintWriter(filePath);
            
            writeInvoice.println("From: Change (Sofia)");
            writeInvoice.println("Date and time: " + new Date());
            writeInvoice.println("__________________________");
            writeInvoice.println("PURCHASE OF FOREIGN CURRENCY");
            writeInvoice.println("Invoice number: " + (invoiceNumber++));
            writeInvoice.println("__________________________");
            writeInvoice.println();
            writeInvoice.println("Name: " + name);
            writeInvoice.println("EGN: " + egn);
            writeInvoice.println("City: " + city);
            writeInvoice.println();
            writeInvoice.println("Customer amount: " + amountFrom + " " + codeFrom);
            writeInvoice.println("Exchange rate: " + rate);
            writeInvoice.println("Customer receive: " + amountTo + " " + codeTo);
            writeInvoice.println("Reason: " + reason);
            writeInvoice.println();
            writeInvoice.println("Beneficiary: .................                                 Cashier: ................");
            writeInvoice.println();
            writeInvoice.println("First name and last name: .................");
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } finally {
            if (writeInvoice != null) {
                writeInvoice.close();
            }
        }
    }
}