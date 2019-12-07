package com.testpack.cleanarchitecture.Domain;

import com.testpack.cleanarchitecture.Data.APICallback;
import com.testpack.cleanarchitecture.Data.HotelComment;
import com.testpack.cleanarchitecture.Data.HotelDetails;

import java.util.List;

import androidx.lifecycle.LiveData;
import retrofit2.Call;

public interface ApIRepository {

    public void getHotelDetail(APICallback<HotelDetails> apiCallback);

    public LiveData<List<HotelComment>> getHotelComments(APICallback<List<HotelComment>> apiCallback);
}
