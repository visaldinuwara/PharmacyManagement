package Model.Entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class PaymentDetails {
    private String PaymentId;
    private String OrderDetailId;
    private String PaymentMethod;
    private double AmountPayed;
    private String CardType;
}
