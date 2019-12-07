package com.testpack.cleanarchitecture.Presentation;

import com.testpack.cleanarchitecture.Data.APICallback;
import com.testpack.cleanarchitecture.Domain.ApIRepository;
import com.testpack.cleanarchitecture.Data.HotelComment;
import com.testpack.cleanarchitecture.Data.APIRepositoryImpl;
import com.testpack.cleanarchitecture.Data.HotelDetails;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HotelViewModel extends ViewModel {

    ApIRepository apiRepository;
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

    public void getHotelDetailsFromApi() {

        apiRepository.getHotelDetail(new APICallback<HotelDetails>() {
            @Override
            public void onSuccess(HotelDetails hotelDetails) {
                hotelDetailsLiveData.postValue(hotelDetails);
            }

            @Override
            public void onError(String error) {

            }
        });
    }

    public void getHotelCommentsFromApi() {
        apiRepository.getHotelComments(new APICallback<List<HotelComment>>() {
            @Override
            public void onSuccess(List<HotelComment> hotelCommentList) {
                List<HotelComment> hotelComments =  hotelCommentsMutableLiveData.getValue();
                hotelCommentList.addAll(hotelComments);
                hotelCommentsMutableLiveData.postValue(hotelComments);
            }

            @Override
            public void onError(String error) {

            }
        });
    }

    public void updateComments(HotelComment hotelComment) {
        List<HotelComment> hotelComments = hotelCommentsMutableLiveData.getValue();
        hotelComments.add(hotelComment);
        hotelCommentsMutableLiveData.setValue(hotelComments);
//        hotelCommentsMutableLiveData.postValue(hotelComments);

    }

    public void getUpdatedComments() {
        List<HotelComment> hotelCommentsList = hotelCommentsMutableLiveData.getValue();
        List<HotelComment> hotelComments =  hotelCommentsMutableLiveData.getValue();
        hotelCommentsList.addAll(hotelComments);
        hotelCommentsMutableLiveData.postValue(hotelComments);
    }
}
