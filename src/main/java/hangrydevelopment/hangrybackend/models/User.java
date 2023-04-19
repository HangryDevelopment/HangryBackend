package hangrydevelopment.hangrybackend.models;

// import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringExclude;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;
import java.util.Collection;
// import java.util.Collection;
// import java.util.List;
import java.util.Set;

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

    @ToString.Exclude
    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false)
    private LocalDate createdAt;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column
    private Role role;

    // @ElementCollection(fetch = FetchType.EAGER)
    // private Set<String> roles;

    // @ManyToMany(cascade = CascadeType.MERGE, mappedBy = "userFriends")
    // @JsonIgnoreProperties({"userFriends", "likes", "userName", "gamerTag",
    // "region", "blocked", "email", "createdAt", "role", "friendsList", "posts",
    // "postComments", "games", "platforms"})
    // private List<User> friendsList;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH,
            CascadeType.REFRESH }, targetEntity = Restaurant.class)
    @JoinTable(name = "user_restaurants", joinColumns = {
            @JoinColumn(name = "user_id", nullable = false, updatable = false) }, inverseJoinColumns = {
                    @JoinColumn(name = "restaurant_id", nullable = false, updatable = false) }, foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT), inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    @JsonIgnoreProperties({"users"})
    @ToString.Exclude
    private Collection<Restaurant> restaurants;
}
