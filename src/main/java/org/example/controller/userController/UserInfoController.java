package org.example.controller.userController;

import jakarta.persistence.EntityManager;
import org.example.model.entities.UserApp;
import org.example.service.ServiceUserApp;
import org.example.view.dashboart.application.form.other.UserInfo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.util.List;

public class UserInfoController {

    private final EntityManager em;


    private ServiceUserApp serviceUserApp;
    public UserInfoController(EntityManager em) {
        this.em = em;

    }


    public void ShowDataTbl(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        serviceUserApp = new ServiceUserApp(em);
        List<UserApp> dataAdd = serviceUserApp.listUserApp();
        for(UserApp userApp : dataAdd) {
            model.addRow(new Object[] {
                            userApp.getUserName(),
                            userApp.getEmail(),
                            userApp.getPhoneNumber(),
                            userApp.getName(),
                            userApp.getRole()
                            }
                    );
        }

        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(model);
        table.setRowSorter(rowSorter);
    }

}
