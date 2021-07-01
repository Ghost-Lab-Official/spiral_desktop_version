package server.Server.Controllers.UserModuleControllers;

import java.util.ArrayList;
import java.util.List;
/**
 * @author : Ineza Aimee Annabelle
 * @description: This is user category actions controller
 */



import server.Server.Model.RequestBody;
import server.Server.Model.ResponseStatus;
import server.Server.Model.UserCategory;

public class UserCategoryController {

  public List<Object> mainMethod(RequestBody requestBody) throws Exception {
    String action = requestBody.getAction();
    List<Object> usersObject = new ArrayList<>();
    switch (action) {
      case "register":
        ResponseStatus responseStatus = new UserCategoryActions()
        .createUserCategory((UserCategory) requestBody.getObject());
        usersObject.add((Object) responseStatus);
        return usersObject;
      case "getUserCategories":
        usersObject = new UserCategoryActions().selectCategories();
        return usersObject;
      case "updateUserCategory":
        ResponseStatus responseStatus2 = new UserCategoryActions()
        .updateCategory((UserCategory) requestBody.getObject());
        usersObject.add((Object) responseStatus2);
        return usersObject;
      case "deleteUserCategory":
        ResponseStatus responseStatus3 = new UserCategoryActions()
        .deleteUserCategory((UserCategory) requestBody.getObject());
        usersObject.add((Object) responseStatus3);
        return usersObject;
      case "selectCategoryById":
        usersObject =
          new UserCategoryActions()
          .selectCategoriesById((UserCategory) requestBody.getObject());
        return usersObject;
    }

    return null;
  }
}
