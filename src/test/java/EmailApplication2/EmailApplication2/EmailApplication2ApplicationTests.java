package EmailApplication2.EmailApplication2;

import EmailApplication2.EmailApplication2.Data.models.MyUsers;
import EmailApplication2.EmailApplication2.Data.repositories.UserRepo1;
import EmailApplication2.EmailApplication2.services.UserServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmailApplication2ApplicationTests {
	@Autowired
private UserServices userServices;
	@Autowired
	private UserRepo1 userRepo1;
	@BeforeEach
	public void setUp(){

	}
	@Test
	public void createUser(){
		MyUsers myUsers = MyUsers.builder()
						.firstName("godwin")
								.lastName("stanley")
										.emailUserName("stanley@419")
												.password("123")
				.build();
		userRepo1.save(myUsers);
		assertNotNull(myUsers);

	}

//	@Test
//	public void userCanRegister() throws LoginExceptionForUsers {
//MyUsers users = new MyUsers();
//users.setEmailUserName("stanleygodwin@360");
//users.setFirstName("stanley");
//users.setLastName("godwin");
//users.setPassword("12345");
// MyUsers newUsers = userRepo1.save(users);
// userServices.registerUser(newUsers)
// assertEquals("stanleygodwin@360",userRepo1.findMyUsersByEmailUserName("stanleygodwin@360"));
//	}


	@Test
	public void testYouCanFindUserByUsername(){
		MyUsers myUsers = MyUsers.builder()
				.firstName("godwin")
				.lastName("stanley")
				.emailUserName("stanley@419")
				.password("123")
				.build();
		userRepo1.save(myUsers);
		//assertEquals(userRepo1.findMyUsersByEmailUserName(myUsers.getEmailUserName()).toString() ,"stanley@419");
	}
	}


