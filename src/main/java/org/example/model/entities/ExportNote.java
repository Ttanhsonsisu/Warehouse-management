package org.example.model.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.model.entities.abstractEntity.ProductTransactionAbstract;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ExportNote extends ProductTransactionAbstract {

    @Id
    @GeneratedValue
    private Integer idExportNote;

    @ManyToOne
    private Client client ;

}
