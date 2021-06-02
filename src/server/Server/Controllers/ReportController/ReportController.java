package server.Server.Controllers.ReportController;


import server.Server.Model.RequestBody;
import server.Server.Model.ResponseStatus;
import server.Server.Model.UserLog;

import java.util.ArrayList;
import java.util.List;

public class ReportController {
     /**
 * ReportController: This class is to controll every action that is done on our module. in this controller class is where cases or actions are switched to return the response 
 * regarding that kind of action. 
 * @author Best Verie Iradukunda
 *  @author Erneste Ntezirizaza
 */

    public List<Object> mainMethod(RequestBody request)throws Exception{
        String action = request.getAction();
        List<Object> userLogsReport = new ArrayList<>();
        List<Object> reportList = new ArrayList<>();

        switch (action){
            case "getUserLogs":
                return new UserLogsActions().getAllUserLogs();

            case "createUserLog":
                ResponseStatus userLogResponseStatus = new UserLogsActions().recordUserLogs((UserLog) request.getObject());
                userLogsReport.add((Object) userLogResponseStatus);
                return userLogsReport;
            case "getTotalNumberOfUsers":
                return new UsersReportActions().getTheTotalNumberOfAllUsersRegistered();

            case "getAllUsers":
                return new UsersReportActions().viewAllUsers();

            case "getAllActiveUsers":
                return new UsersReportActions().viewAllUsersByStatus("active");

            case "getAllInactiveUsers":
                return new UsersReportActions().viewAllUsersByStatus("inactive");

            case "getTotalNumberOfActiveUsers":
                return new UsersReportActions().getTheTotalNumberOfAllUsersByStatus("active");

            case "getTotalNumberOfInactiveUsers":
                return new UsersReportActions().getTheTotalNumberOfAllUsersByStatus("inactive");

            case "getAllLocations":
                return new LocationsReportsActions().viewAllLocations();


                //Spot Cases


            case "getTotalNumberOfRegisteredSpots":
                return new SpotReportsActions().getTheTotalNumbersOfRegisteredSpots();

            case "getTotalNumberOfActiveSpots":
                return new SpotReportsActions().getTheTotalNumberOfActiveSpots();

            case "getTotalNumberOfInactiveSpots":
                return new SpotReportsActions().getTheTotalNumberOfInactiveSpots();

            case "getTotalNumberOfTrendingSpots":
                return new SpotReportsActions().getTheTotalNumbersOfTrendingSpots();
            case "getAllSpots":
                return new SpotReportsActions().viewAllSpots();
            case "getAllActiveSpots":
                return new SpotReportsActions().viewAllActiveSpots();
            case "getAllTrendingSpots":
                return new SpotReportsActions().ViewHighlyVisitedSpots();
            case "getAllInactiveSpots":
                return new SpotReportsActions().viewAllInactiveSpots();

            case "getTheNumberOfAllRegisteredLocations":
                return new LocationsReportsActions().totalNumberOfRegisteredLocations();

            case "getTheNumberOfActiveLocations":
                return new LocationsReportsActions().totalNumberOfLocationsByStatus("active");

            case "getTheNumberOfInActiveLocations":
                return new LocationsReportsActions().totalNumberOfLocationsByStatus("inactive");

            case "viewAllActiveLocations":
                return new LocationsReportsActions().viewLocationsByStatus("active");

            case "viewAllInActiveLocations":
                return new LocationsReportsActions().viewLocationsByStatus("inactive");

            case "getSpotsByLocations":
                return new LocationsReportsActions().getSpotsByLocation((String) request.getObject());

            case "viewTodaysSpots":
                return new SpotReportsActions().viewTodaysSpots();
            case "viewTodaysTrendingSpots":
                return new SpotReportsActions().viewTodaysTrendingSpots();

            case "viewThisMonthsSpots":
                return new SpotReportsActions().viewThisMonthsSpots();
            case "viewThisMonthsTrendingSpots":
                return new SpotReportsActions().viewThisMonthsTrendingSpots();

            case "viewReportForAnotherDay":
                return new SpotReportsActions().getReportForAnotherDay((String) request.getObject());
            //                OTHER ACTIONS SHOULD GO HERE
//            --------------------------------------
        }

        return null;
    }
}