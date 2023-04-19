package hangrydevelopment.hangrybackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import hangrydevelopment.hangrybackend.models.Restaurant;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface RestaurantRepository extends JpaRepository<Restaurant, String> {
    @Modifying
    @Transactional
    @Query(value = "insert into user_restaurants (user_id, restaurant_id) VALUES (:userId, :restaurantId)", nativeQuery = true)
    void addRestaurantById(@Param("userId") Long userID, @Param("restaurantId") String restaurantId);

    // INSERT INTO games for inserting each game id as it is gathered from RAWG
    @Modifying
    @Transactional
    @Query(value = "insert into restaurants (restaurant, restaurant_Id, restaurant_img) VALUES (:restaurant, :restaurantId, :restaurant_img)", nativeQuery = true)
    void addRestaurantToRestaurants(@Param("restaurant") String restaurant, @Param("restaurantId") String restaurantId, @Param("restaurant_img") String restaurant_img);

    @Modifying
    @Transactional
    @Query(value = "delete from user_restaurants WHERE user_id = :userId AND restaurant_Id = :restaurantId", nativeQuery = true)
    void deleteRestaurantById(@Param("restaurantId") String restaurantId, @Param("userId") Long userID);

}
