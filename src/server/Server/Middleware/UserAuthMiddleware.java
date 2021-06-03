package server.Server.Middleware;


import server.Server.Model.UserLog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author : Blessing Hirwa
 * @description: checking for a logged in user
 * @throws Exception
 */
public class UserAuthMiddleware {
    public Integer checkForUserExistence()throws Exception{
        InputStream inputStream = new FileInputStream("config.properties");
        // Writing token and other required credentials
        Properties properties = new Properties();
        properties.load(inputStream);

        Object userId = (Object) properties.getProperty("UserId");

        if(userId == null){
            InputStream input = new FileInputStream("config.properties");
            // Writing token and other required credentials
            Properties props = new Properties();
            properties.load(input);
            properties.setProperty("Token","");
            properties.setProperty("UserId", String.valueOf(0));

            properties.store(new FileOutputStream("config.properties"),null);

            return 0;
        }
        String ret = userId.toString();
    return Integer.parseInt(ret);

    }

    /**
     * @author : Muhodari Sage
     * @description: Logout functionality
     * @throws Exception
     */
    public void logoutMiddleWare()throws Exception {
        File file;
        InputStream inputStream = new FileInputStream("config.properties");
        // Writing token and other required credentials
        Properties properties = new Properties();
        properties.load(inputStream);
        properties.setProperty("Token", "");
        properties.setProperty("UserId", "0");

        properties.store(new FileOutputStream("config.properties"), null);

        System.out.println("\t\t -------------------------------------- STATUS: 200  ---------------------------");
        System.out.println("\t\t --------------         Meaning: LOGOUT IS DONE ");
        System.out.println("\t\t --------------         Action: Goodbye , See you later !");
        System.out.println("\t\t ------------------------------------------------------------------------------");

        UserLog userLogToInsert = new UserLog();
        userLogToInsert.setUser_id(new UserAuthMiddleware().checkForUserExistence());
        userLogToInsert.setAction("logOut");


    }
    public Integer checkIfIsAdmin()throws Exception{
        InputStream inputStream = new FileInputStream("config.properties");
        Properties properties = new Properties();
        properties.load(inputStream);

        return Integer.valueOf(properties.getProperty("ROLE"));
    }
}
