package EmailApplication2.EmailApplication2.services;


import EmailApplication2.EmailApplication2.Data.models.MyEmail;
import EmailApplication2.EmailApplication2.Data.repositories.EmailRepo1;
import EmailApplication2.EmailApplication2.Dtos.Request.CreateEmailRequest;
import EmailApplication2.EmailApplication2.Dtos.Response.MyEmailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailServices{
   @Autowired
    private EmailRepo1 emailRepo1;
    @Autowired
   private JavaMailSender javaMailSender;
    @Override
    public void createAndSaveEmail(CreateEmailRequest createEmailRequest) {
       MyEmail myEmail = MyEmail.builder()
               .emailBody(createEmailRequest.getBody())
               .emailTitle(createEmailRequest.getTitle())
               .build();
       myEmail = emailRepo1.save(myEmail);
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

    @Override
    public void sendEmail(CreateEmailRequest createEmailRequest) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("godwin-semicolon@domain.io");
        message.setTo(createEmailRequest.getToWhom());
        message.setSubject(createEmailRequest.getTitle());
        message.setText(createEmailRequest.getBody());
        javaMailSender.send(message);
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
    }

