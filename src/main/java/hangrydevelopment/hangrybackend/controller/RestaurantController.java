package hangrydevelopment.hangrybackend.controller;

import hangrydevelopment.hangrybackend.models.Restaurant;
import hangrydevelopment.hangrybackend.repository.RestaurantRepository;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping(value = "api/restaurants", produces = "application/json")
public class RestaurantController {
    private RestaurantRepository restaurantRepository;

    @GetMapping("")
    private List<Restaurant> fetchAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Restaurant> fetchRestaurantById(String id) {
        Optional<Restaurant> optionalRestaurants = restaurantRepository.findById(id);
        if (optionalRestaurants.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurant id " + id + " not found");
        }
        return optionalRestaurants;
    }

    @PostMapping("/save/{name}/{restaurantId}/{restaurant_img}")
    public void addRestaurantToRestaurants (@PathVariable String name, @PathVariable String restaurantId, @PathVariable String restaurant_img){
        restaurantRepository.addRestaurantToRestaurants(name, restaurantId, restaurant_img);
    }

    @PostMapping("/add/{myd}/{restaurantId}")
    public void addRestaurantById(@PathVariable long myd, @PathVariable String restaurantId){
        restaurantRepository.addRestaurantById(myd, restaurantId);
    }

    @DeleteMapping("/{myd}/{restaurantId}")
    public void deleteRestaurantById(@PathVariable String restaurantId, @PathVariable long myd) {
        restaurantRepository.deleteRestaurantById(restaurantId, myd);
    }

}