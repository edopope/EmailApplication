package EmailApplication2.EmailApplication2.Data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
//@RequiredArgsConstructor
public class MyEmail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long emailId;
    private String emailBody;
    private String emailTitle;
}
