package hangrydevelopment.hangrybackend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import hangrydevelopment.hangrybackend.dto.UserFetchDto;
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
    @Column(nullable = false, unique = true)
    private String restaurantId;

    @Column(nullable = false, length = 150)
    private String restaurant;

    @Column(nullable = true, unique = false)
    private String restaurant_img;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH,
            CascadeType.REFRESH }, targetEntity = User.class)
    @JoinTable(name = "user_restaurants", joinColumns = {
            @JoinColumn(name = "restaurant_id", nullable = false, updatable = false) }, inverseJoinColumns = {
                    @JoinColumn(name = "user_id", nullable = false, updatable = false) }, foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT), inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    @JsonIgnoreProperties({ "restaurants", "password", "createdAt", "role"})
    private Collection<UserFetchDto> users;
}
