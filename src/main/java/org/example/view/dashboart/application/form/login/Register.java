package org.example.view.dashboart.application.form.login;

import com.formdev.flatlaf.FlatClientProperties;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.Setter;
import net.miginfocom.swing.MigLayout;

import org.example.controller.RegisterController;
import org.example.model.entities.UserApp;
import org.example.model.entities.enums.UserRole;
import org.example.view.dashboart.application.Application;

import org.example.view.dashboart.application.form.login.component.PasswordStrengthStatus;
import raven.toast.Notifications;


import javax.swing.*;
import java.awt.*;


public class Register extends JPanel {
    @Getter
    private UserApp dataRegister;

    private RegisterController registerController;

    private final EntityManager em;

    public Register(EntityManager em) {
        this.em = em;
        dataRegister = new UserApp();
        init();
    }

    private void init() {
        setLayout(new MigLayout("fill,insets 20", "[center]", "[center]"));
        txtFirstName = new JTextField();
        txtLastName = new JTextField();
        txtUsername = new JTextField();
        txtPhoneNumber = new JTextField();
        txtPassword = new JPasswordField();
        txtConfirmPassword = new JPasswordField();

        cmdRegister = new JButton("Đăng kí");

        cmdRegister.addActionListener(e -> {
            if (isMatchPassword()) {
               dataRegister = new UserApp();
               String name = txtFirstName.getText() + " " + txtLastName.getText();
               String password = new String(txtPassword.getPassword());
               String email = txtUsername.getText();
               String phoneNumber = txtPhoneNumber.getText();
               dataRegister.setName(name);
               dataRegister.setUserName(email);
               dataRegister.setPassword(password);
               dataRegister.setEmail(email);
               dataRegister.setPhoneNumber(phoneNumber);

               if(jrClient.isSelected()) {
                   dataRegister.setRole(UserRole.CLIENT);
               } else if(jrSupplier.isSelected()) {
                   dataRegister.setRole(UserRole.SUPPLIER);
               } else {
                   dataRegister.setRole(UserRole.OTHER);
               }
               // connect to controller
                registerController = new RegisterController(em);
                registerController.register(this);

                //
                System.out.println(dataRegister.toString());
                Notifications.getInstance().show(Notifications.Type.SUCCESS, "Tài khoản"+ name +" +đã sản sàng");

//                try {
//                    Integer timeOut = 2000;
//                    Notifications.getInstance().show(Notifications.Type.INFO , "Hệ thống sẽ tự động chuyển đăng nhập trong " + timeOut);
//                    Thread.sleep(timeOut);
//                } catch (InterruptedException ex) {
//                    throw new RuntimeException(ex);
//
//                } finally {
//                    Application.changeFormLoginRegister("login");
//                }
            } else {
                Notifications.getInstance().show(Notifications.Type.WARNING, "Passwords don't match. Try again!");
            }
        });
        passwordStrengthStatus = new PasswordStrengthStatus();

        JPanel panel = new JPanel(new MigLayout("wrap,fillx,insets 35 45 30 45", "[fill,360]"));
        panel.putClientProperty(FlatClientProperties.STYLE, "" +
                "arc:20;" +
                "[light]background:darken(@background,3%);" +
                "[dark]background:lighten(@background,3%)");

        txtFirstName.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "First name");
        txtLastName.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Last name");
        txtUsername.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter your username or email");
       txtPhoneNumber.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter your phone number");
        txtPassword.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter your password");
        txtConfirmPassword.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Re-enter your password");
        txtPassword.putClientProperty(FlatClientProperties.STYLE, "" +
                "showRevealButton:true");
        txtConfirmPassword.putClientProperty(FlatClientProperties.STYLE, "" +
                "showRevealButton:true");

        cmdRegister.putClientProperty(FlatClientProperties.STYLE, "" +
                "[light]background:darken(@background,10%);" +
                "[dark]background:lighten(@background,10%);" +
                "borderWidth:0;" +
                "focusWidth:0;" +
                "innerFocusWidth:0");

        JLabel lbTitle = new JLabel("Chào mừng đến với app");
        JLabel description = new JLabel("tạo tài khoản ");
        lbTitle.putClientProperty(FlatClientProperties.STYLE, "" +
                "font:bold +10");
        description.putClientProperty(FlatClientProperties.STYLE, "" +
                "[light]foreground:lighten(@foreground,30%);" +
                "[dark]foreground:darken(@foreground,30%)");

        passwordStrengthStatus.initPasswordField(txtPassword);

        panel.add(lbTitle);
        panel.add(description);
        panel.add(new JLabel("Full Name"), "gapy 10");
        panel.add(txtFirstName, "split 2");
        panel.add(txtLastName);
        panel.add(new JLabel("loại người dùng"), "gapy 8");
        panel.add(createGenderPanel());
        panel.add(new JSeparator(), "gapy 5 5");
        panel.add(new JLabel("Tài khoản và Email"));
        panel.add(txtUsername);
        panel.add(new JLabel("Password"), "gapy 8");
        panel.add(txtPhoneNumber);
        panel.add(new JLabel("Confirm Password"), "gapy 8");
        panel.add(txtPassword);
        panel.add(passwordStrengthStatus, "gapy 0");
        panel.add(new JLabel("Confirm Password"), "gapy 0");
        panel.add(txtConfirmPassword);
        panel.add(cmdRegister, "gapy 20");
        panel.add(createLoginLabel(), "gapy 10");
        add(panel);
    }

    private Component createGenderPanel() {
        JPanel panel = new JPanel(new MigLayout("insets 0"));
        panel.putClientProperty(FlatClientProperties.STYLE, "" +
                "background:null");
        jrClient = new JRadioButton("khách hàng");
        jrSupplier = new JRadioButton("nhà cùng cấp");
        groupUser = new ButtonGroup();
        groupUser.add(jrClient);
        groupUser.add(jrSupplier);
        jrClient.setSelected(true);
        panel.add(jrClient);
        panel.add(jrSupplier);


        return panel;
    }

    private Component createLoginLabel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panel.putClientProperty(FlatClientProperties.STYLE, "" +
                "background:null");
        JButton cmdLogin = new JButton("<html><a href=\"#\">Đăng nhập</a></html>");
        cmdLogin.putClientProperty(FlatClientProperties.STYLE, "" +
                "border:3,3,3,3");
        cmdLogin.setContentAreaFilled(false);
        cmdLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));

        cmdLogin.addActionListener(e -> {
            Application.changeFormLoginRegister("login");
        });

        JLabel label = new JLabel("Đã có tài khoản rồi ?"); // englist :)) Already have an account
        label.putClientProperty(FlatClientProperties.STYLE, "" +
                "[light]foreground:lighten(@foreground,30%);" +
                "[dark]foreground:darken(@foreground,30%)");
        panel.add(label);
        panel.add(cmdLogin);
        return panel;
    }

    public boolean isMatchPassword() {
        String password = String.valueOf(txtPassword.getPassword());
        String confirmPassword = String.valueOf(txtConfirmPassword.getPassword());
        return password.equals(confirmPassword);
    }

    private JTextField txtFirstName;
    private JTextField txtLastName;
    private JRadioButton jrClient;
    private JRadioButton jrSupplier;
    private JTextField txtUsername;
    private  JTextField txtPhoneNumber;
    private JPasswordField txtPassword;
    private JPasswordField txtConfirmPassword;
    private ButtonGroup groupUser;
    private JButton cmdRegister;
    private PasswordStrengthStatus passwordStrengthStatus;
}
