package niffler.data.model.dao;

import niffler.data.model.FriendsEntity;

public interface FriendsDAO  extends DAO{
    int addFriends(FriendsEntity friendsEntity);

    void updateFriends(FriendsEntity friendsEntity);

    void remove(FriendsEntity friendsEntity);

    FriendsEntity getByFriendsName(String friends);
}
