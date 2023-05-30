package EmailApplication2.EmailApplication2.Dtos.request;


import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailNotificationRequest {
   private MailMessenger sender = new MailMessenger();
  // private  final MailMessenger sender = new MailMessenger("MEDIC--CONNECT", "noreply@medic_connect.net");
    private List<MailMessenger> to=new ArrayList<>();
    private final String subject="My-Custom-Mail";
    private String htmlContent;

}
