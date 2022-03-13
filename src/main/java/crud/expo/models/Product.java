package crud.expo.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Products_table")
public class Product {
    @Id
    private int pid;
    private String productName;
    private int qty;
    private int price;
}

