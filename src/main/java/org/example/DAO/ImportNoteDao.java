package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.example.model.entities.ImportNote;

import java.util.Date;
import java.util.List;

public class ImportNoteDao {

    private final EntityManager em;

    public ImportNoteDao(EntityManager em) {
        this.em = em;
    }

    public List<ImportNote> findAllImportNote() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ImportNote> cq = cb.createQuery(ImportNote.class);
        Root<ImportNote> root = cq.from(ImportNote.class);
        cq.select(root);
        return em.createQuery(cq).getResultList();
    }

    public ImportNote findImportNoteById(int id) {
        return em.find(ImportNote.class, id);
    }

    public List<ImportNote> getTransactionsBetweenDates(Date startDate, Date endDate) {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

        CriteriaQuery<ImportNote> criteriaQuery = criteriaBuilder.createQuery(ImportNote.class);

        Root<ImportNote> root = criteriaQuery.from(ImportNote.class);

        Predicate datePredicate = criteriaBuilder.between(root.get("dateTranSaction"), startDate, endDate);

        criteriaQuery.select(root).where(datePredicate);

        return em.createQuery(criteriaQuery).getResultList();
    }
}
