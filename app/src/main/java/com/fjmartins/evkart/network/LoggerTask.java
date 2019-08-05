package com.fjmartins.evkart.network;

import android.os.AsyncTask;

import com.fjmartins.evkart.model.KartLoggerResponse;
import com.fjmartins.evkart.model.Log;
import com.google.gson.Gson;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class LoggerTask extends AsyncTask<Log, Void, Observable<KartLoggerResponse>> {
    @Override
    protected Observable<KartLoggerResponse> doInBackground(Log... logs) {
        String logString = new Gson().toJson(logs[0]);

        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("param", logString)
                .build();

        return KartLogger.getInstance().insertDrivingLog(requestBody);
    }

    @Override
    protected void onPostExecute(Observable<KartLoggerResponse> kartLoggerResponseObservable) {
        kartLoggerResponseObservable.subscribe(results -> {
            if(results.code.equals("0")) {
                // Success
            }
        }, throwable -> {
            System.out.println(throwable.getMessage());
        });
    }
}