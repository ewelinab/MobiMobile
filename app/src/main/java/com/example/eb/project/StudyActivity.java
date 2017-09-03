package com.example.eb.project;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.eb.project.services.DeanOfficeCredentialSystem;
import com.example.eb.project.services.IDeanOfficeService;

public class StudyActivity extends AppCompatActivity implements android.view.View.OnClickListener {

    private TextView availableNumberStudy;
    private TextView currentNumberStudy;
    private TextView availableNumberStudyTitle;

    private IDeanOfficeService service;
    private int reservedNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);

        availableNumberStudy = (TextView) findViewById(R.id.availableNumberStudy);
        currentNumberStudy = (TextView) findViewById(R.id.currentNumberStudy);
        availableNumberStudyTitle = (TextView) findViewById(R.id.availableNumberStudyTitle);

        String username = getIntent().getStringExtra("Username");
        String password = getIntent().getStringExtra("Password");
        service = DeanOfficeFactory.CreateStudyDeanOffice(username, password);
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
            availableNumberStudy.setText(Integer.toString(service.getAvailableNumber()));
        currentNumberStudy.setText(Integer.toString(service.getCurrentServicedNumber()));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.approveButtonStudy:
                reservedNumber = service.reserveNumber();
                availableNumberStudy.setText(Integer.toString(reservedNumber));
                availableNumberStudy.setBackgroundColor(Color.rgb(254, 114, 100));
                availableNumberStudyTitle.setText("Twój numer");
                availableNumberStudyTitle.setTextColor(Color.rgb(255, 56, 35));
                break;
            case R.id.cancelButtonStudy:
                service.cancelNumber();
                finish();
                break;
        }
    }
}
