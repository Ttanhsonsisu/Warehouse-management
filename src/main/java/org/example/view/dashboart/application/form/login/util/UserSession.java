package org.example.view.dashboart.application.form.login.util;

import com.sun.jna.platform.win32.Netapi32Util;
import lombok.Getter;
import lombok.Setter;
import org.example.model.entities.UserApp;
import org.example.model.entities.enums.UserRole;



public class UserSession {

    private static Integer idUser;

    private static String name;

    private static String email;

    private static UserRole role;

    public static void setIdUser(Integer idUser) {
        UserSession.idUser = idUser;
    }
    public static void setName(String name) {
        UserSession.name = name;
    }
    public static void setEmail(String email) {
        UserSession.email = email;
    }
    public static void setRole(UserRole role) {
        UserSession.role = role;
    }
    public static Integer getIdUser() {
        return UserSession.idUser;
    }
    public static String getName() {
        return UserSession.name;
    }
    public static String getEmail() {
        return UserSession.email;
    }
    public static UserRole getRole() {
        return UserSession.role;
    }

}
