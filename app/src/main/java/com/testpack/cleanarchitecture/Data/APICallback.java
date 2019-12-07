package com.testpack.cleanarchitecture.Data;

public interface APICallback<T> {

    public void onSuccess(T t);



    public void onError(String error);
}
