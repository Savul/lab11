package util;

import Driver.DriverSingleton;
import org.apache.commons.io.FileUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {
    private Logger log = LogManager.getRootLogger();
    @Override
    public void onTestStart(ITestResult iTestResult) {
        log.info("test is started");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        saveScreenshots("onTestFailure");
        log.info("test is failure");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
            saveScreenshots("onTestSkipped");
            log.info("test is skipped");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        saveScreenshots("onTestSuccess");
        log.info("test is success");
    }

    private  void saveScreenshots(String typeOfEndingTest)
    {
        File screeCapture = ((TakesScreenshot) DriverSingleton.getDriver()).getScreenshotAs(OutputType.FILE);
        try
        {
            FileUtils.copyFile(screeCapture,new File(".//target/screenshots/"+getCurrentTimeAsString()+"-"+typeOfEndingTest+".png"));
        }catch (IOException e)
        {
            log.error("Error in screenshot: " + e.getLocalizedMessage());
        }
    }

    private String getCurrentTimeAsString()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }
}
