package com.example.eb.project;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.eb.project.services.IDeanOfficeService;

public class WelfareActivity extends AppCompatActivity implements android.view.View.OnClickListener {

    private TextView availableNumberWelfare;
    private TextView currentNumberWelfare;
    private TextView availableNumberWelfareTitle;

    private IDeanOfficeService service;
    private int reservedNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welfare);

        availableNumberWelfare = (TextView) findViewById(R.id.availableNumberWelfare);
        currentNumberWelfare = (TextView) findViewById(R.id.currentNumberWelfare);
        availableNumberWelfareTitle = (TextView) findViewById(R.id.availableNumberWelfareTitle);

        String username = getIntent().getStringExtra("Username");
        String password = getIntent().getStringExtra("Password");
        service = DeanOfficeFactory.CreateWelfareDeanOffice(username, password);
        startPeriodicUpdates(1000);
}

    void startPeriodicUpdates(final int time)
    {
        final Handler h = new Handler();
        h.postDelayed(new Runnable() {
            public void run() {
                updateOfficeNumbers();
                h.postDelayed(this, time);
            }
        }, 0);
    }

    void updateOfficeNumbers()
    {
        if(reservedNumber == 0)
            availableNumberWelfare.setText(Integer.toString(service.getAvailableNumber()));
        currentNumberWelfare.setText(Integer.toString(service.getCurrentServicedNumber()));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.approveButtonWelfare:
                reservedNumber = service.reserveNumber();
                availableNumberWelfare.setText(Integer.toString(reservedNumber));
                availableNumberWelfare.setTextColor(Color.rgb(232, 161, 57));
                availableNumberWelfareTitle.setText("Twój numerek:");
                break;
            case R.id.welfareCancelButton:
                service.cancelNumber();
                finish();
                break;
        }
    }
}
