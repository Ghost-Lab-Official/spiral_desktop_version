package server.Server.Model;

import java.io.Serializable;

public class Location implements Serializable {

    private String location_id;
    private String level_id;
    private String parent_id;
    private String location_name;
    private String location_GPS;
    private String description;

    public Location(){}

    public Location(String location_id, String level_id, String parent_id, String location_name, String location_GPS, String description) {
        this.location_id = location_id;
        this.level_id = level_id;
        this.parent_id = parent_id;
        this.location_name = location_name;
        this.location_GPS = location_GPS;
        this.description = description;
    }

    public String getLocation_id() {
        return location_id;
    }

    public void setLocation_id(String location_id) {
        this.location_id = location_id;
    }

    public String getLevel_id() {
        return level_id;
    }

    public void setLevel_id(String level_id) {
        this.level_id = level_id;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getLocation_name() {
        return location_name;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }

    public String getLocation_GPS() {
        return location_GPS;
    }

    public void setLocation_GPS(String location_GPS) {
        this.location_GPS = location_GPS;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
