package server.Server.Model;

import java.io.Serializable;
/*
            @author : Ishimwe Gervais
            Location levels modal format
            This is describing the entities reserved for the Location_levels table
 */

public class LocationLevels implements Serializable {
  private String level_id;
  private String level_name;
  private String description;

  public LocationLevels(){}

    public LocationLevels(String level_id, String level_name, String description) {
        this.level_id = level_id;
        this.level_name = level_name;
        this.description = description;
    }

    public String  getLevel_id() {
        return level_id;
    }

    public void setLevel_id(String level_id) {
        this.level_id = level_id;
    }

    public String getLevel_name() {
        return level_name;
    }

    public void setLevel_name(String level_name) {
        this.level_name = level_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
