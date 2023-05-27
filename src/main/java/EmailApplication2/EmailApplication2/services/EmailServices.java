package EmailApplication2.EmailApplication2.services;

import EmailApplication2.EmailApplication2.Data.models.MyEmail;
import EmailApplication2.EmailApplication2.Dtos.Request.SendEmails;
import EmailApplication2.EmailApplication2.Dtos.Response.MyEmailResponse;
import EmailApplication2.EmailApplication2.Dtos.Response.MyEmailResponse;

import java.util.List;

public interface EmailServices {
    void createAndSaveEmail(SendEmails sendEmails);
List<MyEmailResponse> getAllEmails();

MyEmailResponse getEmailsByTitle(String emailTitle);

void deleteMailByTitle(String title);

    String sendMail(SendEmails sendEmails);


}
