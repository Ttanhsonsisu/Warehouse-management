package org.example.model.entities;


import com.sun.jna.platform.win32.Netapi32Util;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.model.entities.abstractEntity.ProductTransactionAbstract;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExportNote extends ProductTransactionAbstract {

    @Id
    @GeneratedValue
    private Integer idExportNote;

    @ManyToOne
    private UserApp client ;

    @ManyToMany
    @JoinTable(
            name = "product_exportnote",
            joinColumns = @JoinColumn(name = "idexportnote"),
            inverseJoinColumns = @JoinColumn(name = "idproduct")
    )
    private List<Product> products;

}
