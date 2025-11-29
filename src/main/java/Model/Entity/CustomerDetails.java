package Model.Entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class CustomerDetails {
    private String id;
    private String FirstName;
    private String LastName;
    private String EmailAddress;
    private String PhoneNo;
}
