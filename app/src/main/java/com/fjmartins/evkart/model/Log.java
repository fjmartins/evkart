package com.fjmartins.evkart.model;

import com.fjmartins.evkart.Constants;
import com.squareup.moshi.Json;

import java.util.Calendar;

/* {
        "type": "value",
        "sec": "value",
        "volt": "value",
        "ampere": "value",
        "rpm": "value",
        "duty": "value",
        "thv": "value",
        "kmph": "value"
    }'*/
public class Log {

    @Json(name = "rpm")
    public int rpm;
    @Json(name = "duty")
    public double onDuty;
    @Json(name = "thv")
    public String throttleVoltage;
    @Json(name = "volt")
    public double batteryVoltage;
    @Json(name = "ampere")
    public double batteryAmp;
    @Json(name = "sec")
    public String timeStamp;

    Log() {
        this.timeStamp = Calendar.getInstance().getTime().toString();
    }

    public static Log fromString(String dataString) {
        Log log = new Log();

        for (String attribute : dataString.split(Constants.DATA_DIVIDER)) {
            String[] keyAndValue = attribute.split(Constants.KEY_VALUE_DIVIDER);
            if (keyAndValue.length > 1) {
                log.setAttribute(keyAndValue[0], keyAndValue[1]);
            }
        }

        return log;
    }

    private void setAttribute(String key, String value) {
        switch (key) {
            case "RPM(rpm)":
                rpm = Integer.parseInt(value);
                break;
            case "On Duty(%)":
                onDuty = Double.parseDouble(value);
                break;
            case "ThV(V)":
                throttleVoltage = value;
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

    @Override
    public String toString() {
        return "\nRPM: " + rpm
                + "\nOn Duty: " + onDuty
                + "\nThrottle: " + throttleVoltage
                + "\nBattery: " + batteryVoltage
                + "\nBattery Amp: " + batteryAmp
                + "\nTime: " + timeStamp + "\n";
    }
}
