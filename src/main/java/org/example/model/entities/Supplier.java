package org.example.model.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.example.model.entities.abstractEntity.UserAbstract;

@Entity
@Data
public class Supplier extends UserAbstract {

    @Id
    @GeneratedValue
    @Getter @Setter
    private Integer idSupplier;

    private String nameSupplier;

    @Override
    public void login() {

    }

    @Override
    public void register() {

    }

    @Override
    public void displayItem() {

    }
}
