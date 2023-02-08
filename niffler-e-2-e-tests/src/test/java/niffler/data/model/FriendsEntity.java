package niffler.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "friends", schema = "public", catalog = "niffler-userdata")
public class FriendsEntity {
    @Id
    @GeneratedValue
    @Column(name = "friends_id")
    private UUID id;

    @Column(name = "name")
    private String name;


}
