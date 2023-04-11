package EmailApplication2.EmailApplication2.services;

import EmailApplication2.EmailApplication2.Data.repositories.EmailRepo1;
import EmailApplication2.EmailApplication2.exceptions.LoginExceptionForUsers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(classes = {UserServicesImpl.class})
@ExtendWith(SpringExtension.class)
class MyUsersServicesImplTest {
    @Autowired
private UserServices userServices;
@Autowired
    private EmailRepo1 emailRepo1;

@Test
    public void testThatYouCanCreateUser() throws LoginExceptionForUsers {
//    CreateUserRequests newUser = new CreateUserRequests("john","doe","johndoe@gmail.com","1234");
//    userServices.registerUser(newUser);
//    assertNotNull(newUser);
}
}