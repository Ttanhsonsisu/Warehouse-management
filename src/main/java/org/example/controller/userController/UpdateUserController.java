package org.example.controller.userController;

import jakarta.persistence.EntityManager;
import org.example.service.ServiceUserApp;
import org.example.view.dashboart.application.form.UpdateUserForm;

public class UpdateUserController {

    private final EntityManager em;

    private ServiceUserApp serviceUserApp;

    public UpdateUserController(EntityManager em) {
        this.em = em;
        serviceUserApp= new ServiceUserApp(em);

    }

    public void updateUser(UpdateUserForm updateUserForm) {
       // em.getTransaction().begin();
        serviceUserApp.updateUserApp(updateUserForm.getData());
        //em.getTransaction().commit();

    }
}
