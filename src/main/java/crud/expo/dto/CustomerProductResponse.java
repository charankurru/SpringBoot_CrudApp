package crud.expo.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerProductResponse {
    private String name;
    private String productName;
    private int price;
    public CustomerProductResponse(String name, String productName) {
        this.name = name;
        this.productName = productName;
    }
}
