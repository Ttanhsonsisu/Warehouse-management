package org.example.service;

import jakarta.persistence.EntityManager;
import org.example.DAO.ExportNoteDao;
import org.example.model.entities.ExportNote;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceExportNote {

    private final EntityManager em;

    private ExportNoteDao exportNoteDao;
    public ServiceExportNote(EntityManager em) {
        this.em = em;
        exportNoteDao = new ExportNoteDao(em);
    }

    public List<ExportNote> getAllDataBetween(Date start, Date end) {
        List<ExportNote> result = new ArrayList<>();
        try {
            em.getTransaction().begin();
            result = exportNoteDao.getTransactionsBetweenDates(start, end);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            em.getTransaction().commit();
            return result;
        }
    }

    public List<ExportNote> getExportNotes() {
        List<ExportNote> result = new ArrayList<>();
        try {
            em.getTransaction().begin();
            result = exportNoteDao.findAllExportNotes();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            em.getTransaction().commit();
            return result;
        }
    }
    public void insertExportNote(ExportNote dataInsertExportNote) {

        try {
            em.getTransaction().begin();
            em.persist(dataInsertExportNote);
        } catch(Exception e) {
            //em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.getTransaction().commit();
        }

    }
}
