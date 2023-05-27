package EmailApplication2.EmailApplication2.Dtos.Request;


import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailNotificationRequest {

    private List<MailMessenger> to=new ArrayList<>();
    private String htmlContent;

}
