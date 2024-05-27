package org.example.service;

import jakarta.persistence.EntityManager;
import org.example.DAO.ImportNoteDao;
import org.example.model.entities.ExportNote;
import org.example.model.entities.ImportNote;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ServiceImportNote {

    private final EntityManager em;

    private ImportNoteDao importNoteDao;

    public ServiceImportNote(EntityManager em) {
        this.em = em;
        importNoteDao = new ImportNoteDao(em);
    }

    public List<ImportNote> getImportNotes() {
        List<ImportNote> result = new ArrayList<>();
        try{
            em.getTransaction().begin();
            result = importNoteDao.findAllImportNote();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            em.getTransaction().commit();
            return result;
        }
    }

    public List<ImportNote> getAllDataBetween(Date start, Date end) {
        List<ImportNote> result = new ArrayList<>();
        try {
            em.getTransaction().begin();
            result = importNoteDao.getTransactionsBetweenDates(start, end);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            em.getTransaction().commit();
            return result;
        }
    }

    public void inserImportNote(ImportNote importNote) {
        try {
            em.getTransaction().begin();
            em.persist(importNote);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.getTransaction().commit();
        }
    }

}
