package EmailApplication2.EmailApplication2.services;


import EmailApplication2.EmailApplication2.Data.models.MyEmail;
import EmailApplication2.EmailApplication2.Data.repositories.EmailRepo1;

import EmailApplication2.EmailApplication2.Dtos.MyEmailResponse;
import EmailApplication2.EmailApplication2.Dtos.request.EmailNotificationRequest;
import EmailApplication2.EmailApplication2.Dtos.request.MailMessenger;
import EmailApplication2.EmailApplication2.Dtos.request.SendEmails;
import EmailApplication2.EmailApplication2.mailConfig.MailConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sibModel.SendEmail;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailServices{
   @Autowired
    private EmailRepo1 emailRepo1;
   @Autowired
private final MailConfig mailConfig;


//   private JavaMailSender javaMailSender;
    @Override
    public void createAndSaveEmail(SendEmails sendEmails1) {
       MyEmail myEmail = MyEmail.builder()
               .emailBody(sendEmails1.getMessage())
               .emailTitle(sendEmails1.getTopic())
               .build();
        emailRepo1.save(myEmail);
    }

    @Override
    public MyEmailResponse getEmailsByTitle(String emailTitle) {
        MyEmailResponse myEmailResponse = new MyEmailResponse();
        MyEmail foundEmail = emailRepo1.findEmailByEmailTitle(emailTitle);
        myEmailResponse.setBody(foundEmail.getEmailBody());
        myEmailResponse.setTitle(foundEmail.getEmailTitle());
        return myEmailResponse;
    }

    @Override
    public void deleteMailByTitle(String title) {
        emailRepo1.delete(emailRepo1.findEmailByEmailTitle(title));
    }


    public List<MyEmailResponse> getAllEmails () {
        List<MyEmail> myMyEmails = emailRepo1.findAll();
        return myMyEmails.stream().map(user -> mapToEmailResponse(user)).toList();
}

    private MyEmailResponse mapToEmailResponse(MyEmail myEmails) {
        return MyEmailResponse.builder()
                .body(myEmails.getEmailBody())
                .title(myEmails.getEmailTitle())
                .build();
    }

    @Override
    public String sendHtmlMail(EmailNotificationRequest request)  {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("api-key", mailConfig.getApiKey());
        HttpEntity<EmailNotificationRequest> requestEntity = new HttpEntity<>(request, headers);

        ResponseEntity<String> response =
                restTemplate.postForEntity(mailConfig.getMailUrl(), requestEntity, String.class);
        log.info("res->{}", response);
        return response.getBody();
    }

    @Override
    public String sendMail(SendEmails sendEmails) {
        String message = sendEmails.getMessage();
        EmailNotificationRequest request = EmailNotificationRequest.builder()
                .sender(new MailMessenger(sendEmails.getSenderName(),sendEmails.getSenderEmail()))
                .to(List.of(new MailMessenger(sendEmails.getFirstName(),sendEmails.getEmailUrl())))
                .htmlContent(String.format(message,sendEmails.getFirstName()))
                .build();
        return sendHtmlMail(request);
    }

    }

