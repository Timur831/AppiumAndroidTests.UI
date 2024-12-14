package androidApp.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AddCtnPage {
    private final SelenideElement inputPhoneField = $(byId("ru.beeline.services.staging:id/input_field"));
    private final SelenideElement addButton = $x("//android.widget.TextView[@text='Добавить']");

    @Step("Ввести номер в поле")
    public AddCtnPage fillPhoneInput(String ctn){
        inputPhoneField.shouldBe(visible).sendKeys(ctn);
        return new AddCtnPage();
    }

    @Step("Нажать кнопку \"Добавить\"")
    public void clickAddButton(){
        addButton.shouldBe(visible).click();
    }
}
