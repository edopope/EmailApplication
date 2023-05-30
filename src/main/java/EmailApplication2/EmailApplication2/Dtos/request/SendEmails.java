package EmailApplication2.EmailApplication2.Dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SendEmails {
    private String firstName;
    private String emailUrl;
    private String message;
    private String topic;
    private String senderEmail;
    private String senderName;
}
