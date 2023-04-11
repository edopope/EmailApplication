package EmailApplication2.EmailApplication2.Data.models;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

//@RequiredArgsConstructor
public class MyUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String emailUserName;
    //private List<MyEmail> emails;
    private String phoneNumber;
    private String getMessage;
    private String password;
}
