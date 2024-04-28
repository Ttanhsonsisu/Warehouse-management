package org.example.model.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
public class Supplier extends UserApp {

    private String nameSupplier;

}
