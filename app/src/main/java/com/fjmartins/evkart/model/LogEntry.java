package com.fjmartins.evkart.model;

import com.fjmartins.evkart.Constants;

import java.util.Calendar;

public class LogEntry {

    private int rpm;
    private double onDuty;
    private String throttleVoltage;
    private double batteryVoltage;
    private double batteryAmp;
    private String timeStamp;

    LogEntry() {
        this.timeStamp = Calendar.getInstance().getTime().toString();
    }

    public static LogEntry fromString(String dataString) {
        LogEntry logEntry = new LogEntry();

        for (String attribute : dataString.split(Constants.DATA_DIVIDER)) {
            String[] keyAndValue = attribute.split(Constants.KEY_VALUE_DIVIDER);
            if (keyAndValue.length > 1) {
                logEntry.setAttribute(keyAndValue[0], keyAndValue[1]);
            }
        }

        return logEntry;
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
