package com.example.demo.util;


import com.example.demo.base.TestBase;

public class BrowserManager {

    public void setUpBrowser() {
        TestBase.setBrowser();
    }

    public void quitBrowser() {
        TestBase.quitDriver();
    }
}
