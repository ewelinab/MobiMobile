package com.example.eb.project.services.test;

import android.os.Handler;

import com.example.eb.project.services.WelfareDeanOfficeService;

public class TestWelfareDeanOfficeService extends WelfareDeanOfficeService {
    public TestWelfareDeanOfficeService(String user, String password, int currentServicedNumber, final int availableNumber) {
        super(user, password);
        this.currentServicedNumber = currentServicedNumber;
        this.availableNumber = availableNumber;

        final Handler h = new Handler();
        h.postDelayed(new Runnable() {
            public void run() {
                GetNextStudent();
                h.postDelayed(this, 15000);
            }
        }, 15000);

        final Handler h1 = new Handler();
        h1.postDelayed(new Runnable() {
            public void run() {
                EmulateSomeoneReservedNumber();
                h1.postDelayed(this, 5000);
            }
        }, 5000);
    }

    void GetNextStudent()
    {
        ++currentServicedNumber;
    }

    void EmulateSomeoneReservedNumber()
    {
        ++availableNumber;
    }

}
