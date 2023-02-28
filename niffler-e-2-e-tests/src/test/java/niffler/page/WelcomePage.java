package niffler.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static niffler.condition.PhotoCondition.image;


public class WelcomePage extends BasePage<WelcomePage> {

    public static final String URL = CFG.frontUrl();

    private final SelenideElement loginButton = $("#root > div > div.main-page__container > div > img");
    private final SelenideElement registerButton = $("a[href*='register']");
    private final SelenideElement body = $x("/html/body");

    @Step("Redirect to login page")
    public LoginPage doLogin() {
        loginButton.click();
        return new LoginPage();
    }

    @Step("Redirect to register page")
    public RegisterPage doRegister() {
        registerButton.click();
        return new RegisterPage();
    }

    @Step("Check that page is loaded")
    @Override
    public WelcomePage waitForPageLoaded() {
        loginButton.should(visible);
        registerButton.should(visible);
        return this;
    }


    public void checkImagePage(String path) {
        body.shouldHave(image(path));
    }
}
