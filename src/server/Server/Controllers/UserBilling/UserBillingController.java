package server.Server.Controllers.UserBilling;

import server.Server.Model.RequestBody;
import server.Server.Model.ResponseStatus;
import server.Server.Model.UserBilling;
import server.Server.Model.UserBillingServices;

import java.util.ArrayList;
import java.util.List;

public class UserBillingController {

    public List<Object> mainMethod(RequestBody requestBody) throws Exception{
        String action = requestBody.getAction();
        List<Object> billProcess = new ArrayList<>();

        switch (action){
            case "pay":
                ResponseStatus responseStatus = new UserBillingActions().payBilling((UserBilling) requestBody.getObject());
                billProcess.add((Object) responseStatus);
                return billProcess;

            case "checkUserPlan":
                ResponseStatus checkResponseStatus = new UserBillingActions().checkUserBillingStatus((UserBillingServices) requestBody.getObject());
                billProcess.add((Object) checkResponseStatus);
                return billProcess;

            case "userPlanInfo":
                billProcess = new UserBillingActions().getUserPlan((UserBilling) requestBody.getObject());
                return billProcess;

        }
        return null;
    }



}
