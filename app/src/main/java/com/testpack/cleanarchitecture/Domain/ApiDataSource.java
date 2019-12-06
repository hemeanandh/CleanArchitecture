package com.testpack.cleanarchitecture.Domain;

import com.google.gson.Gson;
import com.testpack.cleanarchitecture.Data.HotelComment;
import com.testpack.cleanarchitecture.Data.HotelDetails;
import com.testpack.cleanarchitecture.Presentation.ApiService;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiDataSource implements AbstractDataSource{

    ApiService apiService;
    public ApiDataSource() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        apiService =new Retrofit.Builder()
                .baseUrl("https://hiringworkshop.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client).build().
                        create(ApiService.class);
    }

    public Call<HotelDetails> getHotelDetails() {

        return apiService.getHotelDetails();
    }


    public Call<List<HotelComment>> getHotelComments() {
        return apiService.getHotelComments();
    }


}
