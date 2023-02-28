package niffler.test.rest;

import io.qameta.allure.AllureId;
import niffler.api.NifflerSpendClient;
import niffler.jupiter.annotation.GenerateCategory;
import niffler.jupiter.annotation.GenerateUser;
import niffler.jupiter.annotation.GenerationSpend;
import niffler.jupiter.annotation.User;
import niffler.model.CurrencyValues;
import niffler.model.UserJson;
import org.junit.jupiter.api.Test;

import static niffler.jupiter.extension.CreateUserExtension.Selector.METHOD;

public class NifflerSpendApiTest {

    private final NifflerSpendClient nsc = new NifflerSpendClient();

    @AllureId("100")
    @GenerateUser(categories = {
            @GenerateCategory("Рестораны"),
            @GenerateCategory("Бары"),

    },
          spend = { @GenerationSpend(spendDate = "2023-01-26",
                    category = "Рестораны",
                    currency = CurrencyValues.KZT,
                    amount = 3.2,
                    description = "Описание")})


    @Test
    void apiShouldReturnIdOfCreatedSpend(@User(selector = METHOD) UserJson user) throws Exception {

        System.out.println(user.getSpendJsons());
        System.out.println(user.getUserName());
        System.out.println(user.getCategoryJsons());



    }
}
