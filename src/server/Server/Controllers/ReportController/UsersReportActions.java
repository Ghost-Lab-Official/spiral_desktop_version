package server.Server.Controllers.ReportController;

import server.Server.Controllers.UserModuleControllers.CounterResponse;
import server.Server.DbController.CloudStorageConnectionHandler;
import server.Server.Model.UsersReport;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UsersReportActions {
    /**
     * @author Ntezirizaza Erneste
     * @description This method shows the list of all registered users
     * @throws Exception
     */

    public List<Object>  getTheTotalNumberOfAllUsersRegistered() throws Exception {
        List<Object> counts = new ArrayList<>();
        CloudStorageConnectionHandler cloudStorageConnection = new CloudStorageConnectionHandler();
        Connection connection= cloudStorageConnection.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT count(*) FROM users_table");
        
        int result = 0;
        while(rs.next()){
            result=rs.getInt(1);
        }

        connection.close();

        CounterResponse counterResponse = new CounterResponse(result);
        counts.add((Object) counterResponse);

        return counts;
    }

    /**
     * @author Ntezirizaza Erneste
     * @description This method shows the number of all users according to their statuses
     * @param statusValue is taken by this method as a parameter
     * @throws Exception
     */

    public List<Object> getTheTotalNumberOfAllUsersByStatus(String statusValue) throws Exception {
        CloudStorageConnectionHandler cloudStorageConnection = new CloudStorageConnectionHandler();
        Connection connection = cloudStorageConnection.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT count(*) FROM users_table WHERE user_status = '" + statusValue + "'");

        List<Object> counts = new ArrayList<>();
        int result = 0;

        while (rs.next()) {
            if (statusValue == "active") {
                result = rs.getInt(1);
            } else if (statusValue == "Inactive") {
                result = rs.getInt(1);
            } else
                System.out.println("Invalid status!");
        }

        CounterResponse counterResponse = new CounterResponse(result);
        counts.add((Object) counterResponse);
        connection.close();

      return counts;
    }

    public List<Object> viewAllUsers() throws Exception {
        CloudStorageConnectionHandler cloudStorageConnection = new CloudStorageConnectionHandler();
        Connection connection= cloudStorageConnection.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT users_table.user_id , users_table.first_name , users_table.first_name ," +
                " users_table.last_name , users_table.user_name  , users_table.email , users_table.gender,users_table.birth_date, users_table.location, users_table.user_status , users_table.registration_date , " +
                " users_categories.user_category from users_table " +
                "left join users_categories on users_table.user_id=users_categories.category_id"
        );
        List<Object> AllUsers = new ArrayList<>();
        while (rs.next()) {
            UsersReport myUsers = new UsersReport(
                    rs.getString("user_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("user_name"),
                    rs.getString("email"),
                    rs.getString("gender"),
                    rs.getString("birth_date"),
                    rs.getString("user_category"),
                    rs.getString("location"),
                    rs.getString("user_status"),
                    rs.getString("registration_date")
            );
            AllUsers.add((Object)myUsers);
        }

        connection.close();

        return AllUsers;
    }

    /**
     * @author Ntezirizaza Erneste
     * @description This method shows the list of all users according to their statuses
     * @param statusValue is taken by this method as a parameter
     * @throws Exception
     */

    public List<Object> viewAllUsersByStatus(String statusValue) throws Exception {
        CloudStorageConnectionHandler cloudStorageConnection = new CloudStorageConnectionHandler();
        Connection connection= cloudStorageConnection.getConnection();
        Statement stmt = connection.createStatement();

        String query = "SELECT users_table.user_id , users_table.first_name , users_table.first_name ,users_table.last_name , users_table.user_name , users_table.email , users_table.gender,users_table.birth_date, users_table.location, users_table.user_status , users_table.registration_date , users_categories.user_category from users_table left join users_categories " +
                "on users_table.user_category=users_categories.category_id where user_status ='"+statusValue+"'";

        ResultSet rs = stmt.executeQuery(query);
        List<Object> AllUsers = new ArrayList<>();
        while (rs.next()) {
            UsersReport  myUsers = new UsersReport(
                    rs.getString("user_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("user_name"),
                    rs.getString("email"),
                    rs.getString("gender"),
                    rs.getString("birth_date"),
                    rs.getString("user_category"),
                    rs.getString("location"),
                    rs.getString("user_status"),
                    rs.getString("registration_date")
            );
            AllUsers.add((Object)myUsers);
        }

        connection.close();

        return AllUsers;
    }

}
