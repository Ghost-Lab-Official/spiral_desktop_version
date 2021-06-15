package server.Server.Controllers.ReportController;


import server.Server.Controllers.UserModuleControllers.*;
import server.Server.DbController.*;
import server.Server.Model.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


/**
 * @author Ange Nicole Mukundwa
 * description This class is intended to define all methods that carry out each and every operation or kind of report that an admin need on spots. he she can need the list of all spots, statistical information , as well as reports according to time
 * so, in this class that's where every kind of report  related to spots is defined.
 * @throws Exception
 * @return
 */

public class SpotReportsActions {


    public List<Object>  getTheTotalNumbersOfTrendingSpots() throws Exception {
        List<Object> counts = new ArrayList<>();
        CloudStorageConnectionHandler cloudStorageConnection = new CloudStorageConnectionHandler();
        Connection connection= cloudStorageConnection.getConnection();
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT count(*) FROM Spot_table where views > 10");

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


    public List<Object> getTheTotalNumberOfActiveSpots() throws Exception {


        List<Object> counts = new ArrayList<>();
        CloudStorageConnectionHandler cloudStorageConnection = new CloudStorageConnectionHandler();
        Connection connection = cloudStorageConnection.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("select count(spot_name) from Spot_table where status='active'");
        try {
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

    public List<Object>  getTheTotalNumberOfInactiveSpots() throws Exception {
        List<Object> counts = new ArrayList<>();
        CloudStorageConnectionHandler cloudStorageConnection = new CloudStorageConnectionHandler();
        Connection connection= cloudStorageConnection.getConnection();
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT count(spot_name) FROM Spot_table where status='inactive'");

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


    public List<Object>  getTheTotalNumbersOfRegisteredSpots() throws Exception {
        List<Object> counts = new ArrayList<>();
        CloudStorageConnectionHandler cloudStorageConnection = new CloudStorageConnectionHandler();
        Connection connection= cloudStorageConnection.getConnection();
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT count(*) FROM Spot_table");

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

    public List<Object> viewAllSpots() throws Exception {
        CloudStorageConnectionHandler cloudStorageConnection = new CloudStorageConnectionHandler();
        Connection connection= cloudStorageConnection.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT Spot_table.spot_id,users_table.user_name,spot_category.category_name,"+
                "Spot_table.spot_name,locations.location_id,Spot_table.spot_description,Spot_table.views,Spot_table.status," +
                "Spot_table.registration_date "+"FROM `Spot_table` LEFT JOIN users_table ON users_table.user_id = Spot_table.user_id " +
                "LEFT JOIN spot_category ON "+"spot_category.category_id = Spot_table.category_id LEFT JOIN locations on " +
                getlocations() + ".location_id = Spot_table.location_id"
        );
        List <Object> AllSpots = new ArrayList<>();
        while (rs.next()) {
            SpotsReport mySpots = new SpotsReport(
                    rs.getString("spot_id"),
                    rs.getString("user_name"),
                    rs.getString("category_name"),
                    rs.getString("location_id"),
                    rs.getString("spot_name"),
                    rs.getString("spot_description"),
                    rs.getDouble("views"),
                    rs.getString("status"),
                    rs.getString("registration_date")
            );
            AllSpots.add((Object)mySpots);
        }

        connection.close();

        return AllSpots;
    }

    private static String getlocations() {
        return "locations";
    }





    public List<Object>  viewAllInactiveSpots() throws Exception{
        CloudStorageConnectionHandler cloudStorageConnection = new CloudStorageConnectionHandler();
        Connection connection= cloudStorageConnection.getConnection();
        Statement stmnt = connection.createStatement();
        String query= "SELECT Spot_table.spot_id,users_table.user_name,spot_category.category_name,"+
                "Spot_table.spot_name,locations.location_id,Spot_table.spot_description,Spot_table.views,Spot_table.status," +
                "Spot_table.registration_date "+"FROM `Spot_table` LEFT JOIN users_table ON users_table.user_id = Spot_table.user_id " +
                "LEFT JOIN spot_category ON "+"spot_category.category_id = Spot_table.category_id LEFT JOIN locations on " +
                "locations.location_id = Spot_table.location_id" +
                " WHERE Spot_table.status ='inactive'";
        ResultSet resultset=stmnt.executeQuery(query);
        List <Object> AllSpots = new ArrayList<>();

        while (resultset.next()) {
            SpotsReport  mySpots = new SpotsReport(
                    resultset.getString("spot_id"),
                    resultset.getString("user_name"),
                    resultset.getString("category_name"),
                    resultset.getString("location_id"),
                    resultset.getString("spot_name"),
                    resultset.getString("spot_description"),
                    resultset.getDouble("views"),
                    resultset.getString("status"),
                    resultset.getString("registration_date")
            );
            AllSpots.add((Object)mySpots);
        }

        connection.close();

        return AllSpots;
    }



    public List<Object>  viewHighlyRatedSpots() throws Exception{
        CloudStorageConnectionHandler cloudStorageConnection = new CloudStorageConnectionHandler();
        Connection connection= cloudStorageConnection.getConnection();
        Statement stmnt = connection.createStatement();
        String query= "SELECT Spot_table.spot_id,users_table.user_name,spot_category.category_name, Spot_table.spot_name,locations.location_id,Spot_table.spot_description,Spot_table.views,Spot_table.status, Spot_table.registration_date FROM `Spot_table` LEFT JOIN users_table ON users_table.user_id = Spot_table.user_id LEFT JOIN spot_category ON spot_category.category_id = Spot_table.category_id LEFT JOIN locations on locations.location_id = Spot_table.location_id ORDER BY rates DESC LIMIT 3\n";
        ResultSet resultset=stmnt.executeQuery(query);
        List <Object> AllSpots = new ArrayList<>();

        while (resultset.next()) {
            SpotsReport  mySpots = new SpotsReport(
                    resultset.getString("spot_id"),
                    resultset.getString("user_name"),
                    resultset.getString("category_name"),
                    resultset.getString("location_id"),
                    resultset.getString("spot_name"),
                    resultset.getString("spot_description"),
                    resultset.getDouble("views"),
                    resultset.getString("status"),
                    resultset.getString("registration_date")
            );
            AllSpots.add((Object)mySpots);
        }

        connection.close();

        return AllSpots;
    }

    public List<Object> viewRecentlyAddedSpots()throws Exception{
        CloudStorageConnectionHandler cloudStorageConnection = new CloudStorageConnectionHandler();
        Connection connection= cloudStorageConnection.getConnection();
        Statement stmnt = connection.createStatement();
        String query= "SELECT * FROM `Spot_table` LIMIT 5";
        ResultSet resultset=stmnt.executeQuery(query);
        List <Object> AllSpots = new ArrayList<>();

        while (resultset.next()) {
            SpotsReport  mySpots = new SpotsReport(
                    resultset.getString("spot_id"),
                    resultset.getString("user_id"),
                    resultset.getString("category_id"),
                    resultset.getString("location_id"),
                    resultset.getString("spot_name"),
                    resultset.getString("spot_description"),
                    resultset.getDouble("views"),
                    resultset.getString("status"),
                    resultset.getString("registration_date")
            );
            AllSpots.add((Object)mySpots);
        }

        connection.close();

        return AllSpots;

    }
    public List<Object> ViewHighlyVisitedSpots() throws Exception{
        CloudStorageConnectionHandler cloudStorageConnection = new CloudStorageConnectionHandler();
        Connection connection = cloudStorageConnection.getConnection();
        Statement stment = connection.createStatement();
//            String querry = "SELECT Spot_table.spot_id , Spot_table.spot_name , Spot_table.spot_description ," +
//                    " Spot_table.status , Spot_table.views  , Spot_table.registration_date ," +
//                    " users_table.user_name , locations.location_name , spot_category.category_name from Spot_table " +
//                    "left join users_table on Spot_table.user_id=users_table.user_id" +
//                    " left join locations on Spot_table.location_id = locations.location_id" +
//                    " left join spot_category on Spot_table.category_id = spot_category.category_id " +
//                    "WHERE Spot_table.status ='active' AND Spot_table.views > 10 LIMIT 5";

        String querry = "SELECT * from Spot_table lIMIT 5";
        ResultSet resultset = stment.executeQuery(querry);

        List <Object> AllSpots = new ArrayList<>();
        while (resultset.next()) {
            SpotsReport  mySpots = new SpotsReport(
                    resultset.getString("spot_id"),
                    resultset.getString("user_id"),
                    resultset.getString("category_id"),
                    resultset.getString("location_id"),
                    resultset.getString("spot_name"),
                    resultset.getString("spot_description"),
                    resultset.getDouble("views"),
                    resultset.getString("status"),
                    resultset.getString("registration_date")
            );
            AllSpots.add((Object)mySpots);
        }

        connection.close();

        return AllSpots;
    }



    public List<Object> viewAllActiveSpots() throws Exception {

        CloudStorageConnectionHandler cloudStorageConnection = new CloudStorageConnectionHandler();
        Connection connection= cloudStorageConnection.getConnection();
        Statement stmt = connection.createStatement();

        String query= "SELECT Spot_table.spot_id,users_table.user_name,spot_category.category_name,"+
                "Spot_table.spot_name,locations.location_id,Spot_table.spot_description,Spot_table.views,Spot_table.status," +
                "Spot_table.registration_date "+"FROM `Spot_table` LEFT JOIN users_table ON users_table.user_id = Spot_table.user_id " +
                "LEFT JOIN spot_category ON "+"spot_category.category_id = Spot_table.category_id LEFT JOIN locations on " +
                "locations.location_id = Spot_table.location_id" +
                " WHERE Spot_table.status ='active'";
        System.out.println(query);
        ResultSet rs = stmt.executeQuery(query);


        List <Object> AllSpots = new ArrayList<>();
        while (rs.next()) {
            SpotsReport  mySpots = new SpotsReport(
                    rs.getString("spot_id"),
                    rs.getString("user_name"),
                    rs.getString("category_name"),
                    rs.getString("location_id"),
                    rs.getString("spot_name"),
                    rs.getString("spot_description"),
                    rs.getDouble("views"),
                    rs.getString("status"),
                    rs.getString("registration_date")
            );
            AllSpots.add((Object)mySpots);
        }

        connection.close();

        return AllSpots;
    }

    public List<Object> viewThisMonthsSpots()throws Exception{
        List<Object> thisMonthsSpots = new ArrayList<>();
        try {
            CloudStorageConnectionHandler cloudStorageConnection = new CloudStorageConnectionHandler();
            Connection connection= cloudStorageConnection.getConnection();
            Statement statement = connection.createStatement();
//            LocalDate currentDate = LocalDate.now();
//            Month currentMonth = currentDate.getMonth();
            String query="SELECT Spot_table.spot_id , Spot_table.spot_name , Spot_table.spot_description ," +
                    " Spot_table.status , Spot_table.views  , Spot_table.registration_date ," +
                    " users_table.user_name , locations.location_name , spot_category.category_name from Spot_table " +
                    "left join users_table on Spot_table.user_id=users_table.user_id" +
                    " left join locations on Spot_table.location_id = locations.locationId" +
                    " left join spot_category on Spot_table.category_id = spot_category.category_id " +
                    "where MONTH(Spot_table.registration_date) = EXTRACT(MONTH From CURRENT_TIMESTAMP)";
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                SpotsReport  currentMonthsSpots = new SpotsReport(
                        result.getString("spot_id"),
                        result.getString("user_name"),
                        result.getString("category_name"),
                        result.getString("location_name"),
                        result.getString("spot_name"),
                        result.getString("spot_description"),
                        result.getDouble("views"),
                        result.getString("status"),
                        result.getString("registration_date")
                );
                thisMonthsSpots.add((Object)currentMonthsSpots);


            }

            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return thisMonthsSpots;
    }


    public List<Object> viewThisMonthsTrendingSpots() throws Exception{
        List<Object> thisMonthsTrendingSpots = new ArrayList<>();

        try {
            CloudStorageConnectionHandler cloudStorageConnection = new CloudStorageConnectionHandler();
            Connection connection= cloudStorageConnection.getConnection();
            Statement statement = connection.createStatement();
//            LocalDate currentDate = LocalDate.now();
//            Month currentMonth = currentDate.getMonth();
            String query="SELECT Spot_table.spot_id , Spot_table.spot_name , Spot_table.spot_description ," +
                    " Spot_table.status , Spot_table.views  , Spot_table.registration_date ," +
                    " users_table.user_name , locations.location_name , spot_category.category_name from Spot_table " +
                    "left join users_table on Spot_table.user_id=users_table.user_id" +
                    " left join locations on Spot_table.location_id = locations.locationId" +
                    " left join spot_category on Spot_table.category_id = spot_category.category_id " +
                    "where MONTH(Spot_table.registration_date) =EXTRACT(MONTH From CURRENT_TIMESTAMP) and YEAR(Spot_table.registration_date) = EXTRACT(YEAR from CURRENT_TIMESTAMP) and Spot_table.status=1 and views>20 limit 1";
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                SpotsReport  currentMonthsTrendingSpots = new SpotsReport(
                        result.getString("spot_id"),
                        result.getString("user_name"),
                        result.getString("category_name"),
                        result.getString("location_name"),
                        result.getString("spot_name"),
                        result.getString("spot_description"),
                        result.getDouble("views"),
                        result.getString("status"),
                        result.getString("registration_date")
                );
                thisMonthsTrendingSpots.add((Object)currentMonthsTrendingSpots);

            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return thisMonthsTrendingSpots;
    }

    public List<Object>  viewTodaysSpots()throws Exception{

        List<Object> TodaysNewSpots = new ArrayList<>();
        try {
            CloudStorageConnectionHandler cloudStorageConnection=new CloudStorageConnectionHandler();
            Connection connection=cloudStorageConnection.getConnection();

            Statement statement=connection.createStatement();
            LocalDate currentDate = LocalDate.now();
            String query="SELECT Spot_table.spot_id , Spot_table.spot_name , Spot_table.spot_description ," +
                    " Spot_table.status , Spot_table.views  , Spot_table.registration_date ," +
                    " users_table.user_name , locations.location_name , spot_category.category_name from Spot_table " +
                    "left join users_table on Spot_table.user_id=users_table.user_id" +
                    " left join locations on Spot_table.location_id = locations.location_id" +
                    " left join spot_category on Spot_table.category_id = spot_category.category_id where Spot_table.registration_date = "+"'"+currentDate+"'";


            ResultSet result=statement.executeQuery(query);

            while (result.next()){
                SpotsReport thisdaysSpots =new SpotsReport(
                        result.getString("spot_id"),
                        result.getString("user_name"),
                        result.getString("category_name"),
                        result.getString("location_name"),
                        result.getString("spot_name"),
                        result.getString("spot_description"),
                        result.getDouble("views"),
                        result.getString("status"),
                        result.getString("registration_date")
                );
                TodaysNewSpots.add((Object)thisdaysSpots);
            }

            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return TodaysNewSpots;
    }
    public List<Object>  viewTodaysTrendingSpots()throws Exception{
        List<Object> TodaysNewSpots = new ArrayList<>();

        try {
            CloudStorageConnectionHandler cloudStorageConnection=new CloudStorageConnectionHandler();
            Connection connection=cloudStorageConnection.getConnection();

            Statement statement=connection.createStatement();
            LocalDate currentDate = LocalDate.now();
            String query="SELECT Spot_table.spot_id , Spot_table.spot_name , Spot_table.spot_description ," +
                    " Spot_table.status , Spot_table.views  , Spot_table.registration_date ," +
                    " users_table.user_name , locations.location_name , spot_category.category_name from Spot_table " +
                    "left join users_table on Spot_table.user_id=users_table.user_id" +
                    " left join locations on Spot_table.location_id = locations.locationId" +
                    " left join spot_category on Spot_table.category_id = spot_category.category_id where Spot_table.registration_date = "+"'"+currentDate+"' and Spot_table.status=1 and Spot_table.views >20 limit 1";


            ResultSet result=statement.executeQuery(query);

            while (result.next()){
                SpotsReport thisdaysSpots =new SpotsReport(
                        result.getString("spot_id"),
                        result.getString("user_name"),
                        result.getString("category_name"),
                        result.getString("location_name"),
                        result.getString("spot_name"),
                        result.getString("spot_description"),
                        result.getDouble("views"),
                        result.getString("status"),
                        result.getString("registration_date")
                );
                TodaysNewSpots.add(thisdaysSpots);
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return TodaysNewSpots;
    }

    public List <Object> getReportForAnotherDay(String anotherDate)throws Exception{
        List<Object> reportForAnotherDay=new ArrayList<>();
        try{
            CloudStorageConnectionHandler cloudStorageConnection=new CloudStorageConnectionHandler();
            Connection connection=cloudStorageConnection.getConnection();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
            LocalDate myDate = LocalDate.parse(anotherDate, formatter);

            Statement statement=connection.createStatement();
            String query="SELECT Spot_table.spot_id , Spot_table.spot_name , Spot_table.spot_description ," +
                    " Spot_table.status , Spot_table.views  , Spot_table.registration_date ," +
                    " users_table.user_name , locations.location_name , spot_category.category_name from Spot_table " +
                    "left join users_table on Spot_table.user_id=users_table.user_id" +
                    " left join locations on Spot_table.location_id = locations.location_id" +
                    " left join spot_category on Spot_table.category_id = spot_category.category_id where Spot_table.registration_date = "+"'"+myDate+"'";


            ResultSet resultSet=statement.executeQuery(query);

            while (resultSet.next()){
                SpotsReport spots= new SpotsReport(
                        resultSet.getString("spot_id"),
                        resultSet.getString("user_name"),
                        resultSet.getString("category_name"),
                        resultSet.getString("location_name"),
                        resultSet.getString("spot_name"),
                        resultSet.getString("spot_description"),
                        resultSet.getDouble("views"),
                        resultSet.getString("status"),
                        resultSet.getString("registration_date")                    );

                reportForAnotherDay.add((Object)spots);
            }
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return reportForAnotherDay;
    }


    public static void getReportForAnotherMonth(int month, int year)throws Exception {
        try {
            CloudStorageConnectionHandler cloudStorageConnection = new CloudStorageConnectionHandler();
            Connection connection = cloudStorageConnection.getConnection();

            Statement statement = connection.createStatement();
            String query = "SELECT Spot_table.spot_id , Spot_table.spot_name , Spot_table.spot_description ," +
                    " Spot_table.status , Spot_table.views  , Spot_table.registration_date ," +
                    " users_table.user_name , locations.location_name , spot_category.category_name from Spot_table " +
                    "left join users_table on Spot_table.user_id=users_table.user_id" +
                    " left join locations on Spot_table.location_id = locations.locationId" +
                    " left join spot_category on Spot_table.category_id = spot_category.category_id " +
                    "where MONTH(Spot_table.registration_date)= " + month + " and YEAR(Spot_table.registration_date) =" + year;
//            System.out.println(query);


            ResultSet resultSet = statement.executeQuery(query);
            ArrayList<SpotsReport> reportForAnotherDay = new ArrayList<SpotsReport>();

            while (resultSet.next()) {
                SpotsReport spots = new SpotsReport(
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

                reportForAnotherDay.add(spots);
            }
            Iterator iterator = reportForAnotherDay.iterator();
            System.out.println("\t\t\t #Id" + "\t\t\t createdBy" + "\t\t\t  Entitled " + "\t\t\t\t\t\t location" + "\t\t\t\t\t category " + "\t\t\t\t\t\t status " + "\t\t\t\t\t views" + "\t\t\t\t\t  registrationDate ");
            System.out.println("\t\t-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            while (iterator.hasNext()) {
                SpotsReport spot = (SpotsReport) iterator.next();
                System.out.println("\t\t\t " + spot.getSpot_id() + "\t\t\t\t " + spot.getUser_name() + "\t\t\t\t " + spot.getSpot_description() + "\t\t\t\t\t " + spot.getLocation_name() + "\t\t\t\t\t " + spot.getCategory_name() + "\t\t\t\t\t\t\t\t " + spot.getStatus() + "\t\t\t\t\t\t\t " + spot.getViews() + "\t\t\t\t\t\t " + spot.getRegistration_date());
            }
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        public static List<List> printDataOnLineChart(){
            List<List> data = new ArrayList<List>();
            try{
                CloudStorageConnectionHandler cloudStorageConnection = new CloudStorageConnectionHandler();
                Connection connection = cloudStorageConnection.getConnection();
                Statement statement = connection.createStatement();
                String castedYear;
                Set<Integer> years = new HashSet<Integer>();
                List<Integer> yearsList = new ArrayList<Integer>();
                List<Integer> spots = new ArrayList<>();
                Set<String> castedYears = new HashSet<String>();
                String number_of_years = "SELECT EXTRACT(YEAR FROM registration_date) FROM Spot_table";
                ResultSet resultSet = statement.executeQuery(number_of_years);
                while (resultSet.next()){
                years.add(Integer.parseInt(resultSet.getString(1)));
                }
                yearsList.addAll(years);
                for(Integer spotYear: yearsList) {
                    castedYear= spotYear.toString();
                    castedYears.add(castedYear);
                    String spotsNumber = "SELECT COUNT(spot_id) FROM Spot_table WHERE (SELECT EXTRACT(YEAR FROM registration_date)='"+castedYear+"')";
                    ResultSet resultSet2 = statement.executeQuery(spotsNumber);
                   while (resultSet2.next()){
                       spots.add(Integer.parseInt(resultSet2.getString(1)));
                   }
                }
                data.add(spots);
                data.add(yearsList);
                System.out.println(data);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            return data;
        }

    }


