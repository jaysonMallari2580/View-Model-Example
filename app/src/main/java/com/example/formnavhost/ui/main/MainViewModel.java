package com.example.formnavhost.ui.main;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private String name = "";
    private String email = "";
    private String schoolName = "";


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
