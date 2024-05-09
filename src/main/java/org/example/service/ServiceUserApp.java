package org.example.service;

import jakarta.persistence.EntityManager;
import org.example.DAO.UserAppDAO;
import org.example.model.entities.UserApp;
import java.util.List;



public class ServiceUserApp {

    private final EntityManager em;

    public ServiceUserApp(EntityManager em) {
        this.em = em;
    }

    public List<UserApp> listUserApp(){
        em.getTransaction().begin();
        UserAppDAO dao = new UserAppDAO(em);
        List<UserApp> result = dao.findAllUserApp();
        em.getTransaction().commit();

        return result;
    }
    public void insertUser(UserApp userApp) {
        em.getTransaction().begin();
        UserAppDAO userDao = new UserAppDAO(em);
        userDao.insertLoginRegister(userApp.getUserName(), userApp.getEmail(), userApp.getPassword());
        em.getTransaction().commit();
    }

    public UserApp findUserbyNameAndPass (UserApp userApp) {
        em.getTransaction().begin();
        UserAppDAO userDao = new UserAppDAO(em);
        UserApp r = userDao.findLoginRegister(userApp.getUserName(), userApp.getPassword());
        em.getTransaction().commit();
        return r;
    }

    public boolean checkDuplicateEmail(String email) {
        boolean checkDuplicate = false;
        em.getTransaction().begin();
        UserAppDAO userDao = new UserAppDAO(em);
        List<Integer> query = userDao.findUserEmail(email);
        em.getTransaction().commit();
        if(query.size() != 0 ) {
            checkDuplicate = true;
        }

        return checkDuplicate;
    }

    public void delUserAppById(Integer Id) {
        em.getTransaction().begin();
        UserAppDAO userDao = new UserAppDAO(em);
        // find userApp by id

    }
}
