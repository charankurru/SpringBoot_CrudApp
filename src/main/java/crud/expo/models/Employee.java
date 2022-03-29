package crud.expo.models;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Employee_table")
public class Employee {
    @Id
    @Column(name = "Id")
    @GeneratedValue
    private int id;
    private  String firstName;
    private  String lastName;
    @Column(nullable = false)
    private  String email;

    @OneToMany(targetEntity = EmployeeAddress.class, cascade = CascadeType.ALL)
    @JoinColumn(name="emp_Id",referencedColumnName = "id")
    private List<EmployeeAddress> addresses;

    @OneToMany(targetEntity = Product.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="cp_fk",referencedColumnName = "id")
    private List<Product> products;

//        @ManyToOne(targetEntity = Team.class,cascade = CascadeType.ALL)
//        @JoinColumn
//        private Team team;

}
