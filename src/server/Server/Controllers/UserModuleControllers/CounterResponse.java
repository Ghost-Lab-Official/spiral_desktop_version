package server.Server.Controllers.UserModuleControllers;

import java.io.Serializable;

public class CounterResponse implements Serializable {
    private Integer number;

    public CounterResponse(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
