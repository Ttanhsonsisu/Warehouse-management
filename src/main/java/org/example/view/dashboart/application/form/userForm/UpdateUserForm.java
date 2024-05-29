package org.example.view.dashboart.application.form.userForm;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.Setter;
import org.example.controller.userController.UpdateUserController;
import org.example.model.entities.UserApp;
import raven.toast.Notifications;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class UpdateUserForm extends javax.swing.JFrame {

    private final EntityManager em;

    @Setter @Getter
    private UserApp data;

    private UserInfo userInfo;

    private UpdateUserController updateUserController;

    public UpdateUserForm(EntityManager em , UserInfo userInfo) {
        this.em = em;

        this.userInfo = userInfo;
//        FlatRobotoFont.install();
//        FlatLaf.registerCustomDefaultsSource("crazypanel");
//        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
//        FlatMacLightLaf.setup();
        initComponents();
        new JProgressBar().setIndeterminate(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        crazyPanel1 = new org.example.view.crazypanel.CrazyPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        ccbRole = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        txtProductSupplier = new javax.swing.JTextField();
        cmdSave = new javax.swing.JButton();

        txtProductSupplier.setEditable(false);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        crazyPanel1.setMigLayoutConstraints(new org.example.view.crazypanel.MigLayoutConstraints(
                "wrap 2,fillx,insets 25",
                "[grow 0,trail]15[fill]",
                "",
                new String[]{
                        "wrap,al lead",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "span 2,grow 1",
                        "wrap,al lead",
                        "wrap,al lead",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "span 2,al trail"
                }
        ));

        jLabel1.setText("SỬA THÔNG TIN USER");
        crazyPanel1.add(jLabel1);

        jLabel4.setText("Họ và tên");
        crazyPanel1.add(jLabel4);
        crazyPanel1.add(txtName);

        jLabel5.setText("UserName & email");
        crazyPanel1.add(jLabel5);

        txtUserName.setEditable(false);
        crazyPanel1.add(txtUserName);

        jLabel6.setText("Số điện thoại");
        crazyPanel1.add(jLabel6);

        txtEmail.setEditable(false);
        crazyPanel1.add(txtEmail);

        jLabel16.setText("Password");
        crazyPanel1.add(jLabel16);
        crazyPanel1.add(txtPassword);
        crazyPanel1.add(jSeparator1);

        jLabel7.setText("Thông tin thêm");
        crazyPanel1.add(jLabel7);

        jLabel12.setText("Role");
        crazyPanel1.add(jLabel12);

        ccbRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Supplier", "Client" }));

        txtUserName.setText(userInfo.getDataSelectTbl().getUserName());
        txtEmail.setText(userInfo.getDataSelectTbl().getEmail());
        txtPassword.setText(userInfo.getDataSelectTbl().getPassword());
        txtName.setText(userInfo.getDataSelectTbl().getName());


        crazyPanel1.add(ccbRole);

        jLabel13.setText("Product Supplier");
        crazyPanel1.add(jLabel13);
        crazyPanel1.add(txtProductSupplier);

        cmdSave.setText("Save");
        ccbRole.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) {
                System.out.println(ccbRole.getSelectedItem());
            if (ccbRole.getSelectedItem().equals("Admin")) {
                txtProductSupplier.setEditable(true);
                System.out.print(1);
            } else if (ccbRole.getSelectedItem().equals("Supplier")) {
                txtProductSupplier.setEditable(true);
            } else {
                txtProductSupplier.setText("");
                txtProductSupplier.setEditable(false);
            }
        }});
        cmdSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                cmdSaveActionPerformed(evt);

            }
        });
        crazyPanel1.add(cmdSave);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(crazyPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(crazyPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmdSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSaveActionPerformed

        String name = txtName.getText();
        //String email = txtEmail.getText();
        String password = txtPassword.getText();
        String role = (String) ccbRole.getSelectedItem();
        String email = txtEmail.getText();

        //String phoneNumber = txt
        String productSupplier = (String) txtProductSupplier.getText();

        data = new UserApp();
        data.setEmail(email);
        data.setName(name);

       try {
           data.setPassword(password);
           updateUserController = new UpdateUserController(em);
           updateUserController.updateUser(this);
           System.out.println("updateUser");

           Notifications.getInstance().show(Notifications.Type.SUCCESS, "Bạn đã thay đổi thông tin thành công");
       } catch (Exception e) {
           e.printStackTrace();
       } finally {


           //userInfo.updataDataTbl(userInfo.getJTable1());
           // update info for table;
           userInfo.updataDataTbl();
           this.dispose();
       }

    }//GEN-LAST:event_cmdSaveActionPerformed

//    public static void main(String args[]) {
//
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new UpdateUser().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ccbRole;
    private javax.swing.JButton cmdSave;
    private org.example.view.crazypanel.CrazyPanel crazyPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtProductSupplier;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
