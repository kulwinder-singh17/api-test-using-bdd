package com.example.auto.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports createInstance(String fileName) {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("API Testing Report");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("API Test Results");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host", "Localhost");
        extent.setSystemInfo("Environment", "Test");
        extent.setSystemInfo("User", "Kulwinder");

        return extent;
    }

    public static ExtentReports getInstance() {
        return extent;
    }
}
