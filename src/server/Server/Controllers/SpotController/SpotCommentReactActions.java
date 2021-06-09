package server.Server.Controllers.SpotController;
import server.Server.DbController.CloudStorageConnectionHandler;
import server.Server.Model.CommentReactions;
import server.Server.Model.ResponseStatus;
import server.Server.Model.SpotCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Spot Comment Reaction This is a class for Spot Reviews (comments) reactions actions
 *
 * @author ntwari egide
 *
 */
public class SpotCommentReactActions {
    private static final String SelectCommentReactionQuery =
            "SELECT * FROM comment_reactions WHERE comment_id=?";
    private static final String InsertCommentReactionQuery =
            "INSERT INTO comment_reactions (comment_reaction_id, comment_id, user_id, liked, created_at, updated_at) VALUES(?,?,?,?,?,?)";

    /*
              @author : Izabayo Cedric
              @description: This method is used to get comment reactions of a specific sotcomment
       */
    public List<CommentReactions> GetCommentReactions(String commentId) throws Exception {
        List<CommentReactions> commentReactionList = new ArrayList<>();
        Connection connection = new CloudStorageConnectionHandler().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    SelectCommentReactionQuery
            );
            preparedStatement.setString(1, commentId);
            ResultSet result = preparedStatement.executeQuery(SelectCommentReactionQuery);

            while (result.next()) {
                CommentReactions commentReaction = new CommentReactions();
                commentReaction.setComment_reaction_id(result.getString("comment_reaction_id"));
                commentReaction.setComment_id(result.getString("comment_id"));
                commentReaction.setUser_id( result.getString("user_id"));
                commentReaction.setLiked(result.getBoolean("liked"));
                commentReaction.setCreated_at(new Date(result.getString("created_at")));
                commentReaction.setUpdated_at(new Date(result.getString("updated_at")));

                commentReactionList.add(commentReaction);
            }

            return commentReactionList;
        } catch (Exception e) {
            return commentReactionList;
        }
    }

    public ResponseStatus addCommentReaction(CommentReactions commentReaction)throws Exception{
        Connection connection = new CloudStorageConnectionHandler().getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(InsertCommentReactionQuery);
            preparedStatement.setString(1, commentReaction.getComment_reaction_id());
            preparedStatement.setString(2, commentReaction.getComment_id());
            preparedStatement.setString(3, commentReaction.getUser_id());
            preparedStatement.setBoolean(4, commentReaction.getLiked());
            preparedStatement.setString(5, toDateTime(commentReaction.getCreated_at()));
            preparedStatement.setString(6, toDateTime(commentReaction.getUpdated_at()));

            int inserted = preparedStatement.executeUpdate();

            if (inserted == 1) {
                return new ResponseStatus(200, "REACTION ADDED", "you have added comment reaction on the spot");
            }
        } catch (Exception e) {
            return new ResponseStatus(500, "EXCEPTION ERROR", e.getMessage());
        }

        return null;
    }

    public static String toDateTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }
}
