package EmailApplication2.EmailApplication2.Dtos;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponse {
    private String message;
    private int id;
}
