package com.persol.evkart.ui

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hoho.android.usbserial.driver.UsbSerialProber
import android.hardware.usb.UsbManager
import com.persol.evkart.R
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get UsbManager from Android.
        val manager = getSystemService(Context.USB_SERVICE) as UsbManager

        // Find the first available driver.
        val driver = UsbSerialProber.acquire(manager)

        if (driver != null) {
            driver.open()
            try {
                driver.setBaudRate(115200)

                val buffer = ByteArray(16)
                val numBytesRead = driver.read(buffer, 1000)
            } catch (e: IOException) {
                // Deal with error.
            } finally {
                driver.close()
            }
        }
    }
}
