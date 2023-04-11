package EmailApplication2.EmailApplication2.Dtos.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponses {
    private String firstName;
    private String lastName;
    private String username;
}
