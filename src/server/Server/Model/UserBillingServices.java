package server.Server.Model;

import java.io.Serializable;

public class UserBillingServices implements Serializable {

    private UserBilling userBilling;
    private String service;

    public UserBillingServices(){}

    public UserBillingServices(UserBilling userBilling, String service) {
        this.userBilling = userBilling;
        this.service = service;
    }

    public UserBilling getUserBilling() {
        return userBilling;
    }

    public void setUserBilling(UserBilling userBilling) {
        this.userBilling = userBilling;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
