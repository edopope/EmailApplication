package EmailApplication2.EmailApplication2;

import EmailApplication2.EmailApplication2.Dtos.Request.CreateEmailRequest;
import EmailApplication2.EmailApplication2.services.EmailServices;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.EventListener;




@SpringBootApplication
public class EmailApplication2Application {
	//@Autowired


	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(EmailApplication2Application.class, args);

//		EmailServices emailServices	= applicationContext.getBean(EmailServices.class);
//		CreateEmailRequest createEmailRequest = CreateEmailRequest.builder()
//				.toWhom("mediconnect247@gmail.com")
//				.body("howfar")
//				.title("nigga")
//				.build();
//		emailServices.sendEmail(createEmailRequest);
//
//	}


// create and send email message using Spring Framework's JavaMailSender


	}
}
