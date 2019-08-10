package com.fjmartins.evkart;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.fjmartins.evkart.model.Log;
import com.fjmartins.evkart.network.LoggerTask;

public class MainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {

    private static int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportFragmentManager().addOnBackStackChangedListener(this);
        if (savedInstanceState == null)
            getSupportFragmentManager().beginTransaction().add(R.id.fragment, new DevicesFragment(), "devices").commit();
        else
            onBackStackChanged();

//        requestHttp();
    }

//    private void requestHttp() {
//        if (count < 120) {
//            new Handler().postDelayed(() -> {
//                Log log = new Log();
//                log.batteryAmp = 19;
//                log.batteryVoltage = 44;
//                log.onDuty = 21;
//                log.rpm = 2304;
//                log.kmph = (int)((log.rpm / 4.375) * 3.14 * 60 * 0.4064) / 1000;
//                log.throttleVoltage = 12;
//
//                new LoggerTask().execute(log);
//                requestHttp();
//            }, 1000);
//
//            count++;
//        }
//    }

    @Override
    public void onBackStackChanged() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(getSupportFragmentManager().getBackStackEntryCount()>0);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
