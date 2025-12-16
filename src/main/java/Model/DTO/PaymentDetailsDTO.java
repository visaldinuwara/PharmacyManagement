package Model.DTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class PaymentDetailsDTO {
    private String orderDetailId;
    private String paymentMethod;
    private double amountPayed;
    private String cardType;
}
