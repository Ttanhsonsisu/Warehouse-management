package org.example.controller.userController;

import jakarta.persistence.EntityManager;
import org.example.model.entities.UserApp;
import org.example.service.ServiceUserApp;

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
