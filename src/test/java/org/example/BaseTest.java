package org.example;

import PageObjects.LandingPage;
import Utilities.AppiumUtilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest extends AppiumUtilities {
    private AppiumDriverLocalService service;
    public AndroidDriver driver;
    public LandingPage landingPage;

    @BeforeClass(alwaysRun = true)
    public void CongifureAppium() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("/Users/ivansvalina/Documents/Faks/MiTTPP/MiTTPP_LV3/src/main/java/AndroidResources.properties");

        properties.load(fileInputStream);

        service = startAppiumService(
                properties.getProperty("ipAddress"),
                Integer.parseInt(properties.getProperty("port"))
        );

        UiAutomator2Options options = new UiAutomator2Options();

//TODO add app filepath once downloaded
        options.setDeviceName(properties.getProperty("deviceName"))
                .setPlatformVersion(properties.getProperty("platformVersion"))
                .setAutomationName("UIAutomator2")
                .setApp(properties.getProperty("appPath"));

        driver = new AndroidDriver(service.getUrl(), options);
        landingPage = new LandingPage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void TearDown(){
        driver.quit();
        service.stop();
    }
}
