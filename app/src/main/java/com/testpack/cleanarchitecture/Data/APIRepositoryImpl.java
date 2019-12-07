package com.testpack.cleanarchitecture.Domain;

import com.testpack.cleanarchitecture.Data.APICallback;
import com.testpack.cleanarchitecture.Data.ApIRepository;
import com.testpack.cleanarchitecture.Data.HotelComment;
import com.testpack.cleanarchitecture.Data.HotelDetails;
import com.testpack.cleanarchitecture.StaticData;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;

public class APIRepositoryImpl implements ApIRepository {

    ApiDataSource apiDataSource;

    MutableLiveData<HotelDetails> hotelDetailsMutableLiveData = new MutableLiveData<HotelDetails>();
    MutableLiveData<List<HotelComment>> hotelCommentsLiveData = new MutableLiveData<List<HotelComment>>();
    public APIRepositoryImpl() {
         apiDataSource = new ApiDataSource();
    }


    public void getHotelDetail(APICallback<HotelDetails> apiCallback) {


//        if(StaticData.hotelDetails != null) {
//            apiCallback.onSuccess(StaticData.hotelDetails);
//        } else {
             apiDataSource.getHotelDetails(apiCallback);
//        }

//        return hotelDetailsMutableLiveData;

    }

    public LiveData<List<HotelComment>> getHotelComments(APICallback apiCallback) {

        if(StaticData.hotelDetails != null) {
        } else {
            return apiDataSource.getHotelComments();
        }

        return hotelCommentsLiveData;


    }
}
