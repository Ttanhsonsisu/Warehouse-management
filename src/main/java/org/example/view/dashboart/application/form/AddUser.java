package org.example.view.dashboart.application.form;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import org.example.controller.userController.AddFormController;
import org.example.model.entities.UserApp;
import org.example.model.entities.enums.UserRole;
import org.example.view.dashboart.application.form.other.UserInfo;
import raven.toast.Notifications;

import javax.swing.JProgressBar;


public class AddUser extends javax.swing.JFrame {

    private final EntityManager em;

    private AddFormController addFormController;

    private UserInfo userInfo;

    @Getter
    private UserApp dataSave;

    public AddUser(EntityManager em , UserInfo userInfo) {
        this.em = em;
        this.userInfo = userInfo;
//        FlatRobotoFont.install();
//        FlatLaf.registerCustomDefaultsSource("theme");
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
        txtPhoneNumber = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        ccbRole = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        txtProductSupplier = new javax.swing.JTextField();
        cmdSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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
        crazyPanel1.setName(""); // NOI18N

        jLabel1.setText("THÊM THÔNG TIN NGƯỜI DÙNG ");
        crazyPanel1.add(jLabel1);

        jLabel4.setText("Họ và tên");
        crazyPanel1.add(jLabel4);
        crazyPanel1.add(txtName);

        jLabel5.setText("UserName & Email");
        crazyPanel1.add(jLabel5);
        crazyPanel1.add(txtUserName);

        jLabel6.setText("Số điện thoại");
        crazyPanel1.add(jLabel6);
        crazyPanel1.add(txtPhoneNumber);

        jLabel16.setText("Password");
        crazyPanel1.add(jLabel16);
        crazyPanel1.add(txtPassword);
        crazyPanel1.add(jSeparator1);

        jLabel7.setText("Thông tin thêm");
        crazyPanel1.add(jLabel7);

        jLabel12.setText("Role");
        crazyPanel1.add(jLabel12);

        ccbRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Supplier", "Client" }));
        crazyPanel1.add(ccbRole);

        jLabel13.setText("Product Supplier");
        crazyPanel1.add(jLabel13);
        crazyPanel1.add(txtProductSupplier);

        cmdSave.setText("Save");
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
                        .addComponent(crazyPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmdSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSaveActionPerformed
        boolean check = false;

        String name = txtName.getText();

        String email = txtUserName.getText();
        String phoneNumber = txtPhoneNumber.getText();
        String password = txtPassword.getText();
        String role = (String) ccbRole.getSelectedItem();

        dataSave = new UserApp();

        // show log data logn
        System.out.println(name+" "+email+" "+password+" "+role);

        if(name == "" & email == "" & password == "" ) {
            System.out.print("no info");
        } else {
            dataSave.setName(name);
            dataSave.setEmail(email);
            dataSave.setUserName(email);
            dataSave.setPassword(password);
            dataSave.setPhoneNumber(phoneNumber);

            if (role == "Admin") {
                dataSave.setRole(UserRole.ADMIN);
            } else if (role == "Supplier") {
                dataSave.setRole(UserRole.SUPPLIER);
            } else if (role == "Client") {
                dataSave.setRole(UserRole.CLIENT);
            } else {
                dataSave.setRole(UserRole.OTHER);
            }

            //System.out.println("adduser");
        }
try {
    addFormController = new AddFormController(em);
    check = addFormController.addUser(this);
    //System.out.println(name + " " + email + " " + password + " " + role);

} catch(Exception e) {
    e.printStackTrace();
} finally {
    if (!check) {
        Notifications.getInstance().show(Notifications.Type.WARNING, "chưa có thông tin");
    } else if (check) {
        userInfo.updataDataTbl();
        Notifications.getInstance().show(Notifications.Type.SUCCESS, "Thay đổi thông tin thành công");
        this.dispose();
    }
}
    }//GEN-LAST:event_cmdSaveActionPerformed

//    public static void main(String args[]) {
//        FlatRobotoFont.install();
//        FlatLaf.registerCustomDefaultsSource("crazypanel");
//        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
//        FlatMacLightLaf.setup();
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new AddUser().setVisible(true);
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
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtProductSupplier;
    private javax.swing.JTextField txtUserName;
//     End of variables declaration//GEN-END:variables
}
