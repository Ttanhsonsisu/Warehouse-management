package org.example.controller.userController;

import jakarta.persistence.EntityManager;
import org.example.model.entities.UserApp;
import org.example.service.ServiceUserApp;
import org.example.view.dashboart.application.form.login.Register;
import raven.toast.Notifications;


public class RegisterController {

    private UserApp userApp;
    private ServiceUserApp serviceRegister;

    private final EntityManager em;

    public RegisterController(EntityManager em) {
        this.em = em;
        serviceRegister = new ServiceUserApp(em);
    }

    public void register(Register registerForm) {
        userApp = registerForm.getDataRegister();
    try {
            if ( userApp.getUserName().isEmpty() || userApp.getPassword().isEmpty() || userApp.getEmail().isEmpty()) {
                System.out.println("userApp is null");
                Notifications.getInstance().show(Notifications.Type.WARNING, "data null");
            } else if (serviceRegister.checkDuplicateEmail(userApp.getEmail())) {
                System.out.println("email already registered");
                Notifications.getInstance().show(Notifications.Type.ERROR, "email already registered");
            } else {
                serviceRegister.insertUser(userApp);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
