package org.example.model.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.model.entities.enums.WareHouseCondition;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WareHouse {

    @Id
    @GeneratedValue
    private Integer idWareHouse;

    private String nameWareHouse;

    private long QuantityProductMax;

    @Enumerated(EnumType.STRING)
    private WareHouseCondition wareHouseCondition;

    // methods

    @Override
    public String toString() {
        return "WareHouse{" +
                "idWareHouse=" + idWareHouse +
                ", nameWareHouse='" + nameWareHouse + '\'' +
                ", QuantityItemMax=" + QuantityProductMax +
                ", wareHouseCondition=" + wareHouseCondition +
                '}';
    }
}
