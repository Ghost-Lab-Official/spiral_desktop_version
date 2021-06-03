package server.Server.Controllers.LocationControllers;
import server.Server.DbController.CloudStorageConnectionHandler;
import server.Server.Model.Location;
import server.Server.Model.ResponseStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
public class LocationActions {

    public ResponseStatus registerLocation(Location location){
        String location_id = UUID.randomUUID().toString();

        try{
            String sql = "INSERT INTO locations(" +
                    "location_id,level_id,parent_id,location_name,location_GPS,description)" +
                    " VALUES(?,?,?,?,?,?)";

            Connection connection = new CloudStorageConnectionHandler().getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, location_id);
            stmt.setString(2, location.getLevel_id());
            stmt.setString(3, location.getParent_id());
            stmt.setString(4, location.getLocation_name());
            stmt.setString(5, location.getLocation_GPS());
            stmt.setString(6, location.getDescription());
            int inserted_rec = stmt.executeUpdate();
            if(inserted_rec == 1){
                return new ResponseStatus(200,"CREATED","Location registered");
            }

        }catch(Exception e){
            return new ResponseStatus(300,"EXCEPTIONAL ERROR",e.getMessage());
        }
        return new ResponseStatus(200,"CREATED","Location  registered");
    }

    /**
     *location management class. Method updating for updating given location
     * @author Felix DUSENGIMANA
     * @copyright by Rwanda Coding Academy
     * instructor Donatien MASHENGESHO
     * @since  04-02-2021
     * return boolean to indicated the success or fail to update.
     *
     */

    public  ResponseStatus UpdateLocation (Location location){

        HashMap<String,String> updateLocationData = new HashMap<>();
        updateLocationData.put("location_id",location.getLocation_id());
        updateLocationData.put("parent_id",location.getParent_id());
        updateLocationData.put("level_id",location.getLevel_id());
        updateLocationData.put("location_name",location.getLocation_name());
        updateLocationData.put("location_GPS",location.getLocation_GPS());
        updateLocationData.put("description",location.getDescription());

        Iterator dataIterator = updateLocationData.entrySet().iterator();
        StringBuilder attr = new StringBuilder();
        String cond = "",query="";

        //while loop for looping through hashMap to check the attributes a user wants to update
        while (dataIterator.hasNext()){
            Map.Entry mapElement = (Map.Entry)dataIterator.next();
            if (mapElement.getValue()!=null){
                /*get location id to update*/
                if(mapElement.getKey() =="location_id"){
                    cond = "WHERE "+mapElement.getKey()+"='"+mapElement.getValue()+"'";
                }else{
                    attr.append(" ").append(mapElement.getKey()).append("=").append("'").append(mapElement.getValue()).append("',");
                }
            }
        }


        try{
            Connection connection = new CloudStorageConnectionHandler().getConnection();

            if(attr.length()==0){
                return  new ResponseStatus(400,"BAD REQUEST","Please enter at least one key to update.");
            }else{
                String withoutLastComma = attr.substring( 0, attr.length( ) - ",".length( ) );
                query +="UPDATE locations SET "+withoutLastComma+" "+cond;
                //System.out.println("Queryy::: "+query);

                PreparedStatement preparedStatement = connection.prepareStatement(query);
                int updated = preparedStatement.executeUpdate();
                if(updated==1){
                    connection.close();
                    return  new ResponseStatus(200,"UPDATED","Location updated successfully.");
                }else {
                    connection.close();
                    return  new ResponseStatus(400,"BAD REQUEST","Error while updating.");
                }
            }
        }catch (Exception e){
            return  new ResponseStatus(300,"EXCEPTION ERROR",e.getMessage());
        }
    }


    /**
     *location management class. Method updating for updating given location
     * @author Felix DUSENGIMANA
     * @copyright  by Rwanda Coding Academy
     * instructor Donatien MASHENGESHO
     * @since  04-02-2021
     * @param parentId {String} for new data to update existing ones.
     * return boolean to indicated the success or fail to update.
     *
     */

    public   boolean CheckLocationId(String parentId){
        String query = "SELECT location_id FROM `locations` WHERE location_id =?";
        boolean checkResult = false;
        try {
            Connection connection = new CloudStorageConnectionHandler().getConnection();

            PreparedStatement checkStatment = connection.prepareStatement(query);
            checkStatment.setString(1,parentId);

            ResultSet rs = checkStatment.executeQuery();
            if (rs.next()){
                connection.close();
                checkResult = true;
            }
        }catch (SQLException e){
            System.out.println("Error Message: "+e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return checkResult;
    }


    /**
     *location management class. Method updating for updating given location
     * @author Felix DUSENGIMANA
     * @copyright  by Rwanda Coding Academy
     * instructor Donatien MASHENGESHO
     * @since  04-02-2021
     * @param levelId {String} for new data to update existing ones.
     * return boolean to indicated the success or fail to update.
     *
     */

    public   boolean CheckLevelId(String levelId){
        String query = "SELECT level_id FROM `location_levels` WHERE level_id =?";
        boolean checkResult = false;
        try {
            Connection connection = new CloudStorageConnectionHandler().getConnection();

            PreparedStatement checkStatment = connection.prepareStatement(query);
            checkStatment.setString(1,levelId);

            ResultSet rs = checkStatment.executeQuery();
            if (rs.next()){
                connection.close();
                checkResult = true;
            }
        }catch (SQLException e){
            System.out.println("Error Message: "+e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return checkResult;
    }

    /**
     *
     * @author Divine
     * @author Felix DUSENGIMANA
     * @description deleteLocation is function to delete location it will not delete by removing location in database
     * it will change the status of our input to inactive if it exists in our database
     * */

    public ResponseStatus DeleteLocation(Location location){
        try {
            Connection connection= new CloudStorageConnectionHandler().getConnection();

            if(!CheckLocationId(location.getLocation_id())){
                return new ResponseStatus(400,"BAD REQUEST","Oops,Entered location doesn't exists");
            }
            String status = "inactive";
            String sql = "UPDATE locations SET status = ? WHERE location_id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,status);
            stmt.setString(2,location.getLocation_id());
            int updated = stmt.executeUpdate();
            if(updated<1){
                connection.close();
                return  new ResponseStatus(500,"SERVER ERROR","Unable to delete, please try again.");
            }
            connection.close();
            return  new ResponseStatus(200,"DELETED","Delete success.");

        } catch (Exception e) {
            return  new ResponseStatus(500,"SERVER ERROR",e.getMessage());
        }
    }



    /**
     *location management class. Method recovering a given location
     * @author Felix DUSENGIMANA
     * @copyright  by Rwanda Coding Academy
     * instructor Donatien MASHENGESHO
     * @since  08-02-2021
     * return boolean to indicated the success or fail to update.
     *
     */

    public ResponseStatus RecoverLocation(Location location){
        try {
            Connection connection= new CloudStorageConnectionHandler().getConnection();

            String status = "active";
            String sql = "UPDATE locations SET status = ? WHERE location_id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,status);
            stmt.setString(2,location.getLocation_id());
            int updated = stmt.executeUpdate();
            if(updated<1){
                connection.close();
                return  new ResponseStatus(500,"SERVER ERROR","Unable to delete, please try again.");
            }
            connection.close();
            return  new ResponseStatus(200,"RECOVERED","Recovered success.");

        } catch (Exception e) {
            return  new ResponseStatus(500,"SERVER ERROR",e.getMessage());
        }
    }

    /**
     * @author: Landrada Iradukunda
     * get locations by parent
     * */
    public List<Object> fetchByParent(String parent) throws Exception {
        ResultSet result1;
        ResultSet result2;
        String locId = null;
        List<Object> locations = new ArrayList<>();
        Connection connection = new CloudStorageConnectionHandler().getConnection();
        String query1 = "select location_id,location_name from locations where location_name =?";
        PreparedStatement selectStmt1 = connection.prepareStatement(query1);
        selectStmt1.setString(1,parent);
        result1 = selectStmt1.executeQuery();
        while (result1.next()){
            System.out.println("Searching...");
            locId = result1.getString("location_id");
        }
        String query = "select * from locations where parent_id ='"+locId+"' and status='active'";
        PreparedStatement selectStmt = connection.prepareStatement(query);
        result2 = selectStmt.executeQuery();
        while(result2.next()){
            List<Object> list = new ArrayList<>();
            list.add(result2.getString("location_name"));
            list.add(result2.getString("location_GPS"));
            list.add(result2.getString("description"));
            locations.add(list);
        }
        return locations;
    }

}