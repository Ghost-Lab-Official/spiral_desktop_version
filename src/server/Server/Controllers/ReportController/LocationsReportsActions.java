package server.Server.Controllers.ReportController;


import server.Server.Controllers.UserModuleControllers.CounterResponse;
import server.Server.DbController.CloudStorageConnectionHandler;
import server.Server.Model.LocationsReport;
import server.Server.Model.SpotsReport;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LocationsReportsActions {
    /**
     * @author MANZI Mike
     * @description This is a method to print all registered locations
     * @throws Exception
     */
    public List<Object> viewAllLocations() throws Exception {
        List<Object> AllLocations = new ArrayList<>();
        try {
            CloudStorageConnectionHandler cloudStorageConnection = new CloudStorageConnectionHandler();
            Connection connection = cloudStorageConnection.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT location_id, location_name, location_GPS, description," +
                    " status FROM locations");

            while (resultSet.next()) {
                LocationsReport location = new LocationsReport(
                        resultSet.getString("location_id"),
                        resultSet.getString("location_name"),
                        resultSet.getString("location_GPS"),
                        resultSet.getString("description"),
                        resultSet.getString("status")
                );
                AllLocations.add((Object) location);
            }
            connection.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return AllLocations;
    }

    /**
     * @author MANZI Mike
     * @description This is a method to print locations depending on their status
     * @throws Exception
     */
    public List<Object> viewLocationsByStatus(String val) throws Exception {

        List<Object> AllLocations = new ArrayList<>();

        try{
            CloudStorageConnectionHandler cloudStorageConnection = new CloudStorageConnectionHandler();
            Connection connection= cloudStorageConnection.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT location_id, location_name, location_GPS, description," +
                    " status FROM locations WHERE status = '"+val+"'");
            while(resultSet.next()) {
                LocationsReport location = new LocationsReport(
                        resultSet.getString("location_id"),
                        resultSet.getString("location_name"),
                        resultSet.getString("location_GPS"),
                        resultSet.getString("description"),
                        resultSet.getString("status")
                );
                AllLocations.add((Object)location);
            }

        }catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
        return AllLocations;
    }

    /**
     * @author MANZI Mike
     * @description This is a method to print the number of registered locations
     * @throws Exception
     */

    public List<Object> totalNumberOfRegisteredLocations() throws Exception {

        List<Object> counts = new ArrayList<>();
        CloudStorageConnectionHandler cloudStorageConnection = new CloudStorageConnectionHandler();
        Connection connection= cloudStorageConnection.getConnection();
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT count(location_name) from locations");

            int result = 0;
            while(rs.next()){
                result=rs.getInt(1);
            }

            CounterResponse counterResponse = new CounterResponse(result);
            counts.add((Object) counterResponse);

            connection.close();
            return counts;
        }

        catch (Exception e){
            CounterResponse counterResponse = new CounterResponse(0);
            counts.add((Object) counterResponse);
        }

        return counts;
    }

    /**
     * @author MANZI Mike
     * @description This is a method to print the number of locations depending on their status
     * @throws Exception
     */
    public  List<Object> totalNumberOfLocationsByStatus(String val) throws Exception {
        List<Object> counts = new ArrayList<>();

        CloudStorageConnectionHandler cloudStorageConnection = new CloudStorageConnectionHandler();
            Connection connection= cloudStorageConnection.getConnection();
            Statement stmt = connection.createStatement();
            try{
                ResultSet rs = stmt.executeQuery("SELECT count(location_name) from locations WHERE status = " +
                    "'"+val+"'");
                int result = 0;
                while(rs.next()){
                    result=rs.getInt(1);
                }

                CounterResponse counterResponse = new CounterResponse(result);
                counts.add((Object) counterResponse);

                connection.close();
                return counts;
            }catch (Exception e) {
                    CounterResponse counterResponse = new CounterResponse(0);
                    counts.add((Object) counterResponse);
            }

            return counts;
    }

    /**
     * @author MANZI Mike
     * @description This is a method to get spots depending on their locations
     * @throws Exception
     */
    public List<Object> getSpotsByLocation(String place) throws Exception{
        List<Object> AllSpots = new ArrayList<>();

        try{
            Scanner scan = new Scanner(System.in);
            CloudStorageConnectionHandler cloudStorageConnection = new CloudStorageConnectionHandler();
            Connection connection= cloudStorageConnection.getConnection();
            Statement stmt = connection.createStatement();

            ResultSet resultSet = stmt.executeQuery("SELECT Spot_table.spot_id,users_table.user_name,spot_category.category_name,"+
                    "Spot_table.spot_name,locations.location_name,Spot_table.spot_description,Spot_table.views,Spot_table.status," +
                    "Spot_table.registration_date "+"FROM `Spot_table` LEFT JOIN users_table ON users_table.user_id = Spot_table.user_id " +
                    "LEFT JOIN spot_category ON "+"spot_category.category_id = Spot_table.category_id LEFT JOIN locations on " +
                    "locations.location_id = Spot_table.location_id WHERE locations.location_name = '"+place+"'");

            while(resultSet.next()) {
                SpotsReport spot = new SpotsReport(
                        resultSet.getString("spot_id"),
                        resultSet.getString("user_name"),
                        resultSet.getString("category_name"),
                        resultSet.getString("location_name"),
                        resultSet.getString("spot_name"),
                        resultSet.getString("spot_description"),
                        resultSet.getDouble("views"),
                        resultSet.getString("status"),
                        resultSet.getString("registration_date")
                );
                AllSpots.add((Object)spot);
            }

        }catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
        return AllSpots;
    }

    /**
     * @author MANZI Mike
     * @description This is a method to print spots depending on their locations
     * @throws Exception
     */
    public static void printSpots(ResultSet resultSet) throws Exception{
        try{
            CloudStorageConnectionHandler cloudStorageConnection = new CloudStorageConnectionHandler();
            Connection connection= cloudStorageConnection.getConnection();
            ArrayList<SpotsReport> AllSpots = new ArrayList<SpotsReport>();

            while (resultSet.next()) {

                SpotsReport  mySpots = new SpotsReport(
                        resultSet.getString("spot_id"),
                        resultSet.getString("user_name"),
                        resultSet.getString("category_name"),
                        resultSet.getString("location_name"),
                        resultSet.getString("spot_name"),
                        resultSet.getString("spot_description"),
                        resultSet.getDouble("views"),
                        resultSet.getString("status"),
                        resultSet.getString("registration_date")
                );
                AllSpots.add(mySpots);
            }
            Iterator it = AllSpots.iterator();
            System.out.println("\t\t\t  #Id" + "\t\t\t Creator" +  "\t\t\t\t Category " +  "\t\t\t Location" +  "\t\t\t Spot Name " +
                    "\t\t\t\t Spot Description" +"\t\t\t\t Views" +  "\t\t\t\t Status" +  "\t\t\t RegistrationDate ");
            System.out.println("\t\t-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            while(it.hasNext()){
                SpotsReport spot = (SpotsReport)it.next();
                System.out.println(" \t\t\t\t "+spot.getSpot_id() + " \t\t\t\t " + spot.getUser_name()+ " \t\t\t\t " + spot.getCategory_name()+
                        " \t\t\t\t " + spot.getLocation_name()+ " \t\t\t " + spot.getSpot_name() +" \t\t\t\t " +spot.getSpot_description()
                        + " \t\t\t\t "+ spot.getViews()+" \t\t\t\t " + spot.getStatus()+ " \t\t\t\t " + spot.getRegistration_date());
            }
            connection.close();
        }catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
}
