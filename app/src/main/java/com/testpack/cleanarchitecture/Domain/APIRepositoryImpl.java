package com.testpack.cleanarchitecture.Domain;

import com.testpack.cleanarchitecture.Data.HotelComment;
import com.testpack.cleanarchitecture.Data.HotelDetails;
import com.testpack.cleanarchitecture.StaticData;

import java.util.List;

import retrofit2.Call;

public class APIRepositoryImpl {

    ApiDataSource apiDataSource;
    public APIRepositoryImpl() {
         apiDataSource = new ApiDataSource();
    }


    public Call<HotelDetails> getHotelDetail() {


        if(StaticData.hotelDetails != null) {

        } else {
            apiDataSource.getHotelDetails();
        }


    }

    public Call<List<HotelComment>> getHotelComments() {

        return apiDataSource.getHotelComments();

    }
}
