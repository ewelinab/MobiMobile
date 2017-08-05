package com.example.eb.project.services;

public abstract class DeanOfficeService implements IDeanOfficeService {
    protected String user;
    protected String password;
    protected int currentServicedNumber;
    protected int availableNumber;

    protected DeanOfficeService(String user, String password)
    {
        this.user = user;
        this.password = password;
    }

    @Override
    public int getCurrentServicedNumber() {
        return currentServicedNumber;
    }

    @Override
    public int getAvailableNumber() {
        return availableNumber;
    }

    @Override
    public int reserveNumber() {
        return availableNumber;
    }

    @Override
    public void cancelNumber() {

    }
}
