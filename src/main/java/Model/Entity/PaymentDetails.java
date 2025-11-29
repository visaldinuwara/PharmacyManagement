package Model.Entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class PaymentDetails {
    private String id;
    private String transactionId;
    private String paymentMethod;
    private double amountPayed;
    private String cardType;
}
