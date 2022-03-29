package crud.expo.Repository;

import crud.expo.models.Student;
import crud.expo.models.StudentProfile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentProfileRepoTest {

    @Autowired
    private StudentProfileRepo studentProfileRepo;

    StudentProfile saveTestStudentProfilesData(){
        Student student = new Student();
        student.setName("charan");
        StudentProfile studentProfile = new StudentProfile();
        studentProfile.setBranch("IT");
        studentProfile.setCollege("AEC");
        studentProfile.setMobileNumber(8919);
        studentProfile.setRollId("18A91A1232");
        studentProfile.setStudent(student);
        return studentProfileRepo.save(studentProfile);
    }

    @Test
    void testFindAllDataSuccess(){
        saveTestStudentProfilesData();
        List<StudentProfile> studentProfileList = (List<StudentProfile>) studentProfileRepo.findAll();
        assertEquals(1,studentProfileList.size());
    }

    @Test
    void testFindAllDataWithNoData(){
        List<StudentProfile> studentProfileList = (List<StudentProfile>) studentProfileRepo.findAll();
        assertEquals(0,studentProfileList.size());
    }

}