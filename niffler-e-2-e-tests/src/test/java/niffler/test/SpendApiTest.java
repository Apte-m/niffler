package niffler.test;

import niffler.api.NifflerSpendClient;
import niffler.dto.Spend;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SpendApiTest {

    private NifflerSpendClient nsc = new NifflerSpendClient();

    @ValueSource(strings = {
            "data/spend0.json",
            "data/spend1.json"
    })
    @ParameterizedTest
    void addSpend(@niffler.converter.Spend Spend spend) throws Exception {
        Spend created = nsc.createSpend(spend);
        Assertions.assertNotNull(created.getId());
    }
}
