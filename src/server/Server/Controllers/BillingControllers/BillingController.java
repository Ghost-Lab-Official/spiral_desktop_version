package server.Server.Controllers.BillingControllers;


import server.Server.Model.*;
import server.Server.Model.RequestBody;
import server.Server.Model.ResponseStatus;

import java.util.ArrayList;
import java.util.List;
/**
 *  Billing actions to do
 * @author Gervais Ishimwe


 */

public class BillingController {

    public List<Object> mainMethod(RequestBody requestBody)throws Exception{
        String action = requestBody.getAction();
        List<Object> plans = new ArrayList<>();

        switch (action){
            case "register":
                ResponseStatus responseStatus = new BilllingActions().registerBillPlan((Billing) requestBody.getObject());
                plans.add((Object) responseStatus);
                return plans;

            case "update":
                ResponseStatus updateResponse = new BilllingActions().updateBillingPlan((Billing) requestBody.getObject());
                plans.add((Object) updateResponse);
                return plans;

            case "selectAllBillingPlans":
                plans = new BilllingActions().getAllBillingPLan();
                return plans;

            case "selectBillingById":
                plans = new BilllingActions().getBillingPlanById((Billing) requestBody.getObject());
                return plans;

            case "actionOnStatus":
                ResponseStatus actionOnStatus = new BilllingActions().updateBillingPlanStatus((Billing) requestBody.getObject());
                plans.add((Object) actionOnStatus);
                return plans;
        }
        return  null;

    }


}
