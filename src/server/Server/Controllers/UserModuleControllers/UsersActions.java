package server.Server.Controllers.UserModuleControllers;

import server.Server.DbController.CloudStorageConnectionHandler;
import server.Server.Model.*;
import org.mindrot.jbcrypt.BCrypt;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.SQLException;
import java.util.Properties;

public class UsersActions {
    String selectQuery = "select user_id, first_name, last_name, user_name,email, gender, birth_date,user_category,location,user_status,registration_date from users_table";
    String createUserQuery = "INSERT INTO users_table(first_name,last_name,user_name,email,gender,birth_date,password,user_category,location,user_status) values (?,?,?,?,?,?,?,?,?,?)";
    String loginUserQuery = "SELECT * FROM users_table WHERE email = ?";
    String userNameQuery = "SELECT * from users_table WHERE user_name = ? ";
    String secreteKey = "SpiralSystemPrivateKeyForAuthentication";


    public static boolean checkIfUserExist(Connection connection, String email) throws Exception {
        String sql = "SELECT * FROM users_table WHERE email = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, email);
        ResultSet rs = preparedStatement.executeQuery();
        boolean checkUser = false;
        if (rs.next()) {
            checkUser = true;
        }
        return checkUser;
    }

    private String hashPassword(String password) {
        System.out.println(BCrypt.gensalt(12));
        return BCrypt.hashpw(password, BCrypt.gensalt(12));

    }

