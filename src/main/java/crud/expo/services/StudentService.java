package crud.expo.services;

import crud.expo.Repository.StudentProfileRepo;
import crud.expo.Repository.StudentRepo;
import crud.expo.models.Student;
import crud.expo.models.StudentProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private StudentProfileRepo studentProfileRepo;

    public void addStudent(Student student) {
        studentRepo.save(student);
    }

    public void addStudentProfile(StudentProfile student) {
        this.studentProfileRepo.save(student);
    }

    public List<Student> getStudent() {
        return (List<Student>) studentRepo.findAll();
    }

    public void deleteStudent(int id) {
        studentRepo.deleteById(id);
    }


}
