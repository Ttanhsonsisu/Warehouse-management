package org.example.model.entities;


import jakarta.persistence.*;
import lombok.*;
import org.example.model.entities.abstractEntity.ProductTransactionAbstract;

import java.util.List;

@Entity
@Data
public class ImportNote extends ProductTransactionAbstract {

    @Id
    @GeneratedValue
    private Integer idImportNote;

    @ManyToOne
    private UserApp suppiers;

    @ManyToMany
    @JoinTable(
            name = "product_importnote",
            joinColumns = @JoinColumn(name = "idimportnote"),
            inverseJoinColumns = @JoinColumn(name = "idproduct")
    )
    private List<Product> products;

}
