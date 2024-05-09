package org.example.view.login_register.forms;


import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.util.UIScale;
import net.miginfocom.swing.MigLayout;
import org.example.model.entities.UserApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.geom.RoundRectangle2D;

public class RegisterForm extends JPanel {



    private UserApp dataUserRegister;

    public UserApp getDataUserRegister() {
        return dataUserRegister;
    }

    public RegisterForm() {
        init();
    }

    private void init() {
        setOpaque(false);
        //override lai de an vao khung bi mat form login
        addMouseListener(new MouseAdapter() {
        });

        setLayout(new MigLayout("wrap,fillx,insets 45 45 50 45", "[fill]"));
        JLabel title = new JLabel("Sign up account", SwingConstants.CENTER);
        JTextField txtUsername = new JTextField();
        JTextField txtEmail = new JTextField();
        JPasswordField txtPassword = new JPasswordField();

        //JButton cmdRegister = new JButton("Register");


        title.putClientProperty(FlatClientProperties.STYLE, "" +
                "font:bold +10");
        txtUsername.putClientProperty(FlatClientProperties.STYLE, "" +
                "margin:5,10,5,10;" +
                "focusWidth:1;" +
                "innerFocusWidth:0");
        txtEmail.putClientProperty(FlatClientProperties.STYLE, "" +
                "margin:5,10,5,10;" +
                "focusWidth:1;" +
                "innerFocusWidth:0");
        txtPassword.putClientProperty(FlatClientProperties.STYLE, "" +
                "margin:5,10,5,10;" +
                "focusWidth:1;" +
                "innerFocusWidth:0;" +
                "showRevealButton:true");
//        cmdRegister.putClientProperty(FlatClientProperties.STYLE, "" +
//                "background:$Component.accentColor;" +
//                "borderWidth:0;" +
//                "focusWidth:0;" +
//                "innerFocusWidth:0");

        JCheckBox chConfirm = new JCheckBox("Đồng ý các luật");

        txtUsername.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Nhap user name");
        txtEmail.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Nhap email ");
        txtPassword.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Nhap password");

         //event when click cmd
//        cmdRegister.addActionListener(e->{
//            String name = txtUsername.getText();
//            String email = txtEmail.getText();
//            String password = String.valueOf(txtPassword.getPassword());
//            System.out.print(name+email+password);
//            userApp = new UserApp(name, email, password);
//        });

        chConfirm.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(chConfirm.isSelected()){
                    String name = txtUsername.getText();
                    String email = txtEmail.getText();
                    String password = String.valueOf(txtPassword.getPassword());
                    System.out.print(name+" "+email+" "+ password);
                    dataUserRegister = new UserApp(name, email, password);
                } else {
                    chConfirm.setForeground(Color.red);
                }
            }
        });

        add(title);
        add(new JLabel("Username"), "gapy 20");
        add(txtUsername);
        add(new JLabel("Email"), "gapy 10");
        add(txtEmail);
        add(new JLabel("Password"), "gapy 10");
        add(txtPassword);
        add(chConfirm);
        //add(cmdRegister, "gapy 30");
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int arc = UIScale.scale(20);
        g2.setColor(getBackground());
        g2.setComposite(AlphaComposite.SrcOver.derive(0.6f));
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arc, arc));
        g2.dispose();
        super.paintComponent(g);
    }
}

