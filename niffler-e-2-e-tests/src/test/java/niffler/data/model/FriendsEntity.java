package niffler.data.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "friends", schema = "public", catalog = "niffler-userdata")
public class FriendsEntity {
    @Id
    @Column(name = "friends_id")
    private UUID friendId;

    @Column(name = "name", nullable = false)
    private String name;
    @OneToOne(mappedBy = "friendsEntity")
    private UsersEntity users;

    public UUID getFriendId() {
        return friendId;
    }

    public void setFriendId(UUID friendId) {
        this.friendId = friendId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UsersEntity getUsers() {
        return users;
    }

    public void setUsers(UsersEntity users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "FriendsEntity{" +
                "friendId=" + friendId +
                ", name='" + name + '}';
    }
}
