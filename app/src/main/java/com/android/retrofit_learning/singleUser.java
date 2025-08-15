package com.android.retrofit_learning;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface singleUser{
    @GET("api.php")
    Call<DataClass> getUser(
            @Query("type") String type,
            @Query("difficulty") String difficulty,
            @Query("category") String category,
            @Query("amount") int amount
             );
}
