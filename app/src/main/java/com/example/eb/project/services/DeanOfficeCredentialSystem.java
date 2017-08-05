package com.example.eb.project.services;

public class DeanOfficeCredentialSystem implements IDeanOfficeCredentials {
    @Override
    public boolean login(String username, String password) {
        if (username .equals("123") && password.equals("ala")) {
            return true;
        }
        else return false;
    }
}
