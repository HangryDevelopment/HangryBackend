package hangrydevelopment.hangrybackend.services;


//import hangrydevelopment.hangrybackend.models.Restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/api/yelpFetch", produces = "application/json")
public class YelpService {

    @GetMapping("/{location}")
    public ResponseEntity<String> getRestaurants(@PathVariable String location) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer YELP-API-KEY");
        headers.add("accept", "application/json");
        String url = "https://api.yelp.com/v3/businesses/search?location=" + location + "&term=fast%20food&radius=40000&categories=Fast%20food&open_now=true&sort_by=best_match&matches_party_size_param=true&limit=20";
        HttpEntity<Object> entity = new HttpEntity<Object>(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

//        Object[] places = restTemplate.getForObject(url, Object[].class);
//
//        assert places != null;
//        return Arrays.asList(places);
        System.out.println(response);
        return response;
    }
}
