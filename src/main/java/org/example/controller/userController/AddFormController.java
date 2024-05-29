package org.example.controller.userController;

import jakarta.persistence.EntityManager;
import org.example.model.entities.UserApp;
import org.example.service.ServiceUserApp;
import org.example.view.dashboart.application.form.userForm.AddUser;
import raven.toast.Notifications;

public class AddFormController {

    private final EntityManager em;
    private ServiceUserApp serviceUserApp;
    public AddFormController(EntityManager em) {
        this.em = em;
        serviceUserApp = new ServiceUserApp(em);
    }
    public boolean addUser(AddUser addUser) {

        boolean result = false;

        UserApp userApp = addUser.getDataSave();

        try {
            if ( userApp.getUserName().isEmpty() || userApp.getPassword().isEmpty() || userApp.getEmail().isEmpty()) {
                System.out.println("userApp is null");
                Notifications.getInstance().show(Notifications.Type.WARNING, "data null");
                return result;
            } else if (serviceUserApp.checkDuplicateEmail(userApp.getEmail())) {
                System.out.println("email already registered");
                Notifications.getInstance().show(Notifications.Type.ERROR, "email already registered");

            } else {
                serviceUserApp.insertUser(userApp);
                result = true;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        return result;

    }

}
