package EmailApplication2.EmailApplication2.Data.repositories;

import EmailApplication2.EmailApplication2.Data.models.MyUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface UserRepo1 extends JpaRepository<MyUsers,Long> {
   MyUsers findMyUsersByEmailUserName(String username);


}
