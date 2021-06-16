package server.Server.Model;

import java.io.Serializable;

/*
        @author : Nimuhire Ange Constance
        @Description: the model for the SpotCategory class
 */
public class SpotCategory implements Serializable {
    private Integer categoryId;
    private Integer userId;
    private String categoryName;
    private String description;
    private String status;

    public SpotCategory() {
    }


    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public SpotCategory(Integer categoryId, Integer userId, String categoryName, String description, String status) {
        this.categoryId = categoryId;
        this.userId = userId;
        this.categoryName = categoryName;
        this.description = description;
        this.status = status;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
