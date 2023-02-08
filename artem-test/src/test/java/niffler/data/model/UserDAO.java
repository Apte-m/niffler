package niffler.data.model;

public interface UserDAO extends DAO {
    int addUser(UsersEntity users);

    void updateUser(UsersEntity user ,String ... nameFriends);

    void remove(UsersEntity user);

    UsersEntity getByUsername(String username);
}
