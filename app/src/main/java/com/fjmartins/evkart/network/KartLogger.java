package com.fjmartins.evkart.network;

import com.fjmartins.evkart.model.KartLoggerResponse;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class KartLogger implements KartLoggerAPI {

    private static final String URL = "https://ptcs.ev-kart-gogo.com/";
    private static KartLogger logger;
    private KartLoggerAPI api;

    public static KartLogger getInstance() {
        if (logger == null) logger = new KartLogger();
        return logger;
    }

    private KartLogger() {
        api = new Retrofit.Builder()
                .baseUrl(URL)
                .client(new OkHttpClient.Builder().build())
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(KartLoggerAPI.class);
    }

    @Override
    public Observable<KartLoggerResponse> insertDrivingLog(RequestBody body) {
        return api.insertDrivingLog(body)
                .subscribeOn(Schedulers.io());
    }
}
