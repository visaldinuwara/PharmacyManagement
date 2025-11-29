package Model.Entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class SupplierOrderDetails {
    private String orderId;
    private String supplierId;
    private String orderDate;
    private String expectedDate;
    private double totalCost;
}
