package org.example.view.dashboart.application.form.product;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


import jakarta.persistence.EntityManager;
import org.example.controller.productController.ProductController;
import org.example.controller.userController.UserInfoController;
import org.example.model.entities.Product;
import org.example.model.entities.UserApp;
import org.example.service.ServiceUserApp;
import org.example.view.crazypanel.CrazyPanel;
import org.example.view.crazypanel.FlatLafStyleComponent;
import org.example.view.crazypanel.MigLayoutConstraints;
import raven.toast.Notifications;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.parser.Entity;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ttanh
 */
public class FrameUpdateProduct extends javax.swing.JFrame {

    private final EntityManager em;

    private ProductForm productForm;
    private ProductController productController;
    public FrameUpdateProduct(EntityManager em, ProductForm product) {
        this.em = em;
        this.productForm = product;
        productController = new ProductController(em);
        initComponents();
        addDateTbl(jTable1);
    }

    private void addDateTbl(JTable table) {
        int id = productForm.getDataSelectTbl().getIdProduct();
        productController.showDataSuplierTbl(table, id);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        crazyPanel2 = new CrazyPanel();
        crazyPanel1 = new CrazyPanel();
        crazyPanel5 = new CrazyPanel();
        jLabel1 = new javax.swing.JLabel();
       //cmdAdd = new javax.swing.JButton();
        cmdDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        crazyPanel3 = new CrazyPanel();
        jLabel2 = new javax.swing.JLabel();
        txtIdProduct = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNameProduct = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        quantity = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNote = new javax.swing.JTextArea();
        crazyPanel4 = new CrazyPanel();
        cmdSave = new javax.swing.JButton();
        cmdExit = new javax.swing.JButton();

        txtIdProduct.setEditable(false);
        txtIdProduct.setText(String.valueOf(productForm.getDataSelectTbl().getIdProduct()));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        crazyPanel2.setMigLayoutConstraints(new MigLayoutConstraints(
                "wrap,fill,insets 15",
                "[fill]",
                "[fill]15[fill]15[grow 0]",
                null
        ));

        crazyPanel1.setMigLayoutConstraints(new MigLayoutConstraints(
                "wrap,fill",
                "[fill]",
                "[grow 0]10[fill]",
                null
        ));

        crazyPanel5.setFlatLafStyleComponent(new FlatLafStyleComponent(
                "",
                null
        ));
        crazyPanel5.setMigLayoutConstraints(new MigLayoutConstraints(
                "",
                "[]push[][]",
                "",
                null
        ));

        jLabel1.setText("Nhà cung cấp");
        crazyPanel5.add(jLabel1);

//        cmdAdd.setText("Add");
//        cmdAdd.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                cmdAddActionPerformed(evt);
//            }
//        });
//        crazyPanel5.add(cmdAdd);

        cmdDelete.setText("Delete");
        cmdDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDeleteActionPerformed(evt);
            }
        });
        crazyPanel5.add(cmdDelete);

        crazyPanel1.add(crazyPanel5);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Mã", "Tên", "Email", "phone"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1Event(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        crazyPanel1.add(jScrollPane1);

        crazyPanel2.add(crazyPanel1);

        crazyPanel3.setMigLayoutConstraints(new MigLayoutConstraints(
                "wrap 2,fillx,insets 25",
                "[grow 0,trail]15[fill]",
                "",
                null
        ));

        jLabel2.setText("Mã Sản phẩm");
        crazyPanel3.add(jLabel2);
        crazyPanel3.add(txtIdProduct);

        jLabel3.setText("Tên sản phẩm");
        crazyPanel3.add(jLabel3);
        crazyPanel3.add(txtNameProduct);

        jLabel7.setText("soLuong");
        crazyPanel3.add(jLabel7);

        crazyPanel3.add(quantity);

        jLabel4.setText("Giá");
        crazyPanel3.add(jLabel4);
        crazyPanel3.add(txtPrice);

        jLabel5.setText("Note");
        crazyPanel3.add(jLabel5);

        txtNote.setColumns(20);
        txtNote.setRows(5);
        jScrollPane2.setViewportView(txtNote);

        crazyPanel3.add(jScrollPane2);

        crazyPanel2.add(crazyPanel3);

        crazyPanel4.setMigLayoutConstraints(new MigLayoutConstraints(
                "",
                "push[][]",
                "",
                null
        ));

        cmdSave.setText("Save");
        cmdSave.addActionListener(e ->{
            try {
                int id = Integer.parseInt(txtIdProduct.getText());
                String name = txtNameProduct.getText();
                Long price = Long.valueOf(txtPrice.getText());
                String note = txtNote.getText();
                Long quan = Long.valueOf(quantity.getText());
                Product dataUpdate = productController.findProductById(id);
                dataUpdate.setQuantityProduct(quan);
                dataUpdate.setNameProduct(name);
                dataUpdate.setPrice(price);
                dataUpdate.setMota(note);

                List<UserApp> userAppList = new ArrayList<>();

                for (int i = 0; i < jTable1.getModel().getRowCount(); i++) {
                    ServiceUserApp serviceUserApp = new ServiceUserApp(em);
                    UserApp user = serviceUserApp.findUserAppById((Integer) jTable1.getModel().getValueAt(i, 0));
                    userAppList.add(user);
                }
                dataUpdate.setSupplier(userAppList);

                productController.updateProductInFrame(id, dataUpdate);
                Notifications.getInstance().show(Notifications.Type.SUCCESS, "cập nhật thành công");
            } catch (Exception exception){
                Notifications.getInstance().show(Notifications.Type.ERROR, "Cập nhật thất bại");
                exception.printStackTrace();
            }

        });
        crazyPanel4.add(cmdSave);

        cmdExit.setText("Exit");
        cmdExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdExitActionPerformed(evt);
            }
        });
        crazyPanel4.add(cmdExit);

        crazyPanel2.add(crazyPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(crazyPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(crazyPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void jLabel1Event(MouseEvent evt) {

    }

    private void cmdDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int row = jTable1.getSelectedRow();
        model.removeRow(row);
    }


    private void cmdExitActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }


    // Variables declaration - do not modify
    private javax.swing.JTextField quantity;
    //private javax.swing.JButton cmdAdd;
    private javax.swing.JButton cmdDelete;
    private javax.swing.JButton cmdExit;
    private javax.swing.JButton cmdSave;
    private CrazyPanel crazyPanel1;
    private CrazyPanel crazyPanel2;
    private CrazyPanel crazyPanel3;
    private CrazyPanel crazyPanel4;
    private CrazyPanel crazyPanel5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtIdProduct;
    private javax.swing.JTextField txtNameProduct;
    private javax.swing.JTextArea txtNote;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration
}
