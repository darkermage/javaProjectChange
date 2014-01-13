package com.java.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/** 
 * A class used for working with the database. Here are all of the methods for 
 * establishing a connection to the database and working with the different 
 * tables from that database.
 * 
 * @author Ivo Mishev 
 * @author Kristiyan Georgiev
 * @author Tony Monov
 * @author Deyan Deyanov 
 * 
 */
public class DataBase {

    private Connection conn;
    private PreparedStatement pst;
    private ResultSet resultSet;
    
    /**
     * No argument constructor that establishes a connection with the database. 
     * A proper driver is required in order for the connection to be successful.
     * MySQL connector 5.1.28 is the driver, used during the writing of the program.
     * 
     * <p>
     * If the connection fails, the program execution terminates, because the 
     * database is vital for the program.
     */
    public DataBase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Cannot connect to database");
            System.exit(1);
        }
    }
    
    /**
     * A method that takes the names of the different currencies from the "rates"
     * table in the database.
     * 
     * @return DefaultComboBoxModel, containing the names of all the different
     *         currencies.
     */
    public DefaultComboBoxModel getCodes() {
        DefaultComboBoxModel dtm = new DefaultComboBoxModel();
       
        try {
            pst = conn.prepareCall("SELECT RateName FROM rates"); 
            resultSet = pst.executeQuery();
       
            while (resultSet.next()) {
                dtm.addElement(resultSet.getString("RateName"));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }

                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
       
        return dtm;
    }
    
    /**
     * The method is collecting data from the database for all of the transactions
     * made on that date.
     * 
     * @param  date The date for which the log will be generated.
     * 
     * @return  A String, containing all of the transactions made on this 
     *          particular date.
     */
    public String getLog(Date date) {
        try {
            pst = conn.prepareStatement("SELECT * FROM log WHERE date = ?");
            pst.setDate(1, date);
            
            resultSet = pst.executeQuery();
            StringBuilder sb = new StringBuilder();
            
            while (resultSet.next()) {
                Date d = resultSet.getDate(2);
                String currency = resultSet.getString(3);
                double amountFrom = resultSet.getDouble(4);
                double rate = resultSet.getDouble(5);
                String currencyTo = resultSet.getString(6);
                double amountTo = resultSet.getDouble(7);
                
                sb.append("Date:").append(d.toString()).append("\tFrom currency:").append(currency).
                        append("\tAmount from:").
                        append(amountFrom).append("\tRate:").
                        append(rate).append("\tTo currency:").append(currencyTo).
                        append("\tAmount to:").append(amountTo).append("\n");  
            }
            
            return sb.toString();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }

                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        
        return null;
    }
    
    /**
     * A method for updating the content of the stock table in the "Cashier" tab.
     * The data inserted in the table is extracted with a query from the "stock"
     * table in the database.
     * 
     * @param table The JTable object which will be updated with the data collected 
     *              with the query to the "stock" table.
     * 
     */
    public void updateStockTable(JTable table) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        
        try {
            pst = conn.prepareStatement("SELECT * FROM stock");
            resultSet = pst.executeQuery();
            
            while (resultSet.next()) {
                dtm.addRow(new Object[] { new Integer(resultSet.getString(1)), resultSet.getString(2), new Double(resultSet.getString(3)) });
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
    
    /**
     * A method for updating the content of the bnbRates table in the "Rates" tab.
     * <p>
     * That table is holding the original currency rates from BNB's site.
     * <p>
     * The data inserted in the table is extracted from the "rates" table in the
     * database.
     * 
     * @param table The JTable object which will be updated
     * 
     */
    public void updateBNBTable(JTable table) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        
        try {
            pst = conn.prepareStatement("SELECT RateName, Rate FROM rates");
            resultSet = pst.executeQuery();
            
            while (resultSet.next()) {
                dtm.addRow(new Object[] { resultSet.getString("RateName"), new Double(resultSet.getString("Rate")) });
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
    
    /**
     * A method for updating the content of the localRates table in the "Rates" tab.
     * <p>
     * That table is holding the local (buy and sell) rates, used for the actual 
     * exchange.
     * <p>
     * The data inserted in the table is extracted from the "local" table in the
     * database.
     * 
     * @param table The JTable object which will be updated
     * 
     */
    public void updateLocalTable(JTable table) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        
        try {
            pst = conn.prepareStatement("SELECT * FROM local");
            resultSet = pst.executeQuery();
            
            while (resultSet.next()) {
                dtm.addRow(new Object[] { new Integer(resultSet.getString("localId")), resultSet.getString("code"), 
                    new Double(resultSet.getString("buy")), new Double(resultSet.getString("sell")) });
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
    
    /**
     * A method for getting all of the currencies names and rates from the BNB's site. 
     * First the "Rates" table in the database is truncated (this is useful when
     * the table is updated). Then the XML file from BNB's site, containing all 
     * of the rates is parsed and the gathered information is inserted into the 
     * database (in the "Rates" table).
     */
    public void updateCurrency() {
        try {
            pst = conn.prepareStatement("truncate table Rates");
            pst.executeUpdate();
            pst.close();

            URL xml = new URL("http://bnb.bg/Statistics/StExternalSector/StExchangeRates/StERForeignCurrencies/index.htm?download=xml&search=&lang=BG");
            URLConnection yc = xml.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            String inputLine;
            String xml2;
            StringBuilder Sb = new StringBuilder();
            
            while ((inputLine = in.readLine()) != null) {
                Sb.append(inputLine);
                Sb.append("\n");
            }

            in.close();
            Sb.delete(0, 1);
            xml2 = Sb.toString();

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(xml2));

            Document doc = builder.parse(is);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("ROW");
            
            String codeString = null;
            String reverseString = null;
            double reverseDouble = 0.0D;
            
            pst = conn.prepareStatement("INSERT INTO rates(RateName, Rate) VALUES (?, ?)");
            pst.setString(1, "BGR");
            pst.setDouble(2, 1);
            pst.executeUpdate();
            pst.close();
            
            pst = conn.prepareStatement("INSERT INTO rates(RateName, Rate) VALUES (?, ?)");
            pst.setString(1, "EUR");
            pst.setDouble(2, 1.95583);
            pst.executeUpdate();
            pst.close();
            
            for (int temp = 1; temp < nList.getLength() - 1; temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    
                    NodeList code = eElement.getElementsByTagName("CODE");
                    NodeList reverse = eElement.getElementsByTagName("REVERSERATE");
                    
                    if( code.getLength() > 0 ){
                        codeString = code.item(0).getTextContent();
                        
                        if( reverse.getLength() > 0 ){
                            reverseString = reverse.item(0).getTextContent();
                            reverseDouble = Double.parseDouble(reverseString);
                        }
                    }
                    
                    pst = conn.prepareStatement("INSERT INTO rates(RateName, Rate) VALUES (?, ?)");
                    pst.setString(1, codeString);
                    pst.setDouble(2, (1 / reverseDouble));
                    pst.executeUpdate();
                }
            }
        } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Cannot connect to internet!");	
        } catch (SQLException e) {
                System.err.println(e.getMessage());
        } catch (ParserConfigurationException e) {
                System.err.println(e.getMessage());
        } catch (SAXException e) {
                System.err.println(e.getMessage());
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }
    
    /**
     * A method for updating the "log" table in the database. That method is used 
     * every time when a transaction is made.
     * 
     * @param date          The date when the transaction was made.
     * @param currencyFrom  The name of the input currency.
     * @param amountFrom    The amount of the input currency.
     * @param rate          The exchange rate.
     * @param currencyTo    The name of the output currency.
     * @param amountTo      The amount of the output currency.
     * 
     */
    public void updateLog(Date date, String currencyFrom, double amountFrom, double rate, String currencyTo, double amountTo) {
        try {
            pst = conn.prepareStatement("INSERT INTO log(`date`, `currency_from`, `currency_from_amount`, `rate`, `currency_to`, `currency_to_amount`) VALUES(?,?,?,?,?,?)");
            pst.setDate(1, date);
            pst.setString(2, currencyFrom);
            pst.setDouble(3, amountFrom);
            pst.setDouble(4, rate);
            pst.setString(5, currencyTo);
            pst.setDouble(6, amountTo);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }
    
    /**
     * A method that fills the "stock" table in the database. That table is holding
     * the amount that we have from each currency.
     */
    public void fillStockTable(){
        try{
            pst = conn.prepareStatement("truncate table stock");
            pst.executeUpdate();
            pst.close();
            
            pst = conn.prepareStatement("INSERT INTO stock (code) SELECT RateName FROM rates");
            pst.executeUpdate();
            pst.close();
            
            pst = conn.prepareStatement("UPDATE stock SET stock = 0");
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }
    
    /**
     * A method for updating the "stock" table in the database.
     * 
     * @param amount    The amount that will be assigned to the currency which
     *                  will be updated.
     * @param stockId   The ID of the currency which will be updated.
     */
    public void updateStock(double amount,int stockId) {
        try{
            pst = conn.prepareStatement("UPDATE stock SET stock = ? WHERE stockid = ?");
            pst.setDouble(1, amount);
            pst.setInt(2, stockId);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }
    
    /**
     * A method for updating the "local" table in the database. That table is holding
     * the buy and sell rates that we have chosen to use for the transactions.
     * 
     * @param localId   The ID of the currency which will be updated
     * @param buy       The Buy rate for that currency
     * @param sell      The Sell rate for that currency
     */
    public void updateLocal(int localId, double buy, double sell) {
        try{
            pst = conn.prepareStatement("UPDATE local SET buy = ?, sell = ? WHERE localid = ?");
            pst.setDouble(1, buy);
            pst.setDouble(2, sell);
            pst.setInt(3, localId);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }
    
    /**
     * A method that is used for changing the amount that we have for (codeFrom and codeTo)
     * currencies. That method is used every time when a transaction is made.
     * 
     * @param amountFrom    The amount that we have from the input currency
     * @param codeFrom      The name of the input currency
     * @param amountTo      The amount that we have from the output currency
     * @param codeTo        The name of the output currency
     * 
     */
    public void changeCurrencyInStock(double amountFrom, String codeFrom, double amountTo, String codeTo) {
        try {
            pst = conn.prepareStatement("SELECT * FROM stock WHERE code = ?");
            pst.setString(1, codeFrom);
            resultSet = pst.executeQuery();
            
            String name = null;
            double amount = 0.0D;
            
            if (resultSet.next()) {
                name = resultSet.getString(2);
                amount = resultSet.getDouble(3);
                amount += amountFrom;
            }
            
            pst.close();
            resultSet.close();
            
            pst = conn.prepareStatement("UPDATE stock SET stock = ? WHERE code = ?");
            
            pst.setDouble(1, amount);
            pst.setString(2, name);
            pst.executeUpdate();
            
            pst.close();
 
            pst = conn.prepareStatement("SELECT * FROM stock WHERE code = ?");
            pst.setString(1, codeTo);
            resultSet = pst.executeQuery();
            
            if (resultSet.next()) {
                name = resultSet.getString(2);
                amount = resultSet.getDouble(3);
            }
            
            pst.close();
            resultSet.close();
 
            amount -= amountTo;
 
            pst = conn.prepareStatement("UPDATE stock SET stock = ? WHERE code = ?");
            pst.setDouble(1, amount);
            pst.setString(2, name);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }
    
    /**
     * A method for updating the "profit" table in the database.
     * That method is used every time when a transaction is made.
     * <p>
     * If that date exist in the table in the database, the profit for that date
     * is updated. If the date do not exist, a new entry is inserted in the 
     * database.
     * 
     * @param date      The date when the transaction is made
     * @param amount    The profit from that transaction
     */
    public void updateProfit(Date date, double amount){
        try { 
            pst = conn.prepareStatement("INSERT INTO profit (date, profit) VALUES (?,?) ON DUPLICATE KEY UPDATE profit = profit + ?");
            pst.setDate(1, date);
            pst.setDouble(2, amount);
            pst.setDouble(3, amount);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }
    
    /**
     * A method for getting the profit for a particular date. That method is used
     * when a log has to be generated.
     * 
     * @param date  The date for which the profit should be extracted from the 
     *              database
     * @return      The profit for that date
     */
    public double getProfit(Date date) {
        double profit = -1.0D;
        
        try {
            pst = conn.prepareStatement("SELECT profit FROM profit WHERE date = ?");
            pst.setDate(1, date);
            
            resultSet = pst.executeQuery();
            
            if (resultSet.next()) {
                profit = resultSet.getDouble("profit");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }

                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        
        return profit;
    }
}