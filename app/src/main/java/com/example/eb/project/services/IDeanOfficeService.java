package com.example.eb.project.services;


public interface IDeanOfficeService {
    int getCurrentServicedNumber();
    int getAvailableNumber();
    int reserveNumber();
    void cancelNumber();
}
