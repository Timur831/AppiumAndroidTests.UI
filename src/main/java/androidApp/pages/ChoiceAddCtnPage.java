package androidApp.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class ChoiceAddCtnPage extends BasePage{
    private final SelenideElement addCtnPhoneButton = $x("//android.widget.TextView[@text='Номер телефона']");

    @Step("Выбор добавления Ctn")
    public AddCtnPage chooseAddCtn(){
        addCtnPhoneButton.shouldBe(visible).click();
        return new AddCtnPage();
    }
}
