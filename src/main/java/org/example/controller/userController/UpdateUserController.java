package org.example.controller.userController;

import jakarta.persistence.EntityManager;
import org.example.service.ServiceUserApp;
import org.example.view.dashboart.application.form.userForm.UpdateUserForm;

public class UpdateUserController {

    private final EntityManager em;

    private ServiceUserApp serviceUserApp;

    public UpdateUserController(EntityManager em) {
        this.em = em;
        serviceUserApp= new ServiceUserApp(em);
    }

    public void updateUser(UpdateUserForm updateUserForm) {
        serviceUserApp.updateUserApp(updateUserForm.getData());
    }
}
