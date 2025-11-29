package Model.DTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class SupplierDetailsDTO {
    private String legalName;
    private String tradeName;
    private String primaryContact;
    private String EmergencyContact;
    private String physicalAddress;
}
