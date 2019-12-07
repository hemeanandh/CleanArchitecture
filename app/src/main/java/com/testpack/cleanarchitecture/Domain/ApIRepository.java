package com.testpack.cleanarchitecture.Data;

import java.util.List;

import androidx.lifecycle.LiveData;
import retrofit2.Call;

public interface ApIRepository {

    public void getHotelDetail(APICallback<HotelDetails> apiCallback);

    public LiveData<List<HotelComment>> getHotelComments(APICallback apiCallback);
}
