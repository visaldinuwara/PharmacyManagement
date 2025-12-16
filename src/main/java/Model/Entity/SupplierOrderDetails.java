package Model.Entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class SupplierOrderDetails {
    private String OrderId;
    private String SupplierId;
    private String OrderDate;
    private String ExpectedDate;
    private double TotalCost;
}
