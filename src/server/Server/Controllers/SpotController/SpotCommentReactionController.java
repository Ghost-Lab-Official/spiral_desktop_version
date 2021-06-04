package server.Server.Controllers.SpotController;

import server.Server.DbController.CloudStorageConnectionHandler;
import server.Server.Model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Spot Comment Reaction This is a class for handling Spot Reviews (comments) reactions actions
 *
 * @author ntwari egide
 *
 */
public class SpotCommentReactionController {
    public List<Object> mainMethod(RequestBody requestBody)throws Exception{
        String action = requestBody.getAction();
        List<Object> usersObject = new ArrayList<>();
        switch (action){
            case "register":
                ResponseStatus registeredStatus = new SpotCommentReactActions().addCommentReaction((CommentReactions) requestBody.getObject());
                usersObject.add((Object) registeredStatus);
                return  usersObject;

            case "update":
                ResponseStatus updatedStatus = new SpotCommentActions().updateComment((Comment) requestBody.getObject());
                usersObject.add((Object) updatedStatus);
                return  usersObject;

            case "reply-comment":
                ResponseStatus replyStatus = new SpotCommentActions().makeCommentReply((Comment) requestBody.getObject());
                usersObject.add((Object) replyStatus);
                return  usersObject;

            case "update-status":
                ResponseStatus updatedCommentStatus = new SpotCommentActions().updateCommentStatus((Comment) requestBody.getObject());
                usersObject.add((Object) updatedCommentStatus);

                return  usersObject;

            case "getCommentReactions":
                List<CommentReactions> commentReactionsList = new SpotCommentReactActions().GetCommentReactions((String) requestBody.getObject());
                for (CommentReactions commentReaction:commentReactionsList){
                    usersObject.add((Object) commentReaction);
                }

                return  usersObject;
            default:
                return usersObject;
        }
    }

}
