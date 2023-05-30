package EmailApplication2.EmailApplication2.Dtos.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter
@Builder
public class MailMessenger {
    private String name;

    private String email;
}
