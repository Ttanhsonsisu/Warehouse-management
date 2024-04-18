package org.example.model.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.example.model.entities.abstractEntity.UserAbstract;

@Entity
@Data
public class Client extends UserAbstract {

    @Id
    @GeneratedValue
    private Integer idClient;

    private String nameClient;

    public Product createOrder () {

        return new Product();
    }

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
