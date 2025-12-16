package Model.Entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class CustomerOrderDetails {
    private String OrderId;
    private String CustomerId;
    private String OrderDate;
    private double TotalAmount;
    private String ShippingAddress;
}
