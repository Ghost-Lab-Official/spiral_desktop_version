/**
 * @author Mutoni Uwingeneye Denyse
 * @version 1.0.0
 *
 */
package server.Server.Controllers.UserModuleControllers;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.temporal.ChronoUnit;
import java.util.TreeMap;

/**
 * Login controller
 * @author Mutoni Uwingeneye Denyse
 */
public class Login {
    public void loginUser(Connection connection,String email,String password) throws Exception{
        boolean checkUser = false;
        String sql = "SELECT * FROM users_table WHERE email = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,email);

        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()){
            System.out.println(rs.getString("email"));
            System.out.println(checkIfPasswordsAreEqual(password,rs.getString("password")));
            if(checkIfPasswordsAreEqual(password,rs.getString("password"))){
                checkUser = true;
                TreeMap <String,String> newPayload = new TreeMap<String,String>();
                newPayload.put("email",rs.getString("email"));
                newPayload.put("user_name",rs.getString("user_name"));
                newPayload.put("user_category",rs.getString("user_Category"));
                Token loginCredentials = new Token(rs.getString("email"),newPayload);
                String userToken = loginCredentials.generateJwtToken(1, ChronoUnit.DAYS);
                System.out.println(userToken);
            };
        }
        else{
            throw new Exception("invalid credentials");
        }
        System.out.println(checkUser);
    }


    /**
     * @author Mutoni Uwingeneye Denyse
     * The checkIfPasswordsAreEqual checks if the passwords are equal
     *make sure that the passwords are equal or get the error
     * @param password password that is not hashed, of String type
     * @param hash hashed password , of String hash;
     * @return decoded string, of String type
     * @throws IllegalArgumentException invalid password
     */
    public boolean checkIfPasswordsAreEqual(String password, String hash){
        boolean rightPassword = false;
        try{
            rightPassword =  BCrypt.checkpw(password,hash);

        }catch (IllegalArgumentException e){
            System.out.println("Wrong credentials");
        }
        return rightPassword;
    }
}
