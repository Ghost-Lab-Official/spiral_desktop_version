
/*
        @author : Manzi Gusave
        @Description: the model for the Spot Ratings class
 */

package server.Server.Model;

import java.io.Serializable;

public class SpotRatings implements Serializable {
    private Integer spotRatingId;
    private Integer user_id;
    private Integer spot_id;
    private Integer rating;

    public SpotRatings() {
    }

    public SpotRatings(Integer spotRatingId, Integer user_id, Integer spot_id, Integer rating) {
        this.spotRatingId = spotRatingId;
        this.user_id = user_id;
        this.spot_id = spot_id;
        this.rating = rating;
    }

    public Integer getSpotRatingId() {
        return spotRatingId;
    }

    public void setSpotRatingId(Integer spotRatingId) {
        this.spotRatingId = spotRatingId;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getSpot_id() {
        return spot_id;
    }

    public void setSpot_id(Integer spot_id) {
        this.spot_id = spot_id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}