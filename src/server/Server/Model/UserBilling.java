package server.Server.Model;

import java.io.Serializable;

public class UserBilling implements Serializable {
    private Integer user_id;
    private Integer plan_id;

    public UserBilling(Integer user_id, Integer plan_id) {
        this.user_id = user_id;
        this.plan_id = plan_id;
    }

    public UserBilling() {

    }


    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(Integer plan_id) {
        this.plan_id = plan_id;
    }
}
