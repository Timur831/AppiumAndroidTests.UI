package androidApp.helpers.drivers;

import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DeviceDriver {

    private static final String URL = "http://127.0.0.1:4723/wd/hub";

    private static WebDriver getAndroidDriver(){

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "realme narzo 50i Prime");
        desiredCapabilities.setCapability("udid", "2A05295510CA01WZ");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "11");

        desiredCapabilities.setCapability("appPackage", "ru.beeline.services.staging");
        desiredCapabilities.setCapability("appActivity", "ru.beeline.RootActivity");

        return new AndroidDriver(getUrl(), desiredCapabilities);
    }

    public static void initDriver(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.timeout = 10000;
        Configuration.screenshots = true;

        WebDriverRunner.setWebDriver(getAndroidDriver());
    }

    private static URL getUrl() {
        try {
            return new URL(URL);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}
