package androidApp.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class AcceptCreateUBPage extends BasePage {
    private SelenideElement acceptCreateUBButton = $x("//android.widget.TextView[@text='Продолжить']");
    private SelenideElement createUBTitle = $x("//android.widget.TextView[@text='Общий баланс создан']");

    @Step("Нажать на кнопку \"Продолжить\"")
    public UBSettingsPage clickAcceptCreateUBButton(){
        createUBTitle.shouldHave(text("Общий баланс создан"));
        acceptCreateUBButton.shouldBe(visible).click();
        return new UBSettingsPage();
    }
}
