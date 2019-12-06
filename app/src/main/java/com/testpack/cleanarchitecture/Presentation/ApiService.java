package com.testpack.cleanarchitecture.Presentation;

import com.testpack.cleanarchitecture.Data.HotelComment;
import com.testpack.cleanarchitecture.Data.HotelDetails;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("api/workshop/hotel/")
    Call<HotelDetails> getHotelDetails();

    @GET("api/workshop/comments/")
    Call<List<HotelComment>> getHotelComments();
}
