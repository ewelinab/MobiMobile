package com.example.eb.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.eb.project.services.IDeanOfficeService;

public class UserActivity extends AppCompatActivity implements android.view.View.OnClickListener {

    private IDeanOfficeService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

    }

    @Override
    public void onClick(View v) {
        String u = getIntent().getStringExtra("Username");
        String p = getIntent().getStringExtra("Password");
        switch (v.getId())
        {
            case R.id.buttonStudies:
                Intent intent = new Intent(this, StudyActivity.class);
                intent.putExtra("Username", u.toString());
                intent.putExtra("Password", p.toString());
                startActivityForResult(intent, 1);
                break;
            case R.id.buttonWelfare:
                Intent intent1 = new Intent(this, WelfareActivity.class);
                intent1.putExtra("Username", u.toString());
                intent1.putExtra("Password", p.toString());
                startActivityForResult(intent1, 1);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
