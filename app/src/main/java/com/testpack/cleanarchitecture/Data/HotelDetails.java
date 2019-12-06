
package com.testpack.cleanarchitecture.Data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HotelDetails implements Parcelable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("rating")
    @Expose
    private Double rating;
    @SerializedName("numberOfReviews")
    @Expose
    private Integer numberOfReviews;
    @SerializedName("cost")
    @Expose
    private Integer cost;
    public final static Creator<HotelDetails> CREATOR = new Creator<HotelDetails>() {


        @SuppressWarnings({
            "unchecked"
        })
        public HotelDetails createFromParcel(Parcel in) {
            return new HotelDetails(in);
        }

        public HotelDetails[] newArray(int size) {
            return (new HotelDetails[size]);
        }

    }
    ;

    protected HotelDetails(Parcel in) {
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.location = ((String) in.readValue((String.class.getClassLoader())));
        this.rating = ((Double) in.readValue((Double.class.getClassLoader())));
        this.numberOfReviews = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.cost = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public HotelDetails() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getNumberOfReviews() {
        return numberOfReviews;
    }

    public void setNumberOfReviews(Integer numberOfReviews) {
        this.numberOfReviews = numberOfReviews;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(description);
        dest.writeValue(location);
        dest.writeValue(rating);
        dest.writeValue(numberOfReviews);
        dest.writeValue(cost);
    }

    public int describeContents() {
        return  0;
    }

}
