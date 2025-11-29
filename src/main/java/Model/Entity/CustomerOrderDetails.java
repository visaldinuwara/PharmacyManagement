package Model.Entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class CustomerOrderDetails {
    private String orderId;
    private String customerId;
    private String orderDate;
    private double totalAmount;
    private String shippingAdress;
}
