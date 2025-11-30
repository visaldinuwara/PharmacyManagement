package Model.DTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class LoginDetailsDTO {
    private String userName;
    private String password;
}
