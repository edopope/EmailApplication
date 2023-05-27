package EmailApplication2.EmailApplication2.Dtos.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SendEmails {
    private String emailUrl;
    private String topic;
    private String message;
}
