package org.example.controller;

import jakarta.persistence.EntityManager;
import org.example.model.entities.UserApp;
import org.example.service.ServiceUserApp;
import org.example.view.login_register.forms.RegisterForm;

public class RegisterController {

    private UserApp userApp;
    private ServiceUserApp serviceRegister;

    private final EntityManager em;

    public RegisterController(EntityManager em) {
        this.em = em;
        serviceRegister = new ServiceUserApp(em);
    }

    public void register(RegisterForm registerForm) {
        userApp = registerForm.getDataUserRegister();
    try {
            if (userApp == null) {
                System.out.println("userApp is null");
            } else if (serviceRegister.checkDuplicateEmail(userApp.getEmail())) {
                System.out.println("email already registered");
            } else {
                serviceRegister.insertUser(userApp);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
