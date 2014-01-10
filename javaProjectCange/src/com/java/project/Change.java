package com.java.project;

import java.text.NumberFormat;
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Change extends javax.swing.JFrame {

    public Change() {
        initComponents();
        
        new DataBase().updateCurrency();
        new DataBase().updateLocalTable(localRateTable);
        
        stockTable.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                int i = stockTable.getSelectedRow();
                if (i < stockTable.getRowCount() && i != -1) {
                    new DataBase().updateStock((double) stockTable.getModel().getValueAt(i, 2), (int) stockTable.getModel().getValueAt(i, 0));             
                }
            }
        });
        
        localRateTable.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                int i = localRateTable.getSelectedRow();
                new DataBase().updateLocal((int) localRateTable.getModel().getValueAt(i, 0), (double) localRateTable.getModel().getValueAt(i, 2), (double) localRateTable.getModel().getValueAt(i, 3));   
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        tabbedPanel = new javax.swing.JTabbedPane();
        buttonGroup = new javax.swing.JPanel();
        converterPanel = new javax.swing.JPanel();
        amoutFromLabel = new javax.swing.JLabel();
        amoutToLabel = new javax.swing.JLabel();
        chooseCodeFrom = new javax.swing.JComboBox();
        exchangeButton = new javax.swing.JButton();
        chooseCodeTo = new javax.swing.JComboBox();
        amountFromField = new javax.swing.JFormattedTextField();
        amountToField = new javax.swing.JFormattedTextField();
        buyRadio = new javax.swing.JRadioButton();
        sellRadio = new javax.swing.JRadioButton();
        invoiceCheck = new javax.swing.JCheckBox();
        tablesPanel = new javax.swing.JPanel();
        scrollPanelOne = new javax.swing.JScrollPane();
        bnbRateTable = new javax.swing.JTable();
        bnbLabel = new javax.swing.JLabel();
        scrollPanelTwo = new javax.swing.JScrollPane();
        localRateTable = new javax.swing.JTable();
        localRatesLabel = new javax.swing.JLabel();
        updateRateButton = new javax.swing.JButton();
        cashierPanel = new javax.swing.JPanel();
        scrollPanelThree = new javax.swing.JScrollPane();
        stockTable = new javax.swing.JTable();
        profitField = new javax.swing.JFormattedTextField();
        profitLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        scrollPanelFour = new javax.swing.JScrollPane();
        logArea = new javax.swing.JTextArea();
        stockLabel = new javax.swing.JLabel();
        chooseDate = new com.toedter.calendar.JDateChooser();
        menuBar = new javax.swing.JMenuBar();
        helpMenu = new javax.swing.JMenu();
        about = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Change");
        setResizable(false);

        converterPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Converter"));

        amoutFromLabel.setText("Amount");

        amoutToLabel.setText("Amount");

        chooseCodeFrom.setModel(new javax.swing.DefaultComboBoxModel(new DataBase().getCodes()));
        chooseCodeFrom.setPreferredSize(new java.awt.Dimension(120, 20));

        exchangeButton.setText("Exchange");
        exchangeButton.setPreferredSize(new java.awt.Dimension(145, 60));
        exchangeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exchangeButtonActionPerformed(evt);
            }
        });

        chooseCodeTo.setModel(new javax.swing.DefaultComboBoxModel(new DataBase().getCodes()));
        chooseCodeTo.setPreferredSize(new java.awt.Dimension(120, 20));

        amountFromField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        amountFromField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        amountFromField.setPreferredSize(new java.awt.Dimension(120, 20));
        amountFromField.setValue(new Double(0));

        amountToField.setEditable(false);
        amountToField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        amountToField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        amountToField.setPreferredSize(new java.awt.Dimension(120, 20));

        buttonGroup1.add(buyRadio);
        buyRadio.setSelected(true);
        buyRadio.setText("Buy");

        buttonGroup1.add(sellRadio);
        sellRadio.setText("Sell");

        invoiceCheck.setText("Invoice");

        javax.swing.GroupLayout converterPanelLayout = new javax.swing.GroupLayout(converterPanel);
        converterPanel.setLayout(converterPanelLayout);
        converterPanelLayout.setHorizontalGroup(
            converterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 451, Short.MAX_VALUE)
            .addGroup(converterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(converterPanelLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addGroup(converterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(converterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(amountFromField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(amoutFromLabel, javax.swing.GroupLayout.Alignment.LEADING))
                        .addComponent(chooseCodeFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(20, 20, 20)
                    .addGroup(converterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(converterPanelLayout.createSequentialGroup()
                            .addComponent(buyRadio)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(sellRadio)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(invoiceCheck))
                        .addComponent(exchangeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(20, 20, 20)
                    .addGroup(converterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(amountToField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(chooseCodeTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(amoutToLabel))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        converterPanelLayout.setVerticalGroup(
            converterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 143, Short.MAX_VALUE)
            .addGroup(converterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(converterPanelLayout.createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addGroup(converterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(converterPanelLayout.createSequentialGroup()
                            .addComponent(amoutToLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(amountToField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(40, 40, 40)
                            .addComponent(chooseCodeTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(converterPanelLayout.createSequentialGroup()
                            .addComponent(amoutFromLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(converterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(amountFromField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(exchangeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(converterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(buyRadio)
                                .addComponent(sellRadio)
                                .addComponent(invoiceCheck)
                                .addComponent(chooseCodeFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(18, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout buttonGroupLayout = new javax.swing.GroupLayout(buttonGroup);
        buttonGroup.setLayout(buttonGroupLayout);
        buttonGroupLayout.setHorizontalGroup(
            buttonGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonGroupLayout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(converterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
        );
        buttonGroupLayout.setVerticalGroup(
            buttonGroupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonGroupLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(converterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(200, Short.MAX_VALUE))
        );

        tabbedPanel.addTab("Converter", buttonGroup);

        scrollPanelOne.setPreferredSize(new java.awt.Dimension(300, 260));

        bnbRateTable.setModel(new javax.swing.table.DefaultTableModel(new Object[] { "Rate Name", "Rate" }, 0) {
            public boolean isCellEditable (int row, int col) {
                return false;
            }
        });
        new DataBase().updateBNBTable(bnbRateTable);

        javax.swing.table.TableColumn column = bnbRateTable.getColumnModel().getColumn(1);
        column.setCellRenderer(new DataRenderer());
        scrollPanelOne.setViewportView(bnbRateTable);

        bnbLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bnbLabel.setText("BNB's Rates");

        scrollPanelTwo.setPreferredSize(new java.awt.Dimension(300, 260));

        localRateTable.setModel(new javax.swing.table.DefaultTableModel(new Object[] { "", "Rate Name", "Buy", "Sell" }, 0) {
            public boolean isCellEditable (int row, int col) {
                if (col == 1) {
                    return false;
                }

                return true;
            }

            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        javax.swing.table.TableColumn tc = localRateTable.getColumnModel().getColumn(0);
        localRateTable.removeColumn(tc);

        column = localRateTable.getColumnModel().getColumn(1);
        column.setCellRenderer(new DataRenderer());

        column = localRateTable.getColumnModel().getColumn(2);
        column.setCellRenderer(new DataRenderer());
        scrollPanelTwo.setViewportView(localRateTable);

        localRatesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        localRatesLabel.setText("Local Rates");

        updateRateButton.setText("Update");
        updateRateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateRateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tablesPanelLayout = new javax.swing.GroupLayout(tablesPanel);
        tablesPanel.setLayout(tablesPanelLayout);
        tablesPanelLayout.setHorizontalGroup(
            tablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablesPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(tablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bnbLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateRateButton)
                    .addComponent(scrollPanelOne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90)
                .addGroup(tablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPanelTwo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(localRatesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        tablesPanelLayout.setVerticalGroup(
            tablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablesPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(tablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(localRatesLabel)
                    .addComponent(bnbLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(tablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPanelTwo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollPanelOne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(updateRateButton)
                .addGap(20, 20, 20))
        );

        tabbedPanel.addTab("Table", tablesPanel);

        scrollPanelThree.setPreferredSize(new java.awt.Dimension(300, 260));

        stockTable.setModel(new javax.swing.table.DefaultTableModel(new Object[] { "", "Code", "Stock" }, 0) {            public boolean isCellEditable (int row, int col) {
            if (col == 1) {
                return false;
            }

            return true;
        }

        Class[] types = new Class [] {
            java.lang.Integer.class, java.lang.String.class, java.lang.Double.class
        };

        public Class getColumnClass(int columnIndex) {
            return types [columnIndex];
        }
    });
    stockTable.getTableHeader().setReorderingAllowed(false);
    tc = stockTable.getColumnModel().getColumn(0);
    stockTable.removeColumn(tc);

    tc = stockTable.getColumnModel().getColumn(1);
    tc.setCellRenderer(new DataRenderer());

    new DataBase().updateStockTable(stockTable);
    scrollPanelThree.setViewportView(stockTable);

    profitField.setEditable(false);
    profitField.setText("0");

    profitLabel.setText("Profit");

    dateLabel.setText("Date");

    scrollPanelFour.setPreferredSize(new java.awt.Dimension(350, 260));

    logArea.setEditable(false);
    logArea.setColumns(20);
    logArea.setRows(5);
    scrollPanelFour.setViewportView(logArea);

    stockLabel.setText("Stock");

    chooseDate.setDate(new java.util.Date());
    chooseDate.setDateFormatString("yyyy-MM-dd");
    chooseDate.setPreferredSize(new java.awt.Dimension(150, 20));
    chooseDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
        public void propertyChange(java.beans.PropertyChangeEvent evt) {
            chooseDatePropertyChange(evt);
        }
    });

    javax.swing.GroupLayout cashierPanelLayout = new javax.swing.GroupLayout(cashierPanel);
    cashierPanel.setLayout(cashierPanelLayout);
    cashierPanelLayout.setHorizontalGroup(
        cashierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(cashierPanelLayout.createSequentialGroup()
            .addGap(25, 25, 25)
            .addGroup(cashierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(scrollPanelThree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(stockLabel))
            .addGap(40, 40, 40)
            .addGroup(cashierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(cashierPanelLayout.createSequentialGroup()
                    .addComponent(dateLabel)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(chooseDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(cashierPanelLayout.createSequentialGroup()
                    .addComponent(profitLabel)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(profitField, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(scrollPanelFour, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(25, 25, 25))
    );
    cashierPanelLayout.setVerticalGroup(
        cashierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(cashierPanelLayout.createSequentialGroup()
            .addGroup(cashierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cashierPanelLayout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addComponent(stockLabel)
                    .addGap(10, 10, 10))
                .addGroup(cashierPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(cashierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(chooseDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dateLabel))))
            .addGroup(cashierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(scrollPanelThree, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(scrollPanelFour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(cashierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(profitField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(profitLabel))
            .addContainerGap(47, Short.MAX_VALUE))
    );

    tabbedPanel.addTab("Cashier", cashierPanel);

    helpMenu.setText("Help");

    about.setText("About");
    about.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            aboutActionPerformed(evt);
        }
    });
    helpMenu.add(about);

    menuBar.add(helpMenu);

    setJMenuBar(menuBar);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(tabbedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tabbedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0))
    );

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    static class DataRenderer extends DefaultTableCellRenderer {
        
        private NumberFormat formatter;
        
        public DataRenderer() { super(); }

        @Override
        public void setValue(Object value) {
            if (formatter == null) {
                formatter = NumberFormat.getNumberInstance();
                formatter.setMaximumFractionDigits(5);
                formatter.setMinimumFractionDigits(2);            
            }
            
            setText((value == null) ? "0" : formatter.format(value));
            setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        }
    }

    private void clearContent(javax.swing.JTable table) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        
        for (int i = table.getRowCount() - 1; i >= 0; i--) {
            dtm.removeRow(i);
        }
    }
    
    private void updateRateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateRateButtonActionPerformed
        this.clearContent(bnbRateTable);
        DataBase dataBase = new DataBase();
        dataBase.updateCurrency();
        dataBase.updateBNBTable(bnbRateTable);
    }//GEN-LAST:event_updateRateButtonActionPerformed

    private void exchangeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exchangeButtonActionPerformed
        int i = chooseCodeFrom.getSelectedIndex();
        int j = chooseCodeTo.getSelectedIndex();
        
        Converter converter = null;
        double afterConvert = 0.0d;
        boolean checked = false;
        String codeFrom = null;
        String codeTo = null;
        
        
        if (buyRadio.isSelected()) {
            converter = new Converter(localRateTable, i, j, 2);
            afterConvert = converter.convertValue(amountFromField.getValue());
            checked = afterConvert < (double) stockTable.getValueAt(j, 1);
            codeFrom = String.valueOf(chooseCodeFrom.getSelectedItem());
            codeTo = String.valueOf(chooseCodeTo.getSelectedItem());
        } else {
            converter = new Converter(localRateTable, j, i, 3);
            afterConvert = converter.convertValue(amountFromField.getValue());
            checked = Double.parseDouble(amountFromField.getText()) < (double) stockTable.getValueAt(i, 1);
            codeFrom = String.valueOf(chooseCodeTo.getSelectedItem());
            codeTo = String.valueOf(chooseCodeFrom.getSelectedItem());
        }
        
        if (checked) {
            amountToField.setValue(afterConvert);
            double rate = converter.getRate();
            double amountFrom = ((Number) amountFromField.getValue()).doubleValue();
            double amountTo = ((Number) amountToField.getValue()).doubleValue();

            DataBase dataBase = new DataBase();
            dataBase.changeCurrencyInStock(amountFrom, codeFrom,  amountTo, codeTo);
            dataBase.updateLog(new Date(new java.util.Date().getTime()), codeFrom, amountFrom, rate, 
                    codeTo, amountTo);

            if (invoiceCheck.isSelected()) {
                new InvoiceDialog(this, true, codeFrom, amountFrom, rate, codeTo, amountTo).setVisible(true);
                invoiceCheck.setSelected(false);
            }
            
            this.clearContent(stockTable);
            dataBase.updateStockTable(stockTable);
        } else {
            JOptionPane.showMessageDialog(null, "Not enough in stock");
        }
    }//GEN-LAST:event_exchangeButtonActionPerformed

    private void chooseDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_chooseDatePropertyChange
        if (evt.getPropertyName().equals("date")) {
            logArea.setText(new DataBase().getLog(new java.sql.Date(chooseDate.getDate().getTime())));
            profitField.setValue(new DataBase().getProfit(new java.sql.Date(chooseDate.getDate().getTime())));
        }
    }//GEN-LAST:event_chooseDatePropertyChange

    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutActionPerformed
        JOptionPane.showMessageDialog(null, "Made by:\nIvo Mishev, Tony Monov,\nChristian Georgiev, Dyan Deyanov");
    }//GEN-LAST:event_aboutActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Change().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem about;
    private javax.swing.JFormattedTextField amountFromField;
    private javax.swing.JFormattedTextField amountToField;
    private javax.swing.JLabel amoutFromLabel;
    private javax.swing.JLabel amoutToLabel;
    private javax.swing.JLabel bnbLabel;
    private javax.swing.JTable bnbRateTable;
    private javax.swing.JPanel buttonGroup;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton buyRadio;
    private javax.swing.JPanel cashierPanel;
    private javax.swing.JComboBox chooseCodeFrom;
    private javax.swing.JComboBox chooseCodeTo;
    private com.toedter.calendar.JDateChooser chooseDate;
    private javax.swing.JPanel converterPanel;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JButton exchangeButton;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JCheckBox invoiceCheck;
    private javax.swing.JTable localRateTable;
    private javax.swing.JLabel localRatesLabel;
    private javax.swing.JTextArea logArea;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JFormattedTextField profitField;
    private javax.swing.JLabel profitLabel;
    private javax.swing.JScrollPane scrollPanelFour;
    private javax.swing.JScrollPane scrollPanelOne;
    private javax.swing.JScrollPane scrollPanelThree;
    private javax.swing.JScrollPane scrollPanelTwo;
    private javax.swing.JRadioButton sellRadio;
    private javax.swing.JLabel stockLabel;
    private javax.swing.JTable stockTable;
    private javax.swing.JTabbedPane tabbedPanel;
    private javax.swing.JPanel tablesPanel;
    private javax.swing.JButton updateRateButton;
    // End of variables declaration//GEN-END:variables
}