    public ResponseStatus registerUserInDb(User userToRegister) throws Exception {
        final String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";


        ResponseStatus responseStatus = new ResponseStatus(200, "OK", "CREATED THE USER");
        Connection connection = new CloudStorageConnectionHandler().getConnection();

        System.out.print(userToRegister.getEmail());

        if (checkIfUserExist(connection, userToRegister.getEmail())) {
            return new ResponseStatus(400, "USER FOUND", "User email is found, try another ");
        }

        String securePassword = hashPassword(userToRegister.getPassword());
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(userToRegister.getEmail());
        System.out.println(matcher.matches());

        if (!matcher.matches()) {
            return new ResponseStatus(400, "INVALID EMAIL", "Invalid email please try another ");
        }

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(createUserQuery);
            preparedStatement.setString(1, userToRegister.getFirstName());
            preparedStatement.setString(2, userToRegister.getLastName());
            preparedStatement.setString(3, userToRegister.getUserName());
            preparedStatement.setString(4, userToRegister.getEmail());
            preparedStatement.setString(5, userToRegister.getGender());
            preparedStatement.setString(6, userToRegister.getBirthDate());
            preparedStatement.setString(7, securePassword);
            preparedStatement.setInt(8, 1);
            preparedStatement.setString(9, userToRegister.getLocation());
            preparedStatement.setString(10, "inactive");

            int inserted = preparedStatement.executeUpdate();
            if (inserted == 1) {
                return new ResponseStatus(200, "CREATED", "User registered , Go Login");
            } else {
                return new ResponseStatus(500, "SERVER ERROR", "Insertion failed, try or contact System Administrator");
            }
        } catch (Exception e) {
            return new ResponseStatus(300, "EXCEPTIONAL ERROR", e.getMessage());
        }
    }

    public ResponseStatus loginUser(User userToLogin) throws Exception {
        boolean checkUser = false;
        Connection connection = new CloudStorageConnectionHandler().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(loginUserQuery);
            preparedStatement.setString(1,userToLogin.getEmail());
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()){
                System.out.println(rs.getString("email"));
                System.out.println(checkIfPasswordsAreEqual(userToLogin.getPassword(),rs.getString("password")));
                if(checkIfPasswordsAreEqual(userToLogin.getPassword(),rs.getString("password"))){
                    checkUser = true;
                    TreeMap<String,String> newPayload = new TreeMap<String,String>();
                    newPayload.put("email",rs.getString("email"));
                    newPayload.put("user_name",rs.getString("user_name"));
                    newPayload.put("user_category",rs.getString("user_Category"));
                    Token loginCredentials = new Token(rs.getString("email"),newPayload);
                    String userToken = loginCredentials.generateJwtToken(1, ChronoUnit.DAYS);

//                    File file;
                    InputStream inputStream = new FileInputStream("config.properties");
                    // Writing token and other required credentials
                    Properties properties = new Properties();
                    properties.load(inputStream);
                    properties.setProperty("Token",userToken);
                    properties.setProperty("UserId",rs.getString("user_id"));
                    properties.setProperty("ROLE",rs.getString("user_category"));

                    properties.store(new FileOutputStream("config.properties"),null);

                    return new ResponseStatus(200,"LOGGED IN",(Object) new TokenIssued(userToken),"You are logged in ");
                };
            }
            else{
                return new ResponseStatus(404,"LOGGED FAILED","Email or password is incorrect");
            }

        return null;
    }

    public static boolean checkIfUserNameExist(Connection connection, Integer userId) throws Exception {
        String userNameQuery = "SELECT * from users_table WHERE user_id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(userNameQuery);
        preparedStatement.setInt(1, userId);
        ResultSet rs = preparedStatement.executeQuery();
        boolean checkUser = false;
        if (rs.next()) {
            checkUser = true;
        }
        return checkUser;
    }

    public ResponseStatus updateUserSettings(User userToRegisterUpdate) throws Exception {

        Connection connection = new CloudStorageConnectionHandler().getConnection();
        String sqlQuery = "UPDATE users_table SET first_name = ? , last_name = ?, gender = ?, birth_date = ? WHERE user_id = ? ";

        if (!checkIfUserNameExist(connection, userToRegisterUpdate.getUserId())) {
            return new ResponseStatus(400, "USER NOT FOUND", "User id was not found in the system, try another ");
        }
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(sqlQuery);
            prepareStatement.setString(1, userToRegisterUpdate.getFirstName());
            prepareStatement.setString(2, userToRegisterUpdate.getLastName());
            prepareStatement.setString(3, userToRegisterUpdate.getGender());
            prepareStatement.setString(4, userToRegisterUpdate.getBirthDate());
            prepareStatement.setInt(5, userToRegisterUpdate.getUserId());

            int rowsUpdate = prepareStatement.executeUpdate();
            if (rowsUpdate == 1) {
                return new ResponseStatus(200, "UPDATED", "User successfully updated ");
            } else {
                return new ResponseStatus(500, "SERVER ERROR", "Update failed, try or contact System Administrator");
            }
        } catch (SQLException e) {
            return new ResponseStatus(300, "EXCEPTIONAL ERROR", e.getMessage());
        }
    }

    public List<Object> selectUsers() throws Exception {
        Connection connection = new CloudStorageConnectionHandler().getConnection();
        Statement state = connection.createStatement();
        ResultSet result = state.executeQuery(selectQuery);
        List<Object> users = new ArrayList<>();

        while (result.next()) {
            User user = new User();

            user.setUserId(result.getInt(1));
            user.setFirstName(result.getString(2));
            user.setLastName(result.getString(3));
            user.setUserName(result.getString(4));
            user.setEmail(result.getString(5));
            user.setGender(result.getString(6));
            user.setUserCategory(result.getString(7));
            user.setBirthDate(result.getString(8));
            user.setLocation(result.getString(9));
            users.add((Object) user);
        }
        return users;
    }

    public boolean checkIfPasswordsAreEqual(String password, String hash) {
        boolean rightPassword = false;
        try {
            rightPassword = BCrypt.checkpw(password, hash);

        } catch (IllegalArgumentException e) {
            System.out.println("Wrong credentials");
        }
        return rightPassword;
    }

    public void sendNotification(String from, String password, String to, String sub, String msg) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        // get Session
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });
        // System.out.println(session);

        // compose message
        try {
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(sub);
            message.setText(msg);

            // send message
            Transport.send(message);
            System.out.println("message sent successfully");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
    public List<Object> ViewUserProfile(User userToView) throws Exception {
        Connection con = new CloudStorageConnectionHandler().getConnection();
        List<Object> user = new ArrayList<>();
        PreparedStatement state = con.prepareStatement("SELECT user_id, first_name, last_name, user_name,email, gender,user_category,birth_date,location from users_table WHERE user_id= ?");
        state.setInt(1,userToView.getUserId());
        ResultSet result = state.executeQuery();

        while (result.next()) {
            User userObj = new User();
            userObj.setUserId(result.getInt(1));
            userObj.setFirstName(result.getString(2));
            userObj.setLastName(result.getString(3));
            userObj.setUserName(result.getString(4));
            userObj.setEmail(result.getString(5));
            userObj.setGender(result.getString(6));
            userObj.setUserCategory(result.getString(7));
            userObj.setBirthDate(result.getString(8));
            userObj.setLocation(result.getString(9));

            user.add(userObj);

        }

        return user;
    }
    public List<Object> selectUserById(User userToView) throws Exception {
        Connection con = new CloudStorageConnectionHandler().getConnection();
        List<Object> user = new ArrayList<>();
        PreparedStatement state = con.prepareStatement("SELECT user_id, first_name, last_name, user_name,email, gender,user_category,birth_date,location from users_table WHERE user_id= ?");
        state.setInt(1,userToView.getUserId());
        ResultSet result = state.executeQuery();

        while (result.next()) {
            User userObj = new User();

            userObj.setUserId(result.getInt(1));
            userObj.setFirstName(result.getString(2));
            userObj.setLastName(result.getString(3));
            userObj.setUserName(result.getString(4));
            userObj.setEmail(result.getString(5));
            userObj.setGender(result.getString(6));
            userObj.setUserCategory(result.getString(7));
            userObj.setBirthDate(result.getString(8));
            userObj.setLocation(result.getString(9));

            user.add(userObj);

        }

        return user;
    }
    public static ResponseStatus deleteProfile(User userToDelete)throws Exception{
            String deleteSQL = "UPDATE users_table SET user_status= ? WHERE user_id=?";
            Connection connection = new CloudStorageConnectionHandler().getConnection();
            try(PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)){
                preparedStatement.setString(1,"inactive");
                preparedStatement.setInt(2, userToDelete.getUserId());
                int deleted = preparedStatement.executeUpdate();
                if(deleted == 1){
                    return new ResponseStatus(200,"USER DELETED","You have deleted the user");
                }
            }
            catch (SQLException e){
                System.out.println(e.getMessage());
                return  new ResponseStatus(400,"BAD REQUEST",e.getMessage());
            }
            catch (Exception e){
                new ResponseStatus(500,"SERVER ERROR",e.getMessage());
            }
            return new ResponseStatus(500,"SERVER ERROR","e.getMessage()");
    }
    public void ResetPassword(Connection con) throws Exception{
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter your email");
        String email=scanner.nextLine();
        Statement CheckEmail = con.createStatement();
        ResultSet check =CheckEmail.executeQuery("SELECT * from users_table WHERE email='" + email + "'");
        if(check.next()) {
            System.out.println("code sent to "+check.getString("email"));
        }else {
            System.out.println("No email found!");
            return;
        }

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 7;

        for(int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }

        String randomString = sb.toString();

        new SendEmail().send("tzyelissa90@gmail.com","doordie16","twizelissa@gmail.com",
                "Verification Code","verification code:"+randomString);

        System.out.println("----------------------------");
        System.out.println("Enter code we send to "+email);
        String code=scanner.nextLine();
        if(code.equals(randomString)){
            System.out.println("Enter new password");
            String password=scanner.nextLine();

            String securePassword = hashPassword(password);

            PreparedStatement updateSql=con.prepareStatement("Update users_table SET password=? where email=?");
            updateSql.setString(1,securePassword);
            updateSql.setString(2,email);
            int PassUpdate=updateSql.executeUpdate();
            if (PassUpdate>0){
                System.out.println("Password reset successful");
            }

        }
        else {
            System.out.println("Try to Enter sent verification code");
        }
    }
    // for hashing and encrypt password


    public ResponseStatus resetPasswordFirstStep(User userToReset)throws Exception{
        Connection con = new CloudStorageConnectionHandler().getConnection();
        Statement CheckEmail = con.createStatement();
        ResultSet check =CheckEmail.executeQuery("SELECT * from users_table WHERE email='" + userToReset.getEmail() + "'");
        if(check.next() == false) {
            return new ResponseStatus(400,"BAD REQUEST","you entered invalid email");
        }else {
            String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            StringBuilder sb = new StringBuilder();
            Random random = new Random();
            int length = 7;

            for(int i = 0; i < length; i++) {
                int index = random.nextInt(alphabet.length());
                char randomChar = alphabet.charAt(index);
                sb.append(randomChar);
            }

            String randomString = sb.toString();

            new SendEmail().send("tzyelissa90@gmail.com","doordie16",userToReset.getEmail(),
                    "Spiral Verification Code","verification code: "+randomString);

            ResponseStatus responseStatus = new ResponseStatus(200,"VERIFICATION CODE SENT","Enter verification email set via your email");
            responseStatus.setObject((Object)randomString);

            return responseStatus;
        }
    }

    public ResponseStatus resetPasswordSecondStep(User userUpdated)throws Exception{
        Connection con = new CloudStorageConnectionHandler().getConnection();
        String securePassword = hashPassword(userUpdated.getPassword());

            PreparedStatement updateSql=con.prepareStatement("Update users_table SET password=? where email=?");
            updateSql.setString(1,securePassword);
            updateSql.setString(2,userUpdated.getPassword());
            int PassUpdate=updateSql.executeUpdate();
            if (PassUpdate>0){
                System.out.println("Password reset successful");
            }

            return new ResponseStatus(200,"DONE PASSWORD RESET","Password is reset successfully");
    }
}
