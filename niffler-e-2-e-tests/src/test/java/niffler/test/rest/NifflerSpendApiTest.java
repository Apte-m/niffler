package niffler.test.rest;

import io.qameta.allure.AllureId;
import niffler.api.NifflerSpendClient;
import niffler.jupiter.annotation.*;
import niffler.model.CurrencyValues;
import niffler.model.SpendJson;
import niffler.model.UserJson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static niffler.jupiter.extension.CreateUserExtension.Selector.METHOD;

public class NifflerSpendApiTest {

    private final NifflerSpendClient nsc = new NifflerSpendClient();




    @AllureId("100")
    @GenerateUser(categories = {
            @GenerateCategory("Рестораны"),
            @GenerateCategory("Бары"),

    }, spend = @GenerationSpend(spendDate = "2023-01-26",
            category = "Рестораны",
            currency = CurrencyValues.KZT,
            amount = 3.2,
            description = "Описание"))
//            @GenerationSpend(spendDate = "2023-01-26",
//                    category = "Рестораны",
//                    currency = CurrencyValues.KZT,
//                    amount = 3.2,
//                    description = "Описание")})


//    @ValueSource(strings = {
//            "data/spend0.json",
//            "data/spend1.json"
//    })
//    @ParameterizedTest
    @Test
    void apiShouldReturnIdOfCreatedSpend(@Spend SpendJson spend, @User(selector = METHOD) UserJson user) throws Exception {
        spend.setUsername(user.getUserName());
        SpendJson created = nsc.createSpend(spend);
        Assertions.assertNotNull(created.getId());



    }
}
