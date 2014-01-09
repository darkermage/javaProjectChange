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
import java.util.ArrayList;
import java.util.List;

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

public class DataBase {

    private Connection conn;
    private PreparedStatement pst;
    private ResultSet resultSet;
    
    public DataBase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Cannot connect to database");
            System.exit(1);
        }
    }
	
    public Object[] getCodes() {
       List<Object> codeName = new ArrayList<>();
       
        try {
            pst = conn.prepareCall("SELECT rateName FROM rates"); 
            resultSet = pst.executeQuery();
       
            while (resultSet.next()) {
                codeName.add(resultSet.getString("RateName"));
            }
            
            return codeName.toArray();
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
            
        return null;
    }
    
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
    
    public void updateStockTable(JTable table) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        
        try {
            pst = conn.prepareStatement("SELECT * FROM stock");
            resultSet = pst.executeQuery();
            
            while (resultSet.next()) {
                dtm.addRow(new Object[] { resultSet.getString(1), resultSet.getString(2), resultSet.getString(3) });
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
    
    public void updateBNBTable(JTable table) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        
        try {
            pst = conn.prepareStatement("SELECT * FROM rates");
            resultSet = pst.executeQuery();
            
            while (resultSet.next()) {
                dtm.addRow(new Object[] { resultSet.getString("RateName"), resultSet.getString("Rate") });
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
    
    public void updateLocalTable(JTable table) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        
        try {
            pst = conn.prepareStatement("SELECT * FROM local");
            resultSet = pst.executeQuery();
            
            while (resultSet.next()) {
                dtm.addRow(new Object[] { resultSet.getString("localId"),resultSet.getString("code"), resultSet.getString("buy"), resultSet.getString("sell") });
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
                    pst.setDouble(2, reverseDouble);
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
    
    public void updateLocal(int localId, double buy, double sell) {
        try{
            pst = conn.prepareStatement("UPDATE local SET buy = ?, sell = ? WHERE localid = ?");
            pst.setDouble(1, buy);
            pst.setDouble(2, sell);
            pst.setInt(2, localId);
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
    
   
    public void changeCurrencyInStock(String amountFrom, String codeFrom, String amountTo, String codeTo) {
        try {
            pst = conn.prepareStatement("SELECT * FROM stock WHERE code = ?");
            pst.setString(1, codeFrom);
            resultSet = pst.executeQuery();
            String name = resultSet.getString(2);
            double amount = resultSet.getDouble(3);
            pst.close();
 
            amount += Double.parseDouble(amountFrom);
 
            pst = conn.prepareStatement("UPDATE stock SET stock = ? WHERE code = ?");
            pst.setDouble(1, amount);
            pst.setString(2, name);
            pst.executeUpdate();
            pst.close();
 
            pst = conn.prepareStatement("SELECT * FROM stock WHERE code = ?");
            pst.setString(1, codeTo);
            resultSet = pst.executeQuery();
            name = resultSet.getString(2);
            amount = resultSet.getDouble(3);
            pst.close();
 
            amount -= Double.parseDouble(amountTo);
 
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
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }
    
//    public Object[][] getStock(){
//        Object[][] ret;
//        try {
//            pst = conn.prepareStatement("SELECT * FROM stock");
//            ResultSet res = pst.executeQuery();
//            res.last();
//            
//            int i = res.getRow();
//        
//            ret = new Object[i - 1][2];
//            res.beforeFirst();
//            int j = 0;
//            while (res.next()) {
//                 String code = res.getString(2);
//                 double amount = res.getDouble(3);
//                 ret[j][0]=code;
//                 ret[j][1]=amount;
//                 j++;
//            }
//            return ret;
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//        } finally {
//            if (pst != null) {
//                try {
//                    pst.close();
//                } catch (SQLException e) {
//                    System.err.println(e.getMessage());
//                }
//            }
//        }
//        return null;
//        
//    }
}