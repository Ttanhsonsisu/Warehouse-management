package org.example.controller.userController;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import org.example.model.entities.UserApp;
import org.example.service.ServiceUserApp;
import org.example.view.dashboart.application.Application;
import org.example.view.dashboart.application.form.login.Login;
import raven.toast.Notifications;


public class LoginController {

    private static UserApp dataLogin;


    private final EntityManager em;

    private Application app;

    private ServiceUserApp serviceUserApp;

    public static UserApp getDataLogin() {
        return dataLogin;
    }

    private void getFullInfoDatalogin() {
        UserApp result = serviceUserApp.findUserAppByEmail(dataLogin.getEmail());
        dataLogin = result;
    }

    public LoginController(EntityManager em) {
        this.em = em;
        serviceUserApp = new ServiceUserApp(em);
    }

    public UserApp login(Login loginForm) {
        dataLogin = loginForm.getDataLogin();
        UserApp user = new ServiceUserApp(em).findUserbyNameAndPass(dataLogin);
        if(user.getIdUser() != null) {
            System.out.print("you are logged in");
            Notifications.getInstance().show(Notifications.Type.SUCCESS, "đăng nhập thành công");
            app.login();
        } else {
            Notifications.getInstance().show(Notifications.Type.ERROR, "Đăng nhập thất bại");

            // changer frame
            System.out.print("fail");
        }
    return user;
    }
}
