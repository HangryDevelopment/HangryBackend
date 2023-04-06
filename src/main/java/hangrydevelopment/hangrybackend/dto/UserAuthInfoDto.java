package hangrydevelopment.hangrybackend.dto;

import hangrydevelopment.hangrybackend.models.*;
import lombok.*;

// import java.util.Collection;
// import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserAuthInfoDto {
    private Long id;
    private String userName;
    private String password;
}