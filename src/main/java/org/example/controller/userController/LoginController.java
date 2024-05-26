package org.example.controller.userController;

import jakarta.persistence.EntityManager;
import org.example.model.entities.UserApp;
import org.example.service.ServiceUserApp;
import org.example.view.dashboart.application.Application;
import org.example.view.dashboart.application.form.login.Login;
import raven.toast.Notifications;


public class LoginController {


    private UserApp dataLogin;
    private final EntityManager em;

    private Application app;
    public LoginController(EntityManager em) {
        this.em = em;
    }
    public void login(Login loginForm) {
        dataLogin = loginForm.getDataLogin();
        UserApp user = new ServiceUserApp(em).findUserbyNameAndPass(dataLogin);
        if(user != null) {
            System.out.print("you are logged in");
            Notifications.getInstance().show(Notifications.Type.SUCCESS, "Đợi giây lát hệ thống đang đăng nhập");

                app.login();

        } else {
            Notifications.getInstance().show(Notifications.Type.ERROR, "Đăng nhập thất bại");
            // changer frame
            System.out.print("fail");
        }
    }
}
