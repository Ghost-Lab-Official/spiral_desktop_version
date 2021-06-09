package server.Server.Controllers.SpotCategoryControllers;
import server.Server.DbController.CloudStorageConnectionHandler;
import server.Server.Model.RequestBody;
import server.Server.Model.ResponseStatus;
import server.Server.Model.SpotCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : NTWARI Egide
 * @Description: spot category controller for synchronizing the spot methods
 */

public class SpotCategoryController {
    public List<Object> mainMethod(RequestBody requestBody)throws Exception{
        String action = requestBody.getAction();
        List<Object> usersObject = new ArrayList<>();
        switch (action){
            case "register":
                ResponseStatus registeredStatus = new SpotCategoryActions().addNewSpotCategory((SpotCategory) requestBody.getObject());
                usersObject.add((Object) registeredStatus);
                return  usersObject;

            case "update":
                ResponseStatus loggedInStatus = new SpotCategoryActions().updateSpotCategory((SpotCategory) requestBody.getObject());
                usersObject.add((Object) loggedInStatus);
                return  usersObject;

            case "getAll":
                List<SpotCategory> spotCategoryList = new SpotCategoryActions().getAllSpotCategories();
                for (SpotCategory spotCategory:spotCategoryList){
                    usersObject.add((Object) spotCategory);
                }

                return  usersObject;

            case "updateStatus":
                ResponseStatus updatedStatus = new SpotCategoryActions().updateStatus((SpotCategory) requestBody.getObject());
                usersObject.add((Object) updatedStatus);

                return  usersObject;

            default:
                return usersObject;
        }
    }
}
