package com.example.eb.project;

import com.example.eb.project.services.DeanOfficeCredentialSystem;
import com.example.eb.project.services.IDeanOfficeCredentials;
import com.example.eb.project.services.IDeanOfficeService;
import com.example.eb.project.services.test.TestStudyDeanOfficeService;
import com.example.eb.project.services.test.TestWelfareDeanOfficeService;

public class DeanOfficeFactory {

    public static IDeanOfficeCredentials CreateDeanOfficeCredentialSystem() {
        return new DeanOfficeCredentialSystem();
    }

    public static IDeanOfficeService CreateWelfareDeanOffice(String username, String password) {
        return new TestWelfareDeanOfficeService(username, password, 1, 5);
    }

    public static IDeanOfficeService CreateStudyDeanOffice(String username, String password) {
        return new TestStudyDeanOfficeService(username, password, 1, 5);
    }
}
