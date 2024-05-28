package org.example.view.dashboart.application.form.login;

import com.formdev.flatlaf.FlatClientProperties;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import net.miginfocom.swing.MigLayout;
import org.example.controller.userController.LoginController;
import org.example.model.entities.UserApp;
import org.example.view.dashboart.application.Application;
import org.example.view.dashboart.application.form.login.util.UserSession;


import javax.swing.*;
import java.awt.*;

public class Login extends JPanel {

    @Getter
    private static UserApp dataLogin;

    public static void setFulldataLogin(UserApp data) {
        dataLogin = data;
    }

    private final EntityManager em;

    public Login(EntityManager em) {
        this.em = em;
        init();

    }

    private void init() {
        setLayout(new MigLayout("fill,insets 20", "[center]", "[center]"));
        txtUsername = new JTextField();
        txtPassword = new JPasswordField();
        chRememberMe = new JCheckBox("Remember me");
        cmdLogin = new JButton("Login");
        JPanel panel = new JPanel(new MigLayout("wrap,fillx,insets 35 45 30 45", "fill,250:280"));
        panel.putClientProperty(FlatClientProperties.STYLE, "" +
                "arc:20;" +
                "[light]background:darken(@background,3%);" +
                "[dark]background:lighten(@background,3%)");

        txtPassword.putClientProperty(FlatClientProperties.STYLE, "" +
                "showRevealButton:true");
        cmdLogin.putClientProperty(FlatClientProperties.STYLE, "" +
                "[light]background:darken(@background,10%);" +
                "[dark]background:lighten(@background,10%);" +
                "borderWidth:0;" +
                "focusWidth:0;" +
                "innerFocusWidth:0");

        txtUsername.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter your username or email");
        txtPassword.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter your password");

        JLabel lbTitle = new JLabel("Ứng dụng quản lí kho hàng");
        JLabel description = new JLabel("Vui lòng đăng nhập");
        lbTitle.putClientProperty(FlatClientProperties.STYLE, "" +
                "font:bold +10");
        description.putClientProperty(FlatClientProperties.STYLE, "" +
                "[light]foreground:lighten(@foreground,30%);" +
                "[dark]foreground:darken(@foreground,30%)");

        cmdLogin.addActionListener(e -> {
            dataLogin = new UserApp();
            String userName = txtUsername.getText();
            String password = String.valueOf(txtPassword.getPassword());

            dataLogin.setUserName(userName);
            dataLogin.setPassword(password);

            System.out.print(userName + " " + password);

            LoginController controller = new LoginController(em);

            UserApp dataUser = controller.login(this);

            UserSession.setName(dataUser.getUserName());
            UserSession.setIdUser(dataUser.getIdUser());
            UserSession.setEmail(dataUser.getEmail());
            UserSession.setRole(dataUser.getRole());
        });

        panel.add(lbTitle);
        panel.add(description);
        panel.add(new JLabel("Username"), "gapy 8");
        panel.add(txtUsername);
        panel.add(new JLabel("Password"), "gapy 8");
        panel.add(txtPassword);
        panel.add(chRememberMe, "grow 0");
        panel.add(cmdLogin, "gapy 10");
        panel.add(createSignupLabel(), "gapy 10");
        add(panel);
    }

    private Component createSignupLabel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panel.putClientProperty(FlatClientProperties.STYLE, "" +
                "background:null");
        JButton cmdRegister = new JButton("<html><a href=\"#\">Sign up</a></html>");
        cmdRegister.putClientProperty(FlatClientProperties.STYLE, "" +
                "border:3,3,3,3");
        cmdRegister.setContentAreaFilled(false);
        cmdRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));

        cmdRegister.addActionListener(e -> {
            Application.changeFormLoginRegister("register");

            });
        JLabel label = new JLabel("chưa có tài khoản");
        label.putClientProperty(FlatClientProperties.STYLE, "" +
                "[light]foreground:lighten(@foreground,30%);" +
                "[dark]foreground:darken(@foreground,30%)");
        panel.add(label);
        panel.add(cmdRegister);
        return panel;
    }


    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JCheckBox chRememberMe;
    private JButton cmdLogin;
}
