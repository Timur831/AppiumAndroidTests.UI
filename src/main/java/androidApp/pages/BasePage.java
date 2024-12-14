package androidApp.pages;

import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class BasePage {

    protected void verticalSwipeByPercentages(double startPercentage, double endPercentage, double anchorPercentage) {
        AndroidDriver androidDriver = (AndroidDriver) WebDriverRunner.getWebDriver();
        Dimension size = androidDriver.manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * endPercentage);
        new TouchAction(androidDriver)
                .press(point(anchor, startPoint))
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(point(anchor, endPoint))
                .release().perform();
    }
}
