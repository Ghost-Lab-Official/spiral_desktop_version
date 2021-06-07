package server.Server.Model;

import java.io.Serializable;

public class Billing implements Serializable {
    private Integer billing_id ;
    private String billing_name;
    private Integer price;
    private Integer billing_period;
    private String billing_status ;

    public Integer getBilling_period() {
        return billing_period;
    }

    public void setBilling_period(Integer billing_period) {
        this.billing_period = billing_period;
    }

    public String getBilling_status() {
        return billing_status;
    }

    public void setBilling_status(String billing_status) {
        this.billing_status = billing_status;
    }

    public Billing(){}

    public Integer getBilling_id() {
        return billing_id;
    }

    public void setBilling_id(Integer billing_id) {
        this.billing_id = billing_id;
    }

    public String getBilling_name() {
        return billing_name;
    }

    public void setBilling_name(String billing_name) {
        this.billing_name = billing_name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
