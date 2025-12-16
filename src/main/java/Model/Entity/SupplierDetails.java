package Model.Entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class SupplierDetails {
    private String id;
    private String LegalName;
    private String TradeName;
    private String PrimaryContact;
    private String EmergencyContact;
    private String PhysicalAddress;
}
