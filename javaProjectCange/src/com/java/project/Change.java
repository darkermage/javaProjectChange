package com.java.project;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Change extends javax.swing.JFrame {

    public Change() {
        initComponents();
        new DataBase().updateCurrency();
        new DataBase().updateLocalTable(localRateTable);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPanel = new javax.swing.JTabbedPane();
        tablesPanel = new javax.swing.JPanel();
        scrollPanelOne = new javax.swing.JScrollPane();
        bnbRateTable = new javax.swing.JTable();
        bnbLabel = new javax.swing.JLabel();
        scrollPanelTwo = new javax.swing.JScrollPane();
        localRateTable = new javax.swing.JTable();
        localRatesLabel = new javax.swing.JLabel();
        editLocalButton = new javax.swing.JButton();
        updateRateButton = new javax.swing.JButton();
        saveLocalButton = new javax.swing.JButton();
        cashierPanel = new javax.swing.JPanel();
        scrollPanelThree = new javax.swing.JScrollPane();
        stockTable = new javax.swing.JTable();
        editStockButton = new javax.swing.JButton();
        profitField = new javax.swing.JFormattedTextField();
        profitLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        scrollPanelFour = new javax.swing.JScrollPane();
        logArea = new javax.swing.JTextArea();
        saveStockButton = new javax.swing.JButton();
        stockLabel = new javax.swing.JLabel();
        chooseDate = new com.toedter.calendar.JDateChooser();
        convertorPanel = new javax.swing.JPanel();
        chooseCodeFrom = new javax.swing.JComboBox();
        exchangeButton = new javax.swing.JButton();
        chooseCodeTo = new javax.swing.JComboBox();
        amountFromField = new javax.swing.JFormattedTextField();
        amountToField = new javax.swing.JFormattedTextField();
        buyRadio = new javax.swing.JRadioButton();
        sellRadio = new javax.swing.JRadioButton();
        invoiceCheck = new javax.swing.JCheckBox();
        amoutFromLabel = new javax.swing.JLabel();
        amoutToLabel = new javax.swing.JLabel();
        outputField = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Change");
        setResizable(false);

        scrollPanelOne.setPreferredSize(new java.awt.Dimension(300, 260));

        bnbRateTable.setModel(new javax.swing.table.DefaultTableModel(new Object[] { "Rate Name", "Rate" }, 0));
        bnbRateTable.setEnabled(false);
        new DataBase().updateBNBTable(bnbRateTable);
        scrollPanelOne.setViewportView(bnbRateTable);

        bnbLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bnbLabel.setText("BNB's Rates");

        scrollPanelTwo.setPreferredSize(new java.awt.Dimension(300, 260));

        localRateTable.setModel(new javax.swing.table.DefaultTableModel(new Object[] { "", "Rate Name", "Buy", "Sell" }, 0));
        javax.swing.table.TableColumn tc = localRateTable.getColumnModel().getColumn(0);
        localRateTable.removeColumn(tc);
        scrollPanelTwo.setViewportView(localRateTable);

        localRatesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        localRatesLabel.setText("Local Rates");

        editLocalButton.setText("Edit");
        editLocalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editLocalButtonActionPerformed(evt);
            }
        });

        updateRateButton.setText("Update");
        updateRateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateRateButtonActionPerformed(evt);
            }
        });

        saveLocalButton.setText("Save");
        saveLocalButton.setEnabled(false);
        saveLocalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveLocalButtonActionPerformed(evt);
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
                    .addGroup(tablesPanelLayout.createSequentialGroup()
                        .addComponent(editLocalButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveLocalButton))
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
                .addGroup(tablesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editLocalButton)
                    .addComponent(updateRateButton)
                    .addComponent(saveLocalButton))
                .addGap(20, 20, 20))
        );

        tabbedPanel.addTab("Table", tablesPanel);

        scrollPanelThree.setPreferredSize(new java.awt.Dimension(300, 260));

        stockTable.setModel(new javax.swing.table.DefaultTableModel(new Object[] { "", "Code", "Stock" }, 0));
        stockTable.setEnabled(false);
        stockTable.getTableHeader().setReorderingAllowed(false);
        tc = stockTable.getColumnModel().getColumn(0);
        stockTable.removeColumn(tc);

        new DataBase().updateStockTable(stockTable);
        scrollPanelThree.setViewportView(stockTable);

        editStockButton.setText("Edit");
        editStockButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editStockButtonActionPerformed(evt);
            }
        });

        profitField.setEditable(false);
        profitField.setText("0");

        profitLabel.setText("Profit");

        dateLabel.setText("Date");

        scrollPanelFour.setPreferredSize(new java.awt.Dimension(350, 260));

        logArea.setEditable(false);
        logArea.setColumns(20);
        logArea.setRows(5);
        scrollPanelFour.setViewportView(logArea);

        saveStockButton.setText("Save");
        saveStockButton.setEnabled(false);
        saveStockButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveStockButtonActionPerformed(evt);
            }
        });

        stockLabel.setText("Stock");

        chooseDate.setDate(new java.util.Date());
        chooseDate.setDateFormatString("dd-MM-yyyy");
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
                    .addGroup(cashierPanelLayout.createSequentialGroup()
                        .addComponent(editStockButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveStockButton))
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
                .addGroup(cashierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cashierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(editStockButton)
                        .addComponent(saveStockButton))
                    .addGroup(cashierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(profitField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(profitLabel)))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        tabbedPanel.addTab("Cashier", cashierPanel);

        chooseCodeFrom.setModel(new javax.swing.DefaultComboBoxModel(new DataBase().getCodes()));
        chooseCodeFrom.setPreferredSize(new java.awt.Dimension(120, 20));
        chooseCodeFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseCodeFromActionPerformed(evt);
            }
        });

        exchangeButton.setText("Exchange");
        exchangeButton.setPreferredSize(new java.awt.Dimension(145, 60));
        exchangeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exchangeButtonActionPerformed(evt);
            }
        });

        chooseCodeTo.setModel(new javax.swing.DefaultComboBoxModel(new DataBase().getCodes()));
        chooseCodeTo.setPreferredSize(new java.awt.Dimension(120, 20));

        amountFromField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###"))));
        amountFromField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        amountFromField.setPreferredSize(new java.awt.Dimension(120, 20));
        amountFromField.setValue(0);
        amountFromField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountFromFieldActionPerformed(evt);
            }
        });

        amountToField.setEditable(false);
        amountToField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###"))));
        amountToField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        amountToField.setPreferredSize(new java.awt.Dimension(120, 20));

        buyRadio.setSelected(true);
        buyRadio.setText("Buy");

        sellRadio.setText("Sell");

        invoiceCheck.setText("Invoice");

        amoutFromLabel.setText("Amount");

        amoutToLabel.setText("Amount");

        outputField.setEditable(false);
        outputField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###"))));
        outputField.setPreferredSize(new java.awt.Dimension(145, 20));
        outputField.setValue(0);

        javax.swing.GroupLayout convertorPanelLayout = new javax.swing.GroupLayout(convertorPanel);
        convertorPanel.setLayout(convertorPanelLayout);
        convertorPanelLayout.setHorizontalGroup(
            convertorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(convertorPanelLayout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addGroup(convertorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(convertorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(amountFromField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(amoutFromLabel, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(chooseCodeFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(convertorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(outputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(convertorPanelLayout.createSequentialGroup()
                        .addGroup(convertorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(convertorPanelLayout.createSequentialGroup()
                                .addComponent(buyRadio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sellRadio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(invoiceCheck))
                            .addComponent(exchangeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(convertorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(amountToField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chooseCodeTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(amoutToLabel))))
                .addContainerGap(153, Short.MAX_VALUE))
        );
        convertorPanelLayout.setVerticalGroup(
            convertorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(convertorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(convertorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(convertorPanelLayout.createSequentialGroup()
                        .addComponent(amoutToLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(amountToField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(chooseCodeTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(convertorPanelLayout.createSequentialGroup()
                        .addComponent(amoutFromLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(convertorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(amountFromField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(exchangeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(convertorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buyRadio)
                            .addComponent(sellRadio)
                            .addComponent(invoiceCheck)
                            .addComponent(chooseCodeFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(outputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(236, Short.MAX_VALUE))
        );

        tabbedPanel.addTab("Convertor", convertorPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabbedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void clearContent(javax.swing.JTable table) {
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        
        for (int i = table.getRowCount() - 1; i >= 0; i--) {
            dtm.removeRow(i);
        }
    }
    
    private void editLocalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editLocalButtonActionPerformed
        saveLocalButton.setEnabled(true);
        localRateTable.setEnabled(true);
    }//GEN-LAST:event_editLocalButtonActionPerformed

    private void updateRateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateRateButtonActionPerformed
        this.clearContent(bnbRateTable);
        DataBase dataBase = new DataBase();
        dataBase.updateCurrency();
        dataBase.updateBNBTable(bnbRateTable);
    }//GEN-LAST:event_updateRateButtonActionPerformed

    private void saveLocalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveLocalButtonActionPerformed
        saveLocalButton.setEnabled(false);
        localRateTable.setEnabled(false);
    }//GEN-LAST:event_saveLocalButtonActionPerformed

    private void editStockButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editStockButtonActionPerformed
        saveStockButton.setEnabled(true);
        stockTable.setEnabled(true);
    }//GEN-LAST:event_editStockButtonActionPerformed

    private void saveStockButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveStockButtonActionPerformed
        saveStockButton.setEnabled(false);
        stockTable.setEnabled(false);

        for (int i = 0; i < stockTable.getRowCount(); i++) {
            new DataBase().updateStock((double) stockTable.getModel().getValueAt(i, 1), (int) stockTable.getModel().getValueAt(i, 0));
        }
    }//GEN-LAST:event_saveStockButtonActionPerformed

    private void chooseCodeFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseCodeFromActionPerformed

    }//GEN-LAST:event_chooseCodeFromActionPerformed

    private void exchangeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exchangeButtonActionPerformed
        int i = chooseCodeFrom.getSelectedIndex();
        int j = chooseCodeTo.getSelectedIndex();
        
        if (buyRadio.isSelected()) {
            Converter converter = new Converter(localRateTable, i, j);
            outputField.setValue(converter.convertValue(amountFromField.getValue()));
        } else {
            Converter converter = new Converter(localRateTable, j, i);
            outputField.setValue(converter.convertValue(amountFromField.getValue()));
        }
        
        if (invoiceCheck.isSelected()) {
            new InvoiceDialog(this, true).setVisible(true);
            invoiceCheck.setSelected(false);
        }
    }//GEN-LAST:event_exchangeButtonActionPerformed

    private void amountFromFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountFromFieldActionPerformed

    }//GEN-LAST:event_amountFromFieldActionPerformed

    private void chooseDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_chooseDatePropertyChange
        if (evt.getPropertyName().equals("date")) {
            logArea.setText(new DataBase().getLog(new java.sql.Date(chooseDate.getDate().getTime())));
        }
    }//GEN-LAST:event_chooseDatePropertyChange

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Change().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField amountFromField;
    private javax.swing.JFormattedTextField amountToField;
    private javax.swing.JLabel amoutFromLabel;
    private javax.swing.JLabel amoutToLabel;
    private javax.swing.JLabel bnbLabel;
    private javax.swing.JTable bnbRateTable;
    private javax.swing.JRadioButton buyRadio;
    private javax.swing.JPanel cashierPanel;
    private javax.swing.JComboBox chooseCodeFrom;
    private javax.swing.JComboBox chooseCodeTo;
    private com.toedter.calendar.JDateChooser chooseDate;
    private javax.swing.JPanel convertorPanel;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JButton editLocalButton;
    private javax.swing.JButton editStockButton;
    private javax.swing.JButton exchangeButton;
    private javax.swing.JCheckBox invoiceCheck;
    private javax.swing.JTable localRateTable;
    private javax.swing.JLabel localRatesLabel;
    private javax.swing.JTextArea logArea;
    private javax.swing.JFormattedTextField outputField;
    private javax.swing.JFormattedTextField profitField;
    private javax.swing.JLabel profitLabel;
    private javax.swing.JButton saveLocalButton;
    private javax.swing.JButton saveStockButton;
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