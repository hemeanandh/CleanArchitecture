package com.testpack.cleanarchitecture.Domain;

import com.google.gson.Gson;
import com.testpack.cleanarchitecture.Data.APICallback;
import com.testpack.cleanarchitecture.Data.HotelComment;
import com.testpack.cleanarchitecture.Data.HotelDetails;
import com.testpack.cleanarchitecture.Presentation.ApiService;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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

    public void getHotelDetails(final APICallback apiCallback) {

//        final MutableLiveData<HotelDetails> mutableLiveData = new MutableLiveData<HotelDetails>();
         apiService.getHotelDetails().enqueue(new Callback<HotelDetails>() {
            @Override
            public void onResponse(Call<HotelDetails> call, Response<HotelDetails> response) {
                apiCallback.onSuccess(response.body());

            }

            @Override
            public void onFailure(Call<HotelDetails> call, Throwable t) {
                apiCallback.onError(null);
            }
        });

    }


    public LiveData<List<HotelComment>> getHotelComments(final APICallback<List<HotelComment>> apiCallback) {

        final MutableLiveData<List<HotelComment>> mutableLiveData = new MutableLiveData<List<HotelComment>>();
         apiService.getHotelComments().enqueue(new Callback<List<HotelComment>>() {
            @Override
            public void onResponse(Call<List<HotelComment>> call, Response<List<HotelComment>> response) {
               apiCallback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<HotelComment>> call, Throwable t) {
                apiCallback.onError("error");
            }
        });

        return mutableLiveData;
    }


}
