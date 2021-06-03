package server.Server.Model;

import java.io.Serializable;
/*

 @author : Ntwari Egide - Scrum Master
 @author : Ishimwe Gervais

 */

public class RequestBody implements Serializable {
    private String url; // /users
    private String action; //update
    private Object object; //{}

    public RequestBody(){}
    public RequestBody(String url, String action, Object object) {
        this.url = url;
        this.action = action;
        this.object = object;
    }
        /*
           /deleteUsers/1
           /updateUser/1

         */

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}