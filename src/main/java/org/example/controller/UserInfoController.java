package org.example.controller;

import jakarta.persistence.EntityManager;
import org.example.model.entities.UserApp;
import org.example.service.ServiceUserApp;
import org.example.view.dashboart.application.form.other.UserInfo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class UserInfoController {

    private final EntityManager em;

    private UserInfo userInfo;

    private ServiceUserApp serviceUserApp;
    public UserInfoController(EntityManager em) {
        this.em = em;

    }

    public void ShowDataTbl(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        serviceUserApp = new ServiceUserApp(em);
        List<UserApp> dataAdd = serviceUserApp.listUserApp();
        for(UserApp userApp : dataAdd) {
            model.addRow(new Object[] {false,
                            userApp.getUserName(),
                            userApp.getEmail(),
                            userApp.getPhoneNumber(),
                            userApp.getName()
                            }
                    );
        }

    }



}
