package EmailApplication2.EmailApplication2.mailConfig;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailConfig {
    private String apiKey;
    private String mailUrl;
}
