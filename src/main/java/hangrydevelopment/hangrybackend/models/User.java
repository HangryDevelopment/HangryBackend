package hangrydevelopment.hangrybackend.models;

// import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
// import java.util.Collection;
// import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String userName;

    @Column(nullable = false, length = 15)
    private String password;

    @Column(nullable = false)
    private LocalDate createdAt;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column
    private UserRole role;

    // @ManyToMany(cascade = CascadeType.MERGE, mappedBy = "userFriends")
    // @JsonIgnoreProperties({"userFriends", "likes", "userName", "gamerTag",
    // "region", "blocked", "email", "createdAt", "role", "friendsList", "posts",
    // "postComments", "games", "platforms"})
    // private List<User> friendsList;
}
