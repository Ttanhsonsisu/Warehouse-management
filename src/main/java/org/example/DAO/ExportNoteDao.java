package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.example.model.entities.ExportNote;
import org.example.model.entities.ImportNote;

import java.util.Date;
import java.util.List;

public class ExportNoteDao {
    private final EntityManager em;

    public ExportNoteDao(EntityManager em) {
        this.em = em;
    }

    public List<ExportNote> findAllExportNotes() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ExportNote> cq = cb.createQuery(ExportNote.class);
        Root<ExportNote> root = cq.from(ExportNote.class);
        cq.select(root);
        return em.createQuery(cq).getResultList();
    }

    public ExportNote findExportNoteById(Long id) {
        return em.find(ExportNote.class, id);
    }

    public List<ExportNote> getTransactionsBetweenDates(Date startDate, Date endDate) {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

        CriteriaQuery<ExportNote> criteriaQuery = criteriaBuilder.createQuery(ExportNote.class);

        Root<ExportNote> root = criteriaQuery.from(ExportNote.class);

        Predicate datePredicate = criteriaBuilder.between(root.get("dateTranSaction"), startDate, endDate);

        criteriaQuery.select(root).where(datePredicate);

        return em.createQuery(criteriaQuery).getResultList();
    }
}
