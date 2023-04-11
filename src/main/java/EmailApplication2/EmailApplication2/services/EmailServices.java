package EmailApplication2.EmailApplication2.services;

import EmailApplication2.EmailApplication2.Data.models.MyEmail;
import EmailApplication2.EmailApplication2.Dtos.Request.CreateEmailRequest;
import EmailApplication2.EmailApplication2.Dtos.Response.MyEmailResponse;
import EmailApplication2.EmailApplication2.Dtos.Response.MyEmailResponse;

import java.util.List;

public interface EmailServices {
    void createAndSaveEmail(CreateEmailRequest createEmailRequest);
List<MyEmailResponse> getAllEmails();

MyEmailResponse getEmailsByTitle(String emailTitle);

void deleteMailByTitle(String title);
void sendEmail(CreateEmailRequest createEmailRequest);

}
