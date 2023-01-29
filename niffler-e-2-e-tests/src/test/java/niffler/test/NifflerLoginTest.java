package niffler.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureId;
import niffler.extension.ScreenshotExtension;
import niffler.extension.User;
import niffler.extension.UsersExtension;
import niffler.model.UserModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Selenide.$;
import static niffler.extension.User.UserType.ADMIN;
import static niffler.extension.User.UserType.COMMON;

@ExtendWith({ScreenshotExtension.class, UsersExtension.class})
public class NifflerLoginTest {

    @AllureId("1")
    @Test
    void mainPageShouldBeDisplayedAfterSuccessLogin(@User(userType = ADMIN) UserModel user) {
        System.out.println("#### Test 1 " + user.toString());
        Allure.step("Check login", () -> {
            Selenide.open("http://127.0.0.1:3000/");
            $("a[href*='redirect']").click();
            $("input[name='username']").setValue("dima");
            $("input[name='password']").setValue("12345");
            $("button[type='submit']").click();
            $(".header__title").shouldBe(Condition.visible)
                    .shouldHave(Condition.text("Niffler. The coin keeper."));
        });
    }

    @AllureId("2")
    @Test
    void mainPageShouldBeDisplayedAfterSuccessLogin0(@User(userType = ADMIN) UserModel user
            ,@User(userType = COMMON) UserModel userCommon) {
        System.out.println("#### Test 2 admin " + user.toString());
        System.out.println("#### Test 2 common " + userCommon.toString());
        Allure.step("Check login", () -> {
            Selenide.open("http://127.0.0.1:3000/");
            $("a[href*='redirect']").click();
            $("input[name='username']").setValue("dima");
            $("input[name='password']").setValue("12345");
            $("button[type='submit']").click();
            $(".header__title").shouldBe(Condition.visible)
                    .shouldHave(Condition.text("Niffler. The coin keeper."));
        });
    }

    @AllureId("3")
    @Test
    void mainPageShouldBeDisplayedAfterSuccessLogin1(@User UserModel user) {
        System.out.println("#### Test 3 " + user.toString());
        Allure.step("Check login", () -> {
            Selenide.open("http://127.0.0.1:3000/");
            $("a[href*='redirect']").click();
            $("input[name='username']").setValue("dima");
            $("input[name='password']").setValue("12345");
            $("button[type='submit']").click();
            $(".header__title").shouldBe(Condition.visible)
                    .shouldHave(Condition.text("Niffler. The coin keeper."));
        });
    }

    @AllureId("4")
    @Test
    void mainPageShouldBeDisplayedAfterSuccessLogin2(@User UserModel user) {
        System.out.println("#### Test 4 " + user.toString());
        Allure.step("Check login", () -> {
            Selenide.open("http://127.0.0.1:3000/");
            $("a[href*='redirect']").click();
            $("input[name='username']").setValue("dima");
            $("input[name='password']").setValue("12345");
            $("button[type='submit']").click();
            $(".header__title").shouldBe(Condition.visible)
                    .shouldHave(Condition.text("Niffler. The coin keeper."));
        });
    }

    @AllureId("5")
    @Test
    void mainPageShouldBeDisplayedAfterSuccessLogin3(@User UserModel user) {
        System.out.println("#### Test 5 " + user.toString());
        Allure.step("Check login", () -> {
            Selenide.open("http://127.0.0.1:3000/");
            $("a[href*='redirect']").click();
            $("input[name='username']").setValue("dima");
            $("input[name='password']").setValue("12345");
            $("button[type='submit']").click();
            $(".header__title").shouldBe(Condition.visible)
                    .shouldHave(Condition.text("Niffler. The coin keeper."));
        });
    }


}
