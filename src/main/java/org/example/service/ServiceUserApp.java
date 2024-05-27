package org.example.service;

import com.sun.jna.platform.win32.Netapi32Util;
import jakarta.persistence.EntityManager;
import org.example.DAO.UserAppDAO;
import org.example.model.entities.Product;
import org.example.model.entities.UserApp;
import org.example.view.dashboart.application.form.login.util.UserSession;

import java.util.List;



public class ServiceUserApp {

    private final EntityManager em;

    public ServiceUserApp(EntityManager em) {
        this.em = em;
    }

    public UserApp findUserAppById(int id) {
        em.getTransaction().begin();
        UserApp result = em.find(UserApp.class, id);
        em.getTransaction().commit();
        return result;

    }

    public void inserProduct (Product product) {
        em.getTransaction().begin();
        UserApp userApp = em.find(UserApp.class, UserSession.getIdUser());
        userApp.getProductList().add(product);
        em.getTransaction().commit();
    }
    public UserApp findUserAppByEmail(String email) {

        UserApp result = new UserApp();

        try {
            em.getTransaction().begin();
            result = em.find(UserApp.class, email);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.getTransaction().commit();
            return result;
        }
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

        userDao.insertLoginRegister(userApp);

        em.getTransaction().commit();
    }

    public UserApp findUserbyNameAndPass (UserApp userApp) {
        UserApp r = new UserApp();
        try {
           em.getTransaction().begin();
           UserAppDAO userDao = new UserAppDAO(em);
           r = userDao.findLoginRegister(userApp.getUserName(), userApp.getPassword());

       } catch(Exception e) {
           e.printStackTrace();
           return null;
       } finally {
           em.getTransaction().commit();
            return r;
       }

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

    public void delUserApp(UserApp delete) {
        try {
            em.getTransaction().begin();
            UserAppDAO userDao = new UserAppDAO(em);
            int id = userDao.findUserAppId(delete.getEmail());
            UserApp dataDel = em.find(UserApp.class, id);
            // find userApp by id
            em.remove(dataDel);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            em.getTransaction().commit();
        }

    }

    public UserApp updateUserApp(UserApp update ) {
        em.getTransaction().begin();

        UserAppDAO userDao = new UserAppDAO(em);
        int id = userDao.findUserAppId(update.getEmail());

        UserApp result = em.find(UserApp.class, id);
        //result.setUserName(before.getUserName()); // no settext
        result.setPassword(update.getPassword());
        result.setPassword(update.getPassword());
        result.setName(update.getName());

        em.getTransaction().commit();
        return result;
    }

}
