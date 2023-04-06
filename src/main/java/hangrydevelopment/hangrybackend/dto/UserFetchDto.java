package hangrydevelopment.hangrybackend.dto;

// import hangrydevelopment.hangrybackend.models.User;
import lombok.*;

// import java.util.Collection;
// import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
///**
// * this is the user dto returned when calling /api/users (or fetch all users)
// */
public class UserFetchDto {
    private Long id;
    private String userName;
    private String password;
}