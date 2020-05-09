package com.panshuljindal.retrofitdemo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL="https://rentbaaz.herokuapp.com/";
    @GET("adgMarvel")
    Call <List<RetroPhoto>> getRetroPhoto();
}
