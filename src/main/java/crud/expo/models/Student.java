package crud.expo.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;

    @Column(nullable = false)
    private String name;

    @OneToOne(targetEntity = StudentProfile.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "student")
    @JsonManagedReference
    private StudentProfile studentProfile;
}
