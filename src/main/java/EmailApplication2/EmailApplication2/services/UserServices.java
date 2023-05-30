package EmailApplication2.EmailApplication2.services;

import EmailApplication2.EmailApplication2.Data.models.MyUsers;
import EmailApplication2.EmailApplication2.Dtos.UserResponses;
import EmailApplication2.EmailApplication2.Dtos.request.CreateUserRequest;
import EmailApplication2.EmailApplication2.exceptions.LoginExceptionForUsers;

import java.util.List;

public interface UserServices {
    MyUsers registerUser(CreateUserRequest user) throws LoginExceptionForUsers;
void loginUser(CreateUserRequest user) throws LoginExceptionForUsers;

 List<UserResponses> getAllUser();
 MyUsers getUserByUserName(String username);
 void createAndSaveUser(CreateUserRequest createUserRequests);

 void deleteUserByEmailUserName(String username);
}
