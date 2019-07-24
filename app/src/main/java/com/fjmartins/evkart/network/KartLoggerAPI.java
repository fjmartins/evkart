package com.fjmartins.evkart.network;

import com.fjmartins.evkart.model.KartLoggerResponse;
import com.fjmartins.evkart.model.LogRequest;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface KartLoggerAPI {

    @POST("InsertDrivingLog")
    Observable<KartLoggerResponse> insertDrivingLog(
            @Body LogRequest log
    );
}