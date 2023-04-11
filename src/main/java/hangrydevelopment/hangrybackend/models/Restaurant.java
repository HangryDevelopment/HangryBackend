package hangrydevelopment.hangrybackend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "restaurants")
public class Restaurant {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(nullable = false, unique = true, length = 100)
private String restaurant;

@ManyToMany(
fetch = FetchType.LAZY,
cascade = {CascadeType.DETACH, CascadeType.REFRESH},
targetEntity = User.class)
@JoinTable(
name="user_restaurants",
joinColumns = {@JoinColumn(name = "restaurants_id", nullable = false,
updatable = false)},
inverseJoinColumns = {@JoinColumn(name="user_id", nullable = false, updatable
= false)},
foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT)
)
@JsonIgnoreProperties({"restaurants"})
private Collection<User> users;
}
