package org.example.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class UserApp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer idUser;

    protected String phoneNumber ;

    protected String email;

    protected String userName;

    protected String password;

    protected String verifyCode;

    public UserApp(Integer idUser, String email, String userName, String password, String verifyCode) {
        this.idUser = idUser;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.verifyCode = verifyCode;
    }

    public UserApp( String userName, String email, String password) {

        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public UserApp(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    protected String status;


}
