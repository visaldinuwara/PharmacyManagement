package Model.DTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class CustomerOrderDetailsDTO {
    private String customerID;
    private String orderDate;
    private double totalAmount;
    private String shippingAdress;
}
