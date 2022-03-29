package crud.expo.Repository;

import crud.expo.models.Student;
import crud.expo.models.StudentProfile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentRepoTest{
    @Autowired
    StudentRepo studentRepo;

    Student  saveTestStudentsData(){
        Student student = new Student();
        student.setName("charan");
        StudentProfile studentProfile = new StudentProfile();
        studentProfile.setBranch("IT");
        studentProfile.setCollege("AEC");
        studentProfile.setMobileNumber(8919);
        studentProfile.setRollId("18A91A1232");
        student.setStudentProfile(studentProfile);
        return studentRepo.save(student);
    }

    @Test
    void testFindAllDataSuccess(){
        saveTestStudentsData();
        List<Student> students = (List<Student>) studentRepo.findAll();
        assertEquals(1,students.size());
    }

    @Test
    void testFindAllDataWithNoData(){
        List<Student> students = (List<Student>) studentRepo.findAll();
        assertEquals(0,students.size());
    }


}