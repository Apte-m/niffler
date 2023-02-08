package niffler.data.test;

import niffler.data.jupiter.ResolverDAO;
import niffler.data.model.UserDAO;
import niffler.data.model.UsersEntity;
import niffler.data.model.annotations.DAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

@ExtendWith(ResolverDAO.class)
public class UserTest extends BaseTest {
    @DAO
    private UserDAO usersDAO;





    @BeforeEach
    void addUserDataBeforeTest() {
        UsersEntity artem = usersDAO.getByUsername("artem");
        usersDAO.updateUser(artem,"Vova","Goga","Petr");

    }



    @Test
    void checkCurrencyTest() {
        List <String> expectedName =  Arrays.asList("Petr","Vova","Goga");

        UsersEntity artem = usersDAO.getByUsername("artem");

        assertThat(expectedName, containsInAnyOrder(artem.getFriendsEntity().toArray()));

    }
}
