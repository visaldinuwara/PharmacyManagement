package Model.DTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class CustomerDetailDTO {
    private String FirstName;
    private String LastName;
    private String EmailAddress;
    private String PhoneNo;
}
