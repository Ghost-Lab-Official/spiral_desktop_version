package server.Server.Controllers.LocationLevelControllers;

import server.Server.DbController.CloudStorageConnectionHandler;
import server.Server.Model.LocationLevels;
import server.Server.Model.ResponseStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.UUID;

/**
 * Location levels actions (Synchronizing the classes)
 * @author Gervais Ishimwe
 */

public class LocationLevelsActions {
    String createLevelQuery = "INSERT INTO location_levels(level_id,level_name,description) VALUES(?,?,?)";

    /**
     *  Register a new location level. It will take a level name and
     *  return a new location level id or false in case of query failure
     * @author Harerimana Egide
     * @version 1.0
     * @param 'level_name' the name for new level
     * @return String the new location level id or false in case of query failure.
     */

    public ResponseStatus registerLocationLevel(LocationLevels location)throws Exception{
        String level_id = UUID.randomUUID().toString();

        Connection connection = new CloudStorageConnectionHandler().getConnection();
        try{
            PreparedStatement stmt = connection.prepareStatement(createLevelQuery);
            stmt.setString(1,level_id );
            stmt.setString(2, location.getLevel_name());
            stmt.setString(3, location.getDescription());
            int inserted_rec = stmt.executeUpdate();
            if(inserted_rec == 1){
              return new ResponseStatus(200,"CREATED","Location level registered");
            }
            if(connection != null){
                return new ResponseStatus(500,"SERVER ERROR","Insertion failed, try or contact System Administrator");
            }

        }catch(Exception e){
            return new ResponseStatus(300,"EXCEPTIONAL ERROR",e.getMessage());
        }
           return new ResponseStatus(200,"CREATED","Location level registered");
    }
}
