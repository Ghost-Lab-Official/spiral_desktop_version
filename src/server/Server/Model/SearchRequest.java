package server.Server.Model;

import java.io.Serializable;

public class SearchRequest implements Serializable {
    private Integer searchId;
    private String category;

    public SearchRequest() {

    }

    public SearchRequest(Integer searchId, String category) {
        this.searchId = searchId;
        this.category = category;
    }

    public Integer getSearchId() {
        return searchId;
    }

    public void setSearchId(Integer searchId) {
        this.searchId = searchId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}