package crud.expo.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cartId;
    @Column(nullable = false)
    private String cartName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    @Fetch(FetchMode.SELECT)
    @JsonManagedReference
    private List<Item> items;


}
