package org.example.model.entities;


import jakarta.persistence.*;
import lombok.*;
import org.example.model.entities.enums.ItemCondition;
import org.example.model.entities.enums.UnitItem;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue
    private Integer idProduct;

    private String nameProduct;

    private String mota;

    private int quantityProduct;

    @Enumerated(EnumType.STRING)
    @Column(length = 300)
    private UnitItem unitProduct;

    private long price;



    @ManyToMany
    @JoinTable(
            name = "Product_UserApp",
            joinColumns = @JoinColumn(name = "idProduct"),
            inverseJoinColumns = @JoinColumn(name = "idUserapp")
    )
    private List<UserApp> supplier;

    @Enumerated(EnumType.STRING)
    @Column(length = 500)
    private ItemCondition productCondition;

    @ManyToMany()
    @JoinTable(
            name = "product_exportnote",
            joinColumns = @JoinColumn(name = "idProduct"),
            inverseJoinColumns = @JoinColumn(name = "idexportnote")
    )
    private List<ExportNote> ExportNotes = new ArrayList<>();

    @ManyToMany()
    @JoinTable(
            name = "product_importnote",
            joinColumns = @JoinColumn(name = "idProduct"),
            inverseJoinColumns = @JoinColumn(name = "idimportnote")
    )
    private List<ImportNote> ImportNotes = new ArrayList<>();

    @Override
    public String toString() {
        return "Product{" +
                "mota='" + mota + '\'' +
                ", idProduct=" + idProduct +
                ", nameProduct='" + nameProduct + '\'' +
                ", quantityProduct=" + quantityProduct +
                ", unitProduct=" + unitProduct +
                ", price=" + price +
                '}';
    }
}
