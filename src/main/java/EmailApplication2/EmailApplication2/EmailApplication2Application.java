package EmailApplication2.EmailApplication2;


import EmailApplication2.EmailApplication2.services.EmailServices;
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
		 SpringApplication.run(EmailApplication2Application.class, args);


	}
}
