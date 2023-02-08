package niffler.data.reposetory;

import niffler.data.DataBase;
import niffler.data.UsersDAO;
import niffler.data.jpa.EmfContext;
import niffler.data.jpa.JpaService;
import niffler.data.model.UsersEntity;

public class PostgresHibernateUsersRepository extends JpaService implements UsersDAO {
    public PostgresHibernateUsersRepository() {
        super(EmfContext.INSTANCE.getEmf(DataBase.USERDATA).createEntityManager());
    }

    @Override
    public int addUser(UsersEntity users) {
        persist(users);
        return 0;
    }

    @Override
    public void updateUser(UsersEntity user) {

        merge(user);
    }

    @Override
    public void remove(UsersEntity user) {
        remove(user);
    }

    @Override
    public UsersEntity getByUsername(String username) {
        return em.createQuery("select u from UsersEntity u where u.username=:username", UsersEntity.class)
                .setParameter("username", username)
                .getSingleResult();
    }
}
