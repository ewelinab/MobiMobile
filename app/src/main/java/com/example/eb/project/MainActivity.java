package com.example.eb.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eb.project.services.IDeanOfficeCredentials;

public class MainActivity extends AppCompatActivity implements android.view.View.OnClickListener {

    private Button loginButton;
    private EditText username;
    private EditText userPassword;

    private IDeanOfficeCredentials credentialsService = DeanOfficeFactory.CreateDeanOfficeCredentialSystem();

    private void showToastWithText(CharSequence toastText) {
        Toast.makeText(getApplicationContext(), toastText, Toast.LENGTH_LONG)
                .show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = (Button) findViewById(R.id.loginButton);
        findViewById(R.id.loginButton).setOnClickListener(this);

        username = (EditText) findViewById(R.id.editTextUserLogin);
        userPassword = (EditText) findViewById(R.id.editTextUserPassword);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.loginButton:

                if(credentialsService.login(username.getText().toString(), userPassword.getText().toString()))
                {
                    Intent intent = new Intent(this, UserActivity.class);
                    //TODO: przeslac username i password do kolejnego slajdu
                    intent.putExtra("Username", username.getText().toString());
                    intent.putExtra("Password", userPassword.getText().toString());
                    startActivity(intent);
                }
                else
                {//TODO: dodac handlowanie zlego logowania
                    showToastWithText("niepoprawny login lub hasło!");
                }
                break;
        }
    }
}
