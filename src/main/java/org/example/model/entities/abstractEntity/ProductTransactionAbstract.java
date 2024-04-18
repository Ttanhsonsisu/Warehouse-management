package org.example.model.entities.abstractEntity;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import org.example.model.entities.enums.TransactionType;

import java.util.Date;

@MappedSuperclass
public abstract class ProductTransactionAbstract {


    protected Date dateTranSaction;

    @Enumerated(EnumType.STRING)
    protected TransactionType transactionType;

    protected long totalPrice = 0;
}
