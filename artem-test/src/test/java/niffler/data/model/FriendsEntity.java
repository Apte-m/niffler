package niffler.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "friends", schema = "public")
public class FriendsEntity  {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "username")
    private String name;


}

