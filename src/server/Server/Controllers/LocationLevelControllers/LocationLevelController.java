package server.Server.Controllers.LocationLevelControllers;


import server.Server.Model.LocationLevels;
import server.Server.Model.RequestBody;
import server.Server.Model.ResponseStatus;

import java.util.ArrayList;
import java.util.List;
/**
 * Location levels (Synchronizing the classes)
 * @author Gervais Ishimwe
 */
public class LocationLevelController {
 public List<Object> mainMethod(RequestBody requestBody)throws Exception
 {
     String action = requestBody.getAction();
     List<Object> locationLevels = new ArrayList<>();
     switch (action){
         case "register":
         ResponseStatus registerLocationLevel = new LocationLevelsActions().registerLocationLevel((LocationLevels) requestBody.getObject());
         locationLevels.add((Object)registerLocationLevel);
         return locationLevels;

         case "update":
             break;
         case "get":
             break;

     }
     return null;
 }


}
