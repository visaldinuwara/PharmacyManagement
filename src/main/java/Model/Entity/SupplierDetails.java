package Model.Entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class SupplierDetails {
    private String id;
    private String legalName;
    private String tradeName;
    private String primaryContact;
    private String EmergencyContact;
    private String physicalAddress;
}
