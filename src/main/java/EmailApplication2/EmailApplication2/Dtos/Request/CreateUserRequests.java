package EmailApplication2.EmailApplication2.Dtos.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class CreateUserRequests {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
}
