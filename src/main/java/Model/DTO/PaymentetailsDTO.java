package Model.DTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class PaymentetailsDTO {
    private String transactionId;
    private String paymentMethod;
    private double amountPayed;
    private String cardType;
}
