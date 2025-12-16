package Model.Entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class ProductDetails {
    private String id;
    private String Name;
    private String Brand;
    private String Expiry;
    private int Quantity;
    private double Price;
}

