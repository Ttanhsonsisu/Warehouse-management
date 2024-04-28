package org.example.model.entities;


import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Data
public class Client extends UserApp {


    public Product createOrder () {

        return new Product();
    }


    

}
