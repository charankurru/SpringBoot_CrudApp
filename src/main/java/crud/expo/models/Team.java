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
@Table(name="Teams_Table")
public class Team {
    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private  int id;
    private  String teamName;

}
