package server.Server.Controllers.ReportController;

import server.Server.DbController.CloudStorageConnectionHandler;
import server.Server.Model.ResponseStatus;
import server.Server.Model.UserLog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;


    /**
     * @author: Best Verie Iradukunda.
     * @Comment: 
     * userLogs action: This class helps to Keep track of each and every action that the users perform on our system . it has a method which enable
     * us to get or fetch all user logs in the database and the other method to record user activities which will be called in all modules so as
     * to get an object some essential information that one can need so as to have this functionality working which are user_id or user_name as well as each action and the
     * time he logged in and out .
     * we also compute some operations like totalIn and totalOut which are designed  to show the total number of users that are using the system
     * at a time (logged in) and the others that have logged out at a time. I think it now makes sense.
     * @date: 5 Feb 2021
     * @copyright all right reserved.
     **/
    

public class UserLogsActions {
    String getAllUserLogsQuery = "select * from user_logs";
    public synchronized List<Object> getAllUserLogs()throws Exception{
        Connection connection = new CloudStorageConnectionHandler().getConnection();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(getAllUserLogsQuery);
        List<Object> userLogList = new ArrayList();
        while (result.next()){
            UserLog userLog = new UserLog();
            userLog.setId(result.getInt("id"));
            userLog.setUser_id(result.getInt("user_id"));
            userLog.setDateTimeLoggedIn(result.getString("date_Time_logged_In"));
            userLog.setAction(result.getString("action"));
            userLog.setDateTimeLoggedOut(result.getString("date_Time_logged_Out"));
            userLog.setTotalIn(result.getInt("Total_in"));
            userLog.setTotalOut(result.getInt("Total_out"));
            userLogList.add((Object) userLog);
        }

        return userLogList;
    }

     public static String dateParser(){
         TimeZone tz = TimeZone.getTimeZone("UTC");
         DateFormat df = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss");
         df.setTimeZone(tz);

         return df.format(new Date());
     }

    public ResponseStatus recordUserLogs(UserLog userLog) throws Exception{
        String recordUserLogsQuery="INSERT into user_logs(user_id, date_Time_logged_In,Action, date_Time_logged_Out,Total_In, Total_out) values (?, ?, ?, ?, ?, ?)";
        String getPreviousRowQuery="SELECT date_Time_logged_In, Total_In, Total_out  FROM user_logs ORDER by id DESC LIMIT 1";
        Connection connection=new CloudStorageConnectionHandler().getConnection();
        Statement statement=connection.createStatement();
        ResultSet rs=statement.executeQuery(getPreviousRowQuery);
        while (rs.next()){
           if(userLog.getAction().equals("logIn")){
               int currentTotalIn = 0;
               currentTotalIn=rs.getInt("Total_in");
               int currentTotalOut = 0;
               currentTotalOut = rs.getInt("Total_out");
               userLog.setTotalIn(currentTotalIn+1);
               userLog.setTotalOut(currentTotalOut);
           }
           else if(userLog.getAction().equals("logOut")){
               int currentTotalIn = rs.getInt("Total_in");
               int currentTotalOut = rs.getInt("Total_out");
               userLog.setDateTimeLoggedIn(rs.getString("date_Time_logged_In"));

               userLog.setDateTimeLoggedOut(dateParser());
               userLog.setTotalIn(currentTotalIn-1);
               userLog.setTotalOut(currentTotalOut+1);
           }
           else{
               String currentLoginDateTime=rs.getString("date_Time_logged_In");
               userLog.setDateTimeLoggedIn(currentLoginDateTime);
               userLog.setTotalIn(rs.getInt("Total_in"));
               userLog.setTotalOut(rs.getInt("Total_out"));
           }
        }

        try {
            PreparedStatement preparedStatement=connection.prepareStatement(recordUserLogsQuery);
            preparedStatement.setInt(1,userLog.getUser_id());
            preparedStatement.setString(2,userLog.getDateTimeLoggedIn());
            preparedStatement.setString(3,userLog.getAction());
            preparedStatement.setString(4,userLog.getDateTimeLoggedOut());
            preparedStatement.setInt(5,userLog.getTotalIn());
            preparedStatement.setInt(6,userLog.getTotalOut());

            int inserted =preparedStatement.executeUpdate();

            if (inserted == 1){
                return new ResponseStatus(200,"USER LOG ADDED","successfully recorded this activity");
            }
        }
        catch (Exception e){
            return new ResponseStatus(400,"BAD REQUEST",e.getMessage());
        }
        return null;
    }
}
