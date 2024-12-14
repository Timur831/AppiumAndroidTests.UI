package androidApp.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class StoryPage {
    private SelenideElement toNextStoryButton = $x("/hierarchy/android.view.View/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.ScrollView");

//    @Step("Нажать на кнопку закрытия Стори")
//    public MainPage clickCloseStoryButton(){
//        closeStoryButton.shouldBe(visible).click();
//        return new MainPage();
//    }

    @Step("Переключить на следующую стори")
    public StoryPage clickToNextStoryButton(){
        toNextStoryButton.shouldBe(visible).click();
        return new StoryPage();
    }

    @Step("Переключить все сторис")
    public MainPage closeStory(){
        for (int i = 0; i < 6; i++) {
            clickToNextStoryButton();
        }
        return new MainPage();
    }
}
