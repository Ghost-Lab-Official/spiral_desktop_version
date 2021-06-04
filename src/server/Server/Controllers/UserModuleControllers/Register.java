package server.Server.Controllers.UserModuleControllers;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



/**
 * @author Mutoni Uwingeneye Denyse
 * Registering user controller
 * @version 1.0
 */

public class Register{
    /**
     * @author Mutoni Uwingeneye Denyse
     * registerUser method is the function used for registering users
     * @param firstName first name , of type String
     * @param lastName last name , of type String
     * @param userName user name , of type String
     * @param email email, of type String
     * @param  gender gender, of type String
     * @param birthDate date of the user, of type String
     * @param password password of the user, of type String
     * @param  location location of the user, of the type String
     *
     */
    public boolean  registerUser(Connection connection,String firstName,String lastName,String userName, String email,
                              String gender,String birthDate,String password,String location) throws Exception{
        if(checkIfUserExist(connection,email)){
            System.out.println("Email is already used Please try using another email");
            return false;
        }
        String securePassword = hashPassword(password);
        boolean matched = BCrypt.checkpw(password,securePassword);

        System.out.println(matched);
        String sql = "INSERT INTO users_table(first_name,last_name,user_name,email,gender,birth_date,password,user_category,location,user_status) values (?,?,?,?,?,?,?,?,?,?)";
//        getUsers
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,firstName);
        preparedStatement.setString(2,lastName);
        preparedStatement.setString(3,userName);
        preparedStatement.setString(4,email);
        preparedStatement.setString(5,gender);
        preparedStatement.setString(6,birthDate);
        preparedStatement.setString(7,securePassword);
        preparedStatement.setInt(8,1);
        preparedStatement.setString(9,location);
        preparedStatement.setString(10,"active");
        int inserted = preparedStatement.executeUpdate();
        if(inserted == 1){
            System.out.println("Inserted");
            return  true;
        }
        else{
            System.out.println("an error occurred");
            return false;
        }
    }
    /**
     * @author Mutoni Uwingeneye Denyse
     * hashPassword function is used for hashing passwords
     * @param password password, of type String,
     * @return hashedPassword, of type String
     * */
    private String hashPassword(String password){
        System.out.println(BCrypt.gensalt(12));
        return BCrypt.hashpw(password,BCrypt.gensalt(12));

    }
    /**
     * @author Mutoni Uwingeneye Denyse
     * checkIfUserExist used for checking if the email is already registered in the system thus
        if the user already exist you get the boolean value
     * @param connection, of type Connection
     * @param email, of type String
     * @return checkUser , of type boolean
     * */
    public static boolean checkIfUserExist(Connection connection,String email) throws Exception {
        String sql = "SELECT * FROM users_table WHERE email = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,email);
        ResultSet rs = preparedStatement.executeQuery();
        boolean checkUser = false;
        if (rs.next()){
            checkUser = true;
        }
        return checkUser;
    }

}

