package com.fjmartins.evkart.network;

import com.fjmartins.evkart.model.KartLoggerResponse;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface KartLoggerAPI {

    @POST("InsertDrivingLog")
    Observable<KartLoggerResponse> insertDrivingLog(
            @Query("address") String query,
            @Query("key") String apiKey
    );
}