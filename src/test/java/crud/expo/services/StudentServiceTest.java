package crud.expo.services;

import crud.expo.Repository.StudentProfileRepo;
import crud.expo.Repository.StudentRepo;
import crud.expo.models.Student;
import crud.expo.models.StudentProfile;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

@DataJpaTest
class StudentServiceTest {

    @Mock
    private StudentRepo studentRepo;
    @Mock
    private StudentProfileRepo studentProfileRepo;
    private StudentService studentService;

    @BeforeEach
    void setup(){
        studentService = new StudentService(studentRepo,studentProfileRepo);
    }

    List<Student> getStudentsData(){
        Student student = new Student();
        student.setName("charan");
        StudentProfile studentProfile = new StudentProfile();
        studentProfile.setBranch("IT");
        studentProfile.setCollege("AEC");
        studentProfile.setMobileNumber(8919);
        studentProfile.setRollId("18A91A1232");
        student.setStudentProfile(studentProfile);
        return Arrays.asList(student);
    }

    @Test
    @Disabled
    void testAddStudent() {
    }

    @Test
    void testGetStudentSuccess(){
        when(studentRepo.findAll()).thenReturn(getStudentsData());
        List<Student> students = studentService.getStudent();
        assertThat(students.size()).isSameAs(1);
        assertThat(students.get(0).getName()).isSameAs("charan");
    }

    @Test
    void testGetStudentReturnsEmptyList(){
        List<Student> students = studentService.getStudent();
        assertThat(students.size()).isSameAs(0);
        assertThat(students).isNotNull();
    }

    /**
     * Test case Scenarios for adding Student data
     * 1) Add data with all correct inputs
     * 2) Add data with missing inputs
     * 3) Add data with incorrect inputs i.e. datatype mismatch
     * */
}