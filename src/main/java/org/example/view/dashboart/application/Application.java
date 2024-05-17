package org.example.view.dashboart.application;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import jakarta.persistence.EntityManager;
import org.example.view.dashboart.application.form.MainForm;
import org.example.view.dashboart.application.form.login.Login;
import org.example.view.dashboart.application.form.login.Register;
import raven.toast.Notifications;


public class Application extends javax.swing.JFrame {

    private static Application app;
    private final MainForm mainForm;

    //private final EntityManager em;

    private final Login loginForm;
    private final Register registerForm;
    public Application(EntityManager em) {
        //this.em = em;
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("theme");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacDarkLaf.setup();
        initComponents();
        setSize(new Dimension(1366, 768));
        setLocationRelativeTo(null);
        mainForm = new MainForm(em);


        registerForm = new Register(em);
        loginForm = new Login(em);

        setContentPane(loginForm);
        Notifications.getInstance().setJFrame(this);
    }

    public static void showForm(Component component) {
        component.applyComponentOrientation(app.getComponentOrientation());
        app.mainForm.showForm(component);
    }

    public static void login() {
        FlatAnimatedLafChange.showSnapshot();
        app.setContentPane(app.mainForm);
        app.mainForm.applyComponentOrientation(app.getComponentOrientation());
        setSelectedMenu(0, 0);
        app.mainForm.hideMenu();
        SwingUtilities.updateComponentTreeUI(app.mainForm);
        FlatAnimatedLafChange.hideSnapshotWithAnimation();
    }

// func change login <--> register
    public static void changeFormLoginRegister(String nameForm) {

        if(nameForm.equals("login")) {
            FlatAnimatedLafChange.showSnapshot();
            app.setContentPane(app.loginForm);
            SwingUtilities.updateComponentTreeUI(app.loginForm);
            app.revalidate();
            app.repaint();
            FlatAnimatedLafChange.hideSnapshotWithAnimation();
        }
        if(nameForm.equals("register")) {
            FlatAnimatedLafChange.showSnapshot();
            app.setContentPane(app.registerForm);
           SwingUtilities.updateComponentTreeUI(app.registerForm);
            app.revalidate();
            app.repaint();
            FlatAnimatedLafChange.hideSnapshotWithAnimation();
        }
    }

    public static void register(){
        FlatAnimatedLafChange.showSnapshot();
        app.setContentPane(app.loginForm);
    }

    public static void logout() {
        FlatAnimatedLafChange.showSnapshot();
        app.setContentPane(app.loginForm);
        app.loginForm.applyComponentOrientation(app.getComponentOrientation());
        SwingUtilities.updateComponentTreeUI(app.loginForm);
        FlatAnimatedLafChange.hideSnapshotWithAnimation();
    }

    public static void setSelectedMenu(int index, int subIndex) {
        app.mainForm.setSelectedMenu(index, subIndex);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 719, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 521, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void initForm(EntityManager entityManager) {
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("theme");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacDarkLaf.setup();
        java.awt.EventQueue.invokeLater(() -> {
            app = new Application(entityManager);
            //  app.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
            app.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
