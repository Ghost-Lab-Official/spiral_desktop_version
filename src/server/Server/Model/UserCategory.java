package server.Server.Model;

import java.io.Serializable;

public class UserCategory implements Serializable {
    private int catId;
    private String catName;
    private String catStatus;
    public UserCategory() {
    }

    public UserCategory(int catId, String catName) {
        this.catId = catId;
        this.catName = catName;
    }

    public UserCategory(int catId, String catName, String catStatus) {
        this.catId = catId;
        this.catName = catName;
        this.catStatus = catStatus;
    }

    public String getCatStatus() {
        return catStatus;
    }

    public void setCatStatus(String catStatus) {
        this.catStatus = catStatus;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }


}
