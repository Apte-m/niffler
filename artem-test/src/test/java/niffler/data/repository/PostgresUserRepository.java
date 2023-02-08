package niffler.data.repository;

import niffler.data.config.DataBase;
import niffler.data.jpa.EntityManagerFactoryContext;
import niffler.data.jpa.JpaService;
import niffler.data.model.FriendsEntity;
import niffler.data.model.UserDAO;
import niffler.data.model.UsersEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PostgresUserRepository extends JpaService implements UserDAO {
    public PostgresUserRepository() {
        super(EntityManagerFactoryContext.INSTANCE.getEmf(DataBase.USERDATA).createEntityManager());
    }

    @Override
    public int addUser(UsersEntity users) {
        persist(users);
        return 0;
    }

    @Override
    public void updateUser(UsersEntity user, String... nameFriends) {
        List<FriendsEntity> friendsEntities = new ArrayList<>();
        FriendsEntity friendsEntity = new FriendsEntity();

        Arrays.stream(nameFriends).forEach( v-> {
            friendsEntity.setName(v);
            friendsEntities.add(friendsEntity);
        });

        user.setFriendsEntity(friendsEntities);
        merge(user);
    }

    @Override
    public void remove(UsersEntity user) {
        remove(user);
    }

    @Override
    public UsersEntity getByUsername(String username) {
        return manager.createQuery("select u from UsersEntity u where u.username=:username", UsersEntity.class)
                .setParameter("username", username)
                .getSingleResult();
    }
}
