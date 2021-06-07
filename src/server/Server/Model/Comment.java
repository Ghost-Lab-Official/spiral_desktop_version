package server.Server.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * Comment.java This is a class for handling Spot Reviews (comments)
 * @author Cedric Izabayo
 */

public class Comment implements Serializable {

    private String comment_id;
    private Integer spotId;
    private Integer userId;
    private Integer replyId;
    private String content;
    private String status;
    private Date created_at;
    private Date updatedAt;

    public Comment() {
    }


    public Comment(String content, Integer userId) {
        this.content=content;
        this.userId=userId;
    }

    public Comment(String comment_id, Integer spotId, Integer userId, Integer replyId, String content, String status, Date created_at, Date updatedAt) {
        this.comment_id = comment_id;
        this.spotId = spotId;
        this.userId = userId;
        this.replyId = replyId;
        this.content = content;
        this.status = status;
        this.created_at = created_at;
        this.updatedAt = updatedAt;
    }

    public String getComment_id() {
        return comment_id;
    }

    public void setComment_id(String comment_id) {
        this.comment_id = comment_id;
    }

    public Integer getSpotId() {
        return spotId;
    }

    public void setSpotId(Integer spotId) {
        this.spotId = spotId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}