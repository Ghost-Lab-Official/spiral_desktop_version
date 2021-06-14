package server.Server.Controllers.UserModuleControllers;

/**
 * @author : Ineza Aimee Annabelle
 * @description: This is user category actions controller
 */

<<<<<<< HEAD
import server.Server.DbController.CloudStorageConnectionHandler;
import server.Server.Model.RequestBody;
import server.Server.Model.ResponseStatus;
import server.Server.Model.SpotCategory;
=======


import server.Server.Model.RequestBody;
import server.Server.Model.ResponseStatus;
>>>>>>> d3cbee5dde6691de8ab652e5c49bd56983c38f24
import server.Server.Model.UserCategory;

import java.util.ArrayList;
import java.util.List;

public class UserCategoryController {
    public List<Object> mainMethod(RequestBody requestBody)throws Exception{
        String action = requestBody.getAction();
        List<Object> usersObject = new ArrayList<>();
        switch (action){
            case "register":
                ResponseStatus responseStatus = new UserCategoryActions().createUserCategory((UserCategory) requestBody.getObject());
                usersObject.add((Object) responseStatus);
                return  usersObject;

            case "getUserCategories":
                usersObject = new UserCategoryActions().selectCategories();
                return  usersObject;
            case "updateUserCategory":
                ResponseStatus responseStatus2 = new UserCategoryActions().updateCategory((UserCategory) requestBody.getObject());
                usersObject.add((Object) responseStatus2);
                return usersObject;
            case "deleteUserCategory":
                ResponseStatus responseStatus3 = new UserCategoryActions().deleteUserCategory((UserCategory) requestBody.getObject());
                usersObject.add((Object) responseStatus3);
                return usersObject;
            case "selectCategoryById":
                usersObject = new UserCategoryActions().selectCategoriesById((UserCategory) requestBody.getObject());
                return  usersObject;
        }

        return null;
    }
}
