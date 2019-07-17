package com.fjmartins.evkart.model;

import android.hardware.usb.UsbDevice;

import com.hoho.android.usbserial.driver.UsbSerialDriver;

public class ListItem {
    public UsbDevice device;
    public int port;
    public UsbSerialDriver driver;

    public ListItem(UsbDevice device, int port, UsbSerialDriver driver) {
        this.device = device;
        this.port = port;
        this.driver = driver;
    }
}
