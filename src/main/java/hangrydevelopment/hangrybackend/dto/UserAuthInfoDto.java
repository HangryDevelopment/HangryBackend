package hangrydevelopment.hangrybackend.dto;

import javax.validation.constraints.NotNull;

import hangrydevelopment.hangrybackend.models.Role;
// import hangrydevelopment.hangrybackend.models.*;
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
    private Role role;
}