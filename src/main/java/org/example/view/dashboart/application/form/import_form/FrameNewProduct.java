package org.example.view.dashboart.application.form.import_form;

import org.example.view.crazypanel.CrazyPanel;
import org.example.view.crazypanel.FlatLafStyleComponent;
import org.example.view.crazypanel.MigLayoutConstraints;

import javax.swing.*;


public class FrameNewProduct extends javax.swing.JFrame {


    public FrameNewProduct() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        crazyPanel1 = new CrazyPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtIdSupplier = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNameSupplier = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEmailSupplier = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNameProduct = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbUnit = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtNote = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        cmdSave = new javax.swing.JButton();
        cmdExit = new javax.swing.JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        crazyPanel1.setFlatLafStyleComponent(new FlatLafStyleComponent(
                "",
                new String[]{
                        "font:bold +2",
                        "font:bold +1",
                        "",
                        "showClearButton:true;JTextField.placeholderText=Mã nhà cung cấp",
                        "",
                        "showClearButton:true;JTextField.placeholderText=Tên",
                        "",
                        "showClearButton:true;JTextField.placeholderText=Email",
                        "",
                        "font:bold +1",
                        "",
                        "showClearButton:true;JTextField.placeholderText=Tên sản phẩm mới"
                }
        ));
        crazyPanel1.setMigLayoutConstraints(new MigLayoutConstraints(
                "wrap 2,fillx,insets 25",
                "[grow 0,trail]15[fill]",
                "",
                new String[]{
                        "wrap,al lead",
                        "wrap,al lead",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "span 2,grow 1",
                        "wrap,al lead",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "span 2,al trail",
                        "span 2,al trail",
                        "span 2,al trail",
                        ""
                }
        ));

        jLabel2.setText("Cung cấp thêm sản phẩm");
        crazyPanel1.add(jLabel2);

        jLabel5.setText("Thông tin nhà cung cấp");
        crazyPanel1.add(jLabel5);

        jLabel6.setText("Mã");
        crazyPanel1.add(jLabel6);
        crazyPanel1.add(txtIdSupplier);

        jLabel1.setText("Tên");
        crazyPanel1.add(jLabel1);
        crazyPanel1.add(txtNameSupplier);

        jLabel3.setText("Email");
        crazyPanel1.add(jLabel3);

        txtEmailSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailSupplierActionPerformed(evt);
            }
        });
        crazyPanel1.add(txtEmailSupplier);
        crazyPanel1.add(jSeparator1);

        jLabel9.setText("Thông tin sản phẩm mới");
        crazyPanel1.add(jLabel9);

        jLabel4.setText("Tên sản phẩm mới");
        crazyPanel1.add(jLabel4);
        crazyPanel1.add(txtNameProduct);

        jLabel7.setText("Đơn vị");
        crazyPanel1.add(jLabel7);

        cmbUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "m", "l", "kg", " " }));
        cmbUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbUnitActionPerformed(evt);
            }
        });
        crazyPanel1.add(cmbUnit);

        jLabel8.setText("Giá bán");
        crazyPanel1.add(jLabel8);
        crazyPanel1.add(txtPrice);

        jLabel10.setText("Note");
        crazyPanel1.add(jLabel10);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        txtNote.setViewportView(jTextArea1);

        crazyPanel1.add(txtNote);

        cmdSave.setText("Save");
        cmdSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSaveActionPerformed(evt);
            }
        });
        crazyPanel1.add(cmdSave);

        cmdExit.setText("Exit");
        cmdExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdExitActionPerformed(evt);
            }
        });
        crazyPanel1.add(cmdExit);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(crazyPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(crazyPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void txtEmailSupplierActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void cmbUnitActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void cmdSaveActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void cmdExitActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify
    private javax.swing.JComboBox<String> cmbUnit;
    private javax.swing.JButton cmdExit;
    private javax.swing.JButton cmdSave;
    private CrazyPanel crazyPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField txtEmailSupplier;
    private javax.swing.JTextField txtIdSupplier;
    private javax.swing.JTextField txtNameProduct;
    private javax.swing.JTextField txtNameSupplier;
    private javax.swing.JScrollPane txtNote;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration
}
