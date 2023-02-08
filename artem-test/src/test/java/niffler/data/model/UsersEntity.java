package niffler.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users", schema = "public")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private UUID id;
    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "currency")
    private String currency;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "surname")
    private String surname;

    @Column(name = "photo")
    private byte[] photo;


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = FriendsEntity.class, mappedBy = "id")

    private List<FriendsEntity> friendsEntity;

}
