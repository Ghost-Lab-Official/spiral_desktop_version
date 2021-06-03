package server.Server.Controllers.UserBilling;

import server.Server.DbController.*;
import server.Server.Model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserBillingActions {
    /**
     *  checkUserBilling payment status.
     * @param |UserBillingServices project having the UserBilling Object and the service to do,
     * The function returns the ResponseStatus
     * @author Gervais Ishimwe
     */



    public ResponseStatus checkUserBillingStatus(UserBillingServices userBillingServices)throws Exception{
        String query = "SELECT * FROM users_billing WHERE user_id = ?";
        String getPlan = "SELECT * FROM billing WHERE billing_id = ?";
        LocalDate date = LocalDate.now();
        try{
            Connection connection = new CloudStorageConnectionHandler().getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,userBillingServices.getUserBilling().getUser_id());

            ResultSet resultset = statement.executeQuery();
            String end_date = "";
            Integer plan_id = 0;
            while(resultset.next()){
                end_date = resultset.getString(5);
                plan_id = resultset.getInt(3);
            }

            if((date.toString()).compareTo(end_date)<0 ||(date.toString()).compareTo(end_date)==0){

                PreparedStatement planStatement = connection.prepareStatement(getPlan);
                planStatement.setInt(1,plan_id);
                ResultSet results1 = planStatement.executeQuery();
                String functionalities = "";
                while (results1.next()){
                    functionalities = results1.getString(6);
                }
                if(functionalities.contains(userBillingServices.getService())){
                    return new ResponseStatus(200,"AUTHORIZED","THIS USER IS AUTHORIZED");
                }
                else{
                    return new ResponseStatus(401,"NOT AUTHORIZED","PURCHASE A PLAN TO ACCESS THIS SERVICE");
                }


            }
            else {
                return new ResponseStatus(401,"NOT AUTHORIZED","PURCHASE A PLAN TO ACCESS THIS SERVICE");
            }
        }catch(Exception e){
            return new ResponseStatus(300,"EXCEPTION ERROR",e.getMessage());

        }
    }
 /**
     *  pay for a plan.
     * @param |UserBilling Object having user_id and plan id
     * The function returns the ResponseStatus
     * @author Gervais Ishimwe
     */

    public ResponseStatus payBilling(UserBilling userBilling)throws Exception{
        String query = "INSERT INTO users_billing(user_id,billing_id,end_date) VALUES (?,?,?)";
        LocalDate date = LocalDate.now();
        String getYearPeriods = "SELECT billing_period from billing WHERE billing_id = ?";
        try{
            Connection connection = new CloudStorageConnectionHandler().getConnection();
            PreparedStatement stat = connection.prepareStatement(getYearPeriods);
            stat.setInt(1,userBilling.getPlan_id());
            ResultSet resultset = stat.executeQuery();
            Integer periods = 0;
            while(resultset.next()){
                periods = resultset.getInt(1);
            }
//
            Integer day = date.getDayOfMonth();
            Integer month = (date.getMonthValue())+periods;
            Integer year = date.getYear();


            // Checking if the month of expiration won't exceed the 12 months of the year
            if(month>12){
                month = month-12;
                year = year+1;
            }

            String expirationDate = year.toString()+"-"+month.toString()+"-"+day.toString();


            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,userBilling.getPlan_id());
            statement.setInt(2,userBilling.getUser_id());
            statement.setString(3,expirationDate);

            int inserted_rec = statement.executeUpdate();
            if(inserted_rec == 1){
                return new ResponseStatus(200,"CREATED","PLAN PURCHASED SUCCESSFULLY");
            }
            if(connection != null){
                return  new ResponseStatus(500,"SERVER ERROR", "Payment failed. Try again or contact system administrator");
            }
        }catch(Exception e){
                return new ResponseStatus(300,"EXCEPTION ERROR",e.getMessage());
        }
        return new ResponseStatus(200,"CREATED","PLAN PURCHASED SUCCESSFULLY");

    }





    public List<Object> getUserPlan(UserBilling userBilling)throws Exception{
        String getBillingId  = "SELECT * FROM users_billing WHERE user_id = ?";
        List<Object> planInfo = new ArrayList<>();
        try{
            
            Connection connection = new CloudStorageConnectionHandler().getConnection();
            PreparedStatement statement = connection.prepareStatement(getBillingId);
            statement.setInt(1,userBilling.getUser_id());
            ResultSet resultSet = statement.executeQuery();
            Integer planId=null;
            while(resultSet.next()){
                planId = resultSet.getInt(3);
            }
            String getPlan = "SELECT * FROM billing WHERE billing_id = ?";
            PreparedStatement statement1 = connection.prepareStatement(getPlan);
            statement1.setInt(1,planId);

            ResultSet resultSet1 = statement1.executeQuery();
            while(resultSet1.next()){
                Billing billing = new Billing();

                billing.setBilling_name(resultSet1.getString(2));
                billing.setPrice(resultSet1.getInt(3));
                billing.setBilling_period(resultSet1.getInt(4));
                billing.setBilling_status(resultSet1.getString(5));

                planInfo.add(billing);
            }
            return planInfo;
        }catch (Exception e){
            planInfo.add(e);
        }

        return null;
    }
}
