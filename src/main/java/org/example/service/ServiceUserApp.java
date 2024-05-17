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
       } finally {
           em.getTransaction().commit();
       }
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
        UserApp dataDel = userDao.findUserById(Id);
        em.remove(dataDel);
        em.getTransaction().commit();
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
