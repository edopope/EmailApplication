package EmailApplication2.EmailApplication2.controllers;

import EmailApplication2.EmailApplication2.Data.models.MyUsers;
import EmailApplication2.EmailApplication2.Dtos.UserResponses;
import EmailApplication2.EmailApplication2.Dtos.request.CreateUserRequest;
import EmailApplication2.EmailApplication2.exceptions.LoginExceptionForUsers;
import EmailApplication2.EmailApplication2.services.UserServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/email/create")
@AllArgsConstructor
public class UserController {

    private UserServices userServices;

    @PostMapping("/createUser")
@ResponseStatus(HttpStatus.CREATED)
    public String registerUsers(@RequestBody CreateUserRequest registerUsers) throws LoginExceptionForUsers {
         try {
             userServices.registerUser(registerUsers);
         }
         catch(LoginExceptionForUsers loginException){
            return loginException.getMessage();
        }
        return "you are Registered!";
    }
@GetMapping("/getAllUser")
@ResponseStatus(HttpStatus.OK)
    public List<UserResponses> getAllUser(){
 return  userServices.getAllUser();
    }

    @GetMapping("/findAUser/{username}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> getUserByUserName(@PathVariable String username){
        UserResponses userResponses = new UserResponses();
        MyUsers myUsers= userServices.getUserByUserName(username);
        return new ResponseEntity<>(userResponses, HttpStatus.OK);
    }

    @DeleteMapping("deleteUser/{userName}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteUser(@PathVariable String userName){
         userServices.deleteUserByEmailUserName(userName);
        return ResponseEntity.status(HttpStatus.OK).body("deleted successfully!!");
    }

}
