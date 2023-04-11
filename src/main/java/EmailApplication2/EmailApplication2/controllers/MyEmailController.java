package EmailApplication2.EmailApplication2.controllers;

import EmailApplication2.EmailApplication2.Data.models.MyEmail;
import EmailApplication2.EmailApplication2.Dtos.Request.CreateEmailRequest;
import EmailApplication2.EmailApplication2.Dtos.Response.MyEmailResponse;
import EmailApplication2.EmailApplication2.services.EmailServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/email/create1")
@AllArgsConstructor
public class MyEmailController {


        private EmailServices emailServices;

        @PostMapping("/sendEmail")
        @ResponseStatus(HttpStatus.OK)
        public String sendAMail(@RequestBody CreateEmailRequest createAMail){
            emailServices.sendEmail(createAMail);
            return "Email Sent!";
        }



        @GetMapping("/getAllEmails")
        @ResponseStatus(HttpStatus.OK)
        public List<MyEmailResponse> getAllUser(){
            return  emailServices.getAllEmails();
        }

        @GetMapping("/findEmail/{emailTitle}")
//        @ResponseStatus(HttpStatus.OK)
        public ResponseEntity<?> getEmailByTitle(@PathVariable String emailTitle){
            MyEmailResponse email = emailServices.getEmailsByTitle(emailTitle);
            return new ResponseEntity<>(email, HttpStatus.OK);
        }

        @DeleteMapping("deleteEmail/{emailTitle}")
        @ResponseStatus(HttpStatus.OK)
        public void deleteEmail(@PathVariable String emailTitle){
            emailServices.deleteMailByTitle(emailTitle);

        }
        @PostMapping("/createAndSaveToDraft")
    @ResponseStatus(HttpStatus.CREATED)
    public String createAndSaveToDraft(@RequestBody CreateEmailRequest create){
            emailServices.createAndSaveEmail(create);
            return "Email created and saved to draft";
        }

    }


