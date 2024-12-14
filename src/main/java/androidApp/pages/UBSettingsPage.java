package androidApp.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class UBSettingsPage extends BasePage{
    private SelenideElement addCtnUBButton = $x("/hierarchy/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[6]/android.widget.Button");
    private SelenideElement ubTitle = $x("//span[@data-component='ubCtnListTitle']");
    private List<SelenideElement> divListCtn = $$x("//span[text()='Ваши номера и лицевые счета']/parent::div/parent::div/div");
    private SelenideElement reformUBButton = $x("//button[@data-component='ubCtnFooterBtn']");
    private SelenideElement exitButton = $x("//span[text()='Общий баланс']/parent::div/parent::div/parent::div/parent::div/div[2]/button");
    private SelenideElement errorInfoDiv = $x("//span[@data-component='ubCtnListTitle']/parent::div/parent::div/div[4]");
    private SelenideElement leftUBButton = $x("//span[@data-component='ubCtnFooterBtnLabel']");
    private SelenideElement ubNextBillingsBtnLabel = $x("//span[@data-component='ubNextBillingsBtnLabel']");
    private SelenideElement ubNextDateBillingMessage = $x("//div[@data-component='ubNextDateBillingMessage']");
    private SelenideElement ubNextBillingsBtn = $x("//span[@data-component='ubNextBillingsBtnLabel']");

    @Step("Нажать на кнопку добавления CTN")
    public ChoiceAddCtnPage clickAddCtnButton(){
        addCtnUBButton.shouldBe(visible).click();
        return new ChoiceAddCtnPage();
    }

    @Step("Проверка наличия ctn в списке ОБ и активного тоггла")
    public boolean isCtnOnTheListAndIsToggleActive(String ctn){
        SelenideElement ctnToggle = $x("//label[@data-component='" + ctn + "_ub_switch']/input");
        List<String> ctnList = new ArrayList();
        ubTitle.shouldBe(visible);
        for (SelenideElement div: divListCtn) {
            if(div.toString().contains("data-component")){
                ctnList.add(Objects.requireNonNull(div.attr("data-component")).replaceAll("[^\\d]", ""));
            }
        }
        for (String number : ctnList) {
            if (number.contains(ctn)) {
                return Objects.equals(ctnToggle.attr("checked"), "true");
            }
        }
        return false;
    }

    @Step("Проверка наличия ctn в списке ОБ")
    public boolean isCtnOnTheList(String ctn){
        List<String> ctnList = new ArrayList();
        ubTitle.shouldBe(visible);
        for (SelenideElement div: divListCtn) {
            if(div.toString().contains("data-component")){
                ctnList.add(div.attr("data-component").replaceAll("[^\\d]", ""));
            }
        }
        return ctnList.contains(ctn);
    }

//    @Step("Нажать кнопку \"Расформировать\"")
//    public AcceptReformUBPage clickReformUBButton(){
//        reformUBButton.shouldBe(visible).click();
//        return PageBuilder.buildAcceptReformUBPage();
//    }

    @Step("Нажать на тоггл")
    public void clickOnToggle(String ctn){
        SelenideElement ctnToggleDiv = $x("//label[@data-component='" + ctn + "_ub_switch']");
        ctnToggleDiv.scrollIntoView(true).click();
    }

    @Step("Нажать на кнопку закрытия")
    public MainPage clickExitButton(){
        exitButton.shouldBe(visible).click();
        return new MainPage();
    }

    @Step("Проверка ошибки отрицательного баланса у Основного номера")
    public void checkErrorMainNegBalance(){
        errorInfoDiv.shouldHave(text("Чтобы сформировать Общий баланс, ваш баланс должен быть положительным"));
        addCtnUBButton.shouldNotBe(visible);
    }

//    @Step("Нажать на кнопку выхода из ОБ")
//    public AcceptLeftUBPage clickLeftUBButton(){
//        leftUBButton.shouldBe(visible).click();
//        return PageBuilder.buildAcceptLeftUBPage();
//    }

//    @Step("Нажать на кнопку редактирования имени")
//    public EditNamePage clickOnEditNameButton(String ctn){
//        SelenideElement editButton = $x("//button[@data-component='" + ctn + "_ub_editIcon']");
//        editButton.shouldBe(visible).click();
//        return PageBuilder.buildEditNamePage();
//    }

    @Step("Вернуть имя ctn")
    public String getCtnName(String ctn){
        SelenideElement nameTitle = $x("//span[@data-component='" + ctn + "_ub_nickname']");
        return nameTitle.getText();
    }

    @Step("Проверка возможности редактирования имени номера в ОБ")
    public boolean isEditButtonDisplayed(String ...ctnArr){
        for (int i = 0; i < ctnArr.length; i++) {
            SelenideElement editButton = $x("//button[@data-component='" + ctnArr[i] + "_ub_editIcon']");
            ubTitle.shouldBe(visible);
            try{
                editButton.shouldBe(visible);
                return true;
            }
            catch (ElementNotFound e){
                return false;
            }
        }
        return true;
    }

    @Step("Нажать на кнопку \"Предстоящие списания\"")
    public void clickUbNextBillingsBtnLabel(){
        ubNextBillingsBtnLabel.shouldBe(visible).click();
    }

    @Step("Проверка открытия страницы с настройками ОБ")
    public void checkOpenUBSettingsPage(){
        ubTitle.shouldBe(visible);
    }

    @Step("Проверка наличия плашки предстоящих списаний")
    public boolean isVisibleUBNextDateBillingMessage(){
        ubTitle.shouldBe(visible);
        try{
            ubNextDateBillingMessage.shouldBe(visible);
            return true;
        }
        catch (ElementNotFound e){
            return false;
        }
    }

    @Step("Проверка доступности тоггла")
    public boolean isEnabledToggle(String ctn){
        SelenideElement ctnToggleDiv = $x("//label[@data-component='" + ctn + "_ub_switch']");
        return ctnToggleDiv.isEnabled();
    }

    @Step("Проверка текстовки по предстоящим списаниям")
    public void checkTextBilling(int billingTotalSum, String date){
        ubNextDateBillingMessage.shouldHave(text("Чтобы оставаться на связи, пополните Общий баланс на" + " " + billingTotalSum + " " + "₽ до " + date));
        ubNextBillingsBtn.shouldHave(text("Предстоящие списания"));
    }

}
