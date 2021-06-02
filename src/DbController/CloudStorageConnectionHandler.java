package DbController;


import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class CloudStorageConnectionHandler {
    public  Connection getConnection()throws Exception{
        Connection connection = null;
        FileReader reader = new FileReader("spiral_desktop_version/config.properties");
        Properties propertiesStored = new Properties();
        propertiesStored.load(reader);
        try {

            String url = propertiesStored.getProperty("dbUrl");
            String username = propertiesStored.getProperty("dbUsername");
            String password = propertiesStored.getProperty("dbPassword");

             Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
             System.out.println("database connection is done ... ");
            return connection;
        } catch (SQLException e) {
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