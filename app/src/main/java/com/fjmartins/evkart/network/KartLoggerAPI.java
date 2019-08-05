package com.fjmartins.evkart.network;

import com.fjmartins.evkart.model.KartLoggerResponse;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.POST;
import retrofit2.http.Body;

public interface KartLoggerAPI {

    @POST("EvKart/InsertDrivingLog/")
    Observable<KartLoggerResponse> insertDrivingLog(
            @Body RequestBody requestBody
    );
}