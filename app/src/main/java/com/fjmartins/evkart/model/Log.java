package com.fjmartins.evkart.model;

import com.fjmartins.evkart.Constants;
import com.google.gson.annotations.SerializedName;
import com.squareup.moshi.Json;

import java.util.Calendar;

public class Log {

    public static int count;

    @SerializedName("rpm")
    public int rpm;
    @SerializedName("duty")
    public double onDuty;
    @SerializedName("thv")
    public double throttleVoltage;
    @SerializedName("volt")
    public double batteryVoltage;
    @SerializedName("ampere")
    public double batteryAmp;
    @SerializedName("sec")
    public int timeStamp;
    @SerializedName("kmph")
    public int kmph;
    @SerializedName("type")
    public int type = 1;

    public Log() {
        count++;

        this.timeStamp = count;
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
                rpm = Integer.parseInt(value);
                kmph = (int)((rpm / 4.375) * 3.14 * 60 * 0.4064) / 1000;
                break;
            case "On Duty(%)":
                onDuty = Double.parseDouble(value);
                break;
            case "ThV(V)":
                throttleVoltage = Double.parseDouble(value);
                break;
            case "BV(V)":
                batteryVoltage = Double.parseDouble(value);
                break;
            case "BI(A)":
                batteryAmp = Double.parseDouble(value);
                break;
            default:
                break;
        }
    }
}
