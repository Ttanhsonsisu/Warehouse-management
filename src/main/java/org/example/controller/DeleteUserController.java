package org.example.controller;

import jakarta.persistence.EntityManager;
import org.example.model.entities.UserApp;
import org.example.service.ServiceUserApp;
import org.example.view.dashboart.application.form.UpdateUserForm;

public class DeleteUserController {
    private final EntityManager em;

    private ServiceUserApp serviceUserApp;

    public DeleteUserController(EntityManager em) {
        this.em = em;
        serviceUserApp= new ServiceUserApp(em);

    }

    public void deleteUser(UserApp dataDel) {

        serviceUserApp.delUserApp(dataDel);

    }
}
