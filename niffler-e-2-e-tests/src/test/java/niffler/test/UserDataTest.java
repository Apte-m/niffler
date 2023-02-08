package niffler.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import niffler.data.UsersDAO;
import niffler.data.model.FriendsEntity;
import niffler.data.model.UsersEntity;
import niffler.jupiter.annotations.DAO;
import niffler.jupiter.DAOResolver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;


@ExtendWith({DAOResolver.class})
public class UserDataTest extends BaseTest {

    @DAO
    private UsersDAO usersDAO;

    private String originalCurrency;
    private String testedCurrency = "KZT";

    @BeforeEach
    void addUserDataBeforeTest() {
        UsersEntity dima = usersDAO.getByUsername("artem");
        originalCurrency = dima.getCurrency();
        dima.setCurrency(testedCurrency);
        FriendsEntity friendsOne = new FriendsEntity();
        friendsOne.setName("Goga");

        FriendsEntity friendsTwo = new FriendsEntity();
        friendsTwo.setName("Goga");

        List <FriendsEntity>  friendsEntities = new ArrayList<>();
        friendsEntities.add(friendsOne);
        friendsEntities.add(friendsTwo);

        dima.setFriendsEntity(friendsEntities);

        usersDAO.updateUser(dima);


//        Selenide.open("http://127.0.0.1:3000/");
//        $("a[href*='redirect']").click();
//        $("input[name='username']").setValue("artem");
//        $("input[name='password']").setValue("123");
//        $("button[type='submit']").click();
//        $(".header__title").shouldBe(Condition.visible)
//                .shouldHave(Condition.text("Niffler. The coin keeper."));
    }

    @AfterEach
    void restoreUser() {
        UsersEntity dima = usersDAO.getByUsername("artem");
        dima.setCurrency(originalCurrency);
        usersDAO.updateUser(dima);

    }

    @Test
    void checkCurrencyTest() {
        $(".header__username").click();
        $("span[id^='react-select'] ").parent().should(text(testedCurrency));
    }
}
