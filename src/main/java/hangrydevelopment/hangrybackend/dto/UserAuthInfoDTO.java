package hangrydevelopment.hangrybackend.dto;

import hangrydevelopment.hangrybackend.models.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserAuthInfoDTO {
    private Long id;
    private String userName;
    private String email;
    private UserRole role;
    private String avatar_url;
    private String backdrop_url;
    private String gamerTag;
    private String region;
}
