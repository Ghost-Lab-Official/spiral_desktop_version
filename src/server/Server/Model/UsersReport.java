package server.Server.Model;

import java.io.Serializable;

/**
     * @author Ntezirizaza Erneste
     * @description This method shows the schema of users table
     * @throws Exception
     */

public class UsersReport implements Serializable {
    private String user_id;
    private String first_name;
    private String last_name;
    private String user_name;
    private String email;
    private String gender;
    private String birth_date;
    private String user_category;
    private String location;
    private String user_status;
    private String registration_date;

    // User report constructor
    public UsersReport(String user_id, String first_name, String last_name, String user_name, String email, String gender, String birth_date, String user_category, String location, String user_status, String registration_date) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.user_name = user_name;
        this.email = email;
        this.gender = gender;
        this.birth_date = birth_date;
        this.user_category = user_category;
        this.location = location;
        this.user_status = user_status;
        this.registration_date = registration_date;
    }
   // getters function
    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }
    // setters function
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getUser_category() {
        return user_category;
    }

    public void setUser_category(String user_category) {
        this.user_category = user_category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUser_status() {
        return user_status;
    }

    public void setUser_status(String user_status) {
        this.user_status = user_status;
    }

    public String getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(String registration_date) {
        this.registration_date = registration_date;
    }
}

