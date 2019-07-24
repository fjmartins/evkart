package com.fjmartins.evkart.model;

import com.squareup.moshi.Json;

public class LogRequest {

    @Json(name = "param")
    public Log param;

    public LogRequest(Log log) {
        param = log;
    }
}
