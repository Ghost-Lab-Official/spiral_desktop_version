package server.Server.Controllers.LocationControllers;


import server.Server.Model.*;
import server.Server.Model.RequestBody;
import server.Server.Model.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * Location actions  (Synchronizing the classes)
 * @author Gervais Ishimwe
 */
public class LocationController {

    public List<Object> mainMethod(RequestBody requestBody) throws Exception{
        String action = requestBody.getAction();
        List<Object> location = new ArrayList<>();

        switch (action){
            case "register":
                ResponseStatus registerLocation = new LocationActions().registerLocation((Location) requestBody.getObject());
                location.add((Object)registerLocation);
                return location;

            case "update":
                ResponseStatus updateLocation = new LocationActions().UpdateLocation((Location) requestBody.getObject());
                location.add((Object) updateLocation);
                return  location;

            case "delete":
                ResponseStatus deleteLocation = new LocationActions().DeleteLocation((Location) requestBody.getObject());
                location.add((Object) deleteLocation);
                return  location;
            case "recover":
                ResponseStatus recoverLocation = new LocationActions().RecoverLocation((Location) requestBody.getObject());
                location.add((Object) recoverLocation);
                return location;

            case "getLocationsByParent":
                List<Object> locations = new LocationActions().fetchByParent((String) requestBody.getObject());
                return locations;
        }
        return  null;
    }

}