package org.example.view.login_register;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.util.UIScale;
import jakarta.persistence.EntityManager;
import org.example.view.login_register.forms.Home;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainLoginRegister extends JFrame {

    private final EntityManager em;

    private Home home;

    public MainLoginRegister(EntityManager em) {
        this.em = em;
        FlatRobotoFont.install(); // thiet lap font chu
        FlatLaf.registerCustomDefaultsSource("viewResources");
        FlatDarkLaf.setup();
        UIManager.put("defaults", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13)); // set font cho UI
        init();
    }

    private void init() {
        //setIconImage(new ImageIcon("videos/waseHouse.jpg").getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(false);
        setSize(UIScale.scale(new Dimension(1170, 600)));
        setLocationRelativeTo(null);
        home = new Home(em);
        setContentPane(home);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                home.initOverlay(MainLoginRegister.this);
                home.play(0); // set index video
            }
            @Override
            public void windowClosing(WindowEvent e) {
                home.stop();
            }
        });
    }
}