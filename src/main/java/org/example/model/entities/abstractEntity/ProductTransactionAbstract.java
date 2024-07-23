package org.example.model.entities.abstractEntity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.example.model.entities.enums.TransactionType;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public abstract class ProductTransactionAbstract {

    protected Date dateTranSaction;

    @Enumerated(EnumType.STRING)
    protected TransactionType transactionType;

    protected long totalPrice = 0;
}
