package crud.expo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int profileId;
    @Column(unique = true)
    private String rollId;
    @Column(nullable = false)
    private String branch;
    @Column(nullable = false)
    private String college;
    private int mobileNumber;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    @JsonBackReference
    private Student student;


}
