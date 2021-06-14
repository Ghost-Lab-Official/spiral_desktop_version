package client.ClientMain;
<<<<<<< HEAD

import server.Server.Model.RequestBody;
import server.Server.Model.ResponseBody;

=======
import server.Server.Model.RequestBody;
import server.Server.Model.ResponseBody;
>>>>>>> d3cbee5dde6691de8ab652e5c49bd56983c38f24
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;
<<<<<<< HEAD

=======
>>>>>>> d3cbee5dde6691de8ab652e5c49bd56983c38f24
/**
 * @author : Ntwari Egide - Scrum Master
 * @author : Ishimwe Gervais
 */
<<<<<<< HEAD

=======
>>>>>>> d3cbee5dde6691de8ab652e5c49bd56983c38f24
public class ClientServerConnector {
    public ResponseBody ConnectToServer(RequestBody requestBody)throws Exception
    {
        // establish a connection by providing host and port
        // number
        try (Socket socket = new Socket("localhost", 1294)) {
<<<<<<< HEAD

            // writing to server
            ObjectOutputStream out = new ObjectOutputStream(
                    socket.getOutputStream());

            // reading from server
            ObjectInputStream in
                    = new ObjectInputStream(socket.getInputStream());

            String line = null;

=======
            // writing to server
            ObjectOutputStream out = new ObjectOutputStream(
                    socket.getOutputStream());
            // reading from server
            ObjectInputStream in
                    = new ObjectInputStream(socket.getInputStream());
            String line = null;
>>>>>>> d3cbee5dde6691de8ab652e5c49bd56983c38f24
                /*
                        SAMPLE OF THE REQUEST AND RESPONSE
                        ----------------------------------
                        user: /users
                        response : table of users
                        user: /users/1
                        response : user with id that id
                 */
<<<<<<< HEAD

            // sending the user input to server
            out.writeObject(requestBody);
            out.flush();

                // displaying server reply
                 List<Object> dataReturned = (List<Object>) in.readObject();


            ResponseBody responseBody = new ResponseBody(dataReturned);

            return responseBody;

=======
            // sending the user input to server
            out.writeObject(requestBody);
            out.flush();
            // displaying server reply
            List<Object> dataReturned = (List<Object>) in.readObject();
            ResponseBody responseBody = new ResponseBody(dataReturned);
            return responseBody;
>>>>>>> d3cbee5dde6691de8ab652e5c49bd56983c38f24
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}