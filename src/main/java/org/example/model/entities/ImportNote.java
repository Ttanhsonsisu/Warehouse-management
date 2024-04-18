package org.example.model.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.example.model.entities.abstractEntity.ProductTransactionAbstract;

@Entity
@Data
public class ImportNote extends ProductTransactionAbstract {

    @Id
    @GeneratedValue
    private Integer idExportNote;

    @ManyToOne
    private Supplier suppiers;



}
