package niffler.test.web;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.AllureId;
import niffler.page.WelcomePage;
import org.junit.jupiter.api.Test;

public class ImageTest extends BaseTest {

    @Test
    @AllureId("52")
    void checkPhoto() {
        Selenide.open(WelcomePage.URL, WelcomePage.class)
                .checkImagePage("yourImage.png");

    }
}
