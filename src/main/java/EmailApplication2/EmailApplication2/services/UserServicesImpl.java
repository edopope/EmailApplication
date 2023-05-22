package EmailApplication2.EmailApplication2.services;

import EmailApplication2.EmailApplication2.Data.models.MyUsers;
import EmailApplication2.EmailApplication2.Data.repositories.UserRepo1;
import EmailApplication2.EmailApplication2.Dtos.Request.CreateUserRequests;
import EmailApplication2.EmailApplication2.Dtos.Response.UserResponses;
import EmailApplication2.EmailApplication2.exceptions.LoginExceptionForUsers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServicesImpl implements UserServices{
    public final UserRepo1 userRepo1;




    public void createAndSaveUser(CreateUserRequests user){
        ModelMapper mapper = new ModelMapper();
        MyUsers newMyUsers = MyUsers
                .builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .emailUserName(user.getUsername())
                .build();
        userRepo1.save(newMyUsers);
    }

    @Override
    public void deleteUserByEmailUserName(String username) {
        userRepo1.delete(userRepo1.findMyUsersByEmailUserName(username));
    }

    @Override
    public MyUsers registerUser(CreateUserRequests user) throws LoginExceptionForUsers {
        MyUsers foundUser = userRepo1.findMyUsersByEmailUserName(user.getUsername());
        if (foundUser != null) throw new LoginExceptionForUsers("User already exists");
        MyUsers newMyUsers = MyUsers
                .builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .emailUserName(user.getUsername())
                .password(user.getPassword())
                .build();
        userRepo1.save(newMyUsers);
              return newMyUsers;
    }
        //return null;


    @Override
    public void loginUser(CreateUserRequests user) {
        boolean canLogin = true;
//if (user.getUsername() == userRepo1.findMyUsersByEmailUserName())
    }

    @Override
    public List<UserResponses> getAllUser() {
        List<MyUsers> myUsers = userRepo1.findAll();
        return myUsers.stream().map(user -> mapToUserResponse(user)).toList();

    }
   public MyUsers getUserByUserName(String username){
        return userRepo1.findMyUsersByEmailUserName(username);
   }

    private UserResponses mapToUserResponse(MyUsers myUsers) {
return UserResponses.builder()
        .firstName(myUsers.getFirstName())
        .username(myUsers.getEmailUserName())
        .lastName(myUsers.getLastName())
        .build();
    }


}
