package com.java.project;

/**
 * A class that contains a dialog window used to collect from the customer the
 * information needed to generate an invoice.
 * 
 * @author Ivo Mishev 
 * @author Kristiyan Georgiev
 * @author Tony Monov
 * @author Deyan Deyanov 
 */

public class InvoiceDialog extends javax.swing.JDialog {

    private static String codeFrom, codeTo;
    private static double amountFrom, rate, amountTo;
    
     /**
     * 7 - Argument constructor.
     * 
     * @param parent        The owner of the dialog
     * @param modal         The specified modality
     * @param codeFrom      The name of the input currency
     * @param amountFrom    The amount from the input currency
     * @param rate          The rate used for the exchange
     * @param codeTo        The name of the output currency
     * @param amountTo      The amount from the output currency
     */
    
    public InvoiceDialog(java.awt.Frame parent, boolean modal, String codeFrom, double amountFrom, double rate, String codeTo, double amountTo) {
        super(parent, modal);
        initComponents();
        
        InvoiceDialog.codeFrom = codeFrom;
        InvoiceDialog.amountFrom = amountFrom;
        InvoiceDialog.rate = rate;
        InvoiceDialog.codeTo = codeTo;
        InvoiceDialog.amountTo = amountTo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        saveButton = new javax.swing.JButton();
        egnLabel = new javax.swing.JLabel();
        cityField = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        egnField = new javax.swing.JTextField();
        cityLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Invoice");
        setResizable(false);

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        egnLabel.setText("EGN");

        cityField.setPreferredSize(new java.awt.Dimension(150, 20));

        nameField.setPreferredSize(new java.awt.Dimension(150, 20));

        nameLabel.setText("Name");

        egnField.setPreferredSize(new java.awt.Dimension(150, 20));

        cityLabel.setText("City");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveButton)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLabel)
                            .addComponent(cityLabel)
                            .addComponent(egnLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(egnField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cityLabel)
                    .addComponent(cityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(egnLabel)
                    .addComponent(egnField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveButton)
                .addGap(10, 10, 10))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        Invoice invoice = new Invoice(nameField.getText(), cityField.getText(), egnField.getText());
        invoice.setInvoice("C:\\invoice.txt", codeFrom, "buy", amountFrom, rate, codeTo, amountTo);
        this.dispose();
    }//GEN-LAST:event_saveButtonActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                InvoiceDialog dialog = new InvoiceDialog(new javax.swing.JFrame(), true, codeFrom, amountFrom, rate, codeTo, amountTo);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cityField;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JTextField egnField;
    private javax.swing.JLabel egnLabel;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}