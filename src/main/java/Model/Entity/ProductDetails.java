package Model.Entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class ProductDetails {
    private String id;
    private String name;
    private String brand;
    private String expiry;
    private String date;
    private int quantity;
    private double price;
}

