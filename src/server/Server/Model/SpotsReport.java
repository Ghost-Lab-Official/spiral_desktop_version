package server.Server.Model;

import java.io.Serializable;

public class SpotsReport implements Serializable {
    private String spot_id;
    private String user_name;
    private String category_name;
    private String location_name;
    private String spot_name;
    private String spot_description;
    private Double views;
    private String status;
    private String registration_date;


    public SpotsReport() {
    }

    public SpotsReport(String spot_id, String user_name, String category_name, String location_name, String spot_name, String spot_description, Double views, String status, String registration_date) {
        this.spot_id = spot_id;
        this.user_name = user_name;
        this.category_name = category_name;
        this.location_name = location_name;
        this.spot_name = spot_name;
        this.spot_description = spot_description;
        this.views = views;
        this.status = status;
        this.registration_date = registration_date;
    }

    public String getSpot_id() {
        return spot_id;
    }

    public void setSpot_id(String spot_id) {
        this.spot_id = spot_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getLocation_name() {
        return location_name;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }

    public String getSpot_name() {
        return spot_name;
    }

    public void setSpot_name(String spot_name) {
        this.spot_name = spot_name;
    }

    public String getSpot_description() {
        return spot_description;
    }

    public void setSpot_description(String spot_description) {
        this.spot_description = spot_description;
    }

    public Double getViews() {
        return views;
    }

    public void setViews(Double views) {
        this.views = views;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(String registration_date) {
        this.registration_date = registration_date;
    }
}
