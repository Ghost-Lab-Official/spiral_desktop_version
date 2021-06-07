package server.Server.Model;

import java.io.Serializable;

public class Users extends Object implements Serializable {
    private String fullName;
    private String email;

    public Users(){}
    public Users(String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}