package server.Server.Model;

import java.io.Serializable;


/**
@author MANZI Mike
@description this class is the model for the locations Report
*/
public class LocationsReport implements Serializable {

    private String locationId;
    private String location_name;
    private String location_GPS;
    private String description;
    private String status;

    public LocationsReport(String locationId, String location_name, String location_GPS, String description, String status) {
        this.locationId = locationId;
        this.location_name = location_name;
        this.location_GPS = location_GPS;
        this.description = description;
        this.status = status;
    }


    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
