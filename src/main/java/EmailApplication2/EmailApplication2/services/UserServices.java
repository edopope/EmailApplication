package EmailApplication2.EmailApplication2.services;

import EmailApplication2.EmailApplication2.Data.models.MyUsers;
import EmailApplication2.EmailApplication2.Dtos.Request.CreateUserRequests;
import EmailApplication2.EmailApplication2.Dtos.Response.UserResponses;
import EmailApplication2.EmailApplication2.exceptions.LoginExceptionForUsers;

import java.util.List;

public interface UserServices {
    MyUsers registerUser(CreateUserRequests user) throws LoginExceptionForUsers;
void loginUser(CreateUserRequests user) throws LoginExceptionForUsers;

 List<UserResponses> getAllUser();
 MyUsers getUserByUserName(String username);
 void createAndSaveUser(CreateUserRequests createUserRequests);

 void deleteUserByEmailUserName(String username);
}
