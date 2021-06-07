package server.Server.Model;

import java.io.Serializable;
import java.util.List;
/*

 @author : Ntwari Egide - Scrum Master
 @author : Ishimwe Gervais

 */

public class ResponseBody implements Serializable {
    private List<Object> response;

    public List<Object> getResponse() {
        return response;
    }

    public ResponseBody(List<Object> response) {
        this.response = response;
    }

    public void setResponse(List<Object> response) {
        this.response = response;
    }
}
