package EmailApplication2.EmailApplication2.services;


import EmailApplication2.EmailApplication2.Dtos.MyEmailResponse;
import EmailApplication2.EmailApplication2.Dtos.request.EmailNotificationRequest;
import EmailApplication2.EmailApplication2.Dtos.request.SendEmails;

import java.util.List;

public interface EmailServices {
    void createAndSaveEmail(SendEmails sendEmails1);
List<MyEmailResponse> getAllEmails();

MyEmailResponse getEmailsByTitle(String emailTitle);

void deleteMailByTitle(String title);
     String sendHtmlMail(EmailNotificationRequest sendMessage);

    String sendMail(SendEmails sendEmails);


}
