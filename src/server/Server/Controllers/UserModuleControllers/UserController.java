package server.Server.Controllers.UserModuleControllers;

import server.Server.DbController.CloudStorageConnectionHandler;
import server.Server.Model.*;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    public List<Object> mainMethod(RequestBody requestBody)throws Exception{
        String action = requestBody.getAction();
        List<Object> usersObject = new ArrayList<>();
        switch (action){
            case "register":
                ResponseStatus registeredStatus = new UsersActions().registerUserInDb((User) requestBody.getObject());
                usersObject.add((Object) registeredStatus);
                return  usersObject;

            case "login":
                ResponseStatus loggedInStatus = new UsersActions().loginUser((User) requestBody.getObject());
                usersObject.add((Object) loggedInStatus);
                return  usersObject;
            case "getUsers":
                usersObject = new UsersActions().selectUsers();
                return usersObject;
            case "getUserById":
                usersObject = new UsersActions().selectUserById((User) requestBody.getObject());
                return usersObject;
            case "update-user-settings":
                ResponseStatus updatedStatus = new UsersActions().updateUserSettings((User) requestBody.getObject());
                usersObject.add((Object) updatedStatus);
                return usersObject;
            case "view-user-profile":
                 usersObject = new UsersActions().ViewUserProfile((User) requestBody.getObject());
                return usersObject;
            case "deleteUser":
                ResponseStatus deleteStatus = new UsersActions().deleteProfile((User) requestBody.getObject());
                usersObject.add((Object) deleteStatus);
                return usersObject;
            case "reset-password":
                ResponseStatus resetStatus = new UsersActions().resetPasswordFirstStep((User) requestBody.getObject());
                usersObject.add((Object) resetStatus);
                return usersObject;
            case "reset-password-second":
                ResponseStatus resetStatus1 = new UsersActions().resetPasswordSecondStep((User) requestBody.getObject());
                usersObject.add((Object) resetStatus1);
                return usersObject;
            default:
                return (List<Object>) new ResponseStatus(500,"SERVER ERROR","Sever failer");
        }
    }
}
