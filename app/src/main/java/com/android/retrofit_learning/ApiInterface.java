package com.android.retrofit_learning;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface ApiInterface{
    @GET("api.php")
    Call<DataClass> getResponse(
            @Query("amount") int amount,
            @Query("category") String category,
            @Query("difficulty") String difficulty,
            @Query("type") String type
    );

}