package tests;

import androidApp.pages.AcceptCreateUBPage;
import androidApp.pages.LoginPage;
import androidApp.pages.StoryPage;
import androidApp.pages.UBSettingsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static androidApp.AppConfig.*;

public class CreateUBTest extends BaseTest {

    @Test(description="UB-T32. Создание Общего баланса с мобильным номером (без акцепта)", groups = {"positive"})
    public void createUBCtnNoAccept() {

        new LoginPage()
                .chooseStand()
                .login(FIRST_NUMBER, PASSWORD)
                .clickBalanceButton()
                .clickCreateUBButton();
        new StoryPage()
                .closeStory();
        new UBSettingsPage()
                .clickAddCtnButton()
                .chooseAddCtn()
                .fillPhoneInput(SECOND_NUMBER)
                .clickAddButton();
        new AcceptCreateUBPage()
                .clickAcceptCreateUBButton();
        System.out.println("pause");
//
//        Assert.assertTrue(PageBuilder.buildUBSettingsPage()
//                .isCtnOnTheListAndIsToggleActive(SECOND_NUMBER));
    }
}
