package org.example.model.entities.abstractEntity;


import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.model.entities.enums.UserRole;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class UserAbstract {



    protected String phoneNumber ;

    protected String email;

    protected String userName;

    protected String password;

    @Enumerated(EnumType.STRING)
    @Column(length = 300)


    public abstract void login();

    public abstract void register();

    public abstract void displayItem();
}
