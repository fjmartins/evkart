package com.fjmartins.evkart.model;

import com.fjmartins.evkart.Constants;
import com.squareup.moshi.Json;

import java.util.Calendar;

public class Log {

    @Json(name = "rpm")
    public int rpm;
    @Json(name = "duty")
    public double onDuty;
    @Json(name = "thv")
    public double throttleVoltage;
    @Json(name = "volt")
    public double batteryVoltage;
    @Json(name = "ampere")
    public double batteryAmp;
    @Json(name = "sec")
    public String timeStamp;

    public Log() {
        this.timeStamp = Calendar.getInstance().getTime().toString();
    }

    public static Log fromString(String dataString) {
        Log log = new Log();

        for (String attribute : dataString.split(Constants.DATA_DIVIDER)) {
            String[] keyAndValue = attribute.trim().split(Constants.KEY_VALUE_DIVIDER);
            if (keyAndValue.length > 1) {
                log.setAttribute(keyAndValue[0].trim(), keyAndValue[1].trim());
            }
        }

        return log;
    }

    private void setAttribute(String key, String value) {
        if (value.isEmpty()) return;

        switch (key) {
            case "RPM(rpm)":
                this.rpm = Integer.parseInt(value);
                break;
            case "On Duty(%)":
                this.onDuty = Double.parseDouble(value);
                break;
            case "ThV(V)":
                this.throttleVoltage = Double.parseDouble(value);
                break;
            case "BV(V)":
                this.batteryVoltage = Double.parseDouble(value);
                break;
            case "BI(A)":
                this.batteryAmp = Double.parseDouble(value);
                break;
            default:
                break;
        }
    }
}
