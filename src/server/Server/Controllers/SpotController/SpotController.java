package server.Server.Controllers.SpotController;

import server.Server.Controllers.SpotCategoryControllers.SpotCategoryActions;
import server.Server.DbController.CloudStorageConnectionHandler;
import server.Server.Model.RequestBody;
import server.Server.Model.ResponseStatus;
import server.Server.Model.Spot;
import server.Server.Model.SpotCategory;

import java.util.ArrayList;
import java.util.List;

/**
 *  @author : ntwari Egide
 *  @description: handler controller for the spot actions
 */

public class SpotController {
    public  List<Object> mainSpotController(RequestBody requestBody)throws Exception{
        String action = requestBody.getAction();
        List<Object> usersObject = new ArrayList<>();
        switch (action){
            case "register":
                ResponseStatus registeredStatus = new SpotActions().createSpotInDb((Spot) requestBody.getObject());
                usersObject.add((Object) registeredStatus);
                return  usersObject;

            case "update":
                ResponseStatus updatedStatus = new SpotActions().updateTheSpot((Spot) requestBody.getObject());
                usersObject.add((Object) updatedStatus);
                return  usersObject;

            case "delete":
                ResponseStatus deleteStatus = new SpotActions().deleteSpot((Spot) requestBody.getObject());
                usersObject.add((Object) deleteStatus);
                return  usersObject;

            case "updateStatus":
                ResponseStatus updatedSpotStatus = new SpotCategoryActions().updateStatus((SpotCategory) requestBody.getObject());
                usersObject.add((Object) updatedSpotStatus);

                return  usersObject;

            default:
                return usersObject;
        }
    }
}
