package server.Server.DbController;
import java.io.FileWriter;
import java.util.Properties;

/**
 * @author : Ntwari Egide
 * @author : Ishimwe Gervais
 * @description: database configuration variables
 */

public class PropertyVariables {

    private String dbUrl;
    private String dbUsername;
    private String dbPassword;
    private Long dbPort;

    private Long port;

    public PropertyVariables(String dbUrl, String dbUsername, String dbPassword, Long dbPort, Long port) {
        this.dbUrl = dbUrl;
        this.dbUsername = dbUsername;
        this.dbPassword = dbPassword;
        this.dbPort = dbPort;
        this.port = port;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getDbUsername() {
        return dbUsername;
    }

    public void setDbUsername(String dbUsername) {
        this.dbUsername = dbUsername;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public Long getDbPort() {
        return dbPort;
    }

    public void setDbPort(Long dbPort) {
        this.dbPort = dbPort;
    }

    public Long getPort() {
        return port;
    }

    public void setPort(Long port) {
        this.port = port;
    }

    public void setPropertiesInFile() throws Exception{
        Properties properties = new Properties();
        properties.setProperty("dbUrl",getDbUrl());
        properties.setProperty("dbUsername",getDbUsername());
        properties.setProperty("dbPassword",getDbPassword());
        properties.setProperty("dbPort",getDbPort().toString());
        properties.setProperty("serverPort",getPort().toString());

<<<<<<< HEAD
        properties.store(new FileWriter("config.properties"),null);
=======
        properties.store(new FileWriter("src/server/config.properties"),null);
>>>>>>> d3cbee5dde6691de8ab652e5c49bd56983c38f24
    }
}
