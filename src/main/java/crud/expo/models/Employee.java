package crud.expo.models;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data public class Employee {
    @Id
    private String userName;
    private  String firstName;
    private  String lastName;
    private  String email;
}
