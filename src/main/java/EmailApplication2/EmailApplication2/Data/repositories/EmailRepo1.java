package EmailApplication2.EmailApplication2.Data.repositories;

import EmailApplication2.EmailApplication2.Data.models.MyEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface EmailRepo1 extends JpaRepository<MyEmail,Long> {
    MyEmail findEmailByEmailTitle(String emailTitle);

}
