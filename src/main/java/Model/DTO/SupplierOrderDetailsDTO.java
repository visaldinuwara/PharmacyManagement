package Model.DTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class SupplierOrderDetailsDTO {
    private String supplierId;
    private String orderDate;
    private String expectedDate;
    private double totalCost;
}
