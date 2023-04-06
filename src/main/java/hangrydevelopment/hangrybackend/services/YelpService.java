package hangrydevelopment.hangrybackend.services;


//import hangrydevelopment.hangrybackend.models.Restaurant;

// import org.springframework.beans.factory.annotation.Autowired;
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

// import java.util.Arrays;
// import java.util.List;

@RestController
@RequestMapping(value = "/api/yelpFetch", produces = "application/json")
public class YelpService {

    @Value("${api.key}")
    private String apiKey;

    @GetMapping("/{location}")
    public ResponseEntity<String> getRestaurants(@PathVariable String location) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", apiKey);
        headers.add("accept", "application/json");
        headers.add("Access-Control-Allow-Origin", "*");
        String url = "https://api.yelp.com/v3/businesses/search?location=" + location + "&radius=25000&term=fastfood&categories=Fast%20food&sort_by=distance&limit=50";
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
