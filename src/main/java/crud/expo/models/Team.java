package crud.expo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name="Teams_Table")
public class Team {
    @Id
    //@GeneratedValue( strategy= GenerationType.AUTO )
    @GeneratedValue
    private  int id;
    private  String teamName;

}
