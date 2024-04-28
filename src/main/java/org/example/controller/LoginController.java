package org.example.controller;

import jakarta.persistence.EntityManager;
import org.example.model.entities.UserApp;
import org.example.service.ServiceUserApp;
import org.example.view.login_register.forms.LoginForm;

public class LoginController {


    private UserApp dataLogin;
    private final EntityManager em;
    public LoginController(EntityManager em) {
        this.em = em;
    }
    public void login(LoginForm loginForm) {
        dataLogin = loginForm.getDataUserLogin();
        UserApp user = new ServiceUserApp(em).findUserbyNameAndPass(dataLogin);
        if(user != null) {
            System.out.print("you are logged in");
        } else {
            // changer frame
            System.out.print("you are not logged in");
        }
    }
}
