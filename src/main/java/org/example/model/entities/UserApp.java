package org.example.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.model.entities.enums.UserRole;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserApp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer idUser;

    protected String phoneNumber ;

    protected String email;

    protected String userName;

    protected String password;

    protected String name;

    @ManyToMany()
    @JoinTable(
            name = "Product_UserApp",
            joinColumns = @JoinColumn(name = "idUserApp"),
            inverseJoinColumns = @JoinColumn(name = "idProduct")
    )
    protected List<Product> productList = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    protected UserRole role;

    public UserApp(Integer idUser, String email, String userName, String password) {
        this.idUser = idUser;
        this.email = email;
        this.userName = userName;
        this.password = password;

    }

    public UserApp( String email, String password, String role, String name, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.userName = email;
        this.role = UserRole.valueOf(role);
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public UserApp(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }


    protected String status;

    @Override
    public String toString() {
        return "UserApp{" +
                "email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", role=" + role +
                '}';
    }
}
