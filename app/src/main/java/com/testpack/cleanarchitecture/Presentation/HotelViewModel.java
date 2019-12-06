package com.testpack.cleanarchitecture.Presentation;

import android.app.Application;

import com.testpack.cleanarchitecture.Data.HotelComment;
import com.testpack.cleanarchitecture.Domain.APIRepositoryImpl;
import com.testpack.cleanarchitecture.Data.HotelDetails;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HotelViewModel extends ViewModel {

    APIRepositoryImpl apiRepository;
    private MutableLiveData<HotelDetails> hotelDetailsLiveData = new MutableLiveData <HotelDetails>() ;
    private MutableLiveData<List<HotelComment>> hotelCommentsMutableLiveData = new MutableLiveData<List<HotelComment>>();

    public HotelViewModel() {
       apiRepository = new APIRepositoryImpl();
    }
    public MutableLiveData<HotelDetails> getHotelDetailsLiveData() {
        return hotelDetailsLiveData;
    }

    public MutableLiveData<List<HotelComment>> getHotelCommentsLiveData() {
        return hotelCommentsMutableLiveData;
    }

    public void getHotelDetailsFromApi(Application application) {

        apiRepository.getHotelDetail().enqueue(new Callback<HotelDetails>() {
            @Override
            public void onResponse(Call<HotelDetails> call, Response<HotelDetails> response) {
                hotelDetailsLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<HotelDetails> call, Throwable t) {

            }
        });
    }

    public void getHotelCommentsFromApi() {
        apiRepository.getHotelComments().enqueue(new Callback<List<HotelComment>>() {
            @Override
            public void onResponse(Call<List<HotelComment>> call, Response<List<HotelComment>> response) {
                hotelCommentsMutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<HotelComment>> call, Throwable t) {
                System.out.println("response"+call);
            }
        });
    }
}
