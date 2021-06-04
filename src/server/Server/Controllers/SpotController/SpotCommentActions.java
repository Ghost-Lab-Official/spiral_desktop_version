package server.Server.Controllers.SpotController;


import server.Server.DbController.CloudStorageConnectionHandler;
import server.Server.Model.Comment;
import server.Server.Model.ResponseStatus;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpotCommentActions {

  String GetCommentQuery = "Select * FROM comments WHERE spot_id=?";

  String GetCommentReplyQuery = "Select * FROM comments WHERE reply_id=?";

  String InsertCommentQuery =
    "INSERT INTO comments (comment_id, spot_id, user_id, content, created_at, updated_at) VALUES(?,?,?,?,?,?)";
  String InsertCommentReplyQuery =
    "INSERT INTO comments (comment_id, spot_id, user_id, reply_id, content, created_at, updated_at) VALUES(?,?,?,?,?,?,?)";
  String UpdateCommentQuery =
    "UPDATE comments  SET spot_id=?, user_id=?, content=?, updated_at=? WHERE comment_id=?";
  String UpdateCommentStatusQuery =
    "UPDATE comments  SET status=?, updated_at=? WHERE comment_id=?";

  /**
   * @author : Izabayo Cedric
   * @description: This method is used to get comments of a spot
   * @param spotId
   * @return
   * @throws Exception
   */
  public List<Comment> GetComments(Integer spotId) throws Exception {
    System.out.println(spotId);
    List<Comment> commentsList = new ArrayList<>();
    Connection connection = new CloudStorageConnectionHandler().getConnection();
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(
        GetCommentQuery
      );
      preparedStatement.setInt(1, spotId);
      ResultSet result = preparedStatement.executeQuery();

      while (result.next()) {
        System.out.println(result.getString("content"));
        Comment comment = new Comment();
        comment.setComment_id(result.getString("comment_id"));
        comment.setSpotId(result.getInt("spot_id"));
        comment.setUserId(result.getInt("user_id"));
        comment.setStatus(result.getString("status"));
        comment.setContent(result.getString("content"));
        comment.setCreated_at(result.getDate("created_at"));
        comment.setUpdatedAt(result.getDate("updated_at"));

        commentsList.add(comment);
      }
      return commentsList;
    } catch (Exception e) {
      return commentsList;
    }
  }

  /**
   * @author : Izabayo Cedric
   *  @description: This method is used to get replies of a spot comment
   * @param CommentId
   * @return
   * @throws Exception
   */
  public List<Comment> GetCommentReplies(String CommentId) throws Exception {
    List<Comment> commentsList = new ArrayList<>();
    Connection connection = new CloudStorageConnectionHandler().getConnection();
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(
              GetCommentReplyQuery
      );
      preparedStatement.setString(1, CommentId);
      ResultSet result = preparedStatement.executeQuery();

      while (result.next()) {
        Comment comment = new Comment();
        comment.setComment_id(result.getString("comment_id"));
        comment.setSpotId(result.getInt("spot_id"));
        comment.setUserId(result.getInt("user_id"));
        comment.setStatus(result.getString("status"));
        comment.setContent(result.getString("content"));
        comment.setReplyId(result.getInt("reply_id"));
        comment.setCreated_at(new Date(result.getString("created_at")));
        comment.setUpdatedAt(new Date(result.getString("updated_at")));

        commentsList.add(comment);
      }

      return commentsList;
    } catch (Exception e) {
      return commentsList;
    }
  }

  /**
   * @author : Izabayo Cedric
   * @description: This method is used to insert a new comment
   * @param comment
   * @return
   * @throws Exception
   */
  public ResponseStatus insertComment(Comment comment) throws Exception {
    Connection connection = new CloudStorageConnectionHandler().getConnection();
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(
        InsertCommentQuery
      );
      preparedStatement.setString(1, comment.getComment_id().toString());
      preparedStatement.setString(2, comment.getSpotId().toString());
      preparedStatement.setString(3, comment.getUserId().toString());
      preparedStatement.setString(4, comment.getContent());
      preparedStatement.setString(5, toDateTime(comment.getCreated_at()));
      preparedStatement.setString(6, toDateTime(comment.getUpdatedAt()));
      int inserted = preparedStatement.executeUpdate();

      if (inserted == 1) {
        return new ResponseStatus(
          200,
          "COMMENT ADDED",
          "you have commented on the spot"
        );
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

  /**
   * @author : Izabayo Cedric
   * @description: This method is used to update a comment
   * @param comment
   * @return
   * @throws Exception
   */
  public ResponseStatus updateComment(Comment comment) throws Exception {
    Connection connection = new CloudStorageConnectionHandler().getConnection();
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(
        UpdateCommentQuery
      );
      preparedStatement.setString(1, comment.getSpotId().toString());
      preparedStatement.setString(2, comment.getUserId().toString());
      preparedStatement.setString(3, comment.getContent());
      preparedStatement.setString(4, toDateTime(comment.getUpdatedAt()));
      preparedStatement.setString(5, comment.getComment_id().toString());
      preparedStatement.execute();

      int updated = preparedStatement.executeUpdate();

      if (updated == 1) {
        return new ResponseStatus(
          200,
          "COMMENT UPDATED",
          "you have updated commented on the spot"
        );
      }
    } catch (Exception e) {
      return new ResponseStatus(500, "EXCEPTION ERROR", e.getMessage());
    }

    return null;
  }

  /**
   *  @author : Izabayo Cedric
   *  @description: This method is used to insert a new commentReply
   * @param comment
   * @return
   * @throws Exception
   */
  public ResponseStatus makeCommentReply(Comment comment) throws Exception {
    Connection connection = new CloudStorageConnectionHandler().getConnection();
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(
        InsertCommentReplyQuery
      );
      preparedStatement.setString(1, comment.getComment_id().toString());
      preparedStatement.setString(2, comment.getSpotId().toString());
      preparedStatement.setString(3, comment.getUserId().toString());
      preparedStatement.setString(4, comment.getReplyId().toString());
      preparedStatement.setString(5, comment.getContent());
      preparedStatement.setString(6, toDateTime(comment.getCreated_at()));
      preparedStatement.setString(7, toDateTime(comment.getUpdatedAt()));
      preparedStatement.execute();

      int insertedReply = preparedStatement.executeUpdate();

      if (insertedReply == 1) {
        return new ResponseStatus(
          200,
          "REPLY ADDED",
          "you have replayed commented on the spot"
        );
      }
    } catch (Exception e) {
      return new ResponseStatus(500, "EXCEPTION ERROR", e.getMessage());
    }

    return null;
  }

  /**
   * @author : Izabayo Cedric
   * @description: This method is used to change a comment's status
   * @param comment
   * @return
   * @throws Exception
   */
  public ResponseStatus updateCommentStatus(Comment comment) throws Exception {
    Connection connection = new CloudStorageConnectionHandler().getConnection();
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(
        UpdateCommentStatusQuery
      );
      preparedStatement.setString(1, comment.getStatus());
      preparedStatement.setString(2, toDateTime(new Date()));
      preparedStatement.setString(3, comment.getComment_id().toString());
      preparedStatement.execute();

      int updated = preparedStatement.executeUpdate();

      if (updated == 1) {
        return new ResponseStatus(
          200,
          "COMMENT UPDATED",
          "you have changed status of the spot comment"
        );
      }
    } catch (Exception e) {
      return new ResponseStatus(500, "EXCEPTION ERROR", e.getMessage());
    }

    return null;
  }
}
