package niffler.condition;

import com.codeborne.selenide.CheckResult;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class PhotoCondition {

    public static Condition image(String imagePath) {
        return new Condition("image") {
            @Nonnull
            @Override
            public CheckResult check(Driver driver, WebElement element) {
                byte[] image = ((TakesScreenshot) driver.getWebDriver()).getScreenshotAs(OutputType.BYTES);
                byte[] fileContent;

                try {
                    fileContent = Files.readAllBytes(new File("niffler-e-2-e-tests/src/test/resources/" + imagePath).toPath());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                boolean actualValue = Arrays.equals(image, fileContent);

                return new CheckResult(actualValue, actualValue);
            }
        };
    }
}
