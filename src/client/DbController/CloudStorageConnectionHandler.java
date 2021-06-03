package client.DbController;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import java.io.FileReader;
import java.util.Properties;

/**
 * @Author: Ntwari Egide
 * @Author: Ishimwe Gervais
 * @description: Setting global settings in config.properties
 */
public class CloudStorageConnectionHandler {
    public  Connection getConnection()throws Exception{
        Connection connection = null;
        FileReader reader = new FileReader("config.properties");
        Properties propertiesStored = new Properties();
        try {
//            String url = propertiesStored.getProperty("dbUrl");
//            String username = propertiesStored.getProperty("dbUsername");
//            String password = propertiesStored.getProperty("dbPassword");
             Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/2YQ7auowc7?autoReconnect=true&useSSL=false", "2YQ7auowc7", "Ro7fFhRVZY");
            // System.out.println("database connection is done ... ");
            return connection;
        }
//        catch (CommunicationsException e){
//            System.out.println("connection problem is occurring on the host server ");
//        }

        catch (SQLException e) {
            System.out.println("sql connection exception is occurring ... ");
            System.out.println(e);
        }

        catch (Exception e) {
            System.out.println("High level failure of the system .... ");
            System.out.println(e);
        }
        return connection;
    }
    /*
     * THIS IS HOW WE WILL BE CALLING THE CONNECTION TO THE ONLINE DATABASE
     */


    public static void checkDbWorking(Connection connection)throws Exception{
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("select  * from test_tb");
        System.out.println(" -------------------------- TEST TABLE DATA  ------------------------- ");
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("username");
            String description = rs.getString("description");
            System.out.println(" Id : " + id + "\t\t name: " + name + "\t\t Desc: " + description);
            System.out
                    .println(" ------------------------------------------------------------------------------------ ");
        }
    }
}