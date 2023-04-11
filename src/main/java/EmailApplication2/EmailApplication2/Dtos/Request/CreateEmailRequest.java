package EmailApplication2.EmailApplication2.Dtos.Request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateEmailRequest {
    private String toWhom;
    private String title;
    private String body;
}
