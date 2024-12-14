package androidApp.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage{

    private final SelenideElement devMenuButton = $(byId("ru.beeline.services.staging:id/dev_menu_button"));
    private final SelenideElement changeStandButton = $x("//android.widget.Button[@text='Сменить стенд']");
    private final SelenideElement rcTestButton = $x("//android.widget.Button[@text='RC Test ']");
    private final SelenideElement inputField = $(byId("ru.beeline.services.staging:id/edit_text"));
    private final SelenideElement inputButton = $(byId("ru.beeline.services.staging:id/enter_button"));
    private final SelenideElement passwordEntryButton = $x("//android.widget.Button[@text='По паролю']");
    private final SelenideElement passwordField = $(byId("ru.beeline.services.staging:id/password_edit_text"));
    private final SelenideElement inputButtonModal = $x("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.LinearLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.Button");
    private final SelenideElement skipButton = $x("//android.widget.TextView[@text='Пропустить']");

    @Step("Перейти к выбору стенда")
    public LoginPage chooseStand(){
        devMenuButton.shouldBe(visible).click();
        changeStandButton.shouldBe(visible).click();
        rcTestButton.shouldBe(visible).click();
        changeStandButton.shouldBe(visible);
        verticalSwipeByPercentages(0.5,0.8,0.5);
        return new LoginPage();
    }

    @Step("Авторизация")
    public MainPage login(String login, String password) {
        inputField.shouldBe(visible).sendKeys(login);
        inputButton.shouldBe(visible).click();
        passwordEntryButton.shouldBe(visible).click();
        passwordField.shouldBe(visible).sendKeys(password);
        inputButtonModal.shouldBe(visible).click();
        skipButton.shouldBe(visible).click();
        return new MainPage();
    }
}
