package crud.expo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Address_table")
public class
EmployeeAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int houseNumber;
    private String street;
    private int pinCode ;
    private String state;


}
