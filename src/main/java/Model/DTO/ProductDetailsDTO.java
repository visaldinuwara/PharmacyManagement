package Model.DTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class ProductDetailsDTO {
    private String name;
    private String brand;
    private String expiry;
    private int quantity;
    private double price;
}
