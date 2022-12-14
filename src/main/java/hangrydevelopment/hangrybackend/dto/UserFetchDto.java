package hangrydevelopment.hangrybackend.dto;

import lombok.*;

import java.util.Collection;

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
    private String email;
    private String avatar_url;
    private String backdrop_url;
}
