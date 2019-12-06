
package com.testpack.cleanarchitecture.Data;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HotelComment {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("comment")
    @Expose
    private String comment;
    @SerializedName("user")
    @Expose
    private String user;
    @SerializedName("timestamp")
    @Expose
    private Long timestamp;
    @SerializedName("replies")
    @Expose
    private List<Object> replies = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public List<Object> getReplies() {
        return replies;
    }

    public void setReplies(List<Object> replies) {
        this.replies = replies;
    }

}